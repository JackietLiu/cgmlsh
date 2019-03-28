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
 * @Description: 系统配置
 * @author onlineGenerator
 * @date 2018-02-01 09:58:41
 * @version V1.0   
 *
 */
@Entity
@Table(name = "tb_config", schema = "")
@SuppressWarnings("serial")
public class TbConfig2Entity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**代码*/
	@Excel(name="代码",width=15)
	private java.lang.String code;
	/**配置名称*/
	@Excel(name="配置名称",width=15)
	private java.lang.String confname;
	/**配置描述*/
	@Excel(name="配置描述",width=15)
	private java.lang.String confdescribe;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String memo;
	/**默认值*/
	@Excel(name="默认值",width=15)
	private java.lang.String defaultvalue;
	/**管理级别*/
	@Excel(name="管理级别",width=15)
	private java.lang.String managerlevel;
	/**分组代码*/
	@Excel(name="分组代码",width=15)
	private java.lang.String groupflag;
	/**分组名称*/
	@Excel(name="分组名称",width=15)
	private java.lang.String groupflagname;
	/**类别*/
	@Excel(name="类别",width=15)
	private java.lang.String category;
	/**值类别*/
	@Excel(name="值类别",width=15)
	private java.lang.String valuetype;
	/**值范围*/
	@Excel(name="值范围",width=15)
	private java.lang.String valuescope;
	/**是否在用*/
	@Excel(name="是否在用",width=15,dicCode="isactive")
	private java.lang.Integer isactive;
	/**停止日期*/
	@Excel(name="停止日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date stopdate;
	/**排序*/
	@Excel(name="排序",width=15)
	private java.lang.Integer sortindex;
	/**是否同步本地*/
	@Excel(name="是否同步本地",width=15)
	private java.lang.String issynclocal;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新日期*/
	private java.util.Date updateDate;
	/**创建日期*/
	private java.util.Date createDate;
	/**创建人名称*/
	private java.lang.String createName;
	
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
	 *@return: java.lang.String  配置名称
	 */

	@Column(name ="CONFNAME",nullable=true,length=50)
	public java.lang.String getConfname(){
		return this.confname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  配置名称
	 */
	public void setConfname(java.lang.String confname){
		this.confname = confname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  配置描述
	 */

	@Column(name ="CONFDESCRIBE",nullable=true,length=500)
	public java.lang.String getConfdescribe(){
		return this.confdescribe;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  配置描述
	 */
	public void setConfdescribe(java.lang.String confdescribe){
		this.confdescribe = confdescribe;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  默认值
	 */

	@Column(name ="DEFAULTVALUE",nullable=true,length=50)
	public java.lang.String getDefaultvalue(){
		return this.defaultvalue;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  默认值
	 */
	public void setDefaultvalue(java.lang.String defaultvalue){
		this.defaultvalue = defaultvalue;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  管理级别
	 */

	@Column(name ="MANAGERLEVEL",nullable=true,length=50)
	public java.lang.String getManagerlevel(){
		return this.managerlevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  管理级别
	 */
	public void setManagerlevel(java.lang.String managerlevel){
		this.managerlevel = managerlevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分组代码
	 */

	@Column(name ="GROUPFLAG",nullable=true,length=50)
	public java.lang.String getGroupflag(){
		return this.groupflag;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分组代码
	 */
	public void setGroupflag(java.lang.String groupflag){
		this.groupflag = groupflag;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分组名称
	 */

	@Column(name ="GROUPFLAGNAME",nullable=true,length=50)
	public java.lang.String getGroupflagname(){
		return this.groupflagname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分组名称
	 */
	public void setGroupflagname(java.lang.String groupflagname){
		this.groupflagname = groupflagname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  类别
	 */

	@Column(name ="CATEGORY",nullable=true,length=20)
	public java.lang.String getCategory(){
		return this.category;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类别
	 */
	public void setCategory(java.lang.String category){
		this.category = category;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  值类别
	 */

	@Column(name ="VALUETYPE",nullable=true,length=20)
	public java.lang.String getValuetype(){
		return this.valuetype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  值类别
	 */
	public void setValuetype(java.lang.String valuetype){
		this.valuetype = valuetype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  值范围
	 */

	@Column(name ="VALUESCOPE",nullable=true,length=20)
	public java.lang.String getValuescope(){
		return this.valuescope;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  值范围
	 */
	public void setValuescope(java.lang.String valuescope){
		this.valuescope = valuescope;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否在用
	 */

	@Column(name ="ISACTIVE",nullable=true,length=10)
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  停止日期
	 */

	@Column(name ="STOPDATE",nullable=true)
	public java.util.Date getStopdate(){
		return this.stopdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  停止日期
	 */
	public void setStopdate(java.util.Date stopdate){
		this.stopdate = stopdate;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  排序
	 */

	@Column(name ="SORTINDEX",nullable=true,length=10)
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否同步本地
	 */

	@Column(name ="ISSYNCLOCAL",nullable=true,length=10)
	public java.lang.String getIssynclocal(){
		return this.issynclocal;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否同步本地
	 */
	public void setIssynclocal(java.lang.String issynclocal){
		this.issynclocal = issynclocal;
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
}
