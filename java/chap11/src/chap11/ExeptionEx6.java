package chap11;
/*
 * throws : ����ó��: �߻��� ���ܸ� �����ϱ�
 * throw : ���ܹ߻�: ���� ���ܸ� ���� �߻�.
 */
public class ExeptionEx6 {
	public static void main(String[] args) {
		try {
			
			throw new Exception("���� ���� �߻�");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}	
}
