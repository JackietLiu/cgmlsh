package configtools.tSMyupload.service;
import configtools.tSMyupload.entity.TSMyuploadEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TSMyuploadServiceI extends CommonService{
	
 	public void delete(TSMyuploadEntity entity) throws Exception;
 	
 	public Serializable save(TSMyuploadEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TSMyuploadEntity entity) throws Exception;
 	
}
