package weixin.guanjia.busionline.service;
import weixin.guanjia.busionline.entity.TBBusionlineInfoEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBBusionlineInfoServiceI extends CommonService{
	
 	public void delete(TBBusionlineInfoEntity entity) throws Exception;
 	
 	public Serializable save(TBBusionlineInfoEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBBusionlineInfoEntity entity) throws Exception;
 	
}
