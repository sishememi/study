<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>현재시간</title>
</head>
<body>
<!-- <%%> = 자바의 영역 -->
<%
	java.util.Calendar c = java.util.Calendar.getInstance();
	int h = c.get(java.util.Calendar.HOUR_OF_DAY);
	int m = c.get(java.util.Calendar.MINUTE);
	int s = c.get(java.util.Calendar.SECOND);
%>
<h1>현재시간은 <%=h%>시<%=m%>분<%=s%>초 입니다.</h1>
</body>
</html>