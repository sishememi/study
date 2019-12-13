<%@page import="model.MemberDao"%>
<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <%--
    	1. �α׾ƿ� ���� : "�α����ϼ���." �޼��� ���. loginForm.jsp �������̵�
    	2. �α��� ����
    			*��ȿ������
    		- �����ڰ� �ƴϰ�, id�� login�� �ٸ� ���
    			"���θ� Ż�� �����մϴ�." �޼��� ���. main.jsp �������� �̵�
    		- id�� ������ �� ���
    			"�����ڴ� Ż�� �Ұ����մϴ�. �޼��� ���. list.jsp ������ �̵�
    			��ȿ������*
    		- �Ϲݻ���� 
    			(1) ���̵�, ��й�ȣ ����
    			(2) ��й�ȣ ����ġ =>�Էµ� ��й�ȣ�� db�� ��й�ȣ�� ����
    					"��й�ȣ�� Ʋ���ϴ�" �޼��� ���. deleteForm.jsp ������ �̵�
    		- ������ 
    			(1) ���̵� ������ �Ķ���ͷ� ����
    	3. ������ �α���, �Ǵ� ��й�ȣ ��ġ�ϴ� ��� db���� ȸ�� ���� �����ϱ�
    	 	���� ���� 
    	 		�Ϲݻ���� : �α׾ƿ� �� Ż��޼��� ��� . loginForm.jsp �������̵�
    	 		������ : Ż�� �޼��� ���. list.jsp ������ �̵�.
    	 	���� ���� 
    	 		�Ϲݻ���� : �������� �޼��� ���. info.jsp ������ �̵�.
    	 		������ : �������� �޼��� ���. list.jsp ������ �̵�.
    --%>
<%
	String login = (String)session.getAttribute("login");
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String msg = null;
	String url = null;
	if(login == null || login.trim().equals("")){ //�α׾ƿ� ���� 
		msg = "�α��� �ϼ���.";
		url = "loginForm.jsp";	
	}else if(!login.equals("admin") && !login.equals(id)){ //�����̾ƴҶ�
			msg = "���θ� Ż�� �����մϴ�.";
			url = "main.jsp";
		}else if(id.equals("admin")){ //Ż�� ����� �Ǵ� ȸ���� ������ �ȵ�.
			msg = "�����ڴ� Ż�� �Ұ����մϴ�.";
			url = "list.jsp"; //��������� �Ӥ��й�ȣ ���þ���.
		}else { //��й�ȣ�� ���� ����(����)
			MemberDao dao = new MemberDao(); //db������
			Member mem = dao.selectOne(id); //id�� ���ѳ��� db���� ��ȸ
			if(login.equals("admin") || pass.equals(mem.getPass())){ //if �����ȿ� ���� �ٲ�� ����. ���� Ʈ��� ��ü������ ��. ���� ������������
				int result = dao.delete(id); 
				if(result > 0 ){ //��������
					if(login.equals("admin")){ //�������ΰ��
						msg = id+"����ڸ� ���� Ż�� ����";
						url = "list.jsp";
					}else { //�Ϲ� ������ΰ��
						msg = id+"���� ȸ�� Ż�� �Ϸ�Ǿ����ϴ�.";
						url = "loginForm.jsp";
						session.invalidate();
					}
				}else{ //���� ����
					msg = id + "���� Ż��� ���� �߻�.";
					if(login.equals("admin")){ //�������ΰ��
						url = "list.jsp";
					}else { //�Ϲݻ����
						url = "info.jsp?id="+id;
					}
				}
			}else{
				msg = id +"���� ��й�ȣ�� Ʋ���ϴ�.";
				url = "deleteForm.jsp?id="+ id;
			}
		}
%>    
    
<script>
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>