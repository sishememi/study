<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>전송된 숫자 정보</title>
</head>
<body>
<%
	int number = Integer.parseInt(request.getParameter("num")); //자바에서는 Integer.parseInt를 사용 ,parseInt는 자바스크립트에서만 
	int sum = 0;
	for(int i=1; i<=number; i++){
		sum+=i;
}%>
합계:<%=sum  %>
</body>
</html>