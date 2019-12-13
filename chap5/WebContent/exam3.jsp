<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>전송된  값 계산</title>
</head>
<body>
<%
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
//	int  op = Integer.parseInt(request.getParameter("op"));
	String op = request.getParameter("op");
	//int total =0;
	String total=null;
	switch(op){
	case "+" : total = String.format("%d",num1 + num2); break;
	case "-" : total = String.format("%d",num1 - num2); break;
	case "*" : total = String.format("%d",num1 * num2); break;
	case "/" : total = String.format("%.2f",(double)num1 / num2);break;
	}%>

<%-- 	if(op == 0){
		total = num1 + num2;
	}else if (op == 1){
		total = num1 - num2;
	}else if (op == 3){
		total = num1 / num2;
		
	}else if (op == 2){
		total = num1 * num2;	
}
<%=num1 %> <%=(op==0)?"+":(op==1)?"-":(op==2)?"*":"/" %> 
<%=num2 %> = <%=total %>- --%>
<%=num1+op+num2+"="+total %>
</body>
</html>