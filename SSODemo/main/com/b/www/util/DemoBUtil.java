package com.b.www.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.SSO.entyties.User;
import com.opensymphony.xwork2.ActionContext;

import sun.net.www.protocol.http.HttpURLConnection;

public class DemoBUtil {

	//检查用户的合法性
	public static boolean checklogin(String name,String password){
		if(ActionContext.getContext().getSession().get("User")!=null)return true;
		Map<String,String> map=new HashMap<String,String>();
		map.put("name", name);
		map.put("password", password);
		if("1".equals(doCheck("http://www.x.com:8080/SSO-different-yu/Checklogin.action",map))){
			ActionContext.getContext().getSession().put("User", new User("user","123"));
			return true;
		}
		return false;
	}

	
	/*向指定Url发送请求，获得返回数据
	 *
	 */	
	public static String doCheck(String check_server_url,Map<String,String> map) {
		HttpURLConnection connection=null;
		StringBuffer temp=new StringBuffer(check_server_url);
		//添加参数
		temp.append("?");
		for(Map.Entry<String, String> entry:map.entrySet()){
			temp.append(entry.getKey()+"="+entry.getValue()+"&");
		}
		check_server_url=temp.substring(0,temp.length()-1);
		URL url;
		try {
			//建立连接，获取返回内容
			url = new URL(check_server_url);
			connection=(HttpURLConnection) url.openConnection();
			InputStream is=connection.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			String temp2=null;
			temp=new StringBuffer();
			while((temp2=br.readLine())!=null){
				temp.append(temp2);
			}
			is.close();
			isr.close();
			br.close();
		}catch (Exception e) {
				e.printStackTrace();
		}finally{
			connection.disconnect();
		}
		
		return temp.toString();
	
}
	
	//发送添加Cookie的请求
	@Deprecated
	public static String doAddCookie(){
		Set<String> SSOurls=new HashSet<>();
		SSOurls.add("http://www.a.com:8080/SSO-different-yu/DemoA/addCookie.action");
		SSOurls.add("http://www.b.com:8080/SSO-different-yu/DemoB/addCookie.action");
		
		Map<String,String> map=new HashMap<String,String>();
		map.put("addId", "SSOLogin");
		for(String SSOurl:SSOurls){
				System.out.println(SSOurl);
				doCheck(SSOurl,map);
		}
		return null;
	}
}
