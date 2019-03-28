package questionbank.tShHospDrugListHistory.controller;
import questionbank.tShHospDrugListHistory.entity.TShHospDrugListHistoryEntity;
import questionbank.tShHospDrugListHistory.service.TShHospDrugListHistoryServiceI;

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

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;

import org.jeecgframework.core.util.ExceptionUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * @Title: Controller  
 * @Description: 医院药品历史记录
 * @author onlineGenerator
 * @date 2019-02-21 11:05:25
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tShHospDrugListHistoryController")
public class TShHospDrugListHistoryController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(TShHospDrugListHistoryController.class);

	@Autowired
	private TShHospDrugListHistoryServiceI tShHospDrugListHistoryService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 医院药品历史记录列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("questionbank/tShHospDrugListHistory/tShHospDrugListHistoryList");
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
	public void datagrid(TShHospDrugListHistoryEntity tShHospDrugListHistory,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TShHospDrugListHistoryEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShHospDrugListHistory, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tShHospDrugListHistoryService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除医院药品历史记录
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TShHospDrugListHistoryEntity tShHospDrugListHistory, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tShHospDrugListHistory = systemService.getEntity(TShHospDrugListHistoryEntity.class, tShHospDrugListHistory.getId());
		message = "医院药品历史记录删除成功";
		try{
			tShHospDrugListHistoryService.delete(tShHospDrugListHistory);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "医院药品历史记录删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除医院药品历史记录
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "医院药品历史记录删除成功";
		try{
			for(String id:ids.split(",")){
				TShHospDrugListHistoryEntity tShHospDrugListHistory = systemService.getEntity(TShHospDrugListHistoryEntity.class, 
				id
				);
				tShHospDrugListHistoryService.delete(tShHospDrugListHistory);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "医院药品历史记录删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加医院药品历史记录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TShHospDrugListHistoryEntity tShHospDrugListHistory, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "医院药品历史记录添加成功";
		try{
			tShHospDrugListHistoryService.save(tShHospDrugListHistory);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "医院药品历史记录添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新医院药品历史记录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TShHospDrugListHistoryEntity tShHospDrugListHistory, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "医院药品历史记录更新成功";
		TShHospDrugListHistoryEntity t = tShHospDrugListHistoryService.get(TShHospDrugListHistoryEntity.class, tShHospDrugListHistory.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tShHospDrugListHistory, t);
			tShHospDrugListHistoryService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "医院药品历史记录更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 医院药品历史记录新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TShHospDrugListHistoryEntity tShHospDrugListHistory, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShHospDrugListHistory.getId())) {
			tShHospDrugListHistory = tShHospDrugListHistoryService.getEntity(TShHospDrugListHistoryEntity.class, tShHospDrugListHistory.getId());
			req.setAttribute("tShHospDrugListHistory", tShHospDrugListHistory);
		}
		return new ModelAndView("questionbank/tShHospDrugListHistory/tShHospDrugListHistory-add");
	}
	/**
	 * 医院药品历史记录编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TShHospDrugListHistoryEntity tShHospDrugListHistory, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShHospDrugListHistory.getId())) {
			tShHospDrugListHistory = tShHospDrugListHistoryService.getEntity(TShHospDrugListHistoryEntity.class, tShHospDrugListHistory.getId());
			req.setAttribute("tShHospDrugListHistory", tShHospDrugListHistory);
		}
		return new ModelAndView("questionbank/tShHospDrugListHistory/tShHospDrugListHistory-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tShHospDrugListHistoryController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TShHospDrugListHistoryEntity tShHospDrugListHistory,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TShHospDrugListHistoryEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShHospDrugListHistory, request.getParameterMap());
		List<TShHospDrugListHistoryEntity> tShHospDrugListHistorys = this.tShHospDrugListHistoryService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"医院药品历史记录");
		modelMap.put(NormalExcelConstants.CLASS,TShHospDrugListHistoryEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("医院药品历史记录列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tShHospDrugListHistorys);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TShHospDrugListHistoryEntity tShHospDrugListHistory,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"医院药品历史记录");
    	modelMap.put(NormalExcelConstants.CLASS,TShHospDrugListHistoryEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("医院药品历史记录列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TShHospDrugListHistoryEntity> listTShHospDrugListHistoryEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TShHospDrugListHistoryEntity.class,params);
				for (TShHospDrugListHistoryEntity tShHospDrugListHistory : listTShHospDrugListHistoryEntitys) {
					tShHospDrugListHistoryService.save(tShHospDrugListHistory);
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
