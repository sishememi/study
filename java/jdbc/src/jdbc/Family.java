package jdbc;

public class Family {
	private int fno;
	private String name;
	private int age;
	private String job;
	private int sex;
	
	public Family( String name, int age, String job, int sex) {
	
		this.name = name;
		this.age = age;
		this.job = job;
		this.sex = sex;
	}
	public Family(int fno, String name, int age, String job, int sex) {
		this.fno = fno;
		this.name = name;
		this.age = age;
		this.job = job;
		this.sex = sex;
	}
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	   @Override
	   public String toString() {
	      return "번호=" + fno + ", 이름=" + name + ", 나이=" + age + ", 직업=" + job + ", 성별=" + (sex==1?"남자":"여자");
	   }
	
	
}