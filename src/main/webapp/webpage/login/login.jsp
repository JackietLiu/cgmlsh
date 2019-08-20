<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.jeecgframework.core.util.SysThemesUtil,org.jeecgframework.core.enums.SysThemesEnum"%>
<%@page import="java.util.*,org.jeecgframework.core.util.*"%>
<%@include file="/context/mytags.jsp"%>
<%
  session.setAttribute("lang","zh-cn");
  SysThemesEnum sysTheme = SysThemesUtil.getSysTheme(request);
  String lhgdialogTheme = SysThemesUtil.getLhgdialogTheme(sysTheme);
  
  session.setAttribute("showvalid",ResourceUtil.getConfigByName("isshowvalidcode").trim());
  session.setAttribute("isdebugmode",ResourceUtil.getConfigByName("isdebugmode").trim());
/*  session.setAttribute("debugmodeusername",ResourceUtil.getConfigByName("debugmodeusername").trim());
  session.setAttribute("debugmodepwd",ResourceUtil.getConfigByName("debugmodepwd").trim());*/
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta charset="utf-8" />
    <title><t:mutiLang langKey="登录"/></title>
 <%--  <title><t:mutiLang langKey="jeect.platform"/></title> --%>
   <link rel="shortcut icon" href="images/favicon.ico">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
  <!-- bootstrap & fontawesome -->
  <link rel="stylesheet" href="plug-in/ace/css/bootstrap.css" />
  <link rel="stylesheet" href="plug-in/ace/css/font-awesome.css" />
  <link rel="stylesheet" type="text/css" href="plug-in/accordion/css/accordion.css">
  <!-- text fonts -->
  <link rel="stylesheet" href="plug-in/ace/css/ace-fonts.css" />

  <link rel="stylesheet" href="plug-in/ace/css/jquery-ui.css" />
  <!-- ace styles -->
  <link rel="stylesheet" href="plug-in/ace/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />
  <!--[if lte IE 9]>
  <link rel="stylesheet" href="plug-in/ace/css/ace-part2.css" class="ace-main-stylesheet" />
  <![endif]-->

  <!--[if lte IE 9]>
  <link rel="stylesheet" href="plug-in/ace/css/ace-ie.css" />
  <![endif]-->
  <!-- ace settings handler -->
  <script src="plug-in/ace/js/ace-extra.js"></script>

  <!--[if lte IE 8]>
  <script src="plug-in/ace/js/html5shiv.js"></script>
  <script src="plug-in/ace/js/respond.js"></script>
  <![endif]-->
    <style>
        .dlxls{
            padding: 5px;
            text-align: center;
        }
        .dlxls a{
            font-size: 18px;
        }
        .dlxls a:hover{
            color: #fff;
            font-size: 20px;
        }
    </style>
