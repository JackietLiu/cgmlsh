package questionbank.tShHospImport.service;
import questionbank.tShHospImport.entity.TShHospImportEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TShHospImportServiceI extends CommonService{
	
 	public void delete(TShHospImportEntity entity) throws Exception;
 	
 	public Serializable save(TShHospImportEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TShHospImportEntity entity) throws Exception;
 	
}
