<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���۵� �Ķ���� ����</title>
</head>
<body>
<%
	request.setCharacterEncoding("euc-kr");
	String name = request.getParameter("name");/*request�߿� �̸��� name �� ���� ������ */
	String age  = request.getParameter("age");
	String gender  = request.getParameter("gender");
	String hobby  = request.getParameter("hobby");
	String year  = request.getParameter("year");
	
%>
�̸�:<%=name %><br>
����:<%=age %><br> <!-- /*age���� ��´�*/ -->
����:<%=gender.equals("1")?"��":"��" %><br>
���:<%=hobby %><br>
����⵵:<%=year %><br>
<h3> ��� ���� ��� ��ȸ�ϱ�</h3>
<%
	String[] hobbies = request.getParameterValues("hobby");
	for(String h : hobbies){%>
		<%=h %> &nbsp;&nbsp;
<%	} %><br>
<h3>��� �Ķ���� ���� ��ȸ�ϱ�</h3>
<table><tr><th>�Ķ���� �̸�</th></tr><tr><th>�Ķ���� ��</th></tr>
<%
//getParameterNames() : �Ķ������ �̸���.
//Enumeration : Iterator ������. �ݺ���
	Enumeration e = request.getParameterNames();
	while(e.hasMoreElements()){
		//�Ķ������ �̸�
		String pname = (String)e.nextElement();
		String [] pvalue = request.getParameterValues(pname);
%>	
	<tr><td><%=pname %></td>
		<td><%for (String v: pvalue) { %>
		<%=v %> &nbsp;&nbsp;<%} %>
		</td></tr>
<% } %>
</table>
</body>
</html>