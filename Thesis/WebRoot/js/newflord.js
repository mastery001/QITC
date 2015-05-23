// JavaScript Document



//增加一个文件夹函数
   var i = 1;
   function addElement(){
   var div = document.createElement('div'); 
    var str="<table id=dropid"+i+" width=101 height=127 border=0    onMouseMove=Mouse_Over(this) onMouseOut=Mouse_Out(this) ></tbody> <tr> <td height=94><div><img id=imgid src=image/flord.png width=113 height=102></div> </td> </tr> <tr> <td>"+
	"</td> </tr></tbody></table><input  type=text name=userName  onBlur=textBlur() value=新建文件夹"+i+" style=border:1px;border-bottom-style:none;border-top-style:none;border-left-style:none;border-right-style:none; >";
        
        
  <!--div.style.fontSize = '30px'; div.style.backgroundColor = 'red';-->
    
	
	div.setAttribute('class', 'fileDiv');
	div.setAttribute('id', 'Elem'+i);
	//div.innerHTML=str;
	document.getElementById('imgid').appendChild(div); 
	
	//为新增的div增加被选中的效果
	//new RegionSelect({  region:'div.fileDiv', selectedClass: 'seled' }).select(); 
	document.getElementById('Elem'+i).innerHTML=str;
	i++;
  }
  
  //删除文件夹函数
    function dropElement(){
		  
	var aaa = document.getElementById('Elem'+(i-1));
    document.getElementById('imgid').removeChild(aaa);
	i--;
  }
  //文件夹选择函数
  //// new RegionSelect({  region:'div.fileDiv', selectedClass: 'seled' }).select();
   
   var id;
function Mouse_Over(obj)
{
  //document.getElementById(obj.id);
  id =obj.id;

  //alert(obj);
  obj.style.background="Yellow";
  

}
function Mouse_Out(obj)
{

  obj.style.background="";
}
function Mouse_KeyDown()
{
    
     var obj2 = document.getElementById(id);
  //document.getElementById(obj.id).style.background="red";
    // obj.style.background="red"
  
     var div1=obj2.parentNode;
	 if(window.confirm('是否确定删除？')){
                 
				  div1.parentNode.removeChild(div1);
				  alert("删除成功");
                 return true;
              }else{
                  alert("删除失败");
                 return false;
             }
	
  
  
}
   
   
   
   
