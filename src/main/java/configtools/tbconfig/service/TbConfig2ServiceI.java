package configtools.tbconfig.service;
import configtools.tbconfig.entity.TbConfig2Entity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TbConfig2ServiceI extends CommonService{
	
 	public void delete(TbConfig2Entity entity) throws Exception;
 	
 	public Serializable save(TbConfig2Entity entity) throws Exception;
 	
 	public void saveOrUpdate(TbConfig2Entity entity) throws Exception;
 	
}
