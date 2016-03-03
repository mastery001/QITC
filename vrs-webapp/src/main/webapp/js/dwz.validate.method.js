/**
 * @requires jquery.validate.js
 * @author ZhangHuihua@msn.com
 */
(function($){
	if ($.validator) {
		$.validator.addMethod("alphanumeric", function(value, element) {
			return this.optional(element) || /^\w+$/i.test(value);
		}, "Letters, numbers or underscores only please");
		
		$.validator.addMethod("lettersonly", function(value, element) {
			return this.optional(element) || /^[a-z]+$/i.test(value);
		}, "Letters only please"); 
		
		$.validator.addMethod("phone", function(value, element) {
			return this.optional(element) || /^[0-9 \(\)]{7,30}$/.test(value);
		}, "Please specify a valid phone number");
		
		$.validator.addMethod("postcode", function(value, element) {
			return this.optional(element) || /^[0-9 A-Za-z]{5,20}$/.test(value);
		}, "Please specify a valid postcode");
		
		$.validator.addMethod("date", function(value, element) {
			value = value.replace(/\s+/g, "");
			if (String.prototype.parseDate){
				var $input = $(element);
				var pattern = $input.attr('dateFmt') || 'yyyy-MM-dd';
	
				return !$input.val() || $input.val().parseDate(pattern);
			} else {
				return this.optional(element) || value.match(/^\d{4}[\/-]\d{1,2}[\/-]\d{1,2}$/);
			}
		}, "Please enter a valid date.");

        // MMS-42
        $.validator.addMethod("vrsdate", function(value, element) {
            value = value.replace(/\s+/g, "");
            if (String.prototype.parseDate){
                var $input = $(element);
                //var pattern = $input.attr('dateFmt') || 'yyyy-MM-dd';
                var pattern = ['yyyy', 'yyyy-MM', 'yyyy-MM-dd'];
    
                return !$input.val() || $input.val().parseDate(pattern[0]) || 
                                        $input.val().parseDate(pattern[1]) || 
                                        $input.val().parseDate(pattern[2]);
            } else {
                return this.optional(element) || value.match(/^\d{4}[\/-]\d{1,2}[\/-]\d{1,2}$/);
            }
        }, "请输入合法的日期.");
        
     // vrsdateWithMonth
        $.validator.addMethod("vrsdateWithMonth", function(value, element) {
            value = value.replace(/\s+/g, "");
            
            if(value==''){
            	return 1;
            }
            
            if(value.split('-').length<2){
            	return 0;
            }
            
            if (String.prototype.parseDate){
                var $input = $(element);
                var pattern = ['yyyy-MM', 'yyyy-MM-dd'];
    
                return !$input.val() || $input.val().parseDate(pattern[0]) || $input.val().parseDate(pattern[1]);
            } else {
                return this.optional(element) || value.match(/^\d{4}[\/-]\d{1,2}[\/-]\d{1,2}$/);
            }
        }, "请输入合法的日期.");
        
        // MMS-70
        $.validator.addMethod("alphanumericOnly", function(value, element) {
			return this.optional(element) || /^[0-9a-zA-Z]+$/i.test(value);
		}, "只能输入字母、数字或字母数字组合");
        
        // MMS-46
        $.validator.addMethod("videoTag", function(value, element) {
        	value = $.trim(value);
        	var tags = value.split(/\s+/);
        	if(tags.length > 5)
        	{
        		return false;
        	}
        	
        	for(var i = 0, len = tags.length; i < len; i++)
        	{
        		if(tags[i].length > 10)
        		{
        			return false;
        		}
        	}
        	return true;
        }, "最多5个标签，每标签最多10个字符");
        
        // 最多5项,验证是否在指定的专辑内
        $.validator.addMethod("albumClone", function(value, element) {
        	value = $.trim(value);
        	if(value == '') return true;
        	var ids = value.split(',');
        	var flag = true;
        	
        	if(ids.length > 5)
        	{
        		return false;
        	}
        	else if(ids.length >=1 && ids.length < 6)
        	{
	        	for(var i = 0; i < ids.length; i += 1){
	        		if(!$.isNumeric(ids[i]) || !ids[i]){
	        			alertMsg.warn('要复制到的专辑id格式非法');
	        			return false;
	        		}
	        	}
	        	
	        	$.ajax({
	                type: 'POST',
	                url: '../clone/canClone.action',
	                data: {
	                	'vid': $('input[name="id"]', navTab.getCurrentPanel()).val() || 0,
	                	clonePid: value
	                },
	                dataType: 'json',
	                cache: false,
	                async: false,
	                success: function(json){
	                	if(json.statusCode !== 200){
	                		alertMsg.warn(json.message);
	                		flag = false;
	                	}
	                },
	                error: DWZ.ajaxError
	            });
        	}
        	
        	return flag;
        }, '最多5个专辑，视频克隆验证失败');
        
        

		/*自定义js函数验证
		 * <input type="text" name="xxx" customvalid="xxxFn(element)" title="xxx" />
		 */
		$.validator.addMethod("customvalid", function(value, element, params) {
			try{
				return eval('(' + params + ')');
			}catch(e){
				return false;
			}
		}, "Please fix this field.");
		
		$.validator.addClassRules({
			date: {date: true},
			vrsdate: {vrsdate: true},
			vrsdateWithMonth:{vrsdateWithMonth: true},
			alphanumeric: { alphanumeric: true },
			alphanumericOnly: { alphanumericOnly: true },
			lettersonly: { lettersonly: true },
			phone: { phone: true },
			postcode: {postcode: true},
			videoTag: {videoTag: true},
			albumClone: {albumClone: true}
		});
		$.validator.setDefaults({
			errorElement:"span",
			onkeyup: function(element) {return;}//去掉文本内容变化时验证,只保留焦点丢失验证
		});
		$.validator.autoCreateRanges = true;
		
	}

})(jQuery);