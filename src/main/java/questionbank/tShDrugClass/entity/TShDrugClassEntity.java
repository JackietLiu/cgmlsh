package questionbank.tShDrugClass.entity;

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
 * @Description: 药品目录
 * @author onlineGenerator
 * @date 2019-03-04 14:19:06
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_sh_drug_class", schema = "")
@SuppressWarnings("serial")
public class TShDrugClassEntity implements java.io.Serializable {
	/**代码*/
	@Excel(name="代码",width=15)
	private String classcode;
	/**名称*/
	@Excel(name="名称",width=15)
	private String classname;
	/**创建日期*/
	private Date createDate;
	/**创建人名称*/
	private String createName;
	/**id*/
	private String id;
	/**在用*/
	@Excel(name="在用",width=15,dicCode="isactive")
	private String isactive;
	/**备注*/
	@Excel(name="备注",width=15)
	private String memo;
	/**上一级名称*/
	@Excel(name="上一级名称",width=15)
	private String pid;
	/**排序*/
	@Excel(name="排序",width=15)
	private Integer sortindex;
	/**更新日期*/
	private Date updateDate;
	/**更新人名称*/
	private String updateName;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代码
	 */

	@Column(name ="CLASSCODE",nullable=true,length=20)
	public String getClasscode(){
		return this.classcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代码
	 */
	public void setClasscode(String classcode){
		this.classcode = classcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  名称
	 */

	@Column(name ="CLASSNAME",nullable=true,length=32)
	public String getClassname(){
		return this.classname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  名称
	 */
	public void setClassname(String classname){
		this.classname = classname;
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
	 *@return: java.lang.String  在用
	 */

	@Column(name ="ISACTIVE",nullable=true,length=32)
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
	 *@return: java.lang.String  上一级名称
	 */

	@Column(name ="PID",nullable=true,length=32)
	public String getPid(){
		return this.pid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上一级名称
	 */
	public void setPid(String pid){
		this.pid = pid;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  排序
	 */

	@Column(name ="SORTINDEX",nullable=true,length=10)
	public Integer getSortindex(){
		return this.sortindex;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  排序
	 */
	public void setSortindex(Integer sortindex){
		this.sortindex = sortindex;
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
}
