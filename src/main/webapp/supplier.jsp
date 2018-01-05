<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/3
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>

        <script type="text/javascript">


            $(function () {
                $('#dg').datagrid({
                    url: '/getAllSupplier.action',
                    columns: [[
                        {field: 'id', title: 'id', hidden: true},
                        {field: 'suppliername', title: '名称',width:'15%'},
                        {field: 'suppliershort', title: '简称',width:'8%'},
                        {field: 'supplieraddress', title: '地址', width: '18%'},
                        {field: 'suppliertelephone', title: '电话', width: '12%'},
                        {field: 'supplieremail', title: 'e-mail', width: '12%'},
                        {field: 'supplierzipcode', title: '邮政编码', width: '12%'},
                        {field: 'supplieraccount', title: '账号', width: '16%'},
                        {field: 'openingbank', title: '开户行', width: '15%'},
                        {field: 'faxtosupplier', title: '传真', width: '12%'},
                        {field: 'suppliercontact', title: '联系人', width: '10%'},
                        {field: 'suppliercontactnumber', title: '联系电话', width: '12%'}
                    ]],
                    pagination: true,
                    pageList: [5, 10],
                    pageSize: 5,
                    singleSelect: true,
                    rownumbers: true,
                    onClickRow: function (index, row) {
                        $('#ida').textbox('setText',row.id);
                        $('#suppliernameb').textbox('setText',row.suppliername);
                        $('#suppliershortb').textbox('setText',row.suppliershort);
                        $('#supplierzipcodeb').textbox('setText',row.supplierzipcode);
                        $('#supplieraddressb').textbox('setText',row.supplieraddress);
                        $('#suppliertelephoneb').textbox('setText',row.suppliertelephone);
                        $('#faxtosupplierb').textbox('setText',row.faxtosupplier);
                        $('#suppliercontactb').textbox('setText',row.suppliercontact);
                        $('#suppliercontactnumberb').textbox('setText',row.suppliercontactnumber);
                        $('#supplieraccountb').textbox('setText',row.supplieraccount);
                        $('#supplieremailb').textbox('setText',row.supplieremail);
                        $('#opidb').textbox('setText',row.openingbank);
                    },
                    toolbar: '#tb'

                });
            })


        /*查看*/
        function searchabc() {


            $('#dg').datagrid({
                url: '/getAllSupplier.action',
                queryParams:{

                    suppliername:$('#suppliername').textbox('getText')

                }

            });

        }


        /*增加按钮*/
        function addabc() {
            $('#win').window({
                width:450,
                height:400,
                modal:true,
                title: '供应商添加',
            })
        }

       /* 添加*/
        function iconaddabc() {

            $.ajax({


                url:"/getinsertsupplier.action",
                type:"post",
                dataType:"text",
                data:{

                    suppliernamea:$('#suppliernamea').textbox('getText'),
                    suppliershorta: $('#suppliershorta').textbox('getText'),
                    supplierzipcodea:  $('#supplierzipcodea').textbox('getText'),
                    supplieraddressa: $('#supplieraddressa').textbox('getText'),
                    suppliertelephonea: $('#suppliertelephonea').textbox('getText'),
                    faxtosuppliera: $('#faxtosuppliera').textbox('getText'),
                    suppliercontacta: $('#suppliercontacta').textbox('getText'),
                    suppliercontactnumbera:  $('#suppliercontactnumbera').textbox('getText'),
                    supplieraccounta:$('#supplieraccounta').textbox('getText'),
                    supplieremaila: $('#supplieremaila').textbox('getText'),
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

           /* 重填*/
        function redoabc() {
            $('#suppliernamea').textbox('setText',"");
            $('#suppliershorta').textbox('setText',"");
            $('#supplierzipcodea').textbox('setText',"");
            $('#supplieraddressa').textbox('setText',"");
            $('#suppliertelephonea').textbox('setText',"");
            $('#faxtosuppliera').textbox('setText',"");
            $('#suppliercontacta').textbox('setText',"");
            $('#suppliercontactnumbera').textbox('setText',"");
            $('#supplieraccounta').textbox('setText',"");
            $('#supplieremaila').textbox('setText',"");
        }

        /*删除*/
        function removeabc() {
            $.ajax({


                url: "/getdeletesupplier.action",
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
    $.messager.confirm('删除供应商', '您确定要删除', function(r){
        if (r){
            removeabc();
        }
    });


}


/*修改按钮*/
function editabc() {
    $('#wing').window({
        width:450,
        height:450,
        modal:true,
        title: '供应商修改',
    })
}

function noabc() {
    $('#wing').window('close');
}


function okabc() {



    $.ajax({


        url:"/getupdatesupplier.action",
        type:"post",
        dataType:"text",
        data:{
            ida: $('#ida').textbox('getText'),

            suppliernamea:$('#suppliernameb').textbox('getText'),
            suppliershorta: $('#suppliershortb').textbox('getText'),
            supplierzipcodea:  $('#supplierzipcodeb').textbox('getText'),
            supplieraddressa: $('#supplieraddressb').textbox('getText'),
            suppliertelephonea: $('#suppliertelephoneb').textbox('getText'),
            faxtosuppliera: $('#faxtosupplierb').textbox('getText'),
            suppliercontacta: $('#suppliercontactb').textbox('getText'),
            suppliercontactnumbera:  $('#suppliercontactnumberb').textbox('getText'),
            supplieraccounta:$('#supplieraccountb').textbox('getText'),
            supplieremaila: $('#supplieremailb').textbox('getText'),
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
</head>
<body>




<table id="dg"></table>
<div id="tb">
    名称<input class="easyui-textbox"  style="width:180px" id="suppliername">
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
    &nbsp;&nbsp;&nbsp;供应商全称：<input class="easyui-textbox"  style="width:300px" id="suppliernamea">
    <br><br>
    &nbsp;&nbsp;&nbsp;简称: <input class="easyui-textbox"  style="width:120px" id="suppliershorta">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;邮政编码:&nbsp;&nbsp;&nbsp;<input class="easyui-textbox"  style="width:100px" id="supplierzipcodea">
    <br><br>
    &nbsp;&nbsp;&nbsp;地址&nbsp;:&nbsp;&nbsp;&nbsp; <input class="easyui-textbox"  style="width:335px" id="supplieraddressa">
    <br><br>
    &nbsp;&nbsp;&nbsp;电话: <input class="easyui-textbox"  style="width:120px" id="suppliertelephonea">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;传真: <input class="easyui-textbox"  style="width:100px" id="faxtosuppliera">
    <br><br>
    &nbsp;&nbsp;&nbsp;联系人: <input class="easyui-textbox"  style="width:120px" id="suppliercontacta">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;联系人电话: <input class="easyui-textbox"  style="width:100px" id="suppliercontactnumbera">
    <br><br>
    &nbsp;&nbsp;&nbsp;银行账号：<input class="easyui-textbox"  style="width:120px" id="supplieraccounta">
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
    &nbsp;&nbsp;&nbsp;电子邮箱 &nbsp;:&nbsp;&nbsp;&nbsp; <input class="easyui-textbox"  style="width:300px" id="supplieremaila">
    <br><br>
    &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;
    <a id="btna" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="iconaddabc();">添加</a>
    &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;
    <a id="buta" class="easyui-linkbutton" data-options="iconCls:'icon-redo'" onclick="redoabc();">重填</a>
</div>



<div id="wing" style="display: none">
    <br><br>
    &nbsp;&nbsp;&nbsp;供应商全称：<input class="easyui-textbox"  style="width:300px" id="suppliernameb" disabled="disabled">
    <br><br>
    &nbsp;&nbsp;&nbsp;简称: <input class="easyui-textbox"  style="width:120px" id="suppliershortb">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;邮政编码:&nbsp;&nbsp;&nbsp;<input class="easyui-textbox"  style="width:100px" id="supplierzipcodeb">
    <br><br>
    &nbsp;&nbsp;&nbsp;地址&nbsp;:&nbsp;&nbsp;&nbsp; <input class="easyui-textbox"  style="width:335px" id="supplieraddressb">
    <br><br>
    &nbsp;&nbsp;&nbsp;电话: <input class="easyui-textbox"  style="width:120px" id="suppliertelephoneb">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;传真: <input class="easyui-textbox"  style="width:100px" id="faxtosupplierb">
    <br><br>
    &nbsp;&nbsp;&nbsp;联系人: <input class="easyui-textbox"  style="width:120px" id="suppliercontactb">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;联系人电话: <input class="easyui-textbox"  style="width:100px" id="suppliercontactnumberb">
    <br><br>
    &nbsp;&nbsp;&nbsp;银行账号：<input class="easyui-textbox"  style="width:120px" id="supplieraccountb">
    &nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;开户银行:
    <input class="easyui-textbox"  style="width:120px" id="opidb" disabled="disabled">
   <<script type="text/javascript">
        $(function () {
            $('#opidc').combobox({
                url:'/getAllBank.action',
                valueField:'id',
                textField:'openingbank'
            });
        })
    </script>
    <br><br>
    &nbsp;&nbsp;&nbsp;电子邮箱 &nbsp;:&nbsp;&nbsp;&nbsp; <input class="easyui-textbox"  style="width:300px" id="supplieremailb">
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
