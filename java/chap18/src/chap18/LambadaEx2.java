package chap18;
/*
 * Runnable 인터페이스를 이용하여 람다식으로 스레드 생성하기
 */
public class LambadaEx2 {
	public static void main(String[] args) {
		System.out.println("main 시작");
		Runnable r = () -> {
			int sum=0;
			for(int i=0;i<=100;i++) {
				sum+=i;
			}
			System.out.println("1부터 100까지의 합1:"+sum);
		};
		Thread t = new Thread(r);
		Thread t2 = new Thread(() -> { //Runnable 표시되있지않지만 Runnable인걸 인삭함.
			int sum=0;
			for(int i=0;i<=100;i++) {
				sum+=i;
			}
			System.out.println("1부터 100까지의 합2:"+sum);
		});
		t.start();
		t2.start();
		System.out.println("main 종료");
	}
}
