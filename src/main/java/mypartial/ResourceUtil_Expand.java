package mypartial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import org.jeecgframework.core.util.ContextHolderUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.system.manager.ClientManager;
import org.jeecgframework.web.system.pojo.base.Client;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.impl.SystemServiceImpl;
import org.springframework.util.ObjectUtils;

 
 

import java.util.ResourceBundle;
 

public class ResourceUtil_Expand {
	public static final String MYHOSP="MYHOSP";
	
	/**
	 * 鑾峰彇閰嶇疆鏂囦欢鍙傛暟
	 * zczchanged 
	 * @param name
	 * @return
	 */
	public static final String getConfigByName(String filename,String name) {
		
		ResourceBundle bundle =  ResourceBundle.getBundle(filename);
		//GetProperties.class.getResourceAsStream
		boolean bb=bundle.containsKey(name);
		
		if(bb)
		{
			return bundle.getString(name);
		}
		else
		{
			return "";
		}		
	}
	
	private String properiesName = "";
    public void writeProperty(String key, String value) {
        InputStream is = null;
        OutputStream os = null;
        Properties p = new Properties();
        try {
            is = new FileInputStream(properiesName);
            p.load(is);
            os = new FileOutputStream(ResourceUtil_Expand.class.getClassLoader().getResource(properiesName).getFile());

            p.setProperty(key, value);
            p.store(os, key);
            os.flush();
            os.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (null != is)
                    is.close();
                if (null != os)
                    os.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

	/**
	 * 取得当前的是否为
	 * zczadd
	 * @param name
	 * @return
	 */
	public static final String getCurrentweblevel( ) {
		return getConfigByName("zhuanbing","currentweblevel");
	}
	
	public static final String getUrlByname(String thename ) {
		String centerweb= getConfigByName("zhuanbing","centerwebsiteprefix").trim();	
		String myretu=getConfigByName("zhuanbing",thename).trim();	
		if(myretu.startsWith("http://") ||myretu.startsWith("https://") )
		{
		}
		else
		{
			myretu=centerweb +myretu ;
		}
		return myretu;
		
	}
	
	public static void consolePrintName(Class aa,String memo) {
		if(getConfigByName("sysConfig","consoleprintjspname").trim().equalsIgnoreCase("1")){
			if("".equalsIgnoreCase(memo)) {
				memo="current page:";
			}
			System.out.println(memo+":"+ aa.getSimpleName().replaceAll("_", ".").replaceAll(".005f", "_").replaceAll(".002d", "-"));
		}
	}
	/**
	  * 
	  * 方法用途和描述: 创建属性文件 
	  * 
	  * @param propertyFilePath
	  *            要存储属性文件的路径
	  * @param htKeyValue
	  *            属性文件中的键值对Hashtable
	  * @return
	  * @author dengcd 新增日期：2008-10-9
	  * @author 你的姓名 修改日期：2008-10-9
	  * @since wapportal_manager version(2.0)
	  */
	 public final static boolean createPropertiesFile(String propertyFilePath,
	   java.util.Hashtable<String, String> htKeyValue) {
	  java.io.File file = new java.io.File(propertyFilePath);
	  if (!file.exists()) {
	   try {
	    file.createNewFile();
	   } catch (java.io.IOException e) {
	    e.printStackTrace();
	   }
	  }
	  return setValueAndStore(propertyFilePath, htKeyValue,
	    "create properties file:" + file.getName());
	 }
	
	 /**
	  * 
	  * 方法用途和描述: 对存在的属性文件中添加键值对并保存
	  * 
	  * @param propertyFilePath
	  *            属性文件的路径(包括类路径及文件系统路径)
	  * @param htKeyValue
	  *            键值对Hashtable
	  * @return
	  * @author dengcd 新增日期：2008-10-9
	  * @author 你的姓名 修改日期：2008-10-9
	  * @since wapportal_manager version(2.0)
	  */
	 public final static boolean setValueAndStore(String propertyFilePath,
	   java.util.Hashtable<String, String> htKeyValue) {
	  return setValueAndStore(propertyFilePath, htKeyValue, null);
	 }
	 
	 /**
	  * 
	  * 方法用途和描述: 对存在的属性文件中添加键值对并保存 
	  * 
	  * @param propertyFilePath
	  *            属性文件的路径(包括类路径及文件系统路径)
	  * @param htKeyValue
	  *            键值对Hashtable
	  * @param storeMsg
	  *            保存时添加的附加信息（注释）
	  * @return
	  * @author dengcd 新增日期：2008-10-9
	  * @author 你的姓名 修改日期：2008-10-9
	  * @since wapportal_manager version(2.0)
	  */
	 public final static boolean setValueAndStore(String propertyFilePath,
	   java.util.Hashtable<String, String> htKeyValue, String storeMsg) {
	  Properties ppts = getProperties(propertyFilePath);

	  if (ppts == null || htKeyValue == null) {
	   return false;
	  }
	  ppts.putAll(htKeyValue);
	  java.io.OutputStream stream = null;
	  try {
	   stream = new java.io.FileOutputStream(propertyFilePath);
	  } catch (FileNotFoundException e) {
	   String path = ResourceUtil_Expand.class.getResource(propertyFilePath)
	     .getPath();
	   try {
	    stream = new java.io.FileOutputStream(path);
	   } catch (FileNotFoundException e1) {
	    return false;
	   }
	  }

	  if (stream == null) {
	   return false;
	  }

	  try {
	   ppts.store(stream, storeMsg != null ? storeMsg
	     : "set value and store.");
	   return true;
	  } catch (java.io.IOException e) {
	   e.printStackTrace();
	   return false;
	  } finally {
	   if (stream != null) {
	    try {
	     stream.close();
	    } catch (IOException e) {
	     e.printStackTrace();
	    }
	   }
	  }
	 }
	 private static Hashtable<String, Properties> pptContainer = new Hashtable<String, Properties>();
	 /**
	  * 
	  * 方法用途和描述: 获得属性文件的属性 
	  * 
	  * @param propertyFilePath
	  *            属性文件(包括类路径)
	  * @return 属性
	  * @author dengcd 新增日期：2008-10-9
	  * @author 你的姓名 修改日期：2008-10-9
	  * @since wapportal_manager version(2.0)
	  */
	 public final static Properties getProperties(String propertyFilePath) {
	  if (propertyFilePath == null) {
	   return null;
	  }
	  Properties ppts = pptContainer.get(propertyFilePath);
	  if (ppts == null) {
	   ppts = loadPropertyFile(propertyFilePath);
	   if (ppts != null) {
	    pptContainer.put(propertyFilePath, ppts);
	   }
	  }
	  return ppts;
	 }
	
	 /**
	  * 
	  * 方法用途和描述: 加载属性 
	  * 
	  * @param propertyFilePath
	  *            属性文件(包括类路径)
	  * @return 属性
	  * @author dengcd 新增日期：2008-10-9
	  * @author 你的姓名 修改日期：2008-10-9
	  * @since wapportal_manager version(2.0)
	  */
	 private static Properties loadPropertyFile(String propertyFilePath) {
	  java.io.InputStream is = ResourceUtil_Expand.class.getResourceAsStream(propertyFilePath);
	  if (is == null) {
	   return loadPropertyFileByFileSystem(propertyFilePath);
	  }
	  Properties ppts = new Properties();
	  try {
	   ppts.load(is);
	   return ppts;
	  } catch (Exception e) {
	   return null;
	  }
	 }
	 
	 /**
	  * 
	  * 方法用途和描述: 从文件系统加载属性文件 
	  * 
	  * @param propertyFilePath
	  *            属性文件(文件系统的文件路径)
	  * @return 属性
	  * @author dengcd 新增日期：2008-10-9
	  * @author 你的姓名 修改日期：2008-10-9
	  * @since wapportal_manager version(2.0)
	  */
	 private static Properties loadPropertyFileByFileSystem(
	   final String propertyFilePath) {
	  try {
	   Properties ppts = new Properties();
	   ppts.load(new java.io.FileInputStream(propertyFilePath));
	   return ppts;
	  } catch (java.io.FileNotFoundException e) { 
	   		return null;
	  } catch (java.io.IOException e) {
	   return null;
	  }
	 }

	 /**
	  * 
	  * 方法用途和描述: 保存属性文件对象 
	  * 
	  * @param properties
	  *            属性文件对象
	  * @param propertyFilePath
	  *            要保存的路径
	  * @param msg
	  *            保存时添加的附加信息（注释）
	  * @author dengcd 新增日期：2008-10-9
	  * @author 你的姓名 修改日期：2008-10-9
	  * @since wapportal_manager version(2.0)
	  */
	 public final static void store(Properties properties,
	   String propertyFilePath, String msg) {
	  try {
	   java.io.OutputStream stream = new java.io.FileOutputStream(
	     propertyFilePath);
	   properties.store(stream, msg);
	  } catch (java.io.FileNotFoundException e) {
	  } catch (java.io.IOException e) {
	   e.printStackTrace();
	  }
	 }
	 
	 /**
	  * 
	  * 方法用途和描述:删除属性文件中的Key数组所对应的键值对，并将属性文件对象持久化（即保存）
	  * 
	  * 
	  * @param propertyFilePath
	  *            属性文件路径(包括类路径及文件系统路径)
	  * @param key
	  *            属性文件中的key数组
	  * @return 成功与否（true|false）
	  * @author dengcd 新增日期：2008-10-9
	  * @author 你的姓名 修改日期：2008-10-9
	  * @since wapportal_manager version(2.0)
	  */
	 public final static boolean removeValueAndStore(String propertyFilePath,
	   String[] key) {
	  Properties ppts = removeValue(propertyFilePath, key);
	  if (ppts == null) {
	   return false;
	  }
	  store(ppts, propertyFilePath, "batch remove key value!");
	  return true;
	 }

	 /**
	  * 
	  * 方法用途和描述: 删除属性文件中的Key数组所对应的键值对 
	  * 
	  * @param propertyFilePath
	  *            属性文件路径(包括类路径及文件系统路径)
	  * @param key
	  *            key数组
	  * @return 属性文件对象
	  * @author dengcd 新增日期：2008-10-9
	  * @author 你的姓名 修改日期：2008-10-9
	  * @since wapportal_manager version(2.0)
	  */
	 public final static Properties removeValue(String propertyFilePath,
	   String[] key) {
	  if (key == null) {
	   return null;
	  }
	  Properties ppts = getProperties(propertyFilePath);
	  if (ppts == null) {
	   return null;
	  }
	  for (String strKey : key) {
	   ppts.remove(strKey);
	  }
	  return ppts;
	 }
	 
	public static void main(String[] args) {
		String aa=getConfigByName("zhuanbing","item_detail_add");
		System.out.println(aa);
	}
 

	private static final ResourceBundle bundle = java.util.ResourceBundle.getBundle("sysConfig");
	 
	
	/**
	 * zczadd
	 * @return
	 */
	public static final TSUser getSessionUserName() {
		HttpSession session = ContextHolderUtils.getSession();
		if(ClientManager.getInstance().getClient(session.getId())!=null){
			return ClientManager.getInstance().getClient(session.getId()).getUser();

		}else{
			TSUser u = (TSUser) session.getAttribute(ResourceUtil.LOCAL_CLINET_USER);
			Client client = new Client();
	        client.setIp("");
	        client.setLogindatetime(new Date());
	        client.setUser(u);
	        ClientManager.getInstance().addClinet(session.getId(), client);
		}

		return null;
	}
	
	 
	
	
}
