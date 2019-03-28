package configtools.tSCsInfo.controller;

import configtools.tSCsInfo.entity.TSCsInfoDEntity;
import configtools.tSCsInfo.entity.TSCsInfoMEntity;
import configtools.tSCsInfo.service.TSCsInfoDServiceI;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.*;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.cgform.entity.upload.CgUploadEntity;
import org.jeecgframework.web.cgform.service.config.CgFormFieldServiceI;
import org.jeecgframework.web.system.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import questionbank.tShHospital.entity.TShHospitalModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: Controller  
 * @Description: 客服联系方式信息
 * @author onlineGenerator
 * @date 2019-03-14 11:14:12
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tSCsInfoDController")
public class TSCsInfoDController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(TSCsInfoDController.class);

	@Autowired
	private TSCsInfoDServiceI tSCsInfoDService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;
	


	/**
	 * 客服联系方式信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {


		return new ModelAndView("configtools/tSCsInfo/tSCsInfoDList");
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
	public void datagrid(TSCsInfoDEntity tSCsInfoD,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TSCsInfoDEntity.class, dataGrid);
		//查询条件组装器
        String mainId = request.getParameter("MID");
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tSCsInfoD, request.getParameterMap());
		try{
		//自定义追加查询条件
			cq.eq("mid",mainId);
           // System.out.println("===2222===="+tSCsInfoD.getMid());
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tSCsInfoDService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除客服联系方式信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TSCsInfoDEntity tSCsInfoD, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tSCsInfoD = systemService.getEntity(TSCsInfoDEntity.class, tSCsInfoD.getId());
		message = "客服联系方式信息删除成功";
		try{
			tSCsInfoDService.delete(tSCsInfoD);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "客服联系方式信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除客服联系方式信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "客服联系方式信息删除成功";
		try{
			for(String id:ids.split(",")){
				TSCsInfoDEntity tSCsInfoD = systemService.getEntity(TSCsInfoDEntity.class, 
				id
				);
				tSCsInfoDService.delete(tSCsInfoD);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "客服联系方式信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加客服联系方式信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TSCsInfoDEntity tSCsInfoD, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		//String name=request.getParameter("name");
        //String name = oConvertUtils.getString(request.getParameter("name"));
	//	message = "客服联系方式信息添加成功";
		//System.out.println("=========3333===="+request.getParameter("mid"));
		try{
			if (StringUtil.isNotEmpty(tSCsInfoD.getId())) {
				message = "客服联系方式更新成功";
				tSCsInfoDService.save(tSCsInfoD);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			} else {
				message = "客服联系方式添加成功";
				tSCsInfoDService.save(tSCsInfoD);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "客服联系方式添加失败！";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		j.setObj(tSCsInfoD);
		return j;
	}
	
	/**
	 * 更新客服联系方式信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TSCsInfoDEntity tSCsInfoD, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
	//	String name=request.getParameter("name");
		//message = "客服联系方式信息更新成功";
		message = "客服联系方式更新成功";
		TSCsInfoDEntity t = tSCsInfoDService.get(TSCsInfoDEntity.class, tSCsInfoD.getId());
		
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tSCsInfoD, t);
			tSCsInfoDService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "客服联系方式更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 客服联系方式信息新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TSCsInfoDEntity tSCsInfoD, HttpServletRequest req) {

	   // String id=tSCsInfoD.getId();
	String addmid = req.getParameter("mid");
 		req.setAttribute("addmid", addmid);
		TSCsInfoMEntity	tSCsInfoM = systemService.getEntity(TSCsInfoMEntity.class, addmid);
        req.setAttribute("tSCsInfoM", tSCsInfoM);
        String csname = tSCsInfoM.getCsname();
        req.setAttribute("csname",csname);
		if (StringUtil.isNotEmpty(tSCsInfoD.getId())) {
			  tSCsInfoD = systemService.getEntity(TSCsInfoDEntity.class,tSCsInfoD.getId() );
			req.setAttribute("tSCsInfoD", tSCsInfoD);

		}
		return new ModelAndView("configtools/tSCsInfo/tSCsInfoD-add");
	}
	/**
	 * 客服联系方式信息编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TSCsInfoDEntity tSCsInfoD, HttpServletRequest req) {
		/*if (StringUtil.isNotEmpty(tSCsInfoD.getId())) {
			tSCsInfoD = tSCsInfoDService.getEntity(TSCsInfoDEntity.class, tSCsInfoD.getId());
			req.setAttribute("tSCsInfoDPage", tSCsInfoD);
		}*/
		String addmid = req.getParameter("mid");
		req.setAttribute("addmid", addmid);
		TSCsInfoMEntity	tSCsInfoM = systemService.getEntity(TSCsInfoMEntity.class, addmid);
        req.setAttribute("tSCsInfoM", tSCsInfoM);
        String csname = tSCsInfoM.getCsname();
        req.setAttribute("csname",csname);
		if (StringUtil.isNotEmpty(tSCsInfoD.getId())) {
			tSCsInfoD = tSCsInfoDService.getEntity(TSCsInfoDEntity.class, tSCsInfoD.getId());

			if(tSCsInfoD.getMethodname().equals("1")){
                req.setAttribute("methname", "电话");
            }
            else if(tSCsInfoD.getMethodname().equals("2")){
                req.setAttribute("methname", "手机");
            }
            else if(tSCsInfoD.getMethodname().equals("3")){
                req.setAttribute("methname", "微信");
            }
           else if(tSCsInfoD.getMethodname().equals("4")){
                req.setAttribute("methname", "QQ");
            };

            req.setAttribute("tSCsInfoDPage", tSCsInfoD);

		}
		return new ModelAndView("configtools/tSCsInfo/tSCsInfoD-update");
	}
    /**
     * 客服信息
     *
     * @return
     */
    @RequestMapping(params = "techsupportinfo")
    public String techsupportinfo(HttpServletRequest request) {

        List<Map<String,List>> flist=new ArrayList<Map<String,List>>();
        String sql="select * from t_s_cs_info_m";
        List<TSCsInfoMEntity> mlist = systemService.findObjForJdbc(sql, TSCsInfoMEntity.class);
        for (TSCsInfoMEntity tSCsInfoMEntity:mlist){
            TSCsInfoDEntity d = new TSCsInfoDEntity();
            d.setMid(tSCsInfoMEntity.getId());
           // System.out.println("===mid===="+d.getMid());
            List<TSCsInfoDEntity>   dlist = systemService.findByProperty(TSCsInfoDEntity.class,"mid",d.getMid());

            Map<String,List> map = new HashMap<String, List>();
            List zb=new ArrayList();
            zb.add(tSCsInfoMEntity);
            map.put("zb", zb);
            map.put("cb",dlist);
            flist.add(map);

        }
        request.setAttribute("flist",flist);
        return "configtools/tSCsInfo/techsupportinfo";
    }
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
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tSCsInfoDController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TSCsInfoDEntity tSCsInfoD,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TSCsInfoDEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tSCsInfoD, request.getParameterMap());
		List<TSCsInfoDEntity> tSCsInfoDs = this.tSCsInfoDService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"客服联系方式信息");
		modelMap.put(NormalExcelConstants.CLASS,TSCsInfoDEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("客服联系方式信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tSCsInfoDs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TSCsInfoDEntity tSCsInfoD,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"客服联系方式信息");
    	modelMap.put(NormalExcelConstants.CLASS,TSCsInfoDEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("客服联系方式信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TSCsInfoDEntity> listTSCsInfoDEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TSCsInfoDEntity.class,params);
				for (TSCsInfoDEntity tSCsInfoD : listTSCsInfoDEntitys) {
					tSCsInfoDService.save(tSCsInfoD);
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
	 * @param id tSCsInfoD主键id
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
