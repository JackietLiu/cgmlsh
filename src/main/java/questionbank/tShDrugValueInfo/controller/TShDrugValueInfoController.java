package questionbank.tShDrugValueInfo.controller;
import questionbank.tShDrugValueInfo.entity.TShDrugValueInfoEntity;
import questionbank.tShDrugValueInfo.service.TShDrugValueInfoServiceI;

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
 * @date 2019-02-26 16:39:59
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tShDrugValueInfoController")
public class TShDrugValueInfoController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(TShDrugValueInfoController.class);

	@Autowired
	private TShDrugValueInfoServiceI tShDrugValueInfoService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 一致性评价药品清单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		String currentroleids=(String)request.getSession().getAttribute("currentroleids");
		request.setAttribute("currentroleids",currentroleids);
		return new ModelAndView("questionbank/tShDrugValueInfo/tShDrugValueInfoList");
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
	public void datagrid(TShDrugValueInfoEntity tShDrugValueInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TShDrugValueInfoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShDrugValueInfo, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tShDrugValueInfoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除一致性评价药品清单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TShDrugValueInfoEntity tShDrugValueInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tShDrugValueInfo = systemService.getEntity(TShDrugValueInfoEntity.class, tShDrugValueInfo.getId());
		message = "一致性评价药品清单删除成功";
		try{
			tShDrugValueInfoService.delete(tShDrugValueInfo);
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
				TShDrugValueInfoEntity tShDrugValueInfo = systemService.getEntity(TShDrugValueInfoEntity.class, 
				id
				);
				tShDrugValueInfoService.delete(tShDrugValueInfo);
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
	public AjaxJson doAdd(TShDrugValueInfoEntity tShDrugValueInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "一致性评价药品清单添加成功";
		try{
			tShDrugValueInfoService.save(tShDrugValueInfo);
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
	public AjaxJson doUpdate(TShDrugValueInfoEntity tShDrugValueInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "一致性评价药品清单更新成功";
		TShDrugValueInfoEntity t = tShDrugValueInfoService.get(TShDrugValueInfoEntity.class, tShDrugValueInfo.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tShDrugValueInfo, t);
			tShDrugValueInfoService.saveOrUpdate(t);
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
	public ModelAndView goAdd(TShDrugValueInfoEntity tShDrugValueInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShDrugValueInfo.getId())) {
			tShDrugValueInfo = tShDrugValueInfoService.getEntity(TShDrugValueInfoEntity.class, tShDrugValueInfo.getId());
			req.setAttribute("tShDrugValueInfo", tShDrugValueInfo);
		}
		return new ModelAndView("questionbank/tShDrugValueInfo/tShDrugValueInfo-add");
	}
	/**
	 * 一致性评价药品清单编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TShDrugValueInfoEntity tShDrugValueInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShDrugValueInfo.getId())) {
			tShDrugValueInfo = tShDrugValueInfoService.getEntity(TShDrugValueInfoEntity.class, tShDrugValueInfo.getId());
			req.setAttribute("tShDrugValueInfoPage", tShDrugValueInfo);
		}
		return new ModelAndView("questionbank/tShDrugValueInfo/tShDrugValueInfo-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tShDrugValueInfoController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TShDrugValueInfoEntity tShDrugValueInfo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TShDrugValueInfoEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShDrugValueInfo, request.getParameterMap());
		List<TShDrugValueInfoEntity> tShDrugValueInfos = this.tShDrugValueInfoService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"一致性评价药品清单");
		modelMap.put(NormalExcelConstants.CLASS,TShDrugValueInfoEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("一致性评价药品清单列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tShDrugValueInfos);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TShDrugValueInfoEntity tShDrugValueInfo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"一致性评价药品清单");
    	modelMap.put(NormalExcelConstants.CLASS,TShDrugValueInfoEntity.class);
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
				List<TShDrugValueInfoEntity> listTShDrugValueInfoEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TShDrugValueInfoEntity.class,params);
				for (TShDrugValueInfoEntity tShDrugValueInfo : listTShDrugValueInfoEntitys) {
					tShDrugValueInfoService.save(tShDrugValueInfo);
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
