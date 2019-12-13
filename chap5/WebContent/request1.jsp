<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>전송된 파라미터 정보</title>
</head>
<body>
<%
	request.setCharacterEncoding("euc-kr");
	String name = request.getParameter("name");/*request중에 이름이 name 인 값을 가져옴 */
	String age  = request.getParameter("age");
	String gender  = request.getParameter("gender");
	String hobby  = request.getParameter("hobby");
	String year  = request.getParameter("year");
	
%>
이름:<%=name %><br>
나이:<%=age %><br> <!-- /*age값을 찍는다*/ -->
성별:<%=gender.equals("1")?"남":"여" %><br>
취미:<%=hobby %><br>
출생년도:<%=year %><br>
<h3> 취미 정보 모두 조회하기</h3>
<%
	String[] hobbies = request.getParameterValues("hobby");
	for(String h : hobbies){%>
		<%=h %> &nbsp;&nbsp;
<%	} %><br>
<h3>모든 파라미터 정보 조회하기</h3>
<table><tr><th>파라미터 이름</th></tr><tr><th>파라미터 값</th></tr>
<%
//getParameterNames() : 파라미터의 이름들.
//Enumeration : Iterator 구버전. 반복자
	Enumeration e = request.getParameterNames();
	while(e.hasMoreElements()){
		//파라미터의 이름
		String pname = (String)e.nextElement();
		String [] pvalue = request.getParameterValues(pname);
%>	
	<tr><td><%=pname %></td>
		<td><%for (String v: pvalue) { %>
		<%=v %> &nbsp;&nbsp;<%} %>
		</td></tr>
<% } %>
</table>
</body>
</html>