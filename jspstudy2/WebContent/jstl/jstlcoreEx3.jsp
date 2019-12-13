<%@page import="java.util.HashMap"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jstl core �±� : �ݺ���</title>
</head>
<body>
<h3>�ݸ� ���� �±� :forEach</h3>
<c:forEach var="test" begin="1" end="10">
	${test}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</c:forEach>

<h3>�ݸ� ���� �±� :forEach</h3>
<c:forEach var="test" begin="1" end="10" step="2"> <!-- step="2" -> 2�� �ǳʶ� -->
	${test}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</c:forEach>

<h3>forEach �±׸� �̿��Ͽ� 1���� 100������ �� ���ϱ�</h3>
<c:forEach var="i" begin="1" end="100">
	<c:set var="sum" value="${sum+i}" />
</c:forEach>
1���� 100������ ��:${sum}<br>

<h3>forEach �±׸� �̿��Ͽ� 1���� 100������ ¦���� ���ϱ�</h3>
<c:forEach var="i" begin="0" end="100" step="2">
	<c:set var="even" value="${even+i}" />
</c:forEach>
1���� 100���� ¦���� ��:${even}<br>
<h3>forEach �±׸� �̿��Ͽ� 1���� 100������ ¦���� ���ϱ�</h3>
<c:set var="sum" value="${0}"/>
<c:forEach var="i" begin="0" end="100" >
	<c:if test="${i%2==0}">
	<c:set var="sum" value="${sum+i}" />
	</c:if>
</c:forEach>
1���� 100���� ¦���� ��:${sum}<br>

<h3>forEach �±׸� �̿��Ͽ� 1���� 100������ Ȧ���� ���ϱ�</h3>
<c:forEach var="i" begin="1" end="100" step="2">
	<c:set var="odd" value="${odd+i}" />
</c:forEach>
1���� 100���� Ȧ���� ��:${odd}<br>
<h3>forEach �±׸� �̿��Ͽ� 1���� 100������ Ȧ���� ���ϱ�</h3>
<c:set var="sum" value="${0}"/>
<c:forEach var="i" begin="1" end="100" >
	<c:if test="${i%2==1}">
	<c:set var="sum" value="${sum+i}" />
	</c:if>
</c:forEach>
1���� 100���� Ȧ���� ��:${sum}<br>

<h3>forEach �±׸� 2~9�ܱ��� ������ ����ϱ�</h3>
<c:forEach var="i" begin="2" end="9">
	<h4>${i}��</h4>
	<c:forEach var="j" begin="2" end="9">
		${i} * ${j} = ${i*j }<br>
		</c:forEach>
	<br>
</c:forEach>

<h3>forEach �±׸� �̿��Ͽ� List ��ü ����ϱ�</h3>
<%
	List<Integer> list = new ArrayList<Integer>();
	for(int i=1;i<=10;i++){
		list.add(i*10);
	}
	pageContext.setAttribute("list", list);
%>
<c:forEach var="i" items="${list}"> <!-- i => list�� �������ִ� element�ϳ� ��.. "list"=list -->
	${i}&nbsp;&nbsp;&nbsp;
</c:forEach>
<c:forEach var="i" items="${list}" varStatus="stat"> <!-- varStatus="stat" = ÷�� -->
	<c:if test="${stat.index == 0 }" >
	 <h4>forEach�±׿� varStatus �Ӽ� ����</h4>
	 </c:if>
	 ${stat.count}:${i}<br> <!-- stat.index=1���� 10���� stat.count=1����   -->
</c:forEach>
<h3>forEach �±׸� �̿��Ͽ� Map ��ü ����ϱ�</h3>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("name","ȫ�浿");
	map.put("today",new Date());
	map.put("age", 20);
	pageContext.setAttribute("maps", map); //�̸��� map�� �̸��� ���� ��ü�� ���� 
%>
<c:forEach var="m" items="${maps}"  varStatus="stat"> <!-- m������ Ű�� ��ü�� ����  map.put("name","ȫ�浿"); �̰ͺ��� �ϳ��� ������-->
	${stat.count}:${m.key}=${m.value}<br> <!-- hash�� ������� ��µ��� ����. -->
</c:forEach>
<h3>EL�� �̿��Ͽ� Map ��ü ����ϱ�</h3>
name=${maps.name}<br><!-- {�Ӽ���.�����̸�} -->
today=${maps.today}<br>
age=${maps.age}<br>
<h3>forEach �±׸� �̿��Ͽ� �迭 ��ü ���</h3>
<c:set var="arr" value="<%=new int[]{10,20,30,40,50} %>" />
<c:forEach var="a" items="${arr}" varStatus="stat">
	arr[${stat.index}]=${a}<br> 
</c:forEach>
<!-- EL -->
${arr[0]}<br>
${arr[2]}<br>
${list[3]}<br> <!-- list�� �迭ó�� ǥ���� �� �ִ�. -->
<h4>�迭 ��ü�� �ι�° ��Һ��� ����° ��ұ��� ����ϱ�</h4>
<c:forEach var="a" items="${arr}" varStatus="stat" begin="1" end="2" >
	arr[${stat.index}]=${a}<br>
</c:forEach>

<h4>�迭 ��ü�� ¦�� �ε����� ����ϱ�</h4>
<c:forEach var="a" items="${arr}" varStatus="stat" step="2">
	arr[${stat.index}]=${a}<br>
</c:forEach>

<h4>�迭 ��ü�� Ȧ�� �ε����� ����ϱ�</h4>
<c:forEach var="a" items="${arr}" varStatus="stat" step="2" begin="1" > 
	arr[${stat.index}]=${a}<br>
</c:forEach>
</body>
</html>