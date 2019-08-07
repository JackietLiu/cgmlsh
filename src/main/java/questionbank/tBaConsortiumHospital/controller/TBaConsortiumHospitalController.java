package questionbank.tBaConsortiumHospital.controller;
import org.jeecgframework.core.util.*;
import questionbank.tBaConsortiumHospital.entity.TBaConsortiumHospitalEntity;
import questionbank.tBaConsortiumHospital.service.TBaConsortiumHospitalServiceI;

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
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;

import java.io.OutputStream;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import questionbank.tBaMedicalConsortium.entity.TBaMedicalConsortiumEntity;

/**   
 * @Title: Controller  
 * @Description: 医联体下属医院
 * @author onlineGenerator
 * @date 2019-07-09 10:56:55
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tBaConsortiumHospitalController")
public class TBaConsortiumHospitalController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(TBaConsortiumHospitalController.class);

	@Autowired
	private TBaConsortiumHospitalServiceI tBaConsortiumHospitalService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 医联体下属医院列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		request.setAttribute("consid",request.getParameter("consid"));
		return new ModelAndView("questionbank/tBaConsortiumHospital/tBaConsortiumHospitalList");
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
	public void datagrid(TBaConsortiumHospitalEntity tBaConsortiumHospital,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TBaConsortiumHospitalEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBaConsortiumHospital, request.getParameterMap());
		try{
		//自定义追加查询条件
		cq.eq("consid",tBaConsortiumHospital.getConsid());//根据医联体的id过滤数据
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tBaConsortiumHospitalService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除医联体下属医院
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TBaConsortiumHospitalEntity tBaConsortiumHospital, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tBaConsortiumHospital = systemService.getEntity(TBaConsortiumHospitalEntity.class, tBaConsortiumHospital.getId());
		message = "医联体下属医院删除成功";
		try{
			tBaConsortiumHospitalService.delete(tBaConsortiumHospital);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "医联体下属医院删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除医联体下属医院
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "医联体下属医院删除成功";
		try{
			for(String id:ids.split(",")){
				TBaConsortiumHospitalEntity tBaConsortiumHospital = systemService.getEntity(TBaConsortiumHospitalEntity.class, 
				id
				);
				tBaConsortiumHospitalService.delete(tBaConsortiumHospital);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "医联体下属医院删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加医联体下属医院
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TBaConsortiumHospitalEntity tBaConsortiumHospital, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "医联体下属医院添加成功";
		try{
			List<TBaConsortiumHospitalEntity> chs = new ArrayList<>();
			for (String hospid : tBaConsortiumHospital.getHospid().split(",")){
				TBaConsortiumHospitalEntity ch = new TBaConsortiumHospitalEntity();
				ch.setConsid(tBaConsortiumHospital.getConsid());
				ch.setHeadhospid(tBaConsortiumHospital.getHeadhospid());
				ch.setHospid(hospid);
				chs.add(ch);
			}
			tBaConsortiumHospitalService.batchSave(chs);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "医联体下属医院添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新医联体下属医院
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TBaConsortiumHospitalEntity tBaConsortiumHospital, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "医联体下属医院更新成功";
		TBaConsortiumHospitalEntity t = tBaConsortiumHospitalService.get(TBaConsortiumHospitalEntity.class, tBaConsortiumHospital.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tBaConsortiumHospital, t);
			tBaConsortiumHospitalService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "医联体下属医院更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 医联体下属医院新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TBaConsortiumHospitalEntity tBaConsortiumHospital, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBaConsortiumHospital.getId())) {
			tBaConsortiumHospital = tBaConsortiumHospitalService.getEntity(TBaConsortiumHospitalEntity.class, tBaConsortiumHospital.getId());
			req.setAttribute("tBaConsortiumHospitalPage", tBaConsortiumHospital);
		}
		if (StringUtil.isNotEmpty(tBaConsortiumHospital.getConsid())) {
			TBaMedicalConsortiumEntity mc = systemService.get(TBaMedicalConsortiumEntity.class,tBaConsortiumHospital.getConsid());
			req.setAttribute("medicalConsortium",mc);
		}

		return new ModelAndView("questionbank/tBaConsortiumHospital/tBaConsortiumHospital-add");
	}

	/**
	 * 医院选择页
	 *
	 * @return
	 */
	@RequestMapping(params = "hospitals")
	public ModelAndView hospitals(HttpServletRequest req) {
		String ids = oConvertUtils.getString(req.getParameter("ids"));
		req.setAttribute("ids",ids);
		return new ModelAndView("questionbank/tBaConsortiumHospital/hospitals");
	}
	/**
	 * 医联体下属医院编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TBaConsortiumHospitalEntity tBaConsortiumHospital, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBaConsortiumHospital.getId())) {
			tBaConsortiumHospital = tBaConsortiumHospitalService.getEntity(TBaConsortiumHospitalEntity.class, tBaConsortiumHospital.getId());
			req.setAttribute("tBaConsortiumHospitalPage", tBaConsortiumHospital);
		}
		return new ModelAndView("questionbank/tBaConsortiumHospital/tBaConsortiumHospital-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tBaConsortiumHospitalController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TBaConsortiumHospitalEntity tBaConsortiumHospital,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TBaConsortiumHospitalEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBaConsortiumHospital, request.getParameterMap());
		List<TBaConsortiumHospitalEntity> tBaConsortiumHospitals = this.tBaConsortiumHospitalService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"医联体下属医院");
		modelMap.put(NormalExcelConstants.CLASS,TBaConsortiumHospitalEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("医联体下属医院列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tBaConsortiumHospitals);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TBaConsortiumHospitalEntity tBaConsortiumHospital,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"医联体下属医院");
    	modelMap.put(NormalExcelConstants.CLASS,TBaConsortiumHospitalEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("医联体下属医院列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TBaConsortiumHospitalEntity> listTBaConsortiumHospitalEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TBaConsortiumHospitalEntity.class,params);
				for (TBaConsortiumHospitalEntity tBaConsortiumHospital : listTBaConsortiumHospitalEntitys) {
					tBaConsortiumHospitalService.save(tBaConsortiumHospital);
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
