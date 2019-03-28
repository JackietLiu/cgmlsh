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
 * @date 2017-06-17 15:58:28
 * @version V1.0   
 *
 */

public class WeixinSubscribeLocalEntityMobel implements java.io.Serializable {
	private java.lang.String id;
	/*private java.lang.String openid;*/
	private java.lang.String nickname;
	private java.lang.String sex;
	private java.lang.String city;
	private java.lang.String province;
	private java.lang.String country;
	private java.lang.String headimgurl;
	private java.util.Date subscribetime;
	private java.lang.String subscribe;
	private java.lang.String language;
	private java.lang.String unionid;
	private java.lang.String remark;
	private java.lang.String groupid;
	private java.lang.Integer integral;
	private java.lang.String idcard;
	
	
	
	
	
	public java.lang.String getIdcard() {
		return idcard;
	}

	public void setIdcard(java.lang.String idcard) {
		this.idcard = idcard;
	}

	/**
	 * 积分
	 * @return
	 */
	
	
	public java.lang.Integer getIntegral() {
		return integral;
	}

	public void setIntegral(java.lang.Integer integral) {
		this.integral = integral;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
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
	 *@return: java.lang.String  用户标识
	 *//*
	public java.lang.String getOpenid(){
		return this.openid;
	}

	*//**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户标识
	 *//*
	public void setOpenid(java.lang.String openid){
		this.openid = openid;
	}*/
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  呢称
	 */
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
}
