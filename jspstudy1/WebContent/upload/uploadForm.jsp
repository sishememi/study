<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ���ε� ����</title>
<link rel="stylesheet" href="../css/main.css">
</head>
<body>
<%--
	���� ���ε�� �ݵ�� enctype="multipart/form-data" �����ؾ���.
	=>�Ķ���� ������ ���õ� ������ ������� ������ �����ϵ��� ����
	method="post" ������.
	���ǻ���
	upload.jsp ������������ request ��ü�� ����� �� ����.
	cos.jar ���Ͽ� ������ MultipartRequest ��ü�� ����Ͽ�
	�Ķ���Ϳ� ������ ������ ����� �� �ִ�.
 --%>
<form action="upload.jsp" method="post" enctype="multipart/form-data"> <!-- enctype="multipart/form-data" => ���õ� ������ ��������� ������ ���ε��Ҷ�  ����-->
<table>
<tr><th>�ø����</th><td><input type="text" name="name"></td></tr>
<tr><th>����</th><td><input type="text" name="title"></td></tr>
<tr><th>����</th><td><input type="file" name="file1"></td></tr>
<tr><td colspan="2"><input type="submit" value="����"></td></tr>
</table>
</form>
</body>
</html>