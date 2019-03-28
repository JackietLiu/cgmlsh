package mypartial;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;


import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.InputFormatException;

/**
 * 微信接口工具类。
 * 注意getAccessToken里对accessToken的处理。
 *
 */
/**
 * 微信接口工具类。
 * 注意getAccessToken里对accessToken的处理。
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class WeixinUtil_My {
	//存储最后一次获取accessToken的时间，因为一个token可用2个小时，频繁调用token会被禁
	public static Map<String,Long> accessTokenTimeMapping = new HashMap();
	 
	
	public static Map<String,String> accessTokenMapping = new HashMap();
	/**
	 * 获取AccessToken。
	 * @param appId
	 * @param appSecret
	 * @return
	 */
	public static String getAccessToken(String appId, String appSecret) { // 获得ACCESS_TOKEN
		long nowTime = System.currentTimeMillis();
		String key = appId+"_"+appSecret;
		//调试的时候，获取一次token，然后把值放在这里。
	//	if(false)return "knQf-j-L8iXHsp0U9ymtLIJR2spxwrwnuftp-MHpYhb_5Lyn8nnhfAdtqP9GGfWelaZdFoCzDf4vGPHGr6vHfQ";
		Long lstAccessTokenTime = accessTokenTimeMapping.get(key);
		if(lstAccessTokenTime == null)lstAccessTokenTime = 0l;
		if( nowTime - lstAccessTokenTime < 7000 * 1000){
			String accessToken = accessTokenMapping.get(key);
			if(accessToken != null)
			return accessToken;
		}
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
				+ appId + "&secret=" + appSecret;
		String message = weixinRequest(url,null,"GET");

			try {
				JSONObject demoJson = new JSONObject(message);
				String accessToken = demoJson.getString("access_token");
				System.out.println("WeixinManager.getAccessToken()"+message);
				accessTokenTimeMapping.put(key, nowTime);
				accessTokenMapping.put(key, accessToken);
				return accessToken;
			} catch (JSONException e) {
				throw new RuntimeException(e.getMessage(),e);
			}
	}
	/**
	 * 设置微信的菜单。
	 * @param appId
	 * @param appSecret
	 * @param menu
	 * @return
	 * @throws IOException
	 */
	public static String resetMenu(String appId, String appSecret, String menu) throws IOException {
		//[{
		//"name":"最新活动","sub_button":
		//[{"type":"click","name":"优惠活动","key":"m_discount"},				
		//{"type":"click","name":"积分查询","key":"m_query"}
		//]
		//}]
		String access_token = getAccessToken(appId, appSecret);
		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="
				+ access_token;
		String message = weixinRequest(url,menu,"POST");
		return message;
	}
	/**
	 * 获取粉丝列表。
	 * @param appId
	 * @param appSecret
	 * @return
	 */
	public static JSONObject getFollowers(String appId, String appSecret){
		return getFollowers(appId,appSecret,null);
	}
	/**
	 * 获取粉丝列表。
	 * @param appId
	 * @param appSecret
	 * @param nextOpenId 粉丝过万需要
	 * @return
	 */
	public static JSONObject getFollowers(String appId, String appSecret, String nextOpenId){
		String access_token = getAccessToken(appId, appSecret);
		String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token="+access_token;
		if(nextOpenId != null && !"".equals(nextOpenId)) url+="&next_openid="+nextOpenId;
		String rtn = weixinRequest(url,null,"GET");
		System.out.println("WeixinManager.getUsers()"+rtn);
		JSONObject json;
		try {
			json = new JSONObject(rtn);
		} catch (JSONException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		return json;
	}
	/**
	 * 获取粉丝的详细信息。
	 * @param appId
	 * @param appSecret
	 * @param openId
	 * @return
	 */
	public static JSONObject getFollowerInfo(String appId, String appSecret, String openId){
		String accessToken = getAccessToken(appId, appSecret);
		String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+accessToken+"&openid="+openId+"&lang=zh_CN";
		String rtn = weixinRequest(url, null, "GET");
		System.out.println("WeixinManager.getFollowerInfo()"+rtn);
		JSONObject json;
		try {
			json = new JSONObject(rtn);
		} catch (JSONException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		return json;
	}
	
	/**
	 * 创建群组
	 * @param appId
	 * @param appSecret
	 * @param groupName 群组名称
	 * @return 如{"group": { "id": 107, "name": "test" } }
	 */
	public static JSONObject createGroup(String appId, String appSecret, String groupName){
		String accessToken = getAccessToken(appId, appSecret);
		String url = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=" + accessToken;
		JSONObject j = new JSONObject();
		try {
			j.put("group", new JSONObject().put("name",groupName));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		String rtn = weixinRequest(url, j.toString(), "POST");
		System.out.println("WeixinManager.createGroup()"+rtn);
		JSONObject json;
		try {
			json = new JSONObject(rtn);
		} catch (JSONException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		return json;
	}
	
	/**
	 * 查询所有分组
	 * @param appId
	 * @param appSecret
	 * @return
	 */
	public static JSONObject getAllGroups(String appId, String appSecret){
		String accessToken = getAccessToken(appId, appSecret);
		String url = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=" + accessToken;
		
		String rtn = weixinRequest(url, null, "GET");
		System.out.println("WeixinManager.getAllGroups()"+rtn);
		JSONObject json;
		try {
			json = new JSONObject(rtn);
		} catch (JSONException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		return json;
	}
	
	/**
	 * 通过用户的OpenID查询其所在的GroupID
	 * @param appId
	 * @param appSecret
	 * @param openId 用户的OpenID
	 * @return 如：{ "groupid": 102 }
	 */
	public static JSONObject getUserGroup(String appId, String appSecret, String openId){
		String accessToken = getAccessToken(appId, appSecret);
		String url = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=" + accessToken;
		JSONObject j = new JSONObject();
		try {
			j.put("openid", openId);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		
		String rtn = weixinRequest(url, j.toString(), "POST");
		System.out.println("WeixinManager.createGroup()"+rtn);
		JSONObject json;
		try {
			json = new JSONObject(rtn);
		} catch (JSONException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		return json;
	}

/**
 * 发送模板消息	
 * @param appId
 * @param appSecret
 * @param openId 用户的openID
 * @param templateId 模板id
 * @param data 模板中各参数的赋值内容
 * @return
 */
	public static JSONObject sendTemplateMsg(String appId, String appSecret,String openId,
			String templateId,
			String detailUrl,
			String topcolor,
			String[] data){
		String accessToken = getAccessToken(appId, appSecret);
		String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+accessToken;
		JSONObject postJson=new JSONObject();
		try {
			postJson.put("touser", openId);
			postJson.put("template_id", templateId);
			if(detailUrl != null)
			postJson.put("url", detailUrl);
			if(topcolor != null)
			postJson.put("topcolor", topcolor);
			JSONObject dataJson = new JSONObject();
			for (int i = 0; i < data.length; i+=3) {
				JSONObject k = new JSONObject();
				k.put("value", data[i+1]);
				if(data[i+2] != null)
				k.put("color", data[i+2]);
				dataJson.put(data[i], k);
			}
			postJson.put("data", dataJson);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		String rtn = weixinRequest(url, postJson.toString(), "POST");
		JSONObject json;
		try {
			json = new JSONObject(rtn);
		} catch (JSONException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		return json;
	}
	
	
	/**
	 * 修改分组名
	 * @param appId
	 * @param appSecret
	 * @param groupId
	 * @param newGroupName
	 * @return 如 {"errcode": 0, "errmsg": "ok"}
	 */
	public static JSONObject updateGroup(String appId, String appSecret, String groupId, String newGroupName){
		String accessToken = getAccessToken(appId, appSecret);
		String url = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=" + accessToken;
		JSONObject j = new JSONObject();
		JSONObject group = new JSONObject();
		try {
			j.put("id", groupId);
			j.put("name",newGroupName);
			group.put("group",j);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		String rtn = weixinRequest(url, group.toString(), "POST");
		System.out.println("WeixinManager.createGroup()"+rtn);
		JSONObject json;
		try {
			json = new JSONObject(rtn);
		} catch (JSONException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		return json;
	}
	
	/**
	 * 移动用户分组
	 * @param appId
	 * @param appSecret
	 * @param toGroupId 新分组的id
	 * @param openId 用户id
	 * @return 如 {"errcode": 0, "errmsg": "ok"}
	 */
	public static JSONObject updateUserGroup(String appId, String appSecret, String toGroupId, String openId){
		String accessToken = getAccessToken(appId, appSecret);
		String url = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=" + accessToken;
		JSONObject j = new JSONObject();
		try {
			j.put("openid", openId);
			j.put("to_groupid", toGroupId);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		String rtn = weixinRequest(url, j.toString(), "POST");
		System.out.println("WeixinManager.createGroup()"+rtn);
		JSONObject json;
		try {
			json = new JSONObject(rtn);
		} catch (JSONException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		return json;
	}
	
	/**
	 * 上传多媒体文件
	 * @param appId
	 * @param appSecret
	 * @param type 文件类型
	 * @param filePath 文件的绝对路径
	 * @return 含有media_id的json数据
	 * @throws IOException
	 */
	public static JSONObject uploadMedia(String appId, String appSecret, String type, String filePath) throws IOException{
		String accessToken = getAccessToken(appId, appSecret);
		String url = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=" + accessToken + "&type=" + type;
		File file=new File(filePath);
		
//		SimpleHttpClient shc = SimpleHttpClient.getInstance();
//    	Map m = new HashMap();
//    	m.put("media", new File(""));
//    	shc.upload(url, m);
	    URL urlObj = new URL(url);
		
	    // 连接  
	    HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();  
	    
	    //设置关键值 
	    con.setRequestMethod("POST"); // 以Post方式提交表单，默认get方式  
	    con.setDoInput(true);  
	    con.setDoOutput(true);  
	    con.setUseCaches(false); // post方式不能使用缓存  
	   
	    // 设置请求头信息  
	    con.setRequestProperty("Connection", "Keep-Alive");  
	    con.setRequestProperty("Charset", "UTF-8");  
	    
	    // 设置边界  
	    String BOUNDARY = "----------" + System.currentTimeMillis();  
	    con.setRequestProperty("Content-Type", "multipart/form-data; boundary="+ BOUNDARY);  
	   
	    // 请求正文信息  
	    // 第一部分：  
	    StringBuilder sb = new StringBuilder();  
	    sb.append("--"); // 必须多两道线  
	    sb.append(BOUNDARY);  
	    sb.append("\r\n");  
	    sb.append("Content-Disposition: form-data;name=\"file\";filename=\"" + file.getName() + "\"\r\n");  
	    sb.append("Content-Type:application/octet-stream\r\n\r\n");  
	   
	    byte[] head = sb.toString().getBytes("utf-8");  
	   
	    // 获得输出流  
	    OutputStream out = new DataOutputStream(con.getOutputStream());  
	    // 输出表头  
	    out.write(head);  
		
	    // 文件正文部分  
	    // 把文件已流文件的方式 推入到url中  
	    DataInputStream in = new DataInputStream(new FileInputStream(file));  
	    int bytes = 0;  
	    byte[] bufferOut = new byte[1024];  
	    
	    while ((bytes = in.read(bufferOut)) != -1) {  
	    	out.write(bufferOut, 0, bytes);  
	    }  
	    in.close();  
	  
	    // 结尾部分  
	    byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线  
	  
	    out.write(foot);  
	  
	    out.flush();  
	    out.close();  
	  
	    StringBuffer buffer = new StringBuffer();  
	    BufferedReader reader = null;  
	    String rtn = null;
		JSONObject json;
		
	    try {  
		    // 定义BufferedReader输入流来读取URL的响应  
		    reader = new BufferedReader(new InputStreamReader(con.getInputStream()));  
		    String line = null;  
		    while ((line = reader.readLine()) != null) {  
			    //System.out.println(line);  
			    buffer.append(line);  
		    }  
		    if(rtn==null){  
		    	rtn = buffer.toString();  
		    }  
	    } catch (IOException e) {  
	    	System.out.println("发送POST请求出现异常！" + e);  
	    	e.printStackTrace();  
	    	throw new IOException("数据读取异常");  
	    } finally {  
		    if(reader!=null){  
			    reader.close();  
		    }
	    }
		
		try {
			json = new JSONObject(rtn);
		} catch (JSONException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		return json;
	}
	
	/**
	 * 获取图文消息的media_id
	 * @param appId
	 * @param appSecret
	 * @param infoMapList 图文消息的相关信息，Map中必须包括filePath（缩略图绝对地址）, content 群发时必须有title
	 * @return
	 */
	public static JSONObject uploadnews(String appId, String appSecret, List<Map<String, String>> infoMapList){
		String accessToken = getAccessToken(appId, appSecret);
		String url = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=" + accessToken;
		
		List<JSONObject> list = new ArrayList<JSONObject>();
		JSONObject j;
		JSONObject articles = new JSONObject();
		
		for(Map<String, String> infoMap : infoMapList){
			j = new JSONObject();
			String filePath = infoMap.get("filePath");
			try {
				String thumb_media_id = uploadMedia(appId, appSecret, "thumb", filePath).getString("thumb_media_id");
				j.put("thumb_media_id", thumb_media_id);
				
				if(!StringUtils.isEmpty(infoMap.get("author"))){
					j.put("author", infoMap.get("author"));
				}
				j.put("title", infoMap.get("title"));
				
				if(!StringUtils.isEmpty(infoMap.get("content_source_url"))){
					//在图文消息页面点击“阅读原文”后的页面
					j.put("content_source_url", infoMap.get("content_source_url"));
				}
				
				//图文消息页面的内容，支持HTML标签
				j.put("content", infoMap.get("content"));
				
				if(!StringUtils.isEmpty(infoMap.get("digest"))){
					j.put("digest", infoMap.get("digest"));
				}
				
				if(!StringUtils.isEmpty(infoMap.get("show_cover_pic"))){
					//正文中是否仍然显示缩略图，1为显示，0为不显示，默认为1
					j.put("show_cover_pic", infoMap.get("show_cover_pic"));
				}
				
				if(!StringUtils.isEmpty(infoMap.get("description"))){
					//描述 ，客服图文
					j.put("description", infoMap.get("description"));
				}
				
				if(!StringUtils.isEmpty(infoMap.get("url"))){
					//点击后跳转的链接 客服图文
					j.put("url", infoMap.get("url"));
				}
				
				if(!StringUtils.isEmpty(infoMap.get("picurl"))){
					//图文消息的图片链接，支持JPG、PNG格式 ，客服图文
					j.put("picurl", infoMap.get("picurl"));
				}
				
//				System.out.println(j);
				list.add(j);
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			articles.put("articles", list);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		
		/*JSONObject j1 = new JSONObject();
		JSONObject j2 = new JSONObject();
		List<JSONObject> list = new ArrayList<JSONObject>();
		JSONObject articles = new JSONObject();
		
		try {
			
			String filePath = "H:\\upload\\thumb\\8.jpg";
			
			String thumb_media_id = uploadMedia(appId, appSecret, "thumb", filePath).getString("thumb_media_id");
			
			//图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得
			j1.put("thumb_media_id", thumb_media_id);
			j1.put("author", "1ggg");
			j1.put("title", "1测试标题");
			//在图文消息页面点击“阅读原文”后的页面
			j1.put("content_source_url", "www.baidu.com");
			//图文消息页面的内容，支持HTML标签
			j1.put("content", "1测试asiuninasd");
			j1.put("digest", "1digest");
//			System.out.println(j);
			list.add(j1);
			
			
			filePath = "H:\\upload\\thumb\\6.jpg";
			
			thumb_media_id = uploadMedia(appId, appSecret, "thumb", filePath).getString("thumb_media_id");
			//图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得
			j2.put("thumb_media_id", thumb_media_id);
			j2.put("author", "2www");
			j2.put("title", "2测试标题");
			//在图文消息页面点击“阅读原文”后的页面
			j2.put("content_source_url", "www.baidu.com");
			//图文消息页面的内容，支持HTML标签
			j2.put("content", "2测试asiuninasd");
			j2.put("digest", "2digest");
//			System.out.println(j);
			list.add(j2);
			
			articles.put("articles", list);
			
			System.out.println("待发送消息：" + articles);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		String rtn = weixinRequest(url, articles.toString(), "POST");
		System.out.println("WeixinManager.getMediaId()"+rtn);
		JSONObject json;
		try {
			json = new JSONObject(rtn);
		} catch (JSONException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
		return json;
//		return weixinRequest(url, articles.toString(), "POST");
	}
	
//	public static String getVideoMediaId(String appId, String appSecret, String srcMediaId) throws IOException{
//		String accessToken = getAccessToken(appId, appSecret);
//		String url = "https://file.api.weixin.qq.com/cgi-bin/media/uploadvideo?access_token=" + accessToken;
//		
//		JSONObject j = new JSONObject();
//		try {
//			j.put("media_id", srcMediaId);
//			j.put("title", "");
//			j.put("description", "");
//		} catch (JSONException e1) {
//			e1.printStackTrace();
//		}
//		
//		return weixinRequest(url, j.toString(), "POST");
//	}
	
	/**
	 * 群发消息：根据分组进行群发 
	 * @param appId
	 * @param appSecret
	 * @param msgType 消息类型
	 * @param mediaId 若为文本类型，则直接传入文本内容
	 * @param groupId 群组id
	 * @return 示例 ：{ "errcode":0, "errmsg":"send job submission success", "msg_id":34182 }
	 */
	public static JSONObject sendGroupMsg(String appId, String appSecret,String msgType, String mediaId, String groupId){
		String accessToken = getAccessToken(appId, appSecret);
		String url = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=" + accessToken;
		JSONObject j = getMsgJSON(appId, appSecret, msgType, mediaId);
		
		try {
			if("video".equals(msgType)){
				j.remove("video");
				j.put("mpvideo", new JSONObject().put("media_id", mediaId));
				j.put("msgtype", "mpvideo");
			}
			j.put("filter", new JSONObject().put("group_id", groupId));
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		
		String rtn = weixinRequest(url, j.toString(), "POST");
		System.out.println("WeixinManager.sendGroupMsgByGroup()"+rtn);
		JSONObject json;
		try {
			json = new JSONObject(rtn);
		} catch (JSONException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		return json;
	}
	
	/**
	 * 群发消息：根据用户OpenID列表群发 
	 * @param appId
	 * @param appSecret
	 * @param msgType 消息类型
	 * @param mediaId 若为文本类型，则直接传入文本内容
	 * @param userIdList 用户OpenID列表
	 * @return 示例 ：{ "errcode":0, "errmsg":"send job submission success", "msg_id":34182 }
	 */
	public static JSONObject sendGroupMsg(String appId, String appSecret,String msgType, String mediaId, List<String> userIdList){
		String accessToken = getAccessToken(appId, appSecret);
		String url = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=" + accessToken;
		JSONObject j = getMsgJSON(appId, appSecret, msgType, mediaId);
		
		try {
			if("video".equals(msgType)){
				j.remove("video");
				j.put("mpvideo", new JSONObject().put("media_id", mediaId));
				j.put("msgtype", "mpvideo");
			}
			j.put("touser", userIdList);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		
		String rtn = weixinRequest(url, j.toString(), "POST");
		System.out.println("WeixinManager.sendGroupMsgByGroup()"+rtn);
		JSONObject json;
		try {
			json = new JSONObject(rtn);
		} catch (JSONException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		return json;
	}
	
	/**
	 * 用于产生群发视频所需的media_id
	 * @param appId
	 * @param appSecret
	 * @param mediaId 上传视频后腾讯服务器返回的
	 * @param title 视频标题
	 * @param description 视频描述
	 * @return
	 */
	public static JSONObject getMediaIdVideo(String appId, String appSecret, String mediaId, String title, String description){
		String accessToken = getAccessToken(appId, appSecret);
		String url = "https://file.api.weixin.qq.com/cgi-bin/media/uploadvideo?access_token=" + accessToken;
		JSONObject j = new JSONObject();
		
		try {
			j.put("media_id", mediaId);
			j.put("title", title);
			j.put("description", description);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		
		String rtn = weixinRequest(url, j.toString(), "POST");
		System.out.println("WeixinManager.getMediaIdForVideo()"+rtn);
		JSONObject json;
		try {
			json = new JSONObject(rtn);
		} catch (JSONException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		return json;
		
	}
	
	/**
	 * 根据消息信息拼接可复用的JSON内容
	 * @param appId
	 * @param appSecret
	 * @param msgType 消息类型 text mpnews voice image
	 * @param mediaId 若为文本类型，则直接传入文本内容
	 * @return
	 */
	private static JSONObject getMsgJSON(String appId, String appSecret, String msgType, String mediaId){
		
		JSONObject j = new JSONObject();
		try {
			j.put("msgtype", msgType);
//			j.put("filter", new JSONObject().put("group_id", groupId));
			if("text".equals(msgType)){
					j.put("text", new JSONObject().put("content", mediaId));
				}else if("mpnews".equals(msgType)){
//					j.put("mpnews", new JSONObject().put("media_id", getMpnewsId(appId, appSecret).getString("media_id")));
					j.put("mpnews", new JSONObject().put("media_id", mediaId));
				}else if("voice".equals(msgType)){
					j.put("voice", new JSONObject().put("media_id", mediaId));
				}else if("image".equals(msgType)){
					j.put("image", new JSONObject().put("media_id", mediaId));
				}else if("video".equals(msgType)){
					j.put("video", new JSONObject().put("media_id", mediaId));
				}else {  
				  System.out.println("未知的多媒体类型！");  
				}  
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return j;
	}
	
	/**
	 * @param appId
	 * @param appSecret
	 * @param openId
	 * @param msgType 消息类型 text mpnews voice image
	 * @param mediaId 若为文本类型，则直接传入文本内容
	 * @return
	 */
	public static JSONObject sendServiceMsg(String appId, String appSecret,String openId, String msgType, String mediaId){
		String accessToken = getAccessToken(appId, appSecret);
		String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + accessToken;
		JSONObject j = getMsgJSON(appId, appSecret, msgType, mediaId);
		
		try {
			j.put("touser", openId);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		
		String rtn = weixinRequest(url, j.toString(), "POST");
		System.out.println("WeixinManager.sendServiceMsg()"+rtn);
		JSONObject json;
		try {
			json = new JSONObject(rtn);
		} catch (JSONException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		return json;
		
	}
	
	/**
	 * 获取客服基本信息
	 * @param appId
	 * @param appSecret
	 * @return 
	 * json对象示例:
	 * {
    	"kf_list": [
        {
            "kf_account": "test1@test", 客服账号@微信别名
            "kf_nick": "ntest1", 客服昵称
            "kf_id": "1001" 客服工号
        }
       }
	 */
	public static JSONObject getKFList(String appId, String appSecret){
		String accessToken = getAccessToken(appId, appSecret);
		String url = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=" + accessToken;
		
		String rtn = weixinRequest(url,null,"POST");
		System.out.println("WeixinManager.getKFList()"+rtn);
		JSONObject json;
		try {
			json = new JSONObject(rtn);
		} catch (JSONException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		return json;
		
	}
	
	/**
	 * 获取在线客服信息
	 * @param appId
	 * @param appSecret
	 * @return 
	 * json对象示例:
	 * {
    	"kf_online_list": [
        {
            "kf_account": "test1@test", 客服账号@微信别名
            "status": 1, 客服在线状态 1:pc在线，2:手机在线 ,若pc和手机同时在线则为 1+2=3
            "kf_id": "1001", 客服工号
            "auto_accept": 0, 客服设置的最大自动接入数
            "accepted_case": 1 客服当前正在接待的会话数
        }
       }
	 */
	public static JSONObject getOnLineKFList(String appId, String appSecret){
		String accessToken = getAccessToken(appId, appSecret);
		String url = "https://api.weixin.qq.com/cgi-bin/customservice/getonlinekflist?access_token=" + accessToken;
		
		String rtn = weixinRequest(url,null,"POST");
		System.out.println("WeixinManager.getOnLineKFList()"+rtn);
		JSONObject json;
		try {
			json = new JSONObject(rtn);
		} catch (JSONException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		return json;
		
	}
	
	/**
	 * 获取会话记录
	 * @param appId
	 * @param appSecret
	 * @param starttime 必要参数  查询开始时间，UNIX时间戳(秒级别)
	 * @param endtime 必要参数  查询结束时间，UNIX时间戳(秒级别)，每次查询不能跨日查询
	 * @param openid 非必要参数  普通用户openid，若不填则查询该appid下所有用户
	 * @param pagesize 必要参数  每页大小，每页最多拉取1000条
	 * @param pageindex 必要参数  查询第几页，从1开始
	 * @return 
	 * json对象示例:
	 * {
    "recordlist": [
        {
            "worker": " test1", 客服账号
            "openid": "oDF3iY9WMaswOPWjCIp_f3Bnpljk", 普通用户openid
            "opercode": 2002, 操作ID（会话状态）
            "time": 1400563710, 操作时间，UNIX时间戳(秒级别)
            "text": " 您好，客服test1为您服务。" 聊天记录
        }
       }
	 */
	public static JSONObject getRecord(String appId, String appSecret,Long starttime,Long endtime,String openid,int pagesize,int pageindex){
		String accessToken = getAccessToken(appId, appSecret);
		String url = "https://api.weixin.qq.com/cgi-bin/customservice/getrecord?access_token=" + accessToken;
		JSONObject data = new JSONObject();
		try {
			data.put("starttime", starttime);
			data.put("endtime", endtime);
			data.put("openid", openid);
			data.put("pagesize", pagesize);
			data.put("pageindex", pageindex);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		
		String rtn = weixinRequest(url,data.toString(),"POST");
		System.out.println("WeixinManager.getRecord()"+rtn);
		JSONObject json;
		try {
			json = new JSONObject(rtn);
		} catch (JSONException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		return json;
		
	}
	
	
	
	
	public static void main(String[] args) throws JSONException, IOException {
		final String appId = "";
		final String appSecret = ""; // 自己的APPIP
		//上传文件到微信服务器
		//返回media_id
		//{"media_id":"6oYmOskQu9n4PrUsHataDC_Um_hHqXo6OO8F86QAmZQggOAJlEUNu32FAyaSvayx","created_at":1408950679,"type":"image"}
		//{"media_id":"WTGKd2RyH2JL8oyxqqCRUAPyNnxYSDKzwd118v_cbWNUZAIYJNoUvPf04rTidfHa","created_at":1408958060,"type":"image"}
		//{"media_id":"Oyh8JMMu3FuCSAdQK38EDloRp4d4tGeAok_afM0fGyrD-baRa_mTIUX2cNU6po2f","created_at":1408959115,"type":"video"}
		//{"thumb_media_id":"xJCYazReoGAik8jIdIePpl8XwBVSJ81aFCc23sv3FjENTdc9PbQaECL2TsxDwgQo","created_at":1409016231,"type":"thumb"}
//		String filePath = "H:\\upload\\thumb\\8.jpg";
//		JSONObject j = null;
//		j = uploadMedia(appId, appSecret, "thumb", filePath);
//		System.out.println(j);
		
//		System.out.println(getMediaId(appId, appSecret));
//		System.out.println(createGroup(appId, appSecret, "测试"));
//		getAllGroups(appId, appSecret);
		
		//发送图文
		//构建图文
		Map<String, String> infoMap;
		List<Map<String, String>> infoMapList = new ArrayList<Map<String, String>>();
		
		infoMap = new HashMap<String, String>();
		infoMap.put("filePath", "H:\\upload\\thumb\\8.jpg");
		infoMap.put("author", "liuhao1");
		infoMap.put("title", "群发图文消息");
		infoMap.put("content_source_url", "http://www.baidu.com");
		String content = "<h3>内容中显示封面标题缩略图</h3>"
				+ "<br>超链接:<a href='http://www.baidu.com'>点我</a><br>"
				+ "<br>图文中超链接不能用！<br>" +  
				"<br>根据微信公众平台目前的规则，除了已经开通微信支付的微信公众号具有这个链接功能外，其它任何公众号都没有此项功能，<br>"
				+ "<br>换句话说订阅号，没有开通微信支付的服务号都没有链接功能。<br>"
				+ "<br>点击'阅读原文'！<br>";
		infoMap.put("content", content);
		infoMap.put("show_cover_pic", "1");
		infoMapList.add(infoMap);
		
		infoMap = new HashMap<String, String>();
		infoMap.put("filePath", "H:\\upload\\thumb\\6.jpg");
		infoMap.put("author", "liuhao2");
		infoMap.put("title", "测试标题2");
		infoMap.put("content_source_url", "www.qq.com");
		content = "<h3>内容中不显示封面标题缩略图</h3><br>"
				+ "此处可以以html方式添加  文字，图片，音视频<br>"
				+ "<br>图片1：<br><img src='http://avatar.csdn.net/7/A/A/3_everwhl.jpg' /><br>"
				+ "<br>图片2：<br><img src='http://avatar.csdn.net/0/3/1/3_bruce_6.jpg' /><br>";
		infoMap.put("content", content );
		infoMap.put("show_cover_pic", "0");
		infoMap.put("url", "www.baidu.com");
		infoMap.put("picurl", "http://avatar.csdn.net/0/3/1/3_bruce_6.jpg");
		infoMapList.add(infoMap);
		
		String mediaId = uploadnews(appId, appSecret, infoMapList).getString("media_id");
		sendServiceMsg(appId, appSecret, "oH3OZuHtj9hoEkTqWSWUx6jpaB7o", "mpnews", mediaId);
		
//		getKFList(appId, appSecret);
//		getOnLineKFList(appId, appSecret);
//		getRecord(appId, appSecret,1408982400L,1409068799L,null,100,1);
//		sendGroupMsg(appId, appSecret, "mpnews", mediaId, "0");
		
//		//发送含超链接的文本
//		String content = "雨桥pms：<a href='http://www.baidu.com'>点我</a>";
//		sendServiceMsg(appId, appSecret, "oH3OZuHtj9hoEkTqWSWUx6jpaB7o", "text", content);
		
//		//发送图片
//		String mediaId = uploadMedia(appId, appSecret, "image", "H:\\upload\\thumb\\8.jpg").getString("media_id");
//		sendServiceMsg(appId, appSecret, "oH3OZuHtj9hoEkTqWSWUx6jpaB7o", "image", mediaId);
		
//		//发送视频
//		String mediaId = uploadMedia(appId, appSecret, "video", "H:\\upload\\video\\test.MP4").getString("media_id");
//		sendServiceMsg(appId, appSecret, "oH3OZuHtj9hoEkTqWSWUx6jpaB7o", "video", mediaId);
		
//		getFollowerInfo(appId, appSecret, "oH3OZuDaNUUNW3LBd4kaHmntBrAU");
//		getFollowerInfo(appId, appSecret, "oH3OZuIxeVgDFVm1Q8aoA9Xz24Gg");
//		getFollowerInfo(appId, appSecret, "oH3OZuP5chgHB67m5ETDTlxxZM9E");
//		getFollowerInfo(appId, appSecret, "oH3OZuHtj9hoEkTqWSWUx6jpaB7o");
//		getFollowers(appId, appSecret).get("data");
		
//		JSONObject j = getFollowers(appId,appSecret);
//		int total = j.getInt("total");
//		int count = j.getInt("count");
//		JSONArray ja = j.getJSONObject("data").getJSONArray("openid");
//		for (int i = 0; i < count; i++) {
//			String openid = ja.getString(i);
//			JSONObject f = getFollowerInfo(appId,appSecret,openid);
//			System.out.println("WeixinManager.main()"+f);
//		}

	}
	/**
	 * 向微信发送http请求，并获取返回内容。
	 * @param urlStr
	 * @param data
	 * @param method
	 * @return
	 */
	private static String weixinRequest(String urlStr, String data, String method){
		try {
			System.setProperty("jsse.enableSNIExtension", "false");
			
//			SSLContext ctx = SSLContext.getInstance("TLS");
//			SSLSocketFactory factory = ctx.getSocketFactory();
			
			URL url = new URL(urlStr);
			HttpsURLConnection http = (HttpsURLConnection) url.openConnection();
			http.setHostnameVerifier(new CustomizedHostnameVerifier());
//			http.setSSLSocketFactory(factory);
			if(method == null || "".equals(method))method = "GET";
			http.setRequestMethod(method);
			http.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
			http.connect();
			if(data != null && !"".equals(data)){
				OutputStream os = http.getOutputStream();
				os.write(data.getBytes("UTF-8"));// 传入参数
				os.flush();
				os.close();
			}

			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] jsonBytes = new byte[size];
			is.read(jsonBytes);
			String message = new String(jsonBytes, "UTF-8");
			return message;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(),e);
		}
	}
	
	public static class CustomizedHostnameVerifier implements HostnameVerifier  
	{  
	    public boolean verify(String string, SSLSession session)  
	    {  
	        return true;  
	    }  
	  
	}  
	
	/**
	 * 语音文件由.amr文件转换为.mp3文件
	 * @param source  source为.amr文件   
	 * @param target
	 */
	public static void changeAudio(File source,File target) {
		AudioAttributes audio = new AudioAttributes();
		Encoder encoder = new Encoder();
		audio.setCodec("libmp3lame");

		audio.setBitRate(new Integer(128000));
		audio.setChannels(new Integer(2));
		audio.setSamplingRate(new Integer(44100));

		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat("mp3");
		attrs.setAudioAttributes(audio);
		try {
			encoder.encode(source, target, attrs);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InputFormatException e) {
			e.printStackTrace();
		} catch (EncoderException e) {
			e.printStackTrace();
		}
	}
}
