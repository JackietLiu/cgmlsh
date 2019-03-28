package weixin.guanjia.busionline.service.impl;
import weixin.guanjia.busionline.service.TBBusionlineItemServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import weixin.guanjia.busionline.entity.TBBusionlineItemEntity;
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

@Service("tBBusionlineItemService")
@Transactional
public class TBBusionlineItemServiceImpl extends CommonServiceImpl implements TBBusionlineItemServiceI {

	
 	public void delete(TBBusionlineItemEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(TBBusionlineItemEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(TBBusionlineItemEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(TBBusionlineItemEntity t) throws Exception{
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
	private void doUpdateBus(TBBusionlineItemEntity t) throws Exception{
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
	private void doDelBus(TBBusionlineItemEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(TBBusionlineItemEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("create_name", t.getCreateName());
		map.put("create_date", t.getCreateDate());
		map.put("update_name", t.getUpdateName());
		map.put("update_date", t.getUpdateDate());
		map.put("busionlineid", t.getBusionlineid());
		map.put("photopath", t.getPhotopath());
		map.put("itemname", t.getItemname());
		map.put("url", t.getUrl());
		map.put("sortindex", t.getSortindex());
		map.put("memo", t.getMemo());
		map.put("isactive", t.getIsactive());
		map.put("attachment1", t.getAttachment1());
		map.put("attachment2", t.getAttachment2());
		map.put("attachment3", t.getAttachment3());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,TBBusionlineItemEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{busionlineid}",String.valueOf(t.getBusionlineid()));
 		sql  = sql.replace("#{photopath}",String.valueOf(t.getPhotopath()));
 		sql  = sql.replace("#{itemname}",String.valueOf(t.getItemname()));
 		sql  = sql.replace("#{url}",String.valueOf(t.getUrl()));
 		sql  = sql.replace("#{sortindex}",String.valueOf(t.getSortindex()));
 		sql  = sql.replace("#{memo}",String.valueOf(t.getMemo()));
 		sql  = sql.replace("#{isactive}",String.valueOf(t.getIsactive()));
 		sql  = sql.replace("#{attachment1}",String.valueOf(t.getAttachment1()));
 		sql  = sql.replace("#{attachment2}",String.valueOf(t.getAttachment2()));
 		sql  = sql.replace("#{attachment3}",String.valueOf(t.getAttachment3()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
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
					javaInter.execute("t_b_busionline_item",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}