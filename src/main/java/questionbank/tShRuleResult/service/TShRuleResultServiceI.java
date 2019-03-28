package questionbank.tShRuleResult.service;
import questionbank.tShRuleResult.entity.TShRuleResultEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TShRuleResultServiceI extends CommonService{
	
 	public void delete(TShRuleResultEntity entity) throws Exception;
 	
 	public Serializable save(TShRuleResultEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TShRuleResultEntity entity) throws Exception;
 	
}
