package configtools.tbexportsql.service;
import configtools.tbexportsql.entity.TBExportSqlEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBExportSqlServiceI extends CommonService{
	
 	public void delete(TBExportSqlEntity entity) throws Exception;
 	
 	public Serializable save(TBExportSqlEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBExportSqlEntity entity) throws Exception;
 	
}
