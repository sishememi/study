package chap15;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���� ��Ʈ��: �ٸ� ��Ʈ���� �̿��Ͽ� ���ο� ��� �߰��ϴ� ����� ���� ��Ʈ��
 * 			��ü ������ �ٸ� ��Ʈ���� �Ű������� �Է¹޴´�.
 * BufferedReader : ���۸� ������ �߰��Ͽ� ID ���� ����Ű�� ��Ʈ��.
 * 		=>readLine() �޼��带 �̿��Ͽ� ���پ� �д� ��� �߰�.
 * new BufferedReader(Reader) ��ü ���� ����. �Ű������� �ݵ�� Reader�� �����.
 * 
 * Ű���忡�� ���پ� �о ȭ�鿡 ����ϱ�. bufferd.txt ���Ͽ��� �����ϱ�.
 */
public class BufferedReaderEx1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		FileWriter fos = new FileWriter("bufferd.txt"); //1.���������߰����� OutputStream�� �ִµ� ���ڴϱ� filewrite
		String data = null;
		while((data = br.readLine()) != null) {
			System.out.println(data);
			fos.write(data+"\n");//2.���������߰����� 
		}
		fos.flush();//3.���������߰�����/ ���ۿ��ִ°� �� ������
		fos.close();//4.���������߰�����/ ��� ���ݾƹ���. ���� �׸� ����.
	}

}
