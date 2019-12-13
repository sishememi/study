<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>forward하는 페이지</title>
</head>
<body>
<h1>forward 하는 페이지입니다. 이 내용을 화면에 출력되지 않습니다.</h1>
<% pageContext.forward("forward2.jsp"); %> <!-- pageContext.forward("forward2.jsp") 
forward1에서 forward2를 서버단에서 출력하고 모든 내장객체를 물려줌.foward1안에서 forward2는 자기페이지를가지고 응답을 보냄 
forward1이 가지고있는 내장객체를 forward2로 공유함그래서 같은 request객체이다.-->
</body>
</html>