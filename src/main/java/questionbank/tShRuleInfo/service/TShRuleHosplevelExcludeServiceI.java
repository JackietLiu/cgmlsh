package questionbank.tShRuleInfo.service;
import questionbank.tShRuleInfo.entity.TShRuleHosplevelExcludeEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TShRuleHosplevelExcludeServiceI extends CommonService{
	
 	public void delete(TShRuleHosplevelExcludeEntity entity) throws Exception;
 	
 	public Serializable save(TShRuleHosplevelExcludeEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TShRuleHosplevelExcludeEntity entity) throws Exception;
 	
}
