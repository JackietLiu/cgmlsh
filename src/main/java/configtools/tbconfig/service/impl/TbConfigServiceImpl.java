package configtools.tbconfig.service.impl;
import configtools.tbconfig.service.TbConfigServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import configtools.tbconfig.entity.TbConfigEntity;
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

@Service("tbConfigService")
@Transactional
public class TbConfigServiceImpl extends CommonServiceImpl implements TbConfigServiceI {

	
 	public void delete(TbConfigEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(TbConfigEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(TbConfigEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(TbConfigEntity t) throws Exception{
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
	private void doUpdateBus(TbConfigEntity t) throws Exception{
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
	private void doDelBus(TbConfigEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(TbConfigEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("code", t.getCode());
		map.put("confname", t.getConfname());
		map.put("confdescribe", t.getConfdescribe());
		map.put("defaultvalue", t.getDefaultvalue());
		map.put("memo", t.getMemo());
		map.put("managerlevel", t.getManagerlevel());
		map.put("groupflag", t.getGroupflag());
		map.put("groupflagname", t.getGroupflagname());
		map.put("category", t.getCategory());
		map.put("valuetype", t.getValuetype());
		map.put("valuescope", t.getValuescope());
		map.put("isactive", t.getIsactive());
		map.put("stopdate", t.getStopdate());
		map.put("sortindex", t.getSortindex());
		map.put("issynclocal", t.getIssynclocal());
		map.put("update_name", t.getUpdateName());
		map.put("update_date", t.getUpdateDate());
		map.put("create_date", t.getCreateDate());
		map.put("create_name", t.getCreateName());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,TbConfigEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{code}",String.valueOf(t.getCode()));
 		sql  = sql.replace("#{confname}",String.valueOf(t.getConfname()));
 		sql  = sql.replace("#{confdescribe}",String.valueOf(t.getConfdescribe()));
 		sql  = sql.replace("#{defaultvalue}",String.valueOf(t.getDefaultvalue()));
 		sql  = sql.replace("#{memo}",String.valueOf(t.getMemo()));
 		sql  = sql.replace("#{managerlevel}",String.valueOf(t.getManagerlevel()));
 		sql  = sql.replace("#{groupflag}",String.valueOf(t.getGroupflag()));
 		sql  = sql.replace("#{groupflagname}",String.valueOf(t.getGroupflagname()));
 		sql  = sql.replace("#{category}",String.valueOf(t.getCategory()));
 		sql  = sql.replace("#{valuetype}",String.valueOf(t.getValuetype()));
 		sql  = sql.replace("#{valuescope}",String.valueOf(t.getValuescope()));
 		sql  = sql.replace("#{isactive}",String.valueOf(t.getIsactive()));
 		sql  = sql.replace("#{stopdate}",String.valueOf(t.getStopdate()));
 		sql  = sql.replace("#{sortindex}",String.valueOf(t.getSortindex()));
 		sql  = sql.replace("#{issynclocal}",String.valueOf(t.getIssynclocal()));
 		sql  = sql.replace("#{update_name}",String.valueOf(t.getUpdateName()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{create_date}",String.valueOf(t.getCreateDate()));
 		sql  = sql.replace("#{create_name}",String.valueOf(t.getCreateName()));
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
					javaInter.execute("tb_config",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}