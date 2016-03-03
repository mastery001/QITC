// The variable jcrop_api will hold a reference to the
// Jcrop API once Jcrop is instantiated.
var jcrop_api, isTvVrs, noimg;

//用来处理图片全比例替换
var checkObj;
function getCheckObj(obj){
	checkObj = obj;
}

$(document).ready(function() {
	isTvVrsVal = $("input[name='isTvVrs']").val();
	isTvVrs = $("input[name='isTvVrs']").val() != 0 ? true : false;
	noimg = "http://i2.letvimg.com/other/201304/10/noimg.jpg";
	if (isTvVrsVal == 1) {
		noimg = "http://i2.img.cp21.ott.cibntv.net/other/201304/10/noimg.jpg";
	} else if(isTvVrsVal == 2)  {
		noimg = "http://i2.img.letv-epg.wasu.tv/other/201304/10/noimg.jpg";
	}
    // 初始化 素材（资源）的事件
    $(document).on('click', '#source_img img', function(e) {
        var $box = navTab.getCurrentPanel();
        var $this = $(this), objImg = $("#imgbox", $box), scaling = 1,
        // 缩放比例
        original_width = $this.attr('original-width'),
        original_height = $this.attr('original-height'),
        original_src = $this.attr('original-src'),
        most = $("#edit_picture", $box).width() - 50; // 设置最大宽度
        // -
        // 滚动条
        if (jcrop_api) {
            jcrop_api.destroy();
        }

        // 清空坐标值
        showCoords({
            x: '',
            y: '',
            x2: '',
            y2: '',
            w: '',
            h: ''
        });
        $('#imgtype', $box).val('');

        // 将原图尺寸传到编辑区域
        $('#original_width', $box).val(original_width);
        $('#original_height', $box).val(original_height);
        $('#original_src', $box).val(original_src);

        // 将原图加载到编辑区域
        objImg.attr('src', original_src);

        // 开始截图之前先处理（缩放）原图到编辑区域
        var boxWidth;
        if (original_width > most) {
            // 计算缩小比例
            scaling = 1 - (original_width - most) / original_width;
            boxWidth = original_width * scaling; // 画布宽度
            objImg.width(boxWidth);
            objImg.height(original_height * scaling); // img元素设置高度时需进行等比例缩小
            // objImg.height = objImg.height;
            // //img元素没有设置高度时将自动等比例缩小
        } else {
            boxWidth = original_width;
            objImg.width(original_width).height(original_height);
        }

        // 设定画布宽度
        $('#boxWidth', $box).val(boxWidth);

        // 设置缩放比例
        $('#scaling', $box).val(scaling);

        $("#imgbox", $box).Jcrop({onChange: showCoords, onSelect: showCoords}, function() {
            jcrop_api = this;
        });

        // 编辑区域换图
        if (jcrop_api) {
            var num = scaling * 300;
			jcrop_api.setOptions({
				aspectRatio: 1 / 1,
				minSize: [num, num],
				bgOpacity: .6,
				boxWidth: original_width * scaling,
				// 重新设定画布宽度（按原图尺寸缩放）
				boxHeight: original_height * scaling // 重新设定画布宽度（按原图尺寸缩放）
			});
            jcrop_api.setImage(original_src);

            $('#boxWidth', $box).val(original_width * scaling);
        }
    });

    // 删除素材图片结构
    $(document).on('click', '#source_img a', function(e) {
        $(this).parents('dl').remove();
        $('#imgbox', navTab.getCurrentPanel()).removeAttr('src').removeAttr('style');
        if (jcrop_api) {
            jcrop_api.destroy();
        }
    });
    
    // 删除背板图片结构
    $(document).on('click', '#dynamicgraph_img a', function(e) {
    	$(this).parents('dl').remove();
    	$('#imgbox', navTab.getCurrentPanel()).removeAttr('src').removeAttr('style');
    	if (jcrop_api) {
    		jcrop_api.destroy();
    	}
    });

    // 成品图换图
    $('.finished').css('cursor', 'pointer');
    $(document).on('click', '.finished', function(e) {
        var $obj = $(e.target),
        $box = navTab.getCurrentPanel(); // 目标对象
        var change = $('#finished' + $obj.attr('scale'), $box);
        $(".floimg", $box).addClass('hide');
        if (change.hasClass("hide")) {
            change.removeClass('hide');
        }
    });

    
    
    // 更换成品图
    $('.floimg img').css('cursor', 'pointer');
    $(document).on('click', '.floimg img', function(e) {
        var $this = $(this);
        var scaleArray = new Array();
        if ($(checkObj).attr('checked')) {
        	$('.picScaleTr').each(function(){
        		 var scale = $(this).attr('id').replace(/[^\d]/ig, '');
        		 scaleArray.push(scale);
        	});
        } else {
        	var scale = $this.parent().parent().attr('id').replace(/[^\d]/ig, '');
        	scaleArray.push(scale);
        }
        var original_src = $this.attr('original-src');
        var $box = navTab.getCurrentPanel();
        var autoCdnSize = $('#autoCdnSize', $box).val();
        var $callback = function(json) {
            if (json.statusCode == DWZ.statusCode.ok) {
                var data = json.data;
                // 第一张图(最小尺寸)
                for (var picScale in data) {
                	var pic = data[picScale];
                	for (var src in pic) {
                		
                		$('#ar' + picScale, $box).find('img').attr('src', isTvVrs == true ? picToTvUrl(pic[src]) : pic[src]);
                		// 隐藏域同步
                		var hiddenName = "picThumbs['ar" + picScale + "']";
                		
                		$('input[name="' + hiddenName + '"]', $box).val(JSON.stringify(pic));
                		
                		// 只需要获取第一个图片数据，所以跳出循环
                		break;
                	}
                }
                // 剩下的各种尺寸图的链接
                $.each(data, function(scale, pic) {
                	for (var src in pic) {
                		$('#ar' + scale, $box).find('td').last().find('a[scale="' + src + '"]').attr({
                			href: isTvVrs == true ? picToTvUrl(pic[src]) : pic[src],
                					target: '_blank'
                		});
                		checkBigPic(scale, $box);
                	}
                });

                // 关闭浮层
                $(checkObj).attr('checked', false);
                $(".floimg", $box).addClass('hide');
            }
        };
        $.ajax({
            type: 'POST',
            url: '../upload/uploadScreenshot.action',
            data: 'scale=' + scaleArray + '&original_src=' + tvUrlToPic(original_src) + '&autoCdnSize=' + autoCdnSize,
            dataType: "json",
            cache: false,
            success: $callback,
            error: DWZ.ajaxError
        });
    });
    
    $(document).on('click', '.floimg', function(e) {
        $(this).addClass('hide');
    });

    $(document.body).click(function() {
        var $box = navTab.getCurrentPanel();
        if ($(".floimg", $box).is(":visible")) {
            $(".floimg", $box).addClass('hide');
        }
    });

    // 单独保存视频信息
    $(document).on('click', '.save_album_video', function(e) {
    	 if(!confirm('确实要批量保存本页的视频信息?')){
    		 return false;
    	 }
    	var $box = navTab.getCurrentPanel();
    	var pid = $('#pid',$box).val();
        var videos = [];
        $('.videoManage',$box).find('tr').each(function(i) {
            var $that = $(this), video = {}, playPlatforms = $that.find('input[name="playPlatform"]:checked'), playPlatform = [],
            			downloadPlatforms = $that.find('input[name="downloadPlatform"]:checked'), downloadPlatform = [];
            playPlatforms.each(function() {
            	playPlatform.push($(this).val());
            });
            downloadPlatforms.each(function() {
            	downloadPlatform.push($(this).val());
            });
            video.id = $that.attr('video-id');
            video.porder = $that.find("input").eq(0).val();
            video.episode = $that.find("input").eq(1).val();
            video.nameCn = $that.find("textarea").eq(0).val();
            video.subTitle = $that.find("textarea").eq(1).val();
            video.tag = $that.find("textarea").eq(2).val();
            video.description = $that.find('textarea').eq(3).val();
            video.pid = pid;
            video.playPlatform = (playPlatform.length > 0) ? playPlatform.join(',') : '';
            video.downloadPlatform = (downloadPlatform.length > 0) ? downloadPlatform.join(',') : '';
            if (video.nameCn == undefined || video.nameCn == '') {
                return;
            }
            videos.push(video);
        });
        $.ajax({
            type: 'POST',
            url: '../video/batchEditSubmitAndOrder.action',
            data: JSON.stringify(videos),
            dataType: "json",
            contentType: "application/json",
            cache: false,
            success: navTabAjaxDone,
            error: DWZ.ajaxError
        });
    });
});

