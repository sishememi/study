<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<% request.setCharacterEncoding("UTF-8");%>
<!-- 데이터 베이스의 Connection 객체 -->
<sql:setDataSource var="conn" driver="org.mariadb.jdbc.Driver"
	url="jdbc:mariadb://localhost:3306/classdb"
	user="scott" password="1234"/>
<!--  rs = executeQuery(sql) -->
<sql:query var="rs" dataSource="${conn}">
	select * from member where id = ?
	<sql:param>${param.id}</sql:param>
</sql:query>

<c:if test="${!empty rs.rows}">
	<h1 class="find">존재 아이디입니다.</h1> 
</c:if>
<c:if test="${empty rs.rows}">
	<h1 class="notfound">회원가입을 할 수 있는 아이디 입니다.</h1>
</c:if>