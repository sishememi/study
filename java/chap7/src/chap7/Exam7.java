package chap7;
/*
 * ��(Circle) Ŭ���� �����ϱ�
 * 1. ������� 
 * 		������(r),x��ǥ(x),y��ǥ(y),���� ��ȣ(no)
 * 		���� ��ȣ ���� ���� count
 * 2. ������: ���� Ŭ������ �µ��� �����ϱ�
 * 3.����޼���
 * (1)double area(): ���� ���̸���, Math.PI ��� ���
 * (2)double length(): ���� �ѷ� ����, Math.PI ������
 * (3)void move(int a, int b): x,y ��ǥ�� x+a, y+b�� �̵�
 * (4)void scale(double m) : �������� m�� Ȯ��/��� r=r*m
 * (5)String toString():
 * 		1�� ��: ������:10, ��ǥ(10,10), ����:314.xxxx , �ѷ�:xxx.xxx 
 * 		...
 */
class Circle{
	int r,x,y,no;
	static int count;
	
	Circle(int r,int x, int y){
		this.r=r;
		this.x=x;
		this.y=y;	
		no= ++Circle.count;
		
	}
	Circle(int x,int y){
		this(1,x,y);	
		
	}
	Circle(int r){
		this(r,0,0);
	}
	/*
	 * 	Circle(int rp,int xp, int yp){
		r=rp;
		x=xp;
		y=yp;	
		no= ++Circle.count;
		
	}
	Circle(int xp,int yp){
		r=1;
		x=xp;
		y=yp;	
		no= ++Circle.count;
		
	}
	Circle(int rp){
		r=rp;
		x=0;
		y=0;
		no= ++Circle.count;
		
	}
	 * */
	double area() {
		return Math.PI*r*r;
	}
	
	double length() {
		return 2*Math.PI*r;
	}
	
	void move(int a,int b) {
		x=x+a;
		y=y+b;
	}
	
	void scale(double m) {
		r=r*(int)m;
		//r*= m �� ���������� ������.	
	}
	public String toString() {
	return no+"�� ��: ������:"+r+", ��ǥ("+x+","+y+"), ����:"+area()+", �ѷ�:"+length();
//		return String.format
//				("%d����=> ������:%.3f, ��ǥ(%d,%d), ����:%.3f, �ѷ�:%.3f",no,r,x,y,area(),length());
	// return String.format("%d�� �� => ������ : %.3f, ��ǥ(%d, %d), ���� : %.3f , �ѷ�: %.3f", no, r, x, y, area(), length());
	}
		

	
}
public  class Exam7 {
	public static void  main(String[] args) {
		Circle carr[] = new Circle[3];
		carr[0] = new Circle(10,10,10); //������ 10 ,(10,10) ��ǥ
		carr[1] = new Circle(20,20); //������ 1, (20,20) ��ǥ
		carr[2] = new Circle(100); // ������ 100 (0,0)��ǥ
		
		for(Circle c : carr) {
			//c.no= ++Circle.count;
			System.out.println(c);
			c.move(10,10);
			System.out.println(c);
			c.scale(3);
			System.out.println(c);
		}
	}
}
