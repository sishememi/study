package chap7;
/*
 * �ʱ�ȭ �� ����
 * static �ʱ�ȭ ��:
 * 		�ֿ���: Ŭ���� ������ �ʱ�ȭ 
 * 		����ñ�: Ŭ���� ������ �ε� �ǰ�, �ѹ� ����.
 * �ν��Ͻ� �ʱ�ȭ ��
 * 		�ֿ���: �ν��Ͻ� ������ �ʱ�ȭ. �����ڿ� ����� ���ħ
 * 		����ñ�: ��ü ������ ������ ȣ������ ���� ȣ���.
*/
public class InitEx {

	static int cv; //Ŭ��������
	int iv; // �ν��Ͻ� ����
	InitEx(){  //������
		System.out.println("5.������ ȣ�� ��");
		}
	static {  //static �ʱ�ȭ �� /  Ŭ��������� ����
		cv = (int)(Math.random() * 100);
		System.out.println("1.Ŭ���� �ʱ�ȭ ��  cv="+cv);
	}
	
	{ //�ν��Ͻ� �ʱ�ȭ ��  / �ν��Ͻ� ��� (���� ��������)
		System.out.println("4.�ν��Ͻ� �ʱ�ȭ ��. �����ں��� ���� ȣ���");
		iv = (int)(Math.random() * 100);
	}
	public static void main(String[] args) {
		System.out.println("2.main �޼��� ����.");
		System.out.println("3.main init1 ��ü ����");
		InitEx init1 = new InitEx();
		System.out.println("main init2 ��ü ����");
		InitEx init2 = new InitEx();
		
	}
}
