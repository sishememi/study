package chap8;
/*
 * ��� ����
 * 
 *  1.�ڼհ�ü�� ��ü ������ �θ�ü�� ���� �����Ѵ�.
 *  2.�ڼհ�ü�� �θ� ��ü�� ����� ���� �� �� �ִ�.
 *  3.Ŭ�������� ����� ���� ��Ӹ� �����ϴ�.
 *    �ڼ�Ŭ������ �θ�� �Ѱ��� �����ϴ�.
 *  4.��� Ŭ������ Object Ŭ������ ��ӹ޴´�. = ��� Ŭ������ object��ü�� �ִ�.
 *  	��� ��ü�� Object Ŭ������ ��ü�� �����Ѵ�.
 *  	��� ��ü�� Object Ŭ������ ����� ������ �����ϴ�.
*/
class Phone extends Object { //extends Object �����Ǿ����� ��� �θ�ü�� object��ü ����.
	boolean power;
	int number;
	void power() {
		power = !power;
	}
	void send() {
		if(power)
		System.out.println("��ȭ�ɱ�");
	}	
	void receiver() {
		if(power)
		System.out.println("��ȭ�ޱ�");
	}
}
class SmartPhone extends Phone{ //��ӹ��� ,phone ��ü �����ϰ�����
	void setApp(String name) {
		if(power)
			System.out.println(name + "��ġ��~~");
	}
}
public class PhoneEx1 {
	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone();
		sp.power = true;
		sp.send();
		sp.receiver();
		sp.setApp("���̹�");
		
	}
}


