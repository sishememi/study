<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ���ε� ���</title>
</head>
<body>
<%
	String uploadPath = application.getRealPath("/")+"upload/";
	int size = 10*1024*1024;//10M ����
	/* 
	MultipartRequest multi = ... ->���Ͼ��ε� �ѹ��� ����
	new MultipartRequest
		request : ��û��ü. �Ķ���� ���� + ��������
		uploadPath : ���Ͼ��ε�Ǵ� ������ ��ġ����.
		size : �ִ���ε� ���� ũ�� ����Ʈ�� ����.
		"euc-kr" : �Ķ������ ���ڵ� ����.	
	=> ��ü ������ ���ÿ� ���Ͼ��ε� �Ϸ�
	*/
	MultipartRequest multi = new MultipartRequest(request,uploadPath,size,"euc-kr");
	String name = multi.getParameter("name");
	String title = multi.getParameter("title");
	String fname = multi.getParameter("file1");
%>
���ε� ��ġ:<%=uploadPath %><br>
�ø����:<%=name %><br>
����:<%=title %><br>
����:<a href="<%=fname %>"><%=fname %></a><br>
</body>
</html>