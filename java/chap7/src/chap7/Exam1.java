package chap7;
/*
 * ����(width),����(height)�� ������ �������ִ�
 * ���簢��(Rectangle) Ŭ���� �����
 * ��� �޼���δ� ���̸� ���ϴ�area(), �ѷ��� ���ϴ�lenght()�� ������.
 * 
 * */
class Rectangle {  //public ���餷����
	int width;
	int height;
	
	void area() {
		System.out.println("����:"+width*height);
	}
	
	void length() {
		System.out.println("�ѷ�:"+(width*2+height*2));
	}
	
}
/*
 * Exam1 : ����Ŭ����, main �޼��带 ����� ������ �ִ� Ŭ����.
 * 		   public Ŭ���� ������.
 * 
 * ������ �̸��� �ݵ��  public Ŭ������ �̸��� �����ؾ� ��.
 * �ϳ��� ���Ͽ� �ΰ��� public Ŭ������ �Ұ�����.
 * */
public class Exam1 { //public ����� ����
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(); //width,height area,length�� ���� Ŭ���� ����.
	r1.width=5;
	r1.height=7;
//		System.out.println(r1.width+","+r1.height);
		r1.area();
		r1.length();
		//����:30,����:20�� ���簢���� ��ü�� �����ϰ�, ����,�ѷ��� ����ϱ�.
		Rectangle r2 = new Rectangle();
		r2.width=5;
		r2.height=7;
		r2.area();
		r2.length();
		

	}
}
