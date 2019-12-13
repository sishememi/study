<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%--
    	1. id�� �ش��ϴ� ������  db���� ��ȸ
    	2. ������ �����ϸ� ��й�ȣ ����
    		 -> db�� ��й�ȣ�� �Էµ� ��й�ȣ�� Ȯ��
    		 	�´� ��� : session �α��� ���� ���. Ȯ�� �޼��� ���.
    		 => main.jsp�� �������̵�
    		 	��й�ȣ��	Ʋ�� ��� : '��й�ȣ�� Ʋ���ϴ�. �ٽ� Ȯ���ϼ���' �޼��� ���	
    		id�� ������ ȭ�鿡 '���̵� Ȯ���ϼ���' �޼��� ���
    		 => loginForm.jsp�� ������ �̵�
     --%>
     <%-- MVC
     		��1 : �⺻JSP ����
     		��2 : EL,JSTL ,myBatis��� �����ӿ�ũ�� �̿��Ͽ� �𵨱���.
     	 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α��� ȸ������ ��ȸ</title>
</head>
<body>
<%
	String id = request.getParameter("id"); //��û��ü�� ���� id,password������
	String pass = request.getParameter("pass");
	//db���� 
	Class.forName("org.mariadb.jdbc.Driver"); //db����
	Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/classdb", "scott", "1234"); //db����
	String sql = "select * from member where id=?";
	PreparedStatement pstmt = conn.prepareStatement(sql); 
	pstmt.setString(1,id); //ù��° ?�� �Է��� id�� ����
	//db�� ���� id�� �ش��ϴ� ���� �б�.
	ResultSet rs = pstmt.executeQuery();
	if(rs.next()){ //id ����
		
	String dbPass = rs.getString("pass");
	if(pass.equals(dbPass)){ //��й�ȣ �´� ���. �α��� ����
		session.setAttribute("login", id);
		String name = rs.getString("name");
%>
<script type="text/javascript">
	alert("<%=name%>���� �α��� �ϼ̽��ϴ�.");
	location.href='main.jsp';
</script>
<%	}else{ //��й�ȣ�� Ʋ�����
%>
<script type="text/javascript">
	alert("��й�ȣ�� Ʋ���ϴ�. Ȯ���ϼ���");
	location.href="loginForm.jsp";
</script>	
<%	}	
	}else{ //id ���� ���
		
		
%>
<script type="text/javascript">
	alert("���̵� Ȯ���ϼ���");
	location.href="loginForm.jsp";
</script>	
<% 	} %>

</body>
</html>