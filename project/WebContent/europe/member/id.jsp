<%@page import="project.Member" %>
<%@page import="project.MemberDao" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  
<%

	String email = request.getParameter("email");
	String birth = request.getParameter("birth");
	MemberDao dao = new MemberDao();
	Member mem = new Member();
	String id = dao.idSearch(email,birth);
	
	if(id != null){

%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="EUC-KR">
<title>���̵�ã��</title>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../../css/util.css">
	<link rel="stylesheet" type="text/css" href="../../css/main.css">   
 
</head>
<body>
<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-50 p-b-90" style="">
				<form class="login100-form validate-form flex-sb flex-w" action="id.me" method="post" name="f" style="text-align:center; vertical:">
					<div class="wrap-input100 validate-input m-b-16" >
						<span class="login100-form-title p-b-51">
							������ ID��  '<%=id %>' �Դϴ�.
						</span>
						<span class="focus-input100"></span>
					</div>
					<a href="pwForm.jsp" class="login100-form-btn" >PASSWORD ã��</a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
<% } else { %>
<script>
	alert=("������ �´� ���̵� ã�� �� �����ϴ�.");
	location.href="idForm.jsp";
</script>
<%}%>