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
		/**合同名称*/
		@Excel(name="合同名称",width=15)
		private String contractname;
		/**交易场*/
		@Excel(name="交易场",width=15)
		private String place;
		/**采购序号*/
		@Excel(name="采购序号",width=15)
		private String buyno;
		/**评审分组*/

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
		/**最小包装单位*/
		@Excel(name="最小包装单位",width=15)
		private String minpcs;
		/**包装材质*/
		@Excel(name="包装材质",width=15)
		private String pkccz;
		/**生产企业全称*/
		@Excel(name="生产企业全称",width=15)
		private String enterprisename;
		/**供应价*/
		@Excel(name="供应价",width=15)
		private String suppprice;
		@Excel(name="最小单位报价",width=15)
		private String minunitprice;
		/**状态*/
		@Excel(name="状态",width=15,dicCode="isactive")
		private String isactive;
		/**产品备注*/
		@Excel(name="产品备注",width=15)
		private String drugmemo;

		/**批准文号*/
		@Excel(name="批准文号",width=15)
		private String registerno;

		/**药品类别*/
		@Excel(name="药品类别",width=15,dictTable ="t_sh_drug_class",dicCode ="id",dicText ="classname")
		private String drugclass;
		@Excel(name="评审编号",width=15)
		private String groupno;
		@Excel(name="评审分组",width=15)
		private String groupname;
		@Excel(name="最高分",width=15)
		private  String topscore;
		/**经销商全称*/
		//@Excel(name="经销商全称",width=15)
		private String agencyname;

		/**经销商简称*/
		//@Excel(name="经销商简称",width=15)
		private String agencyshortname;

		/**备注*/
//	@Excel(name="备注",width=15)
		private String memo;


		/**公司商品代码*/
		//@Excel(name="公司商品代码",width=15)
		private String drugcodeent;
		/**更新人名称*/
		private String updateName;
		/**更新日期*/
		private Date updateDate;
		/**创建日期*/
		private Date createDate;
		/**创建人名称*/
		private String createName;


		@Column(name ="MINUNITPRICE",nullable=false)
		public String getMinunitprice() {
			return minunitprice;
		}

		public void setMinunitprice(String minunitprice) {
			this.minunitprice = minunitprice;
		}



		@Column(name ="TOPSCORE",nullable=false)
		public String getTopscore() {
			return topscore;
		}

		public void setTopscore(String topscore) {
			this.topscore = topscore;
		}

		@Column(name ="GROUPNO",nullable=false)
		public String getGroupno() {
			return groupno;
		}

		public void setGroupno(String groupno) {
			this.groupno = groupno;
		}


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
		 *@return: java.lang.String  合同名称
		 */

		@Column(name ="CONTRACTNAME",nullable=true,length=100)
		public String getContractname(){
			return this.contractname;
		}

		/**
		 *方法: 设置java.lang.String
		 *@param: java.lang.String  合同名称
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
		 *@return: java.lang.String  最小包装单位
		 */

		@Column(name ="MINPCS",nullable=true,length=20)
		public String getMinpcs(){
			return this.minpcs;
		}

		/**
		 *方法: 设置java.lang.String
		 *@param: java.lang.String  最小包装单位
		 */
		public void setMinpcs(String minpcs){
			this.minpcs = minpcs;
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
		 *@return: java.lang.String  生产企业全称
		 */

		@Column(name ="ENTERPRISENAME",nullable=true,length=255)
		public String getEnterprisename(){
			return this.enterprisename;
		}

		/**
		 *方法: 设置java.lang.String
		 *@param: java.lang.String  生产企业全称
		 */
		public void setEnterprisename(String enterprisename){
			this.enterprisename = enterprisename;
		}
		/**
		 *方法: 取得java.lang.String
		 *@return: java.lang.String  供应价
		 */

		@Column(name ="SUPPPRICE",nullable=true,length=10)
		public String getSuppprice(){
			return this.suppprice;
		}

		/**
		 *方法: 设置java.lang.String
		 *@param: java.lang.String  供应价
		 */
		public void setSuppprice(String suppprice){
			this.suppprice = suppprice;
		}
		/**
		 *方法: 取得java.lang.String
		 *@return: java.lang.String  状态
		 */

		@Column(name ="ISACTIVE",nullable=true,length=20)
		public String getIsactive(){
			return this.isactive;
		}

		/**
		 *方法: 设置java.lang.String
		 *@param: java.lang.String  状态
		 */
		public void setIsactive(String isactive){
			this.isactive = isactive;
		}
		/**
		 *方法: 取得java.lang.String
		 *@return: java.lang.String  经销商简称
		 */

		@Column(name ="AGENCYSHORTNAME",nullable=true,length=20)
		public String getAgencyshortname(){
			return this.agencyshortname;
		}

		/**
		 *方法: 设置java.lang.String
		 *@param: java.lang.String  经销商简称
		 */
		public void setAgencyshortname(String agencyshortname){
			this.agencyshortname = agencyshortname;
		}
		/**
		 *方法: 取得java.lang.String
		 *@return: java.lang.String  经销商全称
		 */

		@Column(name ="AGENCYNAME",nullable=true,length=100)
		public String getAgencyname(){
			return this.agencyname;
		}

		/**
		 *方法: 设置java.lang.String
		 *@param: java.lang.String  经销商全称
		 */
		public void setAgencyname(String agencyname){
			this.agencyname = agencyname;
		}
		/**
		 *方法: 取得java.lang.String
		 *@return: java.lang.String  备注
		 */

		@Column(name ="MEMO",nullable=true,length=100)
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
		 *@return: java.lang.String  产品备注
		 */

		@Column(name ="DRUGMEMO",nullable=true,length=20)
		public String getDrugmemo(){
			return this.drugmemo;
		}

		/**
		 *方法: 设置java.lang.String
		 *@param: java.lang.String  产品备注
		 */
		public void setDrugmemo(String drugmemo){
			this.drugmemo = drugmemo;
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
		 *@return: java.lang.String  公司商品代码
		 */

		@Column(name ="DRUGCODEENT",nullable=true,length=20)
		public String getDrugcodeent(){
			return this.drugcodeent;
		}

		/**
		 *方法: 设置java.lang.String
		 *@param: java.lang.String  公司商品代码
		 */
		public void setDrugcodeent(String drugcodeent){
			this.drugcodeent = drugcodeent;
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
		 *方法: 取得java.lang.String
		 *@return: java.lang.String  药品类别
		 */

		@Column(name ="DRUGCLASS",nullable=true,length=40)
		public String getDrugclass(){
			return this.drugclass;
		}

		/**
		 *方法: 设置java.lang.String
		 *@param: java.lang.String  药品类别
		 */
		public void setDrugclass(String drugclass){
			this.drugclass = drugclass;
		}


	/**南通入围结果*/
//	@Excel(name="南通入围结果",width=15)
	private String ntresult;
	/**江苏入围结果*/
//	@Excel(name="江苏入围结果",width=15)
	private String jsresult;
	/**国家基药*/
//	@Excel(name="国家基药",width=15)
	private String isbasedrug;

	/**购进单价*/
	//@Excel(name="购进单价",width=15)
	private BigDecimal inprice;

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