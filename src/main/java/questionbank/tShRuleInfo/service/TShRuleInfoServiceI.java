package questionbank.tShRuleInfo.service;
import questionbank.tShRuleInfo.entity.TShRuleInfoEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TShRuleInfoServiceI extends CommonService{
	
 	public void delete(TShRuleInfoEntity entity) throws Exception;
 	
 	public Serializable save(TShRuleInfoEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TShRuleInfoEntity entity) throws Exception;
 	
}
