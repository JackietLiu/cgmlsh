package weixin.guanjia.subscribelocal.entity;

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
 * @Description: weixin_subscribe_local
 * @author onlineGenerator
 * @date 2017-08-24 23:50:37
 * @version V1.0   
 *
 */
@Entity
@Table(name = "weixin_subscribe_local", schema = "")
@SuppressWarnings("serial")
public class WeixinSubscribeLocalEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**呢称*/
	@Excel(name="呢称")
	private java.lang.String nickname;
	/**性别*/
	@Excel(name="性别")
	private java.lang.String sex;
	/**城市*/
	@Excel(name="城市")
	private java.lang.String city;
	/**省份*/
	@Excel(name="省份")
	private java.lang.String province;
	/**国籍*/
	@Excel(name="国籍")
	private java.lang.String country;
	/**图像*/
	@Excel(name="图像")
	private java.lang.String headimgurl;
	/**关注时间*/
	@Excel(name="关注时间" ,format = "yyyy-MM-dd")
	private java.util.Date subscribetime;
	/**是否关注*/
	@Excel(name="是否关注")
	private java.lang.String subscribe;
	/**语言*/
	@Excel(name="语言")
	private java.lang.String language;
	/**unionid*/
	@Excel(name="unionid")
	private java.lang.String unionid;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String remark;
	/**分组*/
	@Excel(name="分组")
	private java.lang.String groupid;
	/**真实姓名*/
	@Excel(name="真实姓名")
	private java.lang.String realname;
	/**身份证号*/
	@Excel(name="身份证号")
	private java.lang.String idcard;
	/**认证图片*/
	@Excel(name="认证图片")
	private java.lang.String photopath;
	/**手机号*/
	@Excel(name="手机号")
	private java.lang.String mobile;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String memo;
	/**审核日期*/
	@Excel(name="审核日期",format = "yyyy-MM-dd")
	private java.util.Date approvedate;
	/**审核人*/
	@Excel(name="审核人")
	private java.lang.String approvename;
	/**审核状态*/
	@Excel(name="审核状态")
	private java.lang.String approvestatus;
	 
	private java.lang.String sex1;
	private java.lang.String nickname2;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=50)
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
	 *@return: java.lang.String  呢称
	 */
	@Column(name ="NICKNAME",nullable=true,length=100)
	public java.lang.String getNickname(){
		return this.nickname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  呢称
	 */
	public void setNickname(java.lang.String nickname){
		this.nickname = nickname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */
	@Column(name ="SEX",nullable=true,length=10)
	public java.lang.String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setSex(java.lang.String sex){
		this.sex = sex;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  城市
	 */
	@Column(name ="CITY",nullable=true,length=50)
	public java.lang.String getCity(){
		return this.city;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  城市
	 */
	public void setCity(java.lang.String city){
		this.city = city;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  省份
	 */
	@Column(name ="PROVINCE",nullable=true,length=50)
	public java.lang.String getProvince(){
		return this.province;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  省份
	 */
	public void setProvince(java.lang.String province){
		this.province = province;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  国籍
	 */
	@Column(name ="COUNTRY",nullable=true,length=50)
	public java.lang.String getCountry(){
		return this.country;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  国籍
	 */
	public void setCountry(java.lang.String country){
		this.country = country;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图像
	 */
	@Column(name ="HEADIMGURL",nullable=true,length=200)
	public java.lang.String getHeadimgurl(){
		return this.headimgurl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图像
	 */
	public void setHeadimgurl(java.lang.String headimgurl){
		this.headimgurl = headimgurl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  关注时间
	 */
	@Column(name ="SUBSCRIBETIME",nullable=true)
	public java.util.Date getSubscribetime(){
		return this.subscribetime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  关注时间
	 */
	public void setSubscribetime(java.util.Date subscribetime){
		this.subscribetime = subscribetime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否关注
	 */
	@Column(name ="SUBSCRIBE",nullable=true,length=20)
	public java.lang.String getSubscribe(){
		return this.subscribe;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否关注
	 */
	public void setSubscribe(java.lang.String subscribe){
		this.subscribe = subscribe;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  语言
	 */
	@Column(name ="LANGUAGE",nullable=true,length=10)
	public java.lang.String getLanguage(){
		return this.language;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  语言
	 */
	public void setLanguage(java.lang.String language){
		this.language = language;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  unionid
	 */
	@Column(name ="UNIONID",nullable=true,length=200)
	public java.lang.String getUnionid(){
		return this.unionid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  unionid
	 */
	public void setUnionid(java.lang.String unionid){
		this.unionid = unionid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,length=200)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分组
	 */
	@Column(name ="GROUPID",nullable=true,length=100)
	public java.lang.String getGroupid(){
		return this.groupid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分组
	 */
	public void setGroupid(java.lang.String groupid){
		this.groupid = groupid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  真实姓名
	 */
	@Column(name ="REALNAME",nullable=true,length=50)
	public java.lang.String getRealname(){
		return this.realname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  真实姓名
	 */
	public void setRealname(java.lang.String realname){
		this.realname = realname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */
	@Column(name ="IDCARD",nullable=true,length=18)
	public java.lang.String getIdcard(){
		return this.idcard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setIdcard(java.lang.String idcard){
		this.idcard = idcard;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  认证图片
	 */
	@Column(name ="PHOTOPATH",nullable=true,length=100)
	public java.lang.String getPhotopath(){
		return this.photopath;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  认证图片
	 */
	public void setPhotopath(java.lang.String photopath){
		this.photopath = photopath;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  手机号
	 */
	@Column(name ="MOBILE",nullable=true,length=20)
	public java.lang.String getMobile(){
		return this.mobile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机号
	 */
	public void setMobile(java.lang.String mobile){
		this.mobile = mobile;
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  审核日期
	 */
	@Column(name ="APPROVEDATE",nullable=true,length=32)
	public java.util.Date getApprovedate(){
		return this.approvedate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  审核日期
	 */
	public void setApprovedate(java.util.Date approvedate){
		this.approvedate = approvedate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核人
	 */
	@Column(name ="APPROVENAME",nullable=true,length=50)
	public java.lang.String getApprovename(){
		return this.approvename;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核人
	 */
	public void setApprovename(java.lang.String approvename){
		this.approvename = approvename;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审核状态
	 */
	@Column(name ="APPROVESTATUS",nullable=true,length=20)
	public java.lang.String getApprovestatus(){
		return this.approvestatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核状态
	 */
	public void setApprovestatus(java.lang.String approvestatus){
		this.approvestatus = approvestatus;
	}
	 
   

	public java.lang.String getSex1() {
		return sex1;
	}

	public void setSex1(java.lang.String sex1) {
		this.sex1 = sex1;
	}

	public java.lang.String getNickname2() {
		return nickname2;
	}

	public void setNickname2(java.lang.String nickname2) {
		this.nickname2 = nickname2;
	}
}
