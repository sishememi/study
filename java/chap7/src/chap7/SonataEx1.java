package chap7;
/*
 * ���� ��ġ�� ���� ������ ����
 * Ŭ���� ����: Ŭ���� ���ο� ����.
 * 			static ������ ������
 *			Ŭ���� ������ �޸𸮿� �ε�ɶ� �����޸� �Ҵ�.	
 *			��üȭ�� ���þ��� ������
 *			�޸��Ҵ� ��ġ: Ŭ���� ����.
 *			ū Ư¡: Ŭ������ ��� ��ü�� ���� ������ ����.
 *			���: Ŭ������.������
 * 
 * �ν��Ͻ� ����: Ŭ���� ���ο� �����
 * 			   �ڷ��� ������; �����.
 * 			   ��üȭ�� �޸� �Ҵ� 
 * 			   �ݵ�� ��üȭ �Ǿ�� ������ ����� �� ����
 * 			   �޸� �Ҵ� ��ġ: ������
 * 			   ���: ����������.������
 * 
 * �������� : �޼��� ���ο��� �����. ?�� ��������?���� ����ÿ�������.�޼��� ����� ������ �Բ� ����
 * 	(�Ű���������) �ʱ�ȭ�Ǿ����.
 * 			  ���������� ����ɶ� �޸� �Ҵ�.
 * 			  �޸� �Ҵ� : ���ÿ��� 
 * 			  ���: ������
 *  * */
class Sonata{
	String color; //�ν��Ͻ�����
	int number;  //�ν��Ͻ�����
	static int width = 250; //Ŭ���� ����
	static int height = 150;//Ŭ���� ����
	public String toString()//�۷� �ڵ�ȣ�� 
	{
		return color + ":" + number + "(" + width + "," + height +")";
	}
}
public class SonataEx1 {
	public static void main(String[] args) {
			System.out.println("�ڵ���ũ��:"+ Sonata.width + ","+Sonata.height);
			 //car1 ��������, �ʱ�ȭ �� rorcp aksefmdjwla..
			Sonata car1 = new Sonata();
			car1.color="White";//�������� �Ҵ� ,�ν��Ͻ����� , ��������.������
			car1.number=1234;//�������� �Ҵ�
			System.out.println("car1:"+car1); //println�� car1�� car1.toString() �޼��� ȣ��
			
			Sonata car2 = new Sonata();
			car2.color="black";
			car2.number=2345;
			System.out.println("car2:"+car2);
			
			car2.width=300;
			car1.height=200;
			System.out.println("car1:"+car1);
			System.out.println("car2:"+car2);
	}
}
