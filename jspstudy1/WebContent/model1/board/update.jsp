<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="model.BoardDao"%>
<%@page import="model.Board"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%--
 	1. �Ķ������������ Board ��ü ����.
 	2. ��й�ȣ ����
 		��й�ȣ ��ġ�ϴ� ��� ����
 			�Ķ������ �������� �ش� �Խù��� ������ �����ϱ�.
 			÷�������� ������ ���� ��� file2 �Ķ������ ������ �ٽ� �����ϱ�.
 		��й�ȣ ����ġ
 			��й�ȣ ���� �޼��� ����ϰ�, updateForm.jsp�� ������ �̵�
 	3. �������� : �������� �޼��� ��� ��. info.jsp ������ �̵�
 	       �������� : �������� �޼��� ��� ��. updateForm.jsp ������ �̵�
 --%>
<% 	//1. �Ķ���� ���� Board ��ü�� ����.
	Board board = new Board();
	String path = application.getRealPath("/") + "model1/board/file/";
	MultipartRequest multi = new MultipartRequest(request,path,10*1024*1024 ,"euc-kr");
	board.setNum(Integer.parseInt(multi.getParameter("num")));
	board.setName(multi.getParameter("name"));
	board.setPass(multi.getParameter("pass"));
	board.setSubject(multi.getParameter("subject"));
	board.setContent(multi.getParameter("content"));
	board.setFile1(multi.getFilesystemName("file1"));
	if(board.getFile1() == null || board.getFile1().equals("")){ //���� ������ ���� �ʾҴ�.
		board.setFile1(multi.getParameter("file2"));
	}
	

	//2. ��й�ȣ ����
	BoardDao dao = new BoardDao();
	Board dbBoard = dao.selectOne(board.getNum());
	String msg = "��й�ȣ�� Ʋ�Ƚ��ϴ�.";
	String url = "updateForm.jsp?num="+board.getNum();
	if(board.getPass().equals(dbBoard.getPass())){
		if(dao.update(board)){
			msg = "�Խù� �����Ϸ�";
			url = "info.jsp?num="+board.getNum();
		}else {
			msg= "�Խù� ���� ���� ";
		}
	}%>
<script>
	alert("<%=msg%>");
	location.href="<%=url %>";
</script>
