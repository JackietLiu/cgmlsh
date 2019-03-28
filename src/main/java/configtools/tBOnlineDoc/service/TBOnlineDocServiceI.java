package configtools.tBOnlineDoc.service;
import configtools.tBOnlineDoc.entity.TBOnlineDocEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBOnlineDocServiceI extends CommonService{
	
 	public void delete(TBOnlineDocEntity entity) throws Exception;
 	
 	public Serializable save(TBOnlineDocEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBOnlineDocEntity entity) throws Exception;
 	
}
