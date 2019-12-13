package chap9;
/*
 * �Ű������� �������̽������� ����ϴ� ��� => ����� �ǹ̷� ���� ����
 * */
interface Repairable{}
class Unit{
	int hp;
	final int MAX;
	Unit(int hp){
		this.hp=hp;
		MAX = hp;
	}
}

class AirUnit extends Unit{
	AirUnit(int hp){
		super(hp);
	}
}

class GroundUnit extends Unit{
	 GroundUnit(int hp){
		 super(hp);
	 }
}
class Tank extends GroundUnit implements Repairable{
	Tank(){super(150);}
	public String toString() {return "Tank";}
}
class Dropship extends AirUnit implements Repairable{
	Dropship (){super(125);}
	public String toString() {return "Dropship";}
}
class Marine extends AirUnit implements Repairable{
	Marine (){super(40);}
	public String toString() {return "Marine";}
}
class SCV extends GroundUnit implements Repairable{
	SCV(){super(60);}
	void repair(Repairable r) {
		if(r instanceof Unit ) { //r�� �����ϰ��ִ� ��ü���� unit?
			Unit u = (Unit)r; 
			u.hp = u.MAX;
			System.out.println(r.toString()+"���� �Ϸ�");
		}
	}
	public String toString() {return "SCV";}
}
public class Exam2 {
	public static void main(String[] args) {
		Tank t = new Tank();
		Dropship d = new Dropship();
		Marine n = new Marine();
		SCV s = new SCV();
		s.repair(t);
		s.repair(d);
//		s.repair(m);
		s.repair(s);
	}

}