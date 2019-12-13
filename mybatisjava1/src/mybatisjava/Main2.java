package mybatisjava;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main2 {
		private final static String NS ="student."; //final static String NS => ���
		private static SqlSessionFactory sqlMap;
		static {	//static �ʱ�ȭ �� (Ŭ�������� �ε�ɤ� �� �ѹ��� ����)
			InputStream input = null; 
			try {
				input = Resources.getResourceAsStream("mapper/mybatis-config.xml");
			}catch (IOException e) {
				e.printStackTrace();
			}
			sqlMap = new SqlSessionFactoryBuilder().build(input);
		}
		public static void main(String[] args) {
			SqlSession session = sqlMap.openSession(); //sqlMap�� �ִ� session����..? Connection ���..?
			//Student ���̺���  �� ���ڵ� �Ǽ� ����ϱ�
			int cnt = session.selectOne(NS+"count");
			System.out.println("student ���̺��� ���ڵ� �Ǽ�: " + cnt);
			//Student ���̺���  �� ���ڵ� ����ϱ�
			List<Student> list = session.selectList(NS + "list");
			for(Student s : list) System.out.println(s);
			
			System.out.println("Student ���̺� ���ڵ� �߰��ϱ�");
			Student st = new Student();
			st.setStudno(1000);
			st.setName("ȫ�浿");
			st.setGrade(1);
			st.setId("hongkd");
			st.setJumin("123456");
			st.setMajor1(101);
			cnt = session.insert(NS+"insert",st); //id�Ӽ��� insert
			System.out.println("student ���ڵ� �߰�: "+cnt);
			Student stu = session.selectOne(NS + "selectno",st.getStudno());
			System.out.println(stu);
			
			/*
			 * 	1000�� �л��� �г��� 2�г����� , ������ 80, Ű�� 175, ����������ȣ�� 1001�� ����.
			 */
			System.out.println("Student ���̺� �����ϱ�");
			//st = new Student();
			st.setGrade(2);
			st.setWeight(80);
			st.setHeight(175);
			st.setProfno(1001);
			cnt = session.update(NS + "update",st);
			System.out.println("student ���ڵ� ����: "+cnt);
			stu = session.selectOne(NS + "selectno",st.getStudno());
			System.out.println(stu);
			
			/*
			 *	���� �达�� �л��� ��� ��ȸ�ϱ� 
			 */
			System.out.println("���� �达�� �л��� ��� ��ȸ�ϱ� ");
			list = session.selectList(NS + "select2","��");
			for(Student s : list) System.out.println(s);
			
			/*
			 * 101�а� �л� �� 3�г� �л� �̻��� �л��� ��� ��ȸ�ϱ�
			 * (������ 2�� �� map�� �̿��ؼ� �ѹ��� ó��)
			 */
			System.out.println("101�а� �л� �� 3�г� �л� �̻��� �л��� ��� ��ȸ�ϱ�");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("major1",101);
			map.put("grade",3);
			list = session.selectList(NS + "select3",map);
			for(Student s : list) System.out.println(s);
			
			/*
			 * �����԰� 75kg �̻��� �л��� ����� ��ȸ�ϱ�
			 */
			System.out.println("�����԰� 75kg �̻��� �л�");
			map.clear();
			map.put("col", "weight");
			map.put("val", 75);
			list = session.selectList(NS + "select4",map);
			for(Student s : list) System.out.println(s);
			/*
			 * Ű�� 175 �̻��� �л��� ��� ��ȸ�ϱ�
			 */
			map.clear();
			map.put("col", "height");
			map.put("val", 175);
			System.out.println("Ű�� 175 �̻��� �л�");
			list = session.selectList(NS + "select4",map);
			for(Student s : list) System.out.println(s);
			
			map.clear();
			map.put("col","grade");
			map.put("val",2);
			System.out.println("�г��� 2�г� �̻��� �л�");
			list = session.selectList(NS + "select4",map);
			for(Student s : list) System.out.println(s);
			
			map.clear();
			map.put("col","substr(jumin,7,1)");
			map.put("val",2);
			System.out.println("�ֹι�ȣ ���� ���л�");
			list = session.selectList(NS + "select4",map);
			for(Student s : list) System.out.println(s);
			
			System.out.println("1000�� �л� �����ϱ�");
			map.clear();
			map.put("col","studno");
			map.put("val",1000);
			cnt = session.delete(NS + "delete",map);
			stu = session.selectOne(NS + "selectno" ,st.getStudno());
			System.out.println(stu);
			
			System.out.println("������ �л� �����ϱ�");
			map.clear();
			map.put("col","name");
			map.put("val","������");
			cnt = session.delete(NS+"delete",map);
			stu = session.selectOne(NS + "selectno",971211);
			System.out.println(stu);
		}
}

