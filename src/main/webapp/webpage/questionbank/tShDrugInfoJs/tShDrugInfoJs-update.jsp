<!--thisisid: tShDrugInfoJs-update.jsp  -->
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>省导入药品目录</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,bootstrap-table,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;margin-top: 20px">
 <form id="formobj" action="tShDrugInfoJsController.do?doUpdate" class="form-horizontal validform" role="form"  method="post">
	<input type="hidden" id="btn_sub" class="btn_sub"/>
	<input type="hidden" id="id" name="id" value="${tShDrugInfoJsPage.id}"/>
	<div class="form-group">
		<label for="agencyname" class="col-sm-3 control-label">经销商全称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="agencyname" name="agencyname" value='${tShDrugInfoJsPage.agencyname}' type="text" maxlength="100" class="form-control input-sm" placeholder="请输入经销商全称"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="agencyshortname" class="col-sm-3 control-label">经销商简称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="agencyshortname" name="agencyshortname" value='${tShDrugInfoJsPage.agencyshortname}' type="text" maxlength="20" class="form-control input-sm" placeholder="请输入经销商简称"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="buyno" class="col-sm-3 control-label">采购序号：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="buyno" name="buyno" value='${tShDrugInfoJsPage.buyno}' type="text" maxlength="50" class="form-control input-sm" placeholder="请输入采购序号"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="commonname" class="col-sm-3 control-label">通用名：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="commonname" name="commonname" value='${tShDrugInfoJsPage.commonname}' type="text" maxlength="100" class="form-control input-sm" placeholder="请输入通用名"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="contractname" class="col-sm-3 control-label">合同名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="contractname" name="contractname" value='${tShDrugInfoJsPage.contractname}' type="text" maxlength="100" class="form-control input-sm" placeholder="请输入合同名称"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="createDate" class="col-sm-3 control-label">创建日期：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
      		    <input id="createDate" name="createDate" type="text" class="form-control input-sm" placeholder="请输入创建日期"  ignore="ignore"  value="<fmt:formatDate pattern='yyyy-MM-dd' type='date' value='${tShDrugInfoJsPage.createDate}'/>" />
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
				<input id="createName" name="createName" value='${tShDrugInfoJsPage.createName}' type="text" maxlength="50" class="form-control input-sm" placeholder="请输入创建人名称"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="drugclass" class="col-sm-3 control-label">药品类别：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="drugclass" name="drugclass" value='${tShDrugInfoJsPage.drugclass}' type="text" maxlength="40" class="form-control input-sm" placeholder="请输入药品类别"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="drugcodeent" class="col-sm-3 control-label">公司商品代码：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="drugcodeent" name="drugcodeent" value='${tShDrugInfoJsPage.drugcodeent}' type="text" maxlength="20" class="form-control input-sm" placeholder="请输入公司商品代码"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="drugform" class="col-sm-3 control-label">剂型：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="drugform" name="drugform" value='${tShDrugInfoJsPage.drugform}' type="text" maxlength="20" class="form-control input-sm" placeholder="请输入剂型"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="drugmemo" class="col-sm-3 control-label">产品备注：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="drugmemo" name="drugmemo" value='${tShDrugInfoJsPage.drugmemo}' type="text" maxlength="20" class="form-control input-sm" placeholder="请输入产品备注"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="enterprisename" class="col-sm-3 control-label">生产企业全称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="enterprisename" name="enterprisename" value='${tShDrugInfoJsPage.enterprisename}' type="text" maxlength="255" class="form-control input-sm" placeholder="请输入生产企业全称"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="gg" class="col-sm-3 control-label">规格：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="gg" name="gg" value='${tShDrugInfoJsPage.gg}' type="text" maxlength="100" class="form-control input-sm" placeholder="请输入规格"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="groupname" class="col-sm-3 control-label">评审分组：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="groupname" name="groupname" value='${tShDrugInfoJsPage.groupname}' type="text" maxlength="20" class="form-control input-sm" placeholder="请输入评审分组"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="isactive" class="col-sm-3 control-label">状态：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="isactive" name="isactive" value='${tShDrugInfoJsPage.isactive}' type="text" maxlength="20" class="form-control input-sm" placeholder="请输入状态"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="memo" class="col-sm-3 control-label">备注：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="memo" name="memo" value='${tShDrugInfoJsPage.memo}' type="text" maxlength="100" class="form-control input-sm" placeholder="请输入备注"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="minpcs" class="col-sm-3 control-label">最小包装单位：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="minpcs" name="minpcs" value='${tShDrugInfoJsPage.minpcs}' type="text" maxlength="20" class="form-control input-sm" placeholder="请输入最小包装单位"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="pkccz" class="col-sm-3 control-label">包装材质：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="pkccz" name="pkccz" value='${tShDrugInfoJsPage.pkccz}' type="text" maxlength="50" class="form-control input-sm" placeholder="请输入包装材质"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="place" class="col-sm-3 control-label">交易场：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="place" name="place" value='${tShDrugInfoJsPage.place}' type="text" maxlength="50" class="form-control input-sm" placeholder="请输入交易场"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="rationnum" class="col-sm-3 control-label">转换比：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="rationnum" name="rationnum" value='${tShDrugInfoJsPage.rationnum}' type="text" maxlength="10" class="form-control input-sm" placeholder="请输入转换比"  datatype="n"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="registerno" class="col-sm-3 control-label">批准文号：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="registerno" name="registerno" value='${tShDrugInfoJsPage.registerno}' type="text" maxlength="100" class="form-control input-sm" placeholder="请输入批准文号"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="suppprice" class="col-sm-3 control-label">供应价：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="suppprice" name="suppprice" value='${tShDrugInfoJsPage.suppprice}' type="text" maxlength="10" class="form-control input-sm" placeholder="请输入供应价"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="tradename" class="col-sm-3 control-label">商品名：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="tradename" name="tradename" value='${tShDrugInfoJsPage.tradename}' type="text" maxlength="20" class="form-control input-sm" placeholder="请输入商品名"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="updateDate" class="col-sm-3 control-label">更新日期：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
      		    <input id="updateDate" name="updateDate" type="text" class="form-control input-sm" placeholder="请输入更新日期"  ignore="ignore"  value="<fmt:formatDate pattern='yyyy-MM-dd' type='date' value='${tShDrugInfoJsPage.updateDate}'/>" />
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
				<input id="updateName" name="updateName" value='${tShDrugInfoJsPage.updateName}' type="text" maxlength="50" class="form-control input-sm" placeholder="请输入更新人名称"  ignore="ignore" />
			</div>
		</div>
	</div>
</form>
<script type="text/javascript">
	var subDlgIndex = '';
	$(document).ready(function() {
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