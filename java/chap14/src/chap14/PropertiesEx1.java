package chap14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/*
 * Properties Ŭ���� Hashtable ���̺��� ����Ŭ������.
 * Hashtable��  Map �������̽��� ����Ŭ�����̹Ƿ� Properties Ŭ������ Map�� ������ Ŭ������.
 * (key,value) �ڷ����� ��� String��. ���׸�ǥ�� ���Ѵ�.
 * -�ؽ�Ʈ���Ͽ��� Map ��ü�� �߰��� �� �ִ� ����� �ִ�.
 */
public class PropertiesEx1 {
	public static void main(String[] args) throws IOException {
		Properties pr = new Properties();//Properties() ��ü���� 
		System.out.println(pr);//�ƹ��͵� ����
		FileInputStream fis = new FileInputStream("a.properties");//FileInputStream=>a.properties�� ������.fis�� a.pr~ ������ �����غ� �Ϸ��� ����.
		pr.load(fis); //== pr.load(new FileInputStream("a.properties"));
		System.out.println(pr);
		System.out.println("�̸�: "+pr.get("name"));//pr.get("name") : Ű�� ��ü�� value�� ����, : ȫ�浿
		System.out.println("��ȭ��ȣ: "+pr.getProperty("tel"));//pr.getProperty() :Hashtable�� ������ ���Ǵ� get �޼���. ��ȭ��ȣ�� ������
		pr.put("subject","��ǻ�Ͱ���"); //properties�� subject,��ǻ�Ͱ��� �߰�(put)
		System.out.println(pr);
		//FileOutputStream : ���� �����ϱ�.
		FileOutputStream fos = new FileOutputStream("b.properties");
		//pr ��ü�� (key,value) ��ü�� ���Ϸ� ����
		pr.store(fos, "#save");//"#save"�� ���̸� ������ #�� properties���� �ּ�
		//pr.store(new FileOutputStream("b.properties"), "#save");//== FileOutputStream fos = new FileOutputStream("b.properties");
				
	}
}
