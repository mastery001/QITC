<?php
include '../../custom_util/RequestWrapper.php';

$_GET = proceed();

//本程序用于接收来自HTML页面的表单数据，并输出每个字段
echo "用户的输入如下所示：<BR>";
echo "姓名：".$_GET['username']."<BR>";
echo "密码：".$_GET['password']."<BR>";
echo "密码确认：".$_GET['password2']."<BR>";
echo "性别：".$_GET['sex']."<BR>";
echo "生日：".$_GET['birthday']."<BR>";
echo "E-mail：".$_GET['email']."<BR>";
echo "职业：".$_GET['job']."<BR>"; 
