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
//		this.type="������";
//		this.name=name;
//		this.address=address;
//		this.dept=dept;
//		this.empNo=empNo;
//		this.salary=salary;
//		this.position=position;
//	}
//	
//	public String toString() {
//		return type+", �̸�="+name+"�ּ�="+address+", �μ�="+dept+", ������ȣ="+empNo+", ����="+position+", ����="+salary;
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
//		this.type="��������";
//		this.name=name;
//		this.address=address;
//		this.dept=dept;
//		this.expireDate=expireDate;
//		this.primaryPay=primaryPay;
//	}
//	
//	public String toString() {
//		return type+", �̸�="+name+"�ּ�="+address+", �μ�="+dept+", ��ุ����="+expireDate+", �⺻�ӱ�="+primaryPay;
//	}
//	
//	int getPay() {
//		return primaryPay;
//	}
//}
//
//����Թ���
class Employee{
		String type,name,address,dept;
		Employee(String type,String name,String address,String dept){
			this.type=type;
			this.name=name;
			this.address=address;
			this.dept=dept;
		}
	public String  toString() {
		return type+"�̸�="+name+", �ּ�="+address+",�μ�="+dept;
	}
}

class FormalEmployee extends Employee{

	int salary;
	String empNo,position;

	FormalEmployee(String name,String address,String dept,String empNo,int salary,String position){
		super("������",name,address,dept);
		this.empNo=empNo;
		this.salary=salary;
		this.position=position;
	}

public String toString() {
	return super.toString()+", ������ȣ="+empNo+", ����="+position+", ����="+salary;
}

	int getPay() {
		return (salary/12);
	}//System.out.println(salary/12);

}

class InformalEmployee extends Employee{
	int primaryPay;
	Date expireDate;
	InformalEmployee (String name,String address,String dept,Date expireDate,int primaryPay){
		super("��������",name,address,dept);
		this.expireDate=expireDate;
		this.primaryPay=primaryPay;
	}

public String toString() {
	return super.toString()+", ��ุ����="+expireDate+", �⺻�ӱ�="+primaryPay;
}

int getPay() {
	return primaryPay;
	}
}

public class ex190905 {
	public static void main(String[] args) {
		  //�������� ��ü ����
		  FormalEmployee fe = new FormalEmployee("������", "����� ��걸","�ѹ���", "1", 5000, "����");
		  System.out.println(fe);
		  System.out.println(fe.name + "�� �޿� : " + fe.getPay()); //+   fe.getPay()
		  //fe.getPay();
		  //���������� ��ü ����
		  Date expireDate = new Date();
		  expireDate.setTime(expireDate.getTime() +1000L * 60 * 60 * 24 * 365 * 2);
		  InformalEmployee ie = new InformalEmployee("�̺���", "����� ���α�", "������", expireDate, 1000);
		  System.out.println(ie);
		  System.out.print(ie.name + "�� �޿� : " +  ie.getPay());
		 }
		}
