package weixin.guanjia.busionline.controller;
import weixin.guanjia.busionline.entity.TBBusionlineInfoEntity;
import weixin.guanjia.busionline.entity.TBBusionlineItemEntity;
import weixin.guanjia.busionline.entity.TQbSliderimagesModel;
import weixin.guanjia.busionline.service.TBBusionlineInfoServiceI;
import weixin.guanjia.busionline.service.TBBusionlineItemServiceI;

import weixin.guanjia.core.util.WeixinUtil;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.utils.FastJosnUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.TreeChildCount;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.enums.Permission;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import java.util.HashMap;
import org.jeecgframework.core.util.ExceptionUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.annotation.JAuth;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

import org.jeecgframework.web.cgform.entity.upload.CgUploadEntity;
import org.jeecgframework.web.cgform.service.config.CgFormFieldServiceI;
import java.util.HashMap;
/**   
 * @Title: Controller  
 * @Description: 网上政务
 * @author onlineGenerator
 * @date 2017-08-13 19:00:01
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tBBusionlineInfoController")
public class TBBusionlineInfoController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TBBusionlineInfoController.class);

 
	@Autowired
	private TBBusionlineInfoServiceI tBBusionlineInfoService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;
	
	@Autowired
	private TBBusionlineItemServiceI tBBusionlineItemService;

	//zczadd / modify on  2018年12月18日  begin

	/**
	 * 网上政务列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "allforjob")
	@JAuth(auth=Permission.SKIP_AUTH)
	public ModelAndView allforjob(HttpServletRequest request) {
		List<TBBusionlineInfoEntity>  thelist =tBBusionlineInfoService.findObjForJdbc("select * from t_b_busionline_info where isactive='1' and groupflag='3' order by sortindex ", TBBusionlineInfoEntity.class);
		
		return new ModelAndView("weixin/guanjia/busionline/allforjob","list",thelist);
	}
	/**
	 * 网上政务列表 页面跳转
	 * zczchanged
	 * @return 
	 *    tBBusionlineInfoController.do?busiinfolistmobile
	 */
	@RequestMapping(params = "busiinfolistmobile")
	@JAuth(auth=Permission.SKIP_AUTH)
	public ModelAndView busiinfolistmobile(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("weixin/guanjia/busionline/busiinfolistmobile");
		 String code = request.getParameter("code");
		 //String groupflag= request.getParameter("groupflag");
		 String groupflag="1";
		 String title="章节练习";
		 
		 HttpSession session = request.getSession();
		 String openid = null;
		 
		 openid =null!= session.getAttribute("openid")?(String)session.getAttribute("openid"):"";
		 if(StringUtil.isEmpty(openid)){
			 if (StringUtil.isNotEmpty(code)) {
					openid = WeixinUtil.getOpenidbyCode(code, ResourceUtil.getConfigByName("theappid"),
							ResourceUtil.getConfigByName("thesecret"));
					session.setAttribute("openid", openid);
				}
		}
		session.setAttribute("title", title);
		
		List<TBBusionlineInfoEntity>  thelistkj
			=tBBusionlineInfoService.findObjForJdbc("select * from t_b_busionline_info where isactive='1' and groupflag='1' order by sortindex ", TBBusionlineInfoEntity.class);
			model.addObject("listkj",thelistkj);
		
		List<TBBusionlineInfoEntity>  thelistjj
			=tBBusionlineInfoService.findObjForJdbc("select * from t_b_busionline_info where isactive='1' and groupflag='2' order by sortindex ", TBBusionlineInfoEntity.class);
			model.addObject("listjj",thelistjj);
		
		String sql2="select id,groupname,imgurl,imgtitle,imgdesc from t_qb_sliderimages where groupname='1111' and isactive='1' order by sortindex ";
		List<TQbSliderimagesModel>  imagelist
		=tBBusionlineInfoService.findObjForJdbc(sql2, TQbSliderimagesModel.class);
		session.setAttribute("imagelist", imagelist); 
		//String j=FastJosnUtils.serializewithnull(imagelist);		
		
		if(imagelist.size()>1)
		{
			session.setAttribute("firstimage", imagelist.get(0).getImgurl());
			session.setAttribute("lastimage",  imagelist.get(imagelist.size()-1).getImgurl());
		}
		
		return model;
 	}	
	
	/**
	 * 网上政务列表下载页面跳转
	 * zczchanged
	 * @return
	 */
	@RequestMapping(params = "listdownloadmobile")
	public ModelAndView listdownloadmobile(HttpServletRequest request) {
		String id= request.getParameter("id");
		 
		TBBusionlineItemEntity  theentity =tBBusionlineItemService.findUniqueByProperty(TBBusionlineItemEntity.class, "id", id);
		return new ModelAndView("com/shanyang/busionline/listdownloadmobile","theentity",theentity);
	}
	
	 /**
	 * 网上政务列表 详细页面,手风琴格式的显示方式 
	 * zczchanged
	 * @return
	 * tBBusionlineInfoController.do?listitemmobile
	 */
	@RequestMapping(params = "listitemmobile")
	public ModelAndView listitemmobile(HttpServletRequest request) {
		String busionlineid=request.getParameter("id");
		String title=request.getParameter("title");
		request.setAttribute("title", title);
		String sql="select * from t_b_busionline_item where isactive='1'   and busionlineid='" +busionlineid +"' order by sortindex ";
		List<TBBusionlineItemEntity>  thelist=tBBusionlineItemService.findObjForJdbc(sql, TBBusionlineItemEntity.class);
		return new ModelAndView("weixin/guanjia/busionline/governmentInfo","list",thelist);
		
	}
 
	/**
	 * 备案手机页面 Mobile
	 * chen
	 * @return
	 */
	@RequestMapping(params = "recordMobile")
	public ModelAndView recordMobile(HttpServletRequest request){
		String openid = request.getParameter("openid");
		return new ModelAndView("weixin/guanjia/busionline/record");
	}
	
	
	
	//zczadd / modify  on  2018年12月18日  end
	
	
	
	
	
	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TBBusionlineInfoEntity tBBusionlineInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TBBusionlineInfoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBBusionlineInfo, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tBBusionlineInfoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除网上政务
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TBBusionlineInfoEntity tBBusionlineInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tBBusionlineInfo = systemService.getEntity(TBBusionlineInfoEntity.class, tBBusionlineInfo.getId());
		message = "网上政务删除成功";
		try{
			tBBusionlineInfoService.delete(tBBusionlineInfo);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "网上政务删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除网上政务
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "网上政务删除成功";
		try{
			for(String id:ids.split(",")){
				TBBusionlineInfoEntity tBBusionlineInfo = systemService.getEntity(TBBusionlineInfoEntity.class, 
				id
				);
				tBBusionlineInfoService.delete(tBBusionlineInfo);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "网上政务删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加网上政务
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TBBusionlineInfoEntity tBBusionlineInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "网上政务添加成功";
		try{
			tBBusionlineInfoService.save(tBBusionlineInfo);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "网上政务添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		j.setObj(tBBusionlineInfo);
		return j;
	}
	
	/**
	 * 更新网上政务
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TBBusionlineInfoEntity tBBusionlineInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "网上政务更新成功";
		TBBusionlineInfoEntity t = tBBusionlineInfoService.get(TBBusionlineInfoEntity.class, tBBusionlineInfo.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tBBusionlineInfo, t);
			tBBusionlineInfoService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "网上政务更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 网上政务新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TBBusionlineInfoEntity tBBusionlineInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBBusionlineInfo.getId())) {
			tBBusionlineInfo = tBBusionlineInfoService.getEntity(TBBusionlineInfoEntity.class, tBBusionlineInfo.getId());
			req.setAttribute("tBBusionlineInfoPage", tBBusionlineInfo);
		}
		return new ModelAndView("weixin/guanjia/busionline/tBBusionlineInfo-add");
	}
	/**
	 * 网上政务编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TBBusionlineInfoEntity tBBusionlineInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tBBusionlineInfo.getId())) {
			tBBusionlineInfo = tBBusionlineInfoService.getEntity(TBBusionlineInfoEntity.class, tBBusionlineInfo.getId());
			req.setAttribute("tBBusionlineInfoPage", tBBusionlineInfo);
		}
		return new ModelAndView("com/shanyang/busionline/tBBusionlineInfo-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tBBusionlineInfoController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TBBusionlineInfoEntity tBBusionlineInfo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TBBusionlineInfoEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBBusionlineInfo, request.getParameterMap());
		List<TBBusionlineInfoEntity> tBBusionlineInfos = this.tBBusionlineInfoService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"网上政务");
		modelMap.put(NormalExcelConstants.CLASS,TBBusionlineInfoEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("网上政务列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tBBusionlineInfos);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TBBusionlineInfoEntity tBBusionlineInfo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"网上政务");
    	modelMap.put(NormalExcelConstants.CLASS,TBBusionlineInfoEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("网上政务列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<TBBusionlineInfoEntity> listTBBusionlineInfoEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TBBusionlineInfoEntity.class,params);
				for (TBBusionlineInfoEntity tBBusionlineInfo : listTBBusionlineInfoEntitys) {
					tBBusionlineInfoService.save(tBBusionlineInfo);
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
	 * @param id tBBusionlineInfo主键id
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
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<TBBusionlineInfoEntity> list() {
		List<TBBusionlineInfoEntity> listTBBusionlineInfos=tBBusionlineInfoService.getList(TBBusionlineInfoEntity.class);
		return listTBBusionlineInfos;
	}
	
	/**
	 * 网上政务详情列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/shanyang/busionline/tBBusionlineInfoList");
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		TBBusionlineInfoEntity task = tBBusionlineInfoService.get(TBBusionlineInfoEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody TBBusionlineInfoEntity tBBusionlineInfo, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBBusionlineInfoEntity>> failures = validator.validate(tBBusionlineInfo);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			tBBusionlineInfoService.save(tBBusionlineInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = tBBusionlineInfo.getId();
		URI uri = uriBuilder.path("/rest/tBBusionlineInfoController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody TBBusionlineInfoEntity tBBusionlineInfo) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TBBusionlineInfoEntity>> failures = validator.validate(tBBusionlineInfo);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			tBBusionlineInfoService.saveOrUpdate(tBBusionlineInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		tBBusionlineInfoService.deleteEntityById(TBBusionlineInfoEntity.class, id);
	}
}
