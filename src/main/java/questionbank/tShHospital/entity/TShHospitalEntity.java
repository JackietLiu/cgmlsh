package questionbank.tShHospital.entity;

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
 * @Description: 医院信息
 * @author onlineGenerator
 * @date 2019-03-05 13:30:00
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_sh_hospital", schema = "")
@SuppressWarnings("serial")
public class TShHospitalEntity implements java.io.Serializable {

	/**代码*/
	@Excel(name="代码",width=15)
	private String hospcode;
	/**等级*/
	@Excel(name="等级",width=15,dicCode="hosplevel")
	private String hosplevel;
	/**医院名称*/
	@Excel(name="医院名称",width=15)
	private String hospname;
	/**英文名*/
	@Excel(name="英文名",width=15)
	private String hospnameeng;
	/**简称*/
	@Excel(name="简称",width=15)
	private String hospnameshort;
	/**id*/
	private String id;
	/**在用*/
	//@Excel(name="在用",width=15,dicCode="isactive")
	private String isactive;
	/**图标名称*/
	//@Excel(name="图标名称",width=15)
	private String logofilename;
	/**备注*/
	//@Excel(name="备注",width=15)
	private String memo;
	/**注册码*/
	//@Excel(name="注册码",width=15)
	private String regcode;
	/**电话*/
	@Excel(name="电话",width=15)
	private String tel;
	/**百分比*/
	@Excel(name="百分比",width=15)
	private BigDecimal thepercent;
	/**更新日期*/
	private Date updateDate;
	/**更新人名称*/
	private String updateName;
	/**系统版本*/
	//@Excel(name="系统版本",width=15)
	private String versionname;
	/**地址*/
	@Excel(name="地址",width=15)
	private String address;
	/**创建日期*/
	private Date createDate;
	/**创建人名称*/
	private String createName;
	/**传真*/
	@Excel(name="传真",width=15)
	private String fax;
	@Excel(name="所在区域",width = 15)
	private String regionid;


	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地址
	 */

	@Column(name ="ADDRESS",nullable=true,length=100)
	public String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地址
	 */
	public void setAddress(String address){
		this.address = address;
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
	 *@return: java.lang.String  传真
	 */

	@Column(name ="FAX",nullable=true,length=20)
	public String getFax(){
		return this.fax;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  传真
	 */
	public void setFax(String fax){
		this.fax = fax;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代码
	 */

	@Column(name ="HOSPCODE",nullable=false,length=40)
	public String getHospcode(){
		return this.hospcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  代码
	 */
	public void setHospcode(String hospcode){
		this.hospcode = hospcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  等级
	 */

	@Column(name ="HOSPLEVEL",nullable=true,length=30)
	public String getHosplevel(){
		return this.hosplevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  等级
	 */
	public void setHosplevel(String hosplevel){
		this.hosplevel = hosplevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  医院名称
	 */

	@Column(name ="HOSPNAME",nullable=true,length=100)
	public String getHospname(){
		return this.hospname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  医院名称
	 */
	public void setHospname(String hospname){
		this.hospname = hospname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  英文名
	 */

	@Column(name ="HOSPNAMEENG",nullable=true,length=100)
	public String getHospnameeng(){
		return this.hospnameeng;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  英文名
	 */
	public void setHospnameeng(String hospnameeng){
		this.hospnameeng = hospnameeng;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  简称
	 */

	@Column(name ="HOSPNAMESHORT",nullable=true,length=50)
	public String getHospnameshort(){
		return this.hospnameshort;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  简称
	 */
	public void setHospnameshort(String hospnameshort){
		this.hospnameshort = hospnameshort;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "assigned")

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
	 *@return: java.lang.String  在用
	 */

	@Column(name ="ISACTIVE",nullable=true,length=10)
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
	 *@return: java.lang.String  图标名称
	 */

	@Column(name ="LOGOFILENAME",nullable=true,length=200)
	public String getLogofilename(){
		return this.logofilename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图标名称
	 */
	public void setLogofilename(String logofilename){
		this.logofilename = logofilename;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="MEMO",nullable=true,length=250)
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
	 *@return: java.lang.String  注册码
	 */

	@Column(name ="REGCODE",nullable=true,length=200)
	public String getRegcode(){
		return this.regcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  注册码
	 */
	public void setRegcode(String regcode){
		this.regcode = regcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电话
	 */

	@Column(name ="TEL",nullable=true,length=20)
	public String getTel(){
		return this.tel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电话
	 */
	public void setTel(String tel){
		this.tel = tel;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  百分比
	 */

	@Column(name ="THEPERCENT",nullable=true,scale=2,length=5)
	public BigDecimal getThepercent(){
		return this.thepercent;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  百分比
	 */
	public void setThepercent(BigDecimal thepercent){
		this.thepercent = thepercent;
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  系统版本
	 */

	@Column(name ="VERSIONNAME",nullable=true,length=20)
	public String getVersionname(){
		return this.versionname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  系统版本
	 */
	public void setVersionname(String versionname){
		this.versionname = versionname;
	}

	public String getRegionid() {
		return this.regionid;
	}

	public void setRegionid(String regionid) {
		this.regionid = regionid;
	}
}
