package weixin.guanjia.busionline.entity;

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
 * @Description: 网上政务详情
 * @author onlineGenerator
 * @date 2017-08-15 00:17:27
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_b_busionline_item", schema = "")
@SuppressWarnings("serial")
public class TBBusionlineItemEntity implements java.io.Serializable {
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
	/**政务ID*/
	@Excel(name="政务ID")
	private java.lang.String busionlineid;
	/**图标*/
	@Excel(name="图标")
	private java.lang.String photopath;
	/**项目名称*/
	@Excel(name="项目名称")
	private java.lang.String itemname;
	/**功能链接*/
	@Excel(name="功能链接")
	private java.lang.String url;
	/**排序*/
	@Excel(name="排序")
	private java.lang.Integer sortindex;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String memo;
	/**在用*/
	@Excel(name="在用")
	private java.lang.String isactive;
	/**附件1*/
	@Excel(name="附件1")
	private java.lang.String attachment1;
	/**附件2*/
	@Excel(name="附件2")
	private java.lang.String attachment2;
	/**附件3*/
	@Excel(name="附件3")
	private java.lang.String attachment3;
	
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
	 *@return: java.lang.String  政务ID
	 */
	@Column(name ="BUSIONLINEID",nullable=true,length=40)
	public java.lang.String getBusionlineid(){
		return this.busionlineid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  政务ID
	 */
	public void setBusionlineid(java.lang.String busionlineid){
		this.busionlineid = busionlineid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图标
	 */
	@Column(name ="PHOTOPATH",nullable=true,length=100)
	public java.lang.String getPhotopath(){
		return this.photopath;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图标
	 */
	public void setPhotopath(java.lang.String photopath){
		this.photopath = photopath;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目名称
	 */
	@Column(name ="ITEMNAME",nullable=true,length=50)
	public java.lang.String getItemname(){
		return this.itemname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目名称
	 */
	public void setItemname(java.lang.String itemname){
		this.itemname = itemname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  功能链接
	 */
	@Column(name ="URL",nullable=true,length=100)
	public java.lang.String getUrl(){
		return this.url;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  功能链接
	 */
	public void setUrl(java.lang.String url){
		this.url = url;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  排序
	 */
	@Column(name ="SORTINDEX",nullable=true,length=20)
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
	@Column(name ="ISACTIVE",nullable=true,length=32)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附件1
	 */
	@Column(name ="ATTACHMENT1",nullable=true,length=100)
	public java.lang.String getAttachment1(){
		return this.attachment1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件1
	 */
	public void setAttachment1(java.lang.String attachment1){
		this.attachment1 = attachment1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附件2
	 */
	@Column(name ="ATTACHMENT2",nullable=true,length=100)
	public java.lang.String getAttachment2(){
		return this.attachment2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件2
	 */
	public void setAttachment2(java.lang.String attachment2){
		this.attachment2 = attachment2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附件3
	 */
	@Column(name ="ATTACHMENT3",nullable=true,length=100)
	public java.lang.String getAttachment3(){
		return this.attachment3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件3
	 */
	public void setAttachment3(java.lang.String attachment3){
		this.attachment3 = attachment3;
	}
}
