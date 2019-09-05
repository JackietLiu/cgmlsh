<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>管理员导出</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,bootstrap-table,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;margin-top: 20px">
 <form id="formobj" action="vHospDrugExportController.do?doUpdate" class="form-horizontal validform" role="form"  method="post">
	<input type="hidden" id="btn_sub" class="btn_sub"/>
	<input type="hidden" id="id" name="id" value="${vHospDrugExportPage.id}"/>
	<div class="form-group">
		<label for="registerno" class="col-sm-3 control-label">批准文号：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="registerno" name="registerno" value='${vHospDrugExportPage.registerno}' type="text" maxlength="100" class="form-control input-sm" placeholder="请输入批准文号"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="contractname" class="col-sm-3 control-label">项目名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="contractname" name="contractname" value='${vHospDrugExportPage.contractname}' type="text" maxlength="100" class="form-control input-sm" placeholder="请输入项目名称"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="place" class="col-sm-3 control-label">交易场：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="place" name="place" value='${vHospDrugExportPage.place}' type="text" maxlength="50" class="form-control input-sm" placeholder="请输入交易场"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="buyno" class="col-sm-3 control-label">采购序号：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="buyno" name="buyno" value='${vHospDrugExportPage.buyno}' type="text" maxlength="50" class="form-control input-sm" placeholder="请输入采购序号"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="commonname" class="col-sm-3 control-label">通用名：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="commonname" name="commonname" value='${vHospDrugExportPage.commonname}' type="text" maxlength="100" class="form-control input-sm" placeholder="请输入通用名"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="tradename" class="col-sm-3 control-label">商品名：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="tradename" name="tradename" value='${vHospDrugExportPage.tradename}' type="text" maxlength="20" class="form-control input-sm" placeholder="请输入商品名"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="drugform" class="col-sm-3 control-label">剂型：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="drugform" name="drugform" value='${vHospDrugExportPage.drugform}' type="text" maxlength="20" class="form-control input-sm" placeholder="请输入剂型"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="gg" class="col-sm-3 control-label">规格：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="gg" name="gg" value='${vHospDrugExportPage.gg}' type="text" maxlength="100" class="form-control input-sm" placeholder="请输入规格"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="rationnum" class="col-sm-3 control-label">转换比：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="rationnum" name="rationnum" value='${vHospDrugExportPage.rationnum}' type="text" maxlength="10" class="form-control input-sm" placeholder="请输入转换比"  datatype="n"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="pcs" class="col-sm-3 control-label">单位：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="pcs" name="pcs" value='${vHospDrugExportPage.pcs}' type="text" maxlength="20" class="form-control input-sm" placeholder="请输入单位"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="pkccz" class="col-sm-3 control-label">包装材质：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="pkccz" name="pkccz" value='${vHospDrugExportPage.pkccz}' type="text" maxlength="50" class="form-control input-sm" placeholder="请输入包装材质"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="enterprisename" class="col-sm-3 control-label">生产企业：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="enterprisename" name="enterprisename" value='${vHospDrugExportPage.enterprisename}' type="text" maxlength="255" class="form-control input-sm" placeholder="请输入生产企业"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="inprice" class="col-sm-3 control-label">供应价：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="inprice" name="inprice" value='${vHospDrugExportPage.inprice}' type="text" maxlength="10" class="form-control input-sm" placeholder="请输入供应价"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="minunitprice" class="col-sm-3 control-label">最小单位报价：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="minunitprice" name="minunitprice" value='${vHospDrugExportPage.minunitprice}' type="text" maxlength="20" class="form-control input-sm" placeholder="请输入最小单位报价"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="drugmemo" class="col-sm-3 control-label">国基标注：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="drugmemo" name="drugmemo" value='${vHospDrugExportPage.drugmemo}' type="text" maxlength="20" class="form-control input-sm" placeholder="请输入国基标注"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="innum" class="col-sm-3 control-label">入库数量：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="innum" name="innum" value='${vHospDrugExportPage.innum}' type="text" maxlength="11" class="form-control input-sm" placeholder="请输入入库数量"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="auditno" class="col-sm-3 control-label">导入批号：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="auditno" name="auditno" value='${vHospDrugExportPage.auditno}' type="text" maxlength="20" class="form-control input-sm" placeholder="请输入导入批号"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="groupno" class="col-sm-3 control-label">评审编号：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="groupno" name="groupno" value='${vHospDrugExportPage.groupno}' type="text" maxlength="40" class="form-control input-sm" placeholder="请输入评审编号"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="groupname" class="col-sm-3 control-label">评审分组：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="groupname" name="groupname" value='${vHospDrugExportPage.groupname}' type="text" maxlength="20" class="form-control input-sm" placeholder="请输入评审分组"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="hospcode" class="col-sm-3 control-label">代码：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="hospcode" name="hospcode" value='${vHospDrugExportPage.hospcode}' type="text" maxlength="40" class="form-control input-sm" placeholder="请输入代码"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="hospname" class="col-sm-3 control-label">医院名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="hospname" name="hospname" value='${vHospDrugExportPage.hospname}' type="text" maxlength="100" class="form-control input-sm" placeholder="请输入医院名称"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="name" class="col-sm-3 control-label">城市名：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="name" name="name" value='${vHospDrugExportPage.name}' type="text" maxlength="50" class="form-control input-sm" placeholder="请输入城市名"  ignore="ignore" />
			</div>
		</div>
	</div>
</form>
<script type="text/javascript">
	var subDlgIndex = '';
	$(document).ready(function() {
		
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