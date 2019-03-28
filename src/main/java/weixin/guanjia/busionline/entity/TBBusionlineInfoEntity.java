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
 * @Description: 网上政务
 * @author onlineGenerator
 * @date 2017-08-13 19:00:01
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_b_busionline_info", schema = "")
@SuppressWarnings("serial")
public class TBBusionlineInfoEntity implements java.io.Serializable {
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
	/**业务名称*/
	@Excel(name="业务名称")
	private java.lang.String businame;
	/**业务简称*/
	@Excel(name="业务简称")
	private java.lang.String businameshort;
	/**是否在用*/
	@Excel(name="是否在用")
	private java.lang.String isactive;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String memo;
	/**排序*/
	@Excel(name="排序")
	private java.lang.Integer sortindex;
	/**图片*/
	@Excel(name="图片")
	private java.lang.String photopath;
	/**功能链接*/
	@Excel(name="功能链接")
	private java.lang.String url;
	/**分组*/
	@Excel(name="分组")
	private java.lang.String groupflag;
	
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
	 *@return: java.lang.String  业务名称
	 */
	@Column(name ="BUSINAME",nullable=true,length=50)
	public java.lang.String getBusiname(){
		return this.businame;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务名称
	 */
	public void setBusiname(java.lang.String businame){
		this.businame = businame;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业务简称
	 */
	@Column(name ="BUSINAMESHORT",nullable=true,length=20)
	public java.lang.String getBusinameshort(){
		return this.businameshort;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务简称
	 */
	public void setBusinameshort(java.lang.String businameshort){
		this.businameshort = businameshort;
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
	 *@return: java.lang.String  图片
	 */
	@Column(name ="PHOTOPATH",nullable=true,length=100)
	public java.lang.String getPhotopath(){
		return this.photopath;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片
	 */
	public void setPhotopath(java.lang.String photopath){
		this.photopath = photopath;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  功能链接
	 */
	@Column(name ="URL",nullable=true,length=200)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分组
	 */
	@Column(name ="GROUPFLAG",nullable=true,length=20)
	public java.lang.String getGroupflag(){
		return this.groupflag;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分组
	 */
	public void setGroupflag(java.lang.String groupflag){
		this.groupflag = groupflag;
	}
}
