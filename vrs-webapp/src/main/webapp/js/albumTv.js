/**
 * 电视剧专辑列表 - 电视台相关
 */
$(document).ready(function() {
    var $box = navTab.getCurrentPanel();
    var AlbumTv = {
        idx: 100,
        tvType: {
            'first': {
                'tpl': '<div date-type="tpl"   class="albumTvFirstBox" style="clear:both;padding:5px;">'+
                        '<input type="text" name="firstPlayTvBeginTime" class="date textInput readonly valid" readonly="true" />'+
                        '<a class="inputDateButton" href="javascript:;">选择</a>'+
                        '<span style="float:left;">&nbsp;~&nbsp;</span>'+
                        '<input type="text" name="firstPlayTvEndTime" class="date textInput readonly valid" readonly="true" />'+
                        '<a class="inputDateButton" href="javascript:;">选择</a>'+
                        '<input autocomplete="off" type="text" size="30" name="/fuckMMS/.tvName" readonly="readonly" />'+
                        '<input type="hidden" class="firstTvId" name="/fuckMMS/.tvId"/>'+
                        '<a class="buttonActive" href="../tv/searchTv.action" lookupGroup="/fuckMMS/"><span>搜索电视台</span></a>'+
                        '<a class="btnAdd addFirstPlayTv" data-type="first" href="javascript:;">添加</a>'+
                        '<a class="btnDel removeFirstPlayTv" data-type="first" href="javascript:;">删除</a>'+
                    '</div>',
                'box': $('#albumTvFirstBox', $box)
            },
            'repeat': {
                'tpl': '<div date-type="tpl" class="albumTvRepeatBox" style="clear:both;padding:5px;">'+
                        '<input type="text" name="repeatPlayTvBeginTime" class="date textInput readonly valid" readonly="true" />'+
                        '<a class="inputDateButton" href="javascript:;">选择</a>'+
                        '<span style="float:left;">&nbsp;~&nbsp;</span>'+
                        '<input type="text" name="repeatPlayTvEndTime" class="date textInput readonly valid" readonly="true" />'+
                        '<a class="inputDateButton" href="javascript:;">选择</a>'+
                        '<input autocomplete="off" type="text" size="30" name="/fuckMMS/.tvName" readonly="readonly" />'+
                        '<a class="buttonActive" href="../tv/searchTv.action" lookupGroup="/fuckMMS/"><span>搜索电视台</span></a>'+
                        '<a class="btnAdd addFirstPlayTv" data-type="repeat" href="javascript:;">添加</a>'+
                        '<a class="btnDel removeFirstPlayTv" data-type="repeat" href="javascript:;">删除</a>'+
                        '<input type="hidden" class="repeatTvId" name="/fuckMMS/.tvId"/>'+
                    '</div>',
                'box': $('#albumTvRepeatBox', $box)
            }
        },
        init: function(){
            this._initDom();
            this._initEvent();
        },
        _initDom: function(){
            this.$doc = $(document);
        },
        _initEvent: function(){
            this.$doc.on('click', 'a.addFirstPlayTv', function(e){
                this._addRow(e);
            }.bind(this));
            this.$doc.on('click', 'a.removeFirstPlayTv', function(e){
                this._delRow(e);
            }.bind(this));
        },
        _addRow: function(e){
            var $this = $(e.currentTarget),
                _type = $this.attr('data-type'),
                $current = this.tvType[_type],
                tpl = $current.tpl;

            if ($current.box.children('div').size() === 10) {
                alertMsg.warn('增加的条数不能超过10条！');
                return false;
            }
            // lookupGroup's name
            tpl = tpl.replace(/\/fuckMMS\//gi, _type + this.idx);
            
            // lookupGroup's src
            
            this.idx += 1;
            $current.box.append(tpl).initUI();
        },
        _delRow: function(e){
            var $this = $(e.currentTarget), _type = $this.attr('data-type');
            if (this.tvType[_type].box.children('div').size() === 1) {
                alertMsg.warn('最少保留一行输入框！');
                return false;
            }
            $this.parent().remove();
        },
        _rename: function(){
            
        }
    };

    AlbumTv.init();
});
