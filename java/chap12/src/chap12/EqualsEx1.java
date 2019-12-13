package chap12;
/*
 * Object Ŭ����
 * equals �޼��� ���� : ����񱳽� ���Ǵ� �޼���  => �������̵� �ʿ�
 * 
 * =>���� ��ü���� ���δ� == �� ������ ������.
 * =>���� �������� ���δ� equals �޼��带 �������̵�
 * 
 */
class Equal{
	int value;
	Equal(int value){
		this.value = value;
	}
}
public class EqualsEx1 {
	public static void main(String[] args) {
		 Equal e1 = new Equal(10);
		 Equal e2 = new Equal(10);
		 if(e1==e2) {
			 System.out.println("e1 �� e2�� ���� ��ü��");
		 }else {
			 System.out.println("e1 �� e2�� �ٸ� ��ü��");
		 }
		 if(e1.equals(e2)) {
			 System.out.println("e1�� e2�� ���� ������ ��ü��");
		 }else {
			 System.out.println("e1 �� e2�� �ٸ� ������ ��ü��");
		 }
		 String s1 = new String("abc");
		 String s2 = new String("abc");
		 
		 if(s1==s2) {
			 System.out.println("s1 ��s2�� ���� ��ü��");
		 }else {
			 System.out.println("s1 �� s2�� �ٸ� ��ü��");
		 }
		 if(s1.equals(s2)) {//����κ� ��
			 System.out.println("s1�� s2�� ���� ������ ��ü��");
		 }else {
			 System.out.println("s1 �� s2�� �ٸ� ������ ��ü��");
		 }
	}

}
