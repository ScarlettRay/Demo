package com.SSO;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import struts_interceptors.SSOInterceptor;

public class Test {

//	@org.junit.Test
//	public void test() {
//		Map<String, String> map=new HashMap<String,String>();
//		map.put("name", "user");
//		map.put("password", "123");
//		assertEquals("1", SSOInterceptor.doCookieCheck("http://www.x.com:8080/SSO-different-yu/Checklogin.action", map));
//	}
	@org.junit.Test
	public void test2(){
		Map<String, String> map=new HashMap<String,String>();
		map.put("name", "user");
		map.put("password", "123");
		assertEquals("1", SSOInterceptor.doCookieCheck("http://www.a.com:8080/SSO-different-yu/DemoA/toLogin.action", map));
	}
}
