<%@page import="org.jsoup.nodes.Element"%>
<%@page import="org.jsoup.select.Elements"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@ page import="java.io.IOException" %>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--  jsoup2.jsp : jsoup1.jsp ���� tr�±׵鸸 �����Ͽ� ��� 
	html root �±� : html
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Jsoup�� �̿��� ũ�Ѹ� ����</title>
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
		//�±׵��� dom�̶�� ����...?
		doc = Jsoup.connect(url).get(); //url�� dom ��ä ,doc Ȩ�������� ���� ������ ������ ����..?
		//e1 =  url�� �����ϴ� html ���� ��  �±װ� table �±׵鸸 ����
		Elements e1 = doc.select("table");
		for(Element ele : e1){
			Elements e2 = ele.select("tr"); //e2 = tr�鸸 ����������, ���ڵ�鸸 �������ִ�. class �Ӽ� ���������� ex).tc / id �Ӽ� ���������� ex)#tc
			for(Element ele2 : e2){
				String temp  = ele2.html(); //tr�ȿ��ִ� ���븸 �������ִ�.
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