<%@page import="model.Board"%>
<%@page import="model.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%--
    1. num���� �Խù��� db���� ��ȸ�Ͽ� ȭ�� ����ϱ�.
  --%>
<% 
   int num =  Integer.parseInt(request.getParameter("num"));// num���� �Խù��� db���� ��ȸ
/*    BoardDao dao = new BoardDao();
   Board b = dao.selectOne(num); */
   //b :  num ���� �ش��ϴ� �Խù��� db�� ���� ����.
   Board b = new BoardDao().selectOne(num);   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խ��� ���� ȭ��</title>
<link rel="stylesheet" href="../../css/mainboard.css">
<script>
    function file_delete(){
       document.f.file2.value="";
       file_desc.style.display="none"; //������ü�� ������� �ʴ´�. �Ⱥ������°� ��.
       }
</script>
</head>
<body>
<form action="update.jsp" method="post" enctype="multipart/form-data" name="f"> <!--  multipart/form-data => useBean���Ұ�. -->
   <input type="hidden" name="num" value = "<%=b.getNum() %>">
   <input type="hidden" name="file2" value = "<%=b.getFile1()==null?"":b.getFile1() %>"> <!-- ������ �ִ� ������ ���ش�. -->
   <table><caption>�Խ��� ���� ȭ��</caption>
   <tr><td>�۾���</td><td><input type="text" name="name" value="<%=b.getName()%>"></td></tr>
   <tr><td>��й�ȣ</td><td><input type="password" name="pass" ></td></tr>
   <tr><td>����</td><td><input type="text" name="subject" value="<%=b.getSubject() %>"></td></tr>
   <tr><td>����</td><td><textarea rows="15" name="content" value="<%=b.getContent()%>"></textarea></td></tr>
   <tr><td>÷������</td><td style="text-align:left">
   <%if (b.getFile1() != null && (!b.getFile1().equals(""))){%>
      <div id="file_desc"><%=b.getFile1()%>
      <a href="javascript:file_delete()">[÷������ ����]</a></div>
   <%}%>
   <input type="file" name="file1"></td></tr>
   <tr><td colspan="2"><a href="javascript:document.f.submit()">[�Խù� ����]</a></td></tr>
</table>
</form>
</body>
</html>