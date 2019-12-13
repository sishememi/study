<%@page import="model.Member"%>
<%@page import="model.MemberDao"%>
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
	//MemberDao Ŭ���� : Model ��� Ŭ����
	//Model : dbms�� �����ִ� ����� ���� Ŭ����
	Member mem = new MemberDao().selectOne(id);
	if(mem != null) { //id ����
		if(pass.equals(mem.getPass())){ //��й�ȣ �´� ���. �α��� ���� /pass=>�Էµȳ���  mem.getPass()=>�����ͺ��̽��� �ִ³���
		session.setAttribute("login", id); //�α��� ���� ��� , login �̶�� ������ �����Ѱ���  id������ ��.
%>
<script type="text/javascript">
	alert("<%=mem.getName()%>���� �α��� �ϼ̽��ϴ�."); 
	//Name �� ��
	location.href='main.jsp'; //main �������� �̵�.
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