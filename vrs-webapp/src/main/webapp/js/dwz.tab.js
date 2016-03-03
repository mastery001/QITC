/**
 * @author ZhangHuihua@msn.com
 * 
 */
(function($){
	$.fn.extend({

		/**
		 * options: reverse[true, false], eventType[click, hover], currentIndex[default index 0]
		 * 			stTab[tabs selector], stTabPanel[tab panel selector]
		 * 			ajaxClass[ajax load], closeClass[close tab]
		 */ 
		tabs: function (options){
			var op = $.extend({reverse:false, eventType:"click", currentIndex:0, stTabHeader:"> .tabsHeader", stTab:">.tabsHeaderContent>ul", stTabPanel:"> .tabsContent", ajaxClass:"j-ajax", closeClass:"close", prevClass:"tabsLeft", nextClass:"tabsRight"}, options);
			
			return this.each(function(){
				initTab($(this));
			});
			
			function initTab(jT){
				var jSelector = jT.add($("> *", jT));
				var jTabHeader = $(op.stTabHeader, jSelector);
				var jTabs = $(op.stTab + " li", jTabHeader);
				var jGroups = $(op.stTabPanel + " > *", jSelector);
				var prevBut = jTabHeader.find("."+op.prevClass);
				var nextBut = jTabHeader.find("."+op.nextClass);
				
				jTabs.unbind().find("a").unbind();
				//jTabHeader.find("."+op.prevClass).unbind();
				//jTabHeader.find("."+op.nextClass).unbind();
				prevBut.click(function(event) { TabsScroll.scrollLeft()});
				nextBut.click(function(event) { TabsScroll.scrollRight()});
				TabsScroll.init();
				
				jTabs.each(function(iTabIndex){
					if (op.currentIndex == iTabIndex) $(this).addClass("selected");
					else $(this).removeClass("selected");
					
					if (op.eventType == "hover") $(this).hover(function(event){switchTab(jT, iTabIndex)});
					else $(this).click(function(event){switchTab(jT, iTabIndex)});

					$("a", this).each(function(){
						if ($(this).hasClass(op.ajaxClass)) {
							$(this).click(function(event){
								var jGroup = jGroups.eq(iTabIndex);
								if (this.href && !jGroup.attr("loaded")) jGroup.loadUrl(this.href,{},function(){
									jGroup.find("[layoutH]").layoutH();
									jGroup.attr("loaded",true);
								});
								event.preventDefault();
							});
							
						} else if ($(this).hasClass(op.closeClass)) {
							$(this).click(function(event){
								jTabs.eq(iTabIndex).remove();
								jGroups.eq(iTabIndex).remove();
								if (iTabIndex == op.currentIndex) {
									op.currentIndex = (iTabIndex+1 < jTabs.size()) ? iTabIndex : iTabIndex - 1;
								} else if (iTabIndex < op.currentIndex){
									op.currentIndex = iTabIndex;
								}
								initTab(jT);
								return false;
							});
						}
					});
				});

				switchTab(jT, op.currentIndex);
			}
			
			function switchTab(jT, iTabIndex){
				var jSelector = jT.add($("> *", jT));
				var jTabHeader = $(op.stTabHeader, jSelector);
				var jTabs = $(op.stTab + " li", jTabHeader);
				var jGroups = $(op.stTabPanel + " > *", jSelector);
				
				var jTab = jTabs.eq(iTabIndex);
				var jGroup = jGroups.eq(iTabIndex);
				if (op.reverse && (jTab.hasClass("selected") )) {
					jTabs.removeClass("selected");
					jGroups.hide();
				} else {
					op.currentIndex = iTabIndex;
					jTabs.removeClass("selected");
					jTab.addClass("selected");
					
					jGroups.hide().eq(op.currentIndex).show();
				}
				
				if (!jGroup.attr("inited")){
					jGroup.attr("inited", 1000).find("input[type=text]").filter("[alt]").inputAlert();
				}
			}
			
		}
	});
})(jQuery);

// tabs 滚动
var TabsScroll = {
	init: function(){
		this.pageContent = $(".pageContent:visible")
		this.tabsHeader = this.pageContent.find(".tabsHeader");
		this.tabsHeaderContent = this.pageContent.find(".tabsHeaderContent");
		this.tabsHeaderList = this.pageContent.find(".tabsHeaderContent li");
		this.leftBtn = this.pageContent.find(".tabsLeft");
		this.rightBtn = this.pageContent.find(".tabsRight");
		
		this.position = 0;
		this.isLocked = false;	
		
		var tabsWidth = this.tabsHeader.width();
		var tabsListWidth = 0;
		this.tabsHeaderList.each(function(){
			tabsListWidth += $(this).width() + parseInt($(this).css("margin-right"));
		});
		if(tabsWidth < tabsListWidth){
			this.tabsHeaderContent.css("width", tabsListWidth + this.rightBtn.width());
			this.leftBtn.show();
			this.rightBtn.show();
		}
	},
	scrollLeft: function(){
		if(this.isLocked){
			return;
		}
		if(this.position == 0){
			return;
		}
		var tabsWidth = this.tabsHeader.width();
		var tabsListWidth = this.tabsHeaderContent.width();
		if(this.position + tabsWidth == tabsListWidth){
			this.rightBtn.removeClass("tabsRightDisabled");
		}
		var width = 0;
		if(this.position < 200){
			width = this.position;
			this.leftBtn.addClass("tabsLeftDisabled");
		}else{
			width = 200;
		}
		this.isLocked = true;
		var _this = this;
		this.tabsHeaderContent.animate({"margin-left": "+=" + width}, 200,function(){
			_this.isLocked = false;
		});
		this.position -= width;
	},
	scrollRight: function(){
		if(this.isLocked){
			return;
		}
		var tabsWidth = this.tabsHeader.width();
		var tabsListWidth = this.tabsHeaderContent.width();
		if(this.position + tabsWidth == tabsListWidth){
			return;
		}
		if(this.position == 0){
			this.leftBtn.removeClass("tabsLeftDisabled");
		}
		var width = 0;
		if(tabsListWidth - tabsWidth - this.position < 200){
			width = tabsListWidth - tabsWidth - this.position;
			this.rightBtn.addClass("tabsRightDisabled");
		}else{
			width = 200;
		}
		this.isLocked = true;
		var _this = this;
		this.tabsHeaderContent.animate({"margin-left": "-=" + width}, 200, function(){
			_this.isLocked = false;
		});
		this.position += width;
	}
	
}