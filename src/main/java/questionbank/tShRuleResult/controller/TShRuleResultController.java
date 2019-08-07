package questionbank.tShRuleResult.controller;
import questionbank.tShRuleResult.entity.TShRuleResultEntity;
import questionbank.tShRuleResult.service.TShRuleResultServiceI;

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
 * @Description: 审核结果清单
 * @author liu
 * @date 2019-02-20 10:06:42
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tShRuleResultController")
public class TShRuleResultController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(TShRuleResultController.class);

	@Autowired
	private TShRuleResultServiceI tShRuleResultService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 审核结果清单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		String hospid="";
		if(request.getSession().getAttribute("hospid")!=null){
			hospid=(String)request.getSession().getAttribute("hospid");
		}

		request.setAttribute("hospid",hospid);

		return new ModelAndView("questionbank/tShRuleResult/tShRuleResultList");
	}
	/**
	 * 审核结果清单列表 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "ldlist")
	public ModelAndView ldlist(HttpServletRequest request) {
		return new ModelAndView("questionbank/tShRuleResult/listanddetail");
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
	public void datagrid(TShRuleResultEntity tShRuleResult,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TShRuleResultEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShRuleResult, request.getParameterMap());
		try{
			//自定义追加查询条件
			String usertype = ResourceUtil.getSessionUser().getUserType();
			if ("1".equals(usertype)){
				String hospid = (String) request.getSession().getAttribute("hospid");
				cq.eq("hospid",hospid);
			}

		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tShRuleResultService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除审核结果清单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TShRuleResultEntity tShRuleResult, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tShRuleResult = systemService.getEntity(TShRuleResultEntity.class, tShRuleResult.getId());
		message = "审核结果清单删除成功";
		try{
			tShRuleResultService.delete(tShRuleResult);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "审核结果清单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除审核结果清单
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "审核结果清单删除成功";
		try{
			for(String id:ids.split(",")){
				TShRuleResultEntity tShRuleResult = systemService.getEntity(TShRuleResultEntity.class, 
				id
				);
				tShRuleResultService.delete(tShRuleResult);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "审核结果清单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加审核结果清单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TShRuleResultEntity tShRuleResult, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "审核结果清单添加成功";
		try{
			tShRuleResultService.save(tShRuleResult);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "审核结果清单添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新审核结果清单
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TShRuleResultEntity tShRuleResult, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "审核结果清单更新成功";
		TShRuleResultEntity t = tShRuleResultService.get(TShRuleResultEntity.class, tShRuleResult.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tShRuleResult, t);
			tShRuleResultService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "审核结果清单更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 审核结果清单新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TShRuleResultEntity tShRuleResult, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShRuleResult.getId())) {
			tShRuleResult = tShRuleResultService.getEntity(TShRuleResultEntity.class, tShRuleResult.getId());
			req.setAttribute("tShRuleResult", tShRuleResult);
		}
		return new ModelAndView("questionbank/tShRuleResult/tShRuleResult-add");
	}
	/**
	 * 审核结果清单编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TShRuleResultEntity tShRuleResult, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShRuleResult.getId())) {
			tShRuleResult = tShRuleResultService.getEntity(TShRuleResultEntity.class, tShRuleResult.getId());
			req.setAttribute("tShRuleResult", tShRuleResult);
		}
		return new ModelAndView("questionbank/tShRuleResult/tShRuleResult-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tShRuleResultController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TShRuleResultEntity tShRuleResult,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TShRuleResultEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShRuleResult, request.getParameterMap());
		List<TShRuleResultEntity> tShRuleResults = this.tShRuleResultService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"审核结果清单");
		modelMap.put(NormalExcelConstants.CLASS,TShRuleResultEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("审核结果清单列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tShRuleResults);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TShRuleResultEntity tShRuleResult,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"审核结果清单");
    	modelMap.put(NormalExcelConstants.CLASS,TShRuleResultEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("审核结果清单列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TShRuleResultEntity> listTShRuleResultEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TShRuleResultEntity.class,params);
				for (TShRuleResultEntity tShRuleResult : listTShRuleResultEntitys) {
					tShRuleResultService.save(tShRuleResult);
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
