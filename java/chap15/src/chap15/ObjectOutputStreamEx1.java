package chap15;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * ObjectOutputStream ����
 * 	- ��ü�� �ܺη� �����ϴ� ��Ʈ��.
 * 	- ���۵Ǵ� ��ü�� �ݵ�� Serializable �������̽��� �����ؾ��Ѵ�.
 * 		NotSerializableException: ����ȭ ��� ��ü�� �ƴ�.
 * 	- ��ü�� �ܺη� �����ϴ� �����  ����ȭ�� �Ѵ�.
 * 	- ObjectInputStream �� �̿��Ͽ� ��ü�� ���� �� �ִ�.
 */
class Customer implements Serializable{
	private String name;
	private transient int age;//transient : age �������� ����ȭ ��󿡼� ���ܽ�Ŵ.
	
	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + "]";
	}
	
	
}
public class ObjectOutputStreamEx1 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("object.ser"); //object.ser�� ��ü ��ü ���� �������.
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Customer c1 = new Customer("ȫ�浿",20); //��ü ����
		Customer c2 = new Customer("���",30);
		oos.writeObject(c1); //c1�̶�� ��ü�� �ܺη� ���
		oos.writeObject(c2);
		System.out.println("��1: " +c1);
		System.out.println("��2: " +c2);
	}
}
