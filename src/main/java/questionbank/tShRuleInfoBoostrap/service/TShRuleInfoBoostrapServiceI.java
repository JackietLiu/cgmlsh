package questionbank.tShRuleInfoBoostrap.service;
import questionbank.tShRuleInfoBoostrap.entity.TShRuleInfoBoostrapEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TShRuleInfoBoostrapServiceI extends CommonService{
	
 	public void delete(TShRuleInfoBoostrapEntity entity) throws Exception;
 	
 	public Serializable save(TShRuleInfoBoostrapEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TShRuleInfoBoostrapEntity entity) throws Exception;
 	
}
