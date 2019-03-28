package questionbank.tShUserHospRel.entity;

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
 * @Description: 用户医院关联信息
 * @author onlineGenerator
 * @date 2019-02-27 09:43:33
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_sh_user_hosp_rel", schema = "")
@SuppressWarnings("serial")
public class TShUserHospRelEntity implements java.io.Serializable {
	/**ID*/
	private String id;
	/**用户*/
	@Excel(name="用户",width=15)
	private String userid;
	/**医院*/
	@Excel(name="医院",width=15,dictTable ="t_sh_hospital",dicCode ="id",dicText ="hospname")
	private String hospid;
	/**更新人名称*/
	private String updateName;
	/**更新日期*/
	private Date updateDate;
	/**创建日期*/
	private Date createDate;
	/**创建人名称*/
	private String createName;
	/**在用*/
	@Excel(name="在用",width=15,dicCode="isavtive")
	private String isavtive;
	/**备注*/
	@Excel(name="备注",width=15)
	private String memo;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ID
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=40)
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  ID
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户
	 */

	@Column(name ="USERID",nullable=false,length=40)
	public String getUserid(){
		return this.userid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户
	 */
	public void setUserid(String userid){
		this.userid = userid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  医院
	 */

	@Column(name ="HOSPID",nullable=false,length=40)
	public String getHospid(){
		return this.hospid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  医院
	 */
	public void setHospid(String hospid){
		this.hospid = hospid;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  在用
	 */

	@Column(name ="ISAVTIVE",nullable=true,length=20)
	public String getIsavtive(){
		return this.isavtive;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  在用
	 */
	public void setIsavtive(String isavtive){
		this.isavtive = isavtive;
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
}