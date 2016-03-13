/*---------------------文件上传回调处理----------------------*/
/**
 * 比例图片上传回调处理
 */
var scale_picture_callback = function(event, queueID, fileObj, response, data)
{
	var json_picture = DWZ.jsonEval(response);
	var piclist = json_picture.data;
	var $box = navTab.getCurrentPanel();
	$.each(piclist, function(index, img){
		$('#'+index, $box).attr("src", img);
		$('#id_'+index, $box).val(img);
	});
	close_queue(queueID);
}


/**
 * 演员定妆照上传回调处理
 * 
 * @param  {[type]} event    [description]
 * @param  {[type]} queueID  [description]
 * @param  {[type]} fileObj  [description]
 * @param  {[type]} response [description]
 * @param  {[type]} data     [description]
 * @return {[type]}          [description]
 */
var actor_pic_callback = function(event, queueID, fileObj, response, data)
{
	var json_picture = DWZ.jsonEval(response);
	var $box = navTab.getCurrentPanel();
	$('#album_dingPic img:first', $box).attr('src', json_picture.data);
	$('#Peditor', $box).find('input[name="edit_dzz_url"]').val(json_picture.data);
	
	close_queue(queueID);
}


/**
 * 两秒后关闭上传进度条
 * 
 * @param  string  queueID  上传进度显示的容器ID
 * @return void
 */
function close_queue(queueID)
{
	window.setInterval(function(){
		$('#' + queueID, navTab.getCurrentPanel()).html('').hide();
	}, 2000);
}


var  pic_video_callback = function(event, queueID, fileObj, response, data){
	var json_picture = DWZ.jsonEval(response);
	var piclist = DWZ.jsonEval(json_picture.data);
	var $box = navTab.getCurrentPanel();
	$.each(piclist, function(index, img){
		myid = index;
		var t=0;
		$.each(img, function(i, url){
			// i = '160*160'
			$('#'+index, $box).val(url);
			$('#img_'+index, $box).attr("src", url);
			t++;
		});
	});
}

/**
 * 图片管理 － 素材图片上传 回调处理
 *  
 * @param {Object} event
 * @param {Object} queueID
 * @param {Object} fileObj
 * @param {Object} json
 * @param {Object} data
 */
var source_image_callback = function(event, queueID, fileObj, json, data)
{
    close_queue(queueID);
    var json_picture = DWZ.jsonEval(json);
    if (json_picture.statusCode == DWZ.statusCode.ok)
    {
        var newNode = '<dl class="nowrap" style="width:auto;">', img = json_picture.data;
        newNode += '<dt style="width:auto;"><img src="'+img.thumb+'" width="160" original-width="'+img.original_width+'" original-height="'+img.original_height+'" original-src="'+img.original+'" /></dt>';
        newNode += '<dd style="width:100%"><em  style="padding-right:10px;">'+img.original_width+'px * '+img.original_height+'px</em><a href="javascript:;">删除</a></dd>';
        newNode += '<input type="hidden" name="picOriginalSome" value="'+img.param+'"/></dl>';
        $('#source_img', navTab.getCurrentPanel()).prepend(newNode);
    }
}

var front_image_callback = function(event, fileObj, json, data) {
	 var json_picture = DWZ.jsonEval(json);
	 if (json_picture.statusCode == DWZ.statusCode.ok)
	 {
		 
		 var newNode = '<img src="'+ json_picture.data.thumb +'"/>';
		 $('#front_img', navTab.getCurrentPanel()).prepend(newNode);
	 }
}



var uploadifyMultiLang = function ($dom) {
    var uploadifyConfig = {
        'uploader': "../uploadify/scripts/uploadify.swf",
        'script': "../multiLang/upload.action",
        'cancelImg': '../uploadify/cancel.png',
        'folder': '/temp',
        'fileDataName': "myFile", 
		'lang': lang,
		'type': type,
        'height': "30",
        'width': "110",
        'fileExt': "*.xls;*.xlsx" ,
        'fileDesc': '支持格式：xls xlsx',
        'auto': true,
        'multi': false,
		'onComplete': source_multiLang_text_callback,
    };
    $dom.uploadify(uploadifyConfig);
}


//上传多语回调
var source_multiLang_text_callback = function(event, queueID, fileObj, json, data)
{
	var jsonResult = DWZ.jsonEval(json);
	if (jsonResult.statusCode == DWZ.statusCode.ok) {
		var $box = navTab.getCurrentPanel();
		var lang = $("#lang", $box).val();
		var type = $("#type", $box).val();
		var filePath = jsonResult.data.filePath;
		$.ajax({
			type: "POST",
			async: true,
			url: "../multiLang/multiLangImport.action?lang=" + lang + "&type=" + type + "&filePath=" + filePath,
			datatype:"json",
			success:function(json){
				if(json.statusCode == DWZ.statusCode.ok){
					alert("数据导入成功");
				}else{
					// 下载错误信息
					window.location.href="../multiLang/multiLangExport.action?filePath=" + json.data;
				   	alert("数据导入有异常");
				}
			}
		});
	}
	close_queue(queueID);
};