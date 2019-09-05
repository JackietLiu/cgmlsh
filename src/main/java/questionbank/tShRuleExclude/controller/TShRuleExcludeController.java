package questionbank.tShRuleExclude.controller;
import questionbank.tShRuleExclude.entity.TShRuleExcludeEntity;
import questionbank.tShRuleExclude.service.TShRuleExcludeServiceI;

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
 * @Description: t_sh_rule_exclude
 * @author onlineGenerator
 * @date 2019-09-05 16:39:18
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tShRuleExcludeController")
public class TShRuleExcludeController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(TShRuleExcludeController.class);

	@Autowired
	private TShRuleExcludeServiceI tShRuleExcludeService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * t_sh_rule_exclude列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("questionbank/tShRuleExclude/tShRuleExcludeList");
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
	public void datagrid(TShRuleExcludeEntity tShRuleExclude,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TShRuleExcludeEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShRuleExclude, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tShRuleExcludeService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除t_sh_rule_exclude
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TShRuleExcludeEntity tShRuleExclude, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tShRuleExclude = systemService.getEntity(TShRuleExcludeEntity.class, tShRuleExclude.getId());
		message = "t_sh_rule_exclude删除成功";
		try{
			tShRuleExcludeService.delete(tShRuleExclude);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "t_sh_rule_exclude删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除t_sh_rule_exclude
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "t_sh_rule_exclude删除成功";
		try{
			for(String id:ids.split(",")){
				TShRuleExcludeEntity tShRuleExclude = systemService.getEntity(TShRuleExcludeEntity.class, 
				id
				);
				tShRuleExcludeService.delete(tShRuleExclude);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "t_sh_rule_exclude删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加t_sh_rule_exclude
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TShRuleExcludeEntity tShRuleExclude, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "t_sh_rule_exclude添加成功";
		try{
			tShRuleExcludeService.save(tShRuleExclude);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "t_sh_rule_exclude添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新t_sh_rule_exclude
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TShRuleExcludeEntity tShRuleExclude, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "t_sh_rule_exclude更新成功";
		TShRuleExcludeEntity t = tShRuleExcludeService.get(TShRuleExcludeEntity.class, tShRuleExclude.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tShRuleExclude, t);
			tShRuleExcludeService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "t_sh_rule_exclude更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * t_sh_rule_exclude新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TShRuleExcludeEntity tShRuleExclude, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShRuleExclude.getId())) {
			tShRuleExclude = tShRuleExcludeService.getEntity(TShRuleExcludeEntity.class, tShRuleExclude.getId());
			req.setAttribute("tShRuleExcludePage", tShRuleExclude);
		}
		return new ModelAndView("questionbank/tShRuleExclude/tShRuleExclude-add");
	}
	/**
	 * t_sh_rule_exclude编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TShRuleExcludeEntity tShRuleExclude, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShRuleExclude.getId())) {
			tShRuleExclude = tShRuleExcludeService.getEntity(TShRuleExcludeEntity.class, tShRuleExclude.getId());
			req.setAttribute("tShRuleExcludePage", tShRuleExclude);
		}
		return new ModelAndView("questionbank/tShRuleExclude/tShRuleExclude-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tShRuleExcludeController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TShRuleExcludeEntity tShRuleExclude,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TShRuleExcludeEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShRuleExclude, request.getParameterMap());
		List<TShRuleExcludeEntity> tShRuleExcludes = this.tShRuleExcludeService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"t_sh_rule_exclude");
		modelMap.put(NormalExcelConstants.CLASS,TShRuleExcludeEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("t_sh_rule_exclude列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tShRuleExcludes);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TShRuleExcludeEntity tShRuleExclude,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"t_sh_rule_exclude");
    	modelMap.put(NormalExcelConstants.CLASS,TShRuleExcludeEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("t_sh_rule_exclude列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TShRuleExcludeEntity> listTShRuleExcludeEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TShRuleExcludeEntity.class,params);
				for (TShRuleExcludeEntity tShRuleExclude : listTShRuleExcludeEntitys) {
					tShRuleExcludeService.save(tShRuleExclude);
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
