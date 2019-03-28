package weixin.guanjia.busionline.controller;
import weixin.guanjia.busionline.entity.TQbSliderimagesEntity;
import weixin.guanjia.busionline.service.TQbSliderimagesServiceI;

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
 * @Description: 滚动图片信息
 * @author onlineGenerator
 * @date 2018-12-15 09:57:59
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tQbSliderimagesController")
public class TQbSliderimagesController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(TQbSliderimagesController.class);

	@Autowired
	private TQbSliderimagesServiceI tQbSliderimagesService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;
	


	/**
	 * 滚动图片信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("weixin/guanjia/busionline/tQbSliderimagesList");
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
	public void datagrid(TQbSliderimagesEntity tQbSliderimages,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TQbSliderimagesEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tQbSliderimages, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tQbSliderimagesService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除滚动图片信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TQbSliderimagesEntity tQbSliderimages, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tQbSliderimages = systemService.getEntity(TQbSliderimagesEntity.class, tQbSliderimages.getId());
		message = "滚动图片信息删除成功";
		try{
			tQbSliderimagesService.delete(tQbSliderimages);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "滚动图片信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除滚动图片信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "滚动图片信息删除成功";
		try{
			for(String id:ids.split(",")){
				TQbSliderimagesEntity tQbSliderimages = systemService.getEntity(TQbSliderimagesEntity.class, 
				id
				);
				tQbSliderimagesService.delete(tQbSliderimages);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "滚动图片信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加滚动图片信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TQbSliderimagesEntity tQbSliderimages, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "滚动图片信息添加成功";
		try{
			tQbSliderimagesService.save(tQbSliderimages);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "滚动图片信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新滚动图片信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TQbSliderimagesEntity tQbSliderimages, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "滚动图片信息更新成功";
		TQbSliderimagesEntity t = tQbSliderimagesService.get(TQbSliderimagesEntity.class, tQbSliderimages.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tQbSliderimages, t);
			tQbSliderimagesService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "滚动图片信息更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 滚动图片信息新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TQbSliderimagesEntity tQbSliderimages, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tQbSliderimages.getId())) {
			tQbSliderimages = tQbSliderimagesService.getEntity(TQbSliderimagesEntity.class, tQbSliderimages.getId());
			req.setAttribute("tQbSliderimages", tQbSliderimages);
		}
		return new ModelAndView("weixin/guanjia/busionline/tQbSliderimages-add");
	}
	/**
	 * 滚动图片信息编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TQbSliderimagesEntity tQbSliderimages, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tQbSliderimages.getId())) {
			tQbSliderimages = tQbSliderimagesService.getEntity(TQbSliderimagesEntity.class, tQbSliderimages.getId());
			req.setAttribute("tQbSliderimages", tQbSliderimages);
		}
		return new ModelAndView("weixin/guanjia/busionline/tQbSliderimages-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tQbSliderimagesController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TQbSliderimagesEntity tQbSliderimages,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TQbSliderimagesEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tQbSliderimages, request.getParameterMap());
		List<TQbSliderimagesEntity> tQbSliderimagess = this.tQbSliderimagesService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"滚动图片信息");
		modelMap.put(NormalExcelConstants.CLASS,TQbSliderimagesEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("滚动图片信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tQbSliderimagess);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TQbSliderimagesEntity tQbSliderimages,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"滚动图片信息");
    	modelMap.put(NormalExcelConstants.CLASS,TQbSliderimagesEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("滚动图片信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TQbSliderimagesEntity> listTQbSliderimagesEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TQbSliderimagesEntity.class,params);
				for (TQbSliderimagesEntity tQbSliderimages : listTQbSliderimagesEntitys) {
					tQbSliderimagesService.save(tQbSliderimages);
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
	 * @param id tQbSliderimages主键id
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
