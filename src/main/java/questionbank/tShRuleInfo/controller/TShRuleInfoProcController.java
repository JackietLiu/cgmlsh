package questionbank.tShRuleInfo.controller;
import questionbank.tShRuleInfo.entity.TShRuleInfoProcEntity;
import questionbank.tShRuleInfo.service.TShRuleInfoProcServiceI;

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
 * @Description: 审核规则存储过程
 * @author onlineGenerator
 * @date 2019-02-26 17:05:57
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tShRuleInfoProcController")
public class TShRuleInfoProcController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(TShRuleInfoProcController.class);

	@Autowired
	private TShRuleInfoProcServiceI tShRuleInfoProcService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 审核规则存储过程列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("questionbank/tShRuleInfo/tShRuleInfoProcList");
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
	public void datagrid(TShRuleInfoProcEntity tShRuleInfoProc,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TShRuleInfoProcEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShRuleInfoProc, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tShRuleInfoProcService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除审核规则存储过程
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TShRuleInfoProcEntity tShRuleInfoProc, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tShRuleInfoProc = systemService.getEntity(TShRuleInfoProcEntity.class, tShRuleInfoProc.getId());
		message = "审核规则存储过程删除成功";
		try{
			tShRuleInfoProcService.delete(tShRuleInfoProc);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "审核规则存储过程删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除审核规则存储过程
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "审核规则存储过程删除成功";
		try{
			for(String id:ids.split(",")){
				TShRuleInfoProcEntity tShRuleInfoProc = systemService.getEntity(TShRuleInfoProcEntity.class, 
				id
				);
				tShRuleInfoProcService.delete(tShRuleInfoProc);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "审核规则存储过程删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加审核规则存储过程
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TShRuleInfoProcEntity tShRuleInfoProc, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "审核规则存储过程添加成功";
		try{
			tShRuleInfoProcService.save(tShRuleInfoProc);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "审核规则存储过程添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新审核规则存储过程
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TShRuleInfoProcEntity tShRuleInfoProc, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "审核规则存储过程更新成功";
		TShRuleInfoProcEntity t = tShRuleInfoProcService.get(TShRuleInfoProcEntity.class, tShRuleInfoProc.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tShRuleInfoProc, t);
			tShRuleInfoProcService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "审核规则存储过程更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 审核规则存储过程新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TShRuleInfoProcEntity tShRuleInfoProc, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShRuleInfoProc.getId())) {
			tShRuleInfoProc = tShRuleInfoProcService.getEntity(TShRuleInfoProcEntity.class, tShRuleInfoProc.getId());
			req.setAttribute("tShRuleInfoProc", tShRuleInfoProc);
		}
		return new ModelAndView("questionbank/tShRuleInfo/tShRuleInfoProc-add");
	}
	/**
	 * 审核规则存储过程编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TShRuleInfoProcEntity tShRuleInfoProc, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShRuleInfoProc.getId())) {
			tShRuleInfoProc = tShRuleInfoProcService.getEntity(TShRuleInfoProcEntity.class, tShRuleInfoProc.getId());
			req.setAttribute("tShRuleInfoProcPage", tShRuleInfoProc);
		}
		return new ModelAndView("questionbank/tShRuleInfo/tShRuleInfoProc-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tShRuleInfoProcController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TShRuleInfoProcEntity tShRuleInfoProc,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TShRuleInfoProcEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShRuleInfoProc, request.getParameterMap());
		List<TShRuleInfoProcEntity> tShRuleInfoProcs = this.tShRuleInfoProcService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"审核规则存储过程");
		modelMap.put(NormalExcelConstants.CLASS,TShRuleInfoProcEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("审核规则存储过程列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tShRuleInfoProcs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TShRuleInfoProcEntity tShRuleInfoProc,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"审核规则存储过程");
    	modelMap.put(NormalExcelConstants.CLASS,TShRuleInfoProcEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("审核规则存储过程列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TShRuleInfoProcEntity> listTShRuleInfoProcEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TShRuleInfoProcEntity.class,params);
				for (TShRuleInfoProcEntity tShRuleInfoProc : listTShRuleInfoProcEntitys) {
					tShRuleInfoProcService.save(tShRuleInfoProc);
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
