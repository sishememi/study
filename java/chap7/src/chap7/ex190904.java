package chap7;

class SutdaCard{
	int number;
	boolean isKwang;
	
	SutdaCard(int n, boolean k){
		number= n;
		isKwang=k;
	}
	
	SutdaCard(){
		number=1;
		isKwang=true;
	}
	
	public String toString() {
		
		return number+((isKwang)?"K":" ");
	}
	
}
public class ex190904 {
	public static void main(String[] args) {
		 SutdaCard card1 = new SutdaCard(3,false);
		 SutdaCard card2 = new SutdaCard();
		 System.out.println(card1);//3
		 System.out.println(card2);//1K
	 }
}

/*class Animal3{
	String a;
	int age;
	
	Animal3(String ani,int n){
		a=ani;
		age=n;
	}
	
	Animal3(String ani){
		a=ani;
		age=1;
	}
	
	Animal3(int n){
		a="���";
		age=n;
	}
	
	void info() {
		System.out.println(a+":"+age+"��");
	}
}

public class ex190904 {
	public static void main(String[] args) {
		  Animal3 a1 = new Animal3("������",26);
		  Animal3 a2 = new Animal3("����");
		  Animal3 a3 = new Animal3(100);
		  a1.info(); 
		  a2.info(); 
		  a3.info();  
		 }
}
*/
	

/*
 1.  Student Ŭ���� ����
       ������� : �й�,�̸�,��������,��������, ��������
        ����޼��� : 
                1. int getTotal() : ����,����,���� ������ ���� ����
                2. float getAverage() : ����,����,���� ������ ����� ����
                3. void info() : �̸�,��,�й�, ����,����,����, ����,����� ����ϱ�
        ������ : 
                1. �Ű����� (�̸�, �й�) :  �̸�,�й��� �ʱ�ȭ �ϰ�, ������ 0���� �ʱ�ȭ
                2. �Ű����� (�̸�, �й�, ����, ����, ����) :  �̸�,�й�, ������  �ʱ�ȭ

class Student{
	int no,kor,eng,math;
	String name;
	
	Student(String n,int o){
		name=n;
		no=o;
		kor=0;
		math=0;
		eng=0;
	}
	
	Student(String n, int o, int k, int e, int m){
		name=n;
		no=o;
		kor=k;
		eng=e;
		math=m;
	}
	

	int getTotal() {
		return kor+eng+math;
	}
	 float getAverage() {
		 return getTotal()/3f;
	 }
	 
	 void info() {
		 System.out.println("�й�:"+no+"\n �̸�:"+name+"\n ����:"+kor+"\n ����:"+eng+"\n ����:"+math
				 +"\n ����:"+no+"\n ����:"+getTotal()+"\n ���:"+getAverage()+"\n======================");
	 }
}
public class ex190904 {
	public static void main(String[] args) {
		Student s = new Student("ȫ�浿",1);
		  s.info();
		  Student s2 = new Student("���",2,80,90,70);
		  s2.info();
	}
}
*/