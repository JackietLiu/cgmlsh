package configtools.tSCsInfo.service.impl;
import configtools.tSCsInfo.service.TSCsInfoMServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import configtools.tSCsInfo.entity.TSCsInfoMEntity;
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

import org.jeecgframework.minidao.util.FreemarkerParseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.jeecgframework.core.util.ResourceUtil;

@Service("tSCsInfoMService")
@Transactional
public class TSCsInfoMServiceImpl extends CommonServiceImpl implements TSCsInfoMServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
 	public void delete(TSCsInfoMEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(TSCsInfoMEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(TSCsInfoMEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
 	
}