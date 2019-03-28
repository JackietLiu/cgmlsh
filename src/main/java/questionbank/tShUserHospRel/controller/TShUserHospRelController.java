package questionbank.tShUserHospRel.controller;
import questionbank.tShUserHospRel.entity.TShUserHospRelEntity;
import questionbank.tShUserHospRel.service.TShUserHospRelServiceI;

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
 * @Description: 用户医院关联信息
 * @author onlineGenerator
 * @date 2019-02-27 09:43:33
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tShUserHospRelController")
public class TShUserHospRelController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(TShUserHospRelController.class);

	@Autowired
	private TShUserHospRelServiceI tShUserHospRelService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 用户医院关联信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("questionbank/tShUserHospRel/tShUserHospRelList");
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
	public void datagrid(TShUserHospRelEntity tShUserHospRel,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TShUserHospRelEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShUserHospRel, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tShUserHospRelService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除用户医院关联信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TShUserHospRelEntity tShUserHospRel, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tShUserHospRel = systemService.getEntity(TShUserHospRelEntity.class, tShUserHospRel.getId());
		message = "用户医院关联信息删除成功";
		try{
			tShUserHospRelService.delete(tShUserHospRel);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "用户医院关联信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除用户医院关联信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "用户医院关联信息删除成功";
		try{
			for(String id:ids.split(",")){
				TShUserHospRelEntity tShUserHospRel = systemService.getEntity(TShUserHospRelEntity.class, 
				id
				);
				tShUserHospRelService.delete(tShUserHospRel);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "用户医院关联信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加用户医院关联信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TShUserHospRelEntity tShUserHospRel, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "用户医院关联信息添加成功";
		try{
			tShUserHospRelService.save(tShUserHospRel);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "用户医院关联信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新用户医院关联信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TShUserHospRelEntity tShUserHospRel, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "用户医院关联信息更新成功";
		TShUserHospRelEntity t = tShUserHospRelService.get(TShUserHospRelEntity.class, tShUserHospRel.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tShUserHospRel, t);
			tShUserHospRelService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "用户医院关联信息更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 用户医院关联信息新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TShUserHospRelEntity tShUserHospRel, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShUserHospRel.getId())) {
			tShUserHospRel = tShUserHospRelService.getEntity(TShUserHospRelEntity.class, tShUserHospRel.getId());
			req.setAttribute("tShUserHospRel", tShUserHospRel);
		}
		System.out.println(req.getParameter("hospid"));
		req.setAttribute("hospid", req.getParameter("hospid"));
		return new ModelAndView("questionbank/tShUserHospRel/tShUserHospRel-add");
	}
	/**
	 * 用户医院关联信息编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TShUserHospRelEntity tShUserHospRel, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShUserHospRel.getId())) {
			tShUserHospRel = tShUserHospRelService.getEntity(TShUserHospRelEntity.class, tShUserHospRel.getId());
			req.setAttribute("tShUserHospRel", tShUserHospRel);
		}
		return new ModelAndView("questionbank/tShUserHospRel/tShUserHospRel-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tShUserHospRelController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TShUserHospRelEntity tShUserHospRel,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TShUserHospRelEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShUserHospRel, request.getParameterMap());
		List<TShUserHospRelEntity> tShUserHospRels = this.tShUserHospRelService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"用户医院关联信息");
		modelMap.put(NormalExcelConstants.CLASS,TShUserHospRelEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("用户医院关联信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tShUserHospRels);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TShUserHospRelEntity tShUserHospRel,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"用户医院关联信息");
    	modelMap.put(NormalExcelConstants.CLASS,TShUserHospRelEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("用户医院关联信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TShUserHospRelEntity> listTShUserHospRelEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TShUserHospRelEntity.class,params);
				for (TShUserHospRelEntity tShUserHospRel : listTShUserHospRelEntitys) {
					tShUserHospRelService.save(tShUserHospRel);
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
