/**
 * @author chengyong@letv.com
 * @description 人员管理
 */

//查找明星
function onblurs(object, value)
{
//	if(value == '')
//	{
//		return false;
//	}
//	var $box = navTab.getCurrentPanel();
//	$.get('../star/starIsExist.action?starName=' + encodeURIComponent(value), function(data){
//    	var $id=$(object, $box).parent().parent();
//		$id.find(".j-nostar").remove();
//		if (!data.data.isExist)
//		{
//			$(object).parent().find('input[type="hidden"]').val('');
//			$id.append('<td class="j-nostar"><font color="red">'+value+'不在明星库中</font> <a href="javascript:;" onclick="javascript:addStar(\''+value+'\');"  >点击将'+value+'添加到明星库中</a></td>');
//		}
//		else
//		{
//			var star_data = data.data.data;
//			if (star_data.length > 1)
//			{
//				var str = '<td class="j-nostar"><font color="red">'+value+'在明星库中有重复</font> ';
//				$.each(star_data, function(i, obj){
//					str += '<p>'+obj.id+'-'+obj.name+':'+obj.description+'</p>';
//				});
//				str += '</td>';
//				
//				$id.append(str);
//			}
//		}
//	}, 'json');
}

//添加明星
function addStar(value)
{
	var index = navTab._indexTabId("addstar");
	if(index>0){
		navTab.closeTab("addstar");
	}
	var url = "../star/forwardAdd.action";
	navTab.openTab("addstar", url, {title:"添加明星", fresh: false, data:{'name': value, 'nameHk': value}});
}

//------------------------------------------------------------------
/**
 * 初始化事件绑定
 */
