package com.jeecg.tShDrugValueInfoNew.controller;
import com.jeecg.tShDrugValueInfoNew.entity.TShDrugValueInfoNewEntity;
import com.jeecg.tShDrugValueInfoNew.service.TShDrugValueInfoNewServiceI;

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
 * @Description: 一致性评价药品清单
 * @author onlineGenerator
 * @date 2019-02-25 16:18:16
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tShDrugValueInfoNewController")
public class TShDrugValueInfoNewController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(TShDrugValueInfoNewController.class);

	@Autowired
	private TShDrugValueInfoNewServiceI tShDrugValueInfoNewService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 一致性评价药品清单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/tShDrugValueInfoNew/tShDrugValueInfoNewList");
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
	public void datagrid(TShDrugValueInfoNewEntity tShDrugValueInfoNew,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TShDrugValueInfoNewEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShDrugValueInfoNew, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tShDrugValueInfoNewService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除一致性评价药品清单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TShDrugValueInfoNewEntity tShDrugValueInfoNew, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tShDrugValueInfoNew = systemService.getEntity(TShDrugValueInfoNewEntity.class, tShDrugValueInfoNew.getId());
		message = "一致性评价药品清单删除成功";
		try{
			tShDrugValueInfoNewService.delete(tShDrugValueInfoNew);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "一致性评价药品清单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除一致性评价药品清单
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "一致性评价药品清单删除成功";
		try{
			for(String id:ids.split(",")){
				TShDrugValueInfoNewEntity tShDrugValueInfoNew = systemService.getEntity(TShDrugValueInfoNewEntity.class, 
				id
				);
				tShDrugValueInfoNewService.delete(tShDrugValueInfoNew);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "一致性评价药品清单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加一致性评价药品清单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TShDrugValueInfoNewEntity tShDrugValueInfoNew, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "一致性评价药品清单添加成功";
		try{
			tShDrugValueInfoNewService.save(tShDrugValueInfoNew);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "一致性评价药品清单添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新一致性评价药品清单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TShDrugValueInfoNewEntity tShDrugValueInfoNew, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "一致性评价药品清单更新成功";
		TShDrugValueInfoNewEntity t = tShDrugValueInfoNewService.get(TShDrugValueInfoNewEntity.class, tShDrugValueInfoNew.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tShDrugValueInfoNew, t);
			tShDrugValueInfoNewService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "一致性评价药品清单更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 一致性评价药品清单新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TShDrugValueInfoNewEntity tShDrugValueInfoNew, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShDrugValueInfoNew.getId())) {
			tShDrugValueInfoNew = tShDrugValueInfoNewService.getEntity(TShDrugValueInfoNewEntity.class, tShDrugValueInfoNew.getId());
			req.setAttribute("tShDrugValueInfoNewPage", tShDrugValueInfoNew);
		}
		return new ModelAndView("com/jeecg/tShDrugValueInfoNew/tShDrugValueInfoNew-add");
	}
	/**
	 * 一致性评价药品清单编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TShDrugValueInfoNewEntity tShDrugValueInfoNew, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShDrugValueInfoNew.getId())) {
			tShDrugValueInfoNew = tShDrugValueInfoNewService.getEntity(TShDrugValueInfoNewEntity.class, tShDrugValueInfoNew.getId());
			req.setAttribute("tShDrugValueInfoNewPage", tShDrugValueInfoNew);
		}
		return new ModelAndView("com/jeecg/tShDrugValueInfoNew/tShDrugValueInfoNew-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tShDrugValueInfoNewController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TShDrugValueInfoNewEntity tShDrugValueInfoNew,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TShDrugValueInfoNewEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShDrugValueInfoNew, request.getParameterMap());
		List<TShDrugValueInfoNewEntity> tShDrugValueInfoNews = this.tShDrugValueInfoNewService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"一致性评价药品清单");
		modelMap.put(NormalExcelConstants.CLASS,TShDrugValueInfoNewEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("一致性评价药品清单列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tShDrugValueInfoNews);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TShDrugValueInfoNewEntity tShDrugValueInfoNew,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"一致性评价药品清单");
    	modelMap.put(NormalExcelConstants.CLASS,TShDrugValueInfoNewEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("一致性评价药品清单列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TShDrugValueInfoNewEntity> listTShDrugValueInfoNewEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TShDrugValueInfoNewEntity.class,params);
				for (TShDrugValueInfoNewEntity tShDrugValueInfoNew : listTShDrugValueInfoNewEntitys) {
					tShDrugValueInfoNewService.save(tShDrugValueInfoNew);
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
