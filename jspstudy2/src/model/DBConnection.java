package model;

import java.io.IOException;
import java.io.Reader;


import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class DBConnection {
	private static SqlSessionFactory sqlMap; //static=>��ü ��ü���� �ϳ��� ��.
	static {
		//mybatis-config.xml ������ ��ġ
		String resource = "model/mapper/mybatis-config.xml"; //model/mapper/ �����̱⶧���� ������ ����. ��Ű���� ������ �� ����. 
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		}catch(IOException e) {
			e.printStackTrace();
		}
		//bulid : Connection ��ü ����.
		//		  SQL ���� �����ϴ� �����̳� ����.
		sqlMap = new SqlSessionFactoryBuilder().build(reader);
	}
	static SqlSession getConnection() {//���� ��Ű�������� ��밡��
		return sqlMap.openSession(); //DB�� �����ϱ�
	}
	static void close(SqlSession session) {//���� ��Ű�������� ��밡��
		session.commit();
		session.close();
	}
}
