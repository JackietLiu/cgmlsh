<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线文档一览</title>
<t:base type="jquery,tools"></t:base>

<link rel="stylesheet" href="${webRoot}/plug-in/themes/naturebt/css/search-form.css">
</head>
<body>
<script type="text/javascript" src="${webRoot}/myplug-in/pdfobject/pdfobject.js"></script>
<div id="example1"></div>


<script>
	// 我的pdf文件放在项目的pdf文件夹下，名字叫做Java.pdf
	PDFObject.embed("${webRoot}/${filename}");
</script>
<%--<script>PDFObject.embed("${filename}", "#example1");</script>--%>
</body>
</html>