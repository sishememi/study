package project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import project.mapper.MemberMapper;
//Model ����� ����ϴ� Ŭ����. db�� ������ ����� ���� Ŭ����.
//Dao : Data Access Object
//Member: MemberŬ����
public class MemberDao {
	private Map<String,Object> map = new HashMap<String,Object>();
	private Class<MemberMapper> cls = MemberMapper.class;
	public Member selectOne(String id) {
		//id : ȭ�鿡�� �Էµ� ���̵�
		SqlSession session = DBConnection.getConnection();
		try {
			map.clear();
			map.put("id",id);
			List<Member> list = session.getMapper(cls).select(map);
			return list.get(0);//list���ִ� ù��° ���ڵ�.
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return null;
	}
	//ȸ�����
	public int insert(Member m) {
		SqlSession session = DBConnection.getConnection();
		try {
			return session.getMapper(cls).insert(m);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
	 	return 0; //insert ����
	} 
	public List<Member> list() {
		SqlSession session  = DBConnection.getConnection(); //Connection ��ü����
		try {
			return session.getMapper(cls).select(null); //��� ����� ��Ҹ� ������ select(null)
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return null; //������ ���� null�� ����.
	}
	public int update(Member m) {
		//m : ����ڰ� �Է��� ȸ�� ����. ����� ����
		SqlSession session  = DBConnection.getConnection();
		try {
			return session.getMapper(cls).update(m);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return 0;
	}
	public int delete(String id) {
		//m : ����ڰ� �Է��� ȸ�� ����. ����� ����
		SqlSession session = DBConnection.getConnection();
		try {
			return session.getMapper(cls).delete(id);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return 0;
	}
	public int updatePass(String id, String pass) {
		SqlSession session = DBConnection.getConnection();
		try {
			return session.getMapper(cls).updatpass(id,pass);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return 0;
	}
	public String idSearch(String email, String birth) {
		SqlSession session = DBConnection.getConnection();
		try {
			return session.getMapper(cls).idSearch(email,birth);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}return null;
	}
	 public String pwSearch(String id, String email) {
		 SqlSession session = DBConnection.getConnection();
		   try {
			   return session.getMapper(cls).pwSearch(id,email);
		   } catch (Exception e) {
			   e.printStackTrace();
		   } finally {
			   DBConnection.close(session);
		   }
		   return null;
	   }

}
