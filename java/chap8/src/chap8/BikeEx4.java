package chap8;
/*
 * 
 * */
class Bike4{
	int wheel;
	int price = 10;
	
	Bike4(int wheel){
		this.wheel = wheel;
	}
	void drive() {
		System.out.println(price+"����¥�� �������� ����� ��´�.");
	}
	void stop() {
		System.out.println(price+"����¥�� �������� �극��ũ�� ��´�.");
	}
}

class AutoBike4 extends Bike4{
	boolean power; //�⺻�� false�� ����
	int price = 200;
	AutoBike4(int wheel){
		super(wheel);
	}
	void power() {
		power =  !power;
		if(power) System.out.println("������ �������ϴ�.");
		else System.out.println("������ �������ϴ�.");
	}
	@Override
	void drive() {
		if(!power) power();
		System.out.println(this.price+"����¥�� �������� ��� ��ư�� ������."); //this.price = 200 ����
		System.out.println(super.price+"����¥�� �������� ��� ��ư�� ������.");//super.price = 10 ����
	}
	@Override
	void stop() {
		if(power) System.out.println(price+"����¥�� �������� ���� ��ư�� ������.");
		else System.out.println("������ �������ϴ�. ����� �����ϴ�.");
	}
	
}
public class BikeEx4 {
	public static void main(String[] args) {
		AutoBike4 auto = new AutoBike4(2);
		
		//auto.price: AutoBike4 Ŭ������  price ���� ���
		System.out.println("������ "+auto.price+"�����Դϴ�.");  
		auto.power();
		auto.drive();
		auto.stop();
		Bike4 bike = auto;  
		//bike.price  : Bike4 Ŭ������ price ���� ��µ�.
		System.out.println("������ "+bike.price+"�����Դϴ�."); 
		//AutoBike4 Ŭ���� drive �޼���  ȣ��
		//drive ������ ���� ��������� �޼��带 ������.
		bike.drive(); 
		bike.stop();
	}
}
