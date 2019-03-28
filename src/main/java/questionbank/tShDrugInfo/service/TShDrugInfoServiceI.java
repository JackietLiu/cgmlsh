package questionbank.tShDrugInfo.service;
import questionbank.tShDrugInfo.entity.TShDrugInfoEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TShDrugInfoServiceI extends CommonService{
	
 	public void delete(TShDrugInfoEntity entity) throws Exception;
 	
 	public Serializable save(TShDrugInfoEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TShDrugInfoEntity entity) throws Exception;
 	
}
