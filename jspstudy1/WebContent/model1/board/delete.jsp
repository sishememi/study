
<%@page import="model.Board"%>
<%@page import="model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--
	1. num,pass �Ķ���͸� ������ ����.
	2. �Էµ� ��й�ȣ�� db ��й�ȣ ����
		Ʋ�����: ��й�ȣ ���� �޼��� ���, deleteForm.jsp ������ �̵�
	3. ��й�ȣ�� �´� ��� : �Խù� ����.
		���� ���� : ���� ���� �޼��� ���. list.jsp ������ �̵�
		���� ����  : ���� ���� �޼��� ���. info.jsp ������ �̵�
 --%>
 <%
 	
	int num = Integer.parseInt(request.getParameter("num"));
 	String pass = request.getParameter("pass"); //�Էµ� ��й�ȣ
 	String msg = "��й�ȣ�� Ʋ���ϴ�.";
 	String url = "deleteForm.jsp?num=" + num;
//	String msg = null;
// 	String url = null;
 	BoardDao dao = new BoardDao();
 	Board b = dao.selectOne(num);
 	if(b == null){
 		msg = "���� �Խñ��Դϴ�.";
 	 	url = "list.jsp";
 	}else{
 		if(pass.equals(b.getPass())){
 			 msg = "��й�ȣ�� Ʋ���ϴ�.";
 	 		 url = "deleteForm.jsp?num=" + num;
 		
 		if(dao.delete(num))
 		{
			msg = "�Խù� ���� �Ϸ�";
			url = "list.jsp";
		}
 		else 
		{
			msg= "�Խù� ���� ���� ";
			url = "info.jsp?num=" + num;
		}			
 	}
 }
 %>
<script>
	alert("<%=msg%>");
	location.href="<%=url %>";
</script>
<!-- �����Ѱ�
 	if(b == null){
 		msg = "���� �Խñ��Դϴ�.";
 	 	url = "list.jsp";
 	}else{
 		if(!pass.equals(b.getPass())){
 			 msg = "��й�ȣ�� Ʋ���ϴ�.";
 	 		 url = "deleteForm.jsp?num=" + num;
 		}else{
 		
 			if(dao.delete(num))
 			{
				msg = "�Խù� ���� �Ϸ�";
				url = "list.jsp";
			}
 			else 
			{
				msg= "�Խù� ���� ���� ";
				url = "info.jsp?num=" + num;
			}			
 	}
 }
 -->
