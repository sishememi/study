<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>한글</title>
</head>
<body>
<%-- POST 방식에서만 유효함 --%>
<% request.setCharacterEncoding("euc-kr");%>
이름 : <%=request.getParameter("name") %> <!-- 내 Parameter중에 파라미터 이름이 name인 값을 출력  -->
<!-- 내 Parameter중에 파라미터 이름이 addr인 값을 출력  -->
주소 : <%=request.getParameter("addr") %>
</body>
</html>