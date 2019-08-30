package questionbank.tShHospImportBack.service.impl;
import questionbank.tShHospImportBack.service.TShHospImportBackServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import questionbank.tShHospImportBack.entity.TShHospImportBackEntity;
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

@Service("tShHospImportBackService")
@Transactional
public class TShHospImportBackServiceImpl extends CommonServiceImpl implements TShHospImportBackServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
 	public void delete(TShHospImportBackEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(TShHospImportBackEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(TShHospImportBackEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
 	
}