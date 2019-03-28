<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
 <!--ZCZSN 20180926202402 -->
  <title>网上政务</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <link rel="stylesheet" href="plug-in/uploadify/css/uploadify.css" type="text/css" />
  <script type="text/javascript" src="plug-in/uploadify/jquery.uploadify-3.1.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
  <style type="text/css">
  	select {
    width: 158px !important;
}
  </style>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tBBusionlineInfoController.do?doAdd" callback="jeecgFormFileCallBack@Override">
		<input id="id" name="id" type="hidden" value="${tBBusionlineInfoPage.id }"/>
		<input id="createName" name="createName" type="hidden" value="${tBBusionlineInfoPage.createName }"/>
		<input id="createDate" name="createDate" type="hidden" value="${tBBusionlineInfoPage.createDate }"/>
		<input id="updateName" name="updateName" type="hidden" value="${tBBusionlineInfoPage.updateName }"/>
		<input id="updateDate" name="updateDate" type="hidden" value="${tBBusionlineInfoPage.updateDate }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							业务名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="businame" name="businame" type="text" style="width: 150px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">业务名称</label>
						</td>
						<td align="right">
						<label class="Validform_label">
							业务简称:
						</label>
					</td>
					<td class="value">
					     	 <input id="businameshort" name="businameshort" type="text" style="width: 150px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">业务简称</label>
						</td>
				</tr>
				<tr>
					
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否在用:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="isactive" type="list"
									typeGroupCode="isactive" defaultVal="${tBBusionlineInfoPage.isactive}" hasLabel="false"  title="是否在用"  
									></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否在用</label>
						</td>
						<td align="right">
						<label class="Validform_label">
							分组:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="groupflag" type="list"
									typeGroupCode="groupflag" defaultVal="${tBBusionlineInfoPage.groupflag}" hasLabel="false"  title="分组"  
									></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">分组</label>
						</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							排序:
						</label>
					</td>
					<td class="value" colspan="3" >
					     	 <input id="sortindex" name="sortindex" type="text" style="width: 150px" class="inputxt" 
					     	  datatype="n" 
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">排序</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							功能链接:
						</label>
					</td>
					<td class="value" colspan="3" >
					     	 <input id="url" name="url" type="text" style="width: 455px" class="inputxt" 
					     	  
					     	  ignore="ignore"
					     	  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">功能链接</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							图片:
						</label>
					</td>
					<td class="value" colspan="3" >
								<table></table>
								<div class="form jeecgDetail"> 
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
														'cgFormName':'t_b_busionline_info',
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
								</div> 
								<div class="form" id="filediv_file"></div>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">图片</label>
						</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value" colspan="3" >
						  	 <textarea style="width: 460px; margin: 0px; height: 70px;" class="inputxt" rows="4" id="memo" name="memo" 
						  	 ignore="ignore"
						  	 ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/shanyang/busionline/tBBusionlineInfo.js"></script>		
	  	<script type="text/javascript">
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
