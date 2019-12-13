package chap16;
/*
 * SumTread�� �̿��Ͽ� 1~1000������ ���� ���ϱ� �迭 ����ϱ�
 * SumRunnable�� �̿��Ͽ� 1~1000������ ���� ���ϱ� �迭 ����ϱ�
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
//		System.out.println("1~1000������ ��:"+sum);
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
//		System.out.println("1~1000������ ��:"+sum);
		
		//SumTread
		SumTread [] st = new SumTread[10]; //�������� 10�� ����� �迭
		int sum=0;
		
		for(int i=0;i<st.length;i++) {
			st[i]=new SumTread(i * 100 + 1, ( i + 1 ) * 100); //��üȭ
			st[i].start(); //Thread ������
			//st[i].join(); ������ ���� ������ ���� start�ϸ� �ٷ� main�� �����¸� �˸��� ��  Tread= ���ķ� ó���߱⤨������ ������ ���׹������� ����.�װ� ������.
		}
		for(int i=0;i<st.length;i++) {
			st[i].join();//i�� i���� ���������� ��ٸ��� 
			sum += st[i].sum;//sum�� ������ ��� ���ϰ�
		}
		System.out.println("1~1000������ ��:"+sum); //1~1000���� ���� sum�� ���
		
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
		System.out.println("1~1000������ ��:"+sum);
	}
}
