<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--360浏览器优先以webkit内核解析-->
    <title></title>
    <link rel="shortcut icon" href="images/favicon.ico">
    <link href="plug-in/hplus/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="plug-in/hplus/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="plug-in/hplus/css/animate.css" rel="stylesheet">
    <link href="plug-in/hplus/css/style.css?v=4.1.0" rel="stylesheet">
    <link rel="stylesheet" href="plug-in/themes/fineui/main/iconfont.css">
    <script src="plug-in/laydate/laydate.js"></script>
    <style type="text/css">
        .gray-bg{
            background-color: #e9ecf3;
        }
        ::-webkit-scrollbar {
            width: 6px;
            background-color: transparent;
        }
        ::-webkit-scrollbar-thumb {
            background-color: #ccc;
            border-radius: 6px;
        }
        ::-webkit-scrollbar-track{
            background-color: transparent;
        }

    </style>
</head>
<body class="gray-bg">

<div class="wrapper wrapper-content">
    <div class="col-sm-6">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>规则描述</h5>
            </div>
            <div class="ibox-content no-padding" style="height: 400px;overflow: auto;">
                <div class="panel-body">
                    <div class="panel-group" id="ruledescribe">
                        <c:forEach items="${rdlist}" var="rd">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h5 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#ruledescribe" href="#${rd.id}">${rd.rulename}</a>
                                </h5>
                            </div>
                            <div id="${rd.id}" class="panel-collapse collapse">
                                <div class="panel-body">
                                    ${rd.ruledesc}
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-6">
        <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>审核结果</h5>
                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>
                </div>
            </div>
            <div class="ibox-content" style="height: 400px;overflow: auto;">
                <table class="table table-hover no-margins">
                    <thead>
                    <tr>
                        <th>状态</th>
                        <th>规则</th>
                        <th>结果</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${rrlist}" var="m">
                        <tr>
                            <td>
                                <c:if test="${m.resultclass == '0'}">
                                    <span class="label label-success">通&nbsp&nbsp&nbsp&nbsp过</span>
                                </c:if>
                                <c:if test="${m.resultclass == '1'}">
                                    <span class="label label-danger">未通过</span>
                                </c:if>

                            </td>
                            <td>${m.rulename}</td>
                            <td class="text-navy">${m.resultdesc}</td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>

            </div>
        </div>
    </div>
</div>
<!-- 全局js -->
<script src="plug-in/hplus/js/jquery.min.js?v=2.1.4"></script>
<script src="plug-in/hplus/js/bootstrap.min.js?v=3.3.6"></script>
<!-- 自定义js -->
<script src="plug-in/hplus/js/content.js"></script>
<script type="text/javascript" src="plug-in/echart/echarts.min.js"></script>
<script type="text/javascript" src="plug-in/jquery-plugs/i18n/jquery.i18n.properties.js"></script>
<t:base type="tools"></t:base>
<script type="text/javascript" src="plug-in/login/js/getMsgs.js"></script>
<script>
    $(document).ready(function() {

    })

</script>
</body>
</html>