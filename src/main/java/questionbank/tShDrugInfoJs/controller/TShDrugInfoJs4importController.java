package questionbank.tShDrugInfoJs.controller;
import com.sun.star.util.DateTime;
import org.jeecgframework.web.system.pojo.base.TSUser;
import questionbank.tShDrugInfoJs.entity.TShDrugInfoJs4importEntity;
import questionbank.tShDrugInfoJs.service.TShDrugInfoJs4importServiceI;

import java.util.*;
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
import org.jeecgframework.core.util.ExceptionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * @Title: Controller  
 * @Description: 省导入临时表
 * @author onlineGenerator
 * @date 2019-03-20 13:15:41
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tShDrugInfoJs4importController")
public class TShDrugInfoJs4importController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(TShDrugInfoJs4importController.class);

	@Autowired
	private TShDrugInfoJs4importServiceI tShDrugInfoJs4importService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 省导入临时表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("questionbank/tShDrugInfoJs/tShDrugInfoJs4importList");
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
	public void datagrid(TShDrugInfoJs4importEntity tShDrugInfoJs4import,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TShDrugInfoJs4importEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShDrugInfoJs4import, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tShDrugInfoJs4importService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除省导入临时表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TShDrugInfoJs4importEntity tShDrugInfoJs4import, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tShDrugInfoJs4import = systemService.getEntity(TShDrugInfoJs4importEntity.class, tShDrugInfoJs4import.getId());
		message = "省导入临时表删除成功";
		try{
			tShDrugInfoJs4importService.delete(tShDrugInfoJs4import);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "省导入临时表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除省导入临时表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "省导入临时表删除成功";
		try{
			for(String id:ids.split(",")){
				TShDrugInfoJs4importEntity tShDrugInfoJs4import = systemService.getEntity(TShDrugInfoJs4importEntity.class, 
				id
				);
				tShDrugInfoJs4importService.delete(tShDrugInfoJs4import);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "省导入临时表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加省导入临时表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TShDrugInfoJs4importEntity tShDrugInfoJs4import, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "省导入临时表添加成功";
		try{
			tShDrugInfoJs4importService.save(tShDrugInfoJs4import);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "省导入临时表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新省导入临时表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TShDrugInfoJs4importEntity tShDrugInfoJs4import, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "省导入临时表更新成功";
		TShDrugInfoJs4importEntity t = tShDrugInfoJs4importService.get(TShDrugInfoJs4importEntity.class, tShDrugInfoJs4import.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tShDrugInfoJs4import, t);
			tShDrugInfoJs4importService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "省导入临时表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 省导入临时表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TShDrugInfoJs4importEntity tShDrugInfoJs4import, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShDrugInfoJs4import.getId())) {
			tShDrugInfoJs4import = tShDrugInfoJs4importService.getEntity(TShDrugInfoJs4importEntity.class, tShDrugInfoJs4import.getId());
			req.setAttribute("tShDrugInfoJs4importPage", tShDrugInfoJs4import);
		}
		return new ModelAndView("questionbank/tShDrugInfoJs/tShDrugInfoJs4import-add");
	}
	/**
	 * 省导入临时表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TShDrugInfoJs4importEntity tShDrugInfoJs4import, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShDrugInfoJs4import.getId())) {
			tShDrugInfoJs4import = tShDrugInfoJs4importService.getEntity(TShDrugInfoJs4importEntity.class, tShDrugInfoJs4import.getId());
			req.setAttribute("tShDrugInfoJs4importPage", tShDrugInfoJs4import);
		}
		return new ModelAndView("questionbank/tShDrugInfoJs/tShDrugInfoJs4import-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tShDrugInfoJs4importController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TShDrugInfoJs4importEntity tShDrugInfoJs4import,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TShDrugInfoJs4importEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShDrugInfoJs4import, request.getParameterMap());
		List<TShDrugInfoJs4importEntity> tShDrugInfoJs4imports = this.tShDrugInfoJs4importService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"省导入临时表");
		modelMap.put(NormalExcelConstants.CLASS,TShDrugInfoJs4importEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("省导入临时表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tShDrugInfoJs4imports);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TShDrugInfoJs4importEntity tShDrugInfoJs4import,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"省导入临时表");
    	modelMap.put(NormalExcelConstants.CLASS,TShDrugInfoJs4importEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("省导入临时表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TShDrugInfoJs4importEntity> listTShDrugInfoJs4importEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TShDrugInfoJs4importEntity.class,params);
				if(listTShDrugInfoJs4importEntitys.size()>0){
					String sqlproc = "{call tuncate_js_4import() }";
					tShDrugInfoJs4importService.executeProcedure(sqlproc) ;
				}
				TSUser user = ResourceUtil.getSessionUser();
				String username=user.getRealName();
				for (TShDrugInfoJs4importEntity tShDrugInfoJs4import : listTShDrugInfoJs4importEntitys) {

					tShDrugInfoJs4import.setCreateName(username);
					tShDrugInfoJs4importService.save(tShDrugInfoJs4import);
				}
				 String sqlproc_trans = "{call trans_jsimport2js() }";
				 tShDrugInfoJs4importService.executeProcedure(sqlproc_trans) ;

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
