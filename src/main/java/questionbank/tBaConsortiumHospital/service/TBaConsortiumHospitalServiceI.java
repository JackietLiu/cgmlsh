package questionbank.tBaConsortiumHospital.service;
import questionbank.tBaConsortiumHospital.entity.TBaConsortiumHospitalEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBaConsortiumHospitalServiceI extends CommonService{
	
 	public void delete(TBaConsortiumHospitalEntity entity) throws Exception;
 	
 	public Serializable save(TBaConsortiumHospitalEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBaConsortiumHospitalEntity entity) throws Exception;
 	
}
