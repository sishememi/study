<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSTL core �±� ���� : taglib ���þ� ǥ���ؾ� �Ѵ�.</title>
</head>
<body>
<h3>�Ӽ� ���� �±� : set,remove,out �±�</h3>
<%session.setAttribute("test", "Hello JSTL"); %> <!-- el ���� -->
<c:set var="test" value="${'Hello JSTL'}" scope="session"/> <!-- JSTL ���� -->
<!--  �̸��� test�� ���� 'hello jstl'�� �Է� / session.setA~ ���ٰ� ����. scope�� �����Ǹ� pageContext.setA~ �� �⺻����.-->
test �Ӽ� : ${sessionScope.test} <br>
test �Ӽ� : <c:out value="${test}" /><br>
<c:remove var="test"/>
test �Ӽ�: ${test}<br>
</body>
</html>