package chap18;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/*
 * Supplier 인터페이스 예제
 * 매개변수는 없고, 리턴값은 존재
 */
public class LambdaEx7 {
	public static void main(String[] args) {
		Supplier<String> s1 = () ->{
			return "java";
		};
		System.out.println(s1.get());
		
//		IntSupplier s2 = () -> {
//			int num=(int)(Math.random()*6)+1;
//			return num;
//		};
		IntSupplier s2 = () -> (int)(Math.random()*6)+1;
		System.out.println("주사위:"+s2.getAsInt());
//		DoubleSupplier s3 = () -> {
//			double d = Math.random();
//			return d;
//		};
		DoubleSupplier s3 = ()->Math.random();
		System.out.println("주사위:"+s3.getAsDouble());
	}
}
