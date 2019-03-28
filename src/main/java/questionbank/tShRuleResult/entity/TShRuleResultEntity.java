package questionbank.tShRuleResult.entity;

import java.util.Date;
import java.lang.String;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 审核结果清单
 * @author liu
 * @date 2019-02-20 10:06:42
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_sh_rule_result", schema = "")
@SuppressWarnings("serial")
public class TShRuleResultEntity implements java.io.Serializable {
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
	/**规则*/
	@Excel(name="规则",width=15,dictTable ="t_sh_rule_info",dicCode ="id",dicText ="rulename")
	private String ruleid;
	/**医院*/
	@Excel(name="医院",width=15,dictTable ="t_sh_hospital",dicCode ="id",dicText ="hospname")
	private String hospid;
	/**审核编号*/
	@Excel(name="审核编号",width=15)
	private String auditno;
	/**备注*/
	@Excel(name="备注",width=15)
	private String memo;
	/**结果描述*/
	@Excel(name="结果描述",width=15)
	private String resultdesc;
	
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
	 *@return: java.lang.String  规则
	 */

	@Column(name ="RULEID",nullable=true,length=40)
	public String getRuleid(){
		return this.ruleid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  规则
	 */
	public void setRuleid(String ruleid){
		this.ruleid = ruleid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  医院
	 */

	@Column(name ="HOSPID",nullable=true,length=40)
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
	 *@return: java.lang.String  审核编号
	 */

	@Column(name ="AUDITNO",nullable=true,length=20)
	public String getAuditno(){
		return this.auditno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核编号
	 */
	public void setAuditno(String auditno){
		this.auditno = auditno;
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
	 *@return: java.lang.String  结果描述
	 */

	@Column(name ="RESULTDESC",nullable=true,length=200)
	public String getResultdesc(){
		return this.resultdesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结果描述
	 */
	public void setResultdesc(String resultdesc){
		this.resultdesc = resultdesc;
	}
}