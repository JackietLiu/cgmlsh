package questionbank.tShHospImport.controller;
import org.jeecgframework.web.system.pojo.base.TSRole;
import org.jeecgframework.web.system.pojo.base.TSRoleUser;
import org.jeecgframework.web.system.pojo.base.TSUser;
import questionbank.tBaConsortiumHospital.entity.TBaConsortiumHospitalEntity;
import questionbank.tShHospDrugList.entity.TShHospDrugListEntity;
import questionbank.tShHospImport.entity.TShHospImportEntity;
import questionbank.tShHospImport.service.TShHospImportServiceI;

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
import questionbank.tShHospImportBack.entity.TShHospImportBackEntity;
import questionbank.tShNotfitruleDetail.entity.TShNotfitruleDetailEntity;
import questionbank.tShRoleRegionMatch.entity.TShRoleRegionMatchEntity;
import questionbank.tShRuleInfo.entity.TShRuleInfoEntity;
import questionbank.tShRuleResult.entity.TShRuleResultEntity;

/**   
 * @Title: Controller  
 * @Description: 医院导入列表
 * @author onlineGenerator
 * @date 2019-03-12 17:25:08
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tShHospImportController")
public class TShHospImportController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(TShHospImportController.class);

	@Autowired
	private TShHospImportServiceI tShHospImportService;
	@Autowired
	private SystemService systemService;


//zczadd begin   modify on  2019/2/28 14:03

	/**
	 *  tShHospImportController.do?func_audit
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "func_audit")
	@ResponseBody
	public AjaxJson func_audit( HttpServletRequest request) {
		String message = "审核成功!";
		AjaxJson j = new AjaxJson();
		String hospid = request.getParameter("hospid");

		String auditno = request.getParameter("auditno");
		String sql = "select * from t_sh_rule_info where id not in ( " +
				" select ruleid  from t_sh_rule_hosplevel_exclude  a join t_sh_hospital b  " +
				" on  a.hosplevel=b.hosplevel where  b.id='"+ hospid + "' and a.isactive='1' " +
				" ) and isactive='1' order by sortindex" ;
		List<TShRuleInfoEntity> listrule = tShHospImportService.findObjForJdbc(sql,TShRuleInfoEntity.class);
		//String sqlhosplevel="select hosplevel from t_sh_hospital where id='" + hospid +"'" ;
		//String thelevel=tShHospImportService.getSingleValue(sqlhosplevel);
		for (int i=0;i<listrule.size();i++){
			TShRuleInfoEntity item=listrule.get(i);
			String procsql = item.getRulesql();
			String roleid = item.getId();
			String sqlproc = "";
			if (item.getSortindex() < 500){
				sqlproc  = "{call " +procsql+"('"+hospid +"','"+roleid +"','"+auditno +"')}";
				tShHospImportService.executeProcedure(sqlproc);
			}else {
				List<TBaConsortiumHospitalEntity> chs = systemService.findByProperty(TBaConsortiumHospitalEntity.class,"hospid",hospid);
				if(chs.size() > 0){
					List<TShHospDrugListEntity> hds = systemService.findByProperty(TShHospDrugListEntity.class,"hospid",chs.get(0).getHeadhospid());
					sqlproc  = "{call " +procsql+"('"+hospid +"','"+chs.get(0).getHeadhospid() +"','"+roleid +"','"+auditno +"','"+hds.get(0).getAuditno() +"')}";
					tShHospImportService.executeProcedure(sqlproc);
				}

			}

		}
		String sql2="update t_sh_hosp_import set thestatus='20' where hospid='" +hospid+"' and auditno='" +auditno+"'"  ;
		tShHospImportService.updateBySqlString(sql2);
		return j ;
	}

	/**
	 *  tShHospImportController.do?back_submit
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "back_submit")
	@ResponseBody
	public AjaxJson back_submit( HttpServletRequest request) {
		String message = "驳回成功!";
		AjaxJson j = new AjaxJson();
		String userid = ResourceUtil.getSessionUser().getId();
		String hospid = request.getParameter("hospid");
		String auditno = request.getParameter("auditno");

		String sql2="update t_sh_hosp_import set thestatus='0' where hospid='" +hospid+"' and auditno='" +auditno+"'"  ;
		int count = tShHospImportService.updateBySqlString(sql2);
		//插入退回记录表
		if (count > 0){
			TShHospImportBackEntity ib = new TShHospImportBackEntity();
			ib.setAuditno(auditno);
			ib.setBackdate(new Date());
			ib.setHospid(hospid);
			ib.setUserid(userid);
			systemService.save(ib);
		}

		return j ;
	}
	@RequestMapping(params = "func_self_audit")
	@ResponseBody
	public AjaxJson func_self_audit( HttpServletRequest request) {
		String message = "审核成功!";
		AjaxJson j = new AjaxJson();
		String hospid = request.getParameter("hospid");
		String auditno = request.getParameter("auditno");
		String thestatus = "";
		List<TShHospImportEntity> his = systemService.findByProperty(TShHospImportEntity.class,"auditno",auditno);
		if (his.size() > 0) {
			//获取审核状态
			thestatus = his.get(0).getThestatus();
		}
		if (thestatus.equals("0")){
			String sql = "select * from t_sh_rule_info where id not in ( " +
					" select ruleid  from t_sh_rule_hosplevel_exclude  a join t_sh_hospital b  " +
					" on  a.hosplevel=b.hosplevel where  b.id='"+ hospid + "' and a.isactive='1' " +
					" ) and isactive='1' order by sortindex" ;
			List<TShRuleInfoEntity> listrule = tShHospImportService.findObjForJdbc(sql,TShRuleInfoEntity.class);
			/*清除auditno相同的结果*/
			String rrssql = "select * from t_sh_rule_result where hospid='"+hospid+"' and auditno='"+auditno+"'";
			String ndssql = "select * from t_sh_notfitrule_detail where hospid='"+hospid+"' and auditno='"+auditno+"'";
			List<TShRuleResultEntity> rrs = systemService.findObjForJdbc(rrssql,TShRuleResultEntity.class);
			List<TShNotfitruleDetailEntity> nds = systemService.findObjForJdbc(ndssql,TShNotfitruleDetailEntity.class);

			//List<TShRuleResultEntity> rrs = systemService.findByProperty(TShRuleResultEntity.class,"auditno",auditno);
			//List<TShNotfitruleDetailEntity> nds = systemService.findByProperty(TShNotfitruleDetailEntity.class,"auditno",auditno);
			if (rrs.size() > 0){
				systemService.deleteAllEntitie(rrs);
			}
			if (nds.size() > 0) {
				systemService.deleteAllEntitie(nds);
			}
			//String sqlhosplevel="select hosplevel from t_sh_hospital where id='" + hospid +"'" ;
			//String thelevel=tShHospImportService.getSingleValue(sqlhosplevel);
			for (int i=0;i<listrule.size();i++){
				TShRuleInfoEntity item=listrule.get(i);
				String procsql = item.getRulesql();
				String roleid = item.getId();
				String sqlproc = "";
				if (item.getSortindex() < 500){
					sqlproc  = "{call " +procsql+"('"+hospid +"','"+roleid +"','"+auditno +"')}";
					tShHospImportService.executeProcedure(sqlproc);
				}else {
					List<TBaConsortiumHospitalEntity> chs = systemService.findByProperty(TBaConsortiumHospitalEntity.class,"hospid",hospid);
					if(chs.size() > 0){
						List<TShHospDrugListEntity> hds = systemService.findByProperty(TShHospDrugListEntity.class,"hospid",chs.get(0).getHeadhospid());
						sqlproc  = "{call " +procsql+"('"+hospid +"','"+chs.get(0).getHeadhospid() +"','"+roleid +"','"+auditno +"','"+hds.get(0).getAuditno() +"')}";
						tShHospImportService.executeProcedure(sqlproc);
					}

				}

			}
			/*String sql2="update t_sh_hosp_import set thestatus='20' where hospid='" +hospid+"' and auditno='" +auditno+"'"  ;
			tShHospImportService.updateBySqlString(sql2);*/
		}else{
			j.setMsg("该批次目录已提交，无法再预审。");
		}


		return j ;
	}
