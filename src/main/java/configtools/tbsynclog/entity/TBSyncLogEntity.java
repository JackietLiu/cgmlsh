package configtools.tbsynclog.entity;

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
 * @Description: 同步日志信息
 * @author onlineGenerator
 * @date 2018-03-03 13:53:23
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_b_sync_log", schema = "")
@SuppressWarnings("serial")
public class TBSyncLogEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**同步人*/
	private java.lang.String createName;
	/**同步日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新日期*/
	private java.util.Date updateDate;
	/**同步表名*/
	@Excel(name="同步表名",width=15)
	private java.lang.String synctablename;
	/**同步描述*/
	@Excel(name="同步描述",width=15)
	private java.lang.String syncdesc;
	/**同步机器*/
	@Excel(name="同步机器",width=15)
	private java.lang.String syncip;
	
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
	 *@return: java.lang.String  同步人
	 */

	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  同步人
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  同步日期
	 */

	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  同步日期
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
	 *@return: java.lang.String  同步表名
	 */

	@Column(name ="SYNCTABLENAME",nullable=true,length=50)
	public java.lang.String getSynctablename(){
		return this.synctablename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  同步表名
	 */
	public void setSynctablename(java.lang.String synctablename){
		this.synctablename = synctablename;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  同步描述
	 */

	@Column(name ="SYNCDESC",nullable=true,length=100)
	public java.lang.String getSyncdesc(){
		return this.syncdesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  同步描述
	 */
	public void setSyncdesc(java.lang.String syncdesc){
		this.syncdesc = syncdesc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  同步机器
	 */

	@Column(name ="SYNCIP",nullable=true,length=20)
	public java.lang.String getSyncip(){
		return this.syncip;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  同步机器
	 */
	public void setSyncip(java.lang.String syncip){
		this.syncip = syncip;
	}
}
