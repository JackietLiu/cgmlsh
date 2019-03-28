package weixin.guanjia.busionline.service;
import weixin.guanjia.busionline.entity.TQbSliderimagesEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TQbSliderimagesServiceI extends CommonService{
	
 	public void delete(TQbSliderimagesEntity entity) throws Exception;
 	
 	public Serializable save(TQbSliderimagesEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TQbSliderimagesEntity entity) throws Exception;
 	
}
