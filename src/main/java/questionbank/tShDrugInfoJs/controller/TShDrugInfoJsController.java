package questionbank.tShDrugInfoJs.controller;
import questionbank.tShDrugInfoJs.entity.TShDrugInfoJsEntity;
import questionbank.tShDrugInfoJs.service.TShDrugInfoJsServiceI;

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
 * @Description: 省导入药品目录
 * @author onlineGenerator
 * @date 2019-03-20 13:16:32
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tShDrugInfoJsController")
public class TShDrugInfoJsController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(TShDrugInfoJsController.class);

	@Autowired
	private TShDrugInfoJsServiceI tShDrugInfoJsService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 省导入药品目录列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("questionbank/tShDrugInfoJs/tShDrugInfoJsList");
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
	public void datagrid(TShDrugInfoJsEntity tShDrugInfoJs,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TShDrugInfoJsEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShDrugInfoJs, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tShDrugInfoJsService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除省导入药品目录
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TShDrugInfoJsEntity tShDrugInfoJs, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tShDrugInfoJs = systemService.getEntity(TShDrugInfoJsEntity.class, tShDrugInfoJs.getId());
		message = "省导入药品目录删除成功";
		try{
			tShDrugInfoJsService.delete(tShDrugInfoJs);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "省导入药品目录删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除省导入药品目录
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "省导入药品目录删除成功";
		try{
			for(String id:ids.split(",")){
				TShDrugInfoJsEntity tShDrugInfoJs = systemService.getEntity(TShDrugInfoJsEntity.class, 
				id
				);
				tShDrugInfoJsService.delete(tShDrugInfoJs);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "省导入药品目录删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加省导入药品目录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TShDrugInfoJsEntity tShDrugInfoJs, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "省导入药品目录添加成功";
		try{
			tShDrugInfoJsService.save(tShDrugInfoJs);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "省导入药品目录添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新省导入药品目录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TShDrugInfoJsEntity tShDrugInfoJs, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "省导入药品目录更新成功";
		TShDrugInfoJsEntity t = tShDrugInfoJsService.get(TShDrugInfoJsEntity.class, tShDrugInfoJs.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tShDrugInfoJs, t);
			tShDrugInfoJsService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "省导入药品目录更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 省导入药品目录新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TShDrugInfoJsEntity tShDrugInfoJs, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShDrugInfoJs.getId())) {
			tShDrugInfoJs = tShDrugInfoJsService.getEntity(TShDrugInfoJsEntity.class, tShDrugInfoJs.getId());
			req.setAttribute("tShDrugInfoJsPage", tShDrugInfoJs);
		}
		return new ModelAndView("questionbank/tShDrugInfoJs/tShDrugInfoJs-add");
	}
	/**
	 * 省导入药品目录编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TShDrugInfoJsEntity tShDrugInfoJs, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShDrugInfoJs.getId())) {
			tShDrugInfoJs = tShDrugInfoJsService.getEntity(TShDrugInfoJsEntity.class, tShDrugInfoJs.getId());
			req.setAttribute("tShDrugInfoJsPage", tShDrugInfoJs);
		}
		return new ModelAndView("questionbank/tShDrugInfoJs/tShDrugInfoJs-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tShDrugInfoJsController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TShDrugInfoJsEntity tShDrugInfoJs,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TShDrugInfoJsEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShDrugInfoJs, request.getParameterMap());
		List<TShDrugInfoJsEntity> tShDrugInfoJss = this.tShDrugInfoJsService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"省导入药品目录");
		modelMap.put(NormalExcelConstants.CLASS,TShDrugInfoJsEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("省导入药品目录列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tShDrugInfoJss);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TShDrugInfoJsEntity tShDrugInfoJs,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"省导入药品目录");
    	modelMap.put(NormalExcelConstants.CLASS,TShDrugInfoJsEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("省导入药品目录列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TShDrugInfoJsEntity> listTShDrugInfoJsEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TShDrugInfoJsEntity.class,params);
				for (TShDrugInfoJsEntity tShDrugInfoJs : listTShDrugInfoJsEntitys) {
					tShDrugInfoJsService.save(tShDrugInfoJs);
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