function initEventListener()
{
	//最新添加
//	$(document).on('click', '#starring_box #btnAddStarring3', addStarring3);
//	
//	$(document).on('click', '#directory_box #btnAddDirector', addDirector);
//	$(document).on('click', '#directory_box2 #btnAddDirector2', addDirector2);//视频中的导演非必填
//	$(document).on('click', '#directory_box3 #btnAddDirector3', addDirector3);//视频中的体育频道人员
//	$(document).on('click', '#starring_box2 #btnAddStarring2', addStarring2);//视频中的导演非必填
//	$(document).on('click', '.pageFormContent #btnAddStarring', addStarring);
//	$(document).on('click', '.pageFormContent #btnAddActor', addActor);
//	$(document).on('click', '.pageFormContent .cancelEditor', cancelEditor);
//	$(document).on('click', '#btnSavePersonnel', savePersonnel);
//	$(document).on('click', '.directorBox .editPeronnelList', editPeronnelList);
//	$(document).on('click', '.directorBox .removePeronnelList', removePeronnelList);
//	$(document).on('blur', '#Peditor #editor_name', onBlurCheck);
//	$(document).on('click', '#originator_box #btnAddOriginator', addOriginator);
//	$(document).on('click', '#actorPlay_box #btnAddActorPlay', addActorPlay);
//	$(document).on('click', '#singer_box #btnAddSinger', addSinger);
//	$(document).on('click', '#compere_box #btnAddCompere', addCompere);
//	$(document).on('click', '#guest_box #btnAddGuest', addGuest);
//	$(document).on('click', '#instructor_box #btnAddInstructor', addInstructor);
//	$(document).on('click', '#startringPlay_box #btnAddStartringPlay', addStartringPlay);
//	$(document).on('click', '#supervise_box #btnAddSupervise', addSupervise);
//	$(document).on('click', '.pageFormContent #btnAddCast', addCast);
//	$(document).on('click', '#btnSavePersonnel2', savePersonnel2);
//	
//	$(document).on('click', '#singer2_box #btnAddSinger2', addSinger2);//音频中的编曲
//	$(document).on('click', '#arranger_box #btnAddArranger', addArranger);//音频中的编曲
//	$(document).on('click', '#authors_box #btnAddAuthors', addAuthors);//音频中的作词
//	$(document).on('click', '#compose_box #btnAddCompose', addCompose);//音频中的作曲
//	
//	$(document).on('click', '#btnAddLink', btnAddLink);//增加链接
//	$(document).on('click', '#btnSaveLink', btnSaveLink);//增加链接
//	$(document).on('click', '.cancelEditor', cancelEditor);
	
	//去掉对应的box绑定
	$(document).on('click', '#btnAddStarring3', addStarring3);
	
	$(document).on('click', '#btnAddDirector', addDirector);
	$(document).on('click', '#btnAddDirector2', addDirector2);//视频中的导演非必填
	$(document).on('click', '#directory_box3 #btnAddDirector3', addDirector3);//视频中的体育频道人员
	$(document).on('click', '#starring_box2 #btnAddStarring2', addStarring2);//视频中的导演非必填
	$(document).on('click', '.pageFormContent #btnAddStarring', addStarring);
	$(document).on('click', '.pageFormContent #btnAddActor', addActor);
	$(document).on('click', '.pageFormContent .cancelEditor', cancelEditor);
	$(document).on('click', '#btnSavePersonnel', savePersonnel);
	$(document).on('click', '.directorBox .editPeronnelList', editPeronnelList);
	$(document).on('click', '.directorBox .removePeronnelList', removePeronnelList);
	$(document).on('blur', '#Peditor #editor_name', onBlurCheck);
	$(document).on('click', '#btnAddOriginator', addOriginator);
	$(document).on('click', '#btnAddActorPlay', addActorPlay);
	$(document).on('click', '#singer_box #btnAddSinger', addSinger);
	$(document).on('click', '#btnAddCompere', addCompere);
	$(document).on('click', '#btnAddGuest', addGuest);
	$(document).on('click', '#btnAddInstructor', addInstructor);
	$(document).on('click', '#btnAddStartringPlay', addStartringPlay);
	$(document).on('click', '#btnAddSupervise', addSupervise);
	$(document).on('click', '.pageFormContent #btnAddCast', addCast);
	$(document).on('click', '#btnSavePersonnel2', savePersonnel2);
	
	$(document).on('click', '#singer2_box #btnAddSinger2', addSinger2);//音频中的编曲
	$(document).on('click', '#arranger_box #btnAddArranger', addArranger);//音频中的编曲
	$(document).on('click', '#authors_box #btnAddAuthors', addAuthors);//音频中的作词
	$(document).on('click', '#compose_box #btnAddCompose', addCompose);//音频中的作曲
	
	$(document).on('click', '#btnAddLink', btnAddLink);//增加链接
	$(document).on('click', '#btnSaveLink', btnSaveLink);//增加链接
	$(document).on('click', '.cancelEditor', cancelEditor);
	
	$(document).on('click', '#actorPlay_box a.btnDel', function(){
		var $btnDel = $(this);
		if ($btnDel.is("[href^=javascript:]"))
		{
			$btnDel.parents("tr:first").remove();
			return false;
		}
		
		return false;
	});
	$(document).on('click', '#guest_box a.btnDel', function(){
		var $btnDel = $(this);
		if ($btnDel.is("[href^=javascript:]"))
		{
			$btnDel.parents("tr:first").remove();
			return false;
		}
		
		return false;
	});
	$(document).on('click', '#singer_box a.btnDel', function(){
		var $btnDel = $(this);
		if ($btnDel.is("[href^=javascript:]"))
		{
			$btnDel.parents("tr:first").remove();
			return false;
		}
		
		return false;
	});
	$(document).on('click', '#directory_box a.btnDel', function(){
		var $btnDel = $(this);
		if ($btnDel.is("[href^=javascript:]"))
		{
			$btnDel.parents("tr:first").remove();
			return false;
		}
		
		return false;
	});
	$(document).on('click', '#directory_box2 a.btnDel', function(){
		var $btnDel = $(this);
		if ($btnDel.is("[href^=javascript:]"))
		{
			$btnDel.parents("tr:first").remove();
			return false;
		}
		
		return false;
	});
	$(document).on('click', '#directory_box3 a.btnDel', function(){
		var $btnDel = $(this);
		if ($btnDel.is("[href^=javascript:]"))
		{
			$btnDel.parents("tr:first").remove();
			return false;
		}
		
		return false;
	});
	$(document).on('click', '#originator_box a.btnDel', function(){
		var $btnDel = $(this);
		if ($btnDel.is("[href^=javascript:]"))
		{
			$btnDel.parents("tr:first").remove();
			return false;
		}
		
		return false;
	});
	$(document).on('click', '#instructor_box a.btnDel', function(){
		var $btnDel = $(this);
		if ($btnDel.is("[href^=javascript:]"))
		{
			$btnDel.parents("tr:first").remove();
			return false;
		}
		
		return false;
	});
	$(document).on('click', '#compere_box a.btnDel', function(){
		var $btnDel = $(this);
		if ($btnDel.is("[href^=javascript:]"))
		{
			$btnDel.parents("tr:first").remove();
			return false;
		}
		
		return false;
	});
	$(document).on('click', '#supervise_box a.btnDel', function(){
		var $btnDel = $(this);
		if ($btnDel.is("[href^=javascript:]"))
		{
			$btnDel.parents("tr:first").remove();
			return false;
		}
		
		return false;
	});
	$(document).on('click', '#startringPlay_box a.btnDel', function(){
		var $btnDel = $(this);
		if ($btnDel.is("[href^=javascript:]"))
		{
			$btnDel.parents("tr:first").remove();
			return false;
		}
		
		return false;
	});
	$(document).on('click', '#starring_box a.btnDel', function(){
		var $btnDel = $(this);
		if ($btnDel.is("[href^=javascript:]"))
		{
			$btnDel.parents("tr:first").remove();
			return false;
		}
		
		return false;
	});
	$(document).on('click', '.moveUpContent', function(e){
		var $this = $(e.currentTarget);
        var $currentTR = $this.parent().parent(), $prevTR = $currentTR.prev();
        if (0 == $currentTR.index()) {
            alertMsg.info('已经到达第一行了');
            return false;
        }
        $currentTR.insertBefore($prevTR);
	});
	$(document).on('click', '.moveDownContent', function(e){
		var $this = $(e.currentTarget);
		var $currentTR = $this.parent().parent(), $nextTR = $currentTR.next(), trCount = $currentTR.siblings().length;
        if (trCount == $currentTR.index()) {
            alertMsg.info('已经到达最后一行');
            return false;
        }
        $currentTR.insertAfter($nextTR);
	});
	$(document).on('click', '.directorBox a.selfMoveUp', function(e){
		var $box = navTab.getCurrentPanel();
        var $this = $(e.currentTarget);
        var $currentDIV = $this.parents('.directorBox'), $prevDIV = $currentDIV.prev(), $firstDIV = $box.find('.directorBox:first');
        if ($firstDIV.is($currentDIV)) {
            alertMsg.info('已经到达第一行了');
            return false;
        }
        $currentDIV.insertBefore($prevDIV);
	});
	$(document).on('click', '.directorBox a.selfMoveDown', function(e){
		var $box = navTab.getCurrentPanel();
        var $this = $(e.currentTarget);
        var $currentDIV = $this.parents('.directorBox'), $nextDIV = $currentDIV.next(), $lastDIV = $box.find('.directorBox:last');
        if ($lastDIV.is($currentDIV)) {
            alertMsg.info('已经到达最后一行了');
            return false;
        }
        $currentDIV.insertAfter($nextDIV);
	});
}

/**
 * 检查人员是否存在明星库
 */
