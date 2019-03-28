package weixin.guanjia.busionline.service.impl;
import weixin.guanjia.busionline.service.TQbSliderimagesServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import weixin.guanjia.busionline.entity.TQbSliderimagesEntity;
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

@Service("tQbSliderimagesService")
@Transactional
public class TQbSliderimagesServiceImpl extends CommonServiceImpl implements TQbSliderimagesServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(TQbSliderimagesEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(TQbSliderimagesEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(TQbSliderimagesEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
 	
}