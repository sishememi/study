<%@page import="model.BoardDao"%>
<%@page import="model.Board"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%--
    	1. ������ num�� �Ķ���ͷ� �޴´�.
    	2. ������ num,grp,grplevel,grpstep ������ ����.
    	3. �Է� ȭ��  ǥ��
     --%>
	<%
//num => ������ num ��
		int num = Integer.parseInt(request.getParameter("num")); // �Ķ���Ͱ� �б�
		BoardDao dao = new BoardDao();
		Board board = dao.selectOne(num);//���ۿ� ���� �Խù� ��ȸ
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խ��� �亯 �۾���</title>
<link rel="stylesheet" href="../../css/mainboard.css">
</head>
<body>
<form action="reply.jsp" method="post" name="f">
	<input type="hidden" name="num" value="<%=board.getNum() %>"> <!-- hidden������ ���ۿ� ���Ѱ͵�. -->
	<input type="hidden" name="grp" value="<%=board.getGrp() %>">
	<input type="hidden" name="grplevel" value="<%=board.getGrplevel()%>">
	<input type="hidden" name="grpstep" value="<%=board.getGrpstep()%>">
	<table><caption>�Խ��� ��� ���</caption>
	<tr><td>�۾���</td><td><input type="text" name="name"></td></tr>
	<tr><td>��й�ȣ</td><td><input type="password" name="pass"></td></tr>
	<tr><td>����</td><td><input type="text" name="subject" value="RE:<%=board.getSubject() %>"></td></tr>
	<tr><td>����</td><td><textarea name="content" rows="15"></textarea></td></tr>
	<tr><td colspan="2"><a href = "javascript:document.f.submit()">[�亯 ���]</a></td></tr> <!-- javascript:document.f.submit() => reply.jsp�� �̵� -->
	<tr><td>�۾���</td><td><input type="text" name="name"></td></tr>
</table>
</form>
</body>
</html>