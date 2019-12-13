package chap18;

import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;

/*
 * Operator �������̽� ����: apply �迭 �߻� �޼��� ����
 * 	�Ű����� �ְ�, ���ϰ��� ����, => �� �Ű������� �ڷ�����  ���ϰ��� �ڷ����� ����.
 * 	Function �������̽��� ���� �������̽���.
 */
public class LambadaEx9 {
	private static Student[] List= {
			new Student("ȫ�浿",90,80,"�濵"),
			new Student("���",95,70,"�İ�"),
			new Student("�̸���",100,70,"����")
			
	};
	public static void main(String[] args) {
		System.out.print("�ִ� ���а�:");
		int max = maxOrMinMax((a,b)->{ //�ִ밪 ���� �κ�
			if(a>=b) return a;
			else return b;
		});
		System.out.println(max);
		System.out.print("�ּ� ���а�:");
		System.out.println(maxOrMinMax((a,b)->(a<=b)?a:b)); //������ �����ϵ���.
		System.out.print("�ִ� ��հ�:");
		System.out.println(maxOrMinMaxAvg((a,b)->(a<=b)?a:b)); 
		System.out.print("�ּ� ��հ�:");
		System.out.println(maxOrMinMaxAvg((a,b)->(a<=b)?a:b));
	}
	private static String  maxOrMinMaxAvg(DoubleBinaryOperator op) {
		double result = List[0].getEng() + List[0].getMath()/2.0;
		for(Student s : List) {
			result= op.applyAsDouble(result, (s.getMath()+s.getEng())/2.0);
		}
		return String.format("%.3f", result);
	}
	private static int maxOrMinMax(IntBinaryOperator op) {//op => �ΰ��� ū�� �������� �ڵ���
		int result = List[0].getMath();
		for(Student s: List) {
			result = op.applyAsInt(result, s.getMath());
		}
		return result;
	}
}