// 设置比例
$(document).on('click', '#ar_lock16_9', function(e) {
	var $box = navTab.getCurrentPanel();
	if($('#prefixId', $box).val().length == 0) { 
   	 	alertMsg.error('请先动态截图！');
        return false;
    }
    var scaling = $("#scaling", $box).val(),
    w = scaling * 400,
    h = scaling * 225,
    original_width = $('#original_width', $box).val(),
    original_height = $('#original_height', $box).val();
    if (original_width >= 960 && original_height >= 540) {// 根据原图的大小去自动选择框框大小
    	w = scaling * 960;
        h = scaling * 540;
    }
    if (original_width >= 1080 && original_height >= 608) {// 根据原图的大小去自动选择框框大小
    	w = scaling * 1080;
        h = scaling * 608;
    }
    if (original_width >= 1440 && original_height >= 810) {// 根据原图的大小去自动选择框框大小
    	w = scaling * 1440;
        h = scaling * 810;
    }
    jcrop_api.setOptions({
        aspectRatio: 16 / 9,
        minSize: [w, h]
    });
    jcrop_api.animateTo([0, 0, w, h]);
    jcrop_api.focus();
    $('#imgtype', $box).val('ar169');
});

$(document).on('click', '#ar_lock16_10', function(e) {
	var $box = navTab.getCurrentPanel();
	if($('#prefixId', $box).val().length == 0) { 
   	 	alertMsg.error('请先动态截图！');
        return false;
    }
    var scaling = $("#scaling", $box).val(),
    w = scaling * 400,
    h = scaling * 250;
    original_width = $('#original_width', $box).val(),
    original_height = $('#original_height', $box).val();
    if (original_width >= 640 && original_height >= 400) {// 根据原图的大小去自动选择框框大小
    	w = scaling * 640;
        h = scaling * 400;
    }
    jcrop_api.setOptions({
        aspectRatio: 16 / 10,
        minSize: [w, h]
    });
    jcrop_api.animateTo([0, 0, w, h]);
    jcrop_api.focus();
    $('#imgtype', $box).val('ar1610');
});

$(document).on('click', '#ar_lock4_3', function(e) {
	var $box = navTab.getCurrentPanel();
	if($('#prefixId', $box).val().length == 0) { 
   	 	alertMsg.error('请先动态截图！');
        return false;
    }
    var scaling = $("#scaling", $box).val(),
    w = scaling * 400,
    h = scaling * 300;
    jcrop_api.setOptions({
        aspectRatio: 4 / 3,
        minSize: [w, h]
    });
    jcrop_api.animateTo([0, 0, w, h]);
    jcrop_api.focus();
    $('#imgtype', $box).val('ar43');
});

$(document).on('click', '#ar_lock3_4', function(e) {
    var $box = navTab.getCurrentPanel();
    var scaling = $("#scaling", $box).val(),
    w = scaling * 300,
    h = scaling * 400;
    jcrop_api.setOptions({
        aspectRatio: 3 / 4,
        minSize: [w, h]
    });
    jcrop_api.animateTo([0, 0, w, h]);
    jcrop_api.focus();
    $('#imgtype', $box).val('ar34');
});

