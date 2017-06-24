package struts_interceptors;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.SSO.entyties.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import sun.net.www.protocol.http.HttpURLConnection;


public class SSOInterceptor extends AbstractInterceptor{

	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//判斷是否已登錄
		if(ActionContext.getContext().getSession().get("User")!=null) return invocation.invoke();
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String actionName=invocation.getProxy().getActionName();
		
		Map<String, String> map=null;
		String url=null;
		String requestUrl=null;
		//查看Cookies是否合法
		Cookie cookies[]=request.getCookies();
		if(cookies!=null){
		for(Cookie cookie:cookies){
			if("SSOCookie".equals(cookie.getName())&&cookie.getValue()!=null){
				map=new HashMap<String,String>();
				url="http://www.x.com:8080/SSO-different-yu/Checklogin.action";//认证服务器地址
				map.put("SSOCookie", (String)cookie.getValue());
				if("1".equals(doCookieCheck(url,map))){//发送到认证服务器，结果一为Cookie正确
					User user=new User("user","123");
					request.getSession().setAttribute("User", user);
					if(actionName.startsWith("login"))return "SSOlogin";//是去登陆页面，直接登陆
					return invocation.invoke();
				}
			}
		}
		}
		//获取request的url，来判断是否是去登陆
		
		if(actionName.startsWith("toLogin")||actionName.startsWith("login")||actionName.startsWith("addCookie")){
			return invocation.invoke();
		}
		
		return "login"; 
	}
	
	/*向指定Url发送请求，获得返回数据
	 *
	 */	
	public static String doCookieCheck(String check_server_url,Map<String,String> map) {
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
}