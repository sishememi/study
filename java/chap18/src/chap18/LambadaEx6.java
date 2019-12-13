package chap18;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.ObjIntConsumer;

/*
 * Java API 함수적 인터페이스 예제: Consumer 인터페이스
 * 매개변수가 있고, 리턴값은 없는 경우
 */
public class LambadaEx6 {
	public static void main(String[] args) {
		Consumer<String> c1 = t-> System.out.println(t+8);
		c1.accept("java");
		BiConsumer<String,String> c2 =(t,u)-> System.out.println(t+u);//Bi => 매개변수 2개.
		c2.accept("java", "8.0이후");
		DoubleConsumer c3 = (d)->System.out.println("java"+d);
		c3.accept(8.0);
		ObjIntConsumer<String> c4 = (t,i)->System.out.println(t+i);
		c4.accept("java", 8);
		IntConsumer c5 = t->{
			int sum=0;
			for(int i=0;i<=t;i++) {
				sum+=i;
			}System.out.println(sum);
		};
		c5.accept(10);//10까지의 합 출력
	}
}
