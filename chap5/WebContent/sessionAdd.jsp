<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ٱ��� �߰�</title>
</head>
<body>
<%
	request.setCharacterEncoding("euc-kr");
	String product = request.getParameter("product");//���
	//getAttribute : cart �Ӽ��� ��ü�� ����. ��ϵ� �Ӽ��� ���� ��ȸ
	List<String> cart =(List<String>)session.getAttribute("cart");
	if(cart == null){ //cart �Ӽ��� ���� ���
		cart = new ArrayList<String>();
	//setAttribute : session ��ü�� cart �Ӽ��� ���.
		session.setAttribute("cart",cart);
	}
cart.add(product);
%>
<script>
	alert("<%=product %>��(��) ��ٱ��Ͽ� �߰��Ǿ����ϴ�.")
	history.go(-1); //���������� �̵�
</script>
</body>
</html>