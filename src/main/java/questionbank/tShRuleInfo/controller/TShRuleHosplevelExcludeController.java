package questionbank.tShRuleInfo.controller;
import questionbank.tShRuleInfo.entity.TShRuleHosplevelExcludeEntity;
import questionbank.tShRuleInfo.service.TShRuleHosplevelExcludeServiceI;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import java.util.HashMap;
import org.jeecgframework.core.util.ExceptionUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * @Title: Controller  
 * @Description: 按级别设置
 * @author onlineGenerator
 * @date 2019-03-06 16:59:21
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tShRuleHosplevelExcludeController")
public class TShRuleHosplevelExcludeController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(TShRuleHosplevelExcludeController.class);

	@Autowired
	private TShRuleHosplevelExcludeServiceI tShRuleHosplevelExcludeService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 按级别设置列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("questionbank/tShRuleInfo/tShRuleHosplevelExcludeList");
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
	public void datagrid(TShRuleHosplevelExcludeEntity tShRuleHosplevelExclude,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TShRuleHosplevelExcludeEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShRuleHosplevelExclude, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tShRuleHosplevelExcludeService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除按级别设置
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TShRuleHosplevelExcludeEntity tShRuleHosplevelExclude, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tShRuleHosplevelExclude = systemService.getEntity(TShRuleHosplevelExcludeEntity.class, tShRuleHosplevelExclude.getId());
		message = "按级别设置删除成功";
		try{
			tShRuleHosplevelExcludeService.delete(tShRuleHosplevelExclude);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "按级别设置删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除按级别设置
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "按级别设置删除成功";
		try{
			for(String id:ids.split(",")){
				TShRuleHosplevelExcludeEntity tShRuleHosplevelExclude = systemService.getEntity(TShRuleHosplevelExcludeEntity.class, 
				id
				);
				tShRuleHosplevelExcludeService.delete(tShRuleHosplevelExclude);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "按级别设置删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加按级别设置
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TShRuleHosplevelExcludeEntity tShRuleHosplevelExclude, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "按级别设置添加成功";
		try{
			tShRuleHosplevelExcludeService.save(tShRuleHosplevelExclude);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "按级别设置添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新按级别设置
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TShRuleHosplevelExcludeEntity tShRuleHosplevelExclude, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "按级别设置更新成功";
		TShRuleHosplevelExcludeEntity t = tShRuleHosplevelExcludeService.get(TShRuleHosplevelExcludeEntity.class, tShRuleHosplevelExclude.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tShRuleHosplevelExclude, t);
			tShRuleHosplevelExcludeService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "按级别设置更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 按级别设置新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TShRuleHosplevelExcludeEntity tShRuleHosplevelExclude, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShRuleHosplevelExclude.getId())) {
			tShRuleHosplevelExclude = tShRuleHosplevelExcludeService.getEntity(TShRuleHosplevelExcludeEntity.class, tShRuleHosplevelExclude.getId());
			req.setAttribute("tShRuleHosplevelExclude", tShRuleHosplevelExclude);
		}
		return new ModelAndView("questionbank/tShRuleInfo/tShRuleHosplevelExclude-add");
	}
	/**
	 * 按级别设置编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TShRuleHosplevelExcludeEntity tShRuleHosplevelExclude, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShRuleHosplevelExclude.getId())) {
			tShRuleHosplevelExclude = tShRuleHosplevelExcludeService.getEntity(TShRuleHosplevelExcludeEntity.class, tShRuleHosplevelExclude.getId());
			req.setAttribute("tShRuleHosplevelExcludePage", tShRuleHosplevelExclude);
		}
		return new ModelAndView("questionbank/tShRuleInfo/tShRuleHosplevelExclude-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tShRuleHosplevelExcludeController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TShRuleHosplevelExcludeEntity tShRuleHosplevelExclude,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TShRuleHosplevelExcludeEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShRuleHosplevelExclude, request.getParameterMap());
		List<TShRuleHosplevelExcludeEntity> tShRuleHosplevelExcludes = this.tShRuleHosplevelExcludeService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"按级别设置");
		modelMap.put(NormalExcelConstants.CLASS,TShRuleHosplevelExcludeEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("按级别设置列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tShRuleHosplevelExcludes);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TShRuleHosplevelExcludeEntity tShRuleHosplevelExclude,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"按级别设置");
    	modelMap.put(NormalExcelConstants.CLASS,TShRuleHosplevelExcludeEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("按级别设置列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TShRuleHosplevelExcludeEntity> listTShRuleHosplevelExcludeEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TShRuleHosplevelExcludeEntity.class,params);
				for (TShRuleHosplevelExcludeEntity tShRuleHosplevelExclude : listTShRuleHosplevelExcludeEntitys) {
					tShRuleHosplevelExcludeService.save(tShRuleHosplevelExclude);
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
	
	
}