$(document).on('click', '#ar_lock970_300', function(e) {
    var $box = navTab.getCurrentPanel();
    var scaling = $("#scaling", $box).val(),
    w = scaling * 970,
    h = scaling * 300;
    jcrop_api.setOptions({
        aspectRatio: 97 / 30,
        minSize: [w, h]
    });
    jcrop_api.animateTo([0, 0, w, h]);
    jcrop_api.focus();
    $('#imgtype', $box).val('ar970300');
});

/*$(document).on('click', '#ar_lock16_6', function(e) {
    var $box = navTab.getCurrentPanel();
    if($('#prefixId', $box).val().length == 0) { 
   	 	alertMsg.error('请先动态截图！');
        return false;
    }
    var scaling = $("#scaling", $box).val(),
    w = scaling * 640,
    h = scaling * 240;
    original_width = $('#original_width', $box).val(),
    original_height = $('#original_height', $box).val();
    if (original_width >= 1280 && original_height >= 480) {// 根据原图的大小去自动选择框框大小
    	w = scaling * 1280;
        h = scaling * 480;
    }
    jcrop_api.setOptions({
        aspectRatio: 16 / 6,
        minSize: [w, h]
    });
    jcrop_api.animateTo([0, 0, w, h]);
    jcrop_api.focus();
    $('#imgtype', $box).val('ar166');
});

$(document).on('click', '#ar_lock2_3', function(e) {
    var $box = navTab.getCurrentPanel();
    if($('#prefixId', $box).val().length == 0) { 
   	 	alertMsg.error('请先动态截图！');
        return false;
    }
    var scaling = $("#scaling", $box).val(),
    w = scaling * 320,
    h = scaling * 480;
    original_width = $('#original_width', $box).val(),
    original_height = $('#original_height', $box).val();
    if (original_width >= 640 && original_height >= 960) {// 根据原图的大小去自动选择框框大小
    	w = scaling * 640;
        h = scaling * 960;
    }
    jcrop_api.setOptions({
        aspectRatio: 2 / 3,
        minSize: [w, h]
    });
    jcrop_api.animateTo([0, 0, w, h]);
    jcrop_api.focus();
    $('#imgtype', $box).val('ar23');
});

$(document).on('click', '#ar_lock16_11', function(e) {
    var $box = navTab.getCurrentPanel();
    if($('#prefixId', $box).val().length == 0) { 
   	 	alertMsg.error('请先动态截图！');
        return false;
    }
    var scaling = $("#scaling", $box).val(),
    w = scaling * 640,
    h = scaling * 440;
    original_width = $('#original_width', $box).val(),
    original_height = $('#original_height', $box).val();
    if (original_width >= 1280 && original_height >= 880) {// 根据原图的大小去自动选择框框大小
    	w = scaling * 1280;
        h = scaling * 880;
    }
    jcrop_api.setOptions({
        aspectRatio: 16 / 11,
        minSize: [w, h]
    });
    jcrop_api.animateTo([0, 0, w, h]);
    jcrop_api.focus();
    $('#imgtype', $box).val('ar1611');
});*/

$(document).on('click', '#ar_lock266_200', function(e) {
    var $box = navTab.getCurrentPanel();
    if($('#prefixId', $box).val().length == 0) { 
   	 	alertMsg.error('请先动态截图！');
        return false;
    }
    var scaling = $("#scaling", $box).val(),
    w = scaling * 260,
    h = scaling * 200;
    jcrop_api.setOptions({
        aspectRatio: 26 / 20,
        minSize: [w, h]
    });
    jcrop_api.animateTo([0, 0, w, h]);
    jcrop_api.focus();
    $('#imgtype', $box).val('ar266200');
});

//设置比例
$(document).on('click', '#ar_lock1_1', function(e) {
	var $box = navTab.getCurrentPanel();
	if($('#prefixId', $box).val().length == 0) { 
   	 	alertMsg.error('请先动态截图！');
        return false;
    }
    var scaling = $("#scaling", $box).val(),
    w = scaling * 200,
    h = scaling * 200,
    original_width = $('#original_width', $box).val(),
    original_height = $('#original_height', $box).val();
    if (original_width >= 300 && original_height >= 300) {// 根据原图的大小去自动选择框框大小
    	w = scaling * 300;
        h = scaling * 300;
    }
    if (original_width >= 1080 && original_height >= 1080) {// 根据原图的大小去自动选择框框大小
    	w = scaling * 1080;
        h = scaling * 1080;
    }
    jcrop_api.setOptions({
        aspectRatio: 1 / 1,
        minSize: [w, h]
    });
    jcrop_api.animateTo([0, 0, w, h]);
    jcrop_api.focus();
    $('#imgtype', $box).val('ar11');
});
// 设置各坐标点的值
function showCoords(c) {
    var img = $("#imgbox");
    var $box = navTab.getCurrentPanel();
    $('#x1', $box).val(c.x);
    $('#y1', $box).val(c.y);
    $('#x2', $box).val(c.x2);
    $('#y2', $box).val(c.y2);
    $('#w', $box).val(c.w);
    $('#h', $box).val(c.h);
}

