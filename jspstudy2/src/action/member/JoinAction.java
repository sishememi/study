package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import model.Member;
import model.MemberDao;
/*
 * 1. �Ķ���� ������ Member ��ü�� ����
 * 2. Member ��ü�� db�� �߰��ϱ�.
 * 		- ���� : ���� �޼��� ���, loginForm.me ������ �̵�
 * 		- ���� : ���� �޼��� ���, joinForm.me ������ �̵�
 * 
 */
public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1. �Ķ���� ������ Member ��ü�� ����
		Member mem = new Member();
		mem.setId(request.getParameter("id"));
		mem.setPass(request.getParameter("pass"));
		mem.setName(request.getParameter("name"));
		mem.setGender(Integer.parseInt(request.getParameter("gender")));
		mem.setTel(request.getParameter("tel"));
		mem.setEmail(request.getParameter("email"));
		mem.setPicture(request.getParameter("picture"));
		//2.Member ��ü�� db�� �߰��ϱ�.
		MemberDao dao = new MemberDao();
		String msg = "ȸ������ ����";
		String url = "joinForm.me";
		if(dao.insert(mem) > 0) {
			msg = "ȸ�������� �Ϸ�Ǿ����ϴ�.";
			url = "loginForm.me";
		}
		request.setAttribute("msg", msg);				
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
	}
}
