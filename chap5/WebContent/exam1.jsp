<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���۵� ���� ����</title>
</head>
<body>
<%
	int number = Integer.parseInt(request.getParameter("num")); //�ڹٿ����� Integer.parseInt�� ��� ,parseInt�� �ڹٽ�ũ��Ʈ������ 
	int sum = 0;
	for(int i=1; i<=number; i++){
		sum+=i;
}%>
�հ�:<%=sum  %>
</body>
</html>