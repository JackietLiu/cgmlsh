package questionbank.tShHospital.controller;
import questionbank.tShHospital.entity.TShHospitalEntity;
import questionbank.tShHospital.entity.TShHospitalModel;
import questionbank.tShHospital.service.TShHospitalServiceI;

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

import org.jeecgframework.web.cgform.entity.upload.CgUploadEntity;
import org.jeecgframework.web.cgform.service.config.CgFormFieldServiceI;
import java.util.HashMap;
/**   
 * @Title: Controller  
 * @Description: 医院信息
 * @author onlineGenerator
 * @date 2019-03-05 13:30:00
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tShHospitalController")
public class TShHospitalController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(TShHospitalController.class);

	@Autowired
	private TShHospitalServiceI tShHospitalService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;


	/**
	 * 医院信息列表 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "infolist")
	public ModelAndView infolist(HttpServletRequest request) {

		List<TShHospitalModel> reModelist = new ArrayList<TShHospitalModel>();
		//List<Map<String,Object>> modelList = new ArrayList<Map<String,Object>>();
		String sql = "select a.hospname,a.id,a.hosplevel,a.logofilename,b.thestatus,b.hospid,(CASE WHEN hospid is null THEN '未上传' "
				+" ELSE '已上传' END)as ifupdate from t_sh_hospital a left join (select hospid ,thestatus,create_date from t_sh_hosp_import t "
				+" where (t.hospid,t.create_date) in (select hospid,max(create_date) from t_sh_hosp_import group by hospid) ) b on a.id=b.hospid ";
		List<TShHospitalModel> modelList = systemService.findObjForJdbc(sql, TShHospitalModel.class);

		for (TShHospitalModel list : modelList) {
			String logopath =list.getLogofilename().substring(1, list.getLogofilename().length());
			//System.out.print(logopath);
			list.setLogofilename(logopath);
			if(list.getHospid()==null){
				list.setHospid("");
			}
			System.out.print(list.getLogofilename());
			System.out.println(list.getHospid());
		}
		request.setAttribute("infolist", modelList);
		System.out.println(modelList.get(0).getHospid());

		return new ModelAndView("questionbank/tShHospital/infolist");
	}
	/**
	 * 医院信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("questionbank/tShHospital/tShHospitalList");
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
	public void datagrid(TShHospitalEntity tShHospital,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TShHospitalEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShHospital, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tShHospitalService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除医院信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TShHospitalEntity tShHospital, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tShHospital = systemService.getEntity(TShHospitalEntity.class, tShHospital.getId());
		message = "医院信息删除成功";
		try{
			tShHospitalService.delete(tShHospital);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "医院信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除医院信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "医院信息删除成功";
		try{
			for(String id:ids.split(",")){
				TShHospitalEntity tShHospital = systemService.getEntity(TShHospitalEntity.class, 
				id
				);
				tShHospitalService.delete(tShHospital);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "医院信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加医院信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TShHospitalEntity tShHospital, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "医院信息添加成功";
		try{
			tShHospitalService.save(tShHospital);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "医院信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		j.setObj(tShHospital);
		return j;
	}
	
	/**
	 * 更新医院信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TShHospitalEntity tShHospital, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "医院信息更新成功";
		TShHospitalEntity t = tShHospitalService.get(TShHospitalEntity.class, tShHospital.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tShHospital, t);
			tShHospitalService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "医院信息更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 医院信息新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TShHospitalEntity tShHospital, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShHospital.getId())) {
			tShHospital = tShHospitalService.getEntity(TShHospitalEntity.class, tShHospital.getId());
			req.setAttribute("tShHospitalPage", tShHospital);
		}
		return new ModelAndView("questionbank/tShHospital/tShHospital-add");
	}
	/**
	 * 医院信息编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TShHospitalEntity tShHospital, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShHospital.getId())) {
			tShHospital = tShHospitalService.getEntity(TShHospitalEntity.class, tShHospital.getId());
			req.setAttribute("tShHospitalPage", tShHospital);
		}
		return new ModelAndView("questionbank/tShHospital/tShHospital-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tShHospitalController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TShHospitalEntity tShHospital,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TShHospitalEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShHospital, request.getParameterMap());
		List<TShHospitalEntity> tShHospitals = this.tShHospitalService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"医院信息");
		modelMap.put(NormalExcelConstants.CLASS,TShHospitalEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("医院信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tShHospitals);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TShHospitalEntity tShHospital,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"医院信息");
    	modelMap.put(NormalExcelConstants.CLASS,TShHospitalEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("医院信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TShHospitalEntity> listTShHospitalEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TShHospitalEntity.class,params);
				for (TShHospitalEntity tShHospital : listTShHospitalEntitys) {
					tShHospitalService.save(tShHospital);
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
	
	/**
	 * 获取文件附件信息
	 * 
	 * @param id tShHospital主键id
	 */
	@RequestMapping(params = "getFiles")
	@ResponseBody
	public AjaxJson getFiles(String id){
		List<CgUploadEntity> uploadBeans = cgFormFieldService.findByProperty(CgUploadEntity.class, "cgformId", id);
		List<Map<String,Object>> files = new ArrayList<Map<String,Object>>(0);
		for(CgUploadEntity b:uploadBeans){
			String title = b.getAttachmenttitle();//附件名
			String fileKey = b.getId();//附件主键
			String path = b.getRealpath();//附件路径
			String field = b.getCgformField();//表单中作为附件控件的字段
			Map<String, Object> file = new HashMap<String, Object>();
			file.put("title", title);
			file.put("fileKey", fileKey);
			file.put("path", path);
			file.put("field", field==null?"":field);
			files.add(file);
		}
		AjaxJson j = new AjaxJson();
		j.setObj(files);
		return j;
	}
	
}
