<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>합계 구하기</title>
</head>
<body>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	int kbn = Integer.parseInt(request.getParameter("kbn"));
	int sum = 0;
	for(int i=1; i<=num; i++){
		switch(kbn){
		case 0 : sum += i; break;
		case 1 : if(i%2==0) sum+= i;
				 break;
		case 2 : if(i%2==1) sum+= i;
		 		 break;
		}
	}
%>
<%=num %> 까지의 <%=(kbn==0)?"합계":(kbn==1)?"짝수합계":"홀수합계" %>:<%=sum %>
</body>
</html>