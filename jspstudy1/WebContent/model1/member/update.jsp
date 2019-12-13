<%@page import="model.Member"%>
<%@page import="model.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--
	1. ��� �Ķ���� Member ��ü�� ����
	2. �Էµ� ��й�ȣ�� db�� ����� ��й�ȣ�� ����������
		"��й�ȣ�� Ʋ�Ƚ��ϴ�." �޼��� ��� ��, updateForm.jsp �������� �̵�.
	3. 1���� ������ db�� �����ϱ�
		 int MemberDao.update(Member)
		����� 0���� ũ�� "��������" �޼��� ���. info.jsp ������ �̵�
			 0���� ������ "���� ����" �޼��� ���. main.jsp ������ �̵�
 --%>    
<%request.setCharacterEncoding("euc-kr");%>
<%-- useBean -> Member m = new Member(); --%>
<jsp:useBean id="m" class="model.Member" />
<%-- jsp:setProperty -> m.setId(requset.getParameter("id"); --%>
<jsp:setProperty name="m" property="*"/><!-- 1. �Ķ���� ��ü ��� Member��  ���� /m = ���� �� ����  --> 
<%
	MemberDao dao = new MemberDao(); //MemberDao�� ���õ� dao��ä����
	//selectOne(id) : ����� id�� �ش��� db���� Member ��ü�� ����
	//dbmem : ���� �� Member ���� ����
	Member dbmem = dao.selectOne(m.getId()); //dbmem = ���� �� ����. m(��簪)��  id �Ķ���ͷκ��� dao��ä�� ����.
	String login = (String)session.getAttribute("login");
	String msg = null;
	String url = null;
	//��й�ȣ ����
	if(!login.equals("admin") && !m.getPass().equals(dbmem.getPass())){ //dbmem.getPass()=db���ִ� ��й�ȣ,m.getPass()=�Է��� ��й�ȣ
		msg = "��й�ȣ�� Ʋ�Ƚ��ϴ�.";
		url = "updateForm.jsp?id="+m.getId(); //updateForm�� ȣ���ϸ� id���� �����־����.
	}else {//��й�ȣ ��ġ
		MemberDao dao2 = new MemberDao(); 
		int result = dao2.update(m); //m => jsp:useBean�� 'm' /update = >db�� ȸ�� ���� ���� ���. ��� ������ ����.
		if(result  > 0){
			msg = "������ �Ϸ�Ǿ����ϴ�.";
			url = "info.jsp?id="+m.getId();	
		}else { 	
			msg = "������ �Ϸ����� ���Ͽ����ϴ�."; //result<0
			url = "main.jsp";	//�Ķ���� ����.

		}
	}%>
<script>
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>