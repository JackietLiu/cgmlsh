package weixin.guanjia.subscribelocal.controller;
import org.jeecgframework.core.annotation.JAuth;
import org.jeecgframework.core.enums.Permission;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.entity.common.WeiXinUserList;
import weixin.guanjia.core.util.WeixinUtil;
import weixin.guanjia.subscribelocal.entity.WeixinSubscribeLocalEntity;
import weixin.guanjia.subscribelocal.entity.WeixinSubscribeLocalEntityMobel;
import weixin.guanjia.subscribelocal.service.WeixinSubscribeLocalServiceI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.utils.EmojiFilter;
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
import org.hibernate.SQLQuery;
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
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

 
import net.sf.json.JSONObject;

import org.jeecgframework.web.cgform.entity.upload.CgUploadEntity;
import org.jeecgframework.web.cgform.service.config.CgFormFieldServiceI;
import java.util.HashMap;
/**   
 * @Title: Controller  
 * @Description: weixin_subscribe_local
 * @author onlineGenerator
 * @date 2017-08-24 23:50:37
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/weixinSubscribeLocalController")
public class WeixinSubscribeLocalController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(WeixinSubscribeLocalController.class);

	@Autowired
	private WeixinSubscribeLocalServiceI weixinSubscribeLocalService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;
	
	@Autowired
	private WeixinAccountServiceI weixinAccountService;


	/**zczchanged
	 * 更新weixin_subscribe_local
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdateReal")
	@ResponseBody
	public AjaxJson doUpdateReal(WeixinSubscribeLocalEntity weixinSubscribeLocal, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "实名认证成功";
		WeixinSubscribeLocalEntity t = weixinSubscribeLocalService.get(WeixinSubscribeLocalEntity.class, weixinSubscribeLocal.getId());
		try {
			t.setRealname(weixinSubscribeLocal.getRealname());
			t.setMobile(weixinSubscribeLocal.getMobile());
			t.setIdcard(weixinSubscribeLocal.getIdcard());
			 
			t.setSex1(weixinSubscribeLocal.getSex1());
			t.setNickname2(EmojiFilter.filterEmoji(weixinSubscribeLocal.getNickname2()));
			//MyBeanUtils.copyBeanNotNull2Bean(weixinSubscribeLocal, t);
			weixinSubscribeLocalService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "实名认证成功失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**zczchanged 
	 * weixin_subscribe_local编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdateReal")
	public ModelAndView goUpdateReal(WeixinSubscribeLocalEntity weixinSubscribeLocal, HttpServletRequest req) {
		HttpSession session = req.getSession();
		String openid = req.getParameter("openid");
		if(StringUtil.isEmpty(openid)){
			openid = (String)session.getAttribute("openid");
		}
		weixinSubscribeLocal = weixinSubscribeLocalService.getEntity(WeixinSubscribeLocalEntity.class, openid);
		if(weixinSubscribeLocal.getIdcard()!="" && weixinSubscribeLocal.getIdcard()!=null){
			req.setAttribute("weixinSubscribeLocalPage", weixinSubscribeLocal);
		}
		if (StringUtil.isNotEmpty(weixinSubscribeLocal.getId())) {
			weixinSubscribeLocal = weixinSubscribeLocalService.getEntity(WeixinSubscribeLocalEntity.class, weixinSubscribeLocal.getId());
			req.setAttribute("weixinSubscribeLocalPage", weixinSubscribeLocal);
		}
		session.setAttribute("openid", openid);
		return new ModelAndView("weixin/subscribelocal/goUpdateReal");
	}

	/**chenchanged
	 * 进入个人中心mobile
	 * weixinSubscribeLocalController.do?personal
	 */
	@RequestMapping(params = "personal")
	@JAuth(auth= Permission.SKIP_AUTH)
	public ModelAndView personal(HttpServletRequest request){

		//Criteria criteria = weixinSubscribeLocalService.getSession().createCriteria(WeixinSubscribeLocalEntity.class);
		String code = request.getParameter("code");
		String id ="";
		WeixinSubscribeLocalEntityMobel submb = new WeixinSubscribeLocalEntityMobel();
		SQLQuery query;
		 int num;
		 String str;
		 HttpSession session = request.getSession();
		  
		 //if(session.getAttribute("openid") != "" && session.getAttribute("openid")!=null){
		 if(session.getAttribute("openid")!=null){
				id=(String)session.getAttribute("openid");
				System.out.println("***************************zcz  id ======" + id);
				WeixinSubscribeLocalEntity sub =weixinSubscribeLocalService.get(WeixinSubscribeLocalEntity.class, id);
				if(sub==null){
					String sql33 ="insert into weixin_subscribe_local(id) values('"+id+"')";
					weixinSubscribeLocalService.updateBySqlString(sql33);
					sub =weixinSubscribeLocalService.get(WeixinSubscribeLocalEntity.class, id);
				}
				//chenadd
				/*String sql5 = "SELECT * FROM `t_b_netvillage` where openid = '"+id+"'";
				List<TBNetvillageEntity> netv = systemService.findObjForJdbc(sql5, TBNetvillageEntity.class);
				if(netv.size()>0){
					request.setAttribute("isa", 1);
				}else{
					request.setAttribute("isa", 2);
				}*/
				//chenend
				System.out.println("***************************zcz  sub.getid ======" + sub.getId());
				String sql = "select score from t_b_score_master where openid = '"+sub.getId()+"'";
				query = systemService.getSession().createSQLQuery(sql);
				Object s =query.uniqueResult();
				if(s==null){
					str="0";
				}else{
					str=s.toString();
				}
				num=Integer.valueOf(str);
				
				if(sub==null){
					submb.setId(id);
					 submb.setIntegral(num);
				}else{
				
				submb.setId(sub.getId());
				submb.setNickname(sub.getNickname());
				submb.setSex(sub.getSex());
				submb.setCity(sub.getCity());
				submb.setProvince(sub.getProvince());
				submb.setCountry(sub.getCountry());
				submb.setHeadimgurl(sub.getHeadimgurl());
				submb.setSubscribetime(sub.getSubscribetime());
				submb.setSubscribe(sub.getSubscribe());
				submb.setLanguage(sub.getLanguage());
				submb.setUnionid(sub.getUnionid());
				submb.setRemark(sub.getRemark());
				submb.setGroupid(sub.getGroupid());
				submb.setIdcard(sub.getIdcard());
				submb.setIntegral(num);
				}
				 return new ModelAndView("weixin/mobile/personal/personal-center","sub",submb);
			}else{
					if(StringUtil.isNotEmpty(code)){
						id = WeixinUtil.getOpenidbyCode(code, ResourceUtil.getConfigByName("theappid"),ResourceUtil.getConfigByName("thesecret"));
						session.setAttribute("openid", id);
						WeixinSubscribeLocalEntity sub =weixinSubscribeLocalService.get(WeixinSubscribeLocalEntity.class, id);
						if(sub==null){
							String sql33 ="insert into weixin_subscribe_local(id) values('"+id+"')";
							weixinSubscribeLocalService.updateBySqlString(sql33);
							sub =weixinSubscribeLocalService.get(WeixinSubscribeLocalEntity.class, id);
						}
						//chenadd
						/*String sql5 = "SELECT * FROM `t_b_netvillage` where openid = '"+id+"'";
						List<TBNetvillageEntity> netv = systemService.findObjForJdbc(sql5, TBNetvillageEntity.class);
						if(netv.size()>0){
							request.setAttribute("isa", 1);
						}else{
							request.setAttribute("isa", 2);
						}*/
						//chenend
						System.out.println("***************************zcz  sub.getid22======" + sub.getId());
						String sql = "select score from t_b_score_master where openid = '"+sub.getId()+"'";
						query = systemService.getSession().createSQLQuery(sql);
						Object s =query.uniqueResult();
						if(s==null){
							str="0";
						}else{
							str=s.toString();
						}
						
						num=Integer.valueOf(str);
						if(sub==null){
							submb.setId(id);
							 submb.setIntegral(num);
						}else{
						 submb.setId(sub.getId());
						 submb.setNickname(sub.getNickname());
						 submb.setSex(sub.getSex());
						 submb.setCity(sub.getCity());
						 submb.setProvince(sub.getProvince());
						 submb.setCountry(sub.getCountry());
						 submb.setHeadimgurl(sub.getHeadimgurl());
						 submb.setSubscribetime(sub.getSubscribetime());
						 submb.setSubscribe(sub.getSubscribe());
						 submb.setLanguage(sub.getLanguage());
						 submb.setUnionid(sub.getUnionid());
						 submb.setRemark(sub.getRemark());
						 submb.setGroupid(sub.getGroupid());
						 submb.setIdcard(sub.getIdcard());
						 submb.setIntegral(num);
						}
						return new ModelAndView("weixin/subscribelocal/personal","sub",submb);
					}
			}
		return new ModelAndView("weixin/subscribelocal/personal");
		
	}
	
	/**zczchanged
	 * weixin_subscribe_local新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goReload")	 
	@ResponseBody
	public AjaxJson goReload(WeixinSubscribeLocalEntity weixinSubscribeLocal, HttpServletRequest req) {
		AjaxJson j = new AjaxJson();
		WeiXinUserList userList =new WeiXinUserList();
		List<String> openidList=new ArrayList<String>();
		String accessToken = weixinAccountService.getAccessToken();
		openidList=userList.findWeiXinUserList(openidList, accessToken, null);
		
		if(openidList==null)
		{
			j.setMsg("没有关注用户!");
			return j;
		}
		JSONObject jsonObject= new JSONObject();		
		
		 for(int i=0;i<openidList.size();i++)
		{
			String the_id=openidList.get(i);
			String url = WeixinUtil.get_the_user_url.replace("ACCESS_TOKEN",accessToken).replace("THEOPENID", the_id) ;
			jsonObject=WeixinUtil.httpRequest(url, "GET", "");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String[] params=new  String[12] ;
			Long time = null;
			String subtime =null;
			if(jsonObject.containsKey("subscribe_time") && jsonObject.getString("subscribe_time")!=null && jsonObject.getString("subscribe_time")!=""){
				time=Long.parseLong(jsonObject.getString("subscribe_time"));
				subtime = sdf.format(new Date(time*1000L));
			}
			params[0]= jsonObject.getString("openid") ;
			params[1]= EmojiFilter.filterEmoji(jsonObject.getString("nickname")) ;
			params[2]= jsonObject.getString("sex") ;
			params[3]= EmojiFilter.filterEmoji(jsonObject.getString("city")) ;
			params[4]= EmojiFilter.filterEmoji(jsonObject.getString("province")) ;
			params[5]= EmojiFilter.filterEmoji(jsonObject.getString("country") );
			params[6]= jsonObject.getString("headimgurl") ; 
			/*params[7]= jsonObject.getString("subscribe_time") ;*/
			params[7]=  subtime;
			params[8]= jsonObject.getString("subscribe") ;
			params[9]= jsonObject.getString("language") ;
			params[10]= jsonObject.getString("remark") ;
			params[11]= jsonObject.getString("groupid") ;
			String sql = "{call update_weixin_subscribe_local(?,?,?,?,?,?,?,?,?,?,?,?)}";
			weixinSubscribeLocalService.executeProcedure(sql, params);
			
		} 
		
		
		
		//the following 原先的做法
		/*for(int i=0;i<openidList.size();i++)
		{
			String the_id=openidList.get(i);
			String url = WeixinUtil.get_the_user_url.replace("ACCESS_TOKEN",accessToken).replace("THEOPENID", the_id) ;
			jsonObject=WeixinUtil.httpRequest(url, "GET", "");
			
			String sql="replace into weixin_subscribe_local (id,nickname,sex,city,province,country,headimgurl,subscribetime,subscribe,language,remark,groupid) "
					+" VALUES('" + jsonObject.getString("openid") 
					+"','"  + jsonObject.getString("nickname")
					+"','" + jsonObject.getString("sex")
					+"','" + jsonObject.getString("city")
					+"','" + jsonObject.getString("province")
					+"','" + jsonObject.getString("country")
					+"','" + jsonObject.getString("headimgurl")
					+"','" + jsonObject.getString("subscribe_time")
					+"','" + jsonObject.getString("subscribe")
					+"','" + jsonObject.getString("language")
					+"','" + jsonObject.getString("remark")
					+"','" + jsonObject.getString("groupid")
					+"')";

			weixinSubscribeLocalService.updateBySqlString(sql);
			
		}*/
		 
		
		j.setMsg("本次同步关注用户信息共" +  openidList.size() + "人." );
		return j;
		 
	}


	/**
	 * weixin_subscribe_local列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("weixin/subscribelocal/weixinSubscribeLocalList");
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
	public void datagrid(WeixinSubscribeLocalEntity weixinSubscribeLocal,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(WeixinSubscribeLocalEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, weixinSubscribeLocal, request.getParameterMap());
		try{
		//自定义追加查询条件
		String query_subscribetime_begin = request.getParameter("subscribetime_begin");
		String query_subscribetime_end = request.getParameter("subscribetime_end");
		if(StringUtil.isNotEmpty(query_subscribetime_begin)){
			cq.ge("subscribetime", Integer.parseInt(query_subscribetime_begin));
		}
		if(StringUtil.isNotEmpty(query_subscribetime_end)){
			cq.le("subscribetime", Integer.parseInt(query_subscribetime_end));
		}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.weixinSubscribeLocalService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除weixin_subscribe_local
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(WeixinSubscribeLocalEntity weixinSubscribeLocal, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		weixinSubscribeLocal = systemService.getEntity(WeixinSubscribeLocalEntity.class, weixinSubscribeLocal.getId());
		message = "weixin_subscribe_local删除成功";
		try{
			weixinSubscribeLocalService.delete(weixinSubscribeLocal);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "weixin_subscribe_local删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除weixin_subscribe_local
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "weixin_subscribe_local删除成功";
		try{
			for(String id:ids.split(",")){
				WeixinSubscribeLocalEntity weixinSubscribeLocal = systemService.getEntity(WeixinSubscribeLocalEntity.class, 
				id
				);
				weixinSubscribeLocalService.delete(weixinSubscribeLocal);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "weixin_subscribe_local删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加weixin_subscribe_local
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(WeixinSubscribeLocalEntity weixinSubscribeLocal, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "weixin_subscribe_local添加成功";
		try{
			weixinSubscribeLocalService.save(weixinSubscribeLocal);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "weixin_subscribe_local添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		j.setObj(weixinSubscribeLocal);
		return j;
	}
	
	/**
	 * 更新weixin_subscribe_local
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(WeixinSubscribeLocalEntity weixinSubscribeLocal, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "用户信息更新成功";
		WeixinSubscribeLocalEntity t = weixinSubscribeLocalService.get(WeixinSubscribeLocalEntity.class, weixinSubscribeLocal.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(weixinSubscribeLocal, t);
			weixinSubscribeLocalService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "用户信息更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * weixin_subscribe_local新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(WeixinSubscribeLocalEntity weixinSubscribeLocal, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(weixinSubscribeLocal.getId())) {
			weixinSubscribeLocal = weixinSubscribeLocalService.getEntity(WeixinSubscribeLocalEntity.class, weixinSubscribeLocal.getId());
			req.setAttribute("weixinSubscribeLocalPage", weixinSubscribeLocal);
		}
		return new ModelAndView("weixin/subscribelocal/weixinSubscribeLocal-add");
	}
	/**
	 * weixin_subscribe_local编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(WeixinSubscribeLocalEntity weixinSubscribeLocal, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(weixinSubscribeLocal.getId())) {
			weixinSubscribeLocal = weixinSubscribeLocalService.getEntity(WeixinSubscribeLocalEntity.class, weixinSubscribeLocal.getId());
			req.setAttribute("weixinSubscribeLocalPage", weixinSubscribeLocal);
		}
		return new ModelAndView("weixin/subscribelocal/weixinSubscribeLocal-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","weixinSubscribeLocalController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(WeixinSubscribeLocalEntity weixinSubscribeLocal,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(WeixinSubscribeLocalEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, weixinSubscribeLocal, request.getParameterMap());
		List<WeixinSubscribeLocalEntity> weixinSubscribeLocals = this.weixinSubscribeLocalService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"weixin_subscribe_local");
		modelMap.put(NormalExcelConstants.CLASS,WeixinSubscribeLocalEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("weixin_subscribe_local列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,weixinSubscribeLocals);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(WeixinSubscribeLocalEntity weixinSubscribeLocal,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"weixin_subscribe_local");
    	modelMap.put(NormalExcelConstants.CLASS,WeixinSubscribeLocalEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("weixin_subscribe_local列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<WeixinSubscribeLocalEntity> listWeixinSubscribeLocalEntitys = ExcelImportUtil.importExcel(file.getInputStream(),WeixinSubscribeLocalEntity.class,params);
				for (WeixinSubscribeLocalEntity weixinSubscribeLocal : listWeixinSubscribeLocalEntitys) {
					weixinSubscribeLocalService.save(weixinSubscribeLocal);
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
	 * @param id weixinSubscribeLocal主键id
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
	public List<WeixinSubscribeLocalEntity> list() {
		List<WeixinSubscribeLocalEntity> listWeixinSubscribeLocals=weixinSubscribeLocalService.getList(WeixinSubscribeLocalEntity.class);
		return listWeixinSubscribeLocals;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		WeixinSubscribeLocalEntity task = weixinSubscribeLocalService.get(WeixinSubscribeLocalEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody WeixinSubscribeLocalEntity weixinSubscribeLocal, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WeixinSubscribeLocalEntity>> failures = validator.validate(weixinSubscribeLocal);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			weixinSubscribeLocalService.save(weixinSubscribeLocal);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = weixinSubscribeLocal.getId();
		URI uri = uriBuilder.path("/rest/weixinSubscribeLocalController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody WeixinSubscribeLocalEntity weixinSubscribeLocal) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<WeixinSubscribeLocalEntity>> failures = validator.validate(weixinSubscribeLocal);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			weixinSubscribeLocalService.saveOrUpdate(weixinSubscribeLocal);
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
		weixinSubscribeLocalService.deleteEntityById(WeixinSubscribeLocalEntity.class, id);
	}
}
