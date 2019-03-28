package questionbank.tShNotfitruleDetail.service;
import questionbank.tShNotfitruleDetail.entity.TShNotfitruleDetailEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TShNotfitruleDetailServiceI extends CommonService{
	
 	public void delete(TShNotfitruleDetailEntity entity) throws Exception;
 	
 	public Serializable save(TShNotfitruleDetailEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TShNotfitruleDetailEntity entity) throws Exception;
 	
}
