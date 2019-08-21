package questionbank.tShHospDrugList.entity;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: 医院上传药品列表
 * @author onlineGenerator
 * @date 2019-03-12 23:19:13
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_sh_hosp_drug_list", schema = "")
@SuppressWarnings("serial")
public class TShHospDrugListEntityForExport implements java.io.Serializable {
	/**id*/
	private String id;

	@Excel(name="批准文号",width=50)
	private String registerno;

	/**采购序号*/

	private String buyno;
	/**药品名称*/
	@Excel(name="药品名称",width=15)
	private String commonname;
	/**药品规格*/
	@Excel(name="药品规格",width=15)
	private String gg;
	/**单位*/
	@Excel(name="单位",width=15)
	private String pcs;
	/**厂家*/
	@Excel(name="厂家",width=15)
	private String enterprisename;
	/**剂型*/
	@Excel(name="剂型",width=15)
	private String drugform;
	/**购进单价*/
	@Excel(name="购进单价",width=15)
	private Double inprice;
	/**入库数量*/
	@Excel(name="入库数量",width=15)
	private Double innum;
	/**转换比*/
	@Excel(name="转换比",width=15)
	private Integer rationnum;
	/**更新人名称*/
	//@Excel(name="更新人名称",width=15)
	private String updateName;
	/**更新日期*/
	//@Excel(name="更新日期",width=15,format = "yyyy-MM-dd")
	private Date updateDate;
	/**创建日期*/
	//@Excel(name="创建日期",width=15,format = "yyyy-MM-dd")
	private Date createDate;
	/**创建人名称*/
	//@Excel(name="创建人名称",width=15)
	private String createName;
	/**医院ID*/
	//@Excel(name="医院编号",width=20,dictTable ="t_sh_hospital",dicCode ="id",dicText ="hospnameshort")
	//@Excel(name="医院编号",width=20)
	private String hospid;
	/**导入批号*/
	//@Excel(name="导入批号",width=20)
	private String auditno;

	@Column(name ="registerno",nullable=true,length=50)
	public String getRegisterno() {
		return registerno;
	}

	public void setRegisterno(String registerno) {
		this.registerno = registerno;
	}



	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=40)
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  药品名称
	 */

	@Column(name ="COMMONNAME",nullable=true,length=100)
	public String getCommonname(){
		return this.commonname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  药品名称
	 */
	public void setCommonname(String commonname){
		this.commonname = commonname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  药品规格
	 */

	@Column(name ="GG",nullable=true,length=20)
	public String getGg(){
		return this.gg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  药品规格
	 */
	public void setGg(String gg){
		this.gg = gg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位
	 */

	@Column(name ="PCS",nullable=true,length=20)
	public String getPcs(){
		return this.pcs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位
	 */
	public void setPcs(String pcs){
		this.pcs = pcs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  厂家
	 */

	@Column(name ="ENTERPRISENAME",nullable=true,length=100)
	public String getEnterprisename(){
		return this.enterprisename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  厂家
	 */
	public void setEnterprisename(String enterprisename){
		this.enterprisename = enterprisename;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  剂型
	 */

	@Column(name ="DRUGFORM",nullable=true,length=20)
	public String getDrugform(){
		return this.drugform;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  剂型
	 */
	public void setDrugform(String drugform){
		this.drugform = drugform;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  购进单价
	 */

	@Column(name ="INPRICE",nullable=true,scale=2,length=10)
	public Double getInprice(){
		return this.inprice;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  购进单价
	 */
	public void setInprice(Double inprice){
		this.inprice = inprice;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  入库数量
	 */

	@Column(name ="INNUM",nullable=true,scale=2,length=11)
	public Double getInnum(){
		return this.innum;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  入库数量
	 */
	public void setInnum(Double innum){
		this.innum = innum;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  转换比
	 */

	@Column(name ="RATIONNUM",nullable=true,length=10)
	public Integer getRationnum(){
		return this.rationnum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  转换比
	 */
	public void setRationnum(Integer rationnum){
		this.rationnum = rationnum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */

	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */

	@Column(name ="UPDATE_DATE",nullable=true)
	public Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */

	@Column(name ="CREATE_DATE",nullable=true)
	public Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */

	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  医院ID
	 */

	@Column(name ="HOSPID",nullable=true,length=40)
	public String getHospid(){
		return this.hospid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  医院ID
	 */
	public void setHospid(String hospid){
		this.hospid = hospid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  导入批号
	 */

	@Column(name ="AUDITNO",nullable=true,length=20)
	public String getAuditno(){
		return this.auditno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  导入批号
	 */
	public void setAuditno(String auditno){
		this.auditno = auditno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购序号
	 */

	@Column(name ="BUYNO",nullable=true,length=50)
	public String getBuyno(){
		return this.buyno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购序号
	 */
	public void setBuyno(String buyno){
		this.buyno = buyno;
	}
}
