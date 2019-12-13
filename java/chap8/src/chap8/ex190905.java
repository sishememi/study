package chap8;
import java.util.Date;

//class Employee{
//	String type,name,address,dept;
//}
//
//class FormalEmployee extends Employee{
//	
//	int salary;
//	String empNo,position;
//
//	FormalEmployee(String name,String address,String dept,String empNo,int salary,String position){
//		this.type="정규직";
//		this.name=name;
//		this.address=address;
//		this.dept=dept;
//		this.empNo=empNo;
//		this.salary=salary;
//		this.position=position;
//	}
//	
//	public String toString() {
//		return type+", 이름="+name+"주소="+address+", 부서="+dept+", 직원번호="+empNo+", 직급="+position+", 연봉="+salary;
//	}
//	
//	int getPay() {
//		return (salary/12);
//	}//System.out.println(salary/12);
//
//}
//
//class InformalEmployee extends Employee{
//	int primaryPay;
//	Date expireDate;
//	InformalEmployee (String name,String address,String dept,Date expireDate,int primaryPay){
//		this.type="비정규직";
//		this.name=name;
//		this.address=address;
//		this.dept=dept;
//		this.expireDate=expireDate;
//		this.primaryPay=primaryPay;
//	}
//	
//	public String toString() {
//		return type+", 이름="+name+"주소="+address+", 부서="+dept+", 계약만료일="+expireDate+", 기본임금="+primaryPay;
//	}
//	
//	int getPay() {
//		return primaryPay;
//	}
//}
//
//강사님버젼
class Employee{
		String type,name,address,dept;
		Employee(String type,String name,String address,String dept){
			this.type=type;
			this.name=name;
			this.address=address;
			this.dept=dept;
		}
	public String  toString() {
		return type+"이름="+name+", 주소="+address+",부서="+dept;
	}
}

class FormalEmployee extends Employee{

	int salary;
	String empNo,position;

	FormalEmployee(String name,String address,String dept,String empNo,int salary,String position){
		super("정규직",name,address,dept);
		this.empNo=empNo;
		this.salary=salary;
		this.position=position;
	}

public String toString() {
	return super.toString()+", 직원번호="+empNo+", 직급="+position+", 연봉="+salary;
}

	int getPay() {
		return (salary/12);
	}//System.out.println(salary/12);

}

class InformalEmployee extends Employee{
	int primaryPay;
	Date expireDate;
	InformalEmployee (String name,String address,String dept,Date expireDate,int primaryPay){
		super("비정규직",name,address,dept);
		this.expireDate=expireDate;
		this.primaryPay=primaryPay;
	}

public String toString() {
	return super.toString()+", 계약만료일="+expireDate+", 기본임금="+primaryPay;
}

int getPay() {
	return primaryPay;
	}
}

public class ex190905 {
	public static void main(String[] args) {
		  //정규직원 객체 생성
		  FormalEmployee fe = new FormalEmployee("김정규", "서울시 용산구","총무부", "1", 5000, "과장");
		  System.out.println(fe);
		  System.out.println(fe.name + "의 급여 : " + fe.getPay()); //+   fe.getPay()
		  //fe.getPay();
		  //비정규직원 객체 생성
		  Date expireDate = new Date();
		  expireDate.setTime(expireDate.getTime() +1000L * 60 * 60 * 24 * 365 * 2);
		  InformalEmployee ie = new InformalEmployee("이비정", "서울시 구로구", "영업부", expireDate, 1000);
		  System.out.println(ie);
		  System.out.print(ie.name + "의 급여 : " +  ie.getPay());
		 }
		}
