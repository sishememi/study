<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><decorator:title /></title>
<decorator:head />
<link rel="stylesheet" href="${path}/css/main2.css">
<script type="text/javascript" src="http://cdn.ckeditor.com/4.5.7/full/ckeditor.js">

</script>
</head>
<body>
<table>
	<tr><th colspan="3" align="right">
	������ �������� ���� 2ȸ�� ���α׷� ���� 
	<div class="login" style="float: right; font-size:15px;">
	<c:if test="${empty sessionScope.login}" >
		<a href="loginForm.me">�α���&nbsp;</a>
		<a href="joinForm.me">ȸ������</a>
	</c:if>
	<c:if test="${!empty sessionScope.login}">
	${sessionScope.login}���� �α����ϼ̽��ϴ�.&nbsp;
		<a href="logout.me">�α׾ƿ�</a>
	</c:if>
	</div>
	</th></tr>
	<tr><td width="15%" style="vertical-align:top"> <a href="${path}/model2/member/main.me">ȸ������</a><br>
						 <a href="${path}/model2/board/list.do">�Խ���</a><br>
	</td><td colspan="2" style="text-align: left;">
	<decorator:body />
	</td></tr>
	<tr><td colspan="3">�����ī���� Since 2016</td></tr>
</table>
</body>
</html>
