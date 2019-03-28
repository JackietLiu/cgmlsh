package questionbank.tShHospImport.entity;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: 医院导入列表
 * @author onlineGenerator
 * @date 2019-03-12 17:25:08
 * @version V1.0   
 *
 */
@Entity

@SuppressWarnings("serial")
public class TShHospImportModel implements java.io.Serializable {


	/**医院编号*/
	private String hospnameshort ;
	private String hospid;
	/**上传批号*/
	@Excel(name="上传批号",width=20)
	private String auditno;
	/**状态*/
	@Excel(name="状态",width=15,dicCode="thestatus")
	private String thestatus;

	/**提交日期*/
	@Excel(name="提交日期",width=15,format = "yyyy-MM-dd")
	private Date commitdate;
	/**提交人*/
	@Excel(name="提交人",width=15)
	private String commitname;
	/**审核日期*/
	@Excel(name="审核日期",width=15,format = "yyyy-MM-dd")
	private Date auditdate;
	/**审核人*/
	@Excel(name="审核人",width=15)
	private String auditname;

	/**主键*/
	private String id;

	/**得分*/
	@Excel(name="得分",width=15)
	private Double thescore;
	/**年份*/
	@Excel(name="年份",width=15)
	private Integer year;
	/**月份*/
	@Excel(name="月份",width=15)
	private Integer month;
	@Column(name ="thestatustext",nullable=true)
	public String getThestatustext() {
		return thestatustext;
	}

	public void setThestatustext(String thestatustext) {
		this.thestatustext = thestatustext;
	}

	private String thestatustext;

	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  审核日期
	 */

	@Column(name ="AUDITDATE",nullable=true)
	public Date getAuditdate(){
		return this.auditdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  审核日期
	 */
	public void setAuditdate(Date auditdate){
		this.auditdate = auditdate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核人
	 */

	@Column(name ="AUDITNAME",nullable=true,length=50)
	public String getAuditname(){
		return this.auditname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核人
	 */
	public void setAuditname(String auditname){
		this.auditname = auditname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  上传批号
	 */

	@Column(name ="AUDITNO",nullable=true,length=20)
	public String getAuditno(){
		return this.auditno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上传批号
	 */
	public void setAuditno(String auditno){
		this.auditno = auditno;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  提交日期
	 */

	@Column(name ="COMMITDATE",nullable=true)
	public Date getCommitdate(){
		return this.commitdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  提交日期
	 */
	public void setCommitdate(Date commitdate){
		this.commitdate = commitdate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  提交人
	 */

	@Column(name ="COMMITNAME",nullable=true,length=50)
	public String getCommitname(){
		return this.commitname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  提交人
	 */
	public void setCommitname(String commitname){
		this.commitname = commitname;
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
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=36)
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  月份
	 */

	@Column(name ="MONTH",nullable=true,length=10)
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
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  得分
	 */

	@Column(name ="THESCORE",nullable=true,scale=2,length=5)
	public Double getThescore(){
		return this.thescore;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  得分
	 */
	public void setThescore(Double thescore){
		this.thescore = thescore;
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

	@Column(name ="YEAR",nullable=true,length=10)
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
	@Column(name ="hospnameshort",nullable=true,length=10)
	public String getHospnameshort() {
		return hospnameshort;
	}

	public void setHospnameshort(String hospnameshort) {
		this.hospnameshort = hospnameshort;
	}
}