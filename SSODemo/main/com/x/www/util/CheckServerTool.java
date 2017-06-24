package com.x.www.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.SSO.entyties.User;
import com.opensymphony.xwork2.ActionContext;

public class CheckServerTool {
	
		public static void checkCookie(String cookie_value){
			HttpServletResponse respone=ServletActionContext.getResponse();
			PrintWriter writer=null;
			String result="0";
			try {
				writer=respone.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//判断并写入结构
			if("hello".equals(cookie_value))result="1";
			
			writer.print(result);
			writer.close();
		}

		public static void checkpassword(String name,String password) {
			HttpServletResponse respone=ServletActionContext.getResponse();
			PrintWriter writer=null;
			String result="0";
			try {
				writer=respone.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//判断并写入结构
			if("user".equals(name)
					&&"123".equals(password)){
				
				result="1";
			}
			
			writer.print(result);
			writer.close();
		}
}
