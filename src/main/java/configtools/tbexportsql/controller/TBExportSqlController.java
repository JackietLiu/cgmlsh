package configtools.tbexportsql.controller;
import configtools.export2insert;
import configtools.tbexportsql.entity.TBExportSqlEntity;
import configtools.tbexportsql.service.TBExportSqlServiceI;
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
import java.net.URLDecoder;

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
 * @Description: 导出数据
 * @author onlineGenerator
 * @date 2018-01-29 16:27:55
 * @version V1.0   
 *
 */
@Api(value="TBExportSql",description="导出数据",tags="tBExportSqlController")
@Controller
@RequestMapping("/tBExportSqlController")
public class TBExportSqlController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TBExportSqlController.class);

	@Autowired
	private TBExportSqlServiceI tBExportSqlService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;


	/**zczadd 
	 * 导出数据列表 页面跳转
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "execute")
	@ResponseBody
	public AjaxJson execute(HttpServletRequest request) throws Exception {
		AjaxJson j=new AjaxJson();
		String sqlscript=URLDecoder.decode(request.getParameter("sqlscript") , "UTF-8");
		String thefile=URLDecoder.decode(request.getParameter("thefile"), "UTF-8");
		String connstr=URLDecoder.decode(request.getParameter("connstr"), "UTF-8");
		String thepassword=URLDecoder.decode(request.getParameter("thepassword"), "UTF-8");
		String thedbtype=URLDecoder.decode(request.getParameter("thedbtype"), "UTF-8");
		String theusername=URLDecoder.decode(request.getParameter("theusername"), "UTF-8");
		String thetablename=URLDecoder.decode(request.getParameter("thetablename"), "UTF-8");
		export2insert.execute(thefile, sqlscript, thedbtype, connstr, theusername, thepassword, thetablename) ;
		j.setMsg("导出成功，请使用文本工具打开" +thefile +" 文件查看！" );
		return j;
	}
	
	
	
	/**
	 * 导出数据列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("configtools/tbexportsql/tBExportSqlList");
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
	public void datagrid(TBExportSqlEntity tBExportSql,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TBExportSqlEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBExportSql, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tBExportSqlService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除导出数据
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TBExportSqlEntity tBExportSql, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tBExportSql = systemService.getEntity(TBExportSqlEntity.class, tBExportSql.getId());
		message = "导出数据删除成功";
		try{
			tBExportSqlService.delete(tBExportSql);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "导出数据删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除导出数据
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "导出数据删除成功";
		try{
			for(String id:ids.split(",")){
				TBExportSqlEntity tBExportSql = systemService.getEntity(TBExportSqlEntity.class, 
				id
				);
				tBExportSqlService.delete(tBExportSql);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "导出数据删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加导出数据
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TBExportSqlEntity tBExportSql, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "导出数据添加成功";
		try{
			tBExportSqlService.save(tBExportSql);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "导出数据添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新导出数据
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TBExportSqlEntity tBExportSql, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "导出数据更新成功";
		TBExportSqlEntity t = tBExportSqlService.get(TBExportSqlEntity.class, tBExportSql.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tBExportSql, t);
			tBExportSqlService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "导出数据更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 导出数据新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TBExportSqlEntity tBExportSql, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBExportSql.getId())) {
			tBExportSql = tBExportSqlService.getEntity(TBExportSqlEntity.class, tBExportSql.getId());
			req.setAttribute("tBExportSqlPage", tBExportSql);
		}
		return new ModelAndView("configtools/tbexportsql/tBExportSql-add");
	}
	/**
	 * 导出数据编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TBExportSqlEntity tBExportSql, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBExportSql.getId())) {
			tBExportSql = tBExportSqlService.getEntity(TBExportSqlEntity.class, tBExportSql.getId());
			req.setAttribute("tBExportSqlPage", tBExportSql);
		}
		return new ModelAndView("configtools/tbexportsql/tBExportSql-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tBExportSqlController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TBExportSqlEntity tBExportSql,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TBExportSqlEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBExportSql, request.getParameterMap());
		List<TBExportSqlEntity> tBExportSqls = this.tBExportSqlService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"导出数据");
		modelMap.put(NormalExcelConstants.CLASS,TBExportSqlEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("导出数据列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tBExportSqls);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TBExportSqlEntity tBExportSql,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"导出数据");
    	modelMap.put(NormalExcelConstants.CLASS,TBExportSqlEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("导出数据列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TBExportSqlEntity> listTBExportSqlEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TBExportSqlEntity.class,params);
				for (TBExportSqlEntity tBExportSql : listTBExportSqlEntitys) {
					tBExportSqlService.save(tBExportSql);
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
	@ApiOperation(value="导出数据列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<TBExportSqlEntity>> list() {
		List<TBExportSqlEntity> listTBExportSqls=tBExportSqlService.getList(TBExportSqlEntity.class);
		return Result.success(listTBExportSqls);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取导出数据信息",notes="根据ID获取导出数据信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		TBExportSqlEntity task = tBExportSqlService.get(TBExportSqlEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取导出数据信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建导出数据")
	public ResponseMessage<?> create(@ApiParam(name="导出数据对象")@RequestBody TBExportSqlEntity tBExportSql, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBExportSqlEntity>> failures = validator.validate(tBExportSql);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBExportSqlService.save(tBExportSql);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("导出数据信息保存失败");
		}
		return Result.success(tBExportSql);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新导出数据",notes="更新导出数据")
	public ResponseMessage<?> update(@ApiParam(name="导出数据对象")@RequestBody TBExportSqlEntity tBExportSql) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBExportSqlEntity>> failures = validator.validate(tBExportSql);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			tBExportSqlService.saveOrUpdate(tBExportSql);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新导出数据信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新导出数据信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除导出数据")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" + id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			tBExportSqlService.deleteEntityById(TBExportSqlEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("导出数据删除失败");
		}

		return Result.success();
	}
}
