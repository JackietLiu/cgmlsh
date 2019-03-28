package configtools.tbconfig.service.impl;
import configtools.tbconfig.service.TbConfigDetailServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import configtools.tbconfig.entity.TbConfigDetailEntity;
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

@Service("tbConfigDetailService")
@Transactional
public class TbConfigDetailServiceImpl extends CommonServiceImpl implements TbConfigDetailServiceI {

	
 	public void delete(TbConfigDetailEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(TbConfigDetailEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(TbConfigDetailEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(TbConfigDetailEntity t) throws Exception{
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
	private void doUpdateBus(TbConfigDetailEntity t) throws Exception{
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
	private void doDelBus(TbConfigDetailEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(TbConfigDetailEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("confid", t.getConfid());
		map.put("deptid", t.getDeptid());
		map.put("userid", t.getUserid());
		map.put("roleid", t.getRoleid());
		map.put("code", t.getCode());
		map.put("codedetail", t.getCodedetail());
		map.put("thevalue", t.getThevalue());
		map.put("isactive", t.getIsactive());
		map.put("memo", t.getMemo());
		map.put("entid", t.getEntid());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,TbConfigDetailEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{confid}",String.valueOf(t.getConfid()));
 		sql  = sql.replace("#{deptid}",String.valueOf(t.getDeptid()));
 		sql  = sql.replace("#{userid}",String.valueOf(t.getUserid()));
 		sql  = sql.replace("#{roleid}",String.valueOf(t.getRoleid()));
 		sql  = sql.replace("#{code}",String.valueOf(t.getCode()));
 		sql  = sql.replace("#{codedetail}",String.valueOf(t.getCodedetail()));
 		sql  = sql.replace("#{thevalue}",String.valueOf(t.getThevalue()));
 		sql  = sql.replace("#{isactive}",String.valueOf(t.getIsactive()));
 		sql  = sql.replace("#{memo}",String.valueOf(t.getMemo()));
 		sql  = sql.replace("#{entid}",String.valueOf(t.getEntid()));
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
					javaInter.execute("tb_config_detail",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}