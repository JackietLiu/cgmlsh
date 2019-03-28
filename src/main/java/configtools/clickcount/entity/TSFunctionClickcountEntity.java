package configtools.clickcount.entity;

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
 * @Description: 功能使用频率
 * @author onlineGenerator
 * @date 2018-02-25 19:09:40
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_s_function_clickcount", schema = "")
@SuppressWarnings("serial")
public class TSFunctionClickcountEntity implements java.io.Serializable {
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
	/**功能ID*/
	@Excel(name="功能ID",width=15,dictTable ="t_s_function",dicCode ="id",dicText ="functionname")
	private java.lang.String functionid;
	/**用户ID*/
	@Excel(name="用户ID",width=15,dictTable ="t_s_base_user",dicCode ="id",dicText ="username")
	private java.lang.String userid;
	/**使用次数*/
	@Excel(name="使用次数",width=15)
	private java.lang.Integer clickcount;
	
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
	 *@return: java.lang.String  功能ID
	 */

	@Column(name ="FUNCTIONID",nullable=true,length=40)
	public java.lang.String getFunctionid(){
		return this.functionid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  功能ID
	 */
	public void setFunctionid(java.lang.String functionid){
		this.functionid = functionid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户ID
	 */

	@Column(name ="USERID",nullable=true,length=40)
	public java.lang.String getUserid(){
		return this.userid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户ID
	 */
	public void setUserid(java.lang.String userid){
		this.userid = userid;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  使用次数
	 */

	@Column(name ="CLICKCOUNT",nullable=true,length=32)
	public java.lang.Integer getClickcount(){
		return this.clickcount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  使用次数
	 */
	public void setClickcount(java.lang.Integer clickcount){
		this.clickcount = clickcount;
	}
}
