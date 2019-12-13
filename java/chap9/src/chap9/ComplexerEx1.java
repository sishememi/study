package chap9;
/*
 * �������̽�
 * 1. �������̽��� ����� ���,�߻�޼���,default�޼��� ,static �޼��常 ����
 * 		public static final �ڷ��� ���
 * 		public abstract �ڷ��� �޼����();
 * 		public default �ڷ��� �޼����() {} => jdk 8.0 ���Ŀ����� ����
 * 		public static �ڷ��� �޼����() {} => jdk 8.0 ���Ŀ����� ����
 * 2.�������̽� ����� ���� �����ڴ� public
 * 3.��üȭ �Ұ�. => ����Ŭ������ ��üȭ�� �ȴ�.
 * 4.Ŭ������ �������̽����� �������� ǥ���Ѵ�.
 *   	=> ���� ������ ������.
 * 5.�������̽����� ����� ���� ����� �����ϴ�.
 * 
 * */
interface Printerable{
	//public static final ������ ����.
	int INK = 100; //���
	//public abstract ������ ����
	void print();
}
interface Scannerable{
	void scan();
}
interface Faxable{
	String FAX_NO="010-12345";
	void send(String tel);
	void receive(String tel);
}
//�������̽����� ����� ���� ����� ������.
interface Complexerable extends Printerable,Scannerable,Faxable{}
//Ŭ������ �������̽��� ���� ������.
//Ŭ������ �������̽��� ���� ������ ������.
//�������̽��� ������ Ŭ������ ����Ŭ������ �Ѵ�.
class Complexer implements Complexerable { //Complexer���� Ŭ����
	int ink; 
	Complexer(){
		this.ink=INK;
	}
	@Override
	public void print() { //������ �ۺ�, ���������ڴ� �������̵� �Ҷ� ��������������..?
		System.out.println("���̿� ����մϴ�. ���� ��ũ��:" + --ink);
		
	}
	@Override
	public void scan() {
		System.out.println("�̹����� ��ĵ�մϴ�.");
		
	}
	@Override
	public void send(String tel) {
		System.out.println(FAX_NO+"���� "+tel+"��ȣ�� FAX�� ����");
		
	}
	@Override
	public void receive(String tel) {
		System.out.println(tel+"���� "+FAX_NO+"�� FAX�� ����");
	}
}

public class ComplexerEx1 {
	public static void main(String [] args) {
		Complexer com = new Complexer();
		System.out.println("�⺻ ��ũ��:" +Printerable.INK);
		System.out.println("FAX ��ȣ:"+Complexerable.FAX_NO);
		com.print();
		com.scan();
		com.receive("02-5678");
		com.send("02-5678");
		if(com instanceof Complexer) {
			System.out.println("com ���������� ��ü�� Complexer ��ü��");
		}
		if(com instanceof Complexerable) {
			System.out.println("com ���������� ��ü�� Complexer ��ü��");
			Complexerable ca = com; //����ȯ ������ ���� ����
			ca.print();
			ca.scan();
			ca.receive("02-1234");
			ca.send("02-1234");
		}
		if(com instanceof Printerable) {
			Printerable pa = com;
			pa.print();
			System.out.println(pa.INK);
		}
		if(com instanceof Scannerable) {
			Scannerable sa = com;
			sa.scan();
			
		}
		if(com instanceof Faxable) {
			Faxable fa = com;
			System.out.println(fa.FAX_NO);
			fa.send("02-3456");
			fa.receive("02-3456");
		}
	}
}
