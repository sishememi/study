package project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import project.mapper.BoardMapper;

public class BoardDao {
	private Map<String,Object> map = new HashMap<String,Object>();
	private Class<BoardMapper> cls = BoardMapper.class;
	//���� ��ϵ� �Խù� ��ȣ �� �ִ밪�� ����
	public int maxnum() {
		SqlSession session = DBConnection.getConnection();
		try {
			return session.getMapper(cls).maxnum();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}
	
	public boolean insert(Board board) {
		SqlSession session = DBConnection.getConnection();
		try {
			int cnt = session.getMapper(cls).insert(board);
			if (cnt >0)  return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return false;
	}
	
	public int boardCount(String column,String find) {
		//�Խù� �Ǽ�
		SqlSession session = DBConnection.getConnection();
		try {
			map.clear();
			if(column != null) {
				String [] col =column.split(",");
				map.put("col1", col[0]);
				if(col.length ==2) {
					map.put("col2" , col[1]);
				}
				map.put("find", find);
			}
			return session.getMapper(cls).boardcount(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return 0;
	}
	
	public List<Board> list(int pageNum,int limit,String column,String find) {
		SqlSession session = DBConnection.getConnection();
		try {
			map.clear();
			map.put("start", (pageNum -1) * limit);
			map.put("limit", limit);
			if(column != null) {
				String [] col = column.split(",");
				map.put("col1", col[0]);
				if(col.length == 2) {
					map.put("col2" , col[1]);
				}
				map.put("find", find);
			}
			return session.getMapper(cls).select(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return null;		
	}	
	
	public Board selectOne(int bnum) {
		SqlSession session = DBConnection.getConnection();
		try {
			map.clear();
			map.put("bnum", bnum);
			return session.getMapper(cls).select(map).get(0);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
		return null;
	}
	//��ȸ�� ����
	public void readcntadd(int num) {
		SqlSession session = DBConnection.getConnection();
		try {
			session.getMapper(cls).readcntadd(num);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(session);
		}
	}
	//����� ���� ����
	public void getStepAdd(int grp,int grpstep) {
		SqlSession session = DBConnection.getConnection();
		try {
			session.getMapper(cls).getStepAdd(grp, grpstep);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
	}
	//�Խñ� ����
	public boolean update(Board board) {
		SqlSession session = DBConnection.getConnection();
		try {
			int cnt = session.getMapper(cls).update(board);
			if (cnt > 0) return true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return false;
	}
	//�Խñ� ����
	public boolean delete(int num) {
		SqlSession session = DBConnection.getConnection();
		try {
			int cnt = session.getMapper(cls).delete(num);
			if (cnt > 0) return true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return false;
	}
	
	public List<Map<String,Integer>> boardgraph(){
		SqlSession session = DBConnection.getConnection();
		List<Map<String,Integer>> map = null;
		try {
			map = session.getMapper(cls).graph();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(session);
		}
		return map;
	}
}