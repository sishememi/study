package chap7;
/*
 * Rectangle3 Ŭ���� �����ϱ�
 * �������: width,height,serialNo,sno(���� ��ȣ�� �����ϱ����� static ����)
 * ������: ���ο� ���θ� �Է¹ް�, ����,���ΰ��� �ʱ�ȭ��.
 * ����޼���:
 * 		int area():���� ������
 * 		int length(): �ѷ��� ����
 * 		boolean isSquare():���簢�� ���� ����
 * 	    void info():
 * 			"1�� �簢��:(10,10,) ����:100, �ѷ�:40, ���簢��" ���ڿ��� ����ϱ� 
 * 			"2�� �簢��:(20,10,) ����:200, �ѷ�:60, ���簢��" ���ڿ��� ����ϱ� 
*/
class Rectangle3{
	int width,height,serialNo;
	static int sno;
	
	int area() {
		return width*height;
		}
	
	int length() {
		return (width+height)*2;
		}
	
	Rectangle3(int w, int h){
		width=w;  //���� �Է��� ��(w)���� �Ҵ� 
		height=h;
		serialNo= ++sno;
	}
	void info() {
		System.out.println(serialNo+"�� �簢��: ("+width+","+height+") ����:"+area()+", �ѷ�:"+length()+","+(isSquare()?"���簢��":"���簢��"));
	}
	
	boolean isSquare() {  //true�� false���� ���� �� ����.
//		if(width==height) { 
//			System.out.print("���簢��");
//			}else {
//				System.out.print("���簢��");
//			}
		return width==height;  //���ο� ���ΰ� ������ true �ƴϸ� false ��  ���׿�����? ���ǿ�����?��  �����ϸ��..
			
	}
}
public class Exam6 {
	public static void main(String[] args) {
		Rectangle3[] recarr = new Rectangle3[3];
		recarr[0] = new Rectangle3(10,10);
		recarr[1] = new Rectangle3(20,10);
		recarr[2] = new Rectangle3(25,25);
		
		for(Rectangle3 r: recarr) {
			//r.serialNo = ++Rectangle3.sno; ���⿡ ���ϰ� �����ڿ� �־��.
			r.info();
		}
	}

}