function onBlurCheck()
{
//	var $elm = $(this), $editor = $('#Peditor', navTab.getCurrentPanel()), $name = $elm.val();
//	if($name == '')
//	{
//		return false;
//	}
//
//	var $callback = function(data){
//		$editor.find('.starNotExist').remove();
//		if (!data.data.isExist)
//		{
//			//不在明星库
//			$elm.parent().find('input[type="hidden"]').val('');
//			$editor.prepend('<div class="starNotExist"><font color="red">'+$name+'不在明星库中</font> <a href="javascript:;" onclick="javascript:addStar(\''+$name+'\');"  >点击将'+$name+'添加到明星库中</a></div>');
//		}
//	};
//	
//	$.get('../star/starIsExist.action?starName=' + encodeURIComponent($name), $callback, 'json');
}


/**
 * 增加歌手  专辑中
 */
function addStarring3(){
	var $box = navTab.getCurrentPanel();
	var $directory_box = $('#starring_box', $box);
	var $lastTr = $directory_box.find(".unitBox:last");
	if(!$lastTr.find('input[type="hidden"]').val())
	{
		return false;
	}
	var $row = $('<tr class="unitBox"><td><input type="hidden" name="starrings.id"><input onblur="onblurs(this,this.value)" type="text" name="starrings.key" autocomplete="off" lookupgroup="starrings" suggesturl="../search/getStarsBySuggest.action" suggestfields="key" postfield="str" class="required textInput valid"></td><td><a href="javascript:;" class="btnDel">删除</a><a href="javascript:;" class="moveUpContent">上移</a> <a href="javascript:;" class="moveDownContent">下移</a></td></tr>');
	$directory_box.append($row);
	
	$directory_box.find("a.btnDel").click(function(){
		var $btnDel = $(this);
		
		if ($btnDel.is("[href^=javascript:]")){
			var $parentsTR = $btnDel.parents('#starring_box').find('tr');
			if ($parentsTR.length == 1) {
				addStarring3();
			}
			$btnDel.parents("tr:first").remove();
			return false;
		}

		return false;
	});
	
	$("input[suggestFields]", $directory_box).suggest();
}

/**
 * 增加导演
 */
function addDirector()
{
	var $box = navTab.getCurrentPanel();
	var $directory_box = $('#directory_box', $box);
	var $lastTr = $directory_box.find(".unitBox:last");
	if(!$lastTr.find('input[type="hidden"]').val())
	{
		return false;
	}
	var $row = $('<tr class="unitBox"><td><input type="hidden" name="directorys.id"><input onblur="onblurs(this,this.value)" type="text" name="directorys.key" autocomplete="off" lookupgroup="directorys" suggesturl="../search/getStarsBySuggest.action" suggestfields="key" postfield="str" class="required textInput valid"></td><td><a href="javascript:;" class="btnDel">删除</a><a href="javascript:;" class="moveUpContent">上移</a> <a href="javascript:;" class="moveDownContent">下移</a></td></tr>');
	$directory_box.append($row);
	
	$directory_box.find("a.btnDel").click(function(){
		var $btnDel = $(this);
		
		if ($btnDel.is("[href^=javascript:]")){
			var $parentsTR = $btnDel.parents('#directory_box').find('tr');
			if ($parentsTR.length == 1){
				addDirector();
			}
			$btnDel.parents("tr:first").remove();
			return false;
		}

		return false;
	});
	
	$("input[suggestFields]", $directory_box).suggest();
}
/**
 * 增加导演视频中
 */
function addDirector2()
{
	var $box = navTab.getCurrentPanel();
	var $directory_box = $('#directory_box2', $box);
	var $lastTr = $directory_box.find(".unitBox:last");
	if(!$lastTr.find('input[type="hidden"]').val())
	{
		return false;
	}
	var $row = $('<tr class="unitBox"><td><input type="hidden" name="directorys.id"><input onblur="onblurs(this,this.value)" type="text" name="directorys.key" autocomplete="off" lookupgroup="directorys" suggesturl="../search/getStarsBySuggest.action" suggestfields="key" postfield="str" class="textInput"></td><td><a href="javascript:;" class="btnDel">删除</a><a href="javascript:;" class="moveUpContent">上移</a> <a href="javascript:;" class="moveDownContent">下移</a></td></tr>');
	$directory_box.append($row);
	
	$directory_box.find("a.btnDel").click(function(){
		var $btnDel = $(this);
		
		if ($btnDel.is("[href^=javascript:]")){
			var $parentsTR = $btnDel.parents('#directory_box2').find('tr');
			if ($parentsTR.length == 1) {
				addDirector2();
			}
			$btnDel.parents("tr:first").remove();
			return false;
		}
		
		return false;
	});
	
	$("input[suggestFields]", $directory_box).suggest();
}

/**
 * 增加体育频道人员视频中
 */
function addDirector3()
{
	var $box = navTab.getCurrentPanel();
	var $directory_box = $('#directory_box3', $box);
	var $lastTr = $directory_box.find(".unitBox:last");
	if(!$lastTr.find('input[type="hidden"]').val())
	{
		return false;
	}
	var $row = $('<tr class="unitBox"><td><input type="hidden" name="directorys.id"><input  type="text" name="directorys.key" autocomplete="off" lookupgroup="directorys" suggesturl="../player/getPlayerBySuggest.action" suggestfields="key" postfield="str" class="textInput"></td><td><a href="javascript:;" class="btnDel">删除</a><a href="javascript:;" class="moveUpContent">上移</a> <a href="javascript:;" class="moveDownContent">下移</a></td></tr>');
	$directory_box.append($row);
	
	$directory_box.find("a.btnDel").click(function(){
		var $btnDel = $(this);
		
		if ($btnDel.is("[href^=javascript:]")){
			var $parentsTR = $btnDel.parents('#directory_box3').find('tr');
			if ($parentsTR.length == 1) {
				addDirector3();
			}
			$btnDel.parents("tr:first").remove();
			return false;
		}
		
		return false;
	});
	
	$("input[suggestFields]", $directory_box).suggest();
}

