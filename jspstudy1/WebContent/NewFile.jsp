<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������ ���� �Է�</title>
<link rel="stylesheet" href="css/syj.css">
</head>
<body>
<form action="join.jsp" method="post">
<table><caption>ȸ������</caption>
<tr><td rowspan="4"></td><td>���̵�</td><td><input type="text" name="id"></td></tr> <!-- �Ķ���� ��=>name="id"�� join.jsp�� ���� ���� ���� -->
<tr><td>��й�ȣ</td><td><input type="password" name="pass"></td></tr>
<tr><td>�̸�</td><td><input type="text" name="name"></td></tr>
<tr><td>����</td><td><input type="radio" name="gender" value="1" checked>��
					<input type="radio" name="gender" value="2">��</td></tr>
<tr><td>��ȭ��ȣ</td><td colspan="2"><input type="text" name="tel"></td></tr>
<tr><td>�̸���</td><td colspan="2"><input type="text" name="email"></td></tr>
<tr><td colspan="3"><input type="submit" value="ȸ������"></td></tr>
</table>
</form>
</body>
</html>