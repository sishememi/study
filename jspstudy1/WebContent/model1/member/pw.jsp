<%@page import="model.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
   String id = request.getParameter("id");
   String email = request.getParameter("email");
   String tel = request.getParameter("tel");
   MemberDao dao = new MemberDao();
   String pass = dao.pwSearch(id,email,tel); 
   if(pass != null) {
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��й�ȣã��</title>
<link rel="stylesheet" href="css/main3.css">
<script type="text/javascript">
   function pwclose() {
	   self.close();
   }
</script>
</head>
<body>
<table>
  <tr><th>��й�ȣ</th>
    <td><%="**"+pass.substring(2,pass.length()) %></td>
  </tr>
  <tr><td colspan="2">
     <input type="button" value="�ݱ�" onclick="pwclose()">
  </td>
  </tr>
</table>
</body>
<% }  else { %>
<script>
   alert("������ �´� ��й�ȣ�� ã�� �� �����ϴ�.");
   location.href="pwForm.jsp";
</script>
<% } %>
</html>