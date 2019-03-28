package configtools.tbconfig.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: vs_config
 * @author onlineGenerator
 * @date 2017-12-28 16:05:35
 * @version V1.0   
 *
 */
@Entity
@Table(name = "vs_config", schema = "")
@SuppressWarnings("serial")
public class VsConfigEntity implements java.io.Serializable {
	/**entid*/
	@Excel(name="entid",width=15)
	private java.lang.String entid;
	/**id*/
	private java.lang.String id;
	/**deptid*/
	@Excel(name="deptid",width=15)
	private java.lang.String deptid;
	/**userid*/
	@Excel(name="userid",width=15)
	private java.lang.String userid;
	/**userid2*/
	@Excel(name="userid2",width=15)
	private java.lang.String userid2;
	/**roleid*/
	@Excel(name="roleid",width=15)
	private java.lang.String roleid;
	/**managerlevel*/
	@Excel(name="managerlevel",width=15)
	private java.lang.String managerlevel;
	/**code*/
	@Excel(name="code",width=15)
	private java.lang.String code;
	/**confname*/
	@Excel(name="confname",width=15)
	private java.lang.String confname;
	/**thevalue*/
	@Excel(name="thevalue",width=15)
	private java.lang.String thevalue;
	/**groupflag*/
	@Excel(name="groupflag",width=15)
	private java.lang.String groupflag;
	/**codedetail*/
	@Excel(name="codedetail",width=15)
	private java.lang.String codedetail;
	/**category*/
	@Excel(name="category",width=15)
	private java.lang.String category;
	/**configlevel*/
	@Excel(name="configlevel",width=15)
	private java.lang.String configlevel;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  entid
	 */

	@Column(name ="ENTID",nullable=true,length=40)
	public java.lang.String getEntid(){
		return this.entid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  entid
	 */
	public void setEntid(java.lang.String entid){
		this.entid = entid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
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
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  deptid
	 */

	@Column(name ="DEPTID",nullable=true,length=36)
	public java.lang.String getDeptid(){
		return this.deptid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  deptid
	 */
	public void setDeptid(java.lang.String deptid){
		this.deptid = deptid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  userid
	 */

	@Column(name ="USERID",nullable=false,length=32)
	public java.lang.String getUserid(){
		return this.userid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  userid
	 */
	public void setUserid(java.lang.String userid){
		this.userid = userid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  userid2
	 */

	@Column(name ="USERID2",nullable=true,length=40)
	public java.lang.String getUserid2(){
		return this.userid2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  userid2
	 */
	public void setUserid2(java.lang.String userid2){
		this.userid2 = userid2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  roleid
	 */

	@Column(name ="ROLEID",nullable=true,length=36)
	public java.lang.String getRoleid(){
		return this.roleid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  roleid
	 */
	public void setRoleid(java.lang.String roleid){
		this.roleid = roleid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  managerlevel
	 */

	@Column(name ="MANAGERLEVEL",nullable=true,length=50)
	public java.lang.String getManagerlevel(){
		return this.managerlevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  managerlevel
	 */
	public void setManagerlevel(java.lang.String managerlevel){
		this.managerlevel = managerlevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  code
	 */

	@Column(name ="CODE",nullable=true,length=50)
	public java.lang.String getCode(){
		return this.code;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  code
	 */
	public void setCode(java.lang.String code){
		this.code = code;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  confname
	 */

	@Column(name ="CONFNAME",nullable=true,length=50)
	public java.lang.String getConfname(){
		return this.confname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  confname
	 */
	public void setConfname(java.lang.String confname){
		this.confname = confname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  thevalue
	 */

	@Column(name ="THEVALUE",nullable=true,length=50)
	public java.lang.String getThevalue(){
		return this.thevalue;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  thevalue
	 */
	public void setThevalue(java.lang.String thevalue){
		this.thevalue = thevalue;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  groupflag
	 */

	@Column(name ="GROUPFLAG",nullable=true,length=50)
	public java.lang.String getGroupflag(){
		return this.groupflag;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  groupflag
	 */
	public void setGroupflag(java.lang.String groupflag){
		this.groupflag = groupflag;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  codedetail
	 */

	@Column(name ="CODEDETAIL",nullable=true,length=50)
	public java.lang.String getCodedetail(){
		return this.codedetail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  codedetail
	 */
	public void setCodedetail(java.lang.String codedetail){
		this.codedetail = codedetail;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  category
	 */

	@Column(name ="CATEGORY",nullable=true,length=20)
	public java.lang.String getCategory(){
		return this.category;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  category
	 */
	public void setCategory(java.lang.String category){
		this.category = category;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  configlevel
	 */

	@Column(name ="CONFIGLEVEL",nullable=true,length=50)
	public java.lang.String getConfiglevel(){
		return this.configlevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  configlevel
	 */
	public void setConfiglevel(java.lang.String configlevel){
		this.configlevel = configlevel;
	}
}
