package chep4;
/*
 * ���� ������:
 * */
public class OpEx9 {

	public static void main(String[] args) {
		int num = 100;
		System.out.println(num);
		num += 10; //num=num+10; �ǹ̴� ������ �ý��������δ� �ٸ� ���ִ�.
		System.out.println(num);
		num /= 10;//num=num/10
		System.out.println(num);
		num *= 2+3;//num=num*(2+3);
		System.out.println(num);

		byte b = 1;
		b *= 2;//�ڷ���ü��....
		b=(byte) (b*2);//b=b*2
		System.out.println(b);//2
		b *= 2;
		System.out.println(b);//4
		b *= 2;
		System.out.println(b);//8
	}

}
