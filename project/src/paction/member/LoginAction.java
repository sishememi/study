package paction.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paction.Action;
import paction.ActionForward;
import project.Member;
import project.MemberDao;

public class LoginAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.id,pass �Ķ���� ����
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String msg = "�ش� id�� �������� �ʽ��ϴ�.";
		String url = "loginFrom.jsp";
		//id �ش��ϴ� ������ db���� ��ȸ
		Member mem = new MemberDao().selectOne(id);
		//��й�ȣ ����
		if(mem != null) { 
			//�α��� ����
			if(pass.equals(mem.getPass())) {
				request.getSession().setAttribute("login",id); //session.setAttribute("login",id); session�� jsp���尴ü�� requset.getsession()
				msg = mem.getNickname() + "���� �α����ϼ̽��ϴ�.";
				url = "mainForm.me";
			}else {
			//�α��� ����
				msg = "��й�ȣ�� Ʋ���ϴ�.";
				url = "loginForm.jsp";
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return new ActionForward(false,"../alert.jsp");
	}
}