//保存
$(document).on('click', '#crop_image', function(e) {
    if (!jcrop_api) {
        alertMsg.error('请先选择一张素材图片进行裁切之后再保存！');
        return false;
    }
    var $box = navTab.getCurrentPanel();
    var current = jcrop_api.tellSelect(),
    scaling = $("#scaling", $box).val(),
    original_src = $('#original_src', $box).val(),
    propertyFlag = $('#propertyFlag', $box).val(),
    imgtype = $('#imgtype', $box).val();
    if (!imgtype) {
        alertMsg.error('请选择一种图片裁切比例！');
        return false;
    }
    if (current.x < 0 || current.y < 0) {
        alertMsg.error('素材图尺寸太小，请重新上传符合质量标准的素材图！');
        return false;
    }
    var $callback = function(json) {
        if (json.statusCode == DWZ.statusCode.ok) {
            var data = json.data.picUrl,
            i = 0;
            // 剩下的各种尺寸图的链接
            $('#' + imgtype, $box).find('input').attr('value', JSON.stringify(json.data.original));
            $('#' + imgtype, $box).find('td').last().find('a').each(function() {
            	var $this = $(this);
            	var rato = $(this).text();
            	if (!json.data.original[rato]) {
            		$this.attr({
                        target: '_self',
                        style:"color:red"
                    });
            	}
    			checkBigPic(rato, $box);
            });
            $.each(data, function(title, src) {
                if (i == 0) {
                    // 第一张图(最小尺寸)
                    $('#' + imgtype, $box).find('img').attr('src', src);
                }
                i += 1;
                $('#' + imgtype, $box).find('td').last().find('a').eq(title).attr({
                    href: src,
                    target: '_blank',
                    style:"color:black"
                });
            });
        }
    };
    $.ajax({
        type: 'POST',
        url: '../upload/cutPic.action',
        data: 'x1=' + parseInt(current.x) + '&y1=' + parseInt(current.y) + '&width=' + parseInt(current.w) + '&height=' + parseInt(current.h) + '&imgtype=' + imgtype + '&original_src=' + original_src + '&scaling=' + scaling + '&flag=' + propertyFlag,
        dataType: "json",
        cache: false,
        success: $callback,
        error: DWZ.ajaxError
    });
});

// 动态截图
$(document).on('click', '#auto_crop_image', function(e) {
    if (!jcrop_api) {
        alertMsg.error('请先选择一张素材图片！');
        return false;
    }
    var $box = navTab.getCurrentPanel();
    var original_src = $('#original_src', $box).val(),
    propertyFlag = $('#propertyFlag', $box).val(),
    original_width = $('#original_width', $box).val(),
    original_height = $('#original_height', $box).val();
    var $callback = function(json) {
        if (json.statusCode == DWZ.statusCode.ok) {
            var prefixCdn = json.data.prefixCdn;
            if (prefixCdn == '') {
            	alertMsg.error('调用cdn接口返回值为空！');
            	return false;
            }
            $('#autoCdnOri', $box).val(original_src);
            $('#prefixId', $box).val(prefixCdn);
            $('#autoCdnSize', $box).val(original_width + '*' + original_height);
            $('.tpcp', $box).find('tr').each(function(){
            	var $tr = $(this),
            	i = 0,
            	$link = $tr.find('a');
            	$link.each(function(){
            		var $eachLink = $(this),
            		size = $eachLink.text(),
                	sizeArray = size.split("*");
            		if (parseInt(sizeArray[0]) >= parseInt(sizeArray[1]) && parseInt(sizeArray[0]) != 970) {
            			if (parseInt(original_width) < parseInt(sizeArray[0]) || parseInt(original_height) < parseInt(sizeArray[1])) {
                			$eachLink.attr({style:"color:red", 'href': '#', target: '_self'});
                		} else {
                        	var src = prefixCdn + '/thumb/2_' + sizeArray[0] + '_' + sizeArray[1] + '.jpg';
                			$eachLink.attr({style:"color:black",'href': isTvVrs == true ? picToTvUrl(src) : src, target: '_blank'});
                			if (i == 0) {
                            	$tr.find('img').attr('src', isTvVrs == true ? picToTvUrl(src) : src);
                    		}
                			checkBigPic(size, $tr);
                		}
                    	i = i + 1;
                    	$tr.find('input').each(function(){
                    		var $input = $(this);
                    		if ($input.attr('name')!="isBigPic") {                    			
                    			$input.attr('value', '');
                    		}
                    	});
            		}
            	});
            });
        } else {
        	alertMsg.error(json.message);
        }
    };
    $.ajax({
        type: 'POST',
        url: '../upload/autoCutPic.action',
        data: '&original_src=' + original_src + "&original_width=" + original_width + '&original_height=' + original_height +'&flag=' + propertyFlag,
        dataType: "json",
        cache: false,
        success: $callback,
        error: DWZ.ajaxError
    });
});

//初始化缺失红色尺寸  专辑
var redAlert4Album = function() {
    var $box = navTab.getCurrentPanel(),
    autoCdnSize = $('#autoCdnSize', $box).val(),
    autoCdnSizeArray = autoCdnSize.split("*"),
    autoCdnSize0 = parseInt(autoCdnSizeArray[0]),
    autoCdnSize1 = parseInt(autoCdnSizeArray[1]);
	$('.tpcp', $box).find('tr').each(function(){
		var $tr = $(this),
		arVal = $tr.find('input').val().trim(),
		$link = $tr.find('a');
		$link.each(function(){
			var $eachLink = $(this),
			size = $eachLink.text(),
	    	sizeArray = size.split("*");
			sizeArray0 = parseInt(sizeArray[0]);
			sizeArray1 = parseInt(sizeArray[1]);
    		if (sizeArray0 >= sizeArray1 && sizeArray0 != 970) {
    			if ((autoCdnSize0 < sizeArray0 || autoCdnSize1 < sizeArray1 || autoCdnSize.length == 0) && arVal.length == 0 || (arVal.length > 0 && arVal.indexOf(size) <= 0)) {
        			$eachLink.attr({style:"color:red", 'href': '#', target: '_self'});
        		} else {
        			$eachLink.attr({style:"color:black", target: '_blank'});
        		}
    		}
		});
	});
};

