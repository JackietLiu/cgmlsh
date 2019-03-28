<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%
String __jspName = this.getClass().getSimpleName().replaceAll("_", ".");
System.out.println("current page:"+ __jspName.replaceAll(".005f", "_").replaceAll(".002d", "-"));
%> 
<script> 
var strUrl=window.location.href;
var arrUrl=strUrl.split("/");
var strPage=arrUrl[arrUrl.length-1];
//window.clipboardData.setData("Text",strPage);  
//alert(strPage);
</script>

  <t:dgCol title="类别"  field="eventtype"   query="true" queryMode="single" dictionary="t_b_eventtype_list where isactive='1',id,name" width="60"></t:dgCol>
  <t:dgCol title="活动说明"  field="eventdescribe"    queryMode="single"  width="200"></t:dgCol>
  <t:dgCol title="状态"  field="eventstate"   query="true" queryMode="single" dictionary="eventstate" width="60"></t:dgCol>
 
   <button type=button  class="btn btn-normal btn-xs" id="save" name="save"
 onclick="item_detail_edit_save();">
<i class="fa fa-save"></i>
<span class="bigger-110 no-text-shadow">保存</span></button>   