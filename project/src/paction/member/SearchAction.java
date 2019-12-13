package paction.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paction.Action;
import paction.ActionForward;

import project.MemberDao;

public class SearchAction implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      String email = request.getParameter("email");
      String birth = request.getParameter("birth");
      String id = request.getParameter("id");
      if(id == null) {  //id ã��
         return idSearch(request,email,birth);
      }else {  //��й�ȣ ã��
         return pwSearch(request,id,email);
      }
   }
   private ActionForward pwSearch(HttpServletRequest request, String id, String email) {
      MemberDao dao = new MemberDao();
      String pw = dao.pwSearch(id,email);
      if(pw != null) { //��й�ȣ ã�� ����
         request.setAttribute("pass", pw.substring(2,pw.length()));
         return new ActionForward();
      }else {  //��й�ȣ ã�� ����
         request.setAttribute("msg", "������ �´� ��й�ȣ�� ã�� �� �����ϴ�.");
         request.setAttribute("url", "pwForm.me");
         return new ActionForward(false,"../alert.jsp");
      }
   }
   private ActionForward idSearch (HttpServletRequest request, String email, String birth) {
      MemberDao dao = new MemberDao();
      String id = dao.idSearch(email,birth);
      String msg = null;
      String url = null;
      if(id != null) { //id ã�� ���
         request.setAttribute("id", id);
         return new ActionForward();
      } else { //id ã�� ����
         msg = "������ ���� id�� �����ϴ�.";
         url = "idForm.me";
         request.setAttribute("msg", msg);
         request.setAttribute("url", url);
         return new ActionForward(false,"../alert.jsp");   
      }
   }
}