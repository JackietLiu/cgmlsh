<!--thisisid: tShDrugValueInfoList.jsp  -->
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>一致性评价清单</title>
 <t:base type="jquery,easyui,tools,DatePicker,autocomplete"></t:base>
 <link rel="stylesheet" href="${webRoot}/plug-in/themes/naturebt/css/search-form.css">
</head>
<body>
<div class="easyui-layout" fit="true">
 <div region="center" style="padding:0px;border:0px">
  <table id="tShDrugValueInfoList"></table>
 </div>
 <div id = "tShDrugValueInfoListToolbar">
  <div class="easyui-panel toolbar-search" style="display:none" data-options="doSize:false">
   <form id="tShDrugValueInfoForm" onkeydown="if(event.keyCode==13){doSearch();return false;}">
    <div class="seerch-div">
     <label>批准文号:</label>
     <div class="search-control">
      <input class="dts search-inp" type="text" name="registerno" placeholder="请输入批准文号"/>
     </div>
    </div>
    <div class="seerch-div">
     <label>产品编号:</label>
     <div class="search-control">
      <input class="dts search-inp" type="text" name="buyno" placeholder="请输入产品编号"/>
     </div>
    </div>
    <div class="seerch-div">
     <label>药品名称:</label>
     <div class="search-control">
      <input class="dts search-inp" type="text" name="commonname" placeholder="请输入药品名称"/>
     </div>
    </div>
    <div class="seerch-div">
     <label>生产厂家:</label>
     <div class="search-control">
      <input class="dts search-inp" type="text" name="enterprisename" placeholder="请输入生产厂家"/>
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
   <c:if test="${fn:contains(currentroleids,'8a8ab0b246dc81120146dc8181870050')}">
   <button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="add('录入','tShDrugValueInfoController.do?goAdd','tShDrugValueInfoList',768,500)">
    <i class="fa fa-plus"></i>
    <span>录入</span>
   </button>
    <button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="update('编辑','tShDrugValueInfoController.do?goUpdate','tShDrugValueInfoList',768,500)">
     <i class="fa fa-edit"></i>
     <span>编辑</span>
    </button>
    <button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="deleteALLSelect('批量删除','tShDrugValueInfoController.do?doBatchDel','tShDrugValueInfoList',null,null)">
     <i class="fa fa-trash"></i>
     <span>批量删除</span>
    </button>

    <button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="openuploadwin('Excel导入', 'tShDrugValueInfoController.do?upload', 'tShDrugValueInfoList')">
     <i class="fa fa-download"></i>
     <span>导入</span>
    </button>
   </c:if>

   <button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="update('查看','tShDrugValueInfoController.do?goUpdate&load=detail','tShDrugValueInfoList',768,500)">
    <i class="fa fa-search"></i>
    <span>查看</span>
   </button>

   <button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="JeecgExcelExport('tShDrugValueInfoController.do?exportXls','tShDrugValueInfoList')">
    <i class="fa fa-upload"></i>
    <span>导出</span>
   </button>

   <button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="JeecgExcelExport('tShDrugValueInfoController.do?exportXlsByT','tShDrugValueInfoList')">
    <i class="fa fa-upload"></i>
    <span>模版下载</span>
   </button>

   <button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="$('.toolbar-search').slideToggle(function(){$('#tShDrugValueInfoList').datagrid('resize');});">
    <i class="fa fa-arrow-circle-left"></i>
    <span>检索</span>
   </button>
  </div>
 </div>
</div>

