package chap11;

import java.io.IOException;

/*
 * �������̵� �� �޼����� ����ó���� �θ�޼����� ����ó���� ���ų� ���� ������ �����ϴ�.
 * ���� ���þ��� ����ó���� �ȵȴ�.
 */
class Parent{
	void method(int i) throws RuntimeException{
		System.out.println(i);
	}
}
class Child extends Parent{
	@Override
	void method(int i) throws RuntimeException{
		System.out.println(i);
		try {
			throw new IOException();
		}catch(IOException e) {};
	}
}
public class ExeptionEx9 {
	public static void main(String[] args) {
		

	}

}
