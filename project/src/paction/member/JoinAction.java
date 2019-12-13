package paction.member;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paction.Action;
import paction.ActionForward;
import project.Member;
import project.MemberDao;
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
		mem.setNickname(request.getParameter("nickname"));
		mem.setBirth(request.getParameter("year")+"-"+request.getParameter("month")+"-"+request.getParameter("day"));
		mem.setEmail(request.getParameter("email"));
		mem.setGender(Integer.parseInt(request.getParameter("gender")));
		mem.setTravel(Integer.parseInt(request.getParameter("travel")));

		 String[] values= request.getParameterValues("national");
		 String national="";
		  for(int i=0; i<values.length; i++) { 
			 national += values[i]+(i == values.length -1 ? "":","); 
		  } 
		 mem.setNational(national); 

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
