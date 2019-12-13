package chap15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamEx2 {
	public static void main(String[] args) throws  IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object2.ser"));
		User c1 = (User)ois.readObject();
		User c2 = (User)ois.readObject();
		System.out.println("사용자1:"+ c1);
		System.out.println("사용자2:"+ c2);

	}
}

