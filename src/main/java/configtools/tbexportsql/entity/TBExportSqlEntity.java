package configtools.tbexportsql.entity;

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
 * @Description: 导出数据
 * @author onlineGenerator
 * @date 2018-01-29 16:27:55
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_b_export_sql", schema = "")
@SuppressWarnings("serial")
public class TBExportSqlEntity implements java.io.Serializable {
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
	/**脚本*/
	@Excel(name="脚本",width=15)
	private java.lang.String sqlscript;
	/**保存文件名*/
	@Excel(name="保存文件名",width=15)
	private java.lang.String thefile;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String memo;
	/**连接字符串*/
	@Excel(name="连接字符串",width=15)
	private java.lang.String connstr;
	/**用户名*/
	@Excel(name="用户名",width=15)
	private java.lang.String theusername;
	/**密码*/
	@Excel(name="密码",width=15)
	private java.lang.String thepassword;
	/**数据库类型*/
	@Excel(name="数据库类型",width=15,dicCode="dbtype")
	private java.lang.String thedbtype;
	/**插入的表名*/
	@Excel(name="插入的表名",width=15)
	private java.lang.String thetablename;
	
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
	 *@return: java.lang.String  脚本
	 */

	@Column(name ="SQLSCRIPT",nullable=true,length=2000)
	public java.lang.String getSqlscript(){
		return this.sqlscript;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  脚本
	 */
	public void setSqlscript(java.lang.String sqlscript){
		this.sqlscript = sqlscript;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  保存文件名
	 */

	@Column(name ="THEFILE",nullable=true,length=200)
	public java.lang.String getThefile(){
		return this.thefile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  保存文件名
	 */
	public void setThefile(java.lang.String thefile){
		this.thefile = thefile;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="MEMO",nullable=true,length=100)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  连接字符串
	 */

	@Column(name ="CONNSTR",nullable=true,length=200)
	public java.lang.String getConnstr(){
		return this.connstr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  连接字符串
	 */
	public void setConnstr(java.lang.String connstr){
		this.connstr = connstr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户名
	 */

	@Column(name ="THEUSERNAME",nullable=true,length=32)
	public java.lang.String getTheusername(){
		return this.theusername;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户名
	 */
	public void setTheusername(java.lang.String theusername){
		this.theusername = theusername;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  密码
	 */

	@Column(name ="THEPASSWORD",nullable=true,length=200)
	public java.lang.String getThepassword(){
		return this.thepassword;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  密码
	 */
	public void setThepassword(java.lang.String thepassword){
		this.thepassword = thepassword;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  数据库类型
	 */

	@Column(name ="THEDBTYPE",nullable=true,length=100)
	public java.lang.String getThedbtype(){
		return this.thedbtype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  数据库类型
	 */
	public void setThedbtype(java.lang.String thedbtype){
		this.thedbtype = thedbtype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  插入的表名
	 */

	@Column(name ="THETABLENAME",nullable=true,length=32)
	public java.lang.String getThetablename(){
		return this.thetablename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  插入的表名
	 */
	public void setThetablename(java.lang.String thetablename){
		this.thetablename = thetablename;
	}
}
