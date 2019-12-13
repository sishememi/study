package chap19;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/*
 * 대용량 데이터를 product.txt 파일로 생성하기
 */
public class ProductGenerator {
	public static void main(String[] args) {
		PrintStream ps = null;
		FileOutputStream fos = null;
		String [] cars = {"아반테","그랜저","BMW","벤츠","라세티"};
		String [] remark = {"몰라요","싫어요","그냥이요"};
		int limit = 0;
		int con = 0;
		try {
			fos = new FileOutputStream("product.txt");
			ps = new PrintStream(fos);
			while(limit++<1000000) {
				ps.print((int)(Math.random()*12)+1+",");//1~12까지의 판매월
				con = (int)(Math.random()*3)+1;//1~3까지의 값.: 1:생산,2:판매,3:반품
				ps.print(con+",");
				ps.print(cars[(int)(Math.random()*5)]+",");//자동차 이름
				ps.print((int)(Math.random()*5)+1);//수량
				if(con==3) {//반품
					ps.print(",");
					ps.print(remark[(int)(Math.random()*3)]);//반품 사유
				}
				ps.println();//100만건을 넣음
			}
			System.out.println("파일 생성 완료");
			ps.flush();ps.close();fos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
