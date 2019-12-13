<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>pageContext 예제</title>
</head>
<body>
<h2>pageContext 객체 : 현재 페이지의 자원을 관리하는 객체</h2>
<%
	if(request == pageContext.getRequest()){
	%>
	request 객체와 pageContext.getRequest()는 같은 객체임<br>
	<!-- request가 참조하는 객체 와  pageContext.getRequest()가 참조하는  객체는 같다. 
		jsp 구별
		page영역은 1개의 jsp(가장작은단위) , page 영역을 담당하고있는 객체=pageContext (jsp끼리 공유되지않고 각자 하나씩가지고있다.)
		request 영역은 1번의 요청이 응답을하지않을때까지 여러개의request객체가 있다면 전부 같은 객체로 봄 , request영역을 담당하고있는 객체 = request객체 
		 영역 : 브라우저가 한번 연결하면 세션이 계속연결되어있다 (브라우저가 끊길때까지).1개의 브라우저에서 요청할때 jsp에서 session을 먼저 만든다. 
					 session영역을 담당하고있는 객체 = session객체 . 응답을할때까지의 모든 jsp들은 같은 session을 갖고(공유하고)있다.
		application : 1개의 웹어플리케이션 , application영역을 담당하고있는 객체 = application
		
		속성등록(가능): setAttribute / getAttribute / removesetAttribute
		pageContext
		request
		session
		application
	-->
<%	}%>

<%
	if(response == pageContext.getResponse()){
	%>
	response 객체와 pageContext.getResponse()는 같은 객체임<br>
<%	}%>

<%
	if(session == pageContext.getSession()){
	%>
	session 객체와 pageContext.getSession()는 같은 객체임<br>
<%	}%>

</body>
</html>