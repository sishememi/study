<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%--
	1.openr ȭ�鿡 ��� ����. => javascript
	2.���� ȭ�� close() => javascript
 --%>
<script type="text/javascript">
 	img = opener.document.getElementById("pic");
 	img.src = "picture/${fname}";
 	opener.document.f.picture.value="${fname}";
 	self.close();
</script>
