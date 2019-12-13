package chap12;
/*
 * 
 */
public class StringEx3 {
	public static void main(String[] args) {
		String s = "HTML-CSS-JavaScript-Java-스프링";
		String[] subject = s.split("-"); //split 어떤 기준으로 나눌때 사용하는  메서드
		for(int i =0;i<subject.length;i++) {
			System.out.println((i+1)+":"+subject[i]);
		}
		s="홍길동,김삿갓,이몽룡,성춘향,임꺾정";
		String[] names = s.split(",");
		for(String n : names) {
			System.out.println(n);
		}
		System.out.println("전체 이름:"+names.length+"명");
		
		
		//숫자<=문자열 /문자열을 숫자로 변경하는 메서드
		int i = Integer.parseInt("100");
		System.out.println(i+1);//101
		double d = Double.parseDouble("100.5");
		System.out.println(d+0.1);//100.6
		System.out.println(++d);
		
		//문자열을 Format 형태로 출력하기
		String sf = String.format("%.2f", d+0.12345);//101.62345
		System.out.println(sf);
		sf = String.format("%10d",i); 
		System.out.println(sf);
		sf = String.format("16진수: %X",i); //X => 16진수로 나타나게 해줌.
		System.out.println(sf);
		sf = String.format("8진수: %o",i);
		System.out.println(sf);


	}

}
