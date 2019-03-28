package questionbank.tShRuleInfo.entity;

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
 * @Description: 审核规则存储过程
 * @author onlineGenerator
 * @date 2019-02-26 17:05:57
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_sh_rule_info_proc", schema = "")
@SuppressWarnings("serial")
public class TShRuleInfoProcEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**名称*/
	@Excel(name="名称",width=15)
	private String procname;
	/**在用*/
	@Excel(name="在用",width=15,dicCode="isactive")
	private String isactive;
	/**存储过程名*/
	@Excel(name="存储过程名",width=15)
	private String procmysql;
	/**备注*/
	@Excel(name="备注",width=15)
	private String memo;
	/**更新人名称*/
	private String updateName;
	/**更新日期*/
	private Date updateDate;
	/**创建人名称*/
	private String createName;
	/**创建日期*/
	private Date createDate;
	
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
	 *@return: java.lang.String  名称
	 */

	@Column(name ="PROCNAME",nullable=true,length=20)
	public String getProcname(){
		return this.procname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  名称
	 */
	public void setProcname(String procname){
		this.procname = procname;
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
	 *@return: java.lang.String  存储过程名
	 */

	@Column(name ="PROCMYSQL",nullable=true,length=32)
	public String getProcmysql(){
		return this.procmysql;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  存储过程名
	 */
	public void setProcmysql(String procmysql){
		this.procmysql = procmysql;
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
}