<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%-- 1.�̹� joinForm.jsp�� �Ķ���Ͱ���  �������� --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������ ���� ����ϱ�</title>
<link rel="stylesheet" href="../css/main.css">
</head>
<body>
 <% request.setCharacterEncoding("euc-kr"); %> <!-- 2.�׷��� �ȱ������� �ѱ� ������. -->
 <jsp:useBean id="mem" class="chap7.Member" scope="page"/> <!-- 3.��ü���� -->
 <jsp:setProperty property="*" name="mem"/> <!-- property="*" �ǹ�. �Ķ���Ϳ� �����ü�� setproperty�� ���ؼ� ���� �޾ƿ�. property-->
 <%-- mem ��ü�� �Ķ���� ���� ���� ����� ���� --%>
 <table border="1" style="border-collapse: collapse;"><caption>���� �������</caption>
<tr><td>���̵�</td><td><jsp:getProperty name="mem" property="id"/></td></tr>
<%-- ����Ȱ��� getProperty�� ��� ���� ����. --%>
<tr><td>��й�ȣ</td><td><jsp:getProperty name="mem" property="pass"/></td></tr>
<tr><td>�̸�</td><td><jsp:getProperty name="mem" property="name"/></td></tr>
<tr><td>����</td><td><jsp:getProperty name="mem" property="gender2"/></td></tr>
<tr><td>����</td><td><jsp:getProperty name="mem" property="age"/></td></tr>
<tr><td>�̸���</td><td><jsp:getProperty name="mem" property="email"/></td></tr>
</table>
</body>
</html>