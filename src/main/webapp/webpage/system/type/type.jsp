<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: show" scroll="no"> 
<t:formvalid formid="formobj" layout="div"   dialog="true" action="systemController.do?saveType">
    <input name="id" type="hidden" value="${type.id }">
    <input name="TSTypegroup.id" type="hidden" value="${typegroupid}">
    <fieldset class="step">
        <div class="form">
            <label class="Validform_label"> <t:mutiLang langKey="lang.dictionary.type"/>: </label>
            <input readonly="true" class="inputxt" value="${typegroupname }">
        </div>
        <%--// add-end--Author:zhangguoming  Date:20140928 for：添加显示字段--%>
        <div class="form">
            <label class="Validform_label"> <t:mutiLang langKey="dict.name"/>: </label>
            <input name="typename" class="inputxt" value="${type.typename }" 
            datatype="/^[A-Za-z0-9\u4E00-\u9FA5\uf900-\ufa2d\.\s]{1,50}$/">
            <span class="Validform_checktip"><t:mutiLang langKey="common.range1to50" /></span>
        </div>
        <div class="form">
            <label class="Validform_label"> <t:mutiLang langKey="dict.code"/>: </label>
            <input name="typecode" class="inputxt" value="${type.typecode }" 
            datatype="/^[A-Za-z0-9\u4E00-\u9FA5\uf900-\ufa2d\.\s]{1,50}$/"
                   ajaxurl="systemController.do?checkType&code=${type.typecode }&typeGroupCode=${typegroup.typegroupcode}">
            <span class="Validform_checktip"><t:mutiLang langKey="common.range1to10" /></span>
        </div>
        <div class="form">
            <label class="Validform_label"><t:mutiLang langKey="dict.order"/>: </label>
            <input name="orderNum" class="inputxt" value="${type.orderNum}" 
            datatype="/\b\d{1,3}\b/g" errormsg="请输入一至三位整数">
            <span class="Validform_checktip">请输入一至三位整数</span>
        </div>        
               
          <div class="form">
            <label class="Validform_label">系统必须: </label>
            <t:dictSelect field="issysrequired" typeGroupCode="sf10"
					hasLabel="false" defaultVal="${type.issysrequired }"></t:dictSelect>
            <span class="Validform_checktip"> </span>
        </div>
        <div class="form">
            <label class="Validform_label"> 分值: </label>
            <input name="score" class="inputxt" value="${type.score }"  >
            <span class="Validform_checktip"> 分值</span>
        </div>        
            
        <div class="form">
            <label class="Validform_label"> 子系统: </label>
            <input name="appid" class="inputxt" value="${type.appid }"  >
            <span class="Validform_checktip"> </span>
        </div>
        
           <div class="form">
            <label class="Validform_label"> 设置: </label>
            <input name="propertyvalue" class="inputxt" value="${type.propertyvalue }"  
                   >
            <span class="Validform_checktip"> </span>
        </div>
        
         <div class="form">
            <label class="Validform_label"> 在用: </label>
            <t:dictSelect field="isactive" typeGroupCode="isactive"
					hasLabel="false" defaultVal="${type.isactive }"></t:dictSelect>
			</div>
            <span class="Validform_checktip"> </span>
        </div>   
        
    </fieldset>
</t:formvalid>
</body>
</html>
