package chap7;
/* 
 * Rectangle ��ü�� 3�� ������ �迭�� �����ϱ�.
 * 0����: ����:10 ����:20
 * 1����: ����:11 ����:21
 * 2����: ����:12 ����:22
 * �� ��ü�� �����ϰ�,
 * ������ ���̿� �ѷ� ����ϱ�
 * */

public class Exam2 {
	public static void main(String[] args) {
		//Rectangle ��ü�� 3�� ������ �迭
		//Rectangle ��ü�� ������ ���������� �迭
		Rectangle rarr[] = new Rectangle[3];
		for(int i=0;i<rarr.length;i++) {
			rarr[i] = new Rectangle(); //Rectangle ��üȭ 
			rarr[i].width = i+10;
			rarr[i].height = i+20;
//			System.out.print(i+"�� �簢�� ����:");
//			rarr[i].area();
//			System.out.print(i+"�� �簢�� �ѷ�:");
//			rarr[i].length();
			
		}
		
		for(int i=0;i<rarr.length;i++) {
			System.out.println(+i+"����: ����:"+rarr[i].width+"����:"+rarr[i].height);
				//+"����:"+rarr[i].width*rarr[i].height+"�ѷ�:"+(rarr[i].width*rarr[i].height)*2);
			rarr[i].area();
			rarr[i].length();
		}
	}

}
