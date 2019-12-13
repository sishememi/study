package chap18;

import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;

/*
 * Operator 인터페이스 예제: apply 계열 추상 메서드 소유
 * 	매개변수 있고, 리턴값도 존재, => 단 매개변수의 자료형과  리턴값의 자료형이 같다.
 * 	Function 인터페이스의 하위 인터페이스임.
 */
public class LambadaEx9 {
	private static Student[] List= {
			new Student("홍길동",90,80,"경영"),
			new Student("김삿갓",95,70,"컴공"),
			new Student("이몽룡",100,70,"수학")
			
	};
	public static void main(String[] args) {
		System.out.print("최대 수학값:");
		int max = maxOrMinMax((a,b)->{ //최대값 전달 부분
			if(a>=b) return a;
			else return b;
		});
		System.out.println(max);
		System.out.print("최소 수학값:");
		System.out.println(maxOrMinMax((a,b)->(a<=b)?a:b)); //작은값 전달하도록.
		System.out.print("최대 평균값:");
		System.out.println(maxOrMinMaxAvg((a,b)->(a<=b)?a:b)); 
		System.out.print("최소 평균값:");
		System.out.println(maxOrMinMaxAvg((a,b)->(a<=b)?a:b));
	}
	private static String  maxOrMinMaxAvg(DoubleBinaryOperator op) {
		double result = List[0].getEng() + List[0].getMath()/2.0;
		for(Student s : List) {
			result= op.applyAsDouble(result, (s.getMath()+s.getEng())/2.0);
		}
		return String.format("%.3f", result);
	}
	private static int maxOrMinMax(IntBinaryOperator op) {//op => 두개중 큰값 보내도록 코딩됨
		int result = List[0].getMath();
		for(Student s: List) {
			result = op.applyAsInt(result, s.getMath());
		}
		return result;
	}
}
