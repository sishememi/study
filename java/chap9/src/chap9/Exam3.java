package chap9;
interface RemoteControl{
	void turnOn();
	void turnOff();
	void setVolume(int v);
	default void setMute(boolean n) {
		if(n) {
			System.out.println("���� ó���մϴ�.");
		}else {
			System.out.println("������ �����մϴ�.");
		}
	}
	static void changeBattery() {
		System.out.println("�������� ��ȯ�մϴ�.");
	}
}
class Television implements RemoteControl{

	@Override
	public void turnOn() {
		System.out.println("TV�� �մϴ�.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV�� ���ϴ�.");
	}

	@Override
	public void setVolume(int v) {
		
		System.out.println("TV�� ������"+ v +" ���� �����մϴ�.");
	}
	
}
class Audio implements RemoteControl{

	@Override
	public void turnOn() {
		System.out.println("Audio�� �մϴ�"); 
		
	}

	@Override
	public void turnOff() {
		System.out.println("Audio�� ���ϴ�"); 
		
	}

	@Override
	public void setVolume(int v) {
		System.out.println("Audio�� ������"+ v +" ���� �����մϴ�.");
		
	}	
}

public class Exam3 {
	public static void main(String[] args) {
		RemoteControl rc = new Television();
		rc.turnOn();//TV�� �մϴ�.
		rc.setVolume(10);//TV�� ������ 10 ���� �����մϴ�.
		rc.turnOff();//TV�� ���ϴ�.
		rc.setMute(true);//���� ó���մϴ�.
		rc = new Audio();
		rc.turnOn();//Audio�� �մϴ�
		rc.setVolume(20);//Audio�� ������ 20���� �����մϴ�.
		rc.turnOff();//Audio�� ���ϴ�.
		rc.setMute(false);//������ �����մϴ�. //default
		RemoteControl.changeBattery(); //�������� ��ȯ�մϴ�.//static
	}
}
