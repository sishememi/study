package jdbc;

public class Subject {
	private int no;
	private String name;
	private int hour;
	
	public Subject(String name, int hour) {
		this.name = name;
		this.hour = hour;
	}
	public Subject(int no, String name, int hour) {
		this.no = no;
		this.name = name;
		this.hour = hour;
	}
	//getter, setter, toString 
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	@Override
	public String toString() {
		return "Subject [no=" + no + ", name=" + name + ", hour=" + hour + "]";
	}
	
	
}