/**
 * 增加演员视频中
 */
function addStarring2()
{
	var $box = navTab.getCurrentPanel();
	var $directory_box = $('#starring_box2', $box);
	var $lastTr = $directory_box.find(".unitBox:last");
	if(!$lastTr.find('input[type="hidden"]').val())
	{
		return false;
	}
	var $row = $('<tr class="unitBox"><td><input type="hidden" name="starring.id"><input onblur="onblurs(this,this.value)" type="text" name="starring.key" autocomplete="off" lookupgroup="starring" suggesturl="../search/getStarsBySuggest.action" suggestfields="key" postfield="str" class="textInput"></td><td><a href="javascript:;" class="btnDel">删除</a><a href="javascript:;" class="moveUpContent">上移</a> <a href="javascript:;" class="moveDownContent">下移</a></td></tr>');
	$directory_box.append($row);
	
	$directory_box.find("a.btnDel").click(function(){
		var $btnDel = $(this);
		
		if ($btnDel.is("[href^=javascript:]")){
			var $parentsTR = $btnDel.parents('#starring_box2').find('tr');
			if ($parentsTR.length == 1) {
				addStarring2();
			}
			$btnDel.parents("tr:first").remove();
			return false;
		}
		
		return false;
	});
	
	$("input[suggestFields]", $directory_box).suggest();
}
/**
 * 增加原创
 */
function addOriginator()
{
	var $directory_box = $('#originator_box', navTab.getCurrentPanel());
	var $lastTr = $directory_box.find(".unitBox:last");
	if(!$lastTr.find('input[type="hidden"]').val())
	{
		return false;
	}
	var $row = $('<tr class="unitBox"><td><input type="hidden" name="originator.id"><input onblur="onblurs(this,this.value)" type="text" name="originator.key" autocomplete="off" lookupgroup="originator" suggesturl="../search/getStarsBySuggest.action" suggestfields="key" postfield="str" class="textInput"></td><td><a href="javascript:;" class="btnDel">删除</a><a href="javascript:;" class="moveUpContent">上移</a> <a href="javascript:;" class="moveDownContent">下移</a></td></tr>');
	$directory_box.append($row);
	
	$directory_box.find("a.btnDel").click(function(){
		var $btnDel = $(this);
		
		if ($btnDel.is("[href^=javascript:]")){
			var $parentsTR = $btnDel.parents('#originator_box').find('tr');
			if ($parentsTR.length == 1) {
				addOriginator();
			}
			$btnDel.parents("tr:first").remove();
			return false;
		}
		
		return false;
	});
	
	$("input[suggestFields]", $directory_box).suggest();
}
/**
 * 增加演员参与人
 */
function addActorPlay()
{
	var $directory_box = $('#actorPlay_box', navTab.getCurrentPanel());
	var $lastTr = $directory_box.find(".unitBox:last");
	if(!$lastTr.find('input[type="hidden"]').val())
	{
		return false;
	}
	var $row = $('<tr class="unitBox"><td><input type="text" class="textInput" name="actorPlay"></td><td><a href="javascript:;" class="btnDel">删除</a><a href="javascript:;" class="moveUpContent">上移</a> <a href="javascript:;" class="moveDownContent">下移</a></td></tr>');
	$directory_box.append($row);
	
	$directory_box.find("a.btnDel").click(function(){
		var $btnDel = $(this);
		
		if ($btnDel.is("[href^=javascript:]")){
			var $parentsTR = $btnDel.parents('#actorPlay_box').find('tr');
			if ($parentsTR.length == 1) {
				addActorPlay();
			}
			$btnDel.parents("tr:first").remove();
			return false;
		}
		
		return false;
	});
	
	
}
/**
 * 增加歌手
 */
function addSinger()
{
	var $box = navTab.getCurrentPanel();
	var $directory_box = $('#singer_box', $box);
	var $lastTr = $directory_box.find(".unitBox:last");
	if(!$lastTr.find('input[type="hidden"]').val())
	{
		return false;
	}
	var $row = $('<tr class="unitBox"><td><input type="text" class="textInput" name="singer"></td><td><a href="javascript:;" class="btnDel">删除</a><a href="javascript:;" class="moveUpContent">上移</a> <a href="javascript:;" class="moveDownContent">下移</a></td></tr>');
	$directory_box.append($row);
	
	$directory_box.find("a.btnDel").click(function(){
		var $btnDel = $(this);
		
		if ($btnDel.is("[href^=javascript:]")){
			var $parentsTR = $btnDel.parents('#singer_box').find('tr');
			if ($parentsTR.length == 1) {
				addSinger();
			}
			$btnDel.parents("tr:first").remove();
			return false;
		}
		
		return false;
	});
}

/**
 * 添加歌手 音频
 */
function addSinger2(){
	var $box = navTab.getCurrentPanel();
	var $directory_box = $('#singer2_box', $box);
	var $lastTr = $directory_box.find(".unitBox:last");
	if(!$lastTr.find('input[type="hidden"]').val())
	{
		return false;
	}
	var $row = $('<tr class="unitBox"><td><input type="hidden" name="singers.id"><input onblur="onblurs(this,this.value)" type="text" name="singers.key" autocomplete="off" lookupgroup="singers" suggesturl="../search/getStarsBySuggest.action" suggestfields="key" postfield="str" class="required textInput valid"></td><td><a href="javascript:;" class="btnDel">删除</a></td></tr>');
	$directory_box.append($row);
	
	$directory_box.find("a.btnDel").click(function(){
		var $btnDel = $(this);
		
		if ($btnDel.is("[href^=javascript:]")){
			$btnDel.parents("tr:first").remove();
			return false;
		}

		return false;
	});
	
	$("input[suggestFields]", $directory_box).suggest();
}

