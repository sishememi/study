package chap12;

/*
 * Object Ŭ����
 * equals �޼��� ���� 
 * Equal2 Ŭ������ equals �޼��� �������̵��ϱ�
 */
class Equal2{
	int value;
	Equal2(int value){	
		this.value = value;	
	}
	@Override
	   public boolean equals(Object o){ //e1��e2�� ��������ִ� �κ�.
	      if(o instanceof Equal2) {//o�� Equal2�� �ٸ���ü?
	         Equal2 e = (Equal2)o;
	         return value == e.value;
	      }else return false;
	   }
}
public class EqualsEx2 {
	public static void main(String[] args) {
		Equal2 e1 = new Equal2(10);
		 Equal2 e2 = new Equal2(10);
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
		 System.out.println("e1.hashCode()="+e1.hashCode());
		 System.out.println("e2.hashCode()="+e2.hashCode());

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
		 System.out.println("e1.hashCode()="+e1.hashCode());
		 System.out.println("e2.hashCode()="+e2.hashCode());
		 System.out.println("s1.hashCode()="+s1.hashCode());
		 System.out.println("s2.hashCode()="+s2.hashCode());
	}

}
