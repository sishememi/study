package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.ActionForward;

public class LogoutAction extends UserloginAction { //���� ��Ʈ�ѷ��� UserloginAction���⿡�ִ� doexecute�� ȣ��

	@Override
	protected ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) {
		String msg = login + "���� �α׾ƿ� �ϼ̽��ϴ�.";
		String url = "loginForm.me";
		request.getSession().invalidate();
		request.setAttribute("msg",msg);
		request.setAttribute("url",url);
		return new ActionForward(false,"../alert.jsp");
	}
}