/**
 * 增加编曲
 */
function addArranger(){
	var $box = navTab.getCurrentPanel();
	var $directory_box = $('#arranger_box', $box);
	var $lastTr = $directory_box.find(".unitBox:last");
	if(!$lastTr.find('input[type="hidden"]').val())
	{
		return false;
	}
	var $row = $('<tr class="unitBox"><td><input type="hidden" name="arrangers.id"><input onblur="onblurs(this,this.value)" type="text" name="arrangers.key" autocomplete="off" lookupgroup="arrangers" suggesturl="../search/getStarsBySuggest.action" suggestfields="key" postfield="str" class="required textInput valid"></td><td><a href="javascript:;" class="btnDel">删除</a><a href="javascript:;" class="moveUpContent">上移</a> <a href="javascript:;" class="moveDownContent">下移</a></td></tr>');
	$directory_box.append($row);
	
	$directory_box.find("a.btnDel").click(function(){
		var $btnDel = $(this);
		
		if ($btnDel.is("[href^=javascript:]")){
			var $parentsTR = $btnDel.parents('#arranger_box').find('tr');
			if ($parentsTR.length == 1) {
				addArranger();
			}
			$btnDel.parents("tr:first").remove();
			return false;
		}

		return false;
	});
	
	$("input[suggestFields]", $directory_box).suggest();
}

/**
 * 增加作词
 */
function addAuthors(){
	var $box = navTab.getCurrentPanel();
	var $directory_box = $('#authors_box', $box);
	var $lastTr = $directory_box.find(".unitBox:last");
	if(!$lastTr.find('input[type="hidden"]').val())
	{
		return false;
	}
	var $row = $('<tr class="unitBox"><td><input type="hidden" name="authorss.id"><input onblur="onblurs(this,this.value)" type="text" name="authorss.key" autocomplete="off" lookupgroup="authorss" suggesturl="../search/getStarsBySuggest.action" suggestfields="key" postfield="str" class="required textInput valid"></td><td><a href="javascript:;" class="btnDel">删除</a><a href="javascript:;" class="moveUpContent">上移</a> <a href="javascript:;" class="moveDownContent">下移</a></td></tr>');
	$directory_box.append($row);
	
	$directory_box.find("a.btnDel").click(function(){
		var $btnDel = $(this);
		
		if ($btnDel.is("[href^=javascript:]")){
			var $parentsTR = $btnDel.parents('#authors_box').find('tr');
			if ($parentsTR.length == 1) {
				addAuthors();
			}
			$btnDel.parents("tr:first").remove();
			return false;
		}

		return false;
	});
	
	$("input[suggestFields]", $directory_box).suggest();
}

/**
 * 增加作曲
 */
function addCompose(){
	var $box = navTab.getCurrentPanel();
	var $directory_box = $('#compose_box', $box);
	var $lastTr = $directory_box.find(".unitBox:last");
	if(!$lastTr.find('input[type="hidden"]').val())
	{
		return false;
	}
	var $row = $('<tr class="unitBox"><td><input type="hidden" name="composes.id"><input onblur="onblurs(this,this.value)" type="text" name="composes.key" autocomplete="off" lookupgroup="composes" suggesturl="../search/getStarsBySuggest.action" suggestfields="key" postfield="str" class="required textInput valid"></td><td><a href="javascript:;" class="btnDel">删除</a><a href="javascript:;" class="moveUpContent">上移</a> <a href="javascript:;" class="moveDownContent">下移</a></td></tr>');
	$directory_box.append($row);
	
	$directory_box.find("a.btnDel").click(function(){
		var $btnDel = $(this);
		
		if ($btnDel.is("[href^=javascript:]")){
			var $parentsTR = $btnDel.parents('#compose_box').find('tr');
			if ($parentsTR.length == 1) {
				addCompose();
			}
			$btnDel.parents("tr:first").remove();
			return false;
		}

		return false;
	});
	
	$("input[suggestFields]", $directory_box).suggest();
}


/**
 * 增加人物
 */
function addStartringPlay()
{
	var $box = navTab.getCurrentPanel();
	var $directory_box = $('#startringPlay_box', $box);
	var $lastTr = $directory_box.find(".unitBox:last");
	if(!$lastTr.find('input[type="hidden"]').val())
	{
		return false;
	}
	var $row = $('<tr class="unitBox"><td><input type="text" class="textInput" name="startringPlay"></td><td><a href="javascript:;" class="btnDel">删除</a><a href="javascript:;" class="moveUpContent">上移</a> <a href="javascript:;" class="moveDownContent">下移</a></td></tr>');
	$directory_box.append($row);
	
	$directory_box.find("a.btnDel").click(function(){
		var $btnDel = $(this);
		
		if ($btnDel.is("[href^=javascript:]")){
			var $parentsTR = $btnDel.parents('#startringPlay_box').find('tr');
			if ($parentsTR.length == 1) {
				addStartringPlay();
			}
			$btnDel.parents("tr:first").remove();
			return false;
		}
		
		return false;
	});
}




/**
 * 增加主持人
 */
