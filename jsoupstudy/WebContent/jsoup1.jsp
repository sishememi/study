<%@page import="org.jsoup.nodes.Element"%>
<%@page import="org.jsoup.select.Elements"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@ page import="java.io.IOException" %>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--  크롤링 해주는 도구가 jsoup이다! -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Jsoup을 이용한 크롤링 예제</title>
<style type="text/css">
	table,td,th{border : 2px solid grey;}
 </style>
</head>
<body>
<%
	String url = "https://www.koreaexim.go.kr/site/program/financial/exchange?menuid=001001004002001";
	String line ="";
	Document doc = null;
	try{
		doc = Jsoup.connect(url).get(); //url은 dom 객채 ,doc 홈페이지에 나온 정보를 가지고 있음..?
		//e1 =  url이 제공하는 html 문서 중  태그가 table 태그들만 저장
		Elements e1 = doc.select("table");
		for(Element ele : e1){
			//ele: table 태그만 한개
			String temp  = ele.html();
			System.out.println("===========");
			System.out.println(temp);
			line += temp;
		}
	}catch(IOException e){
			e.printStackTrace();
	}
%>
<table><%=line %></table>
</body>
</html>