package questionbank.tShHospImportBack.entity;

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
 * @Description: 提交驳回记录
 * @author onlineGenerator
 * @date 2019-08-22 14:48:27
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_sh_hosp_import_back", schema = "")
@SuppressWarnings("serial")
public class TShHospImportBackEntity implements java.io.Serializable {
	/**id*/
	private String id;
	/**驳回人*/
	@Excel(name="驳回人",width=15,dictTable ="t_s_base_user",dicCode ="id",dicText ="realname")
	private String userid;
	/**驳回日期*/
	@Excel(name="驳回日期",width=15,format = "yyyy-MM-dd")
	private Date backdate;
	/**被驳回医院*/
	@Excel(name="被驳回医院",width=15,dictTable ="t_sh_hospital",dicCode ="id",dicText ="hospnameshort")
	private String hospid;
	/**上传编号*/
	@Excel(name="上传编号",width=15)
	private String auditno;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=40)
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
	 *@return: java.lang.String  驳回人
	 */

	@Column(name ="USERID",nullable=true,length=40)
	public String getUserid(){
		return this.userid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  驳回人
	 */
	public void setUserid(String userid){
		this.userid = userid;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  驳回日期
	 */

	@Column(name ="BACKDATE",nullable=true)
	public Date getBackdate(){
		return this.backdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  驳回日期
	 */
	public void setBackdate(Date backdate){
		this.backdate = backdate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  被驳回医院
	 */

	@Column(name ="HOSPID",nullable=true,length=40)
	public String getHospid(){
		return this.hospid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  被驳回医院
	 */
	public void setHospid(String hospid){
		this.hospid = hospid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  上传编号
	 */

	@Column(name ="AUDITNO",nullable=true,length=40)
	public String getAuditno(){
		return this.auditno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上传编号
	 */
	public void setAuditno(String auditno){
		this.auditno = auditno;
	}
}
