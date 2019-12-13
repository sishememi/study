package chap9;
interface DataAccessObject{
	void select();
	void insert();
	void update();
	void delete();
}

class  OracleDao implements DataAccessObject {

	@Override
	public void select() {
		System.out.println("Oracle DB���� �˻�");
	}

	@Override
	public void insert() {
		System.out.println("Oracle DB�� ����");
	}

	@Override
	public void update() {
		System.out.println("Oracle DB�� ����");
	}

	@Override
	public void delete() {
		System.out.println("Oracle DB���� ����");
	}
}
class MySqlDao implements DataAccessObject{

	@Override
	public void select() {
		System.out.println("Mysql DB���� �˻�");	
	}

	@Override
	public void insert() {
		System.out.println("Mysql DB�� ����");
	}

	@Override
	public void update() {
		System.out.println("Mysql DB�� ����");
	}

	@Override
	public void delete() {
		System.out.println("Mysql DB���� ����");	
	}	
}
public class ex190910 {
	public static void main(String[] args) {
		dbWork(new OracleDao());
		dbWork(new MySqlDao());
	}
		private static void dbWork(DataAccessObject dao) {
		 dao.select();
		 dao.insert();
		 dao.update();
		 dao.delete();
	}
}
