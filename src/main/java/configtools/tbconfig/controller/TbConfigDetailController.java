package configtools.tbconfig.controller;
import configtools.tbconfig.entity.TbConfig2Entity;
import configtools.tbconfig.service.TbConfig2ServiceI;
import configtools.tbconfig.entity.TbConfigDetailEntity;
import configtools.tbconfig.service.TbConfigDetailServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.TreeChildCount;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import java.util.HashMap;
import org.jeecgframework.core.util.ExceptionUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.jwt.util.GsonUtil;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller  
 * @Description: 系统配置详情
 * @author JackietLiu
 * @date 2018-02-01 12:54:08
 * @version V1.0   
 *
 */
@Api(value="TbConfigDetail",description="系统配置详情",tags="tbConfigDetailController")
@Controller
@RequestMapping("/tbConfigDetailController")
public class TbConfigDetailController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TbConfigDetailController.class);

	@Autowired
	private TbConfigDetailServiceI tbConfigDetailService;
	@Autowired
	private TbConfig2ServiceI tbConfig2Service;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 系统配置详情列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		String id = request.getParameter("confid");	
		String user = ResourceUtil.getSessionUser().getId();
		String sql1 = "SELECT * FROM tb_config_detail WHERE userid='"+user+"' AND confid='"+id+"'";
		TbConfigDetailEntity tbConfigDetail = (TbConfigDetailEntity) tbConfigDetailService.getSession().createSQLQuery(sql1).addEntity(TbConfigDetailEntity.class).uniqueResult();		
	   if(tbConfigDetail !=null) {
		   request.setAttribute("isTbConfigDetail", "Y");
		   request.setAttribute("tbConfigDetail", tbConfigDetail);
	   }else {
		String sql = "SELECT * FROM tb_config WHERE  id='"+id+"'";
		TbConfig2Entity tbConfig = (TbConfig2Entity) tbConfig2Service.getSession().createSQLQuery(sql).addEntity(TbConfig2Entity.class).uniqueResult();
		request.setAttribute("isTbConfigDetail", "N");
		request.setAttribute("tbConfigDetail", tbConfig);
	   }
		return new ModelAndView("configtools/tbconfig/userConfig");
	}
	@RequestMapping(params = "list2")
	public ModelAndView list2(HttpServletRequest request) {
		String id = request.getParameter("confid");	
		String user = ResourceUtil.getSessionUser().getId();
		String sql1 = "SELECT * FROM tb_config_detail WHERE userid='"+user+"' AND confid='"+id+"'";
		TbConfigDetailEntity tbConfigDetail = (TbConfigDetailEntity) tbConfigDetailService.getSession().createSQLQuery(sql1).addEntity(TbConfigDetailEntity.class).uniqueResult();		
	   if(tbConfigDetail !=null) {
		   request.setAttribute("isTbConfigDetail", "Y");
		   request.setAttribute("tbConfigDetail", tbConfigDetail);
	   }else {
		String sql = "SELECT * FROM tb_config WHERE  id='"+id+"'";
		TbConfig2Entity tbConfig = (TbConfig2Entity) tbConfig2Service.getSession().createSQLQuery(sql).addEntity(TbConfig2Entity.class).uniqueResult();
		request.setAttribute("isTbConfigDetail", "N");
		request.setAttribute("tbConfigDetail", tbConfig);
	   }
		return new ModelAndView("configtools/tbconfig/roleConfig");
	}
	@RequestMapping(params = "list3")
	public ModelAndView list3(HttpServletRequest request) {
		String id = request.getParameter("confid");	
		String user = ResourceUtil.getSessionUser().getId();
		String sql1 = "SELECT * FROM tb_config_detail WHERE userid='"+user+"' AND confid='"+id+"'";
		TbConfigDetailEntity tbConfigDetail = (TbConfigDetailEntity) tbConfigDetailService.getSession().createSQLQuery(sql1).addEntity(TbConfigDetailEntity.class).uniqueResult();		
	   if(tbConfigDetail !=null) {
		   request.setAttribute("isTbConfigDetail", "Y");
		   request.setAttribute("tbConfigDetail", tbConfigDetail);
	   }else {
		String sql = "SELECT * FROM tb_config WHERE  id='"+id+"'";
		TbConfig2Entity tbConfig = (TbConfig2Entity) tbConfig2Service.getSession().createSQLQuery(sql).addEntity(TbConfig2Entity.class).uniqueResult();
		request.setAttribute("isTbConfigDetail", "N");
		request.setAttribute("tbConfigDetail", tbConfig);
	   }
		return new ModelAndView("configtools/tbconfig/departConfig");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TbConfigDetailEntity tbConfigDetail,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TbConfigDetailEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tbConfigDetail, request.getParameterMap());
		String id = request.getParameter("confid");
		try{
		//自定义追加查询条件
			cq.eq("confid", id);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tbConfigDetailService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除系统配置详情
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TbConfigDetailEntity tbConfigDetail, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tbConfigDetail = systemService.getEntity(TbConfigDetailEntity.class, tbConfigDetail.getId());
		message = "系统配置详情删除成功";
		try{
			tbConfigDetailService.delete(tbConfigDetail);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "系统配置详情删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除系统配置详情
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "系统配置详情删除成功";
		try{
			for(String id:ids.split(",")){
				TbConfigDetailEntity tbConfigDetail = systemService.getEntity(TbConfigDetailEntity.class, 
				id
				);
				tbConfigDetailService.delete(tbConfigDetail);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "系统配置详情删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加系统配置详情
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TbConfigDetailEntity tbConfigDetail, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "系统配置详情添加成功";
		TSUser user = ResourceUtil.getSessionUser();
		try{
			tbConfigDetail.setUserid(user.getId());
			tbConfigDetail.setDeptid(user.getDepartid());
			tbConfigDetailService.save(tbConfigDetail);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "系统配置详情添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return  j;
	}
/*	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public ModelAndView doUpdate(TbConfig2Entity tbConfig2, HttpServletRequest request,HttpServletResponse response) throws IOException {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "系统配置更新成功";
		TbConfig2Entity t = tbConfig2Service.get(TbConfig2Entity.class, tbConfig2.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tbConfig2, t);
			tbConfig2Service.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "系统配置更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return new ModelAndView("configtools/tbconfig/tbConfig2List");
		//response.sendRedirect("configtools/tbconfig/tbConfig2List");
	}*/
	/**
	 * 更新系统配置详情
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TbConfigDetailEntity tbConfigDetail, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "系统配置详情更新成功";
		TbConfigDetailEntity t = tbConfigDetailService.get(TbConfigDetailEntity.class, tbConfigDetail.getId());
		//TSUser user = ResourceUtil.getSessionUser();
		try {
/*			tbConfigDetail.setUserid(user.getId());
			tbConfigDetail.setDeptid(user.getDepartid());*/
			
			MyBeanUtils.copyBeanNotNull2Bean(tbConfigDetail, t);
			tbConfigDetailService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "系统配置详情更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		 return  j;
	}
	

	/**
	 * 系统配置详情新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TbConfigDetailEntity tbConfigDetail, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tbConfigDetail.getId())) {
			tbConfigDetail = tbConfigDetailService.getEntity(TbConfigDetailEntity.class, tbConfigDetail.getId());
			req.setAttribute("tbConfigDetailPage", tbConfigDetail);
		}
		return new ModelAndView("configtools/tbconfig/tbConfigDetail-add");
	}
	/**
	 * 系统配置详情编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TbConfigDetailEntity tbConfigDetail, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tbConfigDetail.getId())) {
			tbConfigDetail = tbConfigDetailService.getEntity(TbConfigDetailEntity.class, tbConfigDetail.getId());
			req.setAttribute("tbConfigDetailPage", tbConfigDetail);
		}
		return new ModelAndView("configtools/tbconfig/tbConfigDetail-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tbConfigDetailController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TbConfigDetailEntity tbConfigDetail,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TbConfigDetailEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tbConfigDetail, request.getParameterMap());
		List<TbConfigDetailEntity> tbConfigDetails = this.tbConfigDetailService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"系统配置详情");
		modelMap.put(NormalExcelConstants.CLASS,TbConfigDetailEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("系统配置详情列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tbConfigDetails);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TbConfigDetailEntity tbConfigDetail,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"系统配置详情");
    	modelMap.put(NormalExcelConstants.CLASS,TbConfigDetailEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("系统配置详情列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<TbConfigDetailEntity> listTbConfigDetailEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TbConfigDetailEntity.class,params);
				for (TbConfigDetailEntity tbConfigDetail : listTbConfigDetailEntitys) {
					tbConfigDetailService.save(tbConfigDetail);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="系统配置详情列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<TbConfigDetailEntity>> list() {
		List<TbConfigDetailEntity> listTbConfigDetails=tbConfigDetailService.getList(TbConfigDetailEntity.class);
		return Result.success(listTbConfigDetails);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取系统配置详情信息",notes="根据ID获取系统配置详情信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		TbConfigDetailEntity task = tbConfigDetailService.get(TbConfigDetailEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取系统配置详情信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建系统配置详情")
	public ResponseMessage<?> create(@ApiParam(name="系统配置详情对象")@RequestBody TbConfigDetailEntity tbConfigDetail, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TbConfigDetailEntity>> failures = validator.validate(tbConfigDetail);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tbConfigDetailService.save(tbConfigDetail);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("系统配置详情信息保存失败");
		}
		return Result.success(tbConfigDetail);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新系统配置详情",notes="更新系统配置详情")
	public ResponseMessage<?> update(@ApiParam(name="系统配置详情对象")@RequestBody TbConfigDetailEntity tbConfigDetail) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TbConfigDetailEntity>> failures = validator.validate(tbConfigDetail);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tbConfigDetailService.saveOrUpdate(tbConfigDetail);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新系统配置详情信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新系统配置详情信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除系统配置详情")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			tbConfigDetailService.deleteEntityById(TbConfigDetailEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("系统配置详情删除失败");
		}

		return Result.success();
	}
}
