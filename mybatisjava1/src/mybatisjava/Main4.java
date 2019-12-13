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

import mapper.StudentMapper3;

public class Main4 {
	private final static String ns ="mapper.StudentMapper3."; //final static String NS => ���
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
		SqlSession session = sqlMap.openSession();
		System.out.println("��� �л� ���� ��ȸ�ϱ�");
		List<Student> list = session.getMapper(StudentMapper3.class).select(null);
		for(Student s : list) System.out.println(s);
		
		System.out.println("xml��İ� �����ϰ� ȣ��");
		list = session.selectList(ns+"select");
		for(Student s : list) System.out.println(s);
		
		System.out.println("1�г� �л� ���� ��ȸ�ϱ�");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("grade", 1);
		list = session.getMapper(StudentMapper3.class).select(map);
		for(Student s : list) System.out.println(s);
		
		System.out.println("981213 �й� �л� ��ȸ�ϱ�");
		map.clear();
		map.put("studno", 981213);
		list = session.getMapper(StudentMapper3.class).select(map);
		for(Student s: list) System.out.println(s);
		
		System.out.println("ȫ�浿 �л� ���� �߰��ϱ�");
		Student st = new Student();
		st.setStudno(1000);
		st.setName("ȫ�浿");
		st.setJumin("12345");
		st.setId("hongkd");
		int result = session.getMapper(StudentMapper3.class).insert(st);
		System.out.println(result+"�� �߰�");
		map.clear();
		map.put("studno", 1000);
		list = session.getMapper(StudentMapper3.class).select(map);
		for(Student s: list) System.out.println(s);
		
		System.out.println("ȫ�浿 �л��� �г��� 1�г�, ������ : 80 , Ű :175�� ����");
		st.setGrade(1);
		st.setWeight(80);
		st.setHeight(175);
		result = session.getMapper(StudentMapper3.class).update(st);
		System.out.println(result+"�� ����");
		map.clear();
		map.put("studno",1000);
		list = session.getMapper(StudentMapper3.class).select(map);
		for(Student s: list) System.out.println(s);
		
		System.out.println("�й��� 1000���� ȫ�浿 �л� ���� �����ϱ�.");
		result = session.getMapper(StudentMapper3.class).delete("ȫ�浿",1000);
		System.out.println(result+"�� ����");
		list = session.getMapper(StudentMapper3.class).select(map);
		for(Student s: list) System.out.println(s);
		}
}
