<%@page import="model.Member"%>
<%@page import="model.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--
	
 --%>
<%
	String email = request.getParameter("email");
	String tel = request.getParameter("tel");	
	MemberDao dao = new MemberDao();
	Member mem = new Member();
	String id = dao.idfind(email, tel);
//	if(!tel.equals(mem.getTel()) || !email.equals(mem.getEmail())){
	if(id != null){ //id�� ã�°��
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="../../css/main3.css">
<script>
 	function idsend(id) {
		 opener.document.f.id.value = id;
 		 self.close();
 	}

</script>
<title>id ã��</title>
</head>
<body>
<table>
   <tr><th>���̵�</th>
      <td><%=id.substring(0, id.length()-2) + "**" %></td></tr>
   <tr><td colspan="2"><input type="button" value="���̵�����" 
							onclick="idsend('<%=id.substring(0, id.length()-2)%>')"></td></tr>
</table>
</body>
</html>
<% }  else {  //id�� ã�� �� ���� ��� %>
<script>
	alert("������ �´� id�� ã�� �� �����ϴ�.");
	location.href="idForm.jsp";
</script>
<% } %>