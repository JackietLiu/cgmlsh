<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="yiliao.entity.*"%>
<%@ page import="yiliao.itemdetail.service.impl.*"%>
<%
mypartial.ResourceUtil_Expand.consolePrintName(this.getClass(),"") ;
%>

<script> 
var strUrl=window.location.href;
var arrUrl=strUrl.split("/");
var strPage=arrUrl[arrUrl.length-1];
//alert(strPage);
</script>
 
<t:base type="jquery,easyui,tools,autocomplete,ztree"></t:base>
<!--add-start--Author:luobaoli  Date:20150607 for：增加表单树型列表-->
<!-- <script type= "text/javascript" src="plug-in/jquery/jquery-1.8.3.min.js"></script> 
 <link rel= "stylesheet" href= "plug-in/ztree/css/zTreeStyle.css" type="text/css"></link> 
 <script type= "text/javascript" src="plug-in/ztree/js/jquery.ztree.core-3.5.min.js"></script> 
	 <script type= "text/javascript" src="plug-in/ztree/js/jquery.ztree.excheck-3.5.min.js"></script>  -->
	 
<script type="text/javascript" language="javascript">
/**ztree的参数配置，setting主要是设置一些tree的属性，是本地数据源，还是远程，动画效果，是否含有复选框等等**/  
var setting = {
 check: { /**复选框**/
  enable: false,
  chkboxType: {"Y":"", "N":""}
 },
 view: {                                
  showLine : true,  
  expandSpeed: 300 //设置树展开的动画速度，IE6下面没效果，
 },                          
 data: {                                  
  simpleData: {   //简单的数据源，一般开发中都是从数据库里读取，API有介绍，这里只是本地的                         
   enable: true,
   idKey: "id",  //id和pid，这里不用多说了吧，树的目录级别
   pIdKey: "pid",
   rootPId: ""   //根节点
  }
 },
  callback: {  	   
	  onClick : clickNode 
	}  
};
function beforeClick(treeId, treeNode) {
 alert("beforeClick");
}
function onCheck(e, treeId, treeNode) {
 alert("onCheck");
}     

function clickNode(event, treeId, treeNode, clickFlag) {
    var zTree = $.fn.zTree.getZTreeObj("#theTree");
   //alert(JSON.stringify(treeNode));
    //alert(treeNode.id);
    var src; 
    	if(treeNode.pid=="" || treeNode.pid==null ||treeNode.pid=="undefined") src = "<%=request.getContextPath() %>/tbConfig2Controller.do?empty"
    	else src =  "<%=request.getContextPath() %>/tbConfig2Controller.do?rightPage&id=" +treeNode.id  ; 
    document.getElementById("myframe").src= src;
}

function addDict()
{
	 var zTree = $.fn.zTree.getZTreeObj("theTree");
	 var nodes = zTree.getSelectedNodes();
	 if (nodes.length==0 ||nodes == null) {
		  alert("请先选择一条记录，才可以增加选中记录的同级项目信息！");
         return ;
     }
	 document.getElementById("myframe").src= "<%=request.getContextPath() %>/tbConfig2Controller.do?goAdd&pid=" +nodes[0].pid  ;
}	 

function addsubDict()
{
	 var zTree = $.fn.zTree.getZTreeObj("theTree");
	 var nodes = zTree.getSelectedNodes();
	 if (nodes.length==0 ||nodes == null) {
		 alert("请先选择一条记录,才可以增加选中记录的下一级项目信息！");
         return ;
     }
	 document.getElementById("myframe").src= "<%=request.getContextPath() %>/tbConfig2Controller.do?goAdd&pid=" +nodes[0].id  ;
}	

function delDict()
{
	 var zTree = $.fn.zTree.getZTreeObj("theTree");
	 var nodes = zTree.getSelectedNodes();
	var finalaction = "tbConfig2Controller.do?doDel&id="+nodes[0].id;
	 
	$.ajax({
		cache:true,
		type:"post",
		url:finalaction,
		//data:"",
		dataType:"json",
		success: function(data){
		}		
	})  
}	 

var citynodes = ${citynodes };

$(document).ready(function(){//初始化ztree对象   
  var zTreeDemo = $.fn.zTree.init($("#theTree"),setting, citynodes);
});
</script>  
 
<!--add-end--Author:luobaoli  Date:20150607 for：增加表单树型列表-->

<div class="easyui-layout" fit="true">

<!--update-start--Author:luobaoli  Date:20150609 for：panel调整为默认关闭-->
<div region="west" style="width: 250px;" title="配置" split="true" collapsed="false">
<ul id="theTree" class="ztree">
</ul>
<!--update-end--Author:luobaoli  Date:20150609 for：panel调整为默认关闭-->
<div class="easyui-panel" style="padding:0px;border:0px" fit="true" border="false">

</div>
</div>
<div region="center" style="padding:0px;border:0px"  >  
<iframe id="myframe" name="myframe"   style="width:100%;height:100%;border:none;"> 

</iframe>
  
</div> 
</div>
