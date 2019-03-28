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
 * @Description: 滚动图片信息
 * @author onlineGenerator
 * @date 2018-12-15 09:57:59
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_qb_sliderimages", schema = "")
@SuppressWarnings("serial")
public class TQbSliderimagesEntity implements java.io.Serializable {
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
	/**组名*/
	@Excel(name="组名",width=15)
	private java.lang.String groupname;
	/**地址*/
	@Excel(name="地址",width=15)
	private java.lang.String imgurl;
	/**标题*/
	@Excel(name="标题",width=15)
	private java.lang.String imgtitle;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String memo;
	/**说明*/
	@Excel(name="说明",width=15)
	private java.lang.String imgdesc;
	/**在用*/
	@Excel(name="在用",width=15,dicCode="isactive")
	private java.lang.String isactive;
	
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
	 *@return: java.lang.String  组名
	 */

	@Column(name ="GROUPNAME",nullable=true,length=40)
	public java.lang.String getGroupname(){
		return this.groupname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  组名
	 */
	public void setGroupname(java.lang.String groupname){
		this.groupname = groupname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地址
	 */

	@Column(name ="IMGURL",nullable=true,length=100)
	public java.lang.String getImgurl(){
		return this.imgurl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地址
	 */
	public void setImgurl(java.lang.String imgurl){
		this.imgurl = imgurl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  标题
	 */

	@Column(name ="IMGTITLE",nullable=true,length=20)
	public java.lang.String getImgtitle(){
		return this.imgtitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  标题
	 */
	public void setImgtitle(java.lang.String imgtitle){
		this.imgtitle = imgtitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="MEMO",nullable=true,length=50)
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
	 *@return: java.lang.String  说明
	 */

	@Column(name ="IMGDESC",nullable=true,length=50)
	public java.lang.String getImgdesc(){
		return this.imgdesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  说明
	 */
	public void setImgdesc(java.lang.String imgdesc){
		this.imgdesc = imgdesc;
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
}