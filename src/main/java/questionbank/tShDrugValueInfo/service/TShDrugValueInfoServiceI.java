package questionbank.tShDrugValueInfo.service;
import questionbank.tShDrugValueInfo.entity.TShDrugValueInfoEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TShDrugValueInfoServiceI extends CommonService{
	
 	public void delete(TShDrugValueInfoEntity entity) throws Exception;
 	
 	public Serializable save(TShDrugValueInfoEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TShDrugValueInfoEntity entity) throws Exception;
 	
}
