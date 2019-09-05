package questionbank.tShDrugClass.controller;
import org.jeecgframework.core.annotation.JAuth;
import questionbank.tShDrugClass.entity.TShDrugClassEntity;
import questionbank.tShDrugClass.service.TShDrugClassServiceI;

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
 * @Description: 药品目录
 * @author onlineGenerator
 * @date 2019-03-04 14:19:06
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tShDrugClassController")
public class TShDrugClassController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(TShDrugClassController.class);

	@Autowired
	private TShDrugClassServiceI tShDrugClassService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 药品目录列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("questionbank/tShDrugClass/tShDrugClassList");
	}

	/**
	 * 药品类别维护
	 *
	 *
	 * */
	@RequestMapping(params = "goUpdateTree")
	public ModelAndView goUpdateTree(TShDrugClassEntity tShDrugClass,HttpServletRequest request) {

		if (StringUtil.isNotEmpty(tShDrugClass.getId())) {
			tShDrugClass = tShDrugClassService.getEntity(TShDrugClassEntity.class, tShDrugClass.getId());
			request.setAttribute("tShDrugClassPage", tShDrugClass);
		}
		return new ModelAndView("questionbank/tShDrugClass/tShDrugClassTreeUpdate");
	}

	@RequestMapping(params = "tree")
	public ModelAndView tree(HttpServletRequest request) {
		String sql = "select id as 'id',pid as'pid',classname as 'name' from t_sh_drug_class ";
		String json = tShDrugClassService.sql2json(sql);
		request.setAttribute("citynodes", json);
		return new ModelAndView("questionbank/tShDrugClass/tShDrugClassTreeList");
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
	public void datagrid(TShDrugClassEntity tShDrugClass,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TShDrugClassEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShDrugClass, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tShDrugClassService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除药品目录
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TShDrugClassEntity tShDrugClass, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tShDrugClass = systemService.getEntity(TShDrugClassEntity.class, tShDrugClass.getId());
		message = "药品目录删除成功";

		try{
			tShDrugClassService.delete(tShDrugClass);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "药品目录删除失败";
			j.setSuccess(false);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除药品目录
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "药品目录删除成功";

		try{
			for(String id:ids.split(",")){
				TShDrugClassEntity tShDrugClass = systemService.getEntity(TShDrugClassEntity.class, 
				id
				);
				tShDrugClassService.delete(tShDrugClass);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "药品目录删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加药品目录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TShDrugClassEntity tShDrugClass, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "药品目录添加成功";
		j.setSuccess(true);
		try{
			tShDrugClassService.save(tShDrugClass);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "药品目录添加失败";
			j.setSuccess(false);
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新药品目录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TShDrugClassEntity tShDrugClass, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "药品目录更新成功";
		j.setSuccess(true);
		TShDrugClassEntity t = tShDrugClassService.get(TShDrugClassEntity.class, tShDrugClass.getId());
		if (t == null) j.setSuccess(false); else j.setSuccess(true);
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tShDrugClass, t);
			tShDrugClassService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
			message = "药品目录更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 药品目录新增页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "goTreeAdd")
	public ModelAndView goTreeAdd(TShDrugClassEntity tShDrugClass, HttpServletRequest req) {
		//增加同级菜单
		if (StringUtil.isNotEmpty(tShDrugClass.getId()) && "same".equals(req.getParameter("level"))){
			tShDrugClass = tShDrugClassService.getEntity(TShDrugClassEntity.class, tShDrugClass.getId());
			if (tShDrugClass.getPid() == null || "0".equals(tShDrugClass.getPid()) || "".equals(tShDrugClass.getPid())) {
				tShDrugClass.setPid("0");
			} else {
				tShDrugClass.setPid(tShDrugClass.getPid());
			}
			req.setAttribute("tShDrugClassPage", tShDrugClass);

		}else {
			//增加下级菜单
			tShDrugClass = tShDrugClassService.getEntity(TShDrugClassEntity.class, tShDrugClass.getId());
			tShDrugClass.setPid(tShDrugClass.getId());
			req.setAttribute("tShDrugClassPage", tShDrugClass);
		}
		return new ModelAndView("questionbank/tShDrugClass/tShDrugClassTreeAdd");
	}

	/**
	 * 药品目录新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TShDrugClassEntity tShDrugClass, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShDrugClass.getId())) {
			tShDrugClass = tShDrugClassService.getEntity(TShDrugClassEntity.class, tShDrugClass.getId());
			req.setAttribute("tShDrugClassPage", tShDrugClass);
		}
		return new ModelAndView("questionbank/tShDrugClass/tShDrugClass-add");
	}
	/**
	 * 药品目录编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TShDrugClassEntity tShDrugClass, HttpServletRequest req) {

		if (StringUtil.isNotEmpty(tShDrugClass.getId())) {
			tShDrugClass = tShDrugClassService.getEntity(TShDrugClassEntity.class, tShDrugClass.getId());
			req.setAttribute("tShDrugClassPage", tShDrugClass);
		}
		return new ModelAndView("questionbank/tShDrugClass/tShDrugClass-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tShDrugClassController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TShDrugClassEntity tShDrugClass,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TShDrugClassEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShDrugClass, request.getParameterMap());
		List<TShDrugClassEntity> tShDrugClasss = this.tShDrugClassService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"药品目录");
		modelMap.put(NormalExcelConstants.CLASS,TShDrugClassEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("药品目录列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tShDrugClasss);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TShDrugClassEntity tShDrugClass,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"药品目录");
    	modelMap.put(NormalExcelConstants.CLASS,TShDrugClassEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("药品目录列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TShDrugClassEntity> listTShDrugClassEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TShDrugClassEntity.class,params);
				for (TShDrugClassEntity tShDrugClass : listTShDrugClassEntitys) {
					tShDrugClassService.save(tShDrugClass);
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
