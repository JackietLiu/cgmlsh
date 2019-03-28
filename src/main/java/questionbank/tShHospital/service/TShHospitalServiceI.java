package questionbank.tShHospital.service;
import questionbank.tShHospital.entity.TShHospitalEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TShHospitalServiceI extends CommonService{
	
 	public void delete(TShHospitalEntity entity) throws Exception;
 	
 	public Serializable save(TShHospitalEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TShHospitalEntity entity) throws Exception;
 	
}
