// JavaScript Document


var windowwidth;
var windowheight;
var checkmenu;
$(window).ready(function() {
   $('#myMenu').hide();
	   $('.textbox').bind("contextmenu",function(e){
	   windowwidth = $(window).width();
	   windowheight = $(window).height();
	   checkmenu = 1;
	   $('#mask').css({
	   'height': windowheight,
	   'width': windowwidth
	   });
            $('#myMenu').show(500);  
			  $('#myMenu').css({
			  'top':e.pageY+'px',
			  'left':e.pageX+'px'
			  });
			  
			  return false;
       });
$('#mask').click(function(){
$(this).height(0);
$(this).width(0);
$('#myMenu').hide(500);
checkmenu = 0;
return false;
});
$('#mask').bind("contextmenu",function(){
$(this).height(0);
$(this).width(0);
$('#myMenu').hide(500);
checkmenu = 0;
return false;
});
$(window).resize(function(){
if(checkmenu == 1) {
windowwidth = $(window).width();
	windowheight = $(window).height();
	$('#mask').css({
	'height': windowheight,
	'width': windowwidth,
	});
}
});
});

