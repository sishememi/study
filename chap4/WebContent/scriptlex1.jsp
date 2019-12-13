<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%-- 
 	스크립트(Script) 예제 : 자바영역   
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Script 예제</title>
</head>
<body>
<%	//스크립트릿(scriptlet)
	String msg = "스크립트 예제"; //지역변수
	for(int i=1; i<=10; i++){
%>		
	<%= i + ":" + this.msg %><br> <%-- <%= %> <- 표현식 : ; 으로 종료하지 않는다.
	왜냐하면 표현식으로 표현되는부분은 out.print할때 값으로 들어가기 때문. 한 줄 주석도 사용하지 않는다.여러줄 주석으로 처리가능 --%>
<%} //for구문 끝 %>
<%! //선언문
	String msg = "선언문으로 선언한 msg 변수"; //멤버변수
	String getMsg(){
		return msg;
	}
%>

</body>
</html>