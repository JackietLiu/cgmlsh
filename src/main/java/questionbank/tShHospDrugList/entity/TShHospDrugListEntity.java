package questionbank.tShHospDrugList.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

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
public class TShHospDrugListEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**采购序号*/
	@Excel(name="采购序号",width=15)
	private java.lang.String buyno;
	/**药品名称*/
	@Excel(name="药品名称",width=15)
	private java.lang.String commonname;
	/**药品规格*/
	@Excel(name="药品规格",width=15)
	private java.lang.String gg;
	/**单位*/
	@Excel(name="单位",width=15)
	private java.lang.String pcs;
	/**厂家*/
	@Excel(name="厂家",width=15)
	private java.lang.String enterprisename;
	/**剂型*/
	@Excel(name="剂型",width=15)
	private java.lang.String drugform;
	/**购进单价*/
	@Excel(name="购进单价",width=15)
	private java.lang.Double inprice;
	/**入库数量*/
	@Excel(name="入库数量",width=15)
	private java.lang.Double innum;
	/**转换比*/
	@Excel(name="转换比",width=15)
	private java.lang.Integer rationnum;
	/**更新人名称*/
	//@Excel(name="更新人名称",width=15)
	private java.lang.String updateName;
	/**更新日期*/
	//@Excel(name="更新日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date updateDate;
	/**创建日期*/
	//@Excel(name="创建日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date createDate;
	/**创建人名称*/
	//@Excel(name="创建人名称",width=15)
	private java.lang.String createName;
	/**医院ID*/
	//@Excel(name="医院编号",width=20,dictTable ="t_sh_hospital",dicCode ="id",dicText ="hospnameshort")
	@Excel(name="医院编号",width=20)
	private java.lang.String hospid;
	/**导入批号*/
	//@Excel(name="导入批号",width=20)
	private java.lang.String auditno;

	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=40)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  药品名称
	 */

	@Column(name ="COMMONNAME",nullable=true,length=100)
	public java.lang.String getCommonname(){
		return this.commonname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  药品名称
	 */
	public void setCommonname(java.lang.String commonname){
		this.commonname = commonname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  药品规格
	 */

	@Column(name ="GG",nullable=true,length=20)
	public java.lang.String getGg(){
		return this.gg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  药品规格
	 */
	public void setGg(java.lang.String gg){
		this.gg = gg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位
	 */

	@Column(name ="PCS",nullable=true,length=20)
	public java.lang.String getPcs(){
		return this.pcs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位
	 */
	public void setPcs(java.lang.String pcs){
		this.pcs = pcs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  厂家
	 */

	@Column(name ="ENTERPRISENAME",nullable=true,length=100)
	public java.lang.String getEnterprisename(){
		return this.enterprisename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  厂家
	 */
	public void setEnterprisename(java.lang.String enterprisename){
		this.enterprisename = enterprisename;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  剂型
	 */

	@Column(name ="DRUGFORM",nullable=true,length=20)
	public java.lang.String getDrugform(){
		return this.drugform;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  剂型
	 */
	public void setDrugform(java.lang.String drugform){
		this.drugform = drugform;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  购进单价
	 */

	@Column(name ="INPRICE",nullable=true,scale=2,length=10)
	public java.lang.Double getInprice(){
		return this.inprice;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  购进单价
	 */
	public void setInprice(java.lang.Double inprice){
		this.inprice = inprice;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  入库数量
	 */

	@Column(name ="INNUM",nullable=true,scale=2,length=11)
	public java.lang.Double getInnum(){
		return this.innum;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  入库数量
	 */
	public void setInnum(java.lang.Double innum){
		this.innum = innum;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  转换比
	 */

	@Column(name ="RATIONNUM",nullable=true,length=10)
	public java.lang.Integer getRationnum(){
		return this.rationnum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  转换比
	 */
	public void setRationnum(java.lang.Integer rationnum){
		this.rationnum = rationnum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */

	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */

	@Column(name ="UPDATE_DATE",nullable=true)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */

	@Column(name ="CREATE_DATE",nullable=true)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */

	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  医院ID
	 */

	@Column(name ="HOSPID",nullable=true,length=40)
	public java.lang.String getHospid(){
		return this.hospid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  医院ID
	 */
	public void setHospid(java.lang.String hospid){
		this.hospid = hospid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  导入批号
	 */

	@Column(name ="AUDITNO",nullable=true,length=20)
	public java.lang.String getAuditno(){
		return this.auditno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  导入批号
	 */
	public void setAuditno(java.lang.String auditno){
		this.auditno = auditno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购序号
	 */

	@Column(name ="BUYNO",nullable=true,length=20)
	public java.lang.String getBuyno(){
		return this.buyno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购序号
	 */
	public void setBuyno(java.lang.String buyno){
		this.buyno = buyno;
	}
}
