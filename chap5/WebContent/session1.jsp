<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>session ��ü</title>
</head>
<body>
<h2>session ��ü : �������� ���� ������ �����ϴ� ��ü</h2>
<%
	session.setMaxInactiveInterval(10); //10�� ���������ð� ���� () �ȿ� �ʷ� �־����..!
%>
<h3>session ����</h3>
isNew() : <%=session.isNew() %><br>
�����ð� : <%=session.getCreationTime() %><br>
���� ���ӽð� : <%=session.getLastAccessedTime() %><br>
sessionId : <%=session.getId() %><br>
</body>
</html>