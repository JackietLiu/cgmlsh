package configtools.tSCsInfo.service;
import configtools.tSCsInfo.entity.TSCsInfoDEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TSCsInfoDServiceI extends CommonService{
	
 	public void delete(TSCsInfoDEntity entity) throws Exception;
 	
 	public Serializable save(TSCsInfoDEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TSCsInfoDEntity entity) throws Exception;
 	
}
