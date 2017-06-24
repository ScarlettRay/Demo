<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
        <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<%=basePath %>js/addCookie.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome!</title>
</head>
<body>
welcome to A!
<s:iterator value="SSOurls" status="i" var="url">
<s:hidden value="%{url}" id="%{#i.index}"></s:hidden>
</s:iterator>
<s:hidden value="%{addId}" name="addId"></s:hidden>
<%=path %>
</body>
</html>