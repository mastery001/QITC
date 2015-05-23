//无插件 banner切换效果
$(function(){
	//获取可点触发编号
	$('#bannerTextBox').find('li').mouseover(function(){
														//停止自动切换
														clearInterval(t1);
														//获取编号自定义值 以获取对应图片
														var i = $(this).attr('set');
														//调用切换效果，切换到当前鼠标焦点编号的banner
														changeBanner('x',i);
														//设置当前编号的颜色 
														setListNo.apply(this,['x']);
												 }).mouseout(function(){
													 	//鼠标离开编号 自动开始继续切换
													 	t1 = setInterval(changeBanner,'3000');
													 })
//定义可触发编号 该变量用来自动切换过程中累加计算 用于判断是否到达最好一个banner位置
var bannerListIndex = 1;

//设置编号 参数setNo 用来判断方法是setInterval自动触发的还是 mouseover手动触发
function setListNo(setNo){
	//清空历史的选中位置
	$('#bannerTextBox').find(".thisHover").removeClass('thisHover');
	//如果是setInterval自动触发
	if(setNo!="x"){
			//通过 定义可触发编号bannerListIndex 累加参数判断选中位置
			$('#bannerTextBox').find("li").eq(setNo).addClass("thisHover");
		}
	//如果是手动触发
	else{
			//通过设置当前鼠标点击对象设置 选中位置
			$(this).addClass("thisHover");	
		}
	}

//切换方法 参数o 用来判断是否是手动出发  i 用来记录手动出发位置，以便真确定义显示图片
function changeBanner(o,i){
		$("#bannerImgesBox").find('a').hide();
		if(o != 'x'){
			setListNo(bannerListIndex);
			$("#bannerImgesBox").find('a').eq(bannerListIndex).fadeIn("slow");
		}else{
			
			$("#bannerImgesBox").find('a').eq(i).fadeIn("slow");
			bannerListIndex = i;
			}
		// 累加bannerListIndex 于判断是否到达最好一个banner位置 
		bannerListIndex++;
		if(bannerListIndex > 6 ){
			bannerListIndex = 0
		}
	}
//changeBanner();
var t1 = setInterval(changeBanner,'3000');
})