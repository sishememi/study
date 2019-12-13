package chap8;
/*
 * 1.Animal Ŭ���� => �߻�Ŭ����
 * 	�������: ������ ����, �ٸ���
 * 	������: ������ ������ �ٸ��� �Է¹ޱ�.
 * 	����޼���:
 * 			void eat() => �߻�޼���
 * 			void sound() => �߻�޼���
 * 2.Dog Ŭ����: Animal Ŭ������ �ڼ�Ŭ����
 * 	�������� �Ű����� ����.
 * 	����޼���:
 * 		void eat(): "������ �ִ´�� �Դ´�" ���
 * 		void sound(): "�۸�";
 * 3.LionŬ����: Animal Ŭ������ �ڼ�Ŭ����
 * 	�������� �Ű����� ����.
 *  ����޼���:
 *  	void eat(): "�ʽĵ����� ��ƸԴ´�" ���
 *  	void sound():"����";
 * */
abstract class Animal {
	String type;
	int leg;
	
	Animal(String type,int leg){
		this.type=type;
		this.leg=leg;
	}
	
	abstract void eat();
	abstract void sound();
}
class Dog extends Animal{
	
	Dog(){
		super("��",4);
		
	}
	@Override
	void eat() {
		System.out.println("������ �ִ´�� �Դ´�");
	}
	@Override
	void sound() {
		System.out.println("�۸�");
	}
}

class Lion extends Animal{
	 Lion(){
		 super("����",4);
	 }

	@Override
	void eat() {
		System.out.println("�ʽĵ����� ��ƸԴ´�");
	}

	@Override
	void sound() {
		System.out.println("����");
	}
}
public class Exam4 {
	public static void main(String[] args) {
		Animal [] animal = new Animal[2];
		animal[0] = new Dog();
		animal[1] = new Lion();
		for(Animal a : animal) {
			System.out.print(a.type+ "=>");
			a.sound(); //[0]=dog���ִ� ���� �������̵� �� �޼��� ȣ��,AnimalŸ���� �߻�޼���
			a.eat(); //AnimalŸ���� �߻�޼���, ���� �������̵� �� �޼��尡 ȣ��ȴ�.
		}
		
	}
}
