package chap12;

public class WrapperEx1 {
	public static void main(String[] args) {
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		System.out.println("i1==i2:" +(i1==i2));
		System.out.println("i1.equals(i2):"+i1.equals(i2));
		System.out.println("i1==100:"+(i1==100));
		int i3 = 100;
		System.out.println("i1==i3:"+(i1==i3));//i1�� ������ ����..
		Integer i4 = 100;
		System.out.println("i1==i4:"+(i1==i4));
		System.out.println("int ���� �ִ밪: "+Integer.MAX_VALUE);
		System.out.println("long ���� �ִ밪: "+Long.MAX_VALUE);
		System.out.println("int ���� �ּҰ�: "+Integer.MIN_VALUE);
		System.out.println("long ���� �ּҰ�: "+Long.MIN_VALUE);
		System.out.println("byte�� bit ��:"+Byte.SIZE);
		System.out.println("byte�� byte ��:"+Byte.BYTES);
	}
}
