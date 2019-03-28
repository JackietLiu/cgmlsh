package weixin.guanjia.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jeecgframework.web.system.service.SystemService;

import com.alibaba.fastjson.JSONException;
import com.google.gson.Gson;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.core.entity.common.AccessToken;
import weixin.guanjia.core.entity.common.WeiXinUserList;
 
import weixin.guanjia.core.entity.message.resp.Article;
import weixin.guanjia.core.entity.model.AccessTokenYw;
import weixin.util.WeiXinConstants;

/**
 * 公众平台通用接口工具类
 * 
 * @author liuyq
 * @date 2013-08-09
 */
public class WeixinUtil {
	// 获取access_token的接口地址（GET） 限200（次/天）
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	// 菜单创建（POST） 限100（次/天）
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	// 客服接口地址
	public static String send_message_url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";

	public static String get_user_list_url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
	public static String get_the_user_url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=THEOPENID&lang=zh_CN";
	public static String create_group_url = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN";

	// private static final ResourceBundle bundle =
	// ResourceBundle.getBundle("weixin");

	public static String getOpenidbyCode(String code, String appid, String secret) {
	
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=THEAPPID&secret=THESECRET&code=THECODE&grant_type=authorization_code";
		url = url.replace("THECODE", code).replace("THEAPPID", appid).replace("THESECRET", secret);
		System.out.println("getOpenidbyCode.code = "+code);
		System.out.println("getOpenidbyCode.appid = "+appid);
		System.out.println("getOpenidbyCode.secret = "+secret);
		
		JSONObject rtn = httpRequest(url, "POST", "");// 本地方法，根据url提交json内容
		 System.out.println(rtn.toString());
		return rtn.getString("openid");
	}
/**
 * 发送文本信息,
 * @param accessToken
 * @param touser
 * @param msg
 * @return
 */
	public static JSONObject sendTextMsg(String accessToken,String touser,String msg)
	{
		 String json = "{\"touser\": \""+touser+"\",\"msgtype\":\"text\",\"text\": {\"content\": \""+msg+"\"}}";

	       //获取access_token

	   // String accessToken =weixinAccountService.getAccessToken();
	      
	       //获取请求路径

	       String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+accessToken;

	     net.sf.json.JSONObject jj= WeixinUtil.httpRequest(url, "POST", json);
	     return jj;
	    
	}
	
	/**
	 * 发送图文消息
	 * chen
	 * @return
	 */
	
	public static  JSONObject sendImageMsg(String accessToken,String touser,List<Article> articleList){
		JSONArray listArray=JSONArray.fromObject(articleList);
		
	    String json = "{\"touser\": \""+touser+"\",\"msgtype\":\"news \",\"news\": {\"articles\": "+listArray.toString()+"}}";
	    String str = json.replace("\"picUrl\"", "\"picurl\"");
	   // System.out.println(str);
		String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+accessToken;
	     net.sf.json.JSONObject jj= WeixinUtil.httpRequest(url, "POST", str);
		//创建图文消息
		/*NewsMessageResp newsMessageResp = new NewsMessageResp();
		newsMessageResp.setCreateTime(new Date().getTime());
		newsMessageResp.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
		newsMessageResp.setToUserName(touser);
		newsMessageResp.setFromUserName("gh_8485fec4e9be");
		// 设置图文消息个数  
		newsMessageResp.setArticleCount(articleList.size());
		 // 设置图文消息包含的图文集合  
		newsMessageResp.setArticles(articleList);  
		 // 将图文消息对象转换成xml字符串  
        String respMessage = MessageUtil.newsMessageToXml(newsMessageResp);
        String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+accessToken;
        
		String json = "{\"touser\": \""+touser+"\",\"msgtype\":\""+MessageUtil.RESP_MESSAGE_TYPE_NEWS+"\",\"text\": {\"content\": \""+respMessage+"\"}}";
		 String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+accessToken;
        net.sf.json.JSONObject jj= WeixinUtil.httpRequest(url, "POST", respMessage);*/
	     return jj;
	}
	
