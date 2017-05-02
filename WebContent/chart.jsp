<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<base href="<%=basePath%>">

<title>jfreechart 演示</title>


</head>

<body>
    <div style="margin:0px 200px">
		<a href="getChart.do">查看统计图形</a>
		<br>
		<img src="${chartURL}">
	</div>
</body>
</html>