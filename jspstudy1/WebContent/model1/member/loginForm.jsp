<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--
    ..:��������
    "../../css/main.css" : ����� ���
    "/jspstudy1/css/main.css" �����ι��
 	<link rel="stylesheet" href="../../css/main.css">
--%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α��� ȭ��</title>
<link rel="stylesheet" href="../../css/main3.css">
<script>
	function find_id(){
		var nw = open("idForm.jsp","id","width=600,height=200,menubar=no,top=200,left=200")
	}
	
	function find_pw(){
		var nw = open("pwForm.jsp","pw","width=600,height=250,menubar=no,top=200,left=200")
	}
</script>
</head>
<body>
<form action="login.jsp" method="post" name="f">
<table>
	<caption>�α���</caption>
	<tr><th>���̵�</th><td><input type="text" name="id"></td></tr>
	<tr><th>��й�ȣ</th><td><input type="password" name="pass"></td></tr>
	<tr><td colspan="2">
		<input type="submit" value="�α���">
		<input type="button" value="ȸ������" onclick="location.href='joinForm.jsp'">
		<input type="button" value="���̵�ã��" onclick="javascript:find_id()">
		<input type="button" value="��й�ȣã��" onclick="javascript:find_pw()"></td></tr>
</table>
</form>
</body>
</html>