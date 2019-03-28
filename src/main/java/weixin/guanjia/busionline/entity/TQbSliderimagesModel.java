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
@SuppressWarnings("serial")
public class TQbSliderimagesModel implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
 
	/**组名*/
	@Excel(name="组名",width=15)
	private java.lang.String groupname;
	/**地址*/
	@Excel(name="地址",width=15)
	private java.lang.String imgurl;
	/**标题*/
	@Excel(name="标题",width=15)
	private java.lang.String imgtitle;
 
	/**说明*/
	@Excel(name="说明",width=15)
	private java.lang.String imgdesc;
 
	
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
	 
}