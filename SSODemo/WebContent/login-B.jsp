<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login first</title>
</head>
<body>
<center>
<s:form action="toLogin" namespace="/DemoB">
<s:textfield name="name" label="用户名"></s:textfield>
<s:password name="password" label="密码"></s:password>
<s:submit name="登录"></s:submit>
</s:form>
</center>
</body>
</html>