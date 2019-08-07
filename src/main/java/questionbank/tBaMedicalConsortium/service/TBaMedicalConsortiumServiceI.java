package questionbank.tBaMedicalConsortium.service;
import questionbank.tBaMedicalConsortium.entity.TBaMedicalConsortiumEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBaMedicalConsortiumServiceI extends CommonService{
	
 	public void delete(TBaMedicalConsortiumEntity entity) throws Exception;
 	
 	public Serializable save(TBaMedicalConsortiumEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBaMedicalConsortiumEntity entity) throws Exception;
 	
}
