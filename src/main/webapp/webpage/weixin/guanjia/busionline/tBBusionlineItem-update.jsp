<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
 <!--ZCZSN 20180926200718 -->
  <title>网上政务详情</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
	<link rel="stylesheet" href="plug-in/uploadify/css/uploadify.css" type="text/css" />
	<script type="text/javascript" src="plug-in/uploadify/jquery.uploadify-3.1.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tBBusionlineItemController.do?doUpdate" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden" value="${tBBusionlineItemPage.id }">
					<input id="createName" name="createName" type="hidden" value="${tBBusionlineItemPage.createName }">
					<input id="createDate" name="createDate" type="hidden" value="${tBBusionlineItemPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${tBBusionlineItemPage.updateName }">
					<input id="updateDate" name="updateDate" type="hidden" value="${tBBusionlineItemPage.updateDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								政务ID:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="busionlineid" type="list"
										dictTable="t_b_busionline_info" dictField="id" dictText="businameshort" defaultVal="${tBBusionlineItemPage.busionlineid}" hasLabel="false"  title="政务ID"  
										></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">政务ID</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								图标:
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
															'cgFormName':'t_b_busionline_item',
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
							<label class="Validform_label" style="display: none;">图标</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								项目名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="itemname" name="itemname" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${tBBusionlineItemPage.itemname}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								功能链接:
							</label>
						</td>
						<td class="value">
						     	 <input id="url" name="url" type="text" style="width: 150px" class="inputxt"  
						     	 ignore="ignore" 
						     	 value='${tBBusionlineItemPage.url}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">功能链接</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								排序:
							</label>
						</td>
						<td class="value">
						     	 <input id="sortindex" name="sortindex" type="text" style="width: 150px" class="inputxt"  datatype="n" 
						     	 ignore="ignore" 
						     	 value='${tBBusionlineItemPage.sortindex}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">排序</label>
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
						  	 	>${tBBusionlineItemPage.memo}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								在用:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="isactive" type="list"
										typeGroupCode="isactive" defaultVal="${tBBusionlineItemPage.isactive}" hasLabel="false"  title="在用"  
										></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">在用</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/shanyang/busionline/tBBusionlineItem.js"></script>		
	  	<script type="text/javascript">
		  	//加载 已存在的 文件
		  	$(function(){
		  		var table = $("#fileTable");
		  		var cgFormId=$("input[name='id']").val();
		  		$.ajax({
		  		   type: "post",
		  		   url: "tBBusionlineItemController.do?getFiles&id=" +  cgFormId,
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