function addCompere()
{
	var $directory_box = $('#compere_box', navTab.getCurrentPanel());
	var $lastTr = $directory_box.find(".unitBox:last");
	if(!$lastTr.find('input[type="hidden"]').val())
	{
		return false;
	}
	var $row = $('<tr class="unitBox"><td><input type="hidden" name="compere.id"><input onblur="onblurs(this,this.value)" type="text" name="compere.key" autocomplete="off" lookupgroup="compere" suggesturl="../search/getStarsBySuggest.action" suggestfields="key" postfield="str" class="textInput"></td><td><a href="javascript:;" class="btnDel">删除</a><a href="javascript:;" class="moveUpContent">上移</a> <a href="javascript:;" class="moveDownContent">下移</a></td></tr>');
	$directory_box.append($row);
	$directory_box.find("a.btnDel").click(function(){
		var $btnDel = $(this);
		if ($btnDel.is("[href^=javascript:]")){
			var $parentsTR = $btnDel.parents('#compere_box').find('tr');
			if ($parentsTR.length == 1) {
				addCompere();
			}
			$btnDel.parents("tr:first").remove();
			return false;
		}
		return false;
	});
	
	$("input[suggestFields]", $directory_box).suggest();
}
/**
 * 增加嘉宾
 */
function addGuest()
{
	var $directory_box = $('#guest_box', navTab.getCurrentPanel());
	var $lastTr = $directory_box.find(".unitBox:last");
	if(!$lastTr.find('input[type="hidden"]').val())
	{
		return false;
	}
	var $row = $('<tr class="unitBox"><td><input type="hidden" name="guest.id"><input onblur="onblurs(this,this.value)" type="text" name="guest.key" autocomplete="off" lookupgroup="guest" suggesturl="../search/getStarsBySuggest.action" suggestfields="key" postfield="str" class="textInput"></td><td><a href="javascript:;" class="btnDel">删除</a><a href="javascript:;" class="moveUpContent">上移</a> <a href="javascript:;" class="moveDownContent">下移</a></td></tr>');
	$directory_box.append($row);
	$directory_box.find("a.btnDel").click(function(){
		var $btnDel = $(this);
		if ($btnDel.is("[href^=javascript:]")){
			var $parentsTR = $btnDel.parents('#guest_box').find('tr');
			if ($parentsTR.length == 1) {
				addGuest();
			}
			$btnDel.parents("tr:first").remove();
			return false;
		}
		return false;
	});
	
	$("input[suggestFields]", $directory_box).suggest();
}
/**
 * 增加讲师
 */
function addInstructor()
{
	var $directory_box = $('#instructor_box', navTab.getCurrentPanel());
	var $lastTr = $directory_box.find(".unitBox:last");
	if(!$lastTr.find('input[type="hidden"]').val())
	{
		return false;
	}
	var $row = $('<tr class="unitBox"><td><input type="hidden" name="instructor.id"><input onblur="onblurs(this,this.value)" type="text" name="instructor.key" autocomplete="off" lookupgroup="instructor" suggesturl="../search/getStarsBySuggest.action" suggestfields="key" postfield="str" class="textInput"></td><td><a href="javascript:;" class="btnDel">删除</a><a href="javascript:;" class="moveUpContent">上移</a> <a href="javascript:;" class="moveDownContent">下移</a></td></tr>');
	$directory_box.append($row);
	
	$directory_box.find("a.btnDel").click(function(){
		var $btnDel = $(this);
		if ($btnDel.is("[href^=javascript:]")){
			var $parentsTR = $btnDel.parents('#instructor_box').find('tr');
			if ($parentsTR.length == 1) {
				addInstructor();
			}
			$btnDel.parents("tr:first").remove();
			return false;
		}
		return false;
	});
	
	$("input[suggestFields]", $directory_box).suggest();
}
/**
 * 增加监督
 */
function addSupervise()
{
	var $directory_box = $('#supervise_box', navTab.getCurrentPanel());
	var $lastTr = $directory_box.find(".unitBox:last");
	if(!$lastTr.find('input[type="hidden"]').val())
	{
		return false;
	}
	var $row = $('<tr class="unitBox"><td><input type="hidden" name="supervise.id"><input onblur="onblurs(this,this.value)" type="text" name="supervise.key" autocomplete="off" lookupgroup="supervise" suggesturl="../search/getStarsBySuggest.action" suggestfields="key" postfield="str" class="textInput"></td><td><a href="javascript:;" class="btnDel">删除</a><a href="javascript:;" class="moveUpContent">上移</a> <a href="javascript:;" class="moveDownContent">下移</a></td></tr>');
	$directory_box.append($row);
	
	$directory_box.find("a.btnDel").click(function(){
		var $btnDel = $(this);
		if ($btnDel.is("[href^=javascript:]")){
			var $parentsTR = $btnDel.parents('#supervise_box').find('tr');
			if ($parentsTR.length == 1) {
				addSupervise();
			}
			$btnDel.parents("tr:first").remove();
			return false;
		}
		return false;
	});
	
	$("input[suggestFields]", $directory_box).suggest();
}

/**
 * 增加主演
 */
function addStarring()
{
	var $this = $(this).parent(), $editor = $('#Peditor', navTab.getCurrentPanel());
	
	cancelEditor();
	
	$editor.attr('flag', 'starring');
	$editor.insertAfter($this);
	$editor.show();
}


/**
 * 增加链接
 */
function btnAddLink()
{
	var $this = $(this).parent(), $editor = $('#Peditor', navTab.getCurrentPanel());
    
	cancelEditor();
	
	$editor.attr('flag', 'link');
	
	$editor.insertAfter($this);
	$editor.show();
}
/**
 * 增加声优
 */
function addCast()
{
	var $this = $(this).parent(), $editor = $('#Peditor', navTab.getCurrentPanel());
	
	cancelEditor();
	
	$editor.attr('flag', 'cast');
	$editor.insertAfter($this);
	$editor.show();
}

/**
 * 添加演员
 */
function addActor()
{
	var $this = $(this).parent(), $editor = $('#Peditor', navTab.getCurrentPanel());
	
	cancelEditor();
	
	$editor.attr('flag', 'actor');
	$editor.show();
	$editor.insertAfter($this);
}

/**
 * 取消编辑
 */
