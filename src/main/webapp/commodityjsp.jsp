<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/3
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <%@include file="head.jsp"%>
      <script type="text/javascript">

          $(function () {
              $('#dg').datagrid({
                  url: '/getAllCommodity.action',
                  columns: [[
                      {field: 'id', title: 'id', hidden: true},
                      {field: 'productname', title: '名称',width:'15%'},
                      {field: 'commodityreferred', title: '简称',width:'8%'},
                      {field: 'originofgoods', title: '产地', width: '18%'},
                      {field: 'unit', title: '单位', width: '12%'},
                      {field: 'suppliername', title: '供应商', width: '12%'},
                      {field: 'briefintroduction', title: '简介', width: '12%'},
                      {field: 'approvalnumber', title: '批准文号', width: '16%'},
                      {field: 'batchnumber', title: '批号', width: '15%'},
                      {field: 'specification', title: '规格', width: '12%'},
                      {field: 'packaging', title: '包装', width: '10%'}
                  ]],
                  pagination: true,
                  pageList: [5, 10],
                  pageSize: 5,
                  singleSelect: true,
                  rownumbers: true,
                  onClickRow: function (index, row) {

                      $('#ida').textbox('setText',row.id);
                      $('#productnameb').textbox('setText',row.productname);
                      $('#commodityreferredb').textbox('setText',row.commodityreferred);
                      $('#originofgoodsb').textbox('setText',row.originofgoods);
                      $('#unitb').textbox('setText',row.unit);
                      $('#briefintroductionb').textbox('setText',row.briefintroduction);
                      $('#approvalnumberb').textbox('setText',row.approvalnumber);
                      $('#batchnumberb').textbox('setText',row.batchnumber);
                      $('#specificationb').textbox('setText',row.specification);
                      $('#packagingb').textbox('setText',row.packaging);
                      $('#suppliernameb').textbox('setText',row.suppliername);

                  },
                  toolbar: '#tb'

              });
          })



          /*查看*/
          function searchabc() {


              $('#dg').datagrid({
                  url: '/getAllCommodity.action',
                  queryParams:{

                      productname:$('#productname').textbox('getText')

                  }

              });


          }

         /* 增加按钮*/
function addabc() {
    $('#win').window({
        width:450,
        height:400,
        modal:true,
        title: '客户添加',
    })
}


// 重填
function redoabc() {

    $('#productnamea').textbox('setText',"");
    $('#commodityreferreda').textbox('setText',"");
    $('#originofgoodsa').textbox('setText',"");
    $('#unita').textbox('setText',"");
    $('#briefintroductiona').textbox('setText',"");
    $('#approvalnumbera').textbox('setText',"");
    $('#batchnumbera').textbox('setText',"");
    $('#specificationa').textbox('setText',"");
    $('#packaginga').textbox('setText',"");
}


