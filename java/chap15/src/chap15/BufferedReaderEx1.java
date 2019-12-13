package chap15;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 보조 스트림: 다른 스트림을 이용하여 새로운 기능 추가하는 기능을 가진 스트림
 * 			객체 생성시 다른 스트림을 매개변수로 입력받는다.
 * BufferedReader : 버퍼를 내부적 추가하여 ID 성능 향상시키는 스트림.
 * 		=>readLine() 메서드를 이용하여 한줄씩 읽는 기능 추가.
 * new BufferedReader(Reader) 객체 생성 가능. 매개변수에 반드시 Reader를 써야함.
 * 
 * 키보드에서 한줄씩 읽어서 화면에 출력하기. bufferd.txt 파일에도 저장하기.
 */
public class BufferedReaderEx1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		FileWriter fos = new FileWriter("bufferd.txt"); //1.파일저장추가구문 OutputStream도 있는데 문자니까 filewrite
		String data = null;
		while((data = br.readLine()) != null) {
			System.out.println(data);
			fos.write(data+"\n");//2.파일저장추가구문 
		}
		fos.flush();//3.파일저장추가구문/ 버퍼에있는걸 다 내보냄
		fos.close();//4.파일저장추가구문/ 통로 ㄱ닫아버림. 이제 그만 저장.
	}

}
