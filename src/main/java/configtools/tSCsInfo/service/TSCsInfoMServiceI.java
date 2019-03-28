package configtools.tSCsInfo.service;
import configtools.tSCsInfo.entity.TSCsInfoMEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TSCsInfoMServiceI extends CommonService{
	
 	public void delete(TSCsInfoMEntity entity) throws Exception;
 	
 	public Serializable save(TSCsInfoMEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TSCsInfoMEntity entity) throws Exception;
 	
}
