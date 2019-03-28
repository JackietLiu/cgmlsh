package weixin.guanjia.core.entity.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import net.sf.json.JSONObject;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.guanjia.core.util.WeixinUtil;

public class WeiXinUserList {
	public WeiXinUserList()
	{
		
	}
	// 总关注用户数
	private int total;
	// 获取的OpenId个数
	private int count;
	// OpenId列表
	private WeiXinUserData data;
	// 最后一个用户的openid
	private String next_openid;
	private WeixinAccountServiceI weixinAccountService;
	
	public List<String> findWeiXinUserList(List<String> openidList,String token, String nextOpenid){	
		WeiXinUserList weixinUserList = null;
		//String accessToken = weixinAccountService.getAccessToken();
		String url = WeixinUtil.get_user_list_url.replace("ACCESS_TOKEN",token);
		if(StringUtils.isNotBlank(nextOpenid)){
			url=url.replace(next_openid, nextOpenid);
		}
		else
		{
			url=url.replace("&next_openid=NEXT_OPENID", "");
		}
		
		JSONObject jsonObject= new JSONObject();
		
		jsonObject = WeixinUtil.httpRequest(url, "POST","");
	
		if(jsonObject != null){
			try {
				weixinUserList = new Gson().fromJson(jsonObject.toString(), WeiXinUserList.class);
			//	openidList = new ArrayList<String>();
				if(weixinUserList.getCount() <= 10000 && weixinUserList.getCount() >0){
					openidList.addAll(weixinUserList.getData().getOpenid());
				}else{
					//如果大于10000的,继续查询
					findWeiXinUserList(openidList,token, weixinUserList.getNext_openid());
				}	
			} catch (JsonSyntaxException e) {
				openidList = null;
			}
		}
		return openidList;
	}
		
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public WeiXinUserData getData() {
		return data;
	}
	public void setData(WeiXinUserData data) {
		this.data = data;
	}
	public String getNext_openid() {
		return next_openid;
	}
	public void setNext_openid(String next_openid) {
		this.next_openid = next_openid;
	}	
	
}
