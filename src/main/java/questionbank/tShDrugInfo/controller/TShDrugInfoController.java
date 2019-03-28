package questionbank.tShDrugInfo.controller;
import questionbank.tShDrugInfo.entity.TShDrugInfoEntity;
import questionbank.tShDrugInfo.service.TShDrugInfoServiceI;

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
 * @Description: 药品目录维护
 * @author onlineGenerator
 * @date 2019-03-06 15:29:35
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tShDrugInfoController")
public class TShDrugInfoController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(TShDrugInfoController.class);

	@Autowired
	private TShDrugInfoServiceI tShDrugInfoService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 药品目录维护列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("questionbank/tShDrugInfo/tShDrugInfoList");
	}

	/**
	 * 药品目录维护列表 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "druglist4class")
	public ModelAndView druglist4class(HttpServletRequest request) {
		String classid = request.getParameter("classid");
		request.setAttribute("classid",classid);
		return new ModelAndView("questionbank/tShDrugInfo/druglist4class");
	}
	/**
	 * 药品类别选择树 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "treeselect")
	public ModelAndView treeselect(HttpServletRequest request) {
		String sql = "select id as 'id',pid as'pid',classname as 'name' from t_sh_drug_class ";
		String json = tShDrugInfoService.sql2json(sql);
		request.setAttribute("citynodes", json);
		return new ModelAndView("questionbank/tShDrugInfo/drugClassTreeForSelect");
	}

	/**
	 * 药品类别选择树 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "classdruglist")
	public ModelAndView classdruglist(HttpServletRequest request) {
		String sql = "select id as 'id',pid as'pid',classname as 'name' from t_sh_drug_class ";
		String json = tShDrugInfoService.sql2json(sql);
		request.setAttribute("citynodes", json);
		return new ModelAndView("questionbank/tShDrugInfo/class2drugList");
	}
	/**
	 * 获取药品类别名称 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "getClassName")
	@ResponseBody
	public String getClassName(HttpServletRequest request) {
		String sql = "select classname from t_sh_drug_class where id='"+request.getParameter("classid")+"'";
		String json = tShDrugInfoService.sql2json(sql);
		return json;
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
	public void datagrid(TShDrugInfoEntity tShDrugInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TShDrugInfoEntity.class, dataGrid);
		//查询条件组装器

		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShDrugInfo, request.getParameterMap());
		try{
		//自定义追加查询条件
			cq.eq("drugclass",tShDrugInfo.getDrugclass());
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tShDrugInfoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除药品目录维护
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TShDrugInfoEntity tShDrugInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tShDrugInfo = systemService.getEntity(TShDrugInfoEntity.class, tShDrugInfo.getId());
		message = "药品目录维护删除成功";
		try{
			tShDrugInfoService.delete(tShDrugInfo);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "药品目录维护删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除药品目录维护
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "药品目录维护删除成功";
		try{
			for(String id:ids.split(",")){
				TShDrugInfoEntity tShDrugInfo = systemService.getEntity(TShDrugInfoEntity.class, 
				id
				);
				tShDrugInfoService.delete(tShDrugInfo);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "药品目录维护删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加药品目录维护
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TShDrugInfoEntity tShDrugInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "药品目录维护添加成功";
		try{
			tShDrugInfoService.save(tShDrugInfo);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "药品目录维护添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新药品目录维护
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TShDrugInfoEntity tShDrugInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "药品目录维护更新成功";
		TShDrugInfoEntity t = tShDrugInfoService.get(TShDrugInfoEntity.class, tShDrugInfo.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tShDrugInfo, t);
			tShDrugInfoService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "药品目录维护更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 药品目录维护新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TShDrugInfoEntity tShDrugInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShDrugInfo.getId())) {
			tShDrugInfo = tShDrugInfoService.getEntity(TShDrugInfoEntity.class, tShDrugInfo.getId());
			req.setAttribute("tShDrugInfo", tShDrugInfo);
		}
		return new ModelAndView("questionbank/tShDrugInfo/tShDrugInfo-add");
	}
	/**
	 * 药品目录维护编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TShDrugInfoEntity tShDrugInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShDrugInfo.getId())) {
			tShDrugInfo = tShDrugInfoService.getEntity(TShDrugInfoEntity.class, tShDrugInfo.getId());
			req.setAttribute("tShDrugInfo", tShDrugInfo);
		}
		return new ModelAndView("questionbank/tShDrugInfo/tShDrugInfo-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tShDrugInfoController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TShDrugInfoEntity tShDrugInfo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TShDrugInfoEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShDrugInfo, request.getParameterMap());
		List<TShDrugInfoEntity> tShDrugInfos = this.tShDrugInfoService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"药品目录维护");
		modelMap.put(NormalExcelConstants.CLASS,TShDrugInfoEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("药品目录维护列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tShDrugInfos);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TShDrugInfoEntity tShDrugInfo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"药品目录维护");
    	modelMap.put(NormalExcelConstants.CLASS,TShDrugInfoEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("药品目录维护列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TShDrugInfoEntity> listTShDrugInfoEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TShDrugInfoEntity.class,params);
				for (TShDrugInfoEntity tShDrugInfo : listTShDrugInfoEntitys) {
					tShDrugInfoService.save(tShDrugInfo);
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