<script>
    var tShDrugValueInfoListdictsData = {};
    $(function(){
        var promiseArr = [];
        $.when.apply(null,promiseArr).done(function(){
            initDatagrid();
            $('#tShDrugValueInfoList').datagrid('getPager').pagination({
                beforePageText: '',
                afterPageText: '/{pages}',
                displayMsg: '{from}-{to}共 {total}条',
                showPageList: true,
                showRefresh: true
            });
            $('#tShDrugValueInfoList').datagrid('getPager').pagination({
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
        var actionUrl = "tShDrugValueInfoController.do?datagrid&field=id,registerno,buyno,commonname,drugform,gg,enterprisename,ntresult,jsresult,isbasedrug,updateName,updateDate,createDate,createName,inprice,";
        $('#tShDrugValueInfoList').datagrid({
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
            toolbar: '#tShDrugValueInfoListToolbar',
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
                    field : "commonname",
                    title : "药品名称",
                    width : 160,
                    sortable: true,
                    align : "center",
                }
                ,{
                    field : "drugform",
                    title : "剂型",
                    width : 120,
                    sortable: true,
                    align : "center",
                }
                ,{
                    field : "gg",
                    title : "规格",
                    width : 120,
                    sortable: true,
                    align : "center",
                }
                ,{
                    field : "enterprisename",
                    title : "生产厂家",
                    width : 200,
                    sortable: true,
                    halign : "center",
              formatter : function (value) {
               return "<span title='" + value + "'>" + value + "</span>";
              }
                }
             ,{
              field : "registerno",
              title : "批准文号",
              width : 160,
              sortable: true,
              align : "center",
             }
             ,{
              field : "buyno",
              title : "产品编号",
              width : 120,
              sortable: true,
              align : "center",
             }
                ,{
                    field : "ntresult",
                    title : "南通入围结果",
                    width : 120,
                    sortable: true,
              align : "center",
                }
                ,{
                    field : "jsresult",
                    title : "江苏入围结果",
                    width : 120,
                    sortable: true,
              align : "center",
                }
                ,{
                    field : "isbasedrug",
                    title : "国家基药",
                    width : 120,
                    sortable: true,
              align : "center",
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
                    field : "inprice",
                    title : "购进单价",
                    width : 120,
                    sortable: true,
              align : "center",
                }

                ,{
                    field: 'opt',title: '操作',width: 150,
                    formatter: function(value, rec, index) {
                        if (!rec.id) {
                            return '';
                        }
                        var href = '';
                        href += "<a href='#'   class='ace_button'  onclick=delObj('tShDrugValueInfoController.do?doDel&id=" + rec.id + "','tShDrugValueInfoList')>  <i class=' fa fa-trash-o'></i> ";
                        href += "删除</a>&nbsp;";
                        return href;
                    }
                }
            ]],
            onLoadSuccess: function(data) {
                $("#tShDrugValueInfoList").datagrid("clearSelections");
                if (!false) {
                    if (data.total && data.rows.length == 0) {
                        var grid = $('#tShDrugValueInfoList');
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
        $('#tShDrugValueInfoList').datagrid('reload');
    }
    //easyui-datagrid搜索
    function doSearch(){
        var queryParams = $('#tShDrugValueInfoList').datagrid('options').queryParams;
        var actionUrl = "tShDrugValueInfoController.do?datagrid&field=id,registerno,buyno,commonname,drugform,gg,enterprisename,ntresult,jsresult,isbasedrug,updateName,updateDate,createDate,createName,inprice,";
        $('#tShDrugValueInfoForm').find(':input').each(function() {
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

        $('#tShDrugValueInfoList').datagrid({
            url: actionUrl,
            pageNumber: 1
        });
    }
    //easyui-datagrid重置搜索
    function resetSearch(){
        var queryParams = $('#tShDrugValueInfoList').datagrid('options').queryParams;
        $('#tShDrugValueInfoForm').find(':input').each(function() {
            if("checkbox"== $(this).attr("type")){
                $("input:checkbox[name='" + $(this).attr('name') + "']").attr('checked',false);
            }else if("radio"== $(this).attr("type")){
                $("input:radio[name='" + $(this).attr('name') + "']").attr('checked',false);
            }else{
                $(this).val("");
            }
            queryParams[$(this).attr('name')] = "";
        });
        $('#tShDrugValueInfoForm').find("input[type='checkbox']").each(function() {
            $(this).attr('checked', false);
        });
        $('#tShDrugValueInfoForm').find("input[type='radio']").each(function() {
            $(this).attr('checked', false);
        });
        var actionUrl = "tShDrugValueInfoController.do?datagrid&field=id,registerno,buyno,commonname,drugform,gg,enterprisename,ntresult,jsresult,isbasedrug,updateName,updateDate,createDate,createName,inprice,";
        $('#tShDrugValueInfoList').datagrid({
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
        var arr = tShDrugValueInfoListdictsData[dictKey];
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
        var dicts = tShDrugValueInfoListdictsData[dictKey];
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