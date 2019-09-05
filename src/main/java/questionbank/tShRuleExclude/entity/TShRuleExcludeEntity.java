package questionbank.tShRuleExclude.entity;

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
 * @Description: t_sh_rule_exclude
 * @author onlineGenerator
 * @date 2019-09-05 16:39:18
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_sh_rule_exclude", schema = "")
@SuppressWarnings("serial")
public class TShRuleExcludeEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**通用名*/
	@Excel(name="通用名",width=15)
	private java.lang.String commonname;
	/**规则*/
	@Excel(name="规则",width=15,dictTable ="t_sh_rule_info",dicCode ="id",dicText ="rulename")
	private java.lang.String ruleid;
	/**医院*/
	@Excel(name="医院",width=15,dictTable ="t_sh_hospital",dicCode ="id",dicText ="hospname")
	private java.lang.String hospid;
	/**是否在用*/
	@Excel(name="是否在用",width=15)
	private java.lang.String isactive;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String memo;
	
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
	 *@return: java.lang.String  通用名
	 */

	@Column(name ="COMMONNAME",nullable=true,length=1000)
	public java.lang.String getCommonname(){
		return this.commonname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  通用名
	 */
	public void setCommonname(java.lang.String commonname){
		this.commonname = commonname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  规则
	 */

	@Column(name ="RULEID",nullable=true,length=40)
	public java.lang.String getRuleid(){
		return this.ruleid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  规则
	 */
	public void setRuleid(java.lang.String ruleid){
		this.ruleid = ruleid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  医院
	 */

	@Column(name ="HOSPID",nullable=true,length=40)
	public java.lang.String getHospid(){
		return this.hospid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  医院
	 */
	public void setHospid(java.lang.String hospid){
		this.hospid = hospid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否在用
	 */

	@Column(name ="ISACTIVE",nullable=true,length=20)
	public java.lang.String getIsactive(){
		return this.isactive;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否在用
	 */
	public void setIsactive(java.lang.String isactive){
		this.isactive = isactive;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="MEMO",nullable=true,length=200)
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
}