function cancelEditor()
{   
	var $editor = $('#Peditor', navTab.getCurrentPanel());
	$editor.find('input').val('');
	$editor.find('textarea').val('');
	$editor.find('textarea').val('');
	$editor.find('#album_dingPic img:first').attr('src', 'http://img1.c3.letv.com/ptv/letv_vrs/2011/7/star/de45d22dd3064d8da3863ad9032d2406.jpg');
	$editor.hide();
	
	if(window.tempElement)
	{
		window.tempElement = null;
	}
}

/**
 * 保存临时人员信息
 */
function savePersonnel()
{
	if(!addValidate())
	{
		return false;
	}

	_mkPersonnelList();
	
	if(window.tempElement)
	{
		window.tempElement.remove();
		window.tempElement = null;
	}
	
	cancelEditor();
}

/**
 * 保存临时人员信息
 */
function savePersonnel2()
{
	if(!addValidate())
	{
		return false;
	}

	_mkPersonnelList2();
	
	if(window.tempElement)
	{
		window.tempElement.remove();
		window.tempElement = null;
	}
	
	cancelEditor();
}


/**
 * 保存网址信息
 */
function btnSaveLink()
{
	if(!addValidate())
	{
		return false;
	}

	_mkLinkList();
	
	if(window.tempElement)
	{
		window.tempElement.remove();
		window.tempElement = null;
	}
	
	cancelEditor();
}
/**
 * 修改人员信息
 */
function editPeronnelList()
{
	
	var $box = navTab.getCurrentPanel();
	var $currentTr = $(this, $box).parents('.directorBox'), $editor = $('#Peditor', $box), flag = $currentTr.attr('flag') || $editor.attr('flag');
	window.tempElement = $currentTr;
	var dzz_src, editor_id, editor_key, editor_role, editor_desc;
	flag = $('#Peditor', navTab.getCurrentPanel()).attr('flag');
	
	if(flag == 'actor')
	{
		dzz_src = $currentTr.find('.edit input[name="actorPlayPicSome"]').val();
		editor_id = $currentTr.find('.edit input[name="actors.id"]').val();
		editor_key = $currentTr.find('.edit input[name="actors.key"]').val();
		editor_role = $currentTr.find('.edit input[name="actorPlaySome"]').val();
		editor_desc = $currentTr.find('.edit input[name="actorDescSome"]').val();
	}
	else if(flag == 'starring')
	{
		dzz_src = $currentTr.find('.edit input[name="starringPlayPicSome"]').val();
		editor_id = $currentTr.find('.edit input[name="starrings.id"]').val();
		editor_key = $currentTr.find('.edit input[name="starrings.key"]').val();
		editor_role = $currentTr.find('.edit input[name="starringPlaySome"]').val();
		editor_desc = $currentTr.find('.edit input[name="starringDescSome"]').val();
	}
	else if(flag == 'cast')
	{
		editor_id = $currentTr.find('.edit input[name="cast.id"]').val();
		editor_key = $currentTr.find('.edit input[name="cast.key"]').val();
		editor_role = $currentTr.find('.edit input[name="dubSome"]').val();
	}
	else if(flag == 'link' || $currentTr.attr('flag') == 'link')
	{
		editor_key = $currentTr.find('.edit input[name="starrings.key"]').val();
		editor_role = $currentTr.find('.edit input[name="starringPlaySome"]').val();
		dzz_src = $currentTr.find('.edit input[name="starringPlayPicSome"]').val();
	}
	
	// 编辑器赋值
	$editor.attr('flag', flag);
	$editor.find('.dzz img').attr('src', dzz_src);
	$editor.find('.edit input[name="editor.id"]').val(editor_id);
	$editor.find('.edit input[name="editor.key"]').val(editor_key);
	$editor.find('.edit input[name="editor.role"]').val(editor_role);
	$editor.find('.edit textarea[name="editor.desc"]').val(editor_desc);
	$editor.find('.upload input[name="edit_dzz_url"]').val(dzz_src);
	$editor.show();
	$editor.insertBefore($currentTr);
}

/**
 * 删除一条人员记录
 */
function removePeronnelList()
{
	var $currentTr = $(this, navTab.getCurrentPanel()).parents('.directorBox');
	
	$currentTr.remove();
}

/**
 * 生成链接数据(add)
 */
function _mkLinkList()
{
	var _html = '',
		$editor = $('#Peditor', navTab.getCurrentPanel()),
		flag = $editor.attr('flag'),
		dzzurl = $editor.find('input[name="edit_dzz_url"]').val() || 'http://img1.c3.letv.com/ptv/letv_vrs/2011/7/star/de45d22dd3064d8da3863ad9032d2406.jpg',
		editor_key = $editor.find('input[name="editor.key"]').val(),
		editor_role = $editor.find('input[name="editor.role"]').val();
	$editor.attr('flag','link');
	// 不同的栏目需要的不同字段
	var fields = {
		'link': {
			'starrings.key': editor_key,
			'starringPlaySome': editor_role,
			'starringPlayPicSome': dzzurl
		}
	
	};
	var currentField = fields['link'];
	
	_html += '<div class="directorBox" flag="'+flag+'">';
	_html += '<div class="dzz"><img style="width:100px;height:100px" src="{dzzurl}" /></div>';
	_html += '<div class="desc">';
	_html += '	<p>标题：{Star}</p>';
	_html += '	<p>网址：{editor_role}</p>';
	_html += '</div>';
	_html += '<div class="edit">';
	_html += '	<p>';
	_html += '		<a class="button editPeronnelList" href="javascript:;"><span>编辑</span></a>';
	_html += '		<a class="button removePeronnelList" href="javascript:;"><span>删除</span></a>';
	
	for(var field in currentField)
	{
		_html += '	<input type="hidden" name="'+ field +'" value="'+ currentField[field] +'" />';
	}
	
	_html += '	</p>';
	_html += '</div>';
	_html += '</div>';
	
	_html = _html.replace(/{dzzurl}/g, dzzurl).replace(/{Star}/g, editor_key).replace(/{editor_role}/g, editor_role);
	_html = $(_html);
	$lastDirectorBox =  $('div[class=directorBox]:last', navTab.getCurrentPanel());
	if ($lastDirectorBox.length == 0) {
		$editor.after(_html);
	} else {
		if(window.tempElement){
			window.tempElement.replaceWith(_html);
			window.tempElement = null;
		}else{
			$lastDirectorBox.after(_html);
		}
	}
	
}

