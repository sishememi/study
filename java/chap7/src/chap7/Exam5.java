package chap7;
/*
 * main �޼��忡�� Animal2 Ŭ������ ��ü������ �ǵ��� �����ڸ� �����ϱ�
 * */
class Animal2{
	String name;
	int age;
	Animal2(String s, int i){ //������ , �ν��Ͻ����...
		name = s;
		age = i;
	}
	
	public String toString() {
		return name + ":" + age;
	}
}
public class Exam5 {

	public static void main(String[] args) {
		Animal2 a = new Animal2("������",24);
//		a.name="������";
//		a.age=24;       �̷��� ���ص� �� �����ڿ��� �����ϱ⶧��
		System.out.println(a);
	}

}
