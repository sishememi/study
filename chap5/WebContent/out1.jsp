<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>out ���� ��ü ����</title>
</head>
<body>
<h3>out ��ü�� response ��ü�� ��� ���ۿ� �����͸� ���� �� �ִ�
	��� ��Ʈ�� ��ü��.</h3>
<%
	int sum = 0;
	for(int i=1; i<=100; i++){
		sum+= i;
%>
		1���� <%=i %> ������ �κ���: <%=sum %><br>
		
<% }  %>
<br>

<%
	sum = 0;
	for(int i=1; i<=100; i++){
		sum+= i;
		out.println("1����"+i+"������ �κ���:"+sum+"<br>");

	}  %>
</body>
</html>