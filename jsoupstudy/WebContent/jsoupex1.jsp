<%@page import="org.jsoup.nodes.Element"%>
<%@page import="org.jsoup.select.Elements"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@ page import="java.io.IOException" %>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--  ũ�Ѹ� ���ִ� ������ jsoup�̴�! -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ũ�Ѹ� ����</title>
<style type="text/css">
	table,td,th{border : 2px solid grey;}
 </style>
</head>
<body>
<%
	String url = "http://www.hanwhaeagles.co.kr/html/players/player/pitcher_view.asp?sGubunCd=PLPPPC&sMSId=P145";
	String line ="";
	String title="";
	try{
		//�ҽ���ü
		Document doc = Jsoup.connect(url).get();
		Elements body = doc.select(".personAreaInner > .img");
		for(Element src : body){
			out.println(src.toString());
		}
	}catch(IOException e){
			e.printStackTrace();
	}
%>
<%=title %>
</body>
</html>