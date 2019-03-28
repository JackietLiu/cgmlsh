<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html >
<html>
<head>
    <title>客服信息</title>
    <t:base type="jquery,easyui,tools"></t:base>
</head>
<style>
    .methods{
        text-align: left;
        text-indent: 2em;
        line-height: 30px;
    }
    .methods span{
        font-size: 20px;
    }
    .methods img{
        float: right;
        margin-right: 50px;
    }
    .methodname{
        position: absolute;
        width: 85px;
        text-align: right;
        text-align-last: justify;
    }
    .methodname:after{
        display: inline-block;
        content: '';
        width: 100%;
        height: 0;
    }
    .methodname:before{
        position: absolute;
        left: 65px;
        content: '\FF1A';
    }
    .method{
        padding-left: 110px;
    }
    .content_card{
        margin: 10px 5px 0 5px;
        box-shadow: 2px 2px 10px #ccc;
        padding: 10px;
        background: #F0F8FF;
    }
    .csname{
        font-size: 30px;
        color: #FF8C00;
        text-align: center;
        font-family: Microsoft YaHei;

    }
    .img{
        height: 30px;
    }
    .hidediv{
        display: none;
    }
    .hideimg{
        right: 0px;
        position: absolute;
        box-shadow: 0 0 15px #aaa;
    }
</style>


<body style="overflow:hidden;overflow-y:auto;margin: 0; ">
<div style="font-size:40px;padding-top:20px;padding-bottom:40px;text-align: center;color: #FF8C00; ">联系方式</div>
<div style="text-align: center">
    <c:forEach items="${flist}" var="f">
        <c:forEach var="z" items="${f.zb}">
            <c:if test="${not empty f.cb}">
                <div class="content_card">
                    <div>
                        <span class="csname">${z.csname}</span>
                    </div>

                    <div style="padding-top: 10px;"></div>
                    <c:forEach var="c" items="${f.cb}">
                        <div class="methods">
                            <c:if test="${c.methodname !='QQ'}" >
                                <span class="methodname">${c.methodname}</span>
                                <span class="method">${c.method}</span>
                                <c:if test="${not empty c.picname}">
                                    <span><img id="${z.id}" class="img" onmouseenter="imghover('${z.id}')" src="${c.picname}"/></span>
                                    <div id="${z.id}_div" class="hidediv">
                                        <img class="hideimg" src="${c.picname}"/>
                                    </div>
                                </c:if>
                            </c:if>
                            <c:if test="${c.methodname =='QQ'}" >
                                <span class="methodname">QQ</span>
                                <span class="method">${c.method}</span>
                                <span> <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=${c.method}&site=qq&menu=yes"><img border="0" style="vertical-align: middle"  src="http://wpa.qq.com/pa?p=2:${c.method}:51" alt="点击这里给我发消息" title="点击这里给我发消息"/></a></span>

                            </c:if>
                        </div>
                    </c:forEach>
                </div>
            </c:if>
        </c:forEach>
    </c:forEach>
</div>
</body>
</html>
<script type="text/javascript">
    var tSCsInfoDListdictsData = {};
    $(function() {
        var promiseArr = [];
        initDictByCode(tSCsInfoDListdictsData, "isactive", promiseArr, "", "");
        initDictByCode(tSCsInfoDListdictsData, "methodname", promiseArr, "", "");

    });
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
    function imghover(id) {
        $("#"+id).hover(function () {
            $("#"+id+"_div").removeClass("hidediv");
        },function () {
            $("#"+id+"_div").addClass("hidediv");
        })
    }

</script>