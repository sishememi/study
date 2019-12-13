package chap16;
/*
 * SumTread를 이용하여 1~1000까지의 합을 구하기 배열 사용하기
 * SumRunnable를 이용하여 1~1000까지의 합을 구하기 배열 사용하기
 */
public class Exam3 {
	public static void main(String[] args) throws InterruptedException {
//		//SumTread
//		int n1=1; int n2 =100; int sum=0;
//		SumTread [] st = new SumTread[10];
//		for(int i=0;i<st.length;i++) {
//			st[i]=new SumTread(n1,n2);
//			n1+=100; n2+=100;
//			st[i].start();
//			st[i].join();
//			sum+=st[i].sum;
//		}
//		System.out.println("1~1000까지의 합:"+sum);
//		
//		System.out.println();
//		//SumRunnable
//		n1=1; n2=100; sum=0;
//		SumRunnable [] sr = new SumRunnable[10];
//		for(int i=0;i<sr.length;i++) {
//			sr[i]=new SumRunnable(n1,n2);
//			Thread t = new Thread(sr[i]);
//			n1+=100; n2+=100;
//			t.start();
//			t.join();
//			sum+=sr[i].sum;
//		}
//		System.out.println("1~1000까지의 합:"+sum);
		
		//SumTread
		SumTread [] st = new SumTread[10]; //참조변수 10개 만드는 배열
		int sum=0;
		
		for(int i=0;i<st.length;i++) {
			st[i]=new SumTread(i * 100 + 1, ( i + 1 ) * 100); //객체화
			st[i].start(); //Thread 시작함
			//st[i].join(); 스레스 쓰는 이유가 없음 start하면 바로 main에 대기상태를 알리는 꼴  Tread= 병렬로 처리했기ㄸㅐ문에 순서가 뒤죽박죽으로 나옴.그게 정상임.
		}
		for(int i=0;i<st.length;i++) {
			st[i].join();//i가 i까지 끝날때까지 기다리고 
			sum += st[i].sum;//sum에 값들을 모두 더하고
		}
		System.out.println("1~1000까지의 합:"+sum); //1~1000까지 더한 sum을 출력
		
		System.out.println();
		
		
		//SumRunnable
		SumRunnable [] sr = new SumRunnable[10];
		Thread [] t = new Thread[10];
		int sum2 = 0;
		
		for(int i=0; i<t.length; i++) {
			sr[i] = new SumRunnable(i*100+1,(i+1)*100);
			t[i]=new Thread(sr[i]);
			t[i].start();
		}
		for(int i=0;i<t.length;i++) {
			t[i].join();
			sum+=sr[i].sum;
		}
		System.out.println("1~1000까지의 합:"+sum);
	}
}