/**
 * 生成人员数据(add)
 */
function _mkPersonnelList()
{
	var _html = '',
		$editor = $('#Peditor', navTab.getCurrentPanel()),
		flag = $editor.attr('flag'),
		dzzurl = $editor.find('input[name="edit_dzz_url"]').val() || 'http://img1.c3.letv.com/ptv/letv_vrs/2011/7/star/de45d22dd3064d8da3863ad9032d2406.jpg',
		editor_id = $editor.find('input[name="editor.id"]').val(),
		editor_key = $editor.find('input[name="editor.key"]').val(),
		editor_role = $editor.find('input[name="editor.role"]').val()||'无',
		editor_desc = $editor.find('textarea[name="editor.desc"]').val();
	
	// 不同的栏目需要的不同字段
	var fields = {
		'actor': {
			'actors.id': editor_id,
			'actors.key': editor_key,
			'actorPlaySome': editor_role,
			'actorDescSome': editor_desc,
			'actorPlayPicSome': dzzurl
		},
		'starring': {
			'starrings.id': editor_id,
			'starrings.key': editor_key,
			'starringPlaySome': editor_role,
			'starringDescSome': editor_desc,
			'starringPlayPicSome': dzzurl
		}
	
	};
	var currentField = fields[flag];
	
	_html += '<div class="directorBox" flag="'+flag+'">';
	_html += '<div class="dzz"><img src="{dzzurl}" /></div>';
	_html += '<div class="desc">';
	_html += '	<p><a target="_blank" href="http://so.letv.com/star?wd={Star}">{Star}</a>　饰　{Role}</p>';
	_html += '	<p>{description}</p>';
	_html += '</div>';
	_html += '<div class="edit">';
	_html += '	<p>';
	_html += '		<a class="button editPeronnelList" href="javascript:;"><span>编辑</span></a>';
	_html += '		<a class="button removePeronnelList" href="javascript:;"><span>删除</span></a>';
	_html += '      <a class="button selfMoveUp" href="javascript:;"><span>上移</span></a>';
	_html += '      <a class="button selfMoveDown" href="javascript:;"><span>下移</span></a>';
	
	for(var field in currentField)
	{
		_html += '	<input type="hidden" name="'+ field +'" value="'+ currentField[field] +'" />';
	}
	
	_html += '	</p>';
	_html += '</div>';
	_html += '</div>';
	
	_html = _html.replace(/{dzzurl}/g, dzzurl).replace(/{Star}/g, editor_key).replace(/{Role}/g, editor_role).replace(/{description}/g, editor_desc).replace(/{editor_id}/g, editor_id);
	_html = $(_html);
	$lastDirectorBox =  $('div[class=directorBox]:last', navTab.getCurrentPanel());
	if ($lastDirectorBox.length == 0) {
		$editor.after(_html);
	} else {
		if(window.tempElement){
			window.tempElement.replaceWith(_html);
			window.tempElement = null;
		}else{
			$lastDirectorBox.after(_html);
		}
	}
}
/**
 * 生成人员数据(add)
 */
function _mkPersonnelList2()
{
	var _html = '',
	$editor = $('#Peditor', navTab.getCurrentPanel()),
	flag = $editor.attr('flag'),
	editor_id = $editor.find('input[name="editor.id"]').val(),
	editor_key = $editor.find('input[name="editor.key"]').val(),
	editor_role = $editor.find('input[name="editor.role"]').val()||'无';
	
	// 不同的栏目需要的不同字段
	var fields = {
			'cast': {
				'cast.id': editor_id,
				'cast.key': editor_key,
				'dubSome': editor_role
			}
	};
	var currentField = fields[flag];
	
	_html += '<div class="directorBox" flag="'+flag+'" style="height:40px;">';
	_html += '<div class="desc">';
	_html += '	<p><a target="_blank" href="http://so.letv.com/star?wd={Star}">{Star}</a>　配音　{Role}</p>';
	_html += '</div>';
	_html += '<div style="float:right;" class="edit">';
	_html += '	<p>';
	_html += '		<a class="button editPeronnelList" href="javascript:;"><span>编辑</span></a>';
	_html += '		<a class="button removePeronnelList" href="javascript:;"><span>删除</span></a>';
	_html += '      <a class="button selfMoveUp" href="javascript:;"><span>上移</span></a>';
	_html += '      <a class="button selfMoveDown" href="javascript:;"><span>下移</span></a>';
	
	for(var field in currentField)
	{
		_html += '	<input type="hidden" name="'+ field +'" value="'+ currentField[field] +'" />';
	}
	
	_html += '	</p>';
	_html += '</div>';
	_html += '</div>';
	_html = _html.replace(/{Star}/g, editor_key).replace(/{Role}/g, editor_role);

	_html = $(_html);
	$editor.after(_html);
}

/**
 * 人员编辑器验证
 */
function addValidate()
{
	var $editor = $('#Peditor', navTab.getCurrentPanel());
	/*if(!$editor.find('input[name="editor.key"]').val() || !$editor.find('input[name="editor.id"]').val())
	{
		alertMsg.warn('姓名不完整');
		return false;
	}*/
	
	return true;
}

$(function(){
	initEventListener();
});