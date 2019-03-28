package questionbank.tShDrugInfoJs.service.impl;
import questionbank.tShDrugInfoJs.service.TShDrugInfoJs4importServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import questionbank.tShDrugInfoJs.entity.TShDrugInfoJs4importEntity;
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

@Service("tShDrugInfoJs4importService")
@Transactional
public class TShDrugInfoJs4importServiceImpl extends CommonServiceImpl implements TShDrugInfoJs4importServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
 	public void delete(TShDrugInfoJs4importEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(TShDrugInfoJs4importEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(TShDrugInfoJs4importEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
 	
}