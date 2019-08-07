package questionbank.tShNotfitruleDetail.entity;

import java.util.Date;
import java.lang.String;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * @author liu
 * @version V1.0
 * @Title: Entity
 * @Description: 规则清单明细2
 * @date 2019-02-20 13:55:49
 */
@Entity
@Table(name = "t_sh_notfitrule_detail", schema = "")
@SuppressWarnings("serial")
public class TShNotfitruleDetailEntity implements java.io.Serializable {
    /**
     * 主键
     */
    private String id;
    /**
     * 创建人名称
     */
    private String createName;
    /**
     * 创建日期
     */
    private Date createDate;
    /**
     * 更新人名称
     */
    private String updateName;
    /**
     * 更新日期
     */
    private Date updateDate;
    /**
     * 医院
     */
    @Excel(name = "医院", width = 15, dictTable = "t_sh_hospital", dicCode = "id", dicText = "hospname")
    private String hospid;
    /**
     * 批号
     */
    @Excel(name = "导入批号", width = 15)
    private String auditno;
    /**
     * 规则
     */
    @Excel(name = "规则", width = 15, dictTable = "t_sh_rule_info", dicCode = "id", dicText = "rulename")
    private String ruleid;
    /**
     * 不符合说明
     */
    @Excel(name = "不符合说明", width = 15)
    private String thedesc;


    /**
     * 药品名称
     */
    @Excel(name = "药品名称", width = 15)
    private String commonname;

    /**
     * 药品规格
     */
    @Excel(name = "药品规格", width = 15)
    private String gg;
    /**
     * 剂型
     */
    @Excel(name = "剂型", width = 15)
    private String drugform;
    /**
     * 厂家
     */
    @Excel(name = "厂家", width = 15)
    private String enterprisename;
    /**
     * 查询语句
     *
     * @Excel(name="查询语句",width=15)
     */
    private String detailsql;

    @Column(name = "buyno", nullable = true, length = 50)
    public String getBuyno() {
        return buyno;
    }

    public void setBuyno(String buyno) {
        this.buyno = buyno;
    }

    @Excel(name = "采购编号", width = 15)
    private String buyno;

    @Column(name = "registerno", nullable = true, length = 100)
    public String getRegisterno() {
        return registerno;
    }

    public void setRegisterno(String registerno) {
        this.registerno = registerno;
    }

    @Excel(name = "批准文号", width = 15)
    private String registerno;

    /**
     * 备注
     */
    /*@Excel(name="备注",width=15)*/
    private String memo;

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  主键
     */
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

    @Column(name = "ID", nullable = false, length = 36)
    public String getId() {
        return this.id;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  创建人名称
     */

    @Column(name = "CREATE_NAME", nullable = true, length = 50)
    public String getCreateName() {
        return this.createName;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  创建人名称
     */
    public void setCreateName(String createName) {
        this.createName = createName;
    }

    /**
     * 方法: 取得java.util.Date
     *
     * @return: java.util.Date  创建日期
     */

    @Column(name = "CREATE_DATE", nullable = true)
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * 方法: 设置java.util.Date
     *
     * @param: java.util.Date  创建日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  更新人名称
     */

    @Column(name = "UPDATE_NAME", nullable = true, length = 50)
    public String getUpdateName() {
        return this.updateName;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  更新人名称
     */
    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    /**
     * 方法: 取得java.util.Date
     *
     * @return: java.util.Date  更新日期
     */

    @Column(name = "UPDATE_DATE", nullable = true)
    public Date getUpdateDate() {
        return this.updateDate;
    }

    /**
     * 方法: 设置java.util.Date
     *
     * @param: java.util.Date  更新日期
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  医院
     */

    @Column(name = "HOSPID", nullable = true, length = 40)
    public String getHospid() {
        return this.hospid;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  医院
     */
    public void setHospid(String hospid) {
        this.hospid = hospid;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  批号
     */

    @Column(name = "AUDITNO", nullable = true, length = 20)
    public String getAuditno() {
        return this.auditno;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  批号
     */
    public void setAuditno(String auditno) {
        this.auditno = auditno;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  规则
     */

    @Column(name = "RULEID", nullable = true, length = 40)
    public String getRuleid() {
        return this.ruleid;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  规则
     */
    public void setRuleid(String ruleid) {
        this.ruleid = ruleid;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  不符合说明
     */

    @Column(name = "THEDESC", nullable = true, length = 100)
    public String getThedesc() {
        return this.thedesc;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  不符合说明
     */
    public void setThedesc(String thedesc) {
        this.thedesc = thedesc;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  备注
     */

    @Column(name = "MEMO", nullable = true, length = 100)
    public String getMemo() {
        return this.memo;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  备注
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  剂型
     */

    @Column(name = "DRUGFORM", nullable = true, length = 20)
    public String getDrugform() {
        return this.drugform;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  剂型
     */
    public void setDrugform(String drugform) {
        this.drugform = drugform;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  药品规格
     */

    @Column(name = "GG", nullable = true, length = 20)
    public String getGg() {
        return this.gg;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  药品规格
     */
    public void setGg(String gg) {
        this.gg = gg;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  药品名称
     */

    @Column(name = "COMMONNAME", nullable = true, length = 100)
    public String getCommonname() {
        return this.commonname;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  药品名称
     */
    public void setCommonname(String commonname) {
        this.commonname = commonname;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  厂家
     */

    @Column(name = "ENTERPRISENAME", nullable = true, length = 32)
    public String getEnterprisename() {
        return this.enterprisename;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  厂家
     */
    public void setEnterprisename(String enterprisename) {
        this.enterprisename = enterprisename;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  查询语句
     */

    @Column(name = "DETAILSQL", nullable = true, length = 500)
    public String getDetailsql() {
        return this.detailsql;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  查询语句
     */
    public void setDetailsql(String detailsql) {
        this.detailsql = detailsql;
    }

}