package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/* 
 * �α����� �Ǿ�߸�  doExecute�޼��� ����
 */
import action.ActionForward;

public class MainAction extends UserloginAction {

	@Override
	protected ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) 
	{
		return new ActionForward(); 
	}
}
