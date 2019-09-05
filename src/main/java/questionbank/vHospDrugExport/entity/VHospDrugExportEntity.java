package questionbank.vHospDrugExport.entity;

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
 * @Description: 管理员导出
 * @author onlineGenerator
 * @date 2019-09-03 15:40:24
 * @version V1.0   
 *
 */
@Entity
@Table(name = "v_hosp_drug_export", schema = "")
@SuppressWarnings("serial")
public class VHospDrugExportEntity implements java.io.Serializable {
	/**id*/
	private String id;
	/**批准文号*/
	@Excel(name="批准文号",width=15)
	private String registerno;
	/**项目名称*/
	@Excel(name="项目名称",width=15)
	private String contractname;
	/**交易场*/
	@Excel(name="交易场",width=15)
	private String place;
	/**采购序号*/
	@Excel(name="采购序号",width=15)
	private String buyno;
	/**通用名*/
	@Excel(name="通用名",width=15)
	private String commonname;
	/**商品名*/
	@Excel(name="商品名",width=15)
	private String tradename;
	/**剂型*/
	@Excel(name="剂型",width=15)
	private String drugform;
	/**规格*/
	@Excel(name="规格",width=15)
	private String gg;
	/**转换比*/
	@Excel(name="转换比",width=15)
	private Integer rationnum;
	/**单位*/
	@Excel(name="单位",width=15)
	private String pcs;
	/**包装材质*/
	@Excel(name="包装材质",width=15)
	private String pkccz;
	/**生产企业*/
	@Excel(name="生产企业",width=15)
	private String enterprisename;
	/**供应价*/
	@Excel(name="供应价",width=15)
	private Double inprice;
	/**最小单位报价*/
	@Excel(name="最小单位报价",width=15)
	private String minunitprice;
	/**国基标注*/
	@Excel(name="国基标注",width=15)
	private String drugmemo;
	/**入库数量*/
	//@Excel(name="入库数量",width=15)
	private Double innum;
	/**导入批号*/
	//@Excel(name="导入批号",width=15)
	private String auditno;
	/**评审编号*/
	@Excel(name="评审编号",width=15)
	private String groupno;
	/**评审分组*/
	@Excel(name="评审分组",width=15)
	private String groupname;
	/**代码*/
	@Excel(name="代码",width=15)
	private String hospcode;
	/**医院名称*/
	@Excel(name="医院名称",width=15)
	private String hospname;
	/**城市名*/
	@Excel(name="城市名",width=15)
	private String name;
	
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
	 *@return: java.lang.String  批准文号
	 */

	@Column(name ="REGISTERNO",nullable=true,length=100)
	public String getRegisterno(){
		return this.registerno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  批准文号
	 */
	public void setRegisterno(String registerno){
		this.registerno = registerno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目名称
	 */

	@Column(name ="CONTRACTNAME",nullable=true,length=100)
	public String getContractname(){
		return this.contractname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目名称
	 */
	public void setContractname(String contractname){
		this.contractname = contractname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交易场
	 */

	@Column(name ="PLACE",nullable=true,length=50)
	public String getPlace(){
		return this.place;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交易场
	 */
	public void setPlace(String place){
		this.place = place;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  采购序号
	 */

	@Column(name ="BUYNO",nullable=true,length=50)
	public String getBuyno(){
		return this.buyno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  采购序号
	 */
	public void setBuyno(String buyno){
		this.buyno = buyno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  通用名
	 */

	@Column(name ="COMMONNAME",nullable=true,length=100)
	public String getCommonname(){
		return this.commonname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  通用名
	 */
	public void setCommonname(String commonname){
		this.commonname = commonname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品名
	 */

	@Column(name ="TRADENAME",nullable=true,length=20)
	public String getTradename(){
		return this.tradename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品名
	 */
	public void setTradename(String tradename){
		this.tradename = tradename;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  剂型
	 */

	@Column(name ="DRUGFORM",nullable=true,length=20)
	public String getDrugform(){
		return this.drugform;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  剂型
	 */
	public void setDrugform(String drugform){
		this.drugform = drugform;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  规格
	 */

	@Column(name ="GG",nullable=true,length=100)
	public String getGg(){
		return this.gg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  规格
	 */
	public void setGg(String gg){
		this.gg = gg;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  转换比
	 */

	@Column(name ="RATIONNUM",nullable=true,length=10)
	public Integer getRationnum(){
		return this.rationnum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  转换比
	 */
	public void setRationnum(Integer rationnum){
		this.rationnum = rationnum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位
	 */

	@Column(name ="PCS",nullable=true,length=20)
	public String getPcs(){
		return this.pcs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位
	 */
	public void setPcs(String pcs){
		this.pcs = pcs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  包装材质
	 */

	@Column(name ="PKCCZ",nullable=true,length=50)
	public String getPkccz(){
		return this.pkccz;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  包装材质
	 */
	public void setPkccz(String pkccz){
		this.pkccz = pkccz;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  生产企业
	 */

	@Column(name ="ENTERPRISENAME",nullable=true,length=255)
	public String getEnterprisename(){
		return this.enterprisename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  生产企业
	 */
	public void setEnterprisename(String enterprisename){
		this.enterprisename = enterprisename;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  供应价
	 */

	@Column(name ="INPRICE",nullable=true,scale=2,length=10)
	public Double getInprice(){
		return this.inprice;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  供应价
	 */
	public void setInprice(Double inprice){
		this.inprice = inprice;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  最小单位报价
	 */

	@Column(name ="MINUNITPRICE",nullable=true,length=20)
	public String getMinunitprice(){
		return this.minunitprice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  最小单位报价
	 */
	public void setMinunitprice(String minunitprice){
		this.minunitprice = minunitprice;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  国基标注
	 */

	@Column(name ="DRUGMEMO",nullable=true,length=20)
	public String getDrugmemo(){
		return this.drugmemo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  国基标注
	 */
	public void setDrugmemo(String drugmemo){
		this.drugmemo = drugmemo;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  入库数量
	 */

	@Column(name ="INNUM",nullable=true,scale=2,length=11)
	public Double getInnum(){
		return this.innum;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  入库数量
	 */
	public void setInnum(Double innum){
		this.innum = innum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  导入批号
	 */

	@Column(name ="AUDITNO",nullable=true,length=20)
	public String getAuditno(){
		return this.auditno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  导入批号
	 */
	public void setAuditno(String auditno){
		this.auditno = auditno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  评审编号
	 */

	@Column(name ="GROUPNO",nullable=true,length=40)
	public String getGroupno(){
		return this.groupno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  评审编号
	 */
	public void setGroupno(String groupno){
		this.groupno = groupno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  评审分组
	 */

	@Column(name ="GROUPNAME",nullable=true,length=20)
	public String getGroupname(){
		return this.groupname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  评审分组
	 */
	public void setGroupname(String groupname){
		this.groupname = groupname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  代码
	 */

	@Column(name ="HOSPCODE",nullable=true,length=40)
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
	 *@return: java.lang.String  城市名
	 */

	@Column(name ="NAME",nullable=true,length=50)
	public String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  城市名
	 */
	public void setName(String name){
		this.name = name;
	}
}
