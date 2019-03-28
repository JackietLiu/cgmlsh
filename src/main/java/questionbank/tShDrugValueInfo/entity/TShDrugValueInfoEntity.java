package questionbank.tShDrugValueInfo.entity;

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
 * @Description: 一致性评价药品清单
 * @author onlineGenerator
 * @date 2019-02-26 16:39:59
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_sh_drug_value_info", schema = "")
@SuppressWarnings("serial")
public class TShDrugValueInfoEntity implements java.io.Serializable {
	/**id*/
	private String id;
	/**批准文号*/
	@Excel(name="批准文号",width=15)
	private String registerno;
	/**产品编号*/
	@Excel(name="产品编号",width=15)
	private String buyno;
	/**药品名称*/
	@Excel(name="药品名称",width=15)
	private String commonname;
	/**drugform*/
	@Excel(name="drugform",width=15)
	private String drugform;
	/**规格*/
	@Excel(name="规格",width=15)
	private String gg;
	/**生产厂家*/
	@Excel(name="生产厂家",width=15)
	private String enterprisename;
	/**南通入围结果*/
	@Excel(name="南通入围结果",width=15)
	private String ntresult;
	/**江苏入围结果*/
	@Excel(name="江苏入围结果",width=15)
	private String jsresult;
	/**国家基药*/
	@Excel(name="国家基药",width=15)
	private String isbasedrug;
	/**更新人名称*/
	private String updateName;
	/**更新日期*/
	private Date updateDate;
	/**创建日期*/
	private Date createDate;
	/**创建人名称*/
	private String createName;
	/**购进单价*/
	@Excel(name="购进单价",width=15)
	private BigDecimal inprice;
	
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

	@Column(name ="REGISTERNO",nullable=true,length=40)
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
	 *@return: java.lang.String  产品编号
	 */

	@Column(name ="BUYNO",nullable=true,length=20)
	public String getBuyno(){
		return this.buyno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品编号
	 */
	public void setBuyno(String buyno){
		this.buyno = buyno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  药品名称
	 */

	@Column(name ="COMMONNAME",nullable=true,length=100)
	public String getCommonname(){
		return this.commonname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  药品名称
	 */
	public void setCommonname(String commonname){
		this.commonname = commonname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  drugform
	 */

	@Column(name ="DRUGFORM",nullable=true,length=20)
	public String getDrugform(){
		return this.drugform;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  drugform
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  生产厂家
	 */

	@Column(name ="ENTERPRISENAME",nullable=true,length=100)
	public String getEnterprisename(){
		return this.enterprisename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  生产厂家
	 */
	public void setEnterprisename(String enterprisename){
		this.enterprisename = enterprisename;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  南通入围结果
	 */

	@Column(name ="NTRESULT",nullable=true,length=20)
	public String getNtresult(){
		return this.ntresult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  南通入围结果
	 */
	public void setNtresult(String ntresult){
		this.ntresult = ntresult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  江苏入围结果
	 */

	@Column(name ="JSRESULT",nullable=true,length=20)
	public String getJsresult(){
		return this.jsresult;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  江苏入围结果
	 */
	public void setJsresult(String jsresult){
		this.jsresult = jsresult;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  国家基药
	 */

	@Column(name ="ISBASEDRUG",nullable=true,length=20)
	public String getIsbasedrug(){
		return this.isbasedrug;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  国家基药
	 */
	public void setIsbasedrug(String isbasedrug){
		this.isbasedrug = isbasedrug;
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
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  购进单价
	 */

	@Column(name ="INPRICE",nullable=true,scale=2,length=10)
	public BigDecimal getInprice(){
		return this.inprice;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  购进单价
	 */
	public void setInprice(BigDecimal inprice){
		this.inprice = inprice;
	}
}