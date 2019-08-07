<!--thisisid: druglist4class.jsp  -->
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>药品目录清单</title>
 <t:base type="jquery,easyui,tools,DatePicker,autocomplete"></t:base>
 <link rel="stylesheet" href="${webRoot}/plug-in/themes/naturebt/css/search-form.css">
</head>
<body>
<div class="easyui-layout" fit="true">
 <div region="center" style="padding:0px;border:0px">
  <table id="tShDrugInfoList"></table>
 </div>
 <div id = "tShDrugInfoListToolbar">
  <div class="easyui-panel toolbar-search" style="display:none" data-options="doSize:false">
   <form id="tShDrugInfoForm" onkeydown="if(event.keyCode==13){doSearch();return false;}">
    <div class="seerch-div">
     <label>合同名称:</label>
     <div class="search-control">
      <input class="dts search-inp" type="text" name="contractname" placeholder="请输入合同名称"/>
     </div>
    </div>
    <div class="seerch-div">
     <label>采购序号:</label>
     <div class="search-control">
      <input class="dts search-inp" type="text" name="buyno" placeholder="请输入采购序号"/>
     </div>
    </div>
    <div class="seerch-div">
     <label>通用名:</label>
     <div class="search-control">
      <input class="dts search-inp" type="text" name="commonname" placeholder="请输入通用名"/>
     </div>
    </div>
    <div class="seerch-div">
     <label>生产企业全称:</label>
     <div class="search-control">
      <input class="dts search-inp" type="text" name="enterprisename" placeholder="请输入生产企业全称"/>
     </div>
    </div>
    <div class="seerch-div">
     <label>批准文号:</label>
     <div class="search-control">
      <input class="dts search-inp" type="text" name="registerno" placeholder="请输入批准文号"/>
     </div>
    </div>
    <div class="seerch-div">
     <label style="visibility:hidden">查询</label>
     <div>
      <button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="doSearch()">
       <i class="fa fa-search"></i>
       <span>查询</span>
      </button>

      <button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="resetSearch()">
       <i class="fa fa-refresh"></i>
       <span>重置</span>
      </button>
     </div>
    </div>
   </form>
  </div>
  <div class="toolbar-btn">


   <button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="update('查看','tShDrugInfoController.do?goUpdate&load=detail','tShDrugInfoList',908,500)">
    <i class="fa fa-search"></i>
    <span>查看</span>
   </button>

   <button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="$('.toolbar-search').slideToggle(function(){$('#tShDrugInfoList').datagrid('resize');});">
    <i class="fa fa-arrow-circle-left"></i>
    <span>检索</span>
   </button>
  </div>
 </div>
</div>

