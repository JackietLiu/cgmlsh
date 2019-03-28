package configtools.tSCsInfo.entity;

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
 * @Description: 客服人员信息
 * @author onlineGenerator
 * @date 2019-03-14 11:13:51
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_s_cs_info_m", schema = "")
@SuppressWarnings("serial")
public class TSCsInfoMEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新日期*/
	private java.util.Date updateDate;
	/**姓名*/
	@Excel(name="姓名",width=15)
	private java.lang.String csname;
	/**开始时间*/
	@Excel(name="开始时间",width=15)
	private java.lang.String begintime;
	/**结束时间*/
	@Excel(name="结束时间",width=15)
	private java.lang.String endtime;
	/**在用*/
	@Excel(name="是否在用",width=15,dicCode="isactive")
	private java.lang.String isactive;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String memo;
	/**排序*/
	@Excel(name="排序",width=15)
	private java.lang.Integer sortindex;
	
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
	 *@return: java.lang.String  姓名
	 */

	@Column(name ="CSNAME",nullable=true,length=20)
	public java.lang.String getCsname(){
		return this.csname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setCsname(java.lang.String csname){
		this.csname = csname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开始时间
	 */

	@Column(name ="BEGINTIME",nullable=true,length=20)
	public java.lang.String getBegintime(){
		return this.begintime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开始时间
	 */
	public void setBegintime(java.lang.String begintime){
		this.begintime = begintime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结束时间
	 */

	@Column(name ="ENDTIME",nullable=true,length=20)
	public java.lang.String getEndtime(){
		return this.endtime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结束时间
	 */
	public void setEndtime(java.lang.String endtime){
		this.endtime = endtime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否在用
	 */

	@Column(name ="ISACTIVE",nullable=true,length=20)
	public java.lang.String getIsactive(){
		return this.isactive;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否在用
	 */
	public void setIsactive(java.lang.String isactive){
		this.isactive = isactive;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="MEMO",nullable=true,length=50)
	public java.lang.String getMemo(){
		return this.memo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setMemo(java.lang.String memo){
		this.memo = memo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  排序
	 */

	@Column(name ="SORTINDEX",nullable=true,length=32)
	public java.lang.Integer getSortindex(){
		return this.sortindex;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  排序
	 */
	public void setSortindex(java.lang.Integer sortindex){
		this.sortindex = sortindex;
	}
}
