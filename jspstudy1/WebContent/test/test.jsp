<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ���� ���� Ȯ��</title>
<link rel="stylesheet" href="../css/syj.css">
</head>
<body>
 <% request.setCharacterEncoding("euc-kr"); %> 
 <jsp:useBean id="log" class="syj.Member.Test" scope="page"/> 
 <jsp:setProperty property="*" name="log"/> 
 <table><caption>ȸ������ ����</caption>
<tr><td rowspan="4"><jsp:getProperty name="log" property="picture"/></td><td>���̵�</td><td><jsp:getProperty name="log" property="id"/></td></tr> 
<tr><td>��й�ȣ</td><td><jsp:getProperty name="log" property="pass"/></tr>
<tr><td>�̸�</td><td><jsp:getProperty name="log" property="name"/></tr>
<tr><td>����</td><td><jsp:getProperty name="log" property="gender2"/></td></tr>
<tr><td>��ȭ��ȣ</td><td colspan="2"><jsp:getProperty name="log" property="tel"/></td></tr>
<tr><td>�̸���</td><td colspan="2"><jsp:getProperty name="log" property="email"/></td></tr>
<tr><td colspan="3"><input type="submit" value="ȸ������"></td></tr>
</table>
<p style="text-aling:center">Goodee Academy Since 2016 - written by ������</p>
</body>
</html>