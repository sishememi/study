<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>pageContext ����</title>
</head>
<body>
<h2>pageContext ��ü : ���� �������� �ڿ��� �����ϴ� ��ü</h2>
<%
	if(request == pageContext.getRequest()){
	%>
	request ��ü�� pageContext.getRequest()�� ���� ��ü��<br>
	<!-- request�� �����ϴ� ��ü ��  pageContext.getRequest()�� �����ϴ�  ��ü�� ����. 
		jsp ����
		page������ 1���� jsp(������������) , page ������ ����ϰ��ִ� ��ü=pageContext (jsp���� ���������ʰ� ���� �ϳ����������ִ�.)
		request ������ 1���� ��û�� �������������������� ��������request��ü�� �ִٸ� ���� ���� ��ü�� �� , request������ ����ϰ��ִ� ��ü = request��ü 
		 ���� : �������� �ѹ� �����ϸ� ������ ��ӿ���Ǿ��ִ� (�������� ���涧����).1���� ���������� ��û�Ҷ� jsp���� session�� ���� �����. 
					 session������ ����ϰ��ִ� ��ü = session��ü . �������Ҷ������� ��� jsp���� ���� session�� ����(�����ϰ�)�ִ�.
		application : 1���� �����ø����̼� , application������ ����ϰ��ִ� ��ü = application
		
		�Ӽ����(����): setAttribute / getAttribute / removesetAttribute
		pageContext
		request
		session
		application
	-->
<%	}%>

<%
	if(response == pageContext.getResponse()){
	%>
	response ��ü�� pageContext.getResponse()�� ���� ��ü��<br>
<%	}%>

<%
	if(session == pageContext.getSession()){
	%>
	session ��ü�� pageContext.getSession()�� ���� ��ü��<br>
<%	}%>

</body>
</html>