//zczadd end modify  on  2019/2/28 14:03

	/**
	 * 医院导入列表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
        TSUser user = ResourceUtil.getSessionUser();
        List<TSRoleUser> rus = systemService.findByProperty(TSRoleUser.class,"TSUser",user);
        //获取角色和区域的关系
        List<TShRoleRegionMatchEntity> rrm = systemService.findByProperty(TShRoleRegionMatchEntity.class,"roleid",rus.get(0).getTSRole().getId());
        if (rrm.size() > 0){
            //区县管理员角色
            String regionid = rrm.get(0).getRegionid();
            request.setAttribute("regionid",regionid);
            request.setAttribute("isadmin","1");
        }else{
            if ("admin".equals(rus.get(0).getTSRole().getRoleCode())){
                //委管理员
                request.setAttribute("isadmin","0");
            }else{
                //医院用户
                request.setAttribute("isadmin","2");
            }
        }

		return new ModelAndView("questionbank/tShHospImport/tShHospImportList");
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
	public void datagrid(TShHospImportEntity tShHospImport,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TShHospImportEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShHospImport, request.getParameterMap());
		try{
		//自定义追加查询条件
            if (!tShHospImport.getRegionid().isEmpty()){
                cq.eq("regionid",tShHospImport.getRegionid());
            }

		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tShHospImportService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除医院导入列表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TShHospImportEntity tShHospImport, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tShHospImport = systemService.getEntity(TShHospImportEntity.class, tShHospImport.getId());
		message = "医院导入列表删除成功";
		try{
			tShHospImportService.delete(tShHospImport);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "医院导入列表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除医院导入列表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "医院导入列表删除成功";
		try{
			for(String id:ids.split(",")){
				TShHospImportEntity tShHospImport = systemService.getEntity(TShHospImportEntity.class, 
				id
				);
				tShHospImportService.delete(tShHospImport);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "医院导入列表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加医院导入列表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TShHospImportEntity tShHospImport, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "医院导入列表添加成功";
		try{
			tShHospImportService.save(tShHospImport);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "医院导入列表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新医院导入列表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TShHospImportEntity tShHospImport, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "医院导入列表更新成功";
		TShHospImportEntity t = tShHospImportService.get(TShHospImportEntity.class, tShHospImport.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tShHospImport, t);
			tShHospImportService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "医院导入列表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 医院导入列表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TShHospImportEntity tShHospImport, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShHospImport.getId())) {
			tShHospImport = tShHospImportService.getEntity(TShHospImportEntity.class, tShHospImport.getId());
			req.setAttribute("tShHospImport", tShHospImport);
		}
		return new ModelAndView("questionbank/tShHospImport/tShHospImport-add");
	}
	/**
	 * 医院导入列表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TShHospImportEntity tShHospImport, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShHospImport.getId())) {
			tShHospImport = tShHospImportService.getEntity(TShHospImportEntity.class, tShHospImport.getId());
			req.setAttribute("tShHospImport", tShHospImport);
		}
		return new ModelAndView("questionbank/tShHospImport/tShHospImport-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tShHospImportController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TShHospImportEntity tShHospImport,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TShHospImportEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShHospImport, request.getParameterMap());
		List<TShHospImportEntity> tShHospImports = this.tShHospImportService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"医院导入列表");
		modelMap.put(NormalExcelConstants.CLASS,TShHospImportEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("医院导入列表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tShHospImports);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TShHospImportEntity tShHospImport,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"医院导入列表");
    	modelMap.put(NormalExcelConstants.CLASS,TShHospImportEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("医院导入列表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TShHospImportEntity> listTShHospImportEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TShHospImportEntity.class,params);

				for (TShHospImportEntity tShHospImport : listTShHospImportEntitys) {
					tShHospImportService.save(tShHospImport);
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
