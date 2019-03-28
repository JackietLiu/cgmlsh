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

    <%--		<div class="row">
                //功能列表
                <div class="col-md-1 col-cs-2 col-xs-4">
                    <div class="widget  p-lg text-center" style="background: #cfa972;">
                        <div><!-- class="ibtn" -->
                            <i class="iconfont icon-zhihuizhongxin" style="font-size: 30px;"></i>
                            <h3 class="font-bold no-margins"></h3>
                            <small>功能1111</small>
                        </div>
                    </div>
                </div>
                <div class="col-md-1 col-cs-2 col-xs-4">
                    <div class="widget  p-lg text-center" style="background: #f29b76;">
                        <div>
                            <i class="iconfont icon-yujing" style="font-size: 30px;"></i>
                            <h3 class="font-bold no-margins"></h3>
                            <small>功能2</small>
                        </div>
                    </div>
                </div>

                <div class="col-md-1 col-cs-2 col-xs-4">
                    <div class="widget  p-lg text-center" style="background: #88abda;">
                        <div>
                            <i class="iconfont icon-jixiao" style="font-size: 30px;"></i>
                            <h3 class="font-bold no-margins"></h3>
                            <small>功能6</small>
                        </div>
                    </div>
                </div>
                <div class="col-md-1 col-cs-2 col-xs-4">
                    <div class="widget  p-lg text-center" style="background: #8c97cb;">
                        <div>
                            <i class="iconfont icon-fangdajing-copy" style="font-size: 30px;"></i>
                            <h3 class="font-bold no-margins"></h3>
                            <small>功能7</small>
                        </div>
                    </div>
                </div>
            </div>
--%>

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
                                    <span class="label label-warning">${m.hospnameshort}</span>
                                </td>
                                <td>${m.commitdate}</td>
                                <td class="text-navy">${m.thestatustext}</td>
                            </tr>
                        </c:forEach>

                        <%-- <tr>
                             <td>
                                 <span class="label label-warning">类型5</span></td>
                             <td>任务2</td>
                             <td class="text-navy">7</td></tr>
                         <tr>--%>

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
                    <%-- <table class="table table-hover no-margins">
                         <thead>
                         <tr>
                             <th>规则名称</th>
                             <th>数量</th>

                         </tr>
                         </thead>
                         <tbody>

                         <c:forEach items="${theclass}" var="m">
                             <tr>
                                 <td>
                                     <span class="  ">${m.rulename}</span>
                                 </td>
                                 <td>${m.thecount}</td>

                             </tr>
                         </c:forEach>

                         &lt;%&ndash; <tr>
                              <td>
                                  <span class="label label-warning">类型5</span></td>
                              <td>任务2</td>
                              <td class="text-navy">7</td></tr>
                          <tr>&ndash;%&gt;

                         </tbody>
                     </table>--%>
                    <div id="echart_div"  style="height: 400px;">

                    </div>
                </div>
            </div>
        </div>

    </div>

    <div class="wrapper wrapper-content">
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
            /*jsondata=JSON.parse(jsondata);*/
           /* var data=jsondata[0].data;*/
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