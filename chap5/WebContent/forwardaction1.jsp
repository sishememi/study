<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--forwardaction1--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jsp Action �±� ����</title>
</head>
<body>
<h3>�� �������� forwardaction2.jsp�� forward �˴ϴ� 
�� ������ ȭ�鿡 ��µ��� �ʽ��ϴ� forward �ɶ� request ��ü�� forwardaction2.jsp �������� ���޵˴ϴ� <br>
��, forwardaction1.jsp�� forwardaction2.jsp �������� ���� request ������ �������Դϴ�</h3>
<jsp:forward page="forwardaction2.jsp">
<jsp:param value="***" name="test"/>
<jsp:param value="forward test" name="add"/>
</jsp:forward>
</body>
</html>