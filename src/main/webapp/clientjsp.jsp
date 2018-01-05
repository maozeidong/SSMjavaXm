<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/2
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%@include file="head.jsp"%>
</head>
<body>

<script type="text/javascript">


    $(function () {
    $('#dg').datagrid({
        url: '/getAllClient.action',
        columns: [[
            {field: 'id', title: 'id', hidden: true},
            {field: 'customername', title: '名称',width:'15%'},
            {field: 'altek', title: '简称',width:'8%'},
            {field: 'customeraddress', title: '地址', width: '18%'},
            {field: 'customerphone', title: '电话', width: '12%'},
            {field: 'customeremail', title: 'e-mail', width: '12%'},
            {field: 'customerzipcode', title: '邮政编码', width: '12%'},
            {field: 'requesting', title: '账号', width: '16%'},
            {field: 'openingbank', title: '开户行', width: '15%'},
            {field: 'customerfax', title: '传真', width: '12%'},
            {field: 'persontocontact', title: '联系人', width: '10%'},
            {field: 'contactnumber', title: '联系电话', width: '12%'}
        ]],
        pagination: true,
        pageList: [5, 10],
        pageSize: 5,
        singleSelect: true,
        rownumbers: true,
        onClickRow: function (index, row) {
            $('#ida').textbox('setText',row.id);
            $('#customernameb').textbox('setText',row.customername);
            $('#altekb').textbox('setText',row.altek);
            $('#customeraddressb').textbox('setText',row.customeraddress);
            $('#customerphoneb').textbox('setText',row.customerphone);
            $('#customeremailb').textbox('setText',row.customeremail);
            $('#customerzipcodeb').textbox('setText',row.customerzipcode);
            $('#requestingb').textbox('setText',row.requesting);
            $('#customerfaxb').textbox('setText',row.customerfax);
            $('#persontocontactb').textbox('setText',row.persontocontact);
            $('#contactnumberb').textbox('setText',row.contactnumber);
            $('#opidb').textbox('setText',row.openingbank);

        },
        toolbar: '#tb'

    });
    })



/*查看*/
function searchabc() {


    $('#dg').datagrid({
        url: '/getAllClient.action',
       queryParams:{

           customername:$('#customername').textbox('getText')

}

    });


}

/*增加按钮*/
function addabc() {
    $('#win').window({
        width:450,
        height:400,
        modal:true,
        title: '客户添加',
    })
}

/*重填按钮*/
function redoabc() {


    $('#customernamea').textbox('setText',"");
    $('#alteka').textbox('setText',"");
    $('#customeraddressa').textbox('setText',"");
    $('#customerphonea').textbox('setText',"");
    $('#customeremaila').textbox('setText',"");
    $('#customerzipcodea').textbox('setText',"");
    $('#requestinga').textbox('setText',"");
    $('#customerfaxa').textbox('setText',"");
    $('#persontocontacta').textbox('setText',"");
    $('#contactnumbera').textbox('setText',"");
}

/*增加按钮*/
function addbcad() {



    $.ajax({


        url:"/getinsertClient.action",
        type:"post",
        dataType:"text",
        data:{

            customernamea:$('#customernamea').textbox('getText'),

            alteka: $('#alteka').textbox('getText'),

            customeraddressa:  $('#customeraddressa').textbox('getText'),

            customerphonea: $('#customerphonea').textbox('getText'),

            customeremaila: $('#customeremaila').textbox('getText'),

            customerzipcodea: $('#customerzipcodea').textbox('getText'),

            requestinga: $('#requestinga').textbox('getText'),

            customerfaxa:  $('#customerfaxa').textbox('getText'),

            persontocontacta:$('#persontocontacta').textbox('getText'),

            contactnumbera: $('#contactnumbera').textbox('getText'),

            opida:$('#opida').textbox('getValue')

        },
        success:function (data) {

            if (data=='Y'){
                alert("添加成功！")
                $('#win').window('close');
                $('#dg').datagrid('reload');
            }else if (data=='S'){
                alert("添加失败！")
            }else{

                alert("已有该供应商！")
            }



        }


    })






}



   /* 删除*/
    function removeabc() {


        $.ajax({


            url: "/getdeleteclient.action",
            type: "post",
            dataType: "text",
            data: {

                ida: $('#ida').textbox('getText')

            },
            success: function (data) {


                if (data=='Y'){
                    alert("删除成功！")
                    $('#dg').datagrid('reload');
                }else{
                    alert("删除失败！")
                }

            }


        })
    }

    function abc() {
        $.messager.confirm('删除客户', '您确定要删除', function(r){
            if (r){
                removeabc();
            }
        });


    }


   /* 修改*/
function editabc() {

    $('#wing').window({
        width:450,
        height:450,
        modal:true,
        title: '客户修改',
    })

}
/*取消按钮*/
    function noabc() {
        $('#wing').window('close');
    }


