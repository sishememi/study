package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import model.Member;
import model.MemberDao;

/* ���
 * 1. �α׾ƿ� ������ ���. �α����ϼ���. �޼��� ���.
 * 	   �ٸ� ������� ��й�ȣ ���� �Ұ�.
 * 	 Opener ��������  loginForm.me ������ �̵�.
 * 	  ���������� �ݱ�
 * 2. pass,chgpass �Ķ���� �� ����
 * 3. pass ��й�ȣ�� db�� ����� ��й�ȣ�� Ʋ����
 * 	    ��й�ȣ ���� �޼��� ���. passwordForm.me �������̵�
 * 4. pass ��й�ȣ�� db�� ����� ��й�ȣ�� ������
 * 	    ��й�ȣ ����. 
 * 	  opener �������� info.me ������ �̵�.
 * 	     ���� �������ݱ� 
 * 
 */
public class PasswordAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String login = (String)request.getSession().getAttribute("login");
		boolean opener = false;
		boolean closer = false;
		String msg = "��й�ȣ �����Դϴ�.Ȯ���ϼ���.";
		String url = "passwordForm.me";
		if(login == null || login.trim().equals("")){ //�α׾ƿ� ����
			opener  = true;
			closer = true;
			msg = "�α����ϼ���.";
			url = "loginForm.me";
		}else {//�α���
			String pass = request.getParameter("pass");
			String chgpass = request.getParameter("chgpass");
			MemberDao dao= new MemberDao();
			Member mem = dao.selectOne(login); //login�� �����ִ¾ֵ���� ����
			if(pass.equals(mem.getPass())){ //�Էµ� ��й�ȣ�� db�� �Էµ� ��й�ȣ�� ���� ���
				closer = true;
				if(dao.updatePass(login,chgpass) > 0) {
					opener = true;
					msg ="��й�ȣ�� ����Ǿ����ϴ�.";
					url="info.me?id=" + login;
				}else{
					msg = "��й�ȣ ������ ������ �߻��߽��ϴ�.";
				}
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		request.setAttribute("opener", opener);
		request.setAttribute("closer", closer);
		return new ActionForward();
	}

}
