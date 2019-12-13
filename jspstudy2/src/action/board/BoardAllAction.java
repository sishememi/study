package action.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.oreilly.servlet.MultipartRequest;


import action.ActionForward;
import model.Board;
import model.BoardDao;

public class BoardAllAction {
	private BoardDao dao = new BoardDao();
	public ActionForward hello(HttpServletRequest requset,HttpServletResponse response) {
		requset.setAttribute("hello", "Hello, world");
		return new ActionForward();
	}
	/**  
	  1. multipart/form.data Ÿ���� �����̹Ƿ� MultipartRequest ��ü ����
	  2. �Ķ���� ���� model.Board ��ü ����.
 			useBean ���Ұ�: request ������ �Ķ���Ϳ� ��Ŭ������ ������Ƽ ��
 					       request ��ü�� ��� �� �� ����.
 	  3. �Խù� ��ȣ num ���� ��ϵ� num�� �ִ밪�� ��ȸ. �ִ밪 +1 ��ϵ� �Խù��� ��ȣ.
 		 db���� maxnum�� ���ؼ� +1 ������ num �����ϱ�.
 	  4. board ������ DB�� ����ϱ�
 			��� ����: �޼��� ���. list.do ������ �̵�
 			��� ����: �޼��� ���. writeForm.do ������ �̵�
	 * @throws ServletException 
	 
	 */
	public ActionForward write(HttpServletRequest request, HttpServletResponse reseponse) throws ServletException {
		String msg = "�Խù� ��� ����";
		String url = "writeForm.do";
		String path = request.getServletContext().getRealPath("/")+"model2/board/file/";
		try {
		File f = new File(path);
		if(!f.exists())f.mkdirs();
		MultipartRequest multi = new MultipartRequest(request, path,10*1024*1024,"euc-kr");
		//2
		Board b = new Board();
		b.setName(multi.getParameter("name"));
		b.setPass(multi.getParameter("pass"));
		b.setSubject(multi.getParameter("subject"));
		b.setContent(multi.getParameter("content"));
		b.setFile1(multi.getFilesystemName("file1"));
		//3
		int num = dao.maxnum(); //�ִ밪�� �������Ե�
		b.setNum(++num);
		b.setGrp(num);
		if(dao.insert(b)) {
			msg = "�Խù� ��� ����";
			url = "list.do";
		}
		}catch(IOException e) {
			throw new ServletException();
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
	}
	/*
	 *  1. ���������� 10���� �Խù��� ����ϱ�.
      		pageNum �Ķ���Ͱ��� ���� => ���� ���� 1�� �����ϱ�.
   		2. �ֱ� ��ϵ� �Խù��� ���� ���� ��ġ��.
   		3. ȭ�鿡 �ʿ��� ������ �Ӽ����� ���. view�� ����.
	 * 
	 */
	public ActionForward list(HttpServletRequest request, HttpServletResponse reseponse) throws ServletException {
		int limit =  10;
		int pageNum = 1;
		try {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}catch (NumberFormatException e) {}
		String  column = request.getParameter("column");
		String find = request.getParameter("find");
		if(column != null && column.trim().equals(""))
			column=null;
		if(find != null && find.trim().equals(""))
			find=null;
		if(column == null || find == null) {
			column = null;
			find = null;
		}
		int boardcnt = dao.boardCount(column,find);
		List<Board> list = dao.list(pageNum, limit,column,find);
		int maxpage = (int)((double)boardcnt/limit+0.95);
		int startpage = ((int)(pageNum/10.0 + 0.9)-1)* 10 + 1;
		int endpage = startpage + 9;
		if(endpage > maxpage) endpage = maxpage;
		int boardnum = boardcnt - (pageNum-1) * limit;
		request.setAttribute("boardcnt", boardcnt);
		request.setAttribute("list", list);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("boardnum", boardnum);
		request.setAttribute("pageNum", pageNum);
		return new ActionForward();
	}
	/*
	 *  1. num �Ķ���� ������ ������ ����.
  		2. num�� �̿��Ͽ� db���� �Խù� ������ ��ȸ
     		Board BoardDao.selectOne(num)
  		3. ��ȸ�� ������Ű��   
     		void BoardDao.readcntadd(num)
  		4. ��ȸ�� �Խù��� ȭ�鿡 ���. 
	 * 
	 */
	public ActionForward info(HttpServletRequest request, HttpServletResponse reseponse) {
		int num = Integer.parseInt(request.getParameter("num"));
		Board b = dao.selectOne(num);
		// request.getRequestURI() : /jspstudy2/model2/board/info.do
		if(request.getRequestURI().contains("info.do")) {
			dao.readcntadd(num);
		}
		request.setAttribute("b", b);
		return new ActionForward();
	}
	  /*
	*   1.�Ķ���� ���� Board ��ü�� �����ϱ�. 
			��������: num, grp, grplevel, grpstep 
			�������: name, pass, subject, content => �������
		2.���� grp ���� ����ϴ� �Խù����� grpstep ���� 1 �����ϱ�
			void BoardDao.grpSetAdd(grp,grpstep)
		3.Board ��ü�� db�� insert �ϱ�
			num : maxnum + 1
			grp : ���۰� ����
			grplevel : ���� + 1
			grpstep : ���� + 1
		*/
	public ActionForward reply(HttpServletRequest request, HttpServletResponse reseponse) {
		Board b = new Board();
		b.setNum(Integer.parseInt(request.getParameter("num")));
		b.setGrp(Integer.parseInt(request.getParameter("grp")));
		b.setGrplevel(Integer.parseInt(request.getParameter("grplevel")));
		b.setGrpstep(Integer.parseInt(request.getParameter("grpstep")));
		b.setName(request.getParameter("name"));
		b.setPass(request.getParameter("pass"));
		b.setSubject(request.getParameter("subject"));
		b.setContent(request.getParameter("content"));
		dao.getStepAdd(b.getGrp(), b.getGrpstep());
		int grplevel = b.getGrplevel();
		int grpstep = b.getGrpstep();
		int num = dao.maxnum();
		String msg = "�亯 ��Ͻ� �����߻�";
		String url = "replyForm.do?num=" +b.getNum();
		b.setNum(++num);
		b.setGrplevel(grplevel+1);
		b.setGrpstep(grpstep+1);
		if(dao.insert(b)){
			msg = "�亯 ��ϿϷ�";
			url = "list.do";
	}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
	}
	/*
	 * 1.�Ķ���� �������� Board ��ü�� ����.
	 * 2.��й�ȣ ����
	 * 	��й�ȣ ��ġ�ϴ°��
	 * 		���� �Ķ������ �������� �ش� �Խù��� ������ �����ϱ�.
	 * 		÷�� �����Ǻ����� ���� ��� file2 �Ķ������ ������ �ٽ� �����ϱ�
	 * 	��й�ȣ ����ġ
 			��й�ȣ ���� �޼��� ����ϰ�, updateForm.do�� ������ �̵�
 		3. �������� : �������� �޼��� ��� ��. info.do ������ �̵�
 	                �������� : �������� �޼��� ��� ��. updateForm.do ������ �̵�
	 * 
	 */
	public ActionForward update(HttpServletRequest request,HttpServletResponse response) throws IOException  {
		   Board b = new Board();
		   String path = request.getServletContext().getRealPath("/")+"model2/board/file/";
		   MultipartRequest multi = new MultipartRequest(request,path,10*1024*1024 ,"euc-kr");
		    b.setNum(Integer.parseInt(multi.getParameter("num")));
		    b.setName(multi.getParameter("name"));
			b.setPass(multi.getParameter("pass"));
			b.setSubject(multi.getParameter("subject"));
			b.setContent(multi.getParameter("content"));
			b.setFile1(multi.getFilesystemName("file1")); //÷�����Ͽ� �ش��ϴ� ������ �ȵȰ��.
			if(b.getFile1() == null || b.getFile1().equals("")) {
				b.setFile1(multi.getParameter("file2"));
			}
			BoardDao dao = new BoardDao();
			Board dbBoard = dao.selectOne(b.getNum());
			String msg = "��й�ȣ�� Ʋ�Ƚ��ϴ�.";
			String url = "updateForm.do?num="+b.getNum();
			if(b.getPass().equals(dbBoard.getPass())){
				if(dao.update(b)){
					msg = "�Խù� �����Ϸ�";
					url = "info.do?num="+b.getNum();
				}else {
					msg= "�Խù� ���� ���� ";
				}
			}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
	}
	/*
	 *  1. num,pass �Ķ���͸� ������ ����.
		2. �Էµ� ��й�ȣ�� db ��й�ȣ ����
			Ʋ�����: ��й�ȣ ���� �޼��� ���, deleteForm.do ������ �̵�
		3. ��й�ȣ�� �´� ��� : �Խù� ����.
			���� ���� : ���� ���� �޼��� ���. list.do ������ �̵�
			���� ����  : ���� ���� �޼��� ���. info.do ������ �̵�
	 * 
	 */
	public ActionForward delete(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		String pass= request.getParameter("pass");
		String msg = "��й�ȣ�� Ʋ���ϴ�.";
		String url = "deleteForm.do";
		Board b = dao.selectOne(num);
		if(b == null) {
			msg = "���� �Խñ� �Դϴ�.";
			url = "list.do";
		}else {
			if(pass.equals(b.getPass())) {
				msg = "��й�ȣ�� Ʋ���ϴ�.";
				url = "deleteForm.do";
				if(dao.delete(num)) {
					msg = "�Խù� �����Ϸ�";
					url = "list.do";
				}else {
					msg = "�Խù� ���� ����";
					url = "info.do?num=" +num;
				}
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return new ActionForward(false,"../alert.jsp");
	}
	/*
	 * CKEDITOR���� �̹����� �Խ��� ���뿡 �߰��ϱ� 
	 */
	public ActionForward imgupload(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String path = request.getServletContext().getRealPath("/") + "model2/board/imgfile/";
		File f= new File(path);
		if(!f.exists()) f.mkdirs();
		MultipartRequest multi = new MultipartRequest(request, path, 10*1024*1024 , "euc-kr");
		String fileName = multi.getFilesystemName("upload");
		request.setAttribute("fileName", fileName);
		request.setAttribute("CKEditorFuncNum", request.getParameter("CKEditorFuncNum"));
		return new ActionForward(false,"ckeditor.jsp");
	}
	public ActionForward exchange(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String url="https://www.koreaexim.go.kr/site/program/financial/exchange?menuid=001001004002001";
		Document doc = null;
		List<String> list =  new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		try {
			doc = Jsoup.connect(url).get();
			Elements e1 = doc.select(".tc");//ȯ������ =�����ڵ�,ȯ���� �±׼���
			Elements e2 = doc.select(".tl2.bdl");//�����̸�
			for(int i=0; i<e1.size();i++) {
				if(e1.get(i).html().equals("USD")) { //usd���� ����
					list.add(e1.get(i).html());
					for(int j=1; j<=6; j++) {
						list.add(e1.get(i+j).html());//usd ���� ����
					}
					break;
				}
			}
			for(Element ele : e2) {
				if(ele.html().contains("�̱�")) {
					list2.add(ele.html());
				}
			}
			    
		}catch(IOException e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		request.setAttribute("today", new Date());
		return new ActionForward(); //����.
	}
	
	public ActionForward exchange2(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String url="https://www.koreaexim.go.kr/site/program/financial/exchange?menuid=001001004002001";
		Document doc = null;
		Map<String,List<String>> map = new TreeMap<>(Comparator.reverseOrder());
		List<String> names = Arrays.asList("�̱�","����","�Ϻ�");
		List<String> codes = Arrays.asList("USD","EUR","JPY");
		try {
			doc = Jsoup.connect(url).get();
			Elements e1 = doc.select(".tc");//ȯ������ =�����ڵ�,ȯ���� �±׼���
			Elements e2 = doc.select(".tl2.bdl");//�����̸�
			for(Element ele : e2) { //�����̸�
			  for(int n =0; n<names.size(); n++) {
					//names.get(0) : �̱�
				 if(ele.html().contains(names.get(n))) {
					List<String> list = new ArrayList<>();
				  for(int i=0; i<e1.size(); i++) {
					if(e1.get(i).html().startsWith(codes.get(n))) { //EUR�� ���� �ڵ带 ����������
						//codes.get(n) : "USD"
					  list.add(e1.get(i).html());
						// i : USD �ڵ尪�� index��
					  for(int j=1; j<=6; j++) { //eur�� ������
						list.add(e1.get(i+j).html());//���� ����
					}	
				}
			}
			//ele.html() : �����̸�
			//list : ������ ��ȭ�ڵ�� ȯ����
			 map.put(ele.html(),list);
			 }
			}
		   }
		}catch(IOException e) {
			e.printStackTrace();
		}
		request.setAttribute("map", map);
		request.setAttribute("today", new Date());
		return new ActionForward(); //����.
	}
	public ActionForward graph(HttpServletRequest request,HttpServletResponse response) throws IOException{
		List<Map<String,Integer>> list = dao.boardgraph(); //String = name���� ���� Integer= cnt,? �ʰ�ü�� listȭ �ؼ� ����..
		StringBuilder json = new StringBuilder("[");
		int i= 0;
		//json���·� ����
		System.out.println(list.size());
		for(Map<String,Integer> m :list) {
			for(Map.Entry<String, Integer> me : m.entrySet()) {
				if(me.getKey().equals("name"))json.append("{\"name\":\""+me.getValue()+"\",");
				if(me.getKey().equals("cnt"))json.append("\"cnt\":"+me.getValue()+"}");
			}
			i++;
			if(i<list.size()) json.append(",");
		}
		json.append("]");
		request.setAttribute("json", json.toString().trim());
		return new ActionForward();
	}
	
	public ActionForward graph2(HttpServletRequest request,HttpServletResponse response) throws IOException{
		List<Map<String,Integer>> list = dao.boardgraph(); //String = name���� ���� Integer= cnt,? �ʰ�ü�� listȭ �ؼ� ����..
		StringBuilder json = new StringBuilder("[");
		int i= 0;
		//json���·� ����
		System.out.println(list.size());
		for(Map<String,Integer> m :list) {
			for(Map.Entry<String, Integer> me : m.entrySet()) {
				if(me.getKey().equals("name"))json.append("{\"name\":\""+me.getValue()+"\",");
				if(me.getKey().equals("cnt"))json.append("\"cnt\":"+me.getValue()+"}");
			}
			i++;
			if(i<list.size()) json.append(",");
		}
		json.append("]");
		request.setAttribute("json", json.toString().trim());
		return new ActionForward();
	}
}

