package chap15;
/*
 * printf �޼���: ������������.
 */
public class PrintStreamEx2 {
	public static void main(String[] args) {
		//char ������������: %c %n=\n
		System.out.printf("%c%n",'A');//'A'���� ���
		System.out.printf("%5c%n",'A');//5�ڸ� Ȯ��     'A'���� �������� ���
		System.out.printf("%-5c%n",'A');//5�ڸ� Ȯ��   'A'���� �������� ���
		//���� ��� : %d,%o,%x,%X
		System.out.printf("%d%n",12345);//10�������
		System.out.printf("%,d%n",12345);//���ڸ� , 10�������
		System.out.printf("%10d%n",12345);//10�ڸ� Ȯ�� �� 10�������
		System.out.printf("%010d%n",12345);//10�ڸ� Ȯ�� �� ���ڸ� 0 ���� ä�� 10�������
		System.out.printf("%3d%n",12345);//�ּ�3�ڸ� Ȯ�� ,12345�� 3�ڸ��� ��������� �ʱ⶧���� ���� ���10�������
		System.out.printf("%-10d%n",12345);//10�ڸ� Ȯ�� ���� ���� 10�������
		System.out.printf("%,10d%n",12345);//10�ڸ� Ȯ�� ���ڸ�  , �� ��������10�������
		System.out.printf("%-,10d%n",12345);//10�ڸ� Ȯ�� ���ڸ�  , ��  ��������10�������
		System.out.printf("%,010d%n",12345);//10�ڸ� Ȯ�� ���ڸ� , ���ڸ� 0���� ä�� 10�������
		System.out.printf("%o%n",12345);//8�������
		System.out.printf("%x%n",255);//a-f �ҹ��� ǥ�� 16�������
		System.out.printf("%X%n",255);//A-F �빮��  ǥ�� 16�������
		//�Ǽ� ��� : %f , %e, %g
		System.out.printf("%f%n",12345.12345); //�Ǽ����
		System.out.printf("%.2f%n",12345.12345);//�Ҽ������� 2�ڸ����� �Ǽ� ���
		System.out.printf("%10.2f%n",12345.12345);//10�ڸ� Ȯ�� �Ҽ������� 2�ڸ����� �Ǽ� ���
		System.out.printf("%,10.2f%n",12345.12345);//10�ڸ� Ȯ�� ���ڸ� , �Ҽ��� ���� 2�ڸ����� �Ǽ� ���
		System.out.printf("%-,10.2f%n",12345.12345);//10�ڸ� Ȯ�� ���ڸ� , �Ҽ��� ���� 2�ڸ����� �Ǽ� ���� ���� ���
		System.out.printf("%,010.2f%n",12345.12345);///10�ڸ� Ȯ�� ���ڸ� , �Ҽ��� ���� 2�ڸ����� ���ڸ� 0���� ä�� �Ǽ� ���
		System.out.printf("%e%n",12345.12345);//����ǥ�� ��� 1.234512e+04 = 1.234512 * 10��  4��
		System.out.printf("%g%n",12345.12345);//�ٻ� �Ǽ�
		
		//���� : %b
		System.out.printf("%b != %b%n",true,false);
		System.out.printf("(2 > 3)= %b%n",(2>3));
		
		//���ڿ� : %s
		System.out.printf("%s�� %s�̴�\n","ȫ�浿","����");
		System.out.printf("%10s�� %10s�̴�\n","ȫ�浿","����");//10�ڸ� Ȯ��
		
		//����  : 10���� 255�� 8���� 377�̰�, 16���� FF��. ����ϱ�
		System.out.printf("10���� %d�� 8���� %o, �̰� 16���� %X��.",255,255,255);
	}
}
