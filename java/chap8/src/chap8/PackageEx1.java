package chap8;

import chap8.packtest.Pack2; //�� �����ϸ� chap8.packtest.Pack2 p2 = new chap8.packtest.Pack2 �̷��� �������� �ʾƵ���
import java.util.Date;
/*
 * package: Ŭ�������� ����.
 * 		Ŭ�����̸��� ��Ű������ �����Ѵ�.
 * 		package ������ ������ ó���� �ѹ��� ������ �����ϴ�.
 * 		=> �ϳ��� ���Ͽ� �ִ� ��� Ŭ������ ���� ��Ű���� ���� Ŭ������.
 * 
 * import: ��Ű������ ������ �� �ֵ��� �̸� ���� Ŭ������ ��Ű���� �����ϴ� ����.
 * 
 * Ŭ������ �̸��� ������ �� �ִ� ���
 * 	1. ���� ��Ű���� ���� Ŭ������ ��Ű������ ������ �� �ִ�.
 *  2. java.lang ��Ű���� ���� Ŭ�������� ��Ű������ ���� ������.
 *  3. import �������� ������ Ŭ������ ��Ű���� ���� ����
 * 
 * */

class Pack1{
	void method() {
		System.out.println("chap8.Pack1.method() ȣ���");
	}
}
public class PackageEx1 {
	public static void main(String[] args) {
		Pack1 p1 = new Pack1(); //��¥�̸� chap8.Pack1�� �����ص� �� �ȿ� Pack1 �� �־ ����
		p1.method();
		Pack2 p2 = new Pack2(); //�ٸ� Ŭ������ �ִ� Pack2�̱⶧���� ��ü �̸� chap8.packtest.Pack2�� ����
		p2.method();
//		java.util.Date d = new java.util.Date();
		Date d = new Date(); //import java.util.Date;�� �����ϸ� �̷��� �ᵵ��
		
	}
}
