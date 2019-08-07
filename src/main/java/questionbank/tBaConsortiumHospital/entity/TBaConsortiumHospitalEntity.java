package questionbank.tBaConsortiumHospital.entity;

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
 * @Description: 医联体下属医院
 * @author onlineGenerator
 * @date 2019-07-09 10:56:55
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_ba_consortium_hospital", schema = "")
@SuppressWarnings("serial")
public class TBaConsortiumHospitalEntity implements java.io.Serializable {
	/**id*/
	private String id;
	/**联合体id*/
	@Excel(name="联合体id",width=15,dictTable ="t_ba_medical_consortium",dicCode ="id",dicText ="thename")
	private String consid;
	/**牵头医院*/
	@Excel(name="牵头医院",width=15)
	private String headhospid;
	/**医院id*/
	@Excel(name="基层医院",width=15)
	private String hospid;
	/**医院id*/
	@Excel(name="基层医院名称",width=15)
	private String hospname;
	/**创建人名称*/
	private String createName;
	/**创建日期*/
	private Date createDate;
	/**更新人名称*/
	private String updateName;
	/**更新日期*/
	private Date updateDate;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
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
	 *@param: java.lang.String  id
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联合体id
	 */

	@Column(name ="CONSID",nullable=true,length=36)
	public String getConsid(){
		return this.consid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联合体id
	 */
	public void setConsid(String consid){
		this.consid = consid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  牵头医院
	 */

	@Column(name ="HEADHOSPID",nullable=true,length=36)
	public String getHeadhospid(){
		return this.headhospid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  牵头医院
	 */
	public void setHeadhospid(String headhospid){
		this.headhospid = headhospid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  医院id
	 */

	@Column(name ="HOSPID",nullable=true,length=36)
	public String getHospid(){
		return this.hospid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  医院id
	 */
	public void setHospid(String hospid){
		this.hospid = hospid;
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

	@Column(name ="CREATE_DATE",nullable=true)
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

	@Column(name ="UPDATE_DATE",nullable=true)
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

	public String getHospname() {
		return hospname;
	}

	public void setHospname(String hospname) {
		this.hospname = hospname;
	}
}
