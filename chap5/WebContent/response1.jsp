<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>response ��ü ����</title>
</head>
<body>
<h2>response ��ü�� �������� ó�� ����� ������ �ִ� ���� ��ü��.<br>
	���ο� ��� ���۸� ������ �־, �������� ���� �Ǵ� ������ �����ϰ� �ִ�.<br>
	���� response ��ü�� �̿��Ͽ� ���������� �ٸ� �������� ��û�ϵ���
	����� ������ �� �ִ�.
</h2>
<h3>���� �ۼ� ���� ������ ȭ�鿡 ��µ��� �ʴ´�.</h3>
<% response.sendRedirect("response2.jsp"); %> <!--���䰴ü��  ���û�� �䱸 sendRedirect 
���������� response1�� ������ �������� response1�� ������������ ���û �׷��� �ٽ� ����������response2 �����κ����� �����´ٽ� ����  ���⼭ r1,r2�� requeset��ü�� �ٸ���-->
<!-- Redirect : url�� �ٲ�� �ִ�. -->
</body> 
</html>