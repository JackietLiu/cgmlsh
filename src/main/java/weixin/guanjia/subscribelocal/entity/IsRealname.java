package weixin.guanjia.subscribelocal.entity;

import org.jeecgframework.p3.core.common.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;

import weixin.guanjia.subscribelocal.service.WeixinSubscribeLocalServiceI;

/**
 * 是否实名
 * @author Administrator
 *
 */
public class IsRealname {
	@Autowired
	private static WeixinSubscribeLocalServiceI weixinSubscribeLocalService;
	public static boolean  isRealname(String openid){
		WeixinSubscribeLocalEntity weixinloc = weixinSubscribeLocalService.findUniqueByProperty(WeixinSubscribeLocalEntity.class, "id", openid);
		if(weixinloc==null){
			return false;
		}else{
			if(StringUtil.notEmpty(weixinloc.getRealname())){
				return true;
			}else{
				return false;
			}
		}
	}
	public static boolean  notRealname(String openid){
		//WeixinSubscribeLocalEntity weixinloc = weixinSubscribeLocalService.findUniqueByProperty(WeixinSubscribeLocalEntity.class, "id", openid);
		String sql = "select * from weixin_subscribe_local where id='"+openid+"'";
		WeixinSubscribeLocalEntity weixinloc = 
					weixinSubscribeLocalService.findUniqueByProperty(WeixinSubscribeLocalEntity.class, "id", openid);
		if(weixinloc==null){
			return true;
		}else{
			if(StringUtil.notEmpty(weixinloc.getRealname())){
				return false;
			}else{
				return true;
			}
		}
	}

}
