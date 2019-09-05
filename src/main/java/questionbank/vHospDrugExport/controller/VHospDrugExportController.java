package questionbank.vHospDrugExport.controller;
import org.apache.commons.utils.StringUtil3;
import questionbank.vHospDrugExport.entity.VHospDrugExportEntity;
import questionbank.vHospDrugExport.service.VHospDrugExportServiceI;

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
 * @Description: 管理员导出
 * @author onlineGenerator
 * @date 2019-09-03 15:40:24
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/vHospDrugExportController")
public class VHospDrugExportController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(VHospDrugExportController.class);

	@Autowired
	private VHospDrugExportServiceI vHospDrugExportService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 管理员导出列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {


		return new ModelAndView("questionbank/vHospDrugExport/vHospDrugExportList");
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
	public void datagrid(VHospDrugExportEntity vHospDrugExport,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(VHospDrugExportEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vHospDrugExport, request.getParameterMap());
		String regionid = (String) request.getSession().getAttribute("regionid");
		String regionname = systemService.getSingleValue("select name from t_s_region where id='"+regionid+"' limit 1");

		try{
		//自定义追加查询条件
			if (StringUtil3.isNotEmpty(regionname)){
				cq.eq("name",regionname);
			}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.vHospDrugExportService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除管理员导出
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(VHospDrugExportEntity vHospDrugExport, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		vHospDrugExport = systemService.getEntity(VHospDrugExportEntity.class, vHospDrugExport.getId());
		message = "管理员导出删除成功";
		try{
			vHospDrugExportService.delete(vHospDrugExport);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "管理员导出删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除管理员导出
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "管理员导出删除成功";
		try{
			for(String id:ids.split(",")){
				VHospDrugExportEntity vHospDrugExport = systemService.getEntity(VHospDrugExportEntity.class, 
				id
				);
				vHospDrugExportService.delete(vHospDrugExport);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "管理员导出删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加管理员导出
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(VHospDrugExportEntity vHospDrugExport, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "管理员导出添加成功";
		try{
			vHospDrugExportService.save(vHospDrugExport);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "管理员导出添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新管理员导出
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(VHospDrugExportEntity vHospDrugExport, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "管理员导出更新成功";
		VHospDrugExportEntity t = vHospDrugExportService.get(VHospDrugExportEntity.class, vHospDrugExport.getId());
		try {

			MyBeanUtils.copyBeanNotNull2Bean(vHospDrugExport, t);
			vHospDrugExportService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "管理员导出更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 管理员导出新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(VHospDrugExportEntity vHospDrugExport, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vHospDrugExport.getId())) {
			vHospDrugExport = vHospDrugExportService.getEntity(VHospDrugExportEntity.class, vHospDrugExport.getId());
			req.setAttribute("vHospDrugExportPage", vHospDrugExport);
		}
		return new ModelAndView("questionbank/vHospDrugExport/vHospDrugExport-add");
	}
	/**
	 * 管理员导出编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(VHospDrugExportEntity vHospDrugExport, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(vHospDrugExport.getId())) {
			vHospDrugExport = vHospDrugExportService.getEntity(VHospDrugExportEntity.class, vHospDrugExport.getId());
			req.setAttribute("vHospDrugExportPage", vHospDrugExport);
		}
		return new ModelAndView("questionbank/vHospDrugExport/vHospDrugExport-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","vHospDrugExportController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(VHospDrugExportEntity vHospDrugExport,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(VHospDrugExportEntity.class, dataGrid);
		String regionid = (String) request.getSession().getAttribute("regionid");
		String regionname = systemService.getSingleValue("select name from t_s_region where id='"+regionid+"' limit 1");
		if (StringUtil3.isNotEmpty(regionname)){
			vHospDrugExport.setName(regionname);
		}
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, vHospDrugExport, request.getParameterMap());
		List<VHospDrugExportEntity> vHospDrugExports = this.vHospDrugExportService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"管理员导出");
		modelMap.put(NormalExcelConstants.CLASS,VHospDrugExportEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("管理员导出列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,vHospDrugExports);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(VHospDrugExportEntity vHospDrugExport,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"管理员导出");
    	modelMap.put(NormalExcelConstants.CLASS,VHospDrugExportEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("管理员导出列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<VHospDrugExportEntity> listVHospDrugExportEntitys = ExcelImportUtil.importExcel(file.getInputStream(),VHospDrugExportEntity.class,params);
				for (VHospDrugExportEntity vHospDrugExport : listVHospDrugExportEntitys) {
					vHospDrugExportService.save(vHospDrugExport);
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
