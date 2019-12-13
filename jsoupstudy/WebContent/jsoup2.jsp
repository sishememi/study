<%@page import="org.jsoup.nodes.Element"%>
<%@page import="org.jsoup.select.Elements"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@ page import="java.io.IOException" %>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--  jsoup2.jsp : jsoup1.jsp 에서 tr태그들만 선택하여 출력 
	html root 태그 : html
-->
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
		//태그들은 dom이라는 형태...?
		doc = Jsoup.connect(url).get(); //url은 dom 객채 ,doc 홈페이지에 나온 정보를 가지고 있음..?
		//e1 =  url이 제공하는 html 문서 중  태그가 table 태그들만 저장
		Elements e1 = doc.select("table");
		for(Element ele : e1){
			Elements e2 = ele.select("tr"); //e2 = tr들만 가지고있음, 레코드들만 가지고있다. class 속성 가져오려면 ex).tc / id 속성 가져오려면 ex)#tc
			for(Element ele2 : e2){
				String temp  = ele2.html(); //tr안에있는 내용만 가지고있다.
				System.out.println("===========");
				System.out.println(temp);
				line += "<tr>"+temp + "</tr>";
			}
		}
	}catch(IOException e){
			e.printStackTrace();
	}
%>
<table><%=line %></table>
</body>
</html>