<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2017/12/10
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- CSS -->
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/supersized.css">
<link rel="stylesheet" href="css/style.css">

<!-- Javascript -->
<script src="http://apps.bdimg.com/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
<script src="js/supersized.3.2.7.min.js"></script>
<script src="js/supersized-init.js"></script>
<html>
<head>
    <title>Title</title>
    <%@include file="head.jsp"%>
   <script type="text/javascript">
        $(".btn").click(function(){
            is_hide();
        })
        var u = $("input[name=mname]");
        var p = $("input[name=mpwd]");
        $("#submit").live('click',function(){
            if(u.val() == '' || p.val() =='') {
                $("#ts").html("用户名或密码不能为空");
                is_show();
                return false;
            } else{
                var reg = /^[0-9A-Za-z]+$/;
                if(!reg.exec(u.val()))
                {
                    $("#ts").html("用户名错误");
                    is_show();
                    return false;
                }
            }
        });

        window.onload = function()
        {
            $(".connect p").eq(0).animate({"left":"0%"}, 600);
            $(".connect p").eq(1).animate({"left":"0%"}, 400);
        }
        function is_hide(){ $(".alert").animate({"top":"-40%"}, 300) }
        function is_show(){ $(".alert").show().animate({"top":"45%"}, 300) }


        $('#de').window({
            width:600,
            height:400,
            modal:true
        });




       /* 登入按钮*/
        function buttonabc() {

            $.ajax({


                url: "/getselectenterlogin.action",
                type: "post",
                dataType: "text",
                data: {

                    mname: $('#mname').val(),
                    mpwd:$('#mpwd').val()
                },
                success: function (data) {


                    if (data=='Y'){

                        window.location.href='homepage.jsp';

                    }else{

                        alert("失败！")

                    }



                }
            })
        }





   </script>

</head>
<body>
<div class="page-container"  id="de">

    <h1>进销存管理系统</h1>

    <div>
        <input type="text" name="mname" id="mname" class="mname" placeholder="管理员账号" autocomplete="off"/>
    </div>
    <div>
        <input type="password" name="mpwd" id="mpwd" class="mpwd" placeholder="管理员密码" oncontextmenu="return false" onpaste="return false" />
    </div>

    <button id="submit" type="button"  onclick="buttonabc();">登录</button>

    <div class="connect">
        <p>If we can only encounter each other rather than stay with each other,then I wish we had never encountered.</p>
        <p style="margin-top:20px;">如果只是遇见，不能停留，不如不遇见。</p>
    </div>
</div>
<div class="alert" style="display:none">
    <h2>消息</h2>
    <div class="alert_con">
        <p id="ts"></p>
        <p style="line-height:70px"><a class="btn">确定</a></p>
    </div>
</div>
</body>
</html>
