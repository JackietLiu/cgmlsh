package configtools.tbsynclog.service;
import configtools.tbsynclog.entity.TBSyncLogEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBSyncLogServiceI extends CommonService{
	
 	public void delete(TBSyncLogEntity entity) throws Exception;
 	
 	public Serializable save(TBSyncLogEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBSyncLogEntity entity) throws Exception;
 	
}
