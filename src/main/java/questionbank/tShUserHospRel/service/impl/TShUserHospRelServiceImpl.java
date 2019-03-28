package questionbank.tShUserHospRel.service.impl;
import questionbank.tShUserHospRel.service.TShUserHospRelServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import questionbank.tShUserHospRel.entity.TShUserHospRelEntity;
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

@Service("tShUserHospRelService")
@Transactional
public class TShUserHospRelServiceImpl extends CommonServiceImpl implements TShUserHospRelServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(TShUserHospRelEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(TShUserHospRelEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(TShUserHospRelEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
 	
}