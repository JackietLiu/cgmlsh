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
        .col-sm-2 {
            width: 10%;
            padding-left: 5px;
            padding-right: 5px;
            float: left;
        }
        .p-lg{
            padding:0px 0px 10px 0px;
        }
        .widget{
            margin-top: 0px;
        }
        .iconfont{
            font-size: 30px;
            color: white;
        }
        h2 {
            font-size: 19px;
        }
        .echart_div{
            height:240px;width:100%;
        }
        .ibtn{
            cursor: pointer;
        }
        .flot-chart{
            height:400px;
        }
        .topspan{
            margin-left:20px;
        }
        /*  .top-navigation .wrapper.wrapper-content{padding:20px 5px !important;}
         .container {
              width:99% !important; margin:10px;
              padding-right: 1px !important;
              padding-left: 1px !important;
         }
         .color_red{color:#e55555;}
         .col-cs-2 {
             width: 10%;
             padding-left: 5px;
             padding-right: 5px;
             float: left;
         }*/

        @media (min-width: 992px){
            .col-cs-2 {
                width: 11.11%;
                padding-left: 5px;
                padding-right: 5px;
                float: left;
            }
        }

    </style>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="alert alert-warning">
        <span>已提交：</span><a><label id="submited" class="label label-success"></label></a>
        <span class="topspan">未提交：</span><a><label id="unsubmit" class="label label-danger"></label></a>
        <span class="topspan">已审核：</span><a><label id="audited" class="label label-success"></label></a>
    </div>
    <div class="row">
        <div class="col-sm-5">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>医院上传列表</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content" style="height: 400px;">
                    <table class="table table-hover no-margins">
                        <thead>
                        <tr>
                            <th>医院名称</th>
                            <th>提交日期</th>
                            <th>状态</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${hospimportlist}" var="m">
                            <tr>
                                <td>
                                    <span class="label label-warning">${m.hospname}</span>
                                </td>
                                <td>${m.commitdate}</td>
                                <td class="text-navy">${m.thestatustext}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
        <div class="col-sm-7">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>审核结果统计</h5>
                    <div class="pull-right">

                    </div>
                </div>
                <div class="ibox-content"  style="height: 400px;">
                    <div id="echart_div"  style="height: 400px;">

                    </div>
                </div>
            </div>
        </div>

    </div>
    <div class="row">
        <div class="col-sm-5">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>分散合同统计</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content" style="height: 400px;">
                    <table class="table table-hover no-margins">
                        <thead>
                        <tr>
                            <th>医院名称</th>
                            <th>数量</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${jslist}" var="m">
                            <tr>
                                <td>
                                    ${m.hospname}
                                </td>
                                <td><span class="label label-warning">${m.drugcount}</span></td>
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
            //直接嵌套显示
            laydate.render({
                elem: '#calendar'
                ,position: 'static'
                ,theme: 'molv'

            });
            var chart = echarts.init(document.getElementById('echart_div'));
            var jsondata = ${theclass};
            /*获取提交、未提交和已审核的数据 begin*/
            var counts = ${counts};
            var submited =parseInt(counts[0].submited);//已提交
            var hosptotal = parseInt(counts[0].hosptotal);//医院总数
            var audited = parseInt(counts[0].audited);//已审核
            var audited2 = parseInt(counts[0].audited2);//已备份
            $("#submited").html(submited);
            $("#unsubmit").html(hosptotal-submited-audited-audited2);
            $("#audited").html(audited2+audited);
            /*end*/
            var xAxisData=[];
            var seriesData=[];
            for(var i in jsondata){
                xAxisData.push(jsondata[i].rulename);
                seriesData.push(jsondata[i].thecount);
            }
            var option = {
                color: ['#3398DB'],
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'line'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    top: '15%',
                    left: '10%',
                    right: '10%',
                    bottom: '15%',
                    containLabel: true
                },
                xAxis : [
                    {
                        type: 'category',
                        data : xAxisData,
                        axisTick: {
                            alignWithLabel: true
                        },
                        axisLabel:{
                            interval:0,//横轴信息全部显示
                            rotate:-10,//-10角度倾斜展示
                        },
                        name:'规则名称'
                    }
                ],
                yAxis : [
                    {
                        type : 'value',
                        name:'数量'
                    }
                ],
                series : [
                    {
                        name:'数量',
                        type:'bar',
                        barWidth: '40%',
                        data:seriesData,
                        label: {
                            normal: {
                                show: true,
                                position: 'top'
                            }
                        },
                        itemStyle: {
                            normal: {
                                // 随机显示
                                //color:function(d){return "#"+Math.floor(Math.random()*(256*256*256-1)).toString(16);}

                                // 定制显示（按顺序）
                                color: function(params) {
                                    var colorList = ['#C33531','#C33531','#C33531','#C33531','#29AAE3', '#B74AE5','#0AAF9F','#E89589','#16A085','#4A235A','#C39BD3 ','#F9E79F','#BA4A00','#ECF0F1','#616A6B','#EAF2F8','#4A235A','#3498DB' ];
                                    return colorList[params.dataIndex]
                                }
                            },
                        },

                    }
                ]
            };
            chart.setOption(option, true);
        });
    </script>
</body>
</html>