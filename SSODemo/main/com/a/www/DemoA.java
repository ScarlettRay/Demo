package com.a.www;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.a.www.util.DemoAUtil;
import com.opensymphony.xwork2.ActionSupport;

public class DemoA extends ActionSupport {
	
	private String name;

	private String password;

	private String addId;
	
	private Set<String> SSOurls;
	
	public String loginPage(){
		return SUCCESS;
	}
	
	public String doLogin(){
		if(DemoAUtil.checklogin(name, password)){
			SSOurls=new HashSet<String>();
			SSOurls.add("http://www.a.com:8080/SSO-different-yu/DemoA/addCookie.action");
			SSOurls.add("http://www.b.com:8080/SSO-different-yu/DemoB/addCookie.action");
			addId="SSOLogin";
			return SUCCESS;
		}
		
		return "login";
	}
	
	public void addCookie(){
		//¼ì²éÊÇ·ñÒÑµÇÂ¼
		if("SSOLogin".equals(addId)){
		String allow_No_Origin="http://www.b.com:8080";
		Cookie cookie=new Cookie("SSOCookie", "hello");
		cookie.setPath("/");
		HttpServletResponse response=(HttpServletResponse)ServletActionContext.getResponse();
		response.addHeader("Access-Control-Allow-Origin",allow_No_Origin);
		response.addCookie(cookie);
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddId() {
		return addId;
	}

	public void setAddId(String addId) {
		this.addId = addId;
	}

	public Set<String> getSSOurls() {
		return SSOurls;
	}

	public void setSSOurls(Set<String> sSOurls) {
		SSOurls = sSOurls;
	}

	
	
	
	
}
