package chep3;
/*����ȯ ����
 * 	ū�ڷ��� <= �����ڷ���: �ڵ�����ȯ
 * 	�����ڷ��� <= ū�ڷ���: ���������ȯ
 *  byte < short < int < long(8) < float(4) < double
 *  	   char = ������
 *  A=B : ���� �� �ǹ̰� �ƴϰ�, ������ �ǹ���. B�� ���� A�� �Է�.
 *  A = lvalue : ���Կ������� ���� ��. �ݵ�� ����������.
 *  B = rvalue : ���Կ������� ������ ��. ����,���ͳ�,���� ����
 */

public class VarEx2 {

	public static void main(String[] args) {
		//1. �������� �⺻���� ����ȯ �Ұ�
		String s = "a"; //" ":���ڿ�,string(������) ' ': ����,char(�⺻��),�������� �Ѱ��� ���ڸ� ����.����ȴ� 'ab' => X
		//s='a';// �������� string �⺻����  char���� ��ȯ �Ұ�.
		
		//2.�⺻�� ���̿� boolean�� ������ 7���� ���� ����ȯ�� �����ϴ�.
		byte b1 = 100;
		int i1 = (int)b1; // int <= byte ����ȯ��. �ڵ�����ȯ
		byte b2 = (byte)i1;// byte <= byte ����ȯ��. ���������ȯ
		System.out.println("b1="+b1+", i1="+i1);
		
		byte b3 = (byte)256;
		System.out.println("b3="+b3);
		
		long l1 = 10;
		float f1 = l1;
		long l2 = (long)f1;
		System.out.println("l2"+l2);
		
		char c1 = 'A';
		short s1 = (short)c1;
		char c2 = (char)b1;
		System.out.println("c2"+c2);

		
		// ū�ڷ��� = ū�ڷ��� + �����ڷ���
		 // int i2 = (int)l1 + i1; �̰͵� ����
		int i2 = (int)(i1 + l1);
		// String = String + �⺻�ڷ���
		System.out.println("��ȣ:"+ 1 + 2 + 3); //��� = ��ȣ:123  ��ȣ:+1=��ȣ1,  ��ȣ1+2= ��ȣ12 ,��ȣ12+3=��ȣ123 => ��ȣ6 �����Ϸ���  (1+2+3)���� �켱���� ǥ��
		System.out.println(1 + 2 + 3+"��");  //��� = 6��   1+2=3, 3+3=6, 6+��=6��
		
		char c3 = 'A'; //�ƽ�Ű �ڵ尪 65 ������
	    int i3 = c3; //������ c3�� ���ڷ��ν��ؼ� �ƽ�Ű�ڵ� ���
	    System.out.println("c3="+c3+",i3="+i3); //c3=A,i3=65
	    System.out.println("c3="+c3+",i3="+(char)i3); //c3=A,i3=A
	    
	    //int���� ���� �ڷ����� ������ ����� int
	     byte b4;
	     byte b5=1;
	     byte b6=2;
	     b4 = (byte)(b5+b6);
	     
	     //or
	     
	     /*int b4;
	     byte b5=1;
	     byte b6=2;
	     b4 = (byte)(b5+b6);*/
	     	
	    //3.�߸��� ������ ���ļ� ������ �߻����� �ʵ��� �����Ͻÿ�.
	     byte var1= 127;
	     short var2=128;
	     int var3=128;
	     long var4 =128L;
	     var4=var1;
	     var1=(byte)var3;
	     float var5= 1.0f;
	     double var6= 1.0;
	     var5=(float)var6;
	     var6=var5;
	     
	     			
	} 
}
