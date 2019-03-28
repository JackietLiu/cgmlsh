package com.jeecg.test2.entity;

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
 * @Description: 销售工单
 * @author onlineGenerator
 * @date 2019-02-21 14:40:45
 * @version V1.0   
 *
 */
@Entity
@Table(name = "test_rules", schema = "")
@SuppressWarnings("serial")
public class TestRulesEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**流程状态*/
	private java.lang.String bpmStatus;
	/**销售人员*/
	@Excel(name="销售人员",width=15)
	private java.lang.String name;
	/**订单金额*/
	@Excel(name="订单金额",width=15)
	private java.lang.Double money;
	/**产品名字*/
	@Excel(name="产品名字",width=15)
	private java.lang.String product;
	/**下单时间*/
	@Excel(name="下单时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date saleDate;
	/**cc*/
	@Excel(name="cc",width=15)
	private java.lang.String eeee;
	/**dd*/
	@Excel(name="dd",width=15)
	private java.lang.String dda;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
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
	 *@return: java.lang.String  创建人登录名称
	 */

	@Column(name ="CREATE_BY",nullable=true,length=50)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */

	@Column(name ="CREATE_DATE",nullable=true,length=20)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */

	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */

	@Column(name ="UPDATE_DATE",nullable=true,length=20)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属部门
	 */

	@Column(name ="SYS_ORG_CODE",nullable=true,length=50)
	public java.lang.String getSysOrgCode(){
		return this.sysOrgCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属部门
	 */
	public void setSysOrgCode(java.lang.String sysOrgCode){
		this.sysOrgCode = sysOrgCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属公司
	 */

	@Column(name ="SYS_COMPANY_CODE",nullable=true,length=50)
	public java.lang.String getSysCompanyCode(){
		return this.sysCompanyCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属公司
	 */
	public void setSysCompanyCode(java.lang.String sysCompanyCode){
		this.sysCompanyCode = sysCompanyCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程状态
	 */

	@Column(name ="BPM_STATUS",nullable=true,length=32)
	public java.lang.String getBpmStatus(){
		return this.bpmStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程状态
	 */
	public void setBpmStatus(java.lang.String bpmStatus){
		this.bpmStatus = bpmStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  销售人员
	 */

	@Column(name ="NAME",nullable=true,length=32)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  销售人员
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  订单金额
	 */

	@Column(name ="MONEY",nullable=true,length=32)
	public java.lang.Double getMoney(){
		return this.money;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  订单金额
	 */
	public void setMoney(java.lang.Double money){
		this.money = money;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品名字
	 */

	@Column(name ="PRODUCT",nullable=true,length=200)
	public java.lang.String getProduct(){
		return this.product;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品名字
	 */
	public void setProduct(java.lang.String product){
		this.product = product;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  下单时间
	 */

	@Column(name ="SALE_DATE",nullable=true,length=32)
	public java.util.Date getSaleDate(){
		return this.saleDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  下单时间
	 */
	public void setSaleDate(java.util.Date saleDate){
		this.saleDate = saleDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  cc
	 */

	@Column(name ="EEEE",nullable=true,length=32)
	public java.lang.String getEeee(){
		return this.eeee;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  cc
	 */
	public void setEeee(java.lang.String eeee){
		this.eeee = eeee;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  dd
	 */

	@Column(name ="DDA",nullable=true,length=32)
	public java.lang.String getDda(){
		return this.dda;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  dd
	 */
	public void setDda(java.lang.String dda){
		this.dda = dda;
	}
}
