package questionbank.tShHospImportBack.service;
import questionbank.tShHospImportBack.entity.TShHospImportBackEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TShHospImportBackServiceI extends CommonService{
	
 	public void delete(TShHospImportBackEntity entity) throws Exception;
 	
 	public Serializable save(TShHospImportBackEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TShHospImportBackEntity entity) throws Exception;
 	
}
