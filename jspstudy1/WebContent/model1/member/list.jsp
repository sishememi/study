<%@page import="model.MemberDao"%>
<%@page import="model.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%--
    	1.�α׾ƿ� ����: �α����� �ʿ��մϴ�. �޼��� ���
    				 loginForm.jsp�� �������̵�
    	2.�α��� ����
    		�Ϲ� �����: �����ڸ� ������ �ŷ��Դϴ�. �޼��� ���
    				 main.jsp�� ������ �̵�
    		������
    	3.db���� ��� ȸ�� ������ ��ȸ�Ͽ� List<Member> ��ü�� ����
    		List<Member> list = new MemberDao().list();
     --%>
 <%
 	String login = (String)session.getAttribute("login");
	if(login == null || login.trim().equals(""))
	{ //�α��� �ȵ� ���
%> 
	<script>
		alert("�α����� �ʿ��մϴ�.");
		location.href="loginForm.jsp";
	</script>
<%	} else if(!login.equals("admin")) { 	
%>
		<script>
		alert("�����ڸ� ���� �����մϴ�.");
		location.href="main.jsp";
		</script>
<% } else {
	List<Member> list = new MemberDao().list(); //MemberDao�� ����ؼ� db�κ��� ������.(MemberDao.java�� �ۼ�)
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ��Ϻ���</title>
<link rel="stylesheet" href="../../css/main3.css">
</head>
<body>
<table><caption>ȸ�� ���</caption>
<tr></tr><th>���̵�</th><th>�̸�</th><th>����</th><th>��ȭ</th><th>&nbsp;</th>
<% for(Member m : list) { //����Ʈ �ϳ��ϳ��� ��ü.
 %>
         <tr><td><a href="info.jsp?id=<%=m.getId() %>"><%=m.getId() %></a></td> <!-- href="info.jsp?id=m.getId() info.jsp�� ���� id����-->
         <td><%=m.getName() %></td>
         <td><%=m.getGender()==1?"��":"��" %></td>
         <td><%=m.getTel() %></td>
         <td><a href="updateForm.jsp?id=<%=m.getId() %>">[����]</a>
<%
       if(!m.getId().equals("admin")) 
         {
%>
            <a href="delete.jsp?id=<%=m.getId() %>">[����Ż��]</a>
      <%  } %></td></tr>
   <% } %>
</table>
</body>
</html>
<%	} %>