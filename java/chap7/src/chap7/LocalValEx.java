package chap7;
/*
 * ��������: �޼��� ���ο��� ����� ����.
 * 		      �ݵ�� �ʱ�ȭ �Ǿ���Ѵ٤�.
 * 		      �Ű������� ����������
 * */
public class LocalValEx {
	public static void main(String[] args) {
		//args ��������
		int num;//��������
		boolean b=true;//��������. main�޼� ���ο� ����Ǿ��⶧��
		if(b)
		{
			num=100;
		}else
		{
			num=200;
		}
		System.out.println(num);
		String grade; //�ʱ�ȭ������������
		int score=80;//��������
		switch(score/10) {
		case 9: grade ="A";break;
		case 8: grade ="B";break;
		case 7: grade ="C";break;
		case 6: grade ="D";break;
		default : grade = "F";
		}
		System.out.println("����:"+grade); //default : grade = "F"; �� ������ grade���� �ʱ�ȭ�� ��. 
											//������ default�� ������ �ʱ�ȭ�� �ȵ� ���ɼ����ִ»���.
	}
}
