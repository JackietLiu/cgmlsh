package questionbank.tShRoleRegionMatch.service;
import questionbank.tShRoleRegionMatch.entity.TShRoleRegionMatchEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TShRoleRegionMatchServiceI extends CommonService{
	
 	public void delete(TShRoleRegionMatchEntity entity) throws Exception;
 	
 	public Serializable save(TShRoleRegionMatchEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TShRoleRegionMatchEntity entity) throws Exception;
 	
}
