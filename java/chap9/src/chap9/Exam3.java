package chap9;
interface RemoteControl{
	void turnOn();
	void turnOff();
	void setVolume(int v);
	default void setMute(boolean n) {
		if(n) {
			System.out.println("무음 처리합니다.");
		}else {
			System.out.println("무음을 해재합니다.");
		}
	}
	static void changeBattery() {
		System.out.println("건전지를 교환합니다.");
	}
}
class Television implements RemoteControl{

	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}

	@Override
	public void setVolume(int v) {
		
		System.out.println("TV의 볼륨을"+ v +" 으로 설정합니다.");
	}
	
}
class Audio implements RemoteControl{

	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다"); 
		
	}

	@Override
	public void turnOff() {
		System.out.println("Audio를 끕니다"); 
		
	}

	@Override
	public void setVolume(int v) {
		System.out.println("Audio의 볼륨을"+ v +" 으로 설정합니다.");
		
	}	
}

public class Exam3 {
	public static void main(String[] args) {
		RemoteControl rc = new Television();
		rc.turnOn();//TV를 켭니다.
		rc.setVolume(10);//TV의 볼륨을 10 으로 설정합니다.
		rc.turnOff();//TV를 끕니다.
		rc.setMute(true);//무음 처리합니다.
		rc = new Audio();
		rc.turnOn();//Audio를 켭니다
		rc.setVolume(20);//Audio의 볼륨을 20으로 설정합니다.
		rc.turnOff();//Audio를 끕니다.
		rc.setMute(false);//무음을 해제합니다. //default
		RemoteControl.changeBattery(); //건전지를 교환합니다.//static
	}
}
