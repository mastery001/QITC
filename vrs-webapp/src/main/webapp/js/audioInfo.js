/**
*专辑音频管理, 每新打开一个tab页就会执行一次
*/
$(document).ready(function() {
    var audioInfo = {
        init: function(){
        	var $box = navTab.getCurrentPanel();
            this._initDom();
            if ($box.data("inited")) {
            	return; // 如果已经此tab页面已经初始化过的话，就不初始化事件了， 防止一个控件被绑定多个事件
            }
            this._initEvent();
            $box.data("inited", true);
        },
        _initDom: function(){
            this.$doc = $(document);
        },
        _initEvent: function(){
        	var $box = navTab.getCurrentPanel();
//        	$(".addAudio",$box).click($.proxy(this._addRow, this));// 反复打开同一个tab页就不起作用了，而下面是可以的，待研究！!!
        	$box.on('click', '.addAudio', $.proxy(this._addRow, this));
        	$box.on('click', '.addAudioAlbum', $.proxy(this._addAudioAlbumRow, this));
        	$box.on('click', '.addVideoMV', $.proxy(this._addVideoMV, this));
            $box.on('click', '.delAudio', function(e){
                this._delRow(e);
            }.bind(this));
            $box.on('click', '.moveUp', function(e){
                this._moveTrUp(e);
            }.bind(this));
            $box.on('click', '.moveDown', function(e){
                this._moveTrDown(e);
            }.bind(this));
            $box.on('click', '.changeAudioSubTab', function(e){
                this._changeDivDisplay(e);
            }.bind(this));
        },
        _addRow: function(){
        	var $box = navTab.getCurrentPanel();
            var $songId = $("input[name='phoneMusic.songId']",$box), // 可以允许为空,业务需要
            	$songName = $("input[name='phoneMusic.songName']",$box),
            	$singerName = $("input[name='phoneMusic.singerName']",$box),
            	$songType = $("select[name='songType'] option:selected",$box),
            	$desc = $("textarea[name='phoneMusic.desc']",$box);
            if ($songName.val().trim() == '' || $singerName.val().trim() == '') {
        		alertMsg.warn('请填写完整的信息！');
        		return false;
        	}
            var $tr = '<tr><td class="songId" align="center">'+$songId.val()+'</td><td align="center">'+$songName.val()+'</td><td align="center">'+$singerName.val()+'</td><td vals="' + $songType.val() + '"align="center">'+$songType.text()
            +'</td><td>' + $desc.val() + '</td><td align="center"><a class="btnDel delAudio" title="确定要删除吗?" href="javascript:;">删除</a> <a href="javascript:;" class="moveUp">上移</a> <a href="javascript:;" class="moveDown">下移</a></td></tr>',
            $lastTr = $(".audioTb tr:last", $box);
	 		if ($lastTr.length == 0) {
	 			$(".audioTb", $box).append($tr).initUI();
	 		} else {
	 			$lastTr.after($tr).initUI();
	 		}
	 		saveAudio();
        },
        _addAudioAlbumRow: function(){
        	var $box = navTab.getCurrentPanel();
            var $id = $("input[name='audioAlbum.id']",$box), // 可以允许为空,业务需要
            	$nameCn = $("input[name='audioAlbum.nameCn']",$box),
            	$artistName = $("input[name='audioAlbum.artist_name']",$box),
            	$desc = $("textarea[name='audioAlbum.desc']",$box);
            if ($nameCn.val().trim() == '' || $artistName.val().trim() == '') {
        		alertMsg.warn('请填写完整的信息！');
        		return false;
        	}
            var $tr = '<tr><td align="center">'+$id.val()+'</td><td align="center">'+$nameCn.val()+'</td><td align="center">'+$artistName.val()+'</td><td>'
            + $desc.val() + '</td><td align="center"><a class="btnDel delAudio" title="确定要删除吗?" href="javascript:;">删除</a> <a href="javascript:;" class="moveUp">上移</a> <a href="javascript:;" class="moveDown">下移</a></td></tr>',
            $lastTr = $(".audioAlbumTb tr:last", $box);
	 		if ($lastTr.length == 0) {
	 			$(".audioAlbumTb", $box).append($tr).initUI();
	 		} else {
	 			$lastTr.after($tr).initUI();
	 		}
        },
        _addVideoMV: function(){
        	var $box = navTab.getCurrentPanel();
            var $videoId = $("input[name='videoMV.videoId']",$box), // 可以允许为空,业务需要
            	$videoName = $("input[name='videoMV.videoName']",$box),
            	$singer = $("input[name='videoMV.singerName']",$box),
            	$videoType = $("select[name='videoTypes'] option:selected",$box),
            	$desc = $("textarea[name='videoMV.desc']",$box);
            if ($videoName.val().trim() == '') {
        		alertMsg.warn('请填写完整的信息！');
        		return false;
        	}
            var $tr = '<tr><td class="songId" align="center">'+$videoId.val()+'</td><td align="center">'+$videoName.val()+'</td><td align="center">'+$singer.val()+'</td><td vals="' + $videoType.val() + '"align="center">'+$videoType.text()
            +'</td><td>' + $desc.val() + '</td><td align="center"><a class="btnDel delAudio" title="确定要删除吗?" href="javascript:;">删除</a> <a href="javascript:;" class="moveUp">上移</a> <a href="javascript:;" class="moveDown">下移</a></td></tr>',
            $lastTr = $(".videoMVTb tr:last", $box);
	 		if ($lastTr.length == 0) {
	 			$(".videoMVTb", $box).append($tr).initUI();
	 		} else {
	 			$lastTr.after($tr).initUI();
	 		}
	 		saveAudio();
        },
        _delRow: function(e){
        	var $this = $(e.currentTarget);
        	$this.parent().parent().remove();
        },
        _moveTrUp: function(e) {
        	var $this = $(e.currentTarget);
            var $currentTR = $this.parent().parent(), $prevTR = $currentTR.prev();
            if (0 == $currentTR.index()) {
                alertMsg.info('已经到达第一行了');
                return false;
            }
            $currentTR.insertBefore($prevTR);
        },
        _moveTrDown: function(e) {
        	var $this = $(e.currentTarget);
            var $currentTR = $this.parent().parent(), $nextTR = $currentTR.next(), trCount = $currentTR.siblings().length;
            if (trCount == $currentTR.index()) {
                alertMsg.info('已经到达最后一行');
                return false;
            }
            $currentTR.insertAfter($nextTR);
        },
        _changeDivDisplay: function(e) {
        	var $box = navTab.getCurrentPanel();
        	var $this = $(e.currentTarget), thisVal = $this.val();
        	if (thisVal == 'audio') {
        		$("div[name='audioDiv']", $box).css('display', 'block');
        		$("div[name='audioAlbumDiv']", $box).css('display', 'none');
        		$("div[name='videoMVDiv']", $box).css('display', 'none');
        	} else if (thisVal == 'audioAlbum') {
        		$("div[name='audioAlbumDiv']", $box).css('display', 'block');
        		$("div[name='audioDiv']", $box).css('display', 'none');
        		$("div[name='videoMVDiv']", $box).css('display', 'none');
        	} else if (thisVal == 'videoMV') {
        		$("div[name='videoMVDiv']", $box).css('display', 'block');
        		$("div[name='audioAlbumDiv']", $box).css('display', 'none');
        		$("div[name='audioDiv']", $box).css('display', 'none');
        	}        	
        }
    };

    audioInfo.init();
    
});

