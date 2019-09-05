package questionbank.tShRuleExclude.service;
import questionbank.tShRuleExclude.entity.TShRuleExcludeEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TShRuleExcludeServiceI extends CommonService{
	
 	public void delete(TShRuleExcludeEntity entity) throws Exception;
 	
 	public Serializable save(TShRuleExcludeEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TShRuleExcludeEntity entity) throws Exception;
 	
}
