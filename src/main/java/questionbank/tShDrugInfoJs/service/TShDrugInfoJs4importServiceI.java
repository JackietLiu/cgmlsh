package questionbank.tShDrugInfoJs.service;
import questionbank.tShDrugInfoJs.entity.TShDrugInfoJs4importEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TShDrugInfoJs4importServiceI extends CommonService{
	
 	public void delete(TShDrugInfoJs4importEntity entity) throws Exception;
 	
 	public Serializable save(TShDrugInfoJs4importEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TShDrugInfoJs4importEntity entity) throws Exception;
 	
}
