package chap8;
/**/
class  SingleObject{
	private static SingleObject obj = new  SingleObject();
	private SingleObject() {} //������
	private int value=100;
	public static SingleObject getObject() {
		return obj;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
public class SingletonEx {
	public static void main(String[] args) {
		// SingleObject so = new  SingleObject(); //������ ���� �Ұ�.
		 SingleObject so1 = SingleObject.getObject();
		 SingleObject so2 =  SingleObject.getObject();
		 System.out.println(so1.getValue());
		 System.out.println(so2.getValue());
		 so1.setValue(500);
		 System.out.println(so1.getValue());//500
		 System.out.println(so2.getValue());//500 
		 
		 if(so1==so2)
			 System.out.println("so1���������� ��ü�� so2���������� ��ü�� ���� ��ü��.");
	}
}
