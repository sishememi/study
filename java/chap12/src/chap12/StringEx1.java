package chap12;
/*
 * String Ŭ���� ����
 * 1. String Ŭ������ ���Ŭ���� �� �����ϰ� ���Կ����ڷ� ��ü ������ ������. + ������ ����� ������.
 * �ٸ� Ŭ������ ��ü�� new Ŭ������() ���·� ��ü������ ��
 * 2. final Ŭ������.
 * 3. + �������� �⺻���� String ������ ����ȯ ����
 */
public class StringEx1 {
	public static void main(String[] args) {
		String s1 = "abc"; //���Կ����ڷ� ��ü ����
		String s2 = "abc";
		String s3 = new String("abc"); //new �����ڷ� ��ü ����
		String s4 = new String("abc");
		if(s1==s2)
			System.out.println("s1==s2 : ���� ��ü");
		else
			System.out.println("s1!=s2 : �ٸ� ��ü");
		if(s1.equals(s2))
			System.out.println("s1.equals(s2) : ���� ����");
		else
			System.out.println("!s1.equals(s2) : �ٸ� ����");
		if(s3==s4)
			System.out.println("s3==s4 : ���� ��ü");
		else
			System.out.println("s3!=s4 : �ٸ� ��ü");
		if(s2.equals(s3))
			System.out.println("s3.equals(s4) : ���� ����");
		else
			System.out.println("!s3.equals(s4) : �ٸ� ����");
	}

}
