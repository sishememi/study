<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%-- 
 	��ũ��Ʈ(Script) ���� : �ڹٿ���   
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Script ����</title>
</head>
<body>
<%	//��ũ��Ʈ��(scriptlet)
	String msg = "��ũ��Ʈ ����"; //��������
	for(int i=1; i<=10; i++){
%>		
	<%= i + ":" + this.msg %><br> <%-- <%= %> <- ǥ���� : ; ���� �������� �ʴ´�.
	�ֳ��ϸ� ǥ�������� ǥ���Ǵºκ��� out.print�Ҷ� ������ ���� ����. �� �� �ּ��� ������� �ʴ´�.������ �ּ����� ó������ --%>
<%} //for���� �� %>
<%! //����
	String msg = "�������� ������ msg ����"; //�������
	String getMsg(){
		return msg;
	}
%>

</body>
</html>