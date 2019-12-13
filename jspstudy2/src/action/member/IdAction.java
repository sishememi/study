package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import model.Member;
import model.MemberDao;

public class IdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String  id = request.getParameter("id");
		if(id == null) { //idã��
			return idfind(request,tel,email);
		}else { //pw ã��
			return pwSearch(request,id,tel,email);
		}
	}
	private ActionForward pwSearch(HttpServletRequest request, String id, String tel, String email) {
		MemberDao dao = new MemberDao();
//		String msg = null;
//		String url = null;
		String pw = dao.pwSearch(id, email, tel);
		if(pw != null) { //��й�ȣ ã�� ����
			request.setAttribute("pass", pw.substring(2, pw.length()));
			return new ActionForward();
		}else { //��й�ȣ  ã�� ����			
		//	msg = "������ �´� id�� ã�� �� �����ϴ�.";
		//	url = "idForm.me";
			  request.setAttribute("msg", "������ �´� id�� ã�� �� �����ϴ�.");
			  request.setAttribute("url", "idForm.me");
			return  new ActionForward(false,"../alert.jsp");
		}
	}
	private ActionForward idfind(HttpServletRequest request, String tel, String email) {
		MemberDao dao = new MemberDao();
		String msg = null;
		String url = null;
		Member mem = new Member();
		String id = dao.idfind(email, tel);
		if(id != null){ //id�� ã�°��(����)
			id = id.substring(0,id.length()-2);
			request.setAttribute("id", id);
			return new ActionForward(); //id.jsp�� �̵�
		}else { //id ã�� ����.
			 msg = "������ �´� id�� ã�� �� �����ϴ�.";
			 url = "idForm.me";
				request.setAttribute("msg", msg);
				request.setAttribute("url", url);
				return new ActionForward(false,"../alert.jsp");
		}
	}
}

