package chap5;
/*
 *
 * Switch ������ ���Ǵ� �ڷ���
 * 		=> byte,short,int,char,String (O)
 * Switch ������ ������ �ʴ� �ڷ���
 * 	 	=> boolean,long,float,double (X)
 * 
 * ���ǹ�: if, switch
 * 	 ���  switch������  if������ ���� ������.
 * 	 ���  if������ switch������ ������ �� ����. ���� �����Ѱ͵� �ְ� ���� �Ұ����� �͵� �ִ�.
 */
 
public class SwitchEx2 {

	public static void main(String[] args) {
		int value =1; //String value=1+"";
		switch(value) {
		//���� ���� �ȵ�.
		case 1:System.out.println(value);break;
		case 2:System.out.println(value);break;
		default:System.out.println(value);break;
		}

	}

}