	/**
	 * 创建群组
	 * 
	 * @param appId
	 * @param appSecret
	 * @param groupName
	 *            群组名称
	 * @return 如{"group": { "id": 107, "name": "test" } }
	 */
	public static JSONObject createGroup(String accessToken, String groupName) {

		String url = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=" + accessToken;

		/*
		 * JSONObject j = new JSONObject(); try { j.put("group", new
		 * JSONObject().put("name",groupName)); } catch (JSONException e) {
		 * e.printStackTrace(); }
		 */

		String parms = "{\"group\":{\"name\":\"" + groupName + "\"}} ";

		JSONObject rtn = httpRequest(url, "POST", parms);// 本地方法，根据url提交json内容

		System.out.println("WeixinManager.createGroup()" + rtn);

		try {

		} catch (JSONException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		return rtn;
	}

	/**
	 * 查询所有分组
	 * 
	 * @param appId
	 * @param appSecret
	 * @return
	 */
	public static JSONObject getAllGroups(String appId, String appSecret, String accessToken) {

		String url = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=" + accessToken;

		JSONObject jsonObject = new JSONObject();
		jsonObject = WeixinUtil.httpRequest(url, "POST", "");
		if (jsonObject == null) {
			return null;
		}
		return jsonObject;
		/*
		 * Weixin_Groups wg=new Weixin_Groups(); wg=new
		 * Gson().fromJson(jsonObject.toString(), Weixin_Groups.class);
		 * 
		 * return wg;
		 */
	}

	/**
	 * 发起https请求并获取结果
	 * 
	 * @param requestUrl
	 *            请求地址
	 * @param requestMethod
	 *            请求方式（GET、POST）
	 * @param outputStr
	 *            提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
			// jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			org.jeecgframework.core.util.LogUtil.info("Weixin server connection timed out.");
		} catch (Exception e) {
			org.jeecgframework.core.util.LogUtil.info("https request error:{}" + e.getMessage());
		}
		return jsonObject;
	}

	/**
	 * 获取access_token
	 * 
	 * @param appid
	 *            凭证
	 * @param appsecret
	 *            密钥
	 * @return
	 */
	public static AccessToken getAccessToken(SystemService systemService, String appid, String appsecret) {
		// 第三方用户唯一凭证
		// String appid = bundle.getString("appId");
		// // 第三方用户唯一凭证密钥
		// String appsecret = bundle.getString("appSecret");

		AccessTokenYw accessTocken = getRealAccessToken(systemService);

		if (accessTocken != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date end = new java.util.Date();
			java.util.Date start = new java.util.Date(accessTocken.getAddTime().getTime());
			if (end.getTime() - accessTocken.getAddTime().getTime() > accessTocken.getExpires_in() * 1000) {
				AccessToken accessToken = null;
				String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
				JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
				// 如果请求成功
				if (null != jsonObject) {
					try {
						accessToken = new AccessToken();
						accessToken.setToken(jsonObject.getString("access_token"));
						accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
						// 凭证过期更新凭证
						AccessTokenYw atyw = new AccessTokenYw();
						atyw.setId(accessTocken.getId());
						atyw.setExpires_in(jsonObject.getInt("expires_in"));
						atyw.setAccess_token(jsonObject.getString("access_token"));
						updateAccessToken(atyw, systemService);
					} catch (Exception e) {
						accessToken = null;
						// 获取token失败
						String wrongMessage = "获取token失败 errcode:{} errmsg:{}" + jsonObject.getInt("errcode")
								+ jsonObject.getString("errmsg");
						org.jeecgframework.core.util.LogUtil.info(wrongMessage);
					}
				}
				return accessToken;
			} else {

				AccessToken accessToken = new AccessToken();
				accessToken.setToken(accessTocken.getAccess_token());
				accessToken.setExpiresIn(accessTocken.getExpires_in());
				return accessToken;
			}
		} else {

			AccessToken accessToken = null;
			String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
			JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
			// 如果请求成功
			if (null != jsonObject) {
				try {
					accessToken = new AccessToken();
					accessToken.setToken(jsonObject.getString("access_token"));
					accessToken.setExpiresIn(jsonObject.getInt("expires_in"));

					AccessTokenYw atyw = new AccessTokenYw();
					atyw.setExpires_in(jsonObject.getInt("expires_in"));
					atyw.setAccess_token(jsonObject.getString("access_token"));
					saveAccessToken(atyw, systemService);

				} catch (Exception e) {
					accessToken = null;
					// 获取token失败
					String wrongMessage = "获取token失败 errcode:{} errmsg:{}" + jsonObject.getInt("errcode")
							+ jsonObject.getString("errmsg");
					org.jeecgframework.core.util.LogUtil.info(wrongMessage);
				}
			}
			return accessToken;
		}
	}

	/**
	 * 从数据库中读取凭证
	 * 
	 * @return
	 */
	public static AccessTokenYw getRealAccessToken(SystemService systemService) {
		List<AccessTokenYw> accessTockenList = systemService.findByQueryString("from AccessTokenYw");
		return accessTockenList.get(0);
	}

	/**
	 * 保存凭证
	 * 
	 * @return
	 */
	public static void saveAccessToken(AccessTokenYw accessTocken, SystemService systemService) {
		systemService.save(accessTocken);
	}

	/**
	 * 更新凭证
	 * 
	 * @return
	 */
	public static void updateAccessToken(AccessTokenYw accessTocken, SystemService systemService) {
		String sql = "update accesstoken set access_token='" + accessTocken.getAccess_token() + "',expires_ib="
				+ accessTocken.getExpires_in() + ",addtime=now() where id='" + accessTocken.getId() + "'";
		systemService.updateBySqlString(sql);
	}

	/**
	 * 编码
	 * 
	 * @param bstr
	 * @return String
	 */
	public static String encode(byte[] bstr) {
		return new sun.misc.BASE64Encoder().encode(bstr);
	}

	/**
	 * 解码
	 * 
	 * @param str
	 * @return string
	 */
	public static byte[] decode(String str) {

		byte[] bt = null;
		try {
			sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
			bt = decoder.decodeBuffer(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bt;

	}

}