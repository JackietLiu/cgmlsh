package configtools.tbconfig.service;
import configtools.tbconfig.entity.VsConfigEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface VsConfigServiceI extends CommonService{
	
 	public void delete(VsConfigEntity entity) throws Exception;
 	
 	public Serializable save(VsConfigEntity entity) throws Exception;
 	
 	public void saveOrUpdate(VsConfigEntity entity) throws Exception;
 	
}
