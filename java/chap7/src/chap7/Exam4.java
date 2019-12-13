package chap7;
/*
 * Rectangle2 Ŭ������ �����ϱ�
 * 	�������:width,height,serialNo(�簢����ȣ),sno(��ȣ �����ϱ� ���� ����)
 * 	��� �޼���:
 * 		int area():���� ���ϱ�
 * 		int length():�ѷ� ���ϱ�
 * 		public String toString() �޼��� �����ϱ�
 * 	����Ŭ���� ����
 * 		Rectangle2 Ŭ������ 5�� ������ �ִ� �迭 �����ϱ�
 * 		1���簢��: ����(10),����(20);
 *		2���簢��: ����(15),����(25);
 * 		3���簢��: ����(20),����(30);
 *  
 *  ���� �簢���� ����,�ѷ� ����ϰ�, ��ü ������ �հ� �ѷ��� �� ����ϱ�
 *  [���]
 *  1���簢��: (����,����) => ����:100, �ѷ�:200
 *  ...
 *  ��ü �簢�� ������ ��:
 *  ��ü �簢�� �ѷ��� ��:
 *
 * */

class Rectangle2{
	
	int width,height,serialNo;

	static int sno;
	
	int area() { //���ϰ��� �������� void�� ����ȵ� 
		return width*height;
	}
	
	int length() {
		return (width+height)*2;
	}
	public String toString() {
		return serialNo +"�� �ﰢ��: (" + width + "," + height + ") => ����:"
						+ area() + " �ѷ�:" + length()  ;
	}
}
public class Exam4 {
	public static void main(String[] args) {
		Rectangle2 rec[] = new Rectangle2[5];
		int totalArea = 0;
		int totalLenght = 0;
		for(int i=0;i<rec.length;i++) {
			rec[i] = new Rectangle2();
			rec[i].serialNo = ++Rectangle2.sno;
			rec[i].width = i*5+10;
			rec[i].height = i*5+20;
			System.out.println(rec[i]);
			totalArea += rec[i].area();
			totalLenght += rec[i].length();
					

		}
		System.out.println("��ü �簢�� ������ ��:"+ totalArea);
		System.out.println("��ü �簢�� ������ ��:"+ totalLenght);
		
		
	}
}
