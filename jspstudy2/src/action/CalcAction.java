package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			int num1 = Integer.parseInt(request.getParameter("num1"));
			int num2 = Integer.parseInt(request.getParameter("num2"));
			String op = request.getParameter("op");	
			if(op.equals("+")) {
				request.setAttribute("result", num1+num2);
			}else if(op.equals("-")) {
				request.setAttribute("result", num1-num2);
			}else if(op.equals("*")) {
				request.setAttribute("result", num1*num2);
			}else {
				request.setAttribute("result", num1/num2);
			}
			
		}catch(NumberFormatException e) {
			request.setAttribute("resutl", 0);
		}
		return new ActionForward(false,"calc.jsp");
	}
}

/*
 * ������ڴ� ���� ������������
 * 	equals�� ���빰(��)�� ���� ���� String�� ���� equals�� ����
 * */
 