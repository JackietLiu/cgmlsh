package configtools.tbconfig.controller;
import configtools.tbconfig.entity.TbConfig2Entity;
import configtools.tbconfig.service.TbConfig2ServiceI;
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
 * @Description: 系统配置
 * @author JackietLiu
 * @date 2018-02-01 09:58:41
 * @version V1.0   
 *
 */
@Api(value="TbConfig2",description="系统配置",tags="tbConfig2Controller")
@Controller
@RequestMapping("/tbConfig2Controller")
public class TbConfig2Controller extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TbConfig2Controller.class);

	@Autowired
	private TbConfig2ServiceI tbConfig2Service;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;


	/**
	 * 系统配置列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		String id = request.getParameter("id");		
       // request.setAttribute("id", id);
		//String sql = " select * from tb_config where id='"+id+"'";
		TbConfig2Entity json=	tbConfig2Service.get(TbConfig2Entity.class, id);
		//System.out.println(json);
		request.setAttribute("json", json);
		return new ModelAndView("configtools/tbconfig/tbConfig2List");
	}
	
	/**
	 * 系统配置列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "rightPage")
	public ModelAndView rightPage(HttpServletRequest request) {
		String id = request.getParameter("id");		
        request.setAttribute("id", id);
		return new ModelAndView("configtools/tbconfig/rightPage");
	}
	
	/**
	 * 系统配置树形结构 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "tbConfigTree")
	public ModelAndView tree(HttpServletRequest request) {
		String sql = "select distinct groupflag as id ,groupflagname as name,'' as pid from tb_config\n" + 
				"union \n" + 
				"select id as id ,confname as name ,groupflag as pid from tb_config";
		String json=	tbConfig2Service.sql2json(sql);
		//System.out.println(json);
		request.setAttribute("citynodes", json);
		return new ModelAndView("configtools/tbconfig/tbConfigTree");
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
	public void datagrid(TbConfig2Entity tbConfig2,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TbConfig2Entity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tbConfig2, request.getParameterMap());
	    String id = request.getParameter("id");
		try{
		//自定义追加查询条件
			cq.eq("id", id);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tbConfig2Service.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除系统配置
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TbConfig2Entity tbConfig2, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tbConfig2 = systemService.getEntity(TbConfig2Entity.class, tbConfig2.getId());
		message = "系统配置删除成功";
		try{
			tbConfig2Service.delete(tbConfig2);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "系统配置删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除系统配置
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "系统配置删除成功";
		try{
			for(String id:ids.split(",")){
				TbConfig2Entity tbConfig2 = systemService.getEntity(TbConfig2Entity.class, 
				id
				);
				tbConfig2Service.delete(tbConfig2);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "系统配置删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加系统配置
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TbConfig2Entity tbConfig2, HttpServletRequest request) {
		String message = null;
	
		AjaxJson j = new AjaxJson();

		message = "系统配置添加成功";
		try{
			
			tbConfig2Service.save(tbConfig2);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "系统配置添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新系统配置
	 * 
	 * @param ids
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TbConfig2Entity tbConfig2, HttpServletRequest request,HttpServletResponse response) throws IOException {
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
		return j;
		//response.sendRedirect("configtools/tbconfig/tbConfig2List");
	}
	

	/**
	 * 系统配置新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TbConfig2Entity tbConfig2, HttpServletRequest req) {
		String id =req.getParameter("id");
		String pid =req.getParameter("pid");
		System.out.println("id="+id+";pid="+pid);
		if(pid!=null&&pid!="") {
			tbConfig2.setGroupflag(pid);	
			req.setAttribute("pid", pid);
		}			
	/*	if(StringUtil.isNotEmpty(quesId)){
			SmQuestionEntity  sques=systemService.get(SmQuestionEntity.class, quesId);
			req.setAttribute("quesType", sques.getQuesType());
		}*/								
		if (StringUtil.isNotEmpty(tbConfig2.getId())) {
			tbConfig2 = tbConfig2Service.getEntity(TbConfig2Entity.class, tbConfig2.getId());
			req.setAttribute("tbConfig2Page", tbConfig2);
		}
		return new ModelAndView("configtools/tbconfig/tbConfig2-add");
	}
	/**
	 * 系统配置编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "empty")
	public ModelAndView empty(TbConfig2Entity tbConfig2, HttpServletRequest req) {
		return new ModelAndView("configtools/tbconfig/empty");
	}
	/**
	 * 系统配置编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TbConfig2Entity tbConfig2, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tbConfig2.getId())) {
			tbConfig2 = tbConfig2Service.getEntity(TbConfig2Entity.class, tbConfig2.getId());
			req.setAttribute("tbConfig2Page", tbConfig2);
		}
		return new ModelAndView("configtools/tbconfig/tbConfig2-update");
	}
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tbConfig2Controller");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TbConfig2Entity tbConfig2,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TbConfig2Entity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tbConfig2, request.getParameterMap());
		List<TbConfig2Entity> tbConfig2s = this.tbConfig2Service.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"系统配置");
		modelMap.put(NormalExcelConstants.CLASS,TbConfig2Entity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("系统配置列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tbConfig2s);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TbConfig2Entity tbConfig2,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"系统配置");
    	modelMap.put(NormalExcelConstants.CLASS,TbConfig2Entity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("系统配置列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TbConfig2Entity> listTbConfig2Entitys = ExcelImportUtil.importExcel(file.getInputStream(),TbConfig2Entity.class,params);
				for (TbConfig2Entity tbConfig2 : listTbConfig2Entitys) {
					tbConfig2Service.save(tbConfig2);
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
	@ApiOperation(value="系统配置列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<TbConfig2Entity>> list() {
		List<TbConfig2Entity> listTbConfig2s=tbConfig2Service.getList(TbConfig2Entity.class);
		return Result.success(listTbConfig2s);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取系统配置信息",notes="根据ID获取系统配置信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		TbConfig2Entity task = tbConfig2Service.get(TbConfig2Entity.class, id);
		if (task == null) {
			return Result.error("根据ID获取系统配置信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建系统配置")
	public ResponseMessage<?> create(@ApiParam(name="系统配置对象")@RequestBody TbConfig2Entity tbConfig2, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TbConfig2Entity>> failures = validator.validate(tbConfig2);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tbConfig2Service.save(tbConfig2);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("系统配置信息保存失败");
		}
		return Result.success(tbConfig2);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新系统配置",notes="更新系统配置")
	public ResponseMessage<?> update(@ApiParam(name="系统配置对象")@RequestBody TbConfig2Entity tbConfig2) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TbConfig2Entity>> failures = validator.validate(tbConfig2);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tbConfig2Service.saveOrUpdate(tbConfig2);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新系统配置信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新系统配置信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除系统配置")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			tbConfig2Service.deleteEntityById(TbConfig2Entity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("系统配置删除失败");
		}

		return Result.success();
	}
}
