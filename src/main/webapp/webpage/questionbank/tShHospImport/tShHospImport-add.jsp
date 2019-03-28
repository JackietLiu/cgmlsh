<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>医院导入列表</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,bootstrap-table,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;margin-top: 20px">
 <form id="formobj" action="tShHospImportController.do?doAdd" class="form-horizontal validform" role="form"  method="post">
	<input type="hidden" id="btn_sub" class="btn_sub"/>
	<input type="hidden" id="id" name="id"/>
	<div class="form-group">
		<label for="auditdate" class="col-sm-3 control-label">审核日期：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
      		   <input id="auditdate" name="auditdate" type="text" class="form-control input-sm" placeholder="请输入审核日期"  ignore="ignore" />
                   <span class="input-group-addon" >
                       <span class="glyphicon glyphicon-calendar"></span>
                   </span>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="auditname" class="col-sm-3 control-label">审核人：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="auditname" name="auditname" type="text" maxlength="50" class="form-control input-sm" placeholder="请输入审核人"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="auditno" class="col-sm-3 control-label">上传批号：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="auditno" name="auditno" type="text" maxlength="20" class="form-control input-sm" placeholder="请输入上传批号"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="commitdate" class="col-sm-3 control-label">提交日期：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
      		   <input id="commitdate" name="commitdate" type="text" class="form-control input-sm" placeholder="请输入提交日期"  ignore="ignore" />
                   <span class="input-group-addon" >
                       <span class="glyphicon glyphicon-calendar"></span>
                   </span>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="commitname" class="col-sm-3 control-label">提交人：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="commitname" name="commitname" type="text" maxlength="50" class="form-control input-sm" placeholder="请输入提交人"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="createDate" class="col-sm-3 control-label">创建日期：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
      		   <input id="createDate" name="createDate" type="text" class="form-control input-sm" placeholder="请输入创建日期"  ignore="ignore" />
                   <span class="input-group-addon" >
                       <span class="glyphicon glyphicon-calendar"></span>
                   </span>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="createName" class="col-sm-3 control-label">创建人名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="createName" name="createName" type="text" maxlength="50" class="form-control input-sm" placeholder="请输入创建人名称"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="filename" class="col-sm-3 control-label">上传文件名：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="filename" name="filename" type="text" maxlength="200" class="form-control input-sm" placeholder="请输入上传文件名"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="hospid" class="col-sm-3 control-label">医院编号：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<t:dictSelect field="hospid" type="list" extendJson="{class:'form-control input-sm'}"   dictTable="t_sh_hospital" dictField="id" dictText="hospnameshort"  hasLabel="false"  title="医院编号"></t:dictSelect>     
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="memo" class="col-sm-3 control-label">备注：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="memo" name="memo" type="text" maxlength="100" class="form-control input-sm" placeholder="请输入备注"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="month" class="col-sm-3 control-label">月份：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="month" name="month" type="text" maxlength="10" class="form-control input-sm" placeholder="请输入月份"  datatype="n"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="thescore" class="col-sm-3 control-label">得分：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="thescore" name="thescore" type="text" maxlength="5" class="form-control input-sm" placeholder="请输入得分"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="thestatus" class="col-sm-3 control-label">状态：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<t:dictSelect field="thestatus" type="list" extendJson="{class:'form-control input-sm'}"   typeGroupCode="thestatus"  hasLabel="false"  title="状态"></t:dictSelect>     
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="updateDate" class="col-sm-3 control-label">更新日期：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
      		   <input id="updateDate" name="updateDate" type="text" class="form-control input-sm" placeholder="请输入更新日期"  ignore="ignore" />
                   <span class="input-group-addon" >
                       <span class="glyphicon glyphicon-calendar"></span>
                   </span>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="updateName" class="col-sm-3 control-label">更新人名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="updateName" name="updateName" type="text" maxlength="50" class="form-control input-sm" placeholder="请输入更新人名称"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="year" class="col-sm-3 control-label">年份：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="year" name="year" type="text" maxlength="10" class="form-control input-sm" placeholder="请输入年份"  datatype="n"  ignore="ignore" />
			</div>
		</div>
	</div>
</form>
<script type="text/javascript">
	var subDlgIndex = '';
	$(document).ready(function() {
				//审核日期 日期控件初始化
			    laydate.render({
				   elem: '#auditdate'
				  ,type: 'date'
				  ,trigger: 'click' //采用click弹出
				  ,ready: function(date){
				  	 $("#auditdate").val(DateJsonFormat(date,this.format));
				  }
				});
				//提交日期 日期控件初始化
			    laydate.render({
				   elem: '#commitdate'
				  ,type: 'date'
				  ,trigger: 'click' //采用click弹出
				  ,ready: function(date){
				  	 $("#commitdate").val(DateJsonFormat(date,this.format));
				  }
				});
				//创建日期 日期控件初始化
			    laydate.render({
				   elem: '#createDate'
				  ,type: 'date'
				  ,trigger: 'click' //采用click弹出
				  ,ready: function(date){
				  	 $("#createDate").val(DateJsonFormat(date,this.format));
				  }
				});
				//更新日期 日期控件初始化
			    laydate.render({
				   elem: '#updateDate'
				  ,type: 'date'
				  ,trigger: 'click' //采用click弹出
				  ,ready: function(date){
				  	 $("#updateDate").val(DateJsonFormat(date,this.format));
				  }
				});
		
		//单选框/多选框初始化
		$('.i-checks').iCheck({
			labelHover : false,
			cursor : true,
			checkboxClass : 'icheckbox_square-green',
			radioClass : 'iradio_square-green',
			increaseArea : '20%'
		});
		
		//表单提交
		$("#formobj").Validform({
			tiptype:function(msg,o,cssctl){
				if(o.type==3){
					validationMessage(o.obj,msg);
				}else{
					removeMessage(o.obj);
				}
			},
			btnSubmit : "#btn_sub",
			btnReset : "#btn_reset",
			ajaxPost : true,
			beforeSubmit : function(curform) {
			},
			usePlugin : {
				passwordstrength : {
					minLen : 6,
					maxLen : 18,
					trigger : function(obj, error) {
						if (error) {
							obj.parent().next().find(".Validform_checktip").show();
							obj.find(".passwordStrength").hide();
						} else {
							$(".passwordStrength").show();
							obj.parent().next().find(".Validform_checktip").hide();
						}
					}
				}
			},
			callback : function(data) {
				var win = frameElement.api.opener;
				if (data.success == true) {
					frameElement.api.close();
				    win.reloadTable();
				    win.tip(data.msg);
				} else {
				    if (data.responseText == '' || data.responseText == undefined) {
				        $.messager.alert('错误', data.msg);
				        $.Hidemsg();
				    } else {
				        try {
				            var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
				            $.messager.alert('错误', emsg);
				            $.Hidemsg();
				        } catch (ex) {
				            $.messager.alert('错误', data.responseText + "");
				            $.Hidemsg();
				        }
				    }
				    return false;
				}
			}
		});
	});
	
</script>
</body>
</html>