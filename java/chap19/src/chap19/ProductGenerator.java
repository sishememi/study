package chap19;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/*
 * ��뷮 �����͸� product.txt ���Ϸ� �����ϱ�
 */
public class ProductGenerator {
	public static void main(String[] args) {
		PrintStream ps = null;
		FileOutputStream fos = null;
		String [] cars = {"�ƹ���","�׷���","BMW","����","��Ƽ"};
		String [] remark = {"�����","�Ⱦ��","�׳��̿�"};
		int limit = 0;
		int con = 0;
		try {
			fos = new FileOutputStream("product.txt");
			ps = new PrintStream(fos);
			while(limit++<1000000) {
				ps.print((int)(Math.random()*12)+1+",");//1~12������ �Ǹſ�
				con = (int)(Math.random()*3)+1;//1~3������ ��.: 1:����,2:�Ǹ�,3:��ǰ
				ps.print(con+",");
				ps.print(cars[(int)(Math.random()*5)]+",");//�ڵ��� �̸�
				ps.print((int)(Math.random()*5)+1);//����
				if(con==3) {//��ǰ
					ps.print(",");
					ps.print(remark[(int)(Math.random()*3)]);//��ǰ ����
				}
				ps.println();//100������ ����
			}
			System.out.println("���� ���� �Ϸ�");
			ps.flush();ps.close();fos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
