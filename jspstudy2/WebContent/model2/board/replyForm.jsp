<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խ��� �亯 �۾���</title>
<link rel="stylesheet" href="../../css/mainboard.css">
</head>
<body>
<form action="reply.do" method="post" name="f">
	<input type="hidden" name="num" value="${b.num}"> <!-- hidden������ ���ۿ� ���Ѱ͵�. -->
	<input type="hidden" name="grp" value="${b.grp}">
	<input type="hidden" name="grplevel" value="${b.grplevel}">
	<input type="hidden" name="grpstep" value="${b.grpstep}">
	<table><caption>�Խ��� ��� ���</caption>
	<tr><td>�۾���</td><td><input type="text" name="name"></td></tr>
	<tr><td>��й�ȣ</td><td><input type="password" name="pass"></td></tr>
	<tr><td>����</td><td><input type="text" name="subject" value="RE:${b.subject}"></td></tr>
	<tr><td>����</td><td><textarea name="content" rows="15"></textarea></td></tr>
	<tr><td colspan="2"><a href = "javascript:document.f.submit()">[�亯 ���]</a></td></tr> <!-- javascript:document.f.submit() => reply.jsp�� �̵� -->
</table>
</form>
</body>
</html>