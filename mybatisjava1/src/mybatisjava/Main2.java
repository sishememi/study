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
		private final static String NS ="student."; //final static String NS => 상수
		private static SqlSessionFactory sqlMap;
		static {	//static 초기화 블럭 (클래스정보 로드될ㄸ ㅐ 한번만 실행)
			InputStream input = null; 
			try {
				input = Resources.getResourceAsStream("mapper/mybatis-config.xml");
			}catch (IOException e) {
				e.printStackTrace();
			}
			sqlMap = new SqlSessionFactoryBuilder().build(input);
		}
		public static void main(String[] args) {
			SqlSession session = sqlMap.openSession(); //sqlMap에 있는 session가진..? Connection 기능..?
			//Student 테이블의  총 레코드 건수 출력하기
			int cnt = session.selectOne(NS+"count");
			System.out.println("student 테이블의 레코드 건수: " + cnt);
			//Student 테이블의  총 레코드 출력하기
			List<Student> list = session.selectList(NS + "list");
			for(Student s : list) System.out.println(s);
			
			System.out.println("Student 테이블에 레코드 추가하기");
			Student st = new Student();
			st.setStudno(1000);
			st.setName("홍길동");
			st.setGrade(1);
			st.setId("hongkd");
			st.setJumin("123456");
			st.setMajor1(101);
			cnt = session.insert(NS+"insert",st); //id속성값 insert
			System.out.println("student 레코드 추가: "+cnt);
			Student stu = session.selectOne(NS + "selectno",st.getStudno());
			System.out.println(stu);
			
			/*
			 * 	1000번 학생의 학년을 2학년으로 , 몸무게 80, 키를 175, 지도교수번호를 1001로 변경.
			 */
			System.out.println("Student 테이블 수정하기");
			//st = new Student();
			st.setGrade(2);
			st.setWeight(80);
			st.setHeight(175);
			st.setProfno(1001);
			cnt = session.update(NS + "update",st);
			System.out.println("student 레코드 수정: "+cnt);
			stu = session.selectOne(NS + "selectno",st.getStudno());
			System.out.println(stu);
			
			/*
			 *	성이 김씨인 학생의 목록 조회하기 
			 */
			System.out.println("성이 김씨인 학생의 목록 조회하기 ");
			list = session.selectList(NS + "select2","김");
			for(Student s : list) System.out.println(s);
			
			/*
			 * 101학과 학생 중 3학년 학생 이상인 학생의 목록 조회하기
			 * (조건이 2개 는 map을 이용해서 한번에 처리)
			 */
			System.out.println("101학과 학생 중 3학년 학생 이상인 학생의 목록 조회하기");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("major1",101);
			map.put("grade",3);
			list = session.selectList(NS + "select3",map);
			for(Student s : list) System.out.println(s);
			
			/*
			 * 몸무게가 75kg 이상인 학생의 목록을 조회하기
			 */
			System.out.println("몸무게가 75kg 이상인 학생");
			map.clear();
			map.put("col", "weight");
			map.put("val", 75);
			list = session.selectList(NS + "select4",map);
			for(Student s : list) System.out.println(s);
			/*
			 * 키가 175 이상인 학생의 목록 조회하기
			 */
			map.clear();
			map.put("col", "height");
			map.put("val", 175);
			System.out.println("키가 175 이상인 학생");
			list = session.selectList(NS + "select4",map);
			for(Student s : list) System.out.println(s);
			
			map.clear();
			map.put("col","grade");
			map.put("val",2);
			System.out.println("학년이 2학년 이상인 학생");
			list = session.selectList(NS + "select4",map);
			for(Student s : list) System.out.println(s);
			
			map.clear();
			map.put("col","substr(jumin,7,1)");
			map.put("val",2);
			System.out.println("주민번호 기준 여학생");
			list = session.selectList(NS + "select4",map);
			for(Student s : list) System.out.println(s);
			
			System.out.println("1000번 학생 삭제하기");
			map.clear();
			map.put("col","studno");
			map.put("val",1000);
			cnt = session.delete(NS + "delete",map);
			stu = session.selectOne(NS + "selectno" ,st.getStudno());
			System.out.println(stu);
			
			System.out.println("유진성 학생 삭제하기");
			map.clear();
			map.put("col","name");
			map.put("val","유진성");
			cnt = session.delete(NS+"delete",map);
			stu = session.selectOne(NS + "selectno",971211);
			System.out.println(stu);
		}
}