<script>
 var tShDrugInfoListdictsData = {};
 $(function(){
  var promiseArr = [];
  initDictByCode(tShDrugInfoListdictsData,"isactive",promiseArr,"","");
  initDictByCode(tShDrugInfoListdictsData,"id",promiseArr,"t_sh_drug_class","classname");
  $.when.apply(null,promiseArr).done(function(){
   initDatagrid();
   $('#tShDrugInfoList').datagrid('getPager').pagination({
    beforePageText: '',
    afterPageText: '/{pages}',
    displayMsg: '{from}-{to}共 {total}条',
    showPageList: true,
    showRefresh: true
   });
   $('#tShDrugInfoList').datagrid('getPager').pagination({
    onBeforeRefresh: function(pageNumber, pageSize) {
     $(this).pagination('loading');
     $(this).pagination('loaded');
    }
   });
  }).fail(function(){
   console.log("i'm sorry!it's unkown error that i can't resolve as yet");
  });
 });

 //easyui-datagrid实例化
 function initDatagrid(){
  var actionUrl = "tShDrugInfoController.do?datagrid&drugclass=${classid}&field=id,contractname,place,buyno,groupname,commonname,tradename,drugform,gg,rationnum,minpcs,pkccz,enterprisename,suppprice,isactive,agencyshortname,agencyname,memo,drugmemo,registerno,drugcodeent,updateName,updateDate,createDate,createName,drugclass,";
  $('#tShDrugInfoList').datagrid({
   url:actionUrl,
   idField: 'id',
   title: '',
   loadMsg: '数据加载中...',
   fit:true,
   fitColumns:false,
   striped:true,
   autoRowHeight: true,
   pageSize: 10,
   pagination:true,
   singleSelect:false,
   pageList:[10,30,50,100],
   rownumbers:true,
   showFooter:true,
   sortName:'createDate',
   sortOrder:'desc',
   toolbar: '#tShDrugInfoListToolbar',
   frozenColumns:[[]],
   columns:[[
    {field:'ck',checkbox:true}
    ,{
     field : "id",
     title : "id",
     width : 120,
     sortable: true,
     hidden:true,
    }
    ,{
     field : "contractname",
     title : "合同名称",
     width : 240,
     halign : "center",
     sortable: true,
     formatter : function (value) {
      return "<span title='" + value + "'>" + value + "</span>";
     }
    }
    ,{
     field : "place",
     title : "交易场",
     width : 100,
     sortable: true,
     hidden:true,
    }
    ,{
     field : "buyno",
     title : "采购序号",
     width : 120,
     align : "center",
     sortable: true,
    }
    ,{
     field : "groupname",
     title : "评审分组",
     width : 90,
     align : "center",
     sortable: true,
    }
    ,{
     field : "commonname",
     title : "通用名",
     width : 160,
     halign : "center",
     sortable: true,
     formatter : function (value) {
      return "<span title='" + value + "'>" + value + "</span>";
     }
    }
    ,{
     field : "tradename",
     title : "商品名",
     width : 120,
     sortable: true,
     hidden:true,
    }
    ,{
     field : "drugform",
     title : "剂型",
     width : 80,
     align : "center",
     sortable: true,
    }
    ,{
     field : "gg",
     title : "规格",
     width : 120,
     align : "center",
     sortable: true,
     formatter : function (value) {
      return "<span title='" + value + "'>" + value + "</span>";
     }
    }
    ,{
     field : "rationnum",
     title : "转换比",
     width : 120,
     sortable: true,
     hidden:true,
    }
    ,{
     field : "minpcs",
     title : "最小包装单位",
     width : 120,
     align : "center",
     sortable: true,
    }
    ,{
     field : "pkccz",
     title : "包装材质",
     width : 120,
     sortable: true,
     hidden:true,
    }
    ,{
     field : "enterprisename",
     title : "生产企业全称",
     width : 120,
     halign : "center",
     sortable: true,
     formatter : function (value) {
      return "<span title='" + value + "'>" + value + "</span>";
     }
    }
    ,{
     field : "suppprice",
     title : "供应价",
     width : 80,
     sortable: true,
     align : "center",
    }
    ,{
     field : "isactive",
     title : "状态",
     width : 80,
     align : "center",
     sortable: true,
     formatter : function(value, rec, index) {
      return listDictFormat(value,"isactive","");

     }
    }
    ,{
     field : "agencyshortname",
     title : "经销商简称",
     width : 120,
     sortable: true,
     hidden:true,
    }
    ,{
     field : "agencyname",
     title : "经销商全称",
     width : 120,
     sortable: true,
     hidden:true,
    }
    ,{
     field : "memo",
     title : "备注",
     width : 120,
     sortable: true,
     hidden:true,
    }
    ,{
     field : "drugmemo",
     title : "产品备注",
     width : 120,
     sortable: true,
     hidden:true,
    }
    ,{
     field : "registerno",
     title : "批准文号",
     width : 160,
     sortable: true,
     align : "center",
     formatter : function (value) {
      return "<span title='" + value + "'>" + value + "</span>";
     }

    }
    ,{
     field : "drugcodeent",
     title : "公司商品代码",
     width : 120,
     sortable: true,
     hidden:true,
    }
    ,{
     field : "updateName",
     title : "更新人名称",
     width : 120,
     sortable: true,
     hidden:true,
    }
    ,{
     field : "updateDate",
     title : "更新日期",
     width : 120,
     sortable: true,
     hidden:true,
     formatter : function(value, rec, index) {
      return new Date().format('yyyy-MM-dd', value);
     }
    }
    ,{
     field : "createDate",
     title : "创建日期",
     width : 120,
     sortable: true,
     hidden:true,
     formatter : function(value, rec, index) {
      return new Date().format('yyyy-MM-dd', value);
     }
    }
    ,{
     field : "createName",
     title : "创建人名称",
     width : 120,
     sortable: true,
     hidden:true,
    }
    ,{
     field : "drugclass",
     title : "药品类别",
     width : 120,
     sortable: true,
     align : "center",
     formatter : function(value, rec, index) {
      return listDictFormat(value,"id","t_sh_drug_class");
     }
    }
    ,{
     field: 'opt',title: '操作',width: 150,align : "center",
     formatter: function(value, rec, index) {
      if (!rec.id) {
       return '';
      }
      var href = '';
      href += "<a href='#'   class='ace_button'  onclick=delObj('tShDrugInfoController.do?doDel&id=" + rec.id + "','tShDrugInfoList')>  <i class=' fa fa-trash-o'></i> ";
      href += "删除</a>&nbsp;";
      return href;
     }
    }
   ]],
   onLoadSuccess: function(data) {
    $("#tShDrugInfoList").datagrid("clearSelections");
    if (!false) {
     if (data.total && data.rows.length == 0) {
      var grid = $('#tShDrugInfoList');
      var curr = grid.datagrid('getPager').data("pagination").options.pageNumber;
      grid.datagrid({
       pageNumber: (curr - 1)
      });
     }
    }
   }
  });
 }
 //easyui-datagrid重新加载
 function reloadTable() {
  $('#tShDrugInfoList').datagrid('reload');
 }
 //easyui-datagrid搜索
 function doSearch(){
  var queryParams = $('#tShDrugInfoList').datagrid('options').queryParams;
  var actionUrl = "tShDrugInfoController.do?datagrid&drugclass=${classid}&field=id,contractname,place,buyno,groupname,commonname,tradename,drugform,gg,rationnum,minpcs,pkccz,enterprisename,suppprice,isactive,agencyshortname,agencyname,memo,drugmemo,registerno,drugcodeent,updateName,updateDate,createDate,createName,drugclass,";
  $('#tShDrugInfoForm').find(':input').each(function() {
   var paramName = $(this).attr('name');
   if(!!paramName){
    if("checkbox"== $(this).attr("type")){
     queryParams[paramName] = getCheckboxVal(paramName);
    }else if("radio"== $(this).attr("type")){
     queryParams[paramName] = getRadioVal(paramName);
    }else{
     queryParams[paramName] = $(this).val();
    }
   }
  });

  $('#tShDrugInfoList').datagrid({
   url: actionUrl,
   pageNumber: 1
  });
 }
 //easyui-datagrid重置搜索
 function resetSearch(){
  var queryParams = $('#tShDrugInfoList').datagrid('options').queryParams;
  $('#tShDrugInfoForm').find(':input').each(function() {
   if("checkbox"== $(this).attr("type")){
    $("input:checkbox[name='" + $(this).attr('name') + "']").attr('checked',false);
   }else if("radio"== $(this).attr("type")){
    $("input:radio[name='" + $(this).attr('name') + "']").attr('checked',false);
   }else{
    $(this).val("");
   }
   queryParams[$(this).attr('name')] = "";
  });
  $('#tShDrugInfoForm').find("input[type='checkbox']").each(function() {
   $(this).attr('checked', false);
  });
  $('#tShDrugInfoForm').find("input[type='radio']").each(function() {
   $(this).attr('checked', false);
  });
  var actionUrl = "tShDrugInfoController.do?datagrid&drugclass=${classid}&field=id,contractname,place,buyno,groupname,commonname,tradename,drugform,gg,rationnum,minpcs,pkccz,enterprisename,suppprice,isactive,agencyshortname,agencyname,memo,drugmemo,registerno,drugcodeent,updateName,updateDate,createDate,createName,drugclass,";
  $('#tShDrugInfoList').datagrid({
   url: actionUrl,
   pageNumber: 1
  });
 }

 //加载字典数据
 function initDictByCode(dictObj,code,promiseArr,table,text){
  var dictKey = code;
  if(code=="id"){
   //如果当前dictcode为id那么，此处的字典对象对应的key为"表名+id"
   dictKey = table+code;
  }
  if(!dictObj[dictKey]){
   var url = "systemController.do?typeListJson&typeGroupName="+code;
   if(table){
    url += "&dicTable="+table+"&dicText="+text;
   }
   var dictAjax = jQuery.ajax({
    url:url,
    type:"GET",
    dataType:"JSON",
    success: function (back) {
     if(back.success){
      dictObj[dictKey]= back.obj;
     }
    }
   });
   promiseArr.push(dictAjax);
  }
 }
 //加载form查询数据字典项
 function loadSearchFormDicts(obj,table,code,type,name){
  var html = "";
  var dictKey = code;
  if(code=="id"){
   dictKey = table+code;
  }
  var arr = tShDrugInfoListdictsData[dictKey];
  for(var a = 0;a < arr.length;a++){
   if("select"== type){
    if(a==0){
     html+="<option value = '' style='display: none'> 请选择"+name+"</option>";
    }
    html+="<option value = '"+arr[a].typecode+"'>"+arr[a].typename+"</option>";
   }else{
    if(!arr[a].typecode){
    }else{
     html+="<input name = '"+name+"' type='"+type+"' value = '"+arr[a].typecode+"'>"+arr[a].typename +"&nbsp;&nbsp;";
    }
   }
  }
  obj.html(html);
 }
 //获取Checkbox的值
 function getCheckboxVal(name){
  var result = new Array();
  $("input[name='" + name + "']:checkbox").each(function() {
   if ($(this).is(":checked")) {
    result.push($(this).attr("value"));
   }
  });
  return result.join(",");
 }
 //获取radio的值
 function getRadioVal(name){
  var v = $('input:radio[name="'+name+'"]:checked').val();
  if(!v){
   v ="";
  }
  return v;
 }
 //列表数据字典项格式化
 function listDictFormat(value,code,table){
  if (!value) return '';
  var dictKey = code;
  if(code=="id"){
   dictKey = table+code;
  }
  var dicts = tShDrugInfoListdictsData[dictKey];
  var valArray = value.split(',');
  var showVal = '';
  if (valArray.length > 1) {
   for (var k = 0; k < valArray.length; k++) {
    if(dicts && dicts.length>0){
     for(var a = 0;a < dicts.length;a++){
      if(dicts[a].typecode ==valArray[k]){
       showVal = showVal + dicts[a].typename + ',';
       break;
      }
     }
    }
   }
   showVal=showVal.substring(0, showVal.length - 1);
  }else{
   if(dicts && dicts.length>0){
    for(var a = 0;a < dicts.length;a++){
     if(dicts[a].typecode == value){
      showVal =  dicts[a].typename;
      break;
     }
    }
   }
  }
  if(showVal==''){
   showVal = value;
  }
  return showVal;
 }
</script>
</body>
</html>