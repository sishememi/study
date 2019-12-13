<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
 tr,td{
 	border:1px solid
 }
</style>
</head>
<body>
<%
	request.setCharacterEncoding("euc-kr");
	String name = request.getParameter("name");
	String title = request.getParameter("title");
	String text = request.getParameter("text");
	Date today = new Date();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>

<table style="border:1px solid;"><caption>방명록</caption>
<tr><td>방문자</td><td ><%=name %></td></tr> 
<tr><td>제목</td><td><%=title %></td><tr>
<tr><td>내용</td><td><%=text %></td><tr>
<tr><td>등록일</td><td><%= df.format(today) %></td></tr>
</table>
</body>
</html>