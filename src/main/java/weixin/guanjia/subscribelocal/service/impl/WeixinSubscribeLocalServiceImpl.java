package weixin.guanjia.subscribelocal.service.impl;
import weixin.guanjia.subscribelocal.service.WeixinSubscribeLocalServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import weixin.guanjia.subscribelocal.entity.WeixinSubscribeLocalEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("weixinSubscribeLocalService")
@Transactional
public class WeixinSubscribeLocalServiceImpl extends CommonServiceImpl implements WeixinSubscribeLocalServiceI {

	
 	public void delete(WeixinSubscribeLocalEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(WeixinSubscribeLocalEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(WeixinSubscribeLocalEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(WeixinSubscribeLocalEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(WeixinSubscribeLocalEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(WeixinSubscribeLocalEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(WeixinSubscribeLocalEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("nickname", t.getNickname());
		map.put("sex", t.getSex());
		map.put("city", t.getCity());
		map.put("province", t.getProvince());
		map.put("country", t.getCountry());
		map.put("headimgurl", t.getHeadimgurl());
		map.put("subscribetime", t.getSubscribetime());
		map.put("subscribe", t.getSubscribe());
		map.put("language", t.getLanguage());
		map.put("unionid", t.getUnionid());
		map.put("remark", t.getRemark());
		map.put("groupid", t.getGroupid());
		map.put("realname", t.getRealname());
		map.put("idcard", t.getIdcard());
		map.put("photopath", t.getPhotopath());
		map.put("mobile", t.getMobile());
		map.put("memo", t.getMemo());
		map.put("approvedate", t.getApprovedate());
		map.put("approvename", t.getApprovename());
		map.put("approvestatus", t.getApprovestatus());
		 
		map.put("sex1", t.getSex1());	
		map.put("nickname2", t.getNickname2());	
		
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,WeixinSubscribeLocalEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{nickname}",String.valueOf(t.getNickname()));
 		sql  = sql.replace("#{sex}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{city}",String.valueOf(t.getCity()));
 		sql  = sql.replace("#{province}",String.valueOf(t.getProvince()));
 		sql  = sql.replace("#{country}",String.valueOf(t.getCountry()));
 		sql  = sql.replace("#{headimgurl}",String.valueOf(t.getHeadimgurl()));
 		sql  = sql.replace("#{subscribetime}",String.valueOf(t.getSubscribetime()));
 		sql  = sql.replace("#{subscribe}",String.valueOf(t.getSubscribe()));
 		sql  = sql.replace("#{language}",String.valueOf(t.getLanguage()));
 		sql  = sql.replace("#{unionid}",String.valueOf(t.getUnionid()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{groupid}",String.valueOf(t.getGroupid()));
 		sql  = sql.replace("#{realname}",String.valueOf(t.getRealname()));
 		sql  = sql.replace("#{idcard}",String.valueOf(t.getIdcard()));
 		sql  = sql.replace("#{photopath}",String.valueOf(t.getPhotopath()));
 		sql  = sql.replace("#{mobile}",String.valueOf(t.getMobile()));
 		sql  = sql.replace("#{memo}",String.valueOf(t.getMemo()));
 		sql  = sql.replace("#{approvedate}",String.valueOf(t.getApprovedate()));
 		sql  = sql.replace("#{approvename}",String.valueOf(t.getApprovename()));
 		sql  = sql.replace("#{approvestatus}",String.valueOf(t.getApprovestatus()));
 		 
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 	 
 		sql  = sql.replace("#{sex1}",String.valueOf(t.getSex1())); 
 		sql  = sql.replace("#{nickname2}",String.valueOf(t.getNickname2())); 
 		return sql;
 	}
 	
 	/**
	 * 执行JAVA增强
	 */
 	private void executeJavaExtend(String cgJavaType,String cgJavaValue,Map<String,Object> data) throws Exception {
 		if(StringUtil.isNotEmpty(cgJavaValue)){
			Object obj = null;
			try {
				if("class".equals(cgJavaType)){
					//因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
					obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
				}else if("spring".equals(cgJavaType)){
					obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
				}
				if(obj instanceof CgformEnhanceJavaInter){
					CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
					javaInter.execute("weixin_subscribe_local",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}