</head>
<body class="login-layout light-login">
<div class="main-container">
  <div class="main-content">
    <div class="row">
        <div class="center">
            <br> <br> <br> <br>

            <h1 id="id-text2" class="grey">
                <!--  <i class="ace-icon fa fa-leaf green"></i> -->
                <t:mutiLang langKey="sys.loginhead"/>
            </h1>
            <h2 class="blue" id="id-company-text"><t:mutiLang langKey="sys.loginhead2"/></h2>
        </div>
      <div class="col-sm-10 col-sm-offset-1">
        <div class="login-container">
          <%--<div class="center">
            <h1 id="id-text2" class="grey">
             <!--  <i class="ace-icon fa fa-leaf green"></i> -->
               <t:mutiLang langKey="sys.loginhead"/> 
            </h1>
            <h2 class="blue" id="id-company-text"><t:mutiLang langKey="sys.loginhead2"/></h2>   
          </div>--%>
          <div class="space-6"></div>
          <div class="position-relative">
            <div id="login-box" class="login-box visible widget-box no-border">
              <div class="widget-body">
                <form id="loinForm" class="form-horizontal"    method="post">
                <!-- 单点登录参数 -->
                <input type="hidden" id="ReturnURL"  name="ReturnURL" value="${ReturnURL }"/>
                <div class="widget-main">
                 <div class="alert alert-warning alert-dismissible" role="alert" id="errMsgContiner">
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				  <div id="showErrMsg"></div>
				</div>
                  <h4 class="header blue lighter bigger">
                    <i class="ace-icon fa fa-coffee green"></i>
                	    用户登录
                  </h4>
                  <div class="space-6"></div>
                      <label class="block clearfix">
								<span class="block input-icon input-icon-right">
									<input type="text"  name="userName" iscookie="true" class="form-control" placeholder="请输入用户名"  id="userName"/>
									<i class="ace-icon fa fa-user"></i>
								</span>
                      </label>
                      <label class="block clearfix">
								<span class="block input-icon input-icon-right">
									<input type="password" name="password" class="form-control" placeholder="请输入密码" id="password"/>
									<i class="ace-icon fa fa-lock"></i>
								</span>
                      </label>
                        <c:if test="${showvalid=='1' }">
						  <label class="block clearfix">
                        <div class="input-group">
                          <input type="text" style="width:150px" name="randCode" class="form-control" placeholder="请输入验证码"  id="randCode"/>
                          <span class="input-group-addon" style="padding: 0px;"><img id="randCodeImage" src="randCodeImage"  /></span>
                        </div>
                      </label>              
					</c:if>
                    <!--zcznote   <label class="block clearfix">
                        <div class="input-group">
                          <input type="text" style="width:150px" name="randCode" class="form-control" placeholder="请输入验证码"  id="randCode"/>
                          <span class="input-group-addon" style="padding: 0px;"><img id="randCodeImage" src="randCodeImage"  /></span>
                        </div>
                      </label> -->
                      
                      <div class="space"></div>
                      <div class="clearfix">
                        <label class="inline">
                          <input type="checkbox" class="ace" id="on_off"  name="remember" value="yes"/>
                          <span class="lbl">记住用户名</span>
                        </label>
                       <!--zcznoted  <span> | <a href="http://demo.jeecg.org/mLoginController.do?login&from=singlemessage&isappinstalled=0">
                        <i class="ace-icon fa fa-location-arrow">
                        </i><font color='#428bca'>移动OA</font></a></span>
                         <span> | <a href="http://yun.jeecg.org" target="_blank">
                         <i class="ace-icon fa fa-cube"></i>
                         <font color='#428bca'>插件中心</font></a></span> -->
                        <button type="button" id="but_login"  onclick="checkUser()" class="width-35 pull-right btn btn-sm btn-primary">
                          <i class="ace-icon fa fa-key"></i>
                          <span class="bigger-110" >登录</span>
                        </button>
                        <a href="#" class="btn btn-link">如忘记密码请找管理员重置</a>
                      </div>
                      <div class="space-4"></div>

                </div>
                <div class="toolbar dlxls clearfix">
                    <a href="upload/hospitals.xls" class="forgot-password-link">下载医院代码表</a>
                </div>
                </form>
              </div>
            </div>
            <div class="center">
         <!--    zcznoted -->
                <%--<h4 class="blue" id="id-company-text"><t:mutiLang langKey="sys.copyright"/></h4>--%>
            </div>
            <div class="navbar-fixed-top align-right">
              <br />
              &nbsp;
              <a id="btn-login-dark" class="blue" href="#" onclick="darkStyle()">Dark</a>
              &nbsp;
              <span class="blue">/</span>
              &nbsp;
              <a id="btn-login-blur" class="blue" href="#" onclick="blurStyle()">Blur</a>
              &nbsp;
              <span class="blue">/</span>
              &nbsp;
              <a id="btn-login-light" class="blue" href="#" onclick="lightStyle()">Light</a>
              &nbsp; &nbsp; &nbsp;
            </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

<script type="text/javascript" src="plug-in/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="plug-in/jquery/jquery.cookie.js"></script>
<script type="text/javascript" src="plug-in/mutiLang/en.js"></script>
<script type="text/javascript" src="plug-in/mutiLang/zh-cn.js"></script>
<script type="text/javascript" src="plug-in/login/js/jquery.tipsy.js"></script>
<script type="text/javascript" src="plug-in/login/js/iphone.check.js"></script>
<script type="text/javascript" src="webpage/login/login-ace.js"></script>
<%=lhgdialogTheme %>
<script type="text/javascript">
$("#errMsgContiner").hide();
	$(function(){
		 
		optErrMsg();
		 if( '${isdebugmode}'=='1'){
			 
			 $("#userName").val('${debugmodeusername}' );
			 $("#password").val('${debugmodepwd}'   );
			 setTimeout("$('#but_login').click()","10");
		}       
	});
	

   //输入验证码，回车登录
  $(document).bind('keyup', function(event) {
	  if (event.keyCode == "13") {
		  $('#but_login').click();
	}
  });

  //验证用户信息
  function checkUser(){
    if(!validForm()){
      return false;
    }
    newLogin();
  }
  $(document).keydown(function(e){
	  	if(e.keyCode == 13) {
		   
	      setTimeout("$('#but_login').click()","100");

	  	}
	  });
  /**
   * 刷新验证码
   */
  $('#randCodeImage').click(function(){
	    reloadRandCodeImage();
  });
	
</script>

<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?098e6e84ab585bf0c2e6853604192b8b";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>

</body>
</html>