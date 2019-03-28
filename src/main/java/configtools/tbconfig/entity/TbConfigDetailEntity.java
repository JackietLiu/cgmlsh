package configtools.tbconfig.entity;

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
 * @Description: 系统配置详情
 * @author onlineGenerator
 * @date 2018-02-01 12:54:08
 * @version V1.0   
 *
 */
@Entity
@Table(name = "tb_config_detail", schema = "")
@SuppressWarnings("serial")
public class TbConfigDetailEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**配置*/
	@Excel(name="配置",width=15,dictTable ="tb_config",dicCode ="id",dicText ="confname")
	private java.lang.String confid;
	/**部门*/
	@Excel(name="部门",width=15,dictTable ="t_s_depart",dicCode ="id",dicText ="departname")
	private java.lang.String deptid;
	/**用户*/
	@Excel(name="用户",width=15,dictTable ="t_s_base_user",dicCode ="id",dicText ="realname")
	private java.lang.String userid;
	/**角色*/
	@Excel(name="角色",width=15,dictTable ="t_s_role",dicCode ="id",dicText ="rolename")
	private java.lang.String roleid;
	/**代码*/
	@Excel(name="代码",width=15)
	private java.lang.String code;
	/**代码详细*/
	@Excel(name="代码详细",width=15)
	private java.lang.String codedetail;
	/**取值*/
	@Excel(name="取值",width=15)
	private java.lang.String thevalue;
	/**是否在用*/
	@Excel(name="是否在用",width=15,dicCode="isactive")
	private java.lang.Integer isactive;
	/**说明*/
	@Excel(name="说明",width=15)
	private java.lang.String memo;
	/**公司id*/
	@Excel(name="公司id",width=15)
	private java.lang.String entid;
	
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
	 *@return: java.lang.String  配置
	 */

	@Column(name ="CONFID",nullable=true,length=36)
	public java.lang.String getConfid(){
		return this.confid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  配置
	 */
	public void setConfid(java.lang.String confid){
		this.confid = confid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  部门
	 */

	@Column(name ="DEPTID",nullable=true,length=36)
	public java.lang.String getDeptid(){
		return this.deptid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  部门
	 */
	public void setDeptid(java.lang.String deptid){
		this.deptid = deptid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户
	 */

	@Column(name ="USERID",nullable=true,length=40)
	public java.lang.String getUserid(){
		return this.userid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户
	 */
	public void setUserid(java.lang.String userid){
		this.userid = userid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  角色
	 */

	@Column(name ="ROLEID",nullable=true,length=36)
	public java.lang.String getRoleid(){
		return this.roleid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  角色
	 */
	public void setRoleid(java.lang.String roleid){
		this.roleid = roleid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代码
	 */

	@Column(name ="CODE",nullable=true,length=50)
	public java.lang.String getCode(){
		return this.code;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代码
	 */
	public void setCode(java.lang.String code){
		this.code = code;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代码详细
	 */

	@Column(name ="CODEDETAIL",nullable=true,length=50)
	public java.lang.String getCodedetail(){
		return this.codedetail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代码详细
	 */
	public void setCodedetail(java.lang.String codedetail){
		this.codedetail = codedetail;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  取值
	 */

	@Column(name ="THEVALUE",nullable=true,length=50)
	public java.lang.String getThevalue(){
		return this.thevalue;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  取值
	 */
	public void setThevalue(java.lang.String thevalue){
		this.thevalue = thevalue;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否在用
	 */

	@Column(name ="ISACTIVE",nullable=false,length=10)
	public java.lang.Integer getIsactive(){
		return this.isactive;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否在用
	 */
	public void setIsactive(java.lang.Integer isactive){
		this.isactive = isactive;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  说明
	 */

	@Column(name ="MEMO",nullable=true,length=50)
	public java.lang.String getMemo(){
		return this.memo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  说明
	 */
	public void setMemo(java.lang.String memo){
		this.memo = memo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司id
	 */

	@Column(name ="ENTID",nullable=true,length=40)
	public java.lang.String getEntid(){
		return this.entid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司id
	 */
	public void setEntid(java.lang.String entid){
		this.entid = entid;
	}
}
