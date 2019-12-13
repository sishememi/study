<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ä�� ȭ��</title>
</head>
<body>
<fieldset><textarea rows="10" cols="50" readonly="readonly" id="messageWindow"></textarea><br>
	<input id="inputMessage" type="text" size="50">
	<input type="button" value="����" onclick="send()">
</fieldset>

<script type="text/javascript">
 var textarea=document.getElementById("messageWindow");
 var webSocket = new WebSocket("ws://192.168.0.107:8080${path}/broadcasting");
 var inputMessage = document.getElementById("inputMessage");
 webSocket.onerror = function(event){
	 onError(event)
 }
 //������ ����ɶ�,  �ڹٽ�ũ��Ʈ���� on�̵������� ��� event
 webSocket.onopen=function(event){
	 onOpen(event);
	 alert("��ſ� ä��.��Ӿ� ����")
 }
 //�������� �޼����� ������ ���
 webSocket.onmessage=function(event){
	 onMessage(event)
}
function onMessage(event){
	textarea.value += "���:" + event.data + "\n";
}
function onOpen(event){
	textarea.value +="���� ����\n";
}
function onError(event){
	alert("���� ����:" + event.data)
}
function send(){
	<c:if test="${!empty sessionScope.memId}">
		<c:set var="memId" value="${sessionScope.memId}"/>
	</c:if>
	<c:if test="${empty sessionScope.memId}">
		<c:set var="memId" value="����"/>
	</c:if>
	textarea.value += "${memId} :"  + inputMessage.value+"\n";
	webSocket.send(inputMessage.value); //������ �޼��� ����
	inputMessage.value="";
}
</script>
</body>
</html>