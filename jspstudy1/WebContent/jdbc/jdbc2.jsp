<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>������ select ���� ���� ��� Ȯ��</title>
<link rel="stylesheet" href="../css/main.css">
</head>
<body>
<%	
 	request.setCharacterEncoding("euc-kr");
	String sql = request.getParameter("sql");	//null
%>
<%-- form�� action �Ӽ��� ���� ��� �ڽ��� �������� �ٽ� ȣ����. --%>
<form method="post">
	<textarea cols="60" rows="5" name="sql"><%=(sql==null)?"":sql%></textarea>
	<input type="submit" value="����">
</form>
<%
	Connection conn = null;
   if(sql != null && !sql.trim().equals("")) {/* sql �� null�̰ų� sql ���� ������. db���� ����.  */
	try{
	Class.forName("org.mariadb.jdbc.Driver"); 
	conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/classdb", "scott", "1234");
	PreparedStatement pstmt = conn.prepareStatement(sql);
	ResultSet rs = pstmt.executeQuery();
	ResultSetMetaData rsmt = rs.getMetaData();

	PreparedStatement pstmt2 = conn.prepareStatement("select count(*) from ("+ sql +")a");/* ���⼭ sql => ���� �Է��� sql ��  */
	ResultSet rs2 = pstmt2.executeQuery();
	rs2.next(); /* rs2 �� ���پ�?������. �����ؾ���. */
	int cnt = rs2.getInt(1);%>
	
 <table class='w3-table-all'>
<tr><td style="text-align:right;" colspan="<%=rsmt.getColumnCount() %>">��ȸ�� ���ڵ� ����:<%=cnt %></td></tr>
<!-- �÷��� ���-->
<tr>
<% for(int i=1; i<=rsmt.getColumnCount();i++){ %>
	<th><%=rsmt.getColumnName(i)%></th>
	<% } %>
</tr>
<% while(rs.next()){ %><tr>
	<%for(int i=1; i<=rsmt.getColumnCount();i++) { %>
		<td><%=rs.getString(i) %>
		</td><%} %>
	<%} %></tr>
</table> 
<%} catch(Exception e) {%>
	<h2>sql ���� ���� �Դϴ�.</h2>
	<h2><%=e.getMessage()%></h2>
	<h2>sql ����: <%=sql %></h2>
<%} finally{
	//conn.close();
} }%>
</body>
</html>