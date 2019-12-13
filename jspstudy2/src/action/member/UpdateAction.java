package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
1. ��� �Ķ���� Member ��ü�� ����
2. �Էµ� ��й�ȣ�� db�� ����� ��й�ȣ�� ����������
	"��й�ȣ�� Ʋ�Ƚ��ϴ�." �޼��� ��� ��, updateForm.me �������� �̵�.
3. 1���� ������ db�� �����ϱ�
	 int MemberDao.update(Member)
	����� 0���� ũ�� "��������" �޼��� ���. info.me ������ �̵�
		 0���� ������ "���� ����" �޼��� ���. main.mn ������ �̵� 
*/  
import action.ActionForward;
import model.Member;
import model.MemberDao;

public class UpdateAction extends UserloginAction{
	@Override
	protected ActionForward doExecute(HttpServletRequest request, HttpServletResponse response) {
		Member mem = new Member(); //usebean�׼��±׸� ����Ҽ����⶧���� ������ ���� ����.
		mem.setPicture(request.getParameter("picture")); 
		mem.setId(request.getParameter("id"));
		mem.setPass(request.getParameter("pass"));
		mem.setName(request.getParameter("name"));
		mem.setGender(Integer.parseInt(request.getParameter("gender")));
		mem.setEmail(request.getParameter("email"));
		mem.setTel(request.getParameter("tel"));

		MemberDao dao=new MemberDao();
		Member dbmem = dao.selectOne(id);
		String msg =  "��й�ȣ�� Ʋ�Ƚ��ϴ�.";
		String url = "updateForm.me?id="+mem.getId();
		if(!login.equals("admin") && mem.getPass().equals(dbmem.getPass())) {
			if(dao.update(mem) > 0 ) {
				msg="������ �Ϸ�Ǿ����ϴ�.";
				url="info.me?id="+mem.getId();
				
			}else {
				msg="������ �Ϸ����� ���Ͽ����ϴ�.";
				url="main.me";
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
	}
}
