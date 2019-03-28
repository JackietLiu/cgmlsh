package questionbank.tShDrugClass.service;
import questionbank.tShDrugClass.entity.TShDrugClassEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TShDrugClassServiceI extends CommonService{
	
 	public void delete(TShDrugClassEntity entity) throws Exception;
 	
 	public Serializable save(TShDrugClassEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TShDrugClassEntity entity) throws Exception;
 	
}
