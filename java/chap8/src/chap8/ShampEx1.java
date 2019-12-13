package chap8;
/*
 * �߻� Ŭ����
 * 	�߻�޼��带 ���� �� �ִ� Ŭ����. abstract ������ ������.
 * 	��üȭ �Ұ� => ��üȭ�� �ݵ�� ����� ���ؼ� �ڼ�Ŭ������ ��üȭ�� ��üȭ�� ������.
 * 	�̶� �ڼ�Ŭ���������� �߻�޼��带 �وf�� �������̵� �ؾ��Ѵ�.
 * 	�׿ܴ� �Ϲ�Ŭ������ ����.(������, �������, ����޼���..)
 * 	������ ǥ��ȭ�� �����.
 * 
 * �߻�޼���: ����θ� �����ϴ� �޼���. �����ΰ� ����.
 * 			�ڼ�Ŭ�������� �ݵ�� �������̵� �ؾ���.
 * �߻�Ŭ���������� ����� ����. �������̵������ʾƵ���.
 * */

abstract class Shape{
	String type;
	Shape(String type){
		this.type= type;
	}
	abstract double area();//�߻�޼���
	abstract double length();//�߻�޼���
}
class Circle extends Shape{
	int r;
	Circle(int r){
		super("��");
		this.r=r;
	}
	@Override
	double area() {
		return r*r*Math.PI;
	}
	@Override
	double length() {
		return 2*r*Math.PI;
	}
	@Override
	public String toString() {
		return "Circle [r=" + r + ", type=" + type + "]"+ ", ����:"+area()+", �ѷ�:"+length();
	}
	
}
class Rectangle extends Shape{
	int width,height;
	Rectangle(int width,int height){
		super("�簢��");
		this.width=width;
		this.height=height;
	}
	@Override
	double area() {
		return width*height;
	}
	@Override
	double length() {
		return (width+height)*2;
	}
	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + ", type=" + type + "]"+ "����:"+area()+", �ѷ�:"+length();

	}
	
}
public class ShampEx1 {
	public static void main(String[] args) {
		Shape[] shapes = new Shape[2];
		shapes[0] = new Circle(10);
		shapes[1] = new Rectangle(5,5);
		for(Shape s: shapes) {
			System.out.println(s);
		}
	}
}
