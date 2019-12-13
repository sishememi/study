package chap19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;//nio io��ü�� ������ ���̱����� ���� ��Ű��
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/*
 * File���� ���� ������ ��Ʈ������ �����ϱ�.
 */
public class FileToStreamEx1 {
	public static void main(String[] args) throws IOException {
		System.out.println("������ ������ ��Ʈ���� �̿��Ͽ� ȭ�鿡 ���");
		BufferedReader br = new BufferedReader(new FileReader(new File("src/chap19/FilterStreamEx1.java")));
		br.lines().forEach(s->System.out.println(s));
		System.out.println("���� ����� ��Ʈ���� �̿��Ͽ� ȭ�鿡 ���");
		Path path = Paths.get("src/chap19");//������������ ������
		Stream<Path> st = Files.list(path);
		st.forEach(p->System.out.println(p.getFileName()));
	}
}
