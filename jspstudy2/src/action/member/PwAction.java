package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import model.Member;
import model.MemberDao;

public class PwAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		   String id = request.getParameter("id");
		   String email = request.getParameter("email");
		   String tel = request.getParameter("tel");
		   String msg = "��й�ȣ�� ã�ҽ��ϴ�.";
		   String url = "loginForm.me";
		   MemberDao dao = new MemberDao();
		   String pass = dao.pwSearch(id,email,tel); 
		   if(pass != null) {
			   pass = pass.substring(2,pass.length());
			   request.setAttribute("pass", pass);
			   return new ActionForward();
		   }else {
			   msg = "������ �´� ��й�ȣ�� ã�� �� �����ϴ�.";
			   url = "pwForm.me";
			   request.setAttribute("mgs", msg);
			   request.setAttribute("url", url);
			return  new ActionForward(false,"../alert.jsp");
		   }

   }
}