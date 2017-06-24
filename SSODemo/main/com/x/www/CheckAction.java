package com.x.www;

import com.opensymphony.xwork2.ActionSupport;
import com.x.www.util.CheckServerTool;

public class CheckAction extends ActionSupport {
	private String name;
	
	private String password;
	
	private String SSOCookie;
	
	//待加入新功能完善，先简单实现
	public void check(){
		if(name!=null){ CheckServerTool.checkpassword(name,password);
		}else{
			if(SSOCookie!=null ) CheckServerTool.checkCookie(SSOCookie);
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

	public String getSSOCookie() {
		return SSOCookie;
	}

	public void setSSOCookie(String sSOCookie) {
		SSOCookie = sSOCookie;
	}
	
}
