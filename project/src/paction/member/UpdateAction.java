package paction.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.Member;
import project.MemberDao;
import paction.ActionForward;

public class UpdateAction extends UserloginAction {

	@Override
	protected ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) {
		Member mem = new Member(); //usebean�׼��±׸� ����Ҽ����⶧���� ������ ���� ����. 
		mem.setId(request.getParameter("id"));
		mem.setPass(request.getParameter("pass"));
		mem.setNickname(request.getParameter("nicname"));
		mem.setGender(Integer.parseInt(request.getParameter("gender")));
		mem.setEmail(request.getParameter("email"));
		mem.setBirth(request.getParameter("birth"));
		mem.setTravel(Integer.parseInt(request.getParameter("travel")));
		mem.setNational(request.getParameter("national"));

		MemberDao dao=new MemberDao();
		Member dbmem = dao.selectOne(id);
		String msg =  "��й�ȣ�� Ʋ�Ƚ��ϴ�.";
		String url = "updateForm.me?id="+mem.getId();
		if(!login.equals("admin") && mem.getPass().equals(dbmem.getPass())) {
			if(dao.update(mem) > 0 ) {
				msg="������ �Ϸ�Ǿ����ϴ�.";
				url="mypageForm.me?";
				
			}else {
				msg="������ �Ϸ����� ���Ͽ����ϴ�.";
				url="mainForm.me";
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
	}

}
