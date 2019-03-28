package questionbank.tShDrugInfo.entity;

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
 * @Description: 药品目录维护
 * @author onlineGenerator
 * @date 2019-03-06 15:29:35
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_sh_drug_info", schema = "")
@SuppressWarnings("serial")
public class TShDrugInfoEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**合同名称*/
	@Excel(name="合同名称",width=15)
	private java.lang.String contractname;
	/**交易场*/
	@Excel(name="交易场",width=15)
	private java.lang.String place;
	/**采购序号*/
	@Excel(name="采购序号",width=15)
	private java.lang.String buyno;
	/**评审分组*/
	@Excel(name="评审分组",width=15)
	private java.lang.String groupname;
	/**通用名*/
	@Excel(name="通用名",width=15)
	private java.lang.String commonname;
	/**商品名*/
	@Excel(name="商品名",width=15)
	private java.lang.String tradename;
	/**剂型*/
	@Excel(name="剂型",width=15)
	private java.lang.String drugform;
	/**规格*/
	@Excel(name="规格",width=15)
	private java.lang.String gg;
	/**转换比*/
	@Excel(name="转换比",width=15)
	private java.lang.Integer rationnum;
	/**最小包装单位*/
	@Excel(name="最小包装单位",width=15)
	private java.lang.String minpcs;
	/**包装材质*/
	@Excel(name="包装材质",width=15)
	private java.lang.String pkccz;
	/**生产企业全称*/
	@Excel(name="生产企业全称",width=15)
	private java.lang.String enterprisename;
	/**供应价*/
	@Excel(name="供应价",width=15)
	private java.lang.String suppprice;
	/**状态*/
	@Excel(name="状态",width=15,dicCode="isactive")
	private java.lang.String isactive;
	/**经销商简称*/
	@Excel(name="经销商简称",width=15)
	private java.lang.String agencyshortname;
	/**经销商全称*/
	@Excel(name="经销商全称",width=15)
	private java.lang.String agencyname;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String memo;
	/**产品备注*/
	@Excel(name="产品备注",width=15)
	private java.lang.String drugmemo;
	/**批准文号*/
	@Excel(name="批准文号",width=15)
	private java.lang.String registerno;
	/**公司商品代码*/
	@Excel(name="公司商品代码",width=15)
	private java.lang.String drugcodeent;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新日期*/
	private java.util.Date updateDate;
	/**创建日期*/
	private java.util.Date createDate;
	/**创建人名称*/
	private java.lang.String createName;
	/**药品类别*/
	@Excel(name="药品类别",width=15,dictTable ="t_sh_drug_class",dicCode ="id",dicText ="classname")
	private java.lang.String drugclass;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=40)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同名称
	 */

	@Column(name ="CONTRACTNAME",nullable=true,length=100)
	public java.lang.String getContractname(){
		return this.contractname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同名称
	 */
	public void setContractname(java.lang.String contractname){
		this.contractname = contractname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交易场
	 */

	@Column(name ="PLACE",nullable=true,length=50)
	public java.lang.String getPlace(){
		return this.place;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交易场
	 */
	public void setPlace(java.lang.String place){
		this.place = place;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购序号
	 */

	@Column(name ="BUYNO",nullable=true,length=20)
	public java.lang.String getBuyno(){
		return this.buyno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购序号
	 */
	public void setBuyno(java.lang.String buyno){
		this.buyno = buyno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  评审分组
	 */

	@Column(name ="GROUPNAME",nullable=true,length=20)
	public java.lang.String getGroupname(){
		return this.groupname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  评审分组
	 */
	public void setGroupname(java.lang.String groupname){
		this.groupname = groupname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  通用名
	 */

	@Column(name ="COMMONNAME",nullable=true,length=100)
	public java.lang.String getCommonname(){
		return this.commonname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  通用名
	 */
	public void setCommonname(java.lang.String commonname){
		this.commonname = commonname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品名
	 */

	@Column(name ="TRADENAME",nullable=true,length=20)
	public java.lang.String getTradename(){
		return this.tradename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品名
	 */
	public void setTradename(java.lang.String tradename){
		this.tradename = tradename;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  剂型
	 */

	@Column(name ="DRUGFORM",nullable=true,length=20)
	public java.lang.String getDrugform(){
		return this.drugform;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  剂型
	 */
	public void setDrugform(java.lang.String drugform){
		this.drugform = drugform;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  规格
	 */

	@Column(name ="GG",nullable=true,length=100)
	public java.lang.String getGg(){
		return this.gg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  规格
	 */
	public void setGg(java.lang.String gg){
		this.gg = gg;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  转换比
	 */

	@Column(name ="RATIONNUM",nullable=true,length=10)
	public java.lang.Integer getRationnum(){
		return this.rationnum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  转换比
	 */
	public void setRationnum(java.lang.Integer rationnum){
		this.rationnum = rationnum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  最小包装单位
	 */

	@Column(name ="MINPCS",nullable=true,length=20)
	public java.lang.String getMinpcs(){
		return this.minpcs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  最小包装单位
	 */
	public void setMinpcs(java.lang.String minpcs){
		this.minpcs = minpcs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  包装材质
	 */

	@Column(name ="PKCCZ",nullable=true,length=50)
	public java.lang.String getPkccz(){
		return this.pkccz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  包装材质
	 */
	public void setPkccz(java.lang.String pkccz){
		this.pkccz = pkccz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  生产企业全称
	 */

	@Column(name ="ENTERPRISENAME",nullable=true,length=255)
	public java.lang.String getEnterprisename(){
		return this.enterprisename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  生产企业全称
	 */
	public void setEnterprisename(java.lang.String enterprisename){
		this.enterprisename = enterprisename;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  供应价
	 */

	@Column(name ="SUPPPRICE",nullable=true,length=10)
	public java.lang.String getSuppprice(){
		return this.suppprice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  供应价
	 */
	public void setSuppprice(java.lang.String suppprice){
		this.suppprice = suppprice;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */

	@Column(name ="ISACTIVE",nullable=true,length=20)
	public java.lang.String getIsactive(){
		return this.isactive;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setIsactive(java.lang.String isactive){
		this.isactive = isactive;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  经销商简称
	 */

	@Column(name ="AGENCYSHORTNAME",nullable=true,length=20)
	public java.lang.String getAgencyshortname(){
		return this.agencyshortname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  经销商简称
	 */
	public void setAgencyshortname(java.lang.String agencyshortname){
		this.agencyshortname = agencyshortname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  经销商全称
	 */

	@Column(name ="AGENCYNAME",nullable=true,length=100)
	public java.lang.String getAgencyname(){
		return this.agencyname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  经销商全称
	 */
	public void setAgencyname(java.lang.String agencyname){
		this.agencyname = agencyname;
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
	 *@return: java.lang.String  产品备注
	 */

	@Column(name ="DRUGMEMO",nullable=true,length=20)
	public java.lang.String getDrugmemo(){
		return this.drugmemo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品备注
	 */
	public void setDrugmemo(java.lang.String drugmemo){
		this.drugmemo = drugmemo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  批准文号
	 */

	@Column(name ="REGISTERNO",nullable=true,length=100)
	public java.lang.String getRegisterno(){
		return this.registerno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  批准文号
	 */
	public void setRegisterno(java.lang.String registerno){
		this.registerno = registerno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司商品代码
	 */

	@Column(name ="DRUGCODEENT",nullable=true,length=20)
	public java.lang.String getDrugcodeent(){
		return this.drugcodeent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司商品代码
	 */
	public void setDrugcodeent(java.lang.String drugcodeent){
		this.drugcodeent = drugcodeent;
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

	@Column(name ="UPDATE_DATE",nullable=true)
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */

	@Column(name ="CREATE_DATE",nullable=true)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  药品类别
	 */

	@Column(name ="DRUGCLASS",nullable=true,length=40)
	public java.lang.String getDrugclass(){
		return this.drugclass;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  药品类别
	 */
	public void setDrugclass(java.lang.String drugclass){
		this.drugclass = drugclass;
	}
}