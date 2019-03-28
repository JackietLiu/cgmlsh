package questionbank.tShNotfitruleDetail.controller;
import questionbank.tShHospDrugList.entity.TShHospDrugListEntity;
import questionbank.tShHospDrugList.service.TShHospDrugListServiceI;
import questionbank.tShNotfitruleDetail.entity.TShNotfitruleDetailEntity;
import questionbank.tShNotfitruleDetail.service.TShNotfitruleDetailServiceI;

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

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;

import org.jeecgframework.core.util.ExceptionUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**   
 * @Title: Controller  
 * @Description: 规则清单明细
 * @author liu
 * @date 2019-02-20 13:55:49
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tShNotfitruleDetailController")
public class TShNotfitruleDetailController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(TShNotfitruleDetailController.class);

	@Autowired
	private TShNotfitruleDetailServiceI tShNotfitruleDetailService;
	@Autowired
	private TShHospDrugListServiceI tShHospDrugListService;
	@Autowired
	private SystemService systemService;

	/**
	 * 规则清单明细列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("questionbank/tShNotfitruleDetail/tShNotfitruleDetailList");
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
	public void datagrid(TShNotfitruleDetailEntity tShNotfitruleDetail,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TShNotfitruleDetailEntity.class, dataGrid);
		if (tShNotfitruleDetail.getAuditno() == null || "".equals(tShNotfitruleDetail.getAuditno())){

		}else {
			//查询条件组装器
			org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShNotfitruleDetail, request.getParameterMap());
			try{
				//自定义追加查询条件

			}catch (Exception e) {
				throw new BusinessException(e.getMessage());
			}
			cq.add();
			this.tShNotfitruleDetailService.getDataGridReturn(cq, true);
		}

		TagUtil.datagrid(response, dataGrid);
	}
	/**
	 * 清单列表
	 *
	 * */

	@RequestMapping(params = "detailList")
	public ModelAndView detailList(HttpServletRequest request) {
		request.setAttribute("detailsql",request.getParameter("detailsql"));
		request.setAttribute("hospid",request.getParameter("hospid"));
		return new ModelAndView("questionbank/tShNotfitruleDetail/drugDetailList");
	}

	@RequestMapping(params = "detailListGrid")
	public void detailListGrid(TShHospDrugListEntity tShHospDrugList, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TShHospDrugListEntity.class, dataGrid);
		String sql = request.getParameter("detailsql");
		String hospid = request.getParameter("hospid");
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShHospDrugList, request.getParameterMap());
		try{
			//自定义追加查询条件
			List<Map<String, Object>> tShHospDrugs = systemService.findForJdbc(sql);
			dataGrid.setResults(tShHospDrugs);
			dataGrid.setTotal(tShHospDrugs.size());
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		/*cq.add();
		this.tShHospDrugListService.getDataGridReturn(cq, true);*/
		TagUtil.datagrid(response, dataGrid);
	}



	/**
	 * 删除规则清单明细
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TShNotfitruleDetailEntity tShNotfitruleDetail, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tShNotfitruleDetail = systemService.getEntity(TShNotfitruleDetailEntity.class, tShNotfitruleDetail.getId());
		message = "规则清单明细删除成功";
		try{
			tShNotfitruleDetailService.delete(tShNotfitruleDetail);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "规则清单明细删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除规则清单明细
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "规则清单明细删除成功";
		try{
			for(String id:ids.split(",")){
				TShNotfitruleDetailEntity tShNotfitruleDetail = systemService.getEntity(TShNotfitruleDetailEntity.class, 
				id
				);
				tShNotfitruleDetailService.delete(tShNotfitruleDetail);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "规则清单明细删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加规则清单明细
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TShNotfitruleDetailEntity tShNotfitruleDetail, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "规则清单明细添加成功";
		try{
			tShNotfitruleDetailService.save(tShNotfitruleDetail);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "规则清单明细添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新规则清单明细
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TShNotfitruleDetailEntity tShNotfitruleDetail, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "规则清单明细更新成功";
		TShNotfitruleDetailEntity t = tShNotfitruleDetailService.get(TShNotfitruleDetailEntity.class, tShNotfitruleDetail.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tShNotfitruleDetail, t);
			tShNotfitruleDetailService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "规则清单明细更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 规则清单明细新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TShNotfitruleDetailEntity tShNotfitruleDetail, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShNotfitruleDetail.getId())) {
			tShNotfitruleDetail = tShNotfitruleDetailService.getEntity(TShNotfitruleDetailEntity.class, tShNotfitruleDetail.getId());
			req.setAttribute("tShNotfitruleDetail", tShNotfitruleDetail);
		}
		return new ModelAndView("questionbank/tShNotfitruleDetail/tShNotfitruleDetail-add");
	}
	/**
	 * 规则清单明细编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TShNotfitruleDetailEntity tShNotfitruleDetail, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tShNotfitruleDetail.getId())) {
			tShNotfitruleDetail = tShNotfitruleDetailService.getEntity(TShNotfitruleDetailEntity.class, tShNotfitruleDetail.getId());
			req.setAttribute("tShNotfitruleDetail", tShNotfitruleDetail);
		}
		return new ModelAndView("questionbank/tShNotfitruleDetail/tShNotfitruleDetail-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tShNotfitruleDetailController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TShNotfitruleDetailEntity tShNotfitruleDetail,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TShNotfitruleDetailEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShNotfitruleDetail, request.getParameterMap());
		List<TShNotfitruleDetailEntity> tShNotfitruleDetails = this.tShNotfitruleDetailService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"规则清单明细");
		modelMap.put(NormalExcelConstants.CLASS,TShNotfitruleDetailEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("规则清单明细列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tShNotfitruleDetails);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TShNotfitruleDetailEntity tShNotfitruleDetail,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"规则清单明细");
    	modelMap.put(NormalExcelConstants.CLASS,TShNotfitruleDetailEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("规则清单明细列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TShNotfitruleDetailEntity> listTShNotfitruleDetailEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TShNotfitruleDetailEntity.class,params);
				for (TShNotfitruleDetailEntity tShNotfitruleDetail : listTShNotfitruleDetailEntitys) {

					tShNotfitruleDetailService.save(tShNotfitruleDetail);
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
