package questionbank.tBaMedicalConsortium.entity;

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
 * @Description: 医疗联合体信息
 * @author onlineGenerator
 * @date 2019-07-09 10:57:15
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_ba_medical_consortium", schema = "")
@SuppressWarnings("serial")
public class TBaMedicalConsortiumEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**创建人名称*/
	private String createName;
	/**创建日期*/
	private Date createDate;
	/**更新人名称*/
	private String updateName;
	/**更新日期*/
	private Date updateDate;
	/**机构名称*/
	@Excel(name="机构名称",width=15)
	private String thename;
	/**组建日期*/
	@Excel(name="组建日期",width=15)
	private String builddate;
	/**上级机构*/
	@Excel(name="上级机构",width=15)
	private String pid;
	/**机构类型*/
	@Excel(name="机构类型",width=15,dicCode="orglevel")
	private String orglevel;
	/**联合方式*/
	@Excel(name="联合方式",width=15,dicCode="medicaltype")
	private String medicaltype;
	/**在用*/
	@Excel(name="在用",width=15,dicCode="isactive")
	private String isactive;
	/**备注*/
	@Excel(name="备注",width=15)
	private String memo;
	/**牵头单位*/
	@Excel(name="牵头单位",width=15,dictTable ="hosp_cons2",dicCode ="hospid",dicText ="hospname")
	private String headhospid;
	
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */

	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */

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
	 *@return: java.lang.String  更新人名称
	 */

	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */

	@Column(name ="UPDATE_DATE",nullable=true,length=20)
	public Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  机构名称
	 */

	@Column(name ="THENAME",nullable=true,length=50)
	public String getThename(){
		return this.thename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  机构名称
	 */
	public void setThename(String thename){
		this.thename = thename;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  组建日期
	 */

	@Column(name ="BUILDDATE",nullable=true,length=12)
	public String getBuilddate(){
		return this.builddate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  组建日期
	 */
	public void setBuilddate(String builddate){
		this.builddate = builddate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  上级机构
	 */

	@Column(name ="PID",nullable=true,length=40)
	public String getPid(){
		return this.pid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上级机构
	 */
	public void setPid(String pid){
		this.pid = pid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  机构类型
	 */

	@Column(name ="ORGLEVEL",nullable=true,length=20)
	public String getOrglevel(){
		return this.orglevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  机构类型
	 */
	public void setOrglevel(String orglevel){
		this.orglevel = orglevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联合方式
	 */

	@Column(name ="MEDICALTYPE",nullable=true,length=20)
	public String getMedicaltype(){
		return this.medicaltype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联合方式
	 */
	public void setMedicaltype(String medicaltype){
		this.medicaltype = medicaltype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  在用
	 */

	@Column(name ="ISACTIVE",nullable=true,length=20)
	public String getIsactive(){
		return this.isactive;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  在用
	 */
	public void setIsactive(String isactive){
		this.isactive = isactive;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="MEMO",nullable=true,length=100)
	public String getMemo(){
		return this.memo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setMemo(String memo){
		this.memo = memo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  牵头单位
	 */

	@Column(name ="HEADHOSPID",nullable=true,length=36)
	public String getHeadhospid(){
		return this.headhospid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  牵头单位
	 */
	public void setHeadhospid(String headhospid){
		this.headhospid = headhospid;
	}
}
