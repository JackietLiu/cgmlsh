package questionbank.tShHospImportBack.controller;
import questionbank.tShHospImportBack.entity.TShHospImportBackEntity;
import questionbank.tShHospImportBack.service.TShHospImportBackServiceI;

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
 * @Description: 提交驳回记录
 * @author onlineGenerator
 * @date 2019-08-22 14:48:27
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tShHospImportBackController")
public class TShHospImportBackController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(TShHospImportBackController.class);

	@Autowired
	private TShHospImportBackServiceI tShHospImportBackService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 提交驳回记录列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("questionbank/tShHospImportBack/tShHospImportBackList");
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
	public void datagrid(TShHospImportBackEntity tShHospImportBack,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TShHospImportBackEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShHospImportBack, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tShHospImportBackService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除提交驳回记录
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TShHospImportBackEntity tShHospImportBack, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tShHospImportBack = systemService.getEntity(TShHospImportBackEntity.class, tShHospImportBack.getId());
		message = "提交驳回记录删除成功";
		try{
			tShHospImportBackService.delete(tShHospImportBack);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "提交驳回记录删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除提交驳回记录
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "提交驳回记录删除成功";
		try{
			for(String id:ids.split(",")){
				TShHospImportBackEntity tShHospImportBack = systemService.getEntity(TShHospImportBackEntity.class, 
				id
				);
				tShHospImportBackService.delete(tShHospImportBack);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "提交驳回记录删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加提交驳回记录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TShHospImportBackEntity tShHospImportBack, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "提交驳回记录添加成功";
		try{
			tShHospImportBackService.save(tShHospImportBack);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "提交驳回记录添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新提交驳回记录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TShHospImportBackEntity tShHospImportBack, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "提交驳回记录更新成功";
		TShHospImportBackEntity t = tShHospImportBackService.get(TShHospImportBackEntity.class, tShHospImportBack.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tShHospImportBack, t);
			tShHospImportBackService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "提交驳回记录更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 提交驳回记录新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TShHospImportBackEntity tShHospImportBack, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShHospImportBack.getId())) {
			tShHospImportBack = tShHospImportBackService.getEntity(TShHospImportBackEntity.class, tShHospImportBack.getId());
			req.setAttribute("tShHospImportBackPage", tShHospImportBack);
		}
		return new ModelAndView("questionbank/tShHospImportBack/tShHospImportBack-add");
	}
	/**
	 * 提交驳回记录编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TShHospImportBackEntity tShHospImportBack, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShHospImportBack.getId())) {
			tShHospImportBack = tShHospImportBackService.getEntity(TShHospImportBackEntity.class, tShHospImportBack.getId());
			req.setAttribute("tShHospImportBackPage", tShHospImportBack);
		}
		return new ModelAndView("questionbank/tShHospImportBack/tShHospImportBack-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tShHospImportBackController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TShHospImportBackEntity tShHospImportBack,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TShHospImportBackEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShHospImportBack, request.getParameterMap());
		List<TShHospImportBackEntity> tShHospImportBacks = this.tShHospImportBackService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"提交驳回记录");
		modelMap.put(NormalExcelConstants.CLASS,TShHospImportBackEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("提交驳回记录列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tShHospImportBacks);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TShHospImportBackEntity tShHospImportBack,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"提交驳回记录");
    	modelMap.put(NormalExcelConstants.CLASS,TShHospImportBackEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("提交驳回记录列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TShHospImportBackEntity> listTShHospImportBackEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TShHospImportBackEntity.class,params);
				for (TShHospImportBackEntity tShHospImportBack : listTShHospImportBackEntitys) {
					tShHospImportBackService.save(tShHospImportBack);
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
