<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խ��� �۾���</title>
<link rel="stylesheet" href="../../css/write.css">
<script type="text/javascript">
function inputcheck(){
	
	f = document.f;
	if(f.type.value==""){
		alert("�Խ����� �����ϼ���");
		f.type.focus();
		return;
	}
	if(f.n.value==""){
		alert("������ �����ϼ���");
		f.n.focus();
		return;
	}
	if(f.subject.value==""){
		alert("������ �Է��ϼ���");
		f.subject.focus();
		return;
	}
	if(f.content.value==""){
		alert("������ �Է��ϼ���");
		f.content.focus();
		return;
	}
	f.submit();
}
</script>
</head>
<body>
<form action="write.do" method="post" enctype="multipart/form-data" name="f">
	<table border="1">
 	<tr><th>�Խ��� ����</th><td colspan="3">
			<select name="type" id="nation">
			<c:set var="arr" value='<%=new String[]{"Tour Info","Restaurant Info","Etc Info","Photo Spot"}%>' />
			<c:forEach var="b" items="${arr}" varStatus="stat">
				<option value="" selected disabled hidden >Tour Info</option>
		   		<option>${b}</option>
		    </c:forEach></select></td></tr>
	<tr><th>���� ����</th>
	 <td>
      	 <select name="n" id="nation">
			<c:set var="arr" value='<%=new String[]{"����","������","������","����Ʈ����","������","��Ż����","������","�� �ܱ���"} %>' />
			<c:forEach var="d" items="${arr}">
				<option value="" selected disabled hidden >����</option>
		   		<option>${d}</option>
		    </c:forEach></select>
    </td> 
	<th>�ۼ���</th><td><input type="text" name="name" value="${login}"></td></tr>
	<tr><th>����</th><td colspan="3"><input type="text" name="subject" style="width:100%"></td></tr>
	<tr><th>����</th><td colspan="3"><textarea rows="10" name="content" id="content1" style="width:100%"></textarea></td></tr>
	<tr><th>÷������</th><td colspan="3"><input type="file" name="file1"></td></tr>
	<tr><td colspan="4" >&nbsp;</td></tr>
	<tr><td colspan="2"><a href="tourForm.do">���</a></td><td colspan="2"><a href="javascript:inputcheck()"> ���</a></td></tr>
</table>
</form>
</body>
</html>