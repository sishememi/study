package chap8;
/*
 * ����������
 * */
public class BikeEx2 {
	public static void main(String[] args) {
		AutoBike auto1 = new AutoBike(2); //��ü1
		AutoBike auto2;
		Bike bike;
		auto1.power();
		System.out.println(auto1.drive());
		System.out.println("����"+auto1.wheel+"���� ��������.");
		System.out.println(auto1.stop());
		bike = auto1;
	//	bike.power();
		System.out.println(bike.drive());
		auto2 = (AutoBike)bike;
		auto2.power();
		System.out.println(auto2.drive());
		System.out.println(auto2.stop());
		auto2.stop();

	}
}
