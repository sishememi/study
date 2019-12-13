package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
/*
 * ���
 * 1. �α׾ƿ� ���� : "�α����� �ʿ��մϴ�" �޼��� ��� �� loginForm.me �������� �̵�
 * 2. �α��� ����
 *       �Ϲ� ����� : "�����ڸ� ������ �ŷ��Դϴ�" �޼��� ��� �� main.me �������� �̵�
 */
public abstract class AdminLoginAction implements Action{
   protected String login; // �α��� ����
   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception 
   {
      login = (String)request.getSession().getAttribute("login");
      if(login == null || login.trim().equals(""))
      {
         request.setAttribute("msg", "�α��� �� �ŷ��ϼ���");
         request.setAttribute("url", "loginForm.me");
         return new ActionForward(false, "../alert.jsp");            
      }
      else
      {
         if(!login.equals("admin"))
         {
            request.setAttribute("msg", "�����ڸ� ������ �ŷ��Դϴ�");
            request.setAttribute("url", "main.me");
            return new ActionForward(false, "../alert.jsp");            
         }
      }
      return adminExecute(request, response);            

   }
   protected abstract ActionForward adminExecute(HttpServletRequest request, HttpServletResponse response);

}