package paction.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paction.ActionForward;
import project.Member;
import project.MemberDao;

public class DeleteAction extends UserloginAction{
	@Override
	protected ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) {
		if(id.equals("admin")) {
			request.setAttribute("msg", "�����ڴ� Ż���� �� �����ϴ�.");
			request.setAttribute("url", "mypageForm.me");
			return new ActionForward(false,"../alert.jsp");
		}

		String pass = request.getParameter("pw");
		MemberDao dao = new MemberDao();
		Member mem = dao.selectOne(id);
		String msg = "��й�ȣ�� Ʋ���ϴ�. Ȯ���ϼ���";
		String url = "deleteForm.me?id="+id;
		
		 if(login.equals("admin") || pass.equals(mem.getPass()))
	      {
	            if(dao.delete(id) > 0) // ���� ����
	            {
	            if(login.equals("admin")) 
	            {
	                 msg = "����Ż�� ����";
	               url = "myPageForm.me";
	            }
	            else 
	            {
	               msg = id + "ȸ������ Ż�� �Ϸ�Ǿ����ϴ�";
	               url = "loginForm.jsp";
	               request.getSession().invalidate();
	            }
	         }
	         else // ���� ����
	         {
	            msg= id + "���� Ż��� ���� �߻�";
	            if(login.equals("admin")) {
	               url = "list.me";
	            }else { // �Ϲ� ������� ��� 
	               url = "mypageForm.me?id=" + id;               
	            }   
	         }
	      }
		 request.setAttribute("msg", msg);
	     request.setAttribute("url", url);
	     return new ActionForward(false, "../alert.jsp");
	}

}
