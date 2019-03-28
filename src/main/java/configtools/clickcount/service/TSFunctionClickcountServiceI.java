package configtools.clickcount.service;
import configtools.clickcount.entity.TSFunctionClickcountEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TSFunctionClickcountServiceI extends CommonService{
	
 	public void delete(TSFunctionClickcountEntity entity) throws Exception;
 	
 	public Serializable save(TSFunctionClickcountEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TSFunctionClickcountEntity entity) throws Exception;
 	

}