// 初始化缺失红色尺寸 视频
var redAlert4Video = function() {
    var $box = navTab.getCurrentPanel(),
    autoCdnSize = $('#autoCdnSize', $box).val(),
    autoCdnSizeArray = autoCdnSize.split("*"),
    autoCdnSize0 = parseInt(autoCdnSizeArray[0]),
    autoCdnSize1 = parseInt(autoCdnSizeArray[1]);
	$('.tpcp', $box).find('tr').each(function(){
		var $tr = $(this),
		arVal = $tr.find('input').val().trim(),
		$link = $tr.find('a');
		$link.each(function(){
			var $eachLink = $(this),
			size = $eachLink.text(),
	    	sizeArray = size.split("*");
			sizeArray0 = parseInt(sizeArray[0]);
			sizeArray1 = parseInt(sizeArray[1]);
    		if (sizeArray0 >= 960) {
    			// 分为根据前缀（包括转码前缀和动态截图前缀）拼 、 和编辑手工裁图2种情况
    			if (((autoCdnSize0 < sizeArray0 || autoCdnSize1 < sizeArray1 || autoCdnSize.length == 0) && arVal.indexOf('vrs') < 0) || ( arVal.indexOf('vrs') > 0 && arVal.indexOf(size) <= 0)) {
        			$eachLink.attr({style:"color:red", 'href': '#', target: '_self'});
        		} else {
        			$eachLink.attr({style:"color:black", target: '_blank'});
        		}
    		}
    		
    		// 如果没有960*540图,不能选择是否大图
    		if (sizeArray0 == 960) {
    			if (((autoCdnSize0 < sizeArray0 || autoCdnSize1 < sizeArray1 || autoCdnSize.length == 0) && arVal.indexOf('vrs') < 0) || ( arVal.indexOf('vrs') > 0 && arVal.indexOf(size) <= 0)) {
    				$tr.find("[name='isBigPic']").attr("disabled","true");
        		}
    		}
		});
	});
};

// 新增，编辑 看点
$(document).on('click', '.add_description', function() {
    var $this = $(this), timing = $this.prevAll('.date').val(), $url, $callback, $box = navTab.getCurrentPanel(), watching_focus = $this.prev(':input').val(), descript_id = $this.next(':input').val();
    var vid = $("#vid", $box).val();
    //最新加入
    var pic = $("#descript_pic", $box).val();
    if (isTvVrs) {
    	pic = tvUrlToPic(pic);
    }
    // || descript_pic == ''
    if (timing == '' || watching_focus == '') {
        alertMsg.warn('请填写时间点和看点描述和看点图片地址！');
        return false;
    }
    if (descript_id > 0) {
        $url = '../video/editPoint.action';
        $callback = function(json) {
            DWZ.ajaxDone(json);
            if (json.statusCode == DWZ.statusCode.ok) {
                cancelWatchingFocus();

                $('#watching_focus', $box).find('tr').each(function() {
                    var $this = $(this);
                    if (descript_id == $this.attr('descript-id')) {
                        $this.find('td').eq(0).html(json.data.time);
                        $this.find('td').eq(1).html(isTvVrs == true ? picToTvUrl(json.data.pic) : json.data.pic);
                        $this.find('td').eq(2).html(json.data.desc);
                    }
                });
                $('#source_img1 img:first', $box).attr('src', noimg);
            }
        };
    } else {
        $url = '../video/addPoint.action';

        $callback = function(json) {
            DWZ.ajaxDone(json);
            if (json.statusCode == DWZ.statusCode.ok) {
                var _html = [];
                _html.push('<tr descript-id="' + json.data.id + '">');
                _html.push('<td>' + json.data.time + '</td>');
                _html.push('<td>' + (isTvVrs == true ? picToTvUrl(json.data.pic) : json.data.pic) + '</td>');
                _html.push('<td>' + json.data.desc + '</td>');
                _html.push('<td><a title="删除" href="javascript:;" class="btnDel">删除</a><a title="编辑" href="javascript:;" class="btnEdit">编辑</a></td></tr>');

                $('#watching_focus', $box).append(_html.join(''));
                $('#edit_watching_focus', $box).find(':input').eq(0).val('00:00:00');
                $('#edit_watching_focus', $box).find(':input').eq(1).val('');
                $('#edit_watching_focus', $box).find(':input').eq(2).val('');
                $('#edit_watching_focus', $box).find(':input').eq(3).val(0);
                $('#source_img1 img:first', $box).attr('src', noimg);
            }
        };
    }
    $.ajax({
        type: 'POST',
        url: $url,
        data: 'id=' + descript_id + '&time=' + timing + '&desc=' + watching_focus + '&vid=' + vid + '&pic=' + pic,
        dataType: "json",
        cache: false,
        success: $callback,
        error: DWZ.ajaxError
    });
});

// 编辑看点
$(document).on('click', '#watching_focus .btnEdit', function(e) {
    var $this = $(e.target).parents('tr'),
    descript_id = $this.attr('descript-id'),
    $box = navTab.getCurrentPanel(),
    timing = $this.find('td').eq(0).html(),
    pic = $this.find('td').eq(1).html(),
    watching_focus = $this.find('td').eq(2).html();
    var $edit_watching_focus = $('#edit_watching_focus', $box);
    if (!$.isNumeric(descript_id)) {
        return false;
    }

    $edit_watching_focus.find(':input').eq(0).val(timing);
    $edit_watching_focus.find(':input').eq(1).val(pic);
    $edit_watching_focus.find(':input').eq(2).val(watching_focus);
    $edit_watching_focus.find('.add_description').html('<span>保存看点</span>');
    $edit_watching_focus.find('input[name="descript_id"]').val(descript_id);
    $('#source_img1 img:first', $box).attr('src', pic);
    if ($("#cancel_watching_focus", $box).length == 0) {
        $('<a id="cancel_watching_focus" class="button" href="javascript:;"><span>取消</span></a>').appendTo($edit_watching_focus);
    }
    $edit_watching_focus.find(':input').eq(2).focus();
    $edit_watching_focus.find(':input').eq(1).focus();
});

// 取消编辑看点
$(document).on('click', '#cancel_watching_focus', cancelWatchingFocus);

