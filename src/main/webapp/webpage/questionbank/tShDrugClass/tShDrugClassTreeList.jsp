<!--thisisid: tShDrugClassTreeList.jsp  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%@ page import="java.util.*"%>
<%
	String __jspName = this.getClass().getSimpleName().replaceAll("_", ".");
	System.out.println("current page:"+ __jspName);
%>
<script>
    var strUrl=window.location.href;
    var arrUrl=strUrl.split("/");
    var strPage=arrUrl[arrUrl.length-1];
    //alert(strPage);
</script>

<t:base type="jquery,easyui,tools"></t:base>
<!--add-start--Author:luobaoli  Date:20150607 for：增加表单树型列表-->
<link rel= "stylesheet" href= "plug-in/ztree/css/zTreeStyle.css" type="text/css"></link>
<script type= "text/javascript" src="plug-in/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type= "text/javascript" src="plug-in/ztree/js/jquery.ztree.excheck-3.5.min.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/ztreeCreator.js"></script>
<link rel= "stylesheet" href= "myplug-in/sweetalert/sweetalert2.min.css" type="text/css"></link>
<script type="text/javascript" src="myplug-in/sweetalert/sweetalert2.min.js"></script>


<script type="text/javascript" language="javascript">
    var allnode;
    /**ztree的参数配置，setting主要是设置一些tree的属性，是本地数据源，还是远程，动画效果，是否含有复选框等等**/
    var setting = {
        check: { /**复选框**/
            enable: false,
            chkboxType: {"Y":"", "N":""}
        },
        view: {
            showLine : true,
            expandSpeed: 300 ,//设置树展开的动画速度，IE6下面没效果，
            fontCss: getFontCss
        },
        async: {
            enable:true
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
        var zTree = $.fn.zTree.getZTreeObj("theTree");
        var nodes = zTree.getSelectedNodes();
        allnode = zTree.getSelectedNodes();
        //  alert(JSON.stringify(treeNode));
        //    alert(treeNode.id);
        document.getElementById("myframe").src= "<%=request.getContextPath() %>/tShDrugClassController.do?goUpdateTree&id=" +treeNode.id;
    }

    function addDict()
    {
        var zTree = $.fn.zTree.getZTreeObj("theTree");
        var nodes = zTree.getSelectedNodes();
        allnode = zTree.getSelectedNodes();
        if (nodes.length==0 ||nodes == null) {
            alert("请先选择一条记录，才可以增加选中记录的同级项目信息！");
            return ;
        }
        document.getElementById("myframe").src= "<%=request.getContextPath() %>/tShDrugClassController.do?goTreeAdd&id="+nodes[0].id+"&level=same";

    }

    function addsubDict()
    {
        var zTree = $.fn.zTree.getZTreeObj("theTree");
        var nodes = zTree.getSelectedNodes();
        allnode = zTree.getSelectedNodes();
        if (nodes.length==0 ||nodes == null) {
            alert("请先选择一条记录,才可以增加选中记录的下一级项目信息！");
            return ;
        }
        document.getElementById("myframe").src= "<%=request.getContextPath() %>/tShDrugClassController.do?goTreeAdd&id="+nodes[0].id;
    }

    function delDict(){
        var zTree = $.fn.zTree.getZTreeObj("theTree");
        var nodes = zTree.getSelectedNodes();

        if (nodes[0].children){
            swal({
                title: "警告!",
                text: "存在下一级药品类别，无法直接删除！",
                type: "warning",
                showCancelButton: false,
                confirmButtonColor: '#3085d6',
                confirmButtonText: '好的'
            });
		}else {
            swal({
                title: '确定删除该类别吗？',
                text: "删除操作将不可逆",
                type: 'question',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                cancelButtonText: '我再想想',
                confirmButtonText: '直接删除'
            }).then(function(isConfirm) {
                if (isConfirm) {
                    var finalaction = "tShDrugClassController.do?doDel&id="+nodes[0].id ;
                    $.ajax({
                        cache:true,
                        type:"post",
                        url:finalaction,
                        //data:"",
                        dataType:"json",
                        success: function(ret){
                            reloadTree();
                            swal(
                                '',
                                '删除成功',
                                'success'
                            );
                        }
                    });

                }
            })

		}

    }

    var citynodes = ${citynodes };
    function reloadTree() {
        window.location.href="tShDrugClassController.do?tree";
    }
    $(document).ready(function(){//初始化ztree对象
        var zTreeDemo = $.fn.zTree.init($("#theTree"),setting, citynodes);
    });
    var lastValue = "";
    var nodeList = [];
    function searchDict(){

        var zTree = $.fn.zTree.getZTreeObj("theTree");
        var value = $.trim($("#keyword").get(0).value);
        if ($("#keyword").hasClass("empty")) {
            value = "";
        }
        if (value === "") return;
        // if (lastValue === value) return;
        updateNodes(false );

        lastValue = value;
        nodeList = zTree.getNodesByParamFuzzy("name", value);
        if(nodeList.length == 0)
        {
            nodeList = zTree.getNodesByParamFuzzy("Value", value)
        }
        zTree.expandNode(false);
        updateNodes(true );
    }
    function updateNodes(highlight ) {
        var	zTree = $.fn.zTree.getZTreeObj("theTree");
        for( var i=0, l=nodeList.length; i<l; i++) {
            nodeList[i].highlight = highlight;
            if( nodeList[i].getParentNode()!=null)
            {
                nodeList[i].getParentNode().Open = highlight;
                zTree.expandNode(nodeList[i].getParentNode().getParentNode(),highlight,false,false);
                zTree.expandNode(nodeList[i].getParentNode(),highlight,false,false);
                zTree.updateNode(nodeList[i]);
            }
        }
    }
    function getFontCss(treeId, treeNode) {
        return (!!treeNode.highlight) ? {color:"#A60000", "font-weight":"bold"} : {color:"#333", "font-weight":"normal"};
    }
</script>

<!--add-end--Author:luobaoli  Date:20150607 for：增加表单树型列表-->

<div class="easyui-layout" fit="true">
	<div  region="north" style="height: 50px;">
		关键字:  <input id="keyword" name="keyword" type="text" style="width: 150px"
					 class="inputxt"  ignore="ignore" />

		<button type=button class="tool-btn tool-btn-default tool-btn-xs" onclick="searchDict();">
			<i class="fa fa-search"></i>
			<span>字典中查找</span></button>
		<button type=button class="tool-btn tool-btn-default tool-btn-xs" onclick="addDict();">
			<i class="fa fa-plus"></i>
			<span>增加同级</span></button>
		<button type=button class="tool-btn tool-btn-default tool-btn-xs" onclick="addsubDict();">
			<i class="fa fa-plus"></i>
			<span>增加下一级</span></button>
		<button type=button class="tool-btn tool-btn-default tool-btn-xs" onclick="delDict();">
			<i class="fa fa-trash"></i>
			<span>删除</span></button>
		<%--<input type="button" value="增加同级" onclick="addDict();" style="margin-top: 10px;border:1px solid  #B3B3B3 ;width: 70px;height: 25px ;color:#990000 ">--%>
		<%--<input type="button" value="增加下一级" onclick="addsubDict();" style="margin-top: 10px;border:1px solid  #B3B3B3;width: 70px;height: 25px;color:#990000  ">--%>
		<%--<input type="button" value="增加结果选项" onclick="addsubDictli();" style="margin-top: 10px;border:1px solid  #B3B3B3;width: 90px;height: 25px ;color:#990000 ">--%>
		<%--<input type="button" value="删除" onclick="delDict();" style="margin-top: 10px;border:1px solid #B3B3B3;width: 70px;height: 25px ;color:#990000 ">--%>

	</div>
	<!--update-start--Author:luobaoli  Date:20150609 for：panel调整为默认关闭-->
	<div region="west" style="width: 250px;overflow: scroll;" title="药品类别树" split="true" collapsed="false">
		<ul id="theTree" class="ztree">
		</ul>
	</div>
	<div region="center" style="padding:0px;border:0px"  >
		<iframe id="myframe" name="myframe" scrolling="no"  frameborder="0" style="width:100%;height:100%;">

		</iframe>

	</div>
</div>