/*确定按钮*/
    function okabc() {
        $.ajax({


            url:"/getupdateclient.action",
            type:"post",
            dataType:"text",
            data:{
                ida: $('#ida').textbox('getText'),

                customernamea:$('#customernameb').textbox('getText'),

                alteka: $('#altekb').textbox('getText'),

                customeraddressa:  $('#customeraddressb').textbox('getText'),

                customerphonea: $('#customerphoneb').textbox('getText'),

                customeremaila: $('#customeremailb').textbox('getText'),

                customerzipcodea: $('#customerzipcodeb').textbox('getText'),

                requestinga: $('#requestingb').textbox('getText'),

                customerfaxa:  $('#customerfaxb').textbox('getText'),

                persontocontacta:$('#persontocontactb').textbox('getText'),

                contactnumbera: $('#contactnumberb').textbox('getText'),

                opida:$('#opidc').textbox('getValue'),

                opidaa:$('#opidc').textbox('getText'),
            },
            success:function (data) {

                if (data=='Y'){
                    alert("修改成功！")
                    $('#wing').window('close');
                    $('#dg').datagrid('reload');
                }else {
                    alert("修改失败！")
                }



            }


        })
    }

</script>


<table id="dg"></table>
<div id="tb">
    名称<input class="easyui-textbox"  style="width:180px" id="customername">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchabc();">查看</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="addabc();">增加</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="editabc();">修改</a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="abc();">删除</a>
</div>
<div style="display: none">
    <input class="easyui-textbox"  style="width:300px;" id="ida" >
</div>
<div id="win" style="display: none">
    <br><br>
&nbsp;&nbsp;&nbsp;名称：<input class="easyui-textbox"  style="width:300px" id="customernamea">
<br><br>
&nbsp;&nbsp;&nbsp;简称: <input class="easyui-textbox"  style="width:120px" id="alteka">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;邮政编码:&nbsp;&nbsp;&nbsp;<input class="easyui-textbox"  style="width:100px" id="customerzipcodea">
<br><br>
&nbsp;&nbsp;&nbsp;地址&nbsp;:&nbsp;&nbsp;&nbsp; <input class="easyui-textbox"  style="width:335px" id="customeraddressa">
<br><br>
&nbsp;&nbsp;&nbsp;电话: <input class="easyui-textbox"  style="width:120px" id="customerphonea">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;传真: <input class="easyui-textbox"  style="width:100px" id="customerfaxa">
<br><br>
&nbsp;&nbsp;&nbsp;联系人: <input class="easyui-textbox"  style="width:120px" id="persontocontacta">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;联系人电话: <input class="easyui-textbox"  style="width:100px" id="contactnumbera">
<br><br>
&nbsp;&nbsp;&nbsp;银行账号：<input class="easyui-textbox"  style="width:120px" id="requestinga">
&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;开户银行: <input id="opida" name="opida" value="--请选择--" style="width:100px" >
<script type="text/javascript">
    $(function () {
        $('#opida').combobox({
            url:'/getAllBank.action',
            valueField:'id',
            textField:'openingbank'
        });
    })
</script>
<br><br>
&nbsp;&nbsp;&nbsp;电子邮箱 &nbsp;:&nbsp;&nbsp;&nbsp; <input class="easyui-textbox"  style="width:300px" id="customeremaila">
<br><br>
&nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;
<a id="btna" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="addbcad();">添加</a>
&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;
<a id="buta" class="easyui-linkbutton" data-options="iconCls:'icon-redo'" onclick="redoabc();">重填</a>


</div>





<div id="wing" style="display: none">
    <br><br>
    &nbsp;&nbsp;&nbsp;名称：<input class="easyui-textbox"  style="width:300px" id="customernameb" disabled="disabled">
    <br><br>
    &nbsp;&nbsp;&nbsp;简称: <input class="easyui-textbox"  style="width:120px" id="altekb">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;邮政编码:&nbsp;&nbsp;&nbsp;<input class="easyui-textbox"  style="width:100px" id="customerzipcodeb">
    <br><br>
    &nbsp;&nbsp;&nbsp;地址&nbsp;:&nbsp;&nbsp;&nbsp; <input class="easyui-textbox"  style="width:335px" id="customeraddressb">
    <br><br>
    &nbsp;&nbsp;&nbsp;电话: <input class="easyui-textbox"  style="width:120px" id="customerphoneb">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;传真: <input class="easyui-textbox"  style="width:100px" id="customerfaxb">
    <br><br>
    &nbsp;&nbsp;&nbsp;联系人: <input class="easyui-textbox"  style="width:120px" id="persontocontactb">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;联系人电话: <input class="easyui-textbox"  style="width:100px" id="contactnumberb">
    <br><br>
    &nbsp;&nbsp;&nbsp;银行账号：<input class="easyui-textbox"  style="width:120px" id="requestingb">
    &nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;开户银行:
    <input class="easyui-textbox"  style="width:120px" id="opidb" disabled="disabled">
    <script type="text/javascript">
        $(function () {
            $('#opidc').combobox({
                url:'/getAllBank.action',
                valueField:'id',
                textField:'openingbank'
            });
        })
    </script>
    <br><br>
    &nbsp;&nbsp;&nbsp;电子邮箱 &nbsp;:&nbsp;&nbsp;&nbsp; <input class="easyui-textbox"  style="width:300px" id="customeremailb">
    <br><br>
    &nbsp;&nbsp;&nbsp;开户银行: <input id="opidc" name="opidc" value="--请选择--" style="width:150px" >
    <br><br>
    &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;
    <a id="btnb" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="okabc();">确定</a>
    &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;
    <a id="butb" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="noabc();">取消</a>
</div>


</body>
</html>
