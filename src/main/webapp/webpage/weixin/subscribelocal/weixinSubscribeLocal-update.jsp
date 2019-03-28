<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
 <!--ZCZSN 20180927105918 -->
  <title>weixin_subscribe_local</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
	<link rel="stylesheet" href="plug-in/uploadify/css/uploadify.css" type="text/css" />
	<script type="text/javascript" src="plug-in/uploadify/jquery.uploadify-3.1.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="weixinSubscribeLocalController.do?doUpdate" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden" value="${weixinSubscribeLocalPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								呢称:
							</label>
						</td>
						<td class="value">
						     	 <input id="nickname" name="nickname" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${weixinSubscribeLocalPage.nickname}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">呢称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								性别:
							</label>
						</td>
						<td class="value">
						     	 <input id="sex" name="sex" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${weixinSubscribeLocalPage.sex}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">性别</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								城市:
							</label>
						</td>
						<td class="value">
						     	 <input id="city" name="city" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${weixinSubscribeLocalPage.city}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">城市</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								省份:
							</label>
						</td>
						<td class="value">
						     	 <input id="province" name="province" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${weixinSubscribeLocalPage.province}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">省份</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								国籍:
							</label>
						</td>
						<td class="value">
						     	 <input id="country" name="country" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${weixinSubscribeLocalPage.country}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">国籍</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								图像:
							</label>
						</td>
						<td class="value">
						     	 <input id="headimgurl" name="headimgurl" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${weixinSubscribeLocalPage.headimgurl}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">图像</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								关注时间:
							</label>
						</td>
						<td class="value">
						     	 <input id="subscribetime" name="subscribetime" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${weixinSubscribeLocalPage.subscribetime}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">关注时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								是否关注:
							</label>
						</td>
						<td class="value">
						     	 <input id="subscribe" name="subscribe" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${weixinSubscribeLocalPage.subscribe}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否关注</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								语言:
							</label>
						</td>
						<td class="value">
						     	 <input id="language" name="language" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${weixinSubscribeLocalPage.language}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">语言</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								unionid:
							</label>
						</td>
						<td class="value">
						     	 <input id="unionid" name="unionid" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${weixinSubscribeLocalPage.unionid}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">unionid</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						     	 <input id="remark" name="remark" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${weixinSubscribeLocalPage.remark}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								分组:
							</label>
						</td>
						<td class="value">
						     	 <input id="groupid" name="groupid" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${weixinSubscribeLocalPage.groupid}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">分组</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								真实姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="realname" name="realname" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${weixinSubscribeLocalPage.realname}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">真实姓名</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								身份证号:
							</label>
						</td>
						<td class="value">
						     	 <input id="idcard" name="idcard" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${weixinSubscribeLocalPage.idcard}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">身份证号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								认证图片:
							</label>
						</td>
						<td class="value">
									<table id="fileTable"></table>
										<table></table>
										<script type="text/javascript">
											var serverMsg="";
											$(function(){
												$('#photopath').uploadify({
													buttonText:'添加文件',
													auto:false,
													progressData:'speed',
													multi:true,
													height:25,
													overrideEvents:['onDialogClose'],
													fileTypeDesc:'文件格式:',
													queueID:'filediv_file',
													fileSizeLimit:'15MB',
													swf:'plug-in/uploadify/uploadify.swf',	
													uploader:'cgUploadController.do?saveFiles&jsessionid='+$("#sessionUID").val()+'',
													onUploadStart : function(file) { 
														var cgFormId=$("input[name='id']").val();
														$('#photopath').uploadify("settings", "formData", {
															'cgFormId':cgFormId,
															'cgFormName':'weixin_subscribe_local',
															'cgFormField':'PHOTOPATH'
														});
													} ,
													onQueueComplete : function(queueData) {
														 var win = frameElement.api.opener;
														 win.reloadTable();
														 win.tip(serverMsg);
														 frameElement.api.close();
													},
													onUploadSuccess : function(file, data, response) {
														var d=$.parseJSON(data);
														if(d.success){
															var win = frameElement.api.opener;
															serverMsg = d.msg;
														}
													},
													onFallback: function() {
									                    tip("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试")
									                },
									                onSelectError: function(file, errorCode, errorMsg) {
									                    switch (errorCode) {
									                    case - 100 : tip("上传的文件数量已经超出系统限制的" + $('#file').uploadify('settings', 'queueSizeLimit') + "个文件！");
									                        break;
									                    case - 110 : tip("文件 [" + file.name + "] 大小超出系统限制的" + $('#file').uploadify('settings', 'fileSizeLimit') + "大小！");
									                        break;
									                    case - 120 : tip("文件 [" + file.name + "] 大小异常！");
									                        break;
									                    case - 130 : tip("文件 [" + file.name + "] 类型不正确！");
									                        break;
									                    }
									                },
									                onUploadProgress: function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {}
												});
											});
										</script>
										<span id="file_uploadspan"><input type="file" name="photopath" id="photopath" /></span> 
										<div class="form" id="filediv_file"></div>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">认证图片</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								手机号:
							</label>
						</td>
						<td class="value">
						     	 <input id="mobile" name="mobile" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${weixinSubscribeLocalPage.mobile}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">手机号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						  	 	<textarea id="memo" style="width:600px;" class="inputxt" rows="6" name="memo" 
						  	 	ignore="ignore"
						  	 	>${weixinSubscribeLocalPage.memo}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								审核日期:
							</label>
						</td>
						<td class="value">
									  <input id="approvedate" name="approvedate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  
									  ignore="ignore"
									    value='<fmt:formatDate value='${weixinSubscribeLocalPage.approvedate}' type="date" pattern="yyyy-MM-dd"/>'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">审核日期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								审核人:
							</label>
						</td>
						<td class="value">
						     	 <input id="approvename" name="approvename" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${weixinSubscribeLocalPage.approvename}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">审核人</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								审核状态:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="approvestatus" type="radio"
										typeGroupCode="approvestatus" defaultVal="${weixinSubscribeLocalPage.approvestatus}" hasLabel="false"  title="审核状态"  
										></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">审核状态</label>
						</td>
					</tr>				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/weixin/guanjia/subscribelocal/weixinSubscribeLocal.js"></script>		
	  	<script type="text/javascript">
		  	//加载 已存在的 文件
		  	$(function(){
		  		var table = $("#fileTable");
		  		var cgFormId=$("input[name='id']").val();
		  		$.ajax({
		  		   type: "post",
		  		   url: "weixinSubscribeLocalController.do?getFiles&id=" +  cgFormId,
		  		   success: function(data){
		  			 var arrayFileObj = jQuery.parseJSON(data).obj;
		  			 
		  			$.each(arrayFileObj,function(n,file){
		  				var tr = $("<tr style=\"height:34px;\"></tr>");
		  				var td_title = $("<td>" + file.title + "</td>")
		  		  		var td_download = $("<td><a href=\"commonController.do?viewFile&fileid=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity\" title=\"下载\">下载</a></td>")
		  		  		var td_view = $("<td><a href=\"javascript:void(0);\" onclick=\"openwindow('预览','commonController.do?openViewFile&fileid=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity','fList',700,500)\">预览</a></td>");
		  		  		var td_del = $("<td><a href=\"javascript:void(0)\" class=\"jeecgDetail\" onclick=\"del('cgUploadController.do?delFile&id=" + file.fileKey + "',this)\">删除</a></td>");
		  		  		
		  		  		tr.appendTo(table);
		  		  		td_title.appendTo(tr);
		  		  		td_download.appendTo(tr);
		  		  		td_view.appendTo(tr);
		  		  		td_del.appendTo(tr);
		  			 });
		  		   }
		  		});
		  	})
	  		function jeecgFormFileCallBack(data){
	  			if (data.success == true) {
					uploadFile(data);
				} else {
					if (data.responseText == '' || data.responseText == undefined) {
						$.messager.alert('错误', data.msg);
						$.Hidemsg();
					} else {
						try {
							var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
							$.messager.alert('错误', emsg);
							$.Hidemsg();
						} catch(ex) {
							$.messager.alert('错误', data.responseText + '');
						}
					}
					return false;
				}
				if (!neibuClickFlag) {
					var win = frameElement.api.opener;
					win.reloadTable();
				}
	  		}
	  		function upload() {
				$('#photopath').uploadify('upload', '*');		
			}
			
			var neibuClickFlag = false;
			function neibuClick() {
				neibuClickFlag = true; 
				$('#btn_sub').trigger('click');
			}
			function cancel() {
				$('#photopath').uploadify('cancel', '*');
			}
			function uploadFile(data){
				if(!$("input[name='id']").val()){
					if(data.obj!=null && data.obj!='undefined'){
						$("input[name='id']").val(data.obj.id);
					}
				}
				if($(".uploadify-queue-item").length>0){
					upload();
				}else{
					if (neibuClickFlag){
						alert(data.msg);
						neibuClickFlag = false;
					}else {
						var win = frameElement.api.opener;
						win.reloadTable();
						win.tip(data.msg);
						frameElement.api.close();
					}
				}
			}
	  	</script>
