package chap8;
/*
 * final ����: ���� �Ұ� ����. ���
 * final ������ �����ڿ��� �ѹ��� ���� ���� �� �� �ִ�.
 * �� ��������� �ʱ�ȭ ���� ���� ��쿡�� �����ϴ�.
 * const ����� ������ �ʴ´�. ����� final �����ڷ� ǥ����
 * */

class FinalValue{
	final int NUM;
	FinalValue(int num){
		NUM=num; //�����ڿ��� ���� �ѹ� ������.		
	}
	FinalValue(){
		this(100);
	}

	public int getNUM(){
		return NUM;
	}

}
public class FinalValueEx1 {
	public static void main(String[] args) {
		FinalValue f1 = new FinalValue();
		//f1.NUM=200; NUM�� ���.
		System.out.println(f1.getNUM()); //100
		FinalValue f2 = new FinalValue(120);
		System.out.println(f2.getNUM()); //120
	}
}

