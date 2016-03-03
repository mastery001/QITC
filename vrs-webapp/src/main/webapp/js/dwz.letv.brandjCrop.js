/**
 * 资料库-品牌管理-添加品牌
 * 使用面向对象的方式来开发这个功能，能够保证多个页面共用改功能额时候可以进
 * 行个性化的设置
 * 工作空间：brand
 * Created by liwenliang on 2015/6/1.
 */
// 资料库-品牌管理-添加品牌 照片编辑模块
window.Brand_jCrop = function (advert, folder) {
    'use strict';
    this.setProperty('advert', advert);
    this.setProperty('folder', folder);
    this.setProperty('materialImages', []);
    this.setProperty('leBackImage', '');
    this.setProperty('winWidth', $(window).width());
};

// 设置原型
Brand_jCrop.prototype = {
    /**
     * 构造器指回
     */
    constructor: Brand_jCrop,

    /**
     * 照片编辑模块功能初始化入口函数
     */
    init: function () {
        this.initDom();
        this.initEvent();
        this.setProperty('tabInited', true);
    },

    /****************************基本函数****************************/
    /**
     * 初始化Dom节点，保存变量方便使用
     */
    initDom: function () {
        var $box = navTab.getCurrentPanel();
        this.setProperty('jcrop_api', null);
        this.setProperty('$sourceContainer', $('#sourceContainer', $box));
        this.setProperty('currentCropData', {
            ratio: '1:1',
            w: 0,
            h: 0,
            x: 0,
            y: 0,
            path: ''
        });

        // 背板图
        this.setProperty('$result_bgSource', $('#result_bgSource', $box));

        // 比例设置按钮
        this.setProperty('$brand_lock3_4', $('#brand_lock3_4', $box));
        this.setProperty('$brand_lock1_1', $('#brand_lock1_1', $box));
        this.setProperty('$brand_crop_image', $('#brand_crop_image', $box));

        this.setProperty('$brandBgimg', $('#brandBgimg', $box));
        this.setProperty('$brandSource_img', $('#brandSource_img', $box));

        this.setProperty('$brandImgbox', $('#brandImgbox', $box));

        // 文件上传控件
        this.setProperty('$brandFileInput', $('#brandFileInput', $box));
        this.setProperty('$brandBgImageInput', $('#brandBgImageInput', $box));

        // 保存与取消按钮
        this.setProperty('$saveAllInfoData', $('#saveAllInfoData', $box));
        this.setProperty('$cancelSaveInfoData', $('#cancelSaveInfoData', $box));

        // 表单
        this.setProperty('$brandFromList', $('#brandFromList', $box));

        // id
        this.setProperty('brandUniqueId', $('#brandUniqueId', $box).val());

        // 成品图
        this.setProperty('$result3_4', $('#result3_4', $box));
        this.setProperty('$result1_1', $('#result1_1', $box));
        this.setProperty('$result_circle', $('#result_circle', $box));

        this.setProperty('$result150_200', $('#result150_200', $box));
        this.setProperty('$result300_400', $('#result300_400', $box));
        this.setProperty('$result150_150', $('#result150_150', $box));
        this.setProperty('$result300_300', $('#result300_300', $box));
    },

    /**
     * 初始化事件，添加事件监听
     */
    initEvent: function () {
        var $box = navTab.getCurrentPanel();
        $box.on('click', '.sourceImgItem', $.proxy(this.onSourceImgClick, this));
        $box.on('click', '.deleteItem', $.proxy(this.onDeleteItem, this));

        this.getProperty('$brand_lock3_4').on('click', $.proxy(this.onlockClick, this));
        this.getProperty('$brand_lock1_1').on('click', $.proxy(this.onlockClick, this));
        this.getProperty('$brand_crop_image').on('click', $.proxy(this.onCropImage, this));

        // 保存取消按钮点击
        this.getProperty('$saveAllInfoData').on('click', $.proxy(this.saveAllInfoData, this));
        this.getProperty('$cancelSaveInfoData').on('click', $.proxy(this.cancelSaveInfoData, this));

        $(window).on('resize',$.proxy(this.onWindowResize, this));
    },

    /**
     * 初始化jCrop组件
     */
    initJcrop: function (brandFileInput, brandBgImageInput) {
        // 素材图片上传
        var _self = this;
        this.uploadify($('#' + brandFileInput), this.getProperty('folder'), {
            'onComplete': function (event, ID, fileObj, response, data) {
                var json = $.parseJSON(response);
                if (json.statusCode !== 200) {
                    alertMsg.error(json.message);
                } else {
                    var item = {
                        src: json.data.src,
                        width: json.data.width,
                        height: json.data.height
                    };
                    _self.addMaterialImage(item);
                }
            }
        });

        // 背板图上传
        this.uploadify($('#' + brandBgImageInput), this.getProperty('folder'), {
            'script': "/upload/leBackImgUpload.action",
            'onComplete': function (event, ID, fileObj, response, data) {
                var json = $.parseJSON(response);
                if (json.statusCode !== 200) {
                    alertMsg.error(json.message);
                } else {
                    var item = {
                        src: json.data.src,
                        width: json.data.width,
                        height: json.data.height,
                        path: json.data.path
                    };
                    _self.replaceBgImage(item);
                }
            }
        });

        // 如果当前页面存在id，那么就需要去后台取已有数据
        if (this.getProperty('brandUniqueId')) {
            $.ajax({
                url: '/' + this.getProperty('advert') + '/getOrigImgPath.action',
                type: 'get',
                data: {
                    id: this.getProperty('brandUniqueId')
                },
                success: $.proxy(_self.initBackgroundData, _self)
            });
        }
    },

    /**
     * 后台取已有数据
     */
    initBackgroundData: function (data) {
        var json = {};
        if (typeof data === 'string') {
            json = JSON.parse(data);
        } else {
            json = data;
        }
        if (json.statusCode !== 200) {
            alertMsg.error(json.message);
        } else {
            var imageData = json.data;
            for (var i = 0, length = imageData.length; i < length; i++) {
                if(imageData[i].type === 'hd'){
                    var item = {
                        src: imageData[i].path,
                        width: imageData[i].width,
                        height: imageData[i].height
                    };
                    this.addMaterialImage(item);

                    if (imageData[i].imgList && imageData[i].imgList.length > 0) {
                        for (var j = 0; j < imageData[i].imgList.length; j++) {
                            if (imageData[i].imgList[j].ratio === '1:1') {
                                this.setResult11(imageData[i].imgList[j].url, imageData[i].path);
                            } else if (imageData[i].imgList[j].ratio === '3:4') {
                                this.setResult34(imageData[i].imgList[j].url, imageData[i].path);
                            }
                        }
                    }
                } else {
                    var item1 = {
                        src: imageData[i].url,
                        width: imageData[i].width,
                        height: imageData[i].height
                    };
                    this.replaceBgImage(item1);
                }
            }
        }
    },
    /****************************基本函数End****************************/

    /****************************功能函数Start*************************/
    /**
     * 图片上传函数
     * @param $dom  要操作的Dom节点 jQuery对象
     * @param queueID  队列中的id
     * @param customConfig
     */
    uploadify: function ($dom, folder, customConfig) {
        var uploadifyConfig = {
            'uploader': "../uploadify/scripts/uploadify.swf",
            'script': "/upload/leImgUpload.action",
            'cancelImg': '/uploadify/cancel.png',
            'folder': '/' + folder,
            'height': "30",
            'width': "110",
            'fileExt': '*.jpg;',
            'fileDesc': '图像文件 ',
            'auto': true,
            'multi': false
        };
        if (customConfig) {
            $.extend(uploadifyConfig, customConfig);
        }
        $dom.uploadify(uploadifyConfig);
    },

    /**
     * 原图点击事件
     * @param event
     */
    onSourceImgClick: function (event) {
        var _self = this;
        var $this = $(event.currentTarget);
        var order = $this.attr('data-order');
        var currentImage = this.getProperty('materialImages')[order];
        var imageSrc = currentImage.src;

        //设置数据path字段
        this.getProperty('currentCropData').path = imageSrc;
        var $brandImgbox = this.getProperty('$brandImgbox');
        var jcrop_api = this.getProperty('jcrop_api');

        var hbw = currentImage.height / currentImage.width;

        var boxWidth, boxHeight;

        boxWidth = ($(window).width() / 2.2) > currentImage.width ? currentImage.width : ($(window).width() / 2.2);
        boxHeight = hbw * boxWidth;

        if (jcrop_api) {
            jcrop_api.setOptions({
                boxWidth: boxWidth,
                boxHeight: boxHeight,
                aspectRatio: 1 / 1
            });
            jcrop_api.setImage(imageSrc);
            _self.setJcropRatio('1:1');
        } else {
            $brandImgbox.attr('src', imageSrc);
            $brandImgbox.Jcrop({
                minSize: [300, 300],
                onChange: $.proxy(_self.updateCropData, _self),
                onSelect: $.proxy(_self.updateCropData, _self),
                boxWidth: boxWidth,
                boxHeight: boxHeight,
                aspectRatio: 1 / 1
            }, function () {
                _self.setProperty('jcrop_api', this);
                _self.setJcropRatio('1:1');
            });
        }
    },

    /**
     * 删除图片
     */
    onDeleteItem: function (event) {
        var _self = this;
        alertMsg.confirm('确认删除吗？', {okCall: function () {
            var $this = $(event.currentTarget);
            var materialImages = _self.getProperty('materialImages');
            switch ($this.attr('data-type')) {
                case 'materialImage':
                    var order = parseInt($this.attr('data-order'), 10);
                    materialImages.splice(order, 1);
                    $this.parent().remove();
                    _self.reRenderMaterialImages();
                    break;
                case 'backImage':
                    _self.setProperty('leBackImage', '');
                    _self.getProperty('$brandBgimg').html('');
                    break;
            }
        }});
    },

    /**
     * 比例点击
     * @param event
     */
    onlockClick: function (event) {
        var $this = $(event.currentTarget);
        var jcrop_api = this.getProperty('jcrop_api');
        if (!jcrop_api) {
            return;
        }
        switch ($this.attr('id')) {
            case 'brand_lock3_4':
                this.setJcropRatio('3:4');
                break;
            case 'brand_lock1_1':
                this.setJcropRatio('1:1');
                break;
        }
    },

    /**
     * 裁切图片保存
     */
    onCropImage: function () {
        var _self = this;

        //限制裁切尺寸
        var currentCropData = this.getProperty('currentCropData');
    	currentCropData.x = parseInt(currentCropData.x);
    	currentCropData.y = parseInt(currentCropData.y);
    	currentCropData.w = parseInt(currentCropData.w);
    	currentCropData.h = parseInt(currentCropData.h);
        if(currentCropData.x<0 || currentCropData.y<0){
            alertMsg.error("素材图尺寸太小，请重新上传符合质量标准的素材图！");
            return;
        }

        if(currentCropData.w === 0 || currentCropData.h === 0){
            alertMsg.error("请裁切图片！");
            return;
        }

        $.ajax({
            url: '/upload/leImgUploadWithCut.action',
            type: 'get',
            data: currentCropData,
            success: $.proxy(_self.onCropImageSuccess, _self)
        });
    },

    /**
     * 裁切图片完成
     * 这里要做的是这样几件事：
     * 1.设置这几个属性字段：url11，path11，url34，path34，bgUrl
     */
    onCropImageSuccess: function (data) {
        var _self = this;
        if (data.statusCode !== 200) {
            alertMsg.error(data.message);
        } else {
            if (data.data) {
                var url = data.data.url;
                var path = _self.getProperty('currentCropData').path;
                if (data.data.ratio === '1:1') {
                    _self.setResult11(url, path);
                } else if (data.data.ratio === '3:4') {
                    _self.setResult34(url, path);
                }
            }
        }
    },

    /**
     *  设置成品图1:1
     */
    setResult11: function (url, path) {
        this.setProperty('url11', url);
        var url_100_100 = url + '/11_100_100.jpg';
        var url_150_150 = url + '/11_150_150.jpg';
        var url_300_300 = url + '/11_300_300.jpg';
        this.getProperty('$result1_1').attr('src', url_100_100);
        this.getProperty('$result_circle').attr('src', url_100_100);
        this.getProperty('$result150_150').attr('href', url_150_150);
        this.getProperty('$result300_300').attr('href', url_300_300);
        this.setProperty('path11', path);
    },

    /**
     * 设置成品图3:4
     */
    setResult34: function (url, path) {
        this.setProperty('url34', url);
        var url_90_120 = url + '/34_90_120.jpg';
        var url_150_200 = url + '/34_150_200.jpg';
        var url_300_400 = url + '/34_300_400.jpg';
        this.getProperty('$result3_4').attr('src', url_90_120);
        this.getProperty('$result150_200').attr('href', url_150_200);
        this.getProperty('$result300_400').attr('href', url_300_400);
        this.setProperty('path34', path);
    },

    /**
     * 保存
     */
    saveAllInfoData: function(){
        var $brandFromList = this.getProperty('$brandFromList');

        /**
         * 图片裁切部分只需要增加这几个就可以了
         * 剩下的还是用以前的表单提交的方式
         * @type {{name: string, value: *}}
         */
        var url11 = {name: 'headPicWeb', value: this.getProperty('url11')};
        var path11 = {name: 'headPic', value: this.getProperty('path11')};
        var url34 = {name: 'headPicWeb34', value: this.getProperty('url34')};
        var path34 = {name: 'headPic34', value: this.getProperty('path34')};
        var bgUrl = {name: 'backPicWeb', value: this.getProperty('bgUrl')};
        var bgPath = {name: 'backPic', value: this.getProperty('bgPath')};

        var result = "[";
        $(".directorBox").each(function(index){
        	var key = ""
        	$(this).find("input").each(function(index,item){
        		 key = key + $(item).attr("name") + ":\"" + $(item).val() + "\",";
        	});
        	if (key.substring(key.length - 1, key.length) == ",") {
        		key = key.substring(0, key.length - 1);
    		}
        	result += "{" + key + "},";
        }); 
		if (result.substring(result.length - 1, result.length) == ",") {
			result = result.substring(0, result.length - 1);
		}
		link = result + "]";
		
		link = link.replaceAll("starrings.key", "name").replaceAll("starringPlaySome", "link").replaceAll("starringPlayPicSome", "pic");
		
		var re = {name: 'starPicInfo', value: link};
		
        var extendData = [url11, path11, url34, path34, bgUrl, bgPath,re];
        
		this.validateCallback($brandFromList, this.navTabAjaxDone, '保存当前页面信息？', extendData);
    },

    /**
     * 取消
     */
    cancelSaveInfoData: function(){
        var closeTab = function(){
            navTab.closeCurrentTab();
        };
        alertMsg.confirm('取消并关闭当前tab?', {okCall: closeTab});
    },

    /**
     * 普通ajax表单提交
     * @param form  表单
     * @param callback 回调
     * @param confirmMsg 提示确认信息
     * @param extendData 一个数组，里边包含{name:'',value:''}的对象，里边包含的是扩展参数
     */
    validateCallback: function (form, callback, confirmMsg, extendData) {
        var $form = $(form);

        if (!$form.valid()) {
            return false;
        }

        // form表单可扩展
        var formSearializeArray = $form.serializeArray().concat(extendData || []);

        var _submitFn = function () {
            $.ajax({
                type: form.method || 'POST',
                url: $form.attr("action"),
                data: formSearializeArray,
                dataType: "json",
                cache: false,
                success: callback || DWZ.ajaxDone,
                error: DWZ.ajaxError
            });
        };

        if (confirmMsg) {
            alertMsg.confirm(confirmMsg, {okCall: _submitFn});
        } else {
            _submitFn();
        }

        return false;
    },

    /**
     * navTabAjaxDone是DWZ框架中预定义的表单提交回调函数．
     * 服务器转回navTabId可以把那个navTab标记为reloadFlag=1, 下次切换到那个navTab时会重新载入内容.
     * callbackType如果是closeCurrent就会关闭当前tab
     * 只有callbackType="forward"时需要forwardUrl值
     * navTabAjaxDone这个回调函数基本可以通用了，如果还有特殊需要也可以自定义回调函数.
     * 如果表单提交只提示操作是否成功, 就可以不指定回调函数. 框架会默认调用DWZ.ajaxDone()
     * <form action="/user.do?method=save" onsubmit="return validateCallback(this, navTabAjaxDone)">
     *
     * form提交后返回json数据结构statusCode=DWZ.statusCode.ok表示操作成功, 做页面跳转等操作. statusCode=DWZ.statusCode.error表示操作失败, 提示错误原因.
     * statusCode=DWZ.statusCode.timeout表示session超时，下次点击时跳转到DWZ.loginUrl
     * {"statusCode":"200", "message":"操作成功", "navTabId":"navNewsLi", "forwardUrl":"", "callbackType":"closeCurrent", "rel"."xxxId"}
     * {"statusCode":"300", "message":"操作失败"}
     * {"statusCode":"301", "message":"会话超时"}
     *
     */
    navTabAjaxDone: function (json) {
        DWZ.ajaxDone(json);
        if (json.statusCode == DWZ.statusCode.ok) {
            if (json.navTabId) { //把指定navTab页面标记为需要“重新载入”。注意navTabId不能是当前navTab页面的
                navTab.reloadFlag(json.navTabId);
            } else { //重新载入当前navTab页面
                var $pagerForm = $("#pagerForm", navTab.getCurrentPanel());
                var args = $pagerForm.size() > 0 ? $pagerForm.serializeArray() : {}
                navTabPageBreak(args, json.rel);
            }

            if ("closeCurrent" == json.callbackType) {
                setTimeout(function () {
                    navTab.closeCurrentTab(json.navTabId);
                }, 100);
            } else if ("forward" == json.callbackType) {
                navTab.reload(json.forwardUrl);
            } else if ("forwardConfirm" == json.callbackType) {
                alertMsg.confirm(json.confirmMsg || DWZ.msg("forwardConfirmMsg"), {
                    okCall: function () {
                        navTab.reload(json.forwardUrl);
                    },
                    cancelCall: function () {
                        navTab.closeCurrentTab(json.navTabId);
                    }
                });
            } else {
                navTab.getCurrentPanel().find(":input[initValue]").each(function () {
                    var initVal = $(this).attr("initValue");
                    $(this).val(initVal);
                });
            }
        }
    },

    /**
     * 调整窗口大小
     */
    onWindowResize: function () {
        var _self = this;
        setTimeout(function () {
            _self.setProperty('winWidth', $(window).width());
        }, 100);
    },

    /**
     * 设置比例
     * @param ratio
     */
    setJcropRatio: function (ratio) {
        this.getProperty('currentCropData').ratio = ratio;
        var jcrop_api = this.getProperty('jcrop_api');
        if (!jcrop_api) {
            return;
        }
        var endRatio = 1;
        if (ratio === '3:4') {
            endRatio = 3 / 4;
        }
        jcrop_api.setOptions({
            aspectRatio: endRatio
        });
        jcrop_api.focus();
    },

    /**
     * 更新预览
     */
    updateCropData: function (c) {
        var currentCropData = this.getProperty('currentCropData');
        currentCropData.w = c.w;
        currentCropData.h = c.h;
        currentCropData.x = c.x;
        currentCropData.y = c.y;
    },

    /**
     * 添加素材图片
     * @param imageData
     */
    addMaterialImage: function (imageData) {
        var item = '<li><img style="cursor: pointer;display:block;" data-order="' + this.getProperty('materialImages').length + '" class="sourceImgItem" src="' + imageData.src + '" width="160px">' +
            '<span class="brandImgInfo">' + imageData.width + 'px * ' + imageData.height +
            'px</span><span data-type="materialImage" data-order="' + this.getProperty('materialImages').length +
            '" class="deleteItem">删除</span></li>';
        this.getProperty('$brandSource_img').find('ul').append(item);
        this.getProperty('materialImages').push(imageData);
    },

    /**
     * 重新渲素材图片
     */
    reRenderMaterialImages: function () {
        this.getProperty('$brandSource_img').find('ul').html('');
        var materialImages = this.getProperty('materialImages');
        var tempImages = materialImages.concat();
        materialImages.length = 0;
        for (var i = 0, length = tempImages.length; i < length; i++) {
            this.addMaterialImage(tempImages[i]);
        }
    },

    /**
     * 替换背景图
     * @param imageData
     */
    replaceBgImage: function (imageData) {
        this.setProperty('leBackImage', imageData.src);
        var item = '<img style="display:block;" class="bgImgItem" src="' + imageData.src + '" width="160px">' +
            '<span class="brandImgInfo">' + imageData.width + 'px * ' + imageData.height + 'px</span><span data-type="backImage" class="deleteItem">删除</span>';
        this.getProperty('$brandBgimg').html(item);
        this.getProperty('$result_bgSource').attr('src', imageData.src);
        this.getProperty('$result_bgSource').parent().attr('href', imageData.src);
        this.setProperty('bgUrl', imageData.src);
        this.setProperty('bgPath', imageData.path);
    },

    /**
     * 设置属性
     */
    setProperty: function (key, value) {
        var $box = navTab.getCurrentPanel();
        if (key) {
            $box.data(key, value);
        }
    },

    /**
     * 获取属性
     */
    getProperty: function (key) {
        var $box = navTab.getCurrentPanel();
        return $box.data(key) || '';
    }
    /****************************功能函数End*************************/
};