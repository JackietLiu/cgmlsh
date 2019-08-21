package questionbank.tShHospDrugList.controller;

import org.apache.commons.utils.StringUtil3;

import org.hibernate.criterion.Restrictions;
import org.jeecgframework.core.util.ContextHolderUtils;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.system.pojo.base.TSUser;
import questionbank.tShHospDrugList.entity.TShHospDrugListEntity;
import questionbank.tShHospDrugList.entity.TShHospDrugListEntityForExport;
import questionbank.tShHospDrugList.service.TShHospDrugListServiceI;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import questionbank.tShHospDrugListHistory.service.TShHospDrugListHistoryServiceI;
import questionbank.tShHospImport.entity.TShHospImportEntity;
import questionbank.tShHospImport.service.TShHospImportServiceI;
import questionbank.tShHospital.entity.TShHospitalEntity;
import questionbank.tShNotfitruleDetail.service.TShNotfitruleDetailServiceI;

/**
 * @author onlineGenerator
 * @version V1.0
 * @Title: Controller
 * @Description: 医院上传药品列表
 * @date 2019-03-12 23:19:13
 */
@Controller
@RequestMapping("/tShHospDrugListController")
public class TShHospDrugListController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(TShHospDrugListController.class);

    @Autowired
    private TShHospDrugListServiceI tShHospDrugListService;
    @Autowired
    private SystemService systemService;

    //zczadd begin   modify on  2019/2/28 10:10
    @Autowired
    private TShHospDrugListHistoryServiceI tShHospDrugListHistoryService;
    @Autowired
    private TShHospImportServiceI tShHospImportService;
    @Autowired
    private TShNotfitruleDetailServiceI tShNotfitruleDetailService;


    @RequestMapping(params = "list_wjw")
    public ModelAndView list_wjw(HttpServletRequest request) {

        return new ModelAndView("questionbank/tShHospDrugList/tShHospDrugListList");
    }

    //tShHospDrugListController.do?func_beforeimport
    @RequestMapping(params = "func_beforeimport")
    @ResponseBody
    public AjaxJson func_beforeimport(HttpServletRequest request) {
        String message = "";
        AjaxJson j = new AjaxJson();
        HttpSession session = ContextHolderUtils.getSession();
        String hospid = (String) session.getAttribute("hospid");
        String sql = "select auditno from t_sh_hosp_import where hospid='" + hospid + "' and thestatus in ('0','10') limit 1 ";

        String theauditno = tShHospImportService.getSingleValue(sql);
        if (StringUtil3.isNotEmpty(theauditno)) {
            j.setMsg("本院有未审核的上传记录,编号为[" + theauditno + "],请确认是否继续上传,如果继续上传则未审核的记录会全部删除!");
            j.setSuccess(false);
            return j;
        }
        j.setSuccess(true);
        j.setMsg("");
        return j;
    }

    //tShHospDrugListController.do?before_commit
    @RequestMapping(params = "before_commit")
    @ResponseBody
    public AjaxJson before_commit(HttpServletRequest request) {
        //String message = "";
        AjaxJson j = new AjaxJson();
        HttpSession session = ContextHolderUtils.getSession();
        String hospid = (String) session.getAttribute("hospid");
        String sql = "select auditno from t_sh_hosp_import where hospid='" + hospid + "' and thestatus='0' limit 1";
        String theauditno = tShHospImportService.getSingleValue(sql);
        if (StringUtil3.isNotEmpty(theauditno)) {
            j.setMsg("请确认是否提交编号为[" + theauditno + "] 的上传记录!");
            j.setSuccess(true);
            return j;
        }
        j.setSuccess(false);
        j.setMsg("对不起,没有需要提交的上传记录!");
        return j;
    }

    //tShHospDrugListController.do?func_commit
    @RequestMapping(params = "func_commit")
    @ResponseBody
    public AjaxJson func_commit(HttpServletRequest request) {
        String message = "";
        AjaxJson j = new AjaxJson();
        HttpSession session = ContextHolderUtils.getSession();
        String hospid = (String) session.getAttribute("hospid");
        String sql = "select auditno from t_sh_hosp_import where hospid='" + hospid + "' and thestatus='0' limit 1";
        String theauditno = tShHospImportService.getSingleValue(sql);

        if (StringUtil3.isNotEmpty(theauditno)) {
            TSUser user = ResourceUtil.getSessionUser();
            String sql2 = "update t_sh_hosp_import set thestatus='10' ,commitname='" + user.getUserName() + "',commitdate= curdate()  " +
                    " where hospid='" + hospid + "' and auditno='" + theauditno + "' and thestatus='0'";
            tShHospImportService.updateBySqlString(sql2);
            j.setSuccess(true);
            j.setMsg("提交成功!");
            return j;
        }

        return j;
    }

    /**
     * 医院上传药品列表列表 页面跳转
     *
     * @return
     */
    @RequestMapping(params = "list")
    public ModelAndView list(HttpServletRequest request) {
        if (request.getSession().getAttribute("hospid") == null) {
            //TODO  出错提醒,重新登录
        }
        String hospid="";
        if(request.getSession().getAttribute("hospid")!=null){
            hospid=(String)request.getSession().getAttribute("hospid");
        }

        request.setAttribute("hospid",hospid);
       // String hospid = (String) request.getSession().getAttribute("hospid");
        return new ModelAndView("questionbank/tShHospDrugList/tShHospDrugListList", "hospid", hospid);
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
    public void datagrid(TShHospDrugListEntity tShHospDrugList, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        String hospid = request.getParameter("hospid");
        String thescope="0";
        if(request.getParameter("thescope")!=null){
            thescope=(String)request.getParameter("thescope") ;
        }
        CriteriaQuery cq = new CriteriaQuery(TShHospDrugListEntity.class, dataGrid);
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShHospDrugList, request.getParameterMap());
        try {
            //自定义追加查询条件

        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
       if (StringUtil3.isNotEmpty(hospid)) {
            cq.eq("hospid", hospid);
        }

        if(thescope.equalsIgnoreCase("1")){
            cq.add(Restrictions.isNull("commonname"));
            cq.add(Restrictions.isNull("gg"));

        }

        cq.add();
        this.tShHospDrugListService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }

//zczadd end modify  on  2019/2/28 10:10

    /**
     * 删除医院上传药品列表
     *
     * @return
     */
    @RequestMapping(params = "doDel")
    @ResponseBody
    public AjaxJson doDel(TShHospDrugListEntity tShHospDrugList, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        tShHospDrugList = systemService.getEntity(TShHospDrugListEntity.class, tShHospDrugList.getId());
        message = "医院上传药品列表删除成功";
        try {
            tShHospDrugListService.delete(tShHospDrugList);
            systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "医院上传药品列表删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 批量删除医院上传药品列表
     *
     * @return
     */
    @RequestMapping(params = "doBatchDel")
    @ResponseBody
    public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "医院上传药品列表删除成功";
        try {
            for (String id : ids.split(",")) {
                TShHospDrugListEntity tShHospDrugList = systemService.getEntity(TShHospDrugListEntity.class,
                        id
                );
                tShHospDrugListService.delete(tShHospDrugList);
                systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "医院上传药品列表删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }


    /**
     * 添加医院上传药品列表
     *
     * @param ids
     * @return
     */
    @RequestMapping(params = "doAdd")
    @ResponseBody
    public AjaxJson doAdd(TShHospDrugListEntity tShHospDrugList, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "医院上传药品列表添加成功";
        try {
            tShHospDrugListService.save(tShHospDrugList);
            systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "医院上传药品列表添加失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 更新医院上传药品列表
     *
     * @param ids
     * @return
     */
    @RequestMapping(params = "doUpdate")
    @ResponseBody
    public AjaxJson doUpdate(TShHospDrugListEntity tShHospDrugList, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "医院上传药品列表更新成功";
        TShHospDrugListEntity t = tShHospDrugListService.get(TShHospDrugListEntity.class, tShHospDrugList.getId());
        try {
            MyBeanUtils.copyBeanNotNull2Bean(tShHospDrugList, t);
            tShHospDrugListService.saveOrUpdate(t);
            systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "医院上传药品列表更新失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }


    /**
     * 医院上传药品列表新增页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goAdd")
    public ModelAndView goAdd(TShHospDrugListEntity tShHospDrugList, HttpServletRequest req) {
        if (StringUtil3.isNotEmpty(tShHospDrugList.getId())) {
            tShHospDrugList = tShHospDrugListService.getEntity(TShHospDrugListEntity.class, tShHospDrugList.getId());
            req.setAttribute("tShHospDrugListPage", tShHospDrugList);
        }
        if (req.getSession().getAttribute("hospid") == null) {
            //TODO  出错提醒,重新登录
        }
        String hospid = (String) req.getSession().getAttribute("hospid");
        return new ModelAndView("questionbank/tShHospDrugList/tShHospDrugList-add", "hospid", hospid);
    }

    /**
     * 医院上传药品列表编辑页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goUpdate")
    public ModelAndView goUpdate(TShHospDrugListEntity tShHospDrugList, HttpServletRequest req) {
        if (StringUtil3.isNotEmpty(tShHospDrugList.getId())) {
            tShHospDrugList = tShHospDrugListService.getEntity(TShHospDrugListEntity.class, tShHospDrugList.getId());
            req.setAttribute("tShHospDrugListPage", tShHospDrugList);
        }
        return new ModelAndView("questionbank/tShHospDrugList/tShHospDrugList-update");
    }

    /**
     * 导入功能跳转
     *
     * @return
     */
    @RequestMapping(params = "upload")
    public ModelAndView upload(HttpServletRequest req) {
        req.setAttribute("controller_name", "tShHospDrugListController");
        return new ModelAndView("common/upload/pub_excel_upload");
    }

    /**
     * 导出excel
     *
     * @param request
     * @param response
     */
    @RequestMapping(params = "exportXls")
    public String exportXls(TShHospDrugListEntity tShHospDrugList, HttpServletRequest request, HttpServletResponse response
            , DataGrid dataGrid, ModelMap modelMap) {
        CriteriaQuery cq = new CriteriaQuery(TShHospDrugListEntityForExport.class, dataGrid);
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tShHospDrugList, request.getParameterMap());
        List<TShHospDrugListEntityForExport> tShHospDrugLists = this.tShHospDrugListService.getListByCriteriaQuery(cq, false);
        modelMap.put(NormalExcelConstants.FILE_NAME, "医院上传药品列表");
        modelMap.put(NormalExcelConstants.CLASS, TShHospDrugListEntityForExport.class);
        modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("医院上传药品列表列表", "导出人:" + ResourceUtil.getSessionUser().getRealName(),
                "导出信息"));
        modelMap.put(NormalExcelConstants.DATA_LIST, tShHospDrugLists);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
    }

    /**
     * 导出excel 使模板
     *
     * @param request
     * @param response
     */
    @RequestMapping(params = "exportXlsByT")
    public String exportXlsByT(TShHospDrugListEntity tShHospDrugList, HttpServletRequest request, HttpServletResponse response
            , DataGrid dataGrid, ModelMap modelMap) {
        modelMap.put(NormalExcelConstants.FILE_NAME, "医院上传药品列表");
        modelMap.put(NormalExcelConstants.CLASS, TShHospDrugListEntity.class);
        modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("医院上传药品列表列表", "导出人:" + ResourceUtil.getSessionUser().getRealName(),
                "导出信息"));
        modelMap.put(NormalExcelConstants.DATA_LIST, new ArrayList());
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(params = "importExcel", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        AjaxJson j = new AjaxJson();

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
            MultipartFile file = entity.getValue();// 获取上传文件对象
            //导入前备份数据到历史记录表
            String hospid = (String) request.getSession().getAttribute("hospid");
            TShHospitalEntity hosp = systemService.get(TShHospitalEntity.class,hospid);
            if (hospid.equals("") || hospid == null) {
                j.setMsg("系统出现错误,请重新登陆,如果该提示还出现,请联系管理员!");
                return j;
            }
            /**
             * 开始插入t_sh_hosp_import表
             * */
            String sqlproc = "{call backtohistory('" + hospid + "')}";
            tShHospImportService.executeProcedure(sqlproc);

            String filname = file.getOriginalFilename();//获取上传文件名
            TShHospImportEntity tShHospImport = new TShHospImportEntity();
            tShHospImport.setFilename(filname);
            String sql = "select * from t_s_mysequence where SeqCode='" + hospid + "'";
            String auditno = null;
            List count = systemService.findListbySql(sql);
            if (count.size() == 0) {
                auditno = tShNotfitruleDetailService.getNextValueByName("sample");//生成流水号
            } else {
                auditno = tShNotfitruleDetailService.getNextValueByName(hospid);//生成流水号
            }

            tShHospImport.setAuditno(auditno);
            tShHospImport.setHospid(hospid);
            tShHospImport.setThestatus("0");
            tShHospImport.setThescore(0.00);
            tShHospImport.setRegionid(hosp.getRegionid());
            /**
             * 结束插入t_sh_hosp_import表
             * */
            ImportParams params = new ImportParams();
            params.setTitleRows(2);
            params.setHeadRows(1);
            params.setNeedSave(true);

            try {
                List<TShHospDrugListEntity> listTShHospDrugListEntitys = ExcelImportUtil.importExcel(file.getInputStream(), TShHospDrugListEntity.class, params);
                for (TShHospDrugListEntity tShHospDrugList : listTShHospDrugListEntitys) {
                    tShHospDrugList.setAuditno(auditno);
                    tShHospDrugList.setHospid(hospid);
                    tShHospDrugListService.save(tShHospDrugList);
                }
                j.setMsg("文件导入成功！");
            } catch (Exception e) {
                j.setMsg("文件导入失败！请重试或者联系管理员");
                logger.error(ExceptionUtil.getExceptionMessage(e));
            } finally {

                String sqlproc2 = "{call sync_hosp_drug_list_from_drug_info('" + hospid + "','" + auditno + "')}";
                tShHospImportService.executeProcedure(sqlproc2);
                tShHospImportService.save(tShHospImport);
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
