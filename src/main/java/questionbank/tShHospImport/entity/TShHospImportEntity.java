package questionbank.tShHospImport.entity;

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
 * @Description: 医院导入列表
 * @author onlineGenerator
 * @date 2019-03-12 17:25:08
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_sh_hosp_import", schema = "")
@SuppressWarnings("serial")
public class TShHospImportEntity implements java.io.Serializable {
	/**医院编号*/
	@Excel(name="医院简称",width=15,dictTable ="t_sh_hospital",dicCode ="id",dicText ="hospnameshort")
	private java.lang.String hospid;
	/**上传批号*/
	@Excel(name="上传批号",width=20)
	private java.lang.String auditno;
	/**状态*/
	@Excel(name="状态",width=15,dicCode="thestatus")
	private java.lang.String thestatus;
	/**创建日期*/
	@Excel(name="上传日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date createDate;
	/**创建人名称*/
	@Excel(name="上传人",width=15)
	private java.lang.String createName;
	/**提交日期*/
	@Excel(name="提交日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date commitdate;
	/**提交人*/
	@Excel(name="提交人",width=15)
	private java.lang.String commitname;
	/**审核日期*/
	@Excel(name="审核日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date auditdate;
	/**审核人*/
	@Excel(name="审核人",width=15)
	private java.lang.String auditname;



	/**上传文件名*/
	@Excel(name="上传文件名",width=30)
	private java.lang.String filename;

	/**主键*/
	private java.lang.String id;
	/**备注*/
	//@Excel(name="备注",width=15)
	private java.lang.String memo;

	/**得分*/
	@Excel(name="得分",width=15)
	private java.lang.Double thescore;
	/**年份*/
	@Excel(name="年份",width=15)
	private java.lang.Integer year;
	/**月份*/
	@Excel(name="月份",width=15)
	private java.lang.Integer month;
	/**更新日期*/
//	@Excel(name="更新日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date updateDate;
	/**更新人名称*/
	//@Excel(name="更新人名称",width=15)
	private java.lang.String updateName;

	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  审核日期
	 */

	@Column(name ="AUDITDATE",nullable=true)
	public java.util.Date getAuditdate(){
		return this.auditdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  审核日期
	 */
	public void setAuditdate(java.util.Date auditdate){
		this.auditdate = auditdate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核人
	 */

	@Column(name ="AUDITNAME",nullable=true,length=50)
	public java.lang.String getAuditname(){
		return this.auditname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核人
	 */
	public void setAuditname(java.lang.String auditname){
		this.auditname = auditname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  上传批号
	 */

	@Column(name ="AUDITNO",nullable=true,length=20)
	public java.lang.String getAuditno(){
		return this.auditno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上传批号
	 */
	public void setAuditno(java.lang.String auditno){
		this.auditno = auditno;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  提交日期
	 */

	@Column(name ="COMMITDATE",nullable=true)
	public java.util.Date getCommitdate(){
		return this.commitdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  提交日期
	 */
	public void setCommitdate(java.util.Date commitdate){
		this.commitdate = commitdate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  提交人
	 */

	@Column(name ="COMMITNAME",nullable=true,length=50)
	public java.lang.String getCommitname(){
		return this.commitname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  提交人
	 */
	public void setCommitname(java.lang.String commitname){
		this.commitname = commitname;
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
	 *@return: java.lang.String  上传文件名
	 */

	@Column(name ="FILENAME",nullable=true,length=200)
	public java.lang.String getFilename(){
		return this.filename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上传文件名
	 */
	public void setFilename(java.lang.String filename){
		this.filename = filename;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  医院编号
	 */

	@Column(name ="HOSPID",nullable=true,length=40)
	public java.lang.String getHospid(){
		return this.hospid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  医院编号
	 */
	public void setHospid(java.lang.String hospid){
		this.hospid = hospid;
	}
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  月份
	 */

	@Column(name ="MONTH",nullable=true,length=10)
	public java.lang.Integer getMonth(){
		return this.month;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  月份
	 */
	public void setMonth(java.lang.Integer month){
		this.month = month;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  得分
	 */

	@Column(name ="THESCORE",nullable=true,scale=2,length=5)
	public java.lang.Double getThescore(){
		return this.thescore;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  得分
	 */
	public void setThescore(java.lang.Double thescore){
		this.thescore = thescore;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */

	@Column(name ="THESTATUS",nullable=true,length=20)
	public java.lang.String getThestatus(){
		return this.thestatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setThestatus(java.lang.String thestatus){
		this.thestatus = thestatus;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  年份
	 */

	@Column(name ="YEAR",nullable=true,length=10)
	public java.lang.Integer getYear(){
		return this.year;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  年份
	 */
	public void setYear(java.lang.Integer year){
		this.year = year;
	}
}