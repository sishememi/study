package chap8;
/*
 * ´ÙÇü¼º¿¹Á¦
 * */
public class BikeEx2 {
	public static void main(String[] args) {
		AutoBike auto1 = new AutoBike(2); //°´Ã¼1
		AutoBike auto2;
		Bike bike;
		auto1.power();
		System.out.println(auto1.drive());
		System.out.println("¹ÙÄû"+auto1.wheel+"°³°¡ ±¼·¯°£´Ù.");
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
