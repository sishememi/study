package chap11;

import java.text.NumberFormat;

/*
 * ���� catch ��������
 */
public class ExeptionEx2 {

	public static void main(String[] args) {
		try {
			//ArithmeticExeption ���� �߻�
			System.out.println(args[0]); //ȫ�浿
			//NumberFormatExeption ���ܹ߻�
			System.out.println(Integer.parseInt(args[0]));
			System.out.println(10/Integer.parseInt(args[0]));
			String str = null;
			System.out.println(str.charAt(0));//NullPointerException, charAt ���� ������������ �����ΰ� �� �� �ִ�.
		}catch(ArithmeticException e){
			System.out.println("0���� ������ ������.");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("command ���ο� �Ķ���͸� �Է��ϼ���.");
		}catch(NumberFormatException e) {
			System.out.println("command ���ο� ���ڸ� �Է��ϼ���");
		}catch(NullPointerException e) {
			System.out.println("null");
		}catch(RuntimeException e) {
			System.out.println("1.�����߻�: ����η� ��ȭ���");
			e.printStackTrace();//�����߻��� �������������� ȭ�鿡 ���.
		}catch(Exception e) {
			System.out.println("2.�����߻�: ����η� ��ȭ���");
		}
		
	}
}







