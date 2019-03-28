package questionbank.tShDrugInfoJs.service;
import questionbank.tShDrugInfoJs.entity.TShDrugInfoJsEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TShDrugInfoJsServiceI extends CommonService{
	
 	public void delete(TShDrugInfoJsEntity entity) throws Exception;
 	
 	public Serializable save(TShDrugInfoJsEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TShDrugInfoJsEntity entity) throws Exception;
 	
}
