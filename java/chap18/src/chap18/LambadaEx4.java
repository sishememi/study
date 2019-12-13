package chap18;
/*
 * 매개변수도 있고, 리턴값도 있는 경우
 */
interface LambdaInterface4{
	int method(int x, int y);
}
public class LambadaEx4 {
	public static void main(String[] args) {
		LambdaInterface4 f4= (x,y)->{
			return x*y;
		};
		System.out.println("두 수의 곱:"+f4.method(2, 5));//10
		f4 = (x,y) -> x+y;//동적으로 리턴값 변경.
		System.out.println("두 수의 합:"+f4.method(2, 5));//7
		f4 = (x,y) -> x/y;
		System.out.println("두 수의 몫:"+f4.method(5, 2));//2
		f4 = (x,y) -> x%y;
		System.out.println("두 수의 나머지:"+f4.method(5, 2));//1
		f4 = (x,y) -> sum(x,y);
		System.out.println("두 수의 합:"+f4.method(2, 5));//7
		
		//두 수 중 큰수 출력하기
		f4 = (x,y) ->x>y?x:y;
		System.out.println("두 수 중 큰수:"+f4.method(2, 5));
		//두 수 중 작은수 출력하기
		f4 = (x,y)->x<y?x:y;
		System.out.println("두 수 중 작은수:"+f4.method(2, 5));
	}

	static int sum(int x, int y) {
		
		return x+y;
	}
}