function cancelWatchingFocus() {
    var $box = navTab.getCurrentPanel(),
    $edit_watching_focus = $('#edit_watching_focus', $box);
    $edit_watching_focus.find(':input').eq(0).val('00:00:00');
    $edit_watching_focus.find(':input').eq(1).val('');
    $edit_watching_focus.find(':input').eq(2).val('');
    $edit_watching_focus.find('.add_description').html('<span>添加看点</span>');
    $edit_watching_focus.find('input[name="descript_id"]').val(0);
    $("#cancel_watching_focus", $box).remove();
    $('#source_img1 img:first', $box).attr('src', noimg);
}

// 删除看点
$(document).on('click', '#watching_focus .btnDel', function(e) {
    if (!window.confirm('确认执行此操作吗？')) {
        return false;
    }
    var $this = $(e.target),
    descript_id = $this.parents('tr').attr('descript-id');
    var vid = $("#vid", navTab.getCurrentPanel()).val();
    if (!$.isNumeric(descript_id)) {
        return false;
    }
    var $callback = function(json) {
        DWZ.ajaxDone(json);
        if (json.statusCode == DWZ.statusCode.ok) {
            $this.parents('tr').remove();
            $('#source_img1 img:first', navTab.getCurrentPanel()).attr('src', 'http://i2.letvimg.com/other/201304/10/noimg.jpg');
        }
    };
    $.ajax({
        type: 'POST',
        url: '../video/delPoint.action',
        data: 'id=' + descript_id + '&vid=' + vid,
        dataType: "json",
        cache: false,
        success: $callback,
        error: DWZ.ajaxError
    });
});

// 排序功能. 所有被排序波及到的行都要变色
function moveUp(obj) {
    var $currentTR = $(obj).parent().parent().parent(), $prevTR = $currentTR.prev();
    if (0 == $currentTR.index()) {
        alertMsg.info('已经到达第一行了');
        return false;
    }
    $currentTR.insertBefore($prevTR);
    $currentTR.css('background', '#f4e8ee').addClass('changed');
    $prevTR.css('background', '#f4e8ee').addClass('changed');
}

function moveDown(obj) {
    var $currentTR = $(obj).parent().parent().parent(), $nextTR = $currentTR.next(), trCount = $currentTR.siblings().length;
    if (trCount == $currentTR.index()) {
        alertMsg.info('已经到达最后一行');
        return false;
    }
    $currentTR.insertAfter($nextTR);
    $currentTR.css('background', '#f4e8ee').addClass('changed');
    $nextTR.css('background', '#f4e8ee').addClass('changed');
}

// 置顶。 将当前行置于第一行的前面
function moveTop(obj) {
    var $currentTR = $(obj).parent().parent().parent(),
    $firstTR = $currentTR.siblings().eq(0);
    if (0 == $currentTR.index()) {
        return false;
    }

    // 取当前行到第一行的所有行，用于着色
    $currentTR.prevUntil().css('background', '#f4e8ee').addClass('changed');
    $currentTR.css('background', '#f4e8ee').addClass('changed');
    $currentTR.insertBefore($firstTR);

}

// 置底。 将当前行置于最后一行的下面
function moveBottom(obj) {
    var $currentTR = $(obj).parent().parent().parent(), $lastTR = $currentTR.siblings().last();
    if ($currentTR.siblings().length == $currentTR.index()) {
        return false;
    }

    $currentTR.nextUntil().css('background', '#f4e8ee').addClass('changed');
    $currentTR.css('background', '#f4e8ee').addClass('changed');
    $currentTR.insertAfter($lastTR);
}

// 验证视频信息是否被修改过
function is_changed() {
    var iCount = $('.changed', navTab.getCurrentPanel()).length;
    if (iCount > 0) {
        alertMsg.warn('视频列表中存在已修改的记录，请保存之后再进行操作');
        return false;
    }

    // 验证是否已经添加过主演
    if (arguments[0] == 'starring' && $('.directorBox[flag="starring"]', navTab.getCurrentPanel()).length == 0) {
        alertMsg.warn('主演不能留空！');
        return false;
    }
    return true;
}

function searchCountry() {
    var $box = navTab.getCurrentPanel();
    var countrys = $("#countrys", $box).val();
    if (countrys == '') {
        alertMsg.error("国家不能为空");
        return;
    }
    var $callback = function(json) {
        DWZ.ajaxDone(json);
        if (json.statusCode == DWZ.statusCode.ok) {
            var data = json.data;
            for (var p in data) {
                var hasContain = false;
                if ($("input[name='controlAreas']", $box).length < 1) {
                    $("#countrysDiv", $box).append('<div><a href="javascript:;" onclick="remove_watching_focus(this)"><div class="dipc">' + data[p] + '<span></span><input type="hidden" name="controlAreas" value="' + p + '"/></div></a></div>');
                } else {
                    $("input[name='controlAreas']", $box).each(function() {
                        if (this.value == p) {
                            hasContain = true;
                        }
                    });
                    if (!hasContain) {
                        $("#countrysDiv", $box).append('<div><a href="javascript:;" onclick="remove_watching_focus(this)"><div class="dipc">' + data[p] + '<span></span><input type="hidden" name="controlAreas" value="' + p + '"/></div></a></div>');
                    }
                }
            }
            $("#countrys", $box).val('');
        }
    };
    $.ajax({
        type: 'POST',
        url: '../search/countrylist.action',
        data: 'areas=' + countrys,
        dataType: "json",
        cache: false,
        success: $callback,
        error: DWZ.ajaxError
    });
}

function remove_watching_focus(obj) {
    alertMsg.confirm("确认删除？", {
		okCall: function(){
			$(obj).parent().remove();
		}
	});
}

/**
 * 视频指修改保存
 */
