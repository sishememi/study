<%-- 
  http://localhost:8080/jspstudy1/model1/member/loginForm.jsp
  .. : �������� 
  "../../css/main.css" : ����� ���
  "/jspstudy1/css/main.css" : ���� ��� ���
<link rel="stylesheet" href="../../css/main.css">
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- /WebContent/model2/member/loginForm.jsp --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α��� ȭ��</title>
<link rel="stylesheet" href="../../css/main3.css">
<script type="text/javascript">
   function win_open(page) {
	   var op = "width=500, height=350, left=50,top=150";
	   open(page+".me","",op);
   }
</script>

</head>
<body>
<form action="login.me" method="post" name="f">
<table>
  <caption>�α���</caption>
  <tr><th>���̵�</th><td><input type="text" name="id"></td></tr>
  <tr><th>��й�ȣ</th><td><input type="password" name="pass"></td></tr>
  <tr><td colspan="2">
     <input type="submit" value="�α���">
     <input type="button" value="ȸ������"
        onclick="location.href='joinForm.jsp'">
     <input type="button" value="���̵�ã��"
                  onclick="win_open('idForm')">
     <input type="button" value="��й�ȣã��" 
                  onclick="win_open('pwForm')">
  </td></tr></table></form></body></html>