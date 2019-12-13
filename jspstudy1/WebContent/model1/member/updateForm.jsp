<%@page import="model.Member"%>
<%@page import="model.MemberDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--
	 1. id �Ķ���� ��ȸ
	 2. ���� login���� ��ȸ.
	   	       �α��� �ȵ� ��� : "�α��� ���ּ���" �޼��� ���   loginForm.jsp ������ �̵�
	 3. �α��� �Ȱ�� : �α��� admin�� �ƴϸ鼭 �ٸ������ ���� ��ȸ �ϸ�
	   				   "�� ���� ������ �����մϴ�." �޼��� ���. main.jsp ������ �̵�
	 4. id ������ db���� �о Member ��ü�� ����
	 5. Member ��ü�� ȭ�鿡 ���.
--%>
<%
	 String id = request.getParameter("id");
	 String login = (String)session.getAttribute("login");
	 
	 if(login == null || login.trim().equals(""))
	 {
%>		 <script>
			alert("�α��� ���ּ���.");
			location.href="loginForm.jsp";
		</script>
<%	 } else if(!id.equals(login) && !login.equals("admin"))
		{
%>			<script>
				alert("�� ���� ������ �����մϴ�.");
				location.href="main.jsp";
			</script>
<%	} else { //id�� ������ db���� �о�� Member��ü�� ����
		Member mem = new MemberDao().selectOne(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ����</title>
<link rel="stylesheet" href="../../css/main3.css">
<script type="text/javascript">
	function win_upload(){
		var op = "width=500, height=150, left=50,top=150"
		open("pictureForm.jsp","",op);
	}
	function ch(){
		var op = "width=500, height=250, left=50,top=150"
			open("passchForm.jsp","",op); //pass�� �����Ϸ���login���θ� ���� ,id���Ϸ��� jsp?id= �̷����ؾ���.
	}
	function inputcheck(f){
<% if(!login.equals("admin")) {%>
		if(f.pass.value == ""){ //admin�̸� ��й�ȣ �ȳ־ ���.
			alert("��й�ȣ�� �Է��ϼ���.");
			f.pass.focus();
			return false; //������ �ȳѾ����.
		}
	<% } %>
	}
</script>
</head>
<body>
<form action="update.jsp" name = "f" method="post" onsubmit="return inputcheck(this)">
	<input type="hidden" name="picture">
<table><caption>ȸ�� ���� ����</caption>
<tr><td rowspan="4" valign="bottom">
	<img src="picture/<%=mem.getPicture() %>" width="100" height="120" id="pic"><br>
	<font size="1"><a href="javascript:win_upload()">��������</a></font>
	</td><th>���̵�</th><td><input type="text" name="id" readonly value="<%=mem.getId() %>"></td></tr>
	<tr><th>��й�ȣ</th><td><input type="password" name="pass" ></td></tr>
	<tr><th>�̸�</th><td><input type="text" name="name" value="<%=mem.getName()%>"></td></tr>
      <tr><th>����</th>
      <td><input type="radio" name="gender" value="1"<%=mem.getGender() == 1?"checked":"" %>>��
          <input type="radio" name="gender" value="2" <%=mem.getGender() == 2?"checked":"" %>>��</td></tr>
      <tr><th>��ȭ��ȣ</th>
      <td colspan="2"><input type="text" name="tel" value="<%=mem.getTel()%>"></td></tr>
      <tr><th>�̸���</th>
      <td colspan="2"><input type="text" name="email" value="<%=mem.getEmail()%>"></td></tr>
      <tr><td colspan="4"><input type="submit" value="ȸ������">&nbsp;<input type="button" value="��й�ȣ����" onclick="ch()"></td></tr>
</table>    
</form>
</body>
</html>
<% } %>