<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <!-- �������� ������ �����Ҷ� ���������� ������ �����Ѵ�.������ �ϳ��� ������ �ֱ� ����. �������� �ٸ��� �ƹ��͵� ����ȵ�. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>session�� �̿��� ��ٱ��� ����</title>
</head>
<body>
<h3>��ǰ����</h3>
<form action="sessionAdd.jsp" method="post">
	<select name="product">
		<option>���</option>	<option>��</option><option>��</option>
		<option>�ڸ�</option>	<option>��</option><option>����</option>
	</select>
	<input type="submit" value="��ٱ����߰�">
</form>
<a href="sessionView.jsp">��ٱ��� ����</a>
</body>
</html>