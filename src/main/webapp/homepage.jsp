<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/2
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored ="false" %>
<html>
<head>
   <%@include file="head.jsp"%>
   <script language="javascript">
       function realSysTime(clock){
           var now=new Date(); //创建Date对象
           var year=now.getFullYear(); //获取年份
           var month=now.getMonth(); //获取月份
           var date=now.getDate(); //获取日期
           var day=now.getDay(); //获取星期
           var hour=now.getHours(); //获取小时
           var minu=now.getMinutes(); //获取分钟
           var sec=now.getSeconds(); //获取秒钟
           month=month+1;
           var arr_week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
           var week=arr_week[day]; //获取中文的星期
           var time=year+"年"+month+"月"+date+"日 "+week+" "+hour+":"+minu+":"+sec; //组合系统时间
           clock.innerHTML=time; //显示系统时间
       }
       window.onload=function(){
           window.setInterval("realSysTime(clock)",1000); //实时获取并显示系统时间
       }
   </script>



</head>
<body>



<body class="easyui-layout">
<div data-options="region:'north',split:true" style="height:160px;">
   <%--头部--%>

      <div style="background-image:url(img/a1.jpg);height: 150px;width: 100%;">




<div align="center" >

<span style="font-size: 90px">企业进销存管理系统</span>

  <div style="margin-left: 800px">
     <div id="clock" ></div></div>   欢迎你:${username}
  </div>



</div>








</div>
<div data-options="region:'south',split:true" style="height:0px;"></div>
<div data-options="region:'west',title:'菜单',split:true" style="width:200px;">
<%--菜单--%>

<script type="text/javascript">


$(function () {


    $.ajax({


        url:"/getAllMainmenu.action",
        type:"post",
        dataType:"json",
        success:function (data) {
         $.each(data,function (index,m) {

             var flag=false;
             if (m.mid==1){

                 flag=true;
             }

             $('#aa').accordion('add', {
                 title: m.text,
                 content: '<div id='+m.text+'></div>',
                 selected: flag
             });

         })

        }

    })


    $('#aa').accordion({
       onSelect:function (title,index) {
           $('#'+title).tree({
               url:'/getAllMainmenu.action',
               queryParams:{
                   text:title

               }
           });
       }
    });



})







</script>


    <div id="aa" class="easyui-accordion" style="width:190px;">





    </div>










</div>
<div data-options="region:'center'" style="padding:5px;background:#eee;">
   <%--子菜单--%>


















</div>
</body>





</body>
</html>
