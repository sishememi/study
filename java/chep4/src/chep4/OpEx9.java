package chep4;
/*
 * 대입 연산자:
 * */
public class OpEx9 {

	public static void main(String[] args) {
		int num = 100;
		System.out.println(num);
		num += 10; //num=num+10; 의미는 같지만 시스템적으로는 다를 수있다.
		System.out.println(num);
		num /= 10;//num=num/10
		System.out.println(num);
		num *= 2+3;//num=num*(2+3);
		System.out.println(num);

		byte b = 1;
		b *= 2;//자료자체에....
		b=(byte) (b*2);//b=b*2
		System.out.println(b);//2
		b *= 2;
		System.out.println(b);//4
		b *= 2;
		System.out.println(b);//8
	}

}
