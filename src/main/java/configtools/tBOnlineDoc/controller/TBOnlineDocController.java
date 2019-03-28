package configtools.tBOnlineDoc.controller;
import configtools.tBOnlineDoc.entity.TBOnlineDocEntity;
import configtools.tBOnlineDoc.service.TBOnlineDocServiceI;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.annotation.JAuth;
import org.jeecgframework.core.enums.Permission;
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
 * @Description: 在线文档一览
 * @author onlineGenerator
 * @date 2019-03-21 12:16:53
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tBOnlineDocController")
public class TBOnlineDocController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(TBOnlineDocController.class);

	@Autowired
	private TBOnlineDocServiceI tBOnlineDocService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;
	
//zczadd begin   modify on  2019/3/21 12:33
	//tBOnlineDocController.do?displaypdf&docid=1
@RequestMapping(params = "displaypdf")
@JAuth(auth= Permission.SKIP_AUTH)
public ModelAndView displaypdf(HttpServletRequest request) {
	String docid=request.getParameter("docid");
	String sql="select docpathname from t_b_online_doc where id='"+docid+"'" ;
    String filename=tBOnlineDocService.getSingleValue(sql) ;
    request.setAttribute("filename",filename);
	return new ModelAndView("configtools/tBOnlineDoc/displaypdf");
}

//zczadd end modify  on  2019/3/21 12:33

	/**
	 * 在线文档一览列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("configtools/tBOnlineDoc/tBOnlineDocList");
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
	public void datagrid(TBOnlineDocEntity tBOnlineDoc,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TBOnlineDocEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBOnlineDoc, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tBOnlineDocService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除在线文档一览
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TBOnlineDocEntity tBOnlineDoc, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tBOnlineDoc = systemService.getEntity(TBOnlineDocEntity.class, tBOnlineDoc.getId());
		message = "在线文档一览删除成功";
		try{
			tBOnlineDocService.delete(tBOnlineDoc);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "在线文档一览删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除在线文档一览
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "在线文档一览删除成功";
		try{
			for(String id:ids.split(",")){
				TBOnlineDocEntity tBOnlineDoc = systemService.getEntity(TBOnlineDocEntity.class, 
				id
				);
				tBOnlineDocService.delete(tBOnlineDoc);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "在线文档一览删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加在线文档一览
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TBOnlineDocEntity tBOnlineDoc, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "在线文档一览添加成功";
		try{
			tBOnlineDocService.save(tBOnlineDoc);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "在线文档一览添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		j.setObj(tBOnlineDoc);
		return j;
	}
	
	/**
	 * 更新在线文档一览
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TBOnlineDocEntity tBOnlineDoc, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "在线文档一览更新成功";
		TBOnlineDocEntity t = tBOnlineDocService.get(TBOnlineDocEntity.class, tBOnlineDoc.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tBOnlineDoc, t);
			tBOnlineDocService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "在线文档一览更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 在线文档一览新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TBOnlineDocEntity tBOnlineDoc, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBOnlineDoc.getId())) {
			tBOnlineDoc = tBOnlineDocService.getEntity(TBOnlineDocEntity.class, tBOnlineDoc.getId());
			req.setAttribute("tBOnlineDocPage", tBOnlineDoc);
		}
		return new ModelAndView("configtools/tBOnlineDoc/tBOnlineDoc-add");
	}
	/**
	 * 在线文档一览编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TBOnlineDocEntity tBOnlineDoc, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBOnlineDoc.getId())) {
			tBOnlineDoc = tBOnlineDocService.getEntity(TBOnlineDocEntity.class, tBOnlineDoc.getId());
			req.setAttribute("tBOnlineDocPage", tBOnlineDoc);
		}
		return new ModelAndView("configtools/tBOnlineDoc/tBOnlineDoc-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tBOnlineDocController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TBOnlineDocEntity tBOnlineDoc,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TBOnlineDocEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBOnlineDoc, request.getParameterMap());
		List<TBOnlineDocEntity> tBOnlineDocs = this.tBOnlineDocService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"在线文档一览");
		modelMap.put(NormalExcelConstants.CLASS,TBOnlineDocEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("在线文档一览列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tBOnlineDocs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TBOnlineDocEntity tBOnlineDoc,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"在线文档一览");
    	modelMap.put(NormalExcelConstants.CLASS,TBOnlineDocEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("在线文档一览列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TBOnlineDocEntity> listTBOnlineDocEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TBOnlineDocEntity.class,params);
				for (TBOnlineDocEntity tBOnlineDoc : listTBOnlineDocEntitys) {
					tBOnlineDocService.save(tBOnlineDoc);
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
	 * @param id tBOnlineDoc主键id
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
