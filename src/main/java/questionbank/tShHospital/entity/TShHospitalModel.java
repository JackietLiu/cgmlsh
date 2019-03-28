package questionbank.tShHospital.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 医院信息
 * @author onlineGenerator
 * @date 2019-03-05 13:30:00
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_sh_hospital", schema = "")
@SuppressWarnings("serial")
public class TShHospitalModel implements java.io.Serializable {
	
	/**代码*/
	@Excel(name="代码",width=15)
	private java.lang.String hospcode;
	/**等级*/
	@Excel(name="等级",width=15,dicCode="hosplevel")
	private java.lang.String hosplevel;
	/**医院名称*/
	@Excel(name="医院名称",width=15)
	private java.lang.String hospname;
 
	/**简称*/
	@Excel(name="简称",width=15)
	private java.lang.String hospnameshort;
	/**id*/
	private java.lang.String id;
 
	/**图标名称*/
	@Excel(name="图标名称",width=15)
	private java.lang.String logofilename;
	
	
	/**创建日期*/
	private Date createDate;
 
 
	/**医院编号*/
	@Excel(name="医院编号",width=15,dictTable ="t_sh_hospital",dicCode ="id",dicText ="hospcode")
	private String hospid;
	 
	/**状态*/
	@Excel(name="状态",width=15)
	private String thestatus;
 
	/**年份*/
	@Excel(name="年份",width=15)
	private Integer year;
	/**月份*/
	@Excel(name="月份",width=15)
	private Integer month;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地址
	 */

	
 
 
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代码
	 */

	@Column(name ="HOSPCODE",nullable=false,length=40)
	public java.lang.String getHospcode(){
		return this.hospcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代码
	 */
	public void setHospcode(java.lang.String hospcode){
		this.hospcode = hospcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  等级
	 */

	@Column(name ="HOSPLEVEL",nullable=true,length=30)
	public java.lang.String getHosplevel(){
		return this.hosplevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  等级
	 */
	public void setHosplevel(java.lang.String hosplevel){
		this.hosplevel = hosplevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  医院名称
	 */

	@Column(name ="HOSPNAME",nullable=true,length=100)
	public java.lang.String getHospname(){
		return this.hospname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  医院名称
	 */
	public void setHospname(java.lang.String hospname){
		this.hospname = hospname;
	}
 
 
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  简称
	 */

	@Column(name ="HOSPNAMESHORT",nullable=true,length=50)
	public java.lang.String getHospnameshort(){
		return this.hospnameshort;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  简称
	 */
	public void setHospnameshort(java.lang.String hospnameshort){
		this.hospnameshort = hospnameshort;
	}
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
	 *@return: java.lang.String  图标名称
	 */

	@Column(name ="LOGOFILENAME",nullable=true,length=200)
	public java.lang.String getLogofilename(){
		return this.logofilename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图标名称
	 */
	public void setLogofilename(java.lang.String logofilename){
		this.logofilename = logofilename;
	}

	
 
	@Column(name ="CREATE_DATE",nullable=true,length=20)
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
	 *@return: java.lang.String  医院编号
	 */

	@Column(name ="HOSPID",nullable=true,length=40)
	public String getHospid(){
		return this.hospid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  医院编号
	 */
	public void setHospid(String hospid){
		this.hospid = hospid;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */

	@Column(name ="THESTATUS",nullable=true,length=20)
	public String getThestatus(){
		return this.thestatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setThestatus(String thestatus){
		this.thestatus = thestatus;
	}
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  年份
	 */

	@Column(name ="YEAR",nullable=true,length=32)
	public Integer getYear(){
		return this.year;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  年份
	 */
	public void setYear(Integer year){
		this.year = year;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  月份
	 */

	@Column(name ="MONTH",nullable=true,length=32)
	public Integer getMonth(){
		return this.month;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  月份
	 */
	public void setMonth(Integer month){
		this.month = month;
	}
  
}
