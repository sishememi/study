package chap12;

public class WrapperEx1 {
	public static void main(String[] args) {
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		System.out.println("i1==i2:" +(i1==i2));
		System.out.println("i1.equals(i2):"+i1.equals(i2));
		System.out.println("i1==100:"+(i1==100));
		int i3 = 100;
		System.out.println("i1==i3:"+(i1==i3));//i1은 정수와 같다..
		Integer i4 = 100;
		System.out.println("i1==i4:"+(i1==i4));
		System.out.println("int 형의 최대값: "+Integer.MAX_VALUE);
		System.out.println("long 형의 최대값: "+Long.MAX_VALUE);
		System.out.println("int 형의 최소값: "+Integer.MIN_VALUE);
		System.out.println("long 형의 최소값: "+Long.MIN_VALUE);
		System.out.println("byte의 bit 수:"+Byte.SIZE);
		System.out.println("byte의 byte 수:"+Byte.BYTES);
	}
}
