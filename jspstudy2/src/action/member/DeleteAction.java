package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.ActionForward;
import model.Member;
import model.MemberDao;

/*
1.id�� ������ �� ���
	"�����ڴ� Ż�� �Ұ����մϴ�. �޼��� ���. list.me ������ �̵�
2.Ż�� ����
	�Էµ� ��й�ȣ�� db�� ��й�ȣ�� ����
		-�����ڰ� �ƴϸ鼭 ��й�ȣ ����ġ 
				"��й�ȣ�� Ʋ���ϴ�" �޼��� ���. deleteForm.me ������ �̵�
3. ������ �α���, �Ǵ� ��й�ȣ ��ġ�ϴ� ��� db���� ȸ�� ���� �����ϱ�
 	���� ���� 
 		�Ϲݻ���� : �α׾ƿ� �� Ż��޼��� ��� . loginForm.me �������̵�
 		������ : Ż�� �޼��� ���. list.me ������ �̵�.
 	���� ���� 
 		�Ϲݻ���� : �������� �޼��� ���. info.me ������ �̵�.
 		������ : �������� �޼��� ���. list.me ������ �̵�.
*/
public class DeleteAction extends UserloginAction {
	  @Override
	   protected ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) 
	   {
	      if(id.equals("admin")) // �����ڰ� ������ ���� Ż�� ��û��
	      {
	         request.setAttribute("msg", "�����ڴ� Ż���� �� �����ϴ�");
	         request.setAttribute("url", "list.me");
	         return new ActionForward(false, "../alert.jsp");
	      }
	      String pass = request.getParameter("pass");
	      MemberDao dao = new MemberDao();
	      Member mem = dao.selectOne(id);
	      String msg = "��й�ȣ�� Ʋ���ϴ�";
	      String url = "deleteForm.me?id=" + id;
	      if(login.equals("admin") || pass.equals(mem.getPass())) // �������̰ų� �Է��� ���� ��й�ȣ�� ��ġ�ϴ� ���
	      {
	            if(dao.delete(id) > 0) // ���� ����
	            {
	            if(login.equals("admin")) // �������� ���
	            {
	                 msg = "����Ż�� ����";
	               url = "list.me";
	            }
	            else // �Ϲ� ������� ���
	            {
	               msg = id + "ȸ������ Ż�� �Ϸ�Ǿ����ϴ�";
	               url = "loginForm.me";
	               request.getSession().invalidate();
	            }
	         }
	         else // ���� ����
	         {
	            msg= id + "���� Ż��� ���� �߻�";
	            if(login.equals("admin")) {// �������� ���
	               url = "list.me";
	            }else { // �Ϲ� ������� ��� 
	               url = "info.me?id=" + id;               
	            }   
	         }
	      }
	      request.setAttribute("msg", msg);
	      request.setAttribute("url", url);
	      return new ActionForward(false, "../alert.jsp");
	   }
}