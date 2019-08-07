<!--thisisid: tShDrugClassTreeUpdate.jsp  -->
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>药品目录</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="jquery,easyui,tools,DatePicker,bootstrap,bootstrap-table,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;margin-top: 20px">
 <form id="formobj" action="" class="form-horizontal validform" role="form"  method="post">
	<input type="hidden" id="btn_sub" class="btn_sub"/>
	<input type="hidden" id="id" name="id" value="${tShDrugClassPage.id}"/>
	<div class="form-group">
		<label for="classcode" class="col-sm-3 control-label">代码：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="classcode" name="classcode" value='${tShDrugClassPage.classcode}' type="text" maxlength="20" class="form-control input-sm" placeholder="请输入代码"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="classname" class="col-sm-3 control-label">名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="classname" name="classname" value='${tShDrugClassPage.classname}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入名称"  ignore="ignore" />
			</div>
		</div>
	</div>
	 <div class="form-group">
		 <label for="pid" class="col-sm-3 control-label">上一级名称：</label>
		 <div class="col-sm-7">
			 <div class="input-group" style="width:100%">
				 <%--<input id="pid" name="pid" value='${tShDrugClassPage.pid}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入上一级名称"  ignore="ignore" />--%>
				 <t:dictSelect field="pid" type="list" dictTable="t_sh_drug_class" dictField="id" dictText="classname" defaultVal="${tShDrugClassPage.pid}" extendJson="{'style' : 'width:100%'}" hasLabel="false"  title=""  readonly="readonly"
				 ></t:dictSelect>
			 </div>
		 </div>
	 </div>
	<div class="form-group">
		<label for="isactive" class="col-sm-3 control-label">是否在用：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<t:dictSelect field="isactive" type="list" typeGroupCode="isactive" defaultVal="${tShDrugClassPage.isactive}" hasLabel="false"  title="" ></t:dictSelect>
			<%--	<input id="isactive" name="isactive" value='${tShDrugClassPage.isactive}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入在用"  ignore="ignore" />--%>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="memo" class="col-sm-3 control-label">备注：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="memo" name="memo" value='${tShDrugClassPage.memo}' type="text" maxlength="100" class="form-control input-sm" placeholder="请输入备注"  ignore="ignore" />
				<%--<textarea id="memo" name="memo" maxlength="100" class="form-control" placeholder="请输入备注" >${tShDrugClassPage.memo}</textarea>--%>
			</div>
		</div>
	</div>

	<div class="form-group">
		<label for="sortindex" class="col-sm-3 control-label">排序：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="sortindex" name="sortindex" value='${tShDrugClassPage.sortindex}' type="text" maxlength="10" class="form-control input-sm" placeholder="请输入排序"  datatype="n"  ignore="ignore" />
			</div>
		</div>
	</div>
	 <div class="form-group">

		 <div style="text-align:center" >
			 <div class="input-group" style="width:100%;" >
				<button id="submit" type="button" style="font-size:18px;color: #fff;background: #0b6cbc;width: 10%;border: none;line-height: 30px;padding: 10px;">

					<span style="font-size:18px;">保存</span>
				</button>
			 </div>
		 </div>
	 </div>

 </form>
<script type="text/javascript">
	var subDlgIndex = '';
	$(document).ready(function() {

        //单选框/多选框初始化
        $('.i-checks').iCheck({
            labelHover: false,
            cursor: true,
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
            increaseArea: '20%'
        });

        //表单提交
		$("#submit").click(function () {
		    var form = $("#formobj");
			$.ajax({
				url : "tShDrugClassController.do?doUpdate",
				type : "post",
				data :form.serializeArray(),
				success : function (ret) {

				    var json = JSON.parse(ret);
                   // alert(json);
                    if(json.success){
                        $("#submit span").html("数据已提交！");
                        $("#submit").attr("disabled",true);
                        window.parent.reloadTree();
                    }else {
                        $("#submit span").html("数据提交失败，请再次点击");
                    }
                },
				error : function (e) {

                }

			})
        })
    });
</script>
</body>
</html>