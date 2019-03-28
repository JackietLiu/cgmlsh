package configtools.tSCsInfo.controller;

import configtools.tSCsInfo.entity.TSCsInfoMEntity;
import configtools.tSCsInfo.service.TSCsInfoMServiceI;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**   
 * @Title: Controller  
 * @Description: 客服人员信息
 * @author onlineGenerator
 * @date 2019-03-14 11:13:51
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tSCsInfoMController")
public class TSCsInfoMController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(TSCsInfoMController.class);

	@Autowired
	private TSCsInfoMServiceI tSCsInfoMService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 客服人员信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("configtools/tSCsInfo/tSCsInfoMList");
	}
	/**
	 * 操作列表页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "operation")
	public ModelAndView operation(HttpServletRequest request, String functionId) {
		//System.out.println("====functionId===="+functionId);
		request.setAttribute("MID", functionId);
		//String mmid=functionId;
		return new ModelAndView("configtools/tSCsInfo/tSCsInfoDList");
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
	public void datagrid(TSCsInfoMEntity tSCsInfoM,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TSCsInfoMEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tSCsInfoM, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tSCsInfoMService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除客服人员信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TSCsInfoMEntity tSCsInfoM, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tSCsInfoM = systemService.getEntity(TSCsInfoMEntity.class, tSCsInfoM.getId());
		message = "客服人员信息删除成功";
		try{
			tSCsInfoMService.delete(tSCsInfoM);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "客服人员信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除客服人员信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "客服人员信息删除成功";
		try{
			for(String id:ids.split(",")){
				TSCsInfoMEntity tSCsInfoM = systemService.getEntity(TSCsInfoMEntity.class, 
				id
				);
				tSCsInfoMService.delete(tSCsInfoM);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "客服人员信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加客服人员信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TSCsInfoMEntity tSCsInfoM, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "客服人员信息添加成功";
		try{
			tSCsInfoMService.save(tSCsInfoM);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "客服人员信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新客服人员信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TSCsInfoMEntity tSCsInfoM, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "客服人员信息更新成功";
		TSCsInfoMEntity t = tSCsInfoMService.get(TSCsInfoMEntity.class, tSCsInfoM.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tSCsInfoM, t);
			tSCsInfoMService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "客服人员信息更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 客服人员信息新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TSCsInfoMEntity tSCsInfoM, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tSCsInfoM.getId())) {
			tSCsInfoM = tSCsInfoMService.getEntity(TSCsInfoMEntity.class, tSCsInfoM.getId());
			req.setAttribute("tSCsInfoMPage", tSCsInfoM);
		}
		return new ModelAndView("configtools/tSCsInfo/tSCsInfoM-add");
	}
	/**
	 * 客服人员信息编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TSCsInfoMEntity tSCsInfoM, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tSCsInfoM.getId())) {
			tSCsInfoM = tSCsInfoMService.getEntity(TSCsInfoMEntity.class, tSCsInfoM.getId());
			req.setAttribute("tSCsInfoMPage", tSCsInfoM);
		}
		return new ModelAndView("configtools/tSCsInfo/tSCsInfoM-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tSCsInfoMController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TSCsInfoMEntity tSCsInfoM,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TSCsInfoMEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tSCsInfoM, request.getParameterMap());
		List<TSCsInfoMEntity> tSCsInfoMs = this.tSCsInfoMService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"客服人员信息");
		modelMap.put(NormalExcelConstants.CLASS,TSCsInfoMEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("客服人员信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tSCsInfoMs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TSCsInfoMEntity tSCsInfoM,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"客服人员信息");
    	modelMap.put(NormalExcelConstants.CLASS,TSCsInfoMEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("客服人员信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TSCsInfoMEntity> listTSCsInfoMEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TSCsInfoMEntity.class,params);
				for (TSCsInfoMEntity tSCsInfoM : listTSCsInfoMEntitys) {
					tSCsInfoMService.save(tSCsInfoM);
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
