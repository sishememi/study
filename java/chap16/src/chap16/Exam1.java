package chap16;
/*
 * 1���� 500������ ���� ���ϱ� : Thread ��ӹ޴� ������� �����ϱ�
 * t1 : 1~100������ ��
 * t2 : 101~200������ ��
 * t3 : 201~300������ ��
 * t4 : 301~400������ ��
 * t5 : 401~500������ ��
 */
class SumTread extends Thread{
	int n1, n2;
	int sum=0;
	SumTread(int n1,int n2){
		//super();
		this.n1=n1;
		this.n2=n2;
	}
	@Override 
	public void run() {
		for(int i=n1; i<=n2; i++) {
			sum+=i;
		}
		System.out.printf("%d���� %d������ ��:%d%n",n1,n2,sum);
	}
}
public class Exam1 {
	public static void main(String[] args) throws InterruptedException {
		SumTread t1 = new SumTread(1,100);
		SumTread t2 = new SumTread(101,200);
		SumTread t3 = new SumTread(201,300);
		SumTread t4 = new SumTread(301,400);
		SumTread t5 = new SumTread(401,500);
		t1.start();t2.start();
		t3.start();t4.start();
		t5.start();
		/*
		 * main �������� ������ �ٸ� ����
		 */
		t1.join();//t1 �����尡 ������ ������ main�����尡 ���
		t2.join();t3.join();t4.join();t5.join();
		System.out.println("1~500������ ��:"+(t1.sum+t2.sum+t3.sum+t4.sum+t5.sum));//401~500������ ��

	}
}
