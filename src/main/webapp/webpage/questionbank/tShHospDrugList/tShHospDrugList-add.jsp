<!--thisisid: tShHospDrugList-add.jsp  -->
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>医院上传药品列表</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,bootstrap-table,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;margin-top: 20px">
 <form id="formobj" action="tShHospDrugListController.do?doAdd" class="form-horizontal validform" role="form"  method="post">
	<input type="hidden" id="btn_sub" class="btn_sub"/>
	<input type="hidden" id="id" name="id"/>
	 <input type="hidden" id="hospid" name="hospid" value="${hospid}"/>

	 <div class="form-group">
		 <label for="buyno" class="col-sm-3 control-label">采购序号：</label>
		 <div class="col-sm-7">
			 <div class="input-group" style="width:100%">
				 <input id="buyno" name="buyno" type="text" maxlength="50" class="form-control input-sm" placeholder="请输入采购序号"  ignore="ignore" />
			 </div>
		 </div>
	 </div>

	 <div class="form-group">
		<label for="commonname" class="col-sm-3 control-label">药品名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="commonname" name="commonname" type="text" maxlength="100" class="form-control input-sm" placeholder="请输入药品名称"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="gg" class="col-sm-3 control-label">药品规格：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="gg" name="gg" type="text" maxlength="20" class="form-control input-sm" placeholder="请输入药品规格"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="pcs" class="col-sm-3 control-label">单位：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="pcs" name="pcs" type="text" maxlength="20" class="form-control input-sm" placeholder="请输入单位"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="enterprisename" class="col-sm-3 control-label">厂家：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="enterprisename" name="enterprisename" type="text" maxlength="100" class="form-control input-sm" placeholder="请输入厂家"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="drugform" class="col-sm-3 control-label">剂型：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="drugform" name="drugform" type="text" maxlength="20" class="form-control input-sm" placeholder="请输入剂型"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="inprice" class="col-sm-3 control-label">购进单价：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="inprice" name="inprice" type="text" maxlength="10" class="form-control input-sm" placeholder="请输入购进单价"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="innum" class="col-sm-3 control-label">入库数量：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="innum" name="innum" type="text" maxlength="11" class="form-control input-sm" placeholder="请输入入库数量"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="rationnum" class="col-sm-3 control-label">转换比：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="rationnum" name="rationnum" type="text" maxlength="10" class="form-control input-sm" placeholder="请输入转换比"  datatype="n"  ignore="ignore" />
			</div>
		</div>
	</div>

	<%--
	<div class="form-group">
		<label for="updateName" class="col-sm-3 control-label">更新人名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="updateName" name="updateName" type="text" maxlength="50" class="form-control input-sm" placeholder="请输入更新人名称"  ignore="ignore" />
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
		 <label for="auditno" class="col-sm-3 control-label">导入批号：</label>
		 <div class="col-sm-7">
			 <div class="input-group" style="width:100%">
				 <input id="auditno" name="auditno" type="text" maxlength="20" class="form-control input-sm" placeholder="请输入导入批号"  ignore="ignore" />
			 </div>
		 </div>
	 </div>
	 --%>

	<%-- <div class="form-group">
		<label for="hospid" class="col-sm-3 control-label">医院名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<t:dictSelect field="hospid" type="list"
					defaultVal="${hospid}"
							  extendJson="{class:'form-control input-sm'}"
					dictTable="t_sh_hospital" dictField="id" dictText="hospnameshort"  hasLabel="false"  title="医院ID"></t:dictSelect>
			</div>
		</div>
	</div>--%>


</form>
<script type="text/javascript">
	var subDlgIndex = '';
	$(document).ready(function() {
				//更新日期 日期控件初始化
			    laydate.render({
				   elem: '#updateDate'
				  ,type: 'date'
				  ,trigger: 'click' //采用click弹出
				  ,ready: function(date){
				  	 $("#updateDate").val(DateJsonFormat(date,this.format));
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