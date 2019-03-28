package configtools.tbconfig.service;
import configtools.tbconfig.entity.TbConfigEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TbConfigServiceI extends CommonService{
	
 	public void delete(TbConfigEntity entity) throws Exception;
 	
 	public Serializable save(TbConfigEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TbConfigEntity entity) throws Exception;
 	
}
