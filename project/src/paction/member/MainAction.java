package paction.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/* 
 * 로그인이 되어야만  doExecute메서드 실행
 */
import paction.ActionForward;

public class MainAction extends UserloginAction {

	@Override
	protected ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) 
	{
		return new ActionForward(); 
	}
}
