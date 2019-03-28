package questionbank.tShHospDrugList.service;
import questionbank.tShHospDrugList.entity.TShHospDrugListEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TShHospDrugListServiceI extends CommonService{
	
 	public void delete(TShHospDrugListEntity entity) throws Exception;
 	
 	public Serializable save(TShHospDrugListEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TShHospDrugListEntity entity) throws Exception;
 	
}
