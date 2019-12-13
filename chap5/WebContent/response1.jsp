<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>response 객체 예제</title>
</head>
<body>
<h2>response 객체는 브라우저에 처리 결과를 전달해 주는 응답 객체다.<br>
	내부에 출력 버퍼를 가지고 있어서, 브라우저에 전달 되는 내용을 저장하고 있다.<br>
	또한 response 객체를 이용하여 브라우저에게 다른 페이지를 요청하도록
	명령을 전달할 수 있다.
</h2>
<h3>지금 작성 중인 내용은 화면에 출력되지 않는다.</h3>
<% response.sendRedirect("response2.jsp"); %> <!--응답객체에  재요청을 요구 sendRedirect 
브라우저에서 response1을 보내고 서버에서 response1에 응답을보내서 재요청 그래서 다시 브라우저에서response2 서버로보내고 서버는다시 응답  여기서 r1,r2의 requeset객체가 다르다-->
<!-- Redirect : url이 바뀌어 있다. -->
</body> 
</html>