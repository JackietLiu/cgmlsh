package questionbank.tShHospDrugListHistory.service;
import questionbank.tShHospDrugListHistory.entity.TShHospDrugListHistoryEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TShHospDrugListHistoryServiceI extends CommonService{
	
 	public void delete(TShHospDrugListHistoryEntity entity) throws Exception;
 	
 	public Serializable save(TShHospDrugListHistoryEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TShHospDrugListHistoryEntity entity) throws Exception;
 	
}
