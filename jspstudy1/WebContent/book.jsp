<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ���� ����</title>
</head>
<body>
<% request.setCharacterEncoding("euc-kr"); %>
<%-- String writer = request.getParameter("writer);	
	 .....
 --%>
 <%--
 	1. useBean=> Book book = new Book();
 	2. pageContext.setAttribute("book",book);
  --%>
<jsp:useBean id="book" class="chap7.Book"/>
<%--
	book ��ü�� ������ ���������
	book.setWriter(request.getParameter("Writer"));
	book.setTitle(request.getParameter("title")
	...
	������Ƽ
	set������Ƽ
	setXxx() => xxx
	get������Ƽ
	getXxx() => xxx
	
	�� useBean�� setProperty �� ����ϸ� �������ִ� �Ķ���� ���� ���� ������ �� �Ӥ���.
 --%>
<jsp:setProperty property="*" name="book"/>
<%--book.setWriter(request.getParameter("name")) --%>
<jsp:setProperty property="wr" name="book" param="name"/>
<table border="1" style="border-collapse: collapse;">
<caption>���� ��ȸ</caption>
<%-- getProperty => book.getWriter() �޼��� ȣ�� , �̸��� book�̰� writer���� ������--%>
<tr><td>�ۼ���</td><td><jsp:getProperty name="book" property="wr"/>,<%=book.getWr() %></td></tr>
<%-- getProperty => book.getTitle() �޼��� ȣ�� --%>
<tr><td>����</td><td><jsp:getProperty name="book" property="title"/>,<%=book.getTitle() %></td></tr>
<%--getProperty => book.getContent() �޼��� ȣ�� --%>
<tr><td>����</td><td><jsp:getProperty name="book" property="content"/>,<%=book.getContent() %></td></tr>
</table>
</body>
</html>