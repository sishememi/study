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
<sql:query var="rs" dataSource="${conn}"> <%-- rs =list 형태 --%>
	select * from member where id = ? and pass =  ?
	<sql:param>${param.id}</sql:param>
	<sql:param>${param.pass}</sql:param>
</sql:query>

<c:if test="${!empty rs.rows}">
	<h1>반갑습니다. ${rs.rows[0].name}님</h1> <!--  검색된 첫번째 레코드 -->
</c:if>
<c:if test="${empty rs.rows}">
	<h1>아이디 또는 비밀번호가 틀립니다.</h1>
</c:if>