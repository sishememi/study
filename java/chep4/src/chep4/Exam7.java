package chep4;
import java.util.Scanner;
/*
 * ���� �����ڸ� �̿��ϱ�
 * ������ �Է¹޾Ƽ� 90�̻��̸� "A����" 80�̻��̸� "B����" 70�̻��̸� "C����" 60�̻��̸� "D����" �׿ܴ� "F����" ����ϱ�
 * */
public class Exam7 {

	public static void main(String[] args) {
		System.out.println("������ �Է��ϼ���:");
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();
		String a;
		if(score>=90) {
			a="A�����Դϴ�.";
		}else if(score>=80) {
			a="B�����Դϴ�.";
		}else if(score>=70) {
			a="C�����Դϴ�.";
		}else if(score>=60) {
			a="D�����Դϴ�.";
		}else  {
			a="F�����Դϴ�.";
		}
		System.out.println(a);
	}
	//= System.out.println(score+"������"+((score>=90)?:"a":(score>=80)?"b":(score>=70)?"C":(score>=60)?"d":"f")+"�����Դϴ�");

}
