<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>forward�ϴ� ������</title>
</head>
<body>
<h1>forward �ϴ� �������Դϴ�. �� ������ ȭ�鿡 ��µ��� �ʽ��ϴ�.</h1>
<% pageContext.forward("forward2.jsp"); %> <!-- pageContext.forward("forward2.jsp") 
forward1���� forward2�� �����ܿ��� ����ϰ� ��� ���尴ü�� ������.foward1�ȿ��� forward2�� �ڱ��������������� ������ ���� 
forward1�� �������ִ� ���尴ü�� forward2�� �����Ա׷��� ���� request��ü�̴�.-->
</body>
</html>