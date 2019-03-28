package questionbank.tShRuleInfo.service;
import questionbank.tShRuleInfo.entity.TShRuleInfoProcEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TShRuleInfoProcServiceI extends CommonService{
	
 	public void delete(TShRuleInfoProcEntity entity) throws Exception;
 	
 	public Serializable save(TShRuleInfoProcEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TShRuleInfoProcEntity entity) throws Exception;
 	
}
