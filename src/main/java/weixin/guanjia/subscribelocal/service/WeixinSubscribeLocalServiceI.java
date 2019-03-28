package weixin.guanjia.subscribelocal.service;
import weixin.guanjia.subscribelocal.entity.WeixinSubscribeLocalEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface WeixinSubscribeLocalServiceI extends CommonService{
	
 	public void delete(WeixinSubscribeLocalEntity entity) throws Exception;
 	
 	public Serializable save(WeixinSubscribeLocalEntity entity) throws Exception;
 	
 	public void saveOrUpdate(WeixinSubscribeLocalEntity entity) throws Exception;
 	
}
