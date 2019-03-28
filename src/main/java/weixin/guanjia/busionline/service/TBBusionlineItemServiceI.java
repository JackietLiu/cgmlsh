package weixin.guanjia.busionline.service;
import weixin.guanjia.busionline.entity.TBBusionlineItemEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TBBusionlineItemServiceI extends CommonService{
	
 	public void delete(TBBusionlineItemEntity entity) throws Exception;
 	
 	public Serializable save(TBBusionlineItemEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TBBusionlineItemEntity entity) throws Exception;
 	
}
