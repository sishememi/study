package chap1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//url ������ /CurrentTime �� ��û�� ȣ��Ǵ� ������.
@WebServlet("/CurrentTime") // @ -> ������̼�. @WebServlet
public class CurrentTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurrentTime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //Get ������� ��û�� ȣ��Ǵ� �޼���
    //request : ��û ��ü, �������� ��û ���� �����ϰ� �ִ� ��ü
    //response : ���� ��ü, �������� ���޵Ǵ� ���������� �����ϰ� �ִ� ��ü
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
       response.setContentType("text/html; charset=EUC-KR");
       Calendar c = Calendar.getInstance();
       int h = c.get(Calendar.HOUR_OF_DAY);
       int m = c.get(Calendar.MINUTE);
       int s = c.get(Calendar.SECOND);
       // ��������½�Ʈ��
       PrintWriter out = response.getWriter();
       out.println("<html><head><title>����ð�</title></head>");
       out.println("<body>");
       out.println("<h1>����ð���" + h + "��" + m + "��" + s + "���Դϴ�.</h1></body></html>");
//       response.getWriter().append("Served at: ").append(request.getContextPath());
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
  //Post ������� ��û�� ȣ��Ǵ� �޼���
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
