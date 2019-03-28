package configtools.tbconfig.service;
import configtools.tbconfig.entity.TbConfigDetailEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TbConfigDetailServiceI extends CommonService{
	
 	public void delete(TbConfigDetailEntity entity) throws Exception;
 	
 	public Serializable save(TbConfigDetailEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TbConfigDetailEntity entity) throws Exception;
 	
}
