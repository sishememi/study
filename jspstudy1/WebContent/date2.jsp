<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>date2</title>
</head>
<body>
<% 
	String sdate = (String)session.getAttribute("date");
	if(sdate == null){%>
	<script>
		alert("��¥ ��� �� �ŷ��ϼ���. date1.jsp�� ���ư��ϴ�.");
		location.href="date1.jsp";
	</script>
<%	} else {  %>
		�ݰ����ϴ� ��ϵ� ��¥: <%=sdate %>
<%		
		session.invalidate();
	
}
%>	

</body>
</html>