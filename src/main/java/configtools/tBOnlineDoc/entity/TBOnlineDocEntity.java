package configtools.tBOnlineDoc.entity;

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
 * @Description: 在线文档一览
 * @author onlineGenerator
 * @date 2019-03-21 12:16:53
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_b_online_doc", schema = "")
@SuppressWarnings("serial")
public class TBOnlineDocEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新日期*/
	private java.util.Date updateDate;
	/**文档名称*/
	@Excel(name="文档名称",width=15)
	private java.lang.String docname;
	/**文档描述*/
	@Excel(name="文档描述",width=15)
	private java.lang.String docdesc;
	/**文件名*/
	@Excel(name="文件名",width=15)
	private java.lang.String docpathname;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String memo;
	/**在用*/
	@Excel(name="在用",width=15,dicCode="isactive")
	private java.lang.String isactive;
	/**排序*/
	@Excel(name="排序",width=15)
	private java.lang.Integer sortindex;
	/**类别*/
	@Excel(name="类别",width=15,dicCode="docclass")
	private java.lang.String docclass;
	
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */

	@Column(name ="CREATE_DATE",nullable=true,length=20)
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

	@Column(name ="UPDATE_DATE",nullable=true,length=20)
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
	 *@return: java.lang.String  文档名称
	 */

	@Column(name ="DOCNAME",nullable=true,length=50)
	public java.lang.String getDocname(){
		return this.docname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文档名称
	 */
	public void setDocname(java.lang.String docname){
		this.docname = docname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文档描述
	 */

	@Column(name ="DOCDESC",nullable=true,length=100)
	public java.lang.String getDocdesc(){
		return this.docdesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文档描述
	 */
	public void setDocdesc(java.lang.String docdesc){
		this.docdesc = docdesc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文件名
	 */

	@Column(name ="DOCPATHNAME",nullable=true,length=100)
	public java.lang.String getDocpathname(){
		return this.docpathname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文件名
	 */
	public void setDocpathname(java.lang.String docpathname){
		this.docpathname = docpathname;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  在用
	 */

	@Column(name ="ISACTIVE",nullable=true,length=20)
	public java.lang.String getIsactive(){
		return this.isactive;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  在用
	 */
	public void setIsactive(java.lang.String isactive){
		this.isactive = isactive;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  排序
	 */

	@Column(name ="SORTINDEX",nullable=true,length=32)
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
	 *@return: java.lang.String  类别
	 */

	@Column(name ="DOCCLASS",nullable=true,length=20)
	public java.lang.String getDocclass(){
		return this.docclass;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类别
	 */
	public void setDocclass(java.lang.String docclass){
		this.docclass = docclass;
	}
}
