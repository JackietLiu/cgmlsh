package questionbank.tShRuleInfo.entity;

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
 * @Description: 审核规则信息
 * @author onlineGenerator
 * @date 2019-03-06 19:38:57
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_sh_rule_info", schema = "")
@SuppressWarnings("serial")
public class TShRuleInfoEntity implements java.io.Serializable {
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
	/**规则名称*/
	@Excel(name="规则名称",width=15)
	private java.lang.String rulename;
	/**规则描述*/
	@Excel(name="规则描述",width=15)
	private java.lang.String ruledesc;
	/**结果描述*/
	@Excel(name="结果描述",width=15)
	private java.lang.String resultdesc;
	/**规则语句*/
	@Excel(name="规则语句",width=15,dictTable ="t_sh_rule_info_proc",dicCode ="procmysql",dicText ="procname")
	private java.lang.String rulesql;
	/**在用*/
	@Excel(name="在用",width=15,dicCode="isactive")
	private java.lang.String isactive;
	/**排序*/
	@Excel(name="排序",width=15)
	private java.lang.Integer sortindex;
	/**明细语句*/
	@Excel(name="明细语句",width=15)
	private java.lang.String detailsql;
	/**参数*/
	@Excel(name="参数",width=15)
	private java.lang.String parms;
	/**不合规提示*/
	@Excel(name="不合规提示",width=15)
	private java.lang.String allresultdeschaserror;
	/**合规提示*/
	@Excel(name="合规提示",width=15)
	private java.lang.String allresultdescnoerror;
	/**项目分值*/
	@Excel(name="项目分值",width=15)
	private java.lang.Double itemscore;
	/**明细分值*/
	@Excel(name="明细分值",width=15)
	private java.lang.Double detailscore;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String memo;
	private String scorerule;
	@Column(name ="scorerule",nullable=true,length=200)
	public String getScorerule() {
		return scorerule;
	}

	public void setScorerule(String scorerule) {
		this.scorerule = scorerule;
	}


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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  规则名称
	 */

	@Column(name ="RULENAME",nullable=true,length=40)
	public java.lang.String getRulename(){
		return this.rulename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  规则名称
	 */
	public void setRulename(java.lang.String rulename){
		this.rulename = rulename;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  规则描述
	 */

	@Column(name ="RULEDESC",nullable=true,length=100)
	public java.lang.String getRuledesc(){
		return this.ruledesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  规则描述
	 */
	public void setRuledesc(java.lang.String ruledesc){
		this.ruledesc = ruledesc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结果描述
	 */

	@Column(name ="RESULTDESC",nullable=true,length=100)
	public java.lang.String getResultdesc(){
		return this.resultdesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结果描述
	 */
	public void setResultdesc(java.lang.String resultdesc){
		this.resultdesc = resultdesc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  规则语句
	 */

	@Column(name ="RULESQL",nullable=true,length=500)
	public java.lang.String getRulesql(){
		return this.rulesql;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  规则语句
	 */
	public void setRulesql(java.lang.String rulesql){
		this.rulesql = rulesql;
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
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  排序
	 */

	@Column(name ="SORTINDEX",nullable=true,length=10)
	public java.lang.Integer getSortindex(){
		return this.sortindex;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  排序
	 */
	public void setSortindex(java.lang.Integer sortindex){
		this.sortindex = sortindex;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  明细语句
	 */

	@Column(name ="DETAILSQL",nullable=true,length=1000)
	public java.lang.String getDetailsql(){
		return this.detailsql;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  明细语句
	 */
	public void setDetailsql(java.lang.String detailsql){
		this.detailsql = detailsql;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参数
	 */

	@Column(name ="PARMS",nullable=true,length=200)
	public java.lang.String getParms(){
		return this.parms;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参数
	 */
	public void setParms(java.lang.String parms){
		this.parms = parms;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  不合规提示
	 */

	@Column(name ="ALLRESULTDESCHASERROR",nullable=true,length=100)
	public java.lang.String getAllresultdeschaserror(){
		return this.allresultdeschaserror;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  不合规提示
	 */
	public void setAllresultdeschaserror(java.lang.String allresultdeschaserror){
		this.allresultdeschaserror = allresultdeschaserror;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合规提示
	 */

	@Column(name ="ALLRESULTDESCNOERROR",nullable=true,length=100)
	public java.lang.String getAllresultdescnoerror(){
		return this.allresultdescnoerror;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合规提示
	 */
	public void setAllresultdescnoerror(java.lang.String allresultdescnoerror){
		this.allresultdescnoerror = allresultdescnoerror;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  项目分值
	 */

	@Column(name ="ITEMSCORE",nullable=true,scale=2,length=5)
	public java.lang.Double getItemscore(){
		return this.itemscore;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  项目分值
	 */
	public void setItemscore(java.lang.Double itemscore){
		this.itemscore = itemscore;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  明细分值
	 */

	@Column(name ="DETAILSCORE",nullable=true,scale=2,length=5)
	public java.lang.Double getDetailscore(){
		return this.detailscore;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  明细分值
	 */
	public void setDetailscore(java.lang.Double detailscore){
		this.detailscore = detailscore;
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
}