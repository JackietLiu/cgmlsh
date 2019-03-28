package configtools.tbconfig.service.impl;
import configtools.tbconfig.service.VsConfigServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import configtools.tbconfig.entity.VsConfigEntity;
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

@Service("vsConfigService")
@Transactional
public class VsConfigServiceImpl extends CommonServiceImpl implements VsConfigServiceI {

	
 	public void delete(VsConfigEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(VsConfigEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(VsConfigEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(VsConfigEntity t) throws Exception{
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
	private void doUpdateBus(VsConfigEntity t) throws Exception{
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
	private void doDelBus(VsConfigEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(VsConfigEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("entid", t.getEntid());
		map.put("id", t.getId());
		map.put("deptid", t.getDeptid());
		map.put("userid", t.getUserid());
		map.put("userid2", t.getUserid2());
		map.put("roleid", t.getRoleid());
		map.put("managerlevel", t.getManagerlevel());
		map.put("code", t.getCode());
		map.put("confname", t.getConfname());
		map.put("thevalue", t.getThevalue());
		map.put("groupflag", t.getGroupflag());
		map.put("codedetail", t.getCodedetail());
		map.put("category", t.getCategory());
		map.put("configlevel", t.getConfiglevel());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,VsConfigEntity t){
 		sql  = sql.replace("#{entid}",String.valueOf(t.getEntid()));
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{deptid}",String.valueOf(t.getDeptid()));
 		sql  = sql.replace("#{userid}",String.valueOf(t.getUserid()));
 		sql  = sql.replace("#{userid2}",String.valueOf(t.getUserid2()));
 		sql  = sql.replace("#{roleid}",String.valueOf(t.getRoleid()));
 		sql  = sql.replace("#{managerlevel}",String.valueOf(t.getManagerlevel()));
 		sql  = sql.replace("#{code}",String.valueOf(t.getCode()));
 		sql  = sql.replace("#{confname}",String.valueOf(t.getConfname()));
 		sql  = sql.replace("#{thevalue}",String.valueOf(t.getThevalue()));
 		sql  = sql.replace("#{groupflag}",String.valueOf(t.getGroupflag()));
 		sql  = sql.replace("#{codedetail}",String.valueOf(t.getCodedetail()));
 		sql  = sql.replace("#{category}",String.valueOf(t.getCategory()));
 		sql  = sql.replace("#{configlevel}",String.valueOf(t.getConfiglevel()));
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
					javaInter.execute("vs_config",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}