package chap7;
/*
 * static ������ �̿��Ͽ� �ڵ��� �ø��� ��ȣ �����ϱ�.
 * */

class Sonata2{
	String color;
	int number;
	int serialNo;
	static int sno; //Ŭ�������� �⺻�� =0(�ʱ�ȭ)
	static int width = 250;//Ŭ�������� 
	static int height = 150;//Ŭ�������� 
	public String toString() {
		return "�ڵ���������ȣ:"+serialNo+","+color+":"+number
				+"("+width+","+height+" :�ڵ��� �����ȣ="+sno+")";
	}
	
}

public class SonataEx2 {
	public static void main(String[] args) {
		Sonata2 car1= new Sonata2(); //��ü1
		car1.color="white";
		car1.number=1234;
		car1.serialNo= ++Sonata2.sno; //sno ���� 2�γ��� car2�� sno �ø����ȣ�� 2������ ���Ӿ��ֱ⶧��  
	//  System.out.println(car1); ���⿡ ���� ���ָ� �ڵ��������ȣ 1������
		Sonata2 car2 = new Sonata2(); //��ü2		
		car2.color="black";
		car2.number=5678;
		car2.serialNo= ++Sonata2.sno;
		System.out.println(car1); //�ڵ��� �����ȣ2
		System.out.println(car2);//�ڵ��� �����ȣ2
		Sonata2 car3 = new Sonata2();//��ü3
		car3.color="red";
		car3.number=4321;
		car3.serialNo= ++Sonata2.sno;
		System.out.println(car3);
		Sonata2 car4 = car3; //��üX ��ü�� ����= new Sonata2();�� ��
		System.out.println(car4); //car3�� ���� ����
	}

}
