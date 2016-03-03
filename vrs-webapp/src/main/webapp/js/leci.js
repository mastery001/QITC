function up_leci_to_selected(obj, leId, leName) {
	// var $dialog = $(obj).parent().parent().parent().parent();
	var hasContain = false;
	$("input[name='selectedLeId']").each(function() {
		if (this.value == leId) {
			hasContain = true;
		}
	});
	if (!hasContain) {
		appendSeletedLeci(leId, leName);
	} else {
		alertMsg.error("已经存在！");
	}
	$( "#selectedLeciDiv" ).sortable();
};

function add_LeId() {
	var leId = $('[name="leIdSuggest.id"]').val();
	var leName = $('[name="leIdSuggest.key"]').val();
	if (leId == '') {
		alertMsg.error("请输入正确的信息！");
		return;
	}
	var hasContain = false;
	if ($("input[name='selectedLeId']").length < 1) {
		appendSeletedLeci(leId, leName);
	} else {
		$("input[name='selectedLeId']").each(function() {
			if (this.value == leId) {
				hasContain = true;
			}
		});
		if (!hasContain) {
			// if ($("#leIdDiv",$box).find('input[type="hidden"]').length >= 10)
			// {
			// alertMsg.error("总数不能超过10个");
			// return;
			// }
			appendSeletedLeci(leId, leName);
		} else {
			alertMsg.error("已经存在！");
		}
	}
	$('[name="leIdSuggest.key"]').val('');
	$('[name="leIdSuggest.id"]').val('');
	$( "#selectedLeciDiv" ).sortable();
}

var appendSeletedLeci = function(leId, leName) {
	$("#selectedLeciDiv")
			.append(
					'<div name="leciDiv" class="leciDivClass"><a href="javascript:;" onclick="remove_watching_focus_without_tip(this)" ><div class="tipPic">'
							+ leName
							+ '<span></span><input type="hidden" name="selectedLeId" value="'
							+ leId
							+ '" /><input type="hidden" name="selectedLeName" value="'
							+ leName + '" /></div></a></div>');
};

// 设置子页签的乐词到主面板
function setLeId2MainBoard(leciType, minCount, maxCount) {
	var $box = navTab.getCurrentPanel();
	// 取得当前窗口的.tipPic(已选定)
	var divArray = $(".tipPic", $.pdialog.getCurrent());
	// 不为-1说明有边界限制
	if (minCount != -1 && maxCount != -1) {
		var selecteLeciCount = divArray.length;
		if (selecteLeciCount < minCount || selecteLeciCount > maxCount) {
			alert("该分类乐词数量必须大于" + minCount + "个且小于" + maxCount + "个.");
			return;
		}
	}
	var leciTypeDiv = $("#Div_leciType_" + leciType, $box);
	$(".singelLeci", leciTypeDiv).remove();
	for (var i = 0, len = divArray.length; i < len; i += 1) {
		var div = divArray[i];
		var leId = $("input[name='selectedLeId']", div).val();
		var leName = $("input[name='selectedLeName']", div).val();
		$("#Div_leciType_" + leciType, $box)
				.append(
						'<div class="singelLeci">'
								+ leName
								+ '<span></span> <input type="hidden" name="singleLeId" value="'
								+ leId
								+ '" /><input type="hidden" name="singleLeName" value="'
								+ leName + '" /></div>');
	}
	$.pdialog.closeCurrent();
};

// 点击保存时设置乐词json到前端vo
var setLeciJson2VO = function() {
	var $box = navTab.getCurrentPanel();
	var $leciJson = '';
	// 遍历乐词类型对应的div 模糊匹配
	$("div[id^='Div_leciType_']", $box).each(function() {
		var typeCode = $("input[name='leciTypeCode']", this).val();
		var singelLeciArray = $(".singelLeci", this);
		var len = singelLeciArray.length;
		if (len > 0) {
			$leciJson = $leciJson + '"' + typeCode + '":",';
			for (var i = 0; i < len; i += 1) {
				var div = singelLeciArray[i];
				var leId = $("input[name='singleLeId']", div).val();
				$leciJson = $leciJson + leId + ',';
				if (i == len - 1) {
					$leciJson = $leciJson + '"';
				}
			}
			$leciJson = $leciJson + ',';
		}
	});
	$leciJson = '{' + $leciJson.substring(0, $leciJson.length - 1) + '}';
	$("input[name='leId']", $box).val($leciJson);
};

// 设置主面板的乐词串到子面板
var setMainBoardLeci2Sub = function() {
	var leciType = $("input[name='leciType']").val();
	var $box = navTab.getCurrentPanel();
	// 遍历乐词类型对应的div 模糊匹配
	$("#Div_leciType_" + leciType, $box).each(function() {
		var singelLeciArray = $(".singelLeci", this);
		var len = singelLeciArray.length;
		if (len > 0) {
			for (var i = 0; i < len; i += 1) {
				var div = singelLeciArray[i];
				var leId = $("input[name='singleLeId']", div).val();
				var leName = $("input[name='singleLeName']", div).val();
				appendSeletedLeci(leId, leName);
			}
		}
	});
	$( "#selectedLeciDiv" ).sortable();
};

// 移除选中框不弹出警告
var remove_watching_focus_without_tip = function(obj) {
	$(obj).parent().remove();
};