$(document).on('click', '#btnSaveVideo', function() {
	 if(!confirm('确实要批量修改视频吗?请验证勾选的平台信息')){
		  return false;
	  }
    var $box = navTab.getCurrentPanel();
    var videoList = [], index = 1, video = {};

    $("#table1 tbody tr", $box).each(function() {
        var id = $(this).find("td").eq(0).find("input").val(),
        nameCn = $(this).find("td").eq(1).find("input").val(),
        desc = $(this).find("td").eq(3).find("textarea").val(),
        tag = $(this).find("td").eq(4).find("input").val(),
        cbox_play = $("#playPlatformDiv" + index, $box).find('input[name="playPlatform"]:checked'),
        play = "",
        download = "",
        cbox_download = $("#downloadPlatformDiv" + index, $box).find('input[name="downloadPlatform"]:checked');

        cbox_play.each(function() {
            play += $(this).val() + ',';
        });

        if (play.length > 0) {
            play = play.substring(0, play.length - 1);
        }

        cbox_download.each(function() {
            download += $(this).val() + ',';
        });

        if (download.length > 0) {
            download = download.substring(0, download.length - 1);
        }
        var subTitle = $(this).find("td").eq(2).find('input[name="subTitle"]').val();
        var btimeStr = $(this).find("td").eq(7).find('input[name="btimeStr"]').val();
        var etimeStr = $(this).find("td").eq(7).find('input[name="etimeStr"]').val();

        video = {
            id: id,
            nameCn: nameCn,
            description: desc,
            tag: tag,
            playPlatform: play,
            downloadPlatform: download,
            subTitle: subTitle,
            btimeStr: btimeStr,
            etimeStr: etimeStr
        };

        videoList[videoList.length] = video;
        index++;
    });
    $.ajax({
        type: 'POST',
        url: "../video/batchEditSubmit.action",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(videoList),
        success: function(dwz) {
            if (dwz.statusCode != 200) {
                alertMsg.error("更新失败");
            } else {
                // var cid = $("#cidbath",$box).val();
                alertMsg.info("更新成功");
                // navTab.reload(null, null, "videoList"+cid);
                navTab.closeCurrentTab();
            }
        }
    });
});

$(document).on('click', '.disableType', function(){
	var $radio = $(this), $input = $radio.parents('tr').next().find('input[type="text"]');
	if(($radio.val() == '470000' && this.checked) || ($radio.val() == '470001' && this.checked)){
		$input.attr("disabled", true);
		$input.nextAll('div').empty();
	}else{
		$input.attr("disabled", false);
	}
});


//查找并添加国家
$('.searchCountry').each(function(idx){
	var $this = $(this);
	$(this).on('click', function(){
		var hiddenName = 'controlAreas';
		if(idx > 0){
			hiddenName += idx;
		}
		var $elm = $this.prev();
		var $countrysDiv = $this.next();
	    var countrys = $elm.val();
	    if (!countrys) {
	        alertMsg.error("国家不能为空");
	        return false;
	    }
	    var $callback = function(json) {
	        DWZ.ajaxDone(json);
	        if (json.statusCode == DWZ.statusCode.ok) {
	            var data = json.data;
	            for (var p in data) {
	                var hasContain = false;
	                if (!$countrysDiv.length) {
	                    $countrysDiv.append('<div><a href="javascript:;" onclick="remove_watching_focus(this)"><div class="dipc">' + data[p] + '<span></span><input type="hidden" name="'+hiddenName+'" value="' + p + '"/></div></a></div>');
	                } else {
	                    $("input[type='hidden']", $this).each(function() {
	                        if (this.value == p) {
	                            hasContain = true;
	                        }
	                    });
	                    if (!hasContain) {
	                    	$countrysDiv.append('<div><a href="javascript:;" onclick="remove_watching_focus(this)"><div class="dipc">' + data[p] + '<span></span><input type="hidden" name="'+hiddenName+'" value="' + p + '"/></div></a></div>');
	                    }
	                }
	            }
	            $elm.val('');
	        }
	    };
	    $.ajax({
	        type: 'POST',
	        url: '../search/countrylist.action',
	        data: 'areas=' + countrys,
	        dataType: "json",
	        cache: false,
	        success: $callback,
	        error: DWZ.ajaxError
	    });
	});
});

function addLeId(name) {
    var $box = navTab.getCurrentPanel();
    var leId = $('[name="' + name + 'Suggest.id"]', $box).val();
    var leName = $('[name="' + name + 'Suggest.key"]', $box).val();
    if (leId == '') {
        alertMsg.error("请输入正确的信息！");
        return;
    }
    var hasContain = false;
//    if ($("input[name='" + name + "']", $box).length < 1) {
//        $("#" + name + "Div", $box).append('<div><a href="javascript:;" onclick="remove_watching_focus(this)"><div class="dipc">' + leName + '<span></span><input type="hidden" name="' + name + '" value="' + leId + '"/></div></a></div>');
//    } else {
        $("input[name='leIdImport']", $box).each(function() {
            if (this.value == leId) {
                hasContain = true;
            }
        });
        $("input[name='leIdCommon']", $box).each(function() {
        	if (this.value == leId) {
        		hasContain = true;
        	}
        });
        $("input[name='leIdSecondary']", $box).each(function() {
        	if (this.value == leId) {
        		hasContain = true;
        	}
        });
        if (!hasContain) {
//        	if ($("#leIdDiv",$box).find('input[type="hidden"]').length >= 10) {
//		    	  alertMsg.error("总数不能超过10个");
//                return;  
//		    }
            $("#" + name + "Div", $box).append('<div><a href="javascript:;" onclick="remove_watching_focus(this)"><div class="dipc">' + leName + '<span></span><input type="hidden" name="' + name + '" value="' + leId + '"/></div></a></div>');
        } else {
        	alertMsg.error("已经存在！");
        }
//    }
    $('[name="' + name + 'suggest.id"]', $box).val();
    $('[name="' + name + 'suggest.key"]', $box).val();
}

function addSubLeId() {
    var $box = navTab.getCurrentPanel();
    var subLeId = $('[name="subLeIdSuggest.id"]', $box).val();
    var subLeIdName = $('[name="subLeIdSuggest.key"]', $box).val();
    if (subLeId == '') {
        alertMsg.error("请输入正确的信息！");
        return;
    }
    var hasContain = false;
    if ($("input[name='subLeId']", $box).length < 1) {
        $("#subLeIdDiv", $box).append('<div><a href="javascript:;" onclick="remove_watching_focus(this)"><div class="dipc">' + subLeIdName + '<span></span><input type="hidden" name="subLeId" value="' + subLeId + '"/></div></a></div>');
    } else {
        $("input[name='subLeId']", $box).each(function() {
            if (this.value == subLeId) {
                hasContain = true;
            }
        });
        if (!hasContain) {
        	if ($("#subLeIdDiv",$box).find('input[type="hidden"]').length >= 10) {
		    	  alertMsg.error("总数不能超过10个");
                return;  
		    }
            $("#subLeIdDiv", $box).append('<div><a href="javascript:;" onclick="remove_watching_focus(this)"><div class="dipc">' + subLeIdName + '<span></span><input type="hidden" name="subLeId" value="' + subLeId + '"/></div></a></div>');
        } else {
        	alertMsg.error("已经存在！");
        }
    }
    $('[name="subLeIdSuggest.key"]', $box).val('');
    $('[name="subLeIdSuggest.id"]', $box).val('');
}
//切换图片时地址替换
var picToTvUrl = function(oldUrl) {
	if (isTvVrsVal == 1) {
		if(oldUrl.indexOf("i0.letvimg.com")>0){
			return oldUrl.replace(/i0.letvimg.com/,"i0.img.cp21.ott.cibntv.net");
		}else if(oldUrl.indexOf("i1.letvimg.com")>0){
			return oldUrl.replace(/i1.letvimg.com/,"i1.img.cp21.ott.cibntv.net");
		}else if(oldUrl.indexOf("i2.letvimg.com")>0){
			return oldUrl.replace(/i2.letvimg.com/,"i2.img.cp21.ott.cibntv.net");
		}else if(oldUrl.indexOf("i3.letvimg.com")>0){
			return oldUrl.replace(/i3.letvimg.com/,"i3.img.cp21.ott.cibntv.net");
		} else {
			return oldUrl;
		}
	} else if (isTvVrsVal == 2) {
		if(oldUrl.indexOf("i0.letvimg.com")>0){
			return oldUrl.replace(/i0.letvimg.com/,"i0.img.letv-epg.wasu.tv");
		}else if(oldUrl.indexOf("i1.letvimg.com")>0){
			return oldUrl.replace(/i1.letvimg.com/,"i1.img.letv-epg.wasu.tv");
		}else if(oldUrl.indexOf("i2.letvimg.com")>0){
			return oldUrl.replace(/i2.letvimg.com/,"i2.img.letv-epg.wasu.tv");
		}else if(oldUrl.indexOf("i3.letvimg.com")>0){
			return oldUrl.replace(/i3.letvimg.com/,"i3.img.letv-epg.wasu.tv");
		} else {
			return oldUrl;
		}
	}
	return oldUrl;
};
//  反切
// 切换图片时地址替换
var tvUrlToPic = function(oldUrl) {
	if (isTvVrsVal == 1) {
		if(oldUrl.indexOf("i0.img.cp21.ott.cibntv.net")>0){
			return oldUrl.replace(/i0.img.cp21.ott.cibntv.net/,"i0.letvimg.com");
		}else if(oldUrl.indexOf("i1.img.cp21.ott.cibntv.net")>0){
			return oldUrl.replace(/i1.img.cp21.ott.cibntv.net/,"i1.letvimg.com");
		}else if(oldUrl.indexOf("i2.img.cp21.ott.cibntv.net")>0){
			return oldUrl.replace(/i2.img.cp21.ott.cibntv.net/,"i2.letvimg.com");
		}else if(oldUrl.indexOf("i3.img.cp21.ott.cibntv.net")>0){
			return oldUrl.replace(/i3.img.cp21.ott.cibntv.net/,"i3.letvimg.com");
		}
		else {
			return oldUrl;
		}
	} else if (isTvVrsVal == 2) {
		if(oldUrl.indexOf("i0.img.letv-epg.wasu.tv")>0){
			return oldUrl.replace(/i0.img.letv-epg.wasu.tv/,"i0.letvimg.com");
		}else if(oldUrl.indexOf("i1.img.letv-epg.wasu.tv")>0){
			return oldUrl.replace(/i1.img.letv-epg.wasu.tv/,"i1.letvimg.com");
		}else if(oldUrl.indexOf("i2.img.letv-epg.wasu.tv")>0){
			return oldUrl.replace(/i2.img.letv-epg.wasu.tv/,"i2.letvimg.com");
		}else if(oldUrl.indexOf("i3.img.letv-epg.wasu.tv")>0){
			return oldUrl.replace(/i3.img.letv-epg.wasu.tv/,"i3.letvimg.com");
		}
		else {
			return oldUrl;
		}
	}
	return oldUrl;
};

// 处理确认大图逻辑，size为尺寸960*540.. box为所在控件
var checkBigPic = function(size, box) {
	var sizeArray = size.split("*");
    if (parseInt(sizeArray[0])==960) {                				
    	$('#isBigPic', box).removeAttr("disabled");
    	$('#isBigPic', box).attr("checked", true);
    	$('#isBigPic', box).attr("value", 1);
    }
};

// 去掉集数前面的0，如输入01变为1，动漫的0集除外，保存0
function delZeroForStart(obj){
	var tempEpisode = $(obj).val();
	var resultEpisode = tempEpisode;
	var re = new RegExp(/^0\d*$/g);
	if(re.test(tempEpisode)){
		re = new RegExp(/^0*$/g);
		if(re.test(tempEpisode)){
			resultEpisode = 0;
		}
		re = new RegExp(/^0*[1-9]\d*$/g);
		if(re.test(tempEpisode)){
			resultEpisode = tempEpisode.replace(/^0*/g,'');
		}
	}
	$(obj).val(resultEpisode);
}