/*添加按钮*/
function addabcd() {


    $.ajax({


        url:"/getinsertCommodity.action",
        type:"post",
        dataType:"text",
        data:{

            productnamea: $('#productnamea').textbox('getText'),

            commodityreferreda: $('#commodityreferreda').textbox('getText'),

            originofgoodsa: $('#originofgoodsa').textbox('getText'),

            unita: $('#unita').textbox('getText'),

            briefintroductiona: $('#briefintroductiona').textbox('getText'),

            approvalnumbera: $('#approvalnumbera').textbox('getText'),

            batchnumbera: $('#batchnumbera').textbox('getText'),

            specificationa: $('#specificationa').textbox('getText'),

            packaginga: $('#packaginga').textbox('getText'),

            suppliernamea:$('#suppliernamea').textbox('getValue')

        },
        success:function (data) {

            if (data=='Y'){
                alert("添加成功！")
                $('#win').window('close');
                $('#dg').datagrid('reload');
            }else if (data=='S'){
                alert("添加失败！")
            }else{

                alert("已有该商品！")
            }



        }


    })





}


          /* 删除*/
          function removeabc() {


              $.ajax({


                  url: "/getdeletecommodity.action",
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
              $.messager.confirm('删除商品', '您确定要删除', function(r){
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
                  title: '商品修改',
              })


          }


          /*取消按钮*/
          function iconnoabc() {



              $('#wing').window('close');


          }


          /*确定按钮*/
          function iconokabc() {


              $.ajax({


                  url:"/getupdatecommodityAll.action",
                  type:"post",
                  dataType:"text",
                  data:{

                      ida: $('#ida').textbox('getText'),

                      productnamea: $('#productnameb').textbox('getText'),

                      commodityreferreda: $('#commodityreferredb').textbox('getText'),

                      originofgoodsa: $('#originofgoodsb').textbox('getText'),

                      unita: $('#unitb').textbox('getText'),

                      briefintroductiona: $('#briefintroductionb').textbox('getText'),

                      approvalnumbera: $('#approvalnumberb').textbox('getText'),

                      batchnumbera: $('#batchnumberb').textbox('getText'),

                      specificationa: $('#specificationb').textbox('getText'),

                      packaginga: $('#packagingb').textbox('getText'),

                      suppliernamea:$('#suppliernamec').textbox('getValue'),


                      suppliernameb:$('#suppliernamec').textbox('getText')

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
   名称<input class="easyui-textbox"  style="width:180px" id="productname">
   <a class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchabc();">查看</a>
   <a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="addabc();">增加</a>
   <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="editabc();">修改</a>
   <a class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="abc();">删除</a>
</div>

<div style="display: none">

   <input class="easyui-textbox"  style="width:300px" id="ida">

</div>


<div id="win" style="display: none">
   <br><br>
&nbsp;&nbsp;&nbsp;名称：<input class="easyui-textbox"  style="width:300px" id="productnamea">
<br><br>
&nbsp;&nbsp;&nbsp;简称: <input class="easyui-textbox"  style="width:120px" id="commodityreferreda">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;产地:&nbsp;&nbsp;&nbsp;<input class="easyui-textbox"  style="width:100px" id="originofgoodsa">
<br><br>
&nbsp;&nbsp;&nbsp;单位&nbsp;:&nbsp;&nbsp;&nbsp; <input class="easyui-textbox"  style="width:335px" id="unita">
<br><br>
&nbsp;&nbsp;&nbsp;供应商:
   <input id="suppliernamea" name="suppliernamea" value="--请选择--">
   <script type="text/javascript">


       $(function () {
           $('#suppliernamea').combobox({
               url:'/selectsupplierAll.action',
               valueField:'id',
               textField:'suppliername'
           });
       })



   </script>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;简介: <input class="easyui-textbox"  style="width:100px" id="briefintroductiona">
<br><br>
&nbsp;&nbsp;&nbsp;批准文号: <input class="easyui-textbox"  style="width:120px" id="approvalnumbera">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;批号: <input class="easyui-textbox"  style="width:100px" id="batchnumbera">
<br><br>
&nbsp;&nbsp;&nbsp;规格：<input class="easyui-textbox"  style="width:120px" id="specificationa">
&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;包装: <input class="easyui-textbox"  style="width:120px" id="packaginga">

<br><br><br>
&nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;   &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;    &nbsp;
<a id="btna" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="addabcd();">添加</a>
&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;
<a id="buta" class="easyui-linkbutton" data-options="iconCls:'icon-redo'" onclick="redoabc();">重填</a>
</div>


<div id="wing" style="display: none">
   <br><br>
   &nbsp;&nbsp;&nbsp;名称：<input class="easyui-textbox"  style="width:300px" id="productnameb" disabled="disabled">
   <br><br>
   &nbsp;&nbsp;&nbsp;简称: <input class="easyui-textbox"  style="width:120px" id="commodityreferredb">
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  产地:&nbsp;&nbsp;&nbsp;<input class="easyui-textbox"  style="width:150px" id="originofgoodsb">
   <br><br>
   &nbsp;&nbsp;&nbsp;单位&nbsp;:&nbsp;&nbsp;&nbsp; <input class="easyui-textbox"  style="width:335px" id="unitb">
   <br><br>
   &nbsp;&nbsp;&nbsp;供应商:
   <input class="easyui-textbox"  style="width:335px" id="suppliernameb" disabled="disabled">
 <script type="text/javascript">


       $(function () {
           $('#suppliernamec').combobox({
               url:'/selectsupplierAll.action',
               valueField:'id',
               textField:'suppliername'
           });
       })



 </script>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   &nbsp;&nbsp;&nbsp;
   <br>
   &nbsp;&nbsp;简介: <input class="easyui-textbox"  style="width:180px" id="briefintroductionb">
   <br><br>
   &nbsp;&nbsp;&nbsp;批准文号: <input class="easyui-textbox"  style="width:120px" id="approvalnumberb">
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   &nbsp;&nbsp;&nbsp;批号: <input class="easyui-textbox"  style="width:100px" id="batchnumberb">
   <br><br>
   &nbsp;&nbsp;&nbsp;规格：<input class="easyui-textbox"  style="width:120px" id="specificationb">
   &nbsp;&nbsp;&nbsp;
   &nbsp;&nbsp;&nbsp;包装: <input class="easyui-textbox"  style="width:120px" id="packagingb">
   <br><br>
   &nbsp;&nbsp;&nbsp;供应商:
   <input id="suppliernamec" name="suppliernamec" value="--请选择--">
   <br><br><br>
   &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;    &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;   &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;    &nbsp;
   <a id="btnb" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="iconokabc();">确定</a>
   &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;
   &nbsp;&nbsp;&nbsp;
   <a id="butb" class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="iconnoabc();">取消</a>
</div>

</body>
</html>
