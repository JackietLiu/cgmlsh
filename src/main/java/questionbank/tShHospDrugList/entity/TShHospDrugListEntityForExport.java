package questionbank.tShHospDrugList.entity;

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
 * @Description: 医院上传
 * @author onlineGenerator
 * @date 2019-09-02 11:38:39
 * @version V1.0
 *
 */
@Entity
@Table(name = "t_sh_hosp_drug_list", schema = "")
@SuppressWarnings("serial")
public class TShHospDrugListEntityForExport implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**批准文号*/
	@Excel(name="批准文号",width=15)
	private java.lang.String registerno;
	/**合同名称*/
	@Excel(name="项目名称",width=15)
	private java.lang.String contractname;
	/**交易场*/
	@Excel(name="交易场",width=15)
	private java.lang.String place;
	/**采购序号*/
	@Excel(name="采购序号",width=15)
	private java.lang.String buyno;
	/**药品名称*/
	@Excel(name="通用名",width=15)
	private java.lang.String commonname;
	/**商品名*/
	@Excel(name="商品名",width=15)
	private java.lang.String tradename;
	/**剂型*/
	@Excel(name="剂型",width=15)
	private java.lang.String drugform;
	/**药品规格*/
	@Excel(name="规格",width=15)
	private java.lang.String gg;
	/**转换比*/
	@Excel(name="转换比",width=15)
	private java.lang.Integer rationnum;
	/**单位*/
	@Excel(name="单位",width=15)
	private java.lang.String pcs;
	/**包装材质*/
	@Excel(name="包装材质",width=15)
	private java.lang.String pkccz;
	/**厂家*/
	@Excel(name="生产企业",width=15)
	private java.lang.String enterprisename;
	/**购进单价*/
	@Excel(name="供应价",width=15)
	private java.lang.Double inprice;
	/**最小单位报价*/
	@Excel(name="最小单位报价",width=15)
	private java.lang.String minunitprice;
	/**入库数量*/
	//@Excel(name="入库数量",width=15)
	private java.lang.Double innum;
	/**产品备注*/
	@Excel(name="基药",width=15)
	private java.lang.String drugmemo;
	/**评审编号*/
	@Excel(name="评审编号",width=15)
	private java.lang.String groupno;
	/**评审分组*/
	@Excel(name="评审分组",width=15)
	private java.lang.String groupname;
	/**导入批号*/
	//@Excel(name="导入批号",width=15)
	private java.lang.String auditno;
	/**创建日期*/
	private java.util.Date createDate;
	/**创建人名称*/
	private java.lang.String createName;
	/**医院ID*/
	//@Excel(name="医院ID",width=15,dictTable ="t_sh_hospital",dicCode ="id",dicText ="hospnameshort")
	private java.lang.String hospid;
	/**更新日期*/
	private java.util.Date updateDate;
	/**更新人名称*/
	private java.lang.String updateName;

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

	@Column(name ="BUYNO",nullable=true,length=50)
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
	 *@return: java.lang.String  药品名称
	 */

	@Column(name ="COMMONNAME",nullable=true,length=100)
	public java.lang.String getCommonname(){
		return this.commonname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  药品名称
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
	 *@return: java.lang.String  药品规格
	 */

	@Column(name ="GG",nullable=true,length=100)
	public java.lang.String getGg(){
		return this.gg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  药品规格
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
	 *@return: java.lang.String  单位
	 */

	@Column(name ="PCS",nullable=true,length=20)
	public java.lang.String getPcs(){
		return this.pcs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位
	 */
	public void setPcs(java.lang.String pcs){
		this.pcs = pcs;
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
	 *@return: java.lang.String  厂家
	 */

	@Column(name ="ENTERPRISENAME",nullable=true,length=255)
	public java.lang.String getEnterprisename(){
		return this.enterprisename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  厂家
	 */
	public void setEnterprisename(java.lang.String enterprisename){
		this.enterprisename = enterprisename;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  购进单价
	 */

	@Column(name ="INPRICE",nullable=true,scale=2,length=10)
	public java.lang.Double getInprice(){
		return this.inprice;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  购进单价
	 */
	public void setInprice(java.lang.Double inprice){
		this.inprice = inprice;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  最小单位报价
	 */

	@Column(name ="MINUNITPRICE",nullable=true,length=20)
	public java.lang.String getMinunitprice(){
		return this.minunitprice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  最小单位报价
	 */
	public void setMinunitprice(java.lang.String minunitprice){
		this.minunitprice = minunitprice;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  入库数量
	 */

	@Column(name ="INNUM",nullable=true,scale=2,length=11)
	public java.lang.Double getInnum(){
		return this.innum;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  入库数量
	 */
	public void setInnum(java.lang.Double innum){
		this.innum = innum;
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
	 *@return: java.lang.String  评审编号
	 */

	@Column(name ="GROUPNO",nullable=true,length=40)
	public java.lang.String getGroupno(){
		return this.groupno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  评审编号
	 */
	public void setGroupno(java.lang.String groupno){
		this.groupno = groupno;
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
	 *@return: java.lang.String  导入批号
	 */

	@Column(name ="AUDITNO",nullable=true,length=20)
	public java.lang.String getAuditno(){
		return this.auditno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  导入批号
	 */
	public void setAuditno(java.lang.String auditno){
		this.auditno = auditno;
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
	 *@return: java.lang.String  医院ID
	 */

	@Column(name ="HOSPID",nullable=true,length=40)
	public java.lang.String getHospid(){
		return this.hospid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  医院ID
	 */
	public void setHospid(java.lang.String hospid){
		this.hospid = hospid;
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
}
