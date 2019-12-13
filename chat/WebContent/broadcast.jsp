<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>채팅 화면</title>
</head>
<body>
<fieldset><textarea rows="10" cols="50" readonly="readonly" id="messageWindow"></textarea><br>
	<input id="inputMessage" type="text" size="50">
	<input type="button" value="전송" onclick="send()">
</fieldset>

<script type="text/javascript">
 var textarea=document.getElementById("messageWindow");
 var webSocket = new WebSocket("ws://192.168.0.107:8080${path}/broadcasting");
 var inputMessage = document.getElementById("inputMessage");
 webSocket.onerror = function(event){
	 onError(event)
 }
 //서버와 연결될때,  자바스크립트에서 on이들으가면 모두 event
 webSocket.onopen=function(event){
	 onOpen(event);
	 alert("즐거운 채팅.비속어 금지")
 }
 //서버에서 메세지를 수신한 경우
 webSocket.onmessage=function(event){
	 onMessage(event)
}
function onMessage(event){
	textarea.value += "상대:" + event.data + "\n";
}
function onOpen(event){
	textarea.value +="연결 성공\n";
}
function onError(event){
	alert("연결 실패:" + event.data)
}
function send(){
	<c:if test="${!empty sessionScope.memId}">
		<c:set var="memId" value="${sessionScope.memId}"/>
	</c:if>
	<c:if test="${empty sessionScope.memId}">
		<c:set var="memId" value="본인"/>
	</c:if>
	textarea.value += "${memId} :"  + inputMessage.value+"\n";
	webSocket.send(inputMessage.value); //서버로 메세지 전송
	inputMessage.value="";
}
</script>
</body>
</html>