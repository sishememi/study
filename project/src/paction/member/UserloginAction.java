package paction.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paction.Action;
import paction.ActionForward;

public abstract class UserloginAction implements Action {
	protected String login; //�α��� ����
	protected String id; //id ����
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		login = (String)request.getSession().getAttribute("login");
		id =request.getParameter("id");
	//	System.out.println(login+"," + id);
		if(login == null || login.trim().equals("")) {
			request.setAttribute("msg", "�α����ϼ���");
			request.setAttribute("url", "loginForm.jsp");
			return new ActionForward(false,"../alert.jsp"); //��������ϸ� return doExecute(request,response);�� �������.
		}else {
			  if(!login.equals("admin") && id != null && !login.equals(id)) {
				request.setAttribute("msg", "���θ� �����մϴ�.");
				request.setAttribute("url", "loginForm.jsp");
				return new ActionForward(false,"../alert.jsp");
			}
		}
		return doExecute(request,response);
	}
protected abstract ActionForward doExecute(HttpServletRequest request , HttpServletResponse response);
}
