<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%-- /WebContent/model2/member/updateForm.jsp--%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ���� </title>
<script type="text/javascript">
    function win_upload() {
 	   var op = "width=500, height=150, left=50,top=150";
	   open("pictureForm.me","",op);    	
    }
    function win_passchg() {
 	   var op = "width=500, height=230, left=50,top=150";
 	   open("passwordForm.me","",op);
    }    
   function  inputcheck(f) {
    <c:if test="${sessionScope.login != 'admin'}">	   
	   if(f.pass.value == "") {
		   alert("��й�ȣ�� �Է��ϼ���");
		   f.pass.focus();
		   return false;
	   }
    </c:if> 
   }
</script>
</head>
<body>
<form action="update.me" name="f" method="post" 
       onsubmit="return inputcheck(this)">
   <input type="hidden" name="picture" value="${info.picture}">
<table  class="w3-table-all">
<tr><td rowspan="4" valign="bottom">
  <img src="picture/${info.picture}" width="100" height="120" id="pic"><br>
  <font size="1"><a href="javascript:win_upload()">��������</a></font>
</td><th>���̵�</th>
     <td><input type="text" name="id" readonly  value="${info.id}"></td></tr>
<tr><td>��й�ȣ</td><td><input type="password" name="pass" ></td></tr>
<tr><td>�̸�</td>
    <td><input type="text" name="name" value="${info.name}"></td></tr>
<tr><td>����</td>
     <td><input type="radio" name="gender" value="1"
        ${info.gender==1?"checked":""}>��
        <input type="radio" name="gender" value="2"
        ${info.gender==2?"checked":""}>��</td></tr>
<tr><td>��ȭ��ȣ</td>
<td colspan="2"><input type="text" name="tel" value="${info.tel}"></td></tr>
<tr><td>�̸���</td>
<td colspan="2"><input type="text" name="email" value="${info.email}"></td></tr>
<tr><td colspan="3"><input type="submit" value="ȸ������">
<c:if test="${sessionScope.login != 'admin' 
              || param.id == sessionScope.login}">
<input type="button" value="��й�ȣ����" onclick="win_passchg()">
</c:if></td></tr>
</table></form></body></html>