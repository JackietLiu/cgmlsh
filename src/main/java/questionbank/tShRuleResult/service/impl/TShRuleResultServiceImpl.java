package questionbank.tShRuleResult.service.impl;
import questionbank.tShRuleResult.service.TShRuleResultServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import questionbank.tShRuleResult.entity.TShRuleResultEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Service("tShRuleResultService")
@Transactional
public class TShRuleResultServiceImpl extends CommonServiceImpl implements TShRuleResultServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(TShRuleResultEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(TShRuleResultEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(TShRuleResultEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
 	
}