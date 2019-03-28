package questionbank.tShUserHospRel.service;
import questionbank.tShUserHospRel.entity.TShUserHospRelEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TShUserHospRelServiceI extends CommonService{
	
 	public void delete(TShUserHospRelEntity entity) throws Exception;
 	
 	public Serializable save(TShUserHospRelEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TShUserHospRelEntity entity) throws Exception;
 	
}