// 保存音频信息
var saveAudio = function() {
	var $box = navTab.getCurrentPanel();
	var audio = getAudio(), audioAlbum = getAudioAlbum(), videoMV = getVideoMV();
	$("input[name='audioInfo']",$box).val(JSON.stringify({"audio":audio, "audioAlbum":audioAlbum, "videoMV":videoMV}));
};

// 拿到专辑对象
var getAudioAlbum = function() {
	var $box = navTab.getCurrentPanel();
	var $arraySong = [];
	$(".audioAlbumTb" ,$box).children("tr").each(function(){
		var $this = $(this);
		var each = {
				"id" : $this.children("td").eq(0).text().trim(),
				"nameCn" : $this.children("td").eq(1).text().trim(),
				"artistName" : $this.children("td").eq(2).text().trim(),
				"desc" : $this.children("td").eq(3).text().trim()
		};
		$arraySong.push(each);
	});
	return $arraySong;
};

// 拿到音频对象
var getAudio = function() {
	var $box = navTab.getCurrentPanel();
	var $arraySong = [];
	$(".audioTb", $box).children("tr").each(function() {
		var $this = $(this);
		var songTypeObj ={};
		songTypeObj[$this.children("td").eq(3).attr("vals")] = $this.children("td").eq(3).text().trim();
		var each = {
			"id" : $this.children("td").eq(0).text().trim(),
			"nameCn" : $this.children("td").eq(1).text().trim(),
			"singerName" : $this.children("td").eq(2).text().trim(),
			"songType" : songTypeObj, 
			"desc" : $this.children("td").eq(4).text().trim()
		};
		$arraySong.push(each);
	});
	return $arraySong;
};
//拿到视频MV对象
var getVideoMV = function() {
	var $box = navTab.getCurrentPanel();
	var $arrayVideoMV = [];
	$(".videoMVTb", $box).children("tr").each(function() {
		var $this = $(this);
		var videoMVTypeObj ={};
		videoMVTypeObj[$this.children("td").eq(3).attr("vals")] = $this.children("td").eq(3).text().trim();
		var each = {
			"id" : $this.children("td").eq(0).text().trim(),
			"nameCn" : $this.children("td").eq(1).text().trim(),
			"singerName" : $this.children("td").eq(2).text().trim(),
			"videoMVType" : videoMVTypeObj, 
			"desc" : $this.children("td").eq(4).text().trim()
		};
		$arrayVideoMV.push(each);
	});
	return $arrayVideoMV;
};
