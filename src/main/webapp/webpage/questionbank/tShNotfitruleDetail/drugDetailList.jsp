<!--thisisid: drugDetailList -->
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>医院上传药品列表</title>
 <t:base type="jquery,easyui,tools,DatePicker,autocomplete"></t:base>
 <%--  <link rel="stylesheet" href="myplug-in/mui/css/mui.min.css">
   <script type="text/javascript" src="myplug-in/mui/js/mui.min.js"></script>--%>
 <link rel="stylesheet" href="${webRoot}/plug-in/themes/naturebt/css/search-form.css">
</head>
<body>
<div class="easyui-layout" fit="true">
 <div region="center" style="padding:0px;border:0px">
  <table id="tShHospDrugListList"></table>
 </div>
 <div id = "tShHospDrugListListToolbar">
  <div class="toolbar-btn">
   <button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="update('查看','tShHospDrugListController.do?goUpdate&load=detail','tShHospDrugListList',768,500)">
    <i class="fa fa-edit"></i>
    <span>查看</span>
   </button>

   <button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="JeecgExcelExport('tShHospDrugListController.do?exportXls','tShHospDrugListList')">
    <i class="fa fa-upload"></i>
    <span>导出</span>
   </button>

  </div>
 </div>
</div>

<script>
    var tShHospDrugListListdictsData = {};
    $(function(){
        var promiseArr = [];
        initDictByCode(tShHospDrugListListdictsData,"id",promiseArr,"t_sh_hospital","hospnameshort");
        $.when.apply(null,promiseArr).done(function(){
            initDatagrid();
            $('#tShHospDrugListList').datagrid('getPager').pagination({
                beforePageText: '',
                afterPageText: '/{pages}',
                displayMsg: '{from}-{to}共 {total}条',
                showPageList: true,
                showRefresh: true
            });
            $('#tShHospDrugListList').datagrid('getPager').pagination({
                onBeforeRefresh: function(pageNumber, pageSize) {
                    $(this).pagination('loading');
                    $(this).pagination('loaded');
                }
            });
            loadSearchFormDicts($("#tShHospDrugListForm").find("select[name='hospid']"),"t_sh_hospital","id","select","医院ID");
        }).fail(function(){
            console.log("i'm sorry!it's unkown error that i can't resolve as yet");
        });
    });

    //zczadd begin   modify on  2019/3/13 10:37
    function before_commit(){
        var finalaction="tShHospDrugListController.do?before_commit";
        $.ajax({
            cache:true,
            type:"get",
            url:finalaction,
            data:"",
            dataType:"json",
            success: function(data){
                if(!data.success ){
                    $.messager.alert('提信息示', data.msg,"info");
                    return ;
                }

                if(data.success ) {
                    $.messager.confirm("操作提示", data.msg, function (data) {
                        if(data) {
                            var finalaction2="tShHospDrugListController.do?func_commit"
                            $.ajax({
                                cache: true,
                                type: "get",
                                url: finalaction2,
                                data: "",
                                dataType: "json",
                                success: function (data) {
                                    $.messager.alert('提信息示', data.msg,"info");
                                }
                            })
                        }else {
                            return ;
                        }

                    });

                }
            }
        })


    }

    function ImportXls() {
        var finalaction="tShHospDrugListController.do?func_beforeimport";
        $.ajax({
            cache:true,
            type:"get",
            url:finalaction,
            data:"",
            dataType:"json",
            success: function(data){
                if(!data.success ){
                    $.messager.confirm("操作提示", data.msg, function (data) {

                        if(data) {
                            openuploadwin('Excel导入', 'tShHospDrugListController.do?upload', "tShHospDrugListList");
                        }else {
                            return ;
                        }

                    });

                }

                if(data.success ){
                    openuploadwin('Excel导入', 'tShHospDrugListController.do?upload', "tShHospDrugListList");
                }
            }
        })

        //	openuploadwin('Excel导入', 'tShHospDrugListController.do?upload', "tShHospDrugListList");
    }
    //zczadd end modify  on  2019/3/13 10:37

    //easyui-datagrid实例化
    function initDatagrid(){
        var actionUrl = "tShNotfitruleDetailController.do?detailListGrid&hospid=${hospid}&detailsql=${detailsql}&field=id,commonname,gg,pcs,enterprisename,drugform,inprice,innum,rationnum,updateName,updateDate,createDate,createName,hospid,auditno,buyno,";
        $('#tShHospDrugListList').datagrid({
            url:actionUrl,
            idField: 'id',
            title: '',
            loadMsg: '数据加载中...',
            fit:true,
            fitColumns:false,
            striped:true,
            autoRowHeight: true,
            pageSize: 30,
            pagination:true,
            singleSelect:false,
            pageList:[10,30,50,100],
            rownumbers:true,
            showFooter:true,
            sortName:'createDate',
            sortOrder:'desc',
            toolbar: '#tShHospDrugListListToolbar',
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
                    field : "hospid",
                    title : "医院",
                    width : 120,
                    sortable: true,
                    formatter : function(value, rec, index) {
                        return listDictFormat(value,"id","t_sh_hospital");
                    }
                }
                ,{
                    field : "commonname",
                    title : "药品名称",
                    width : 120,
                    sortable: true,
                }

                ,{
                    field : "drugform",
                    title : "剂型",
                    width : 120,
                    sortable: true,
                }
                ,{
                    field : "gg",
                    title : "药品规格",
                    width : 120,
                    sortable: true,
                }

                ,{
                    field : "pcs",
                    title : "单位",
                    width : 120,
                    sortable: true,
                }
                ,{
                    field : "rationnum",
                    title : "转换比",
                    width : 120,
                    sortable: true,
                }
                ,{
                    field : "inprice",
                    title : "购进单价",
                    width : 120,
                    sortable: true,
                }
                ,{
                    field : "innum",
                    title : "入库数量",
                    width : 120,
                    sortable: true,
                }
                ,{
                    field : "enterprisename",
                    title : "厂家",
                    width : 120,
                    sortable: true,
                }
                ,{
                    field : "buyno",
                    title : "采购序号",
                    width : 120,
                    sortable: true,
                }

                ,{
                    field : "updateName",
                    title : "更新人名称",
                    width : 120,
                    sortable: true,
                    hidden : true,
                }
                ,{
                    field : "updateDate",
                    title : "更新日期",
                    width : 120,
                    sortable: true,
                    formatter : function(value, rec, index) {
                        return new Date().format('yyyy-MM-dd', value);
                    },
                    hidden : true,
                }
                ,{
                    field : "createDate",
                    title : "创建日期",
                    width : 120,
                    sortable: true,
                    formatter : function(value, rec, index) {
                        return new Date().format('yyyy-MM-dd', value);
                    },
                    hidden : true,
                }
                ,{
                    field : "createName",
                    title : "创建人名称",
                    width : 120,
                    sortable: true,
                    hidden : true,
                }

                ,{
                    field : "auditno",
                    title : "导入批号",
                    width : 120,
                    sortable: true,
                }

                ,{
                    field: 'opt',title: '操作',width: 150,hidden:true,
                    formatter: function(value, rec, index) {
                        if (!rec.id) {
                            return '';
                        }
                        var href = '';
                        href += "<a href='#'   class='ace_button'  onclick=delObj('tShHospDrugListController.do?doDel&id=" + rec.id + "','tShHospDrugListList')>  <i class=' fa fa-trash-o'></i> ";
                        href += "删除</a>&nbsp;";
                        return href;
                    }
                }
            ]],
            onLoadSuccess: function(data) {
                $("#tShHospDrugListList").datagrid("clearSelections");
                if (!false) {
                    if (data.total && data.rows.length == 0) {
                        var grid = $('#tShHospDrugListList');
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
        $('#tShHospDrugListList').datagrid('reload');
    }
    //easyui-datagrid搜索
    function doSearch(){
        var queryParams = $('#tShHospDrugListList').datagrid('options').queryParams;
        var actionUrl = "tShNotfitruleDetailController.do?detailListGrid&hospid=${hospid}&detailsql=${detailsql}&field=id,commonname,gg,pcs,enterprisename,drugform,inprice,innum,rationnum,updateName,updateDate,createDate,createName,hospid,auditno,buyno,";
        $('#tShHospDrugListForm').find(':input').each(function() {
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

        $('#tShHospDrugListList').datagrid({
            url: actionUrl,
            pageNumber: 1
        });
    }
    //easyui-datagrid重置搜索
    function resetSearch(){
        var queryParams = $('#tShHospDrugListList').datagrid('options').queryParams;
        $('#tShHospDrugListForm').find(':input').each(function() {
            if("checkbox"== $(this).attr("type")){
                $("input:checkbox[name='" + $(this).attr('name') + "']").attr('checked',false);
            }else if("radio"== $(this).attr("type")){
                $("input:radio[name='" + $(this).attr('name') + "']").attr('checked',false);
            }else{
                $(this).val("");
            }
            queryParams[$(this).attr('name')] = "";
        });
        $('#tShHospDrugListForm').find("input[type='checkbox']").each(function() {
            $(this).attr('checked', false);
        });
        $('#tShHospDrugListForm').find("input[type='radio']").each(function() {
            $(this).attr('checked', false);
        });
        var actionUrl = "tShNotfitruleDetailController.do?detailListGrid&hospid=${hospid}&detailsql=${detailsql}&field=id,commonname,gg,pcs,enterprisename,drugform,inprice,innum,rationnum,updateName,updateDate,createDate,createName,hospid=${hospid},auditno,buyno,";
        $('#tShHospDrugListList').datagrid({
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
        var arr = tShHospDrugListListdictsData[dictKey];
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
        var dicts = tShHospDrugListListdictsData[dictKey];
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