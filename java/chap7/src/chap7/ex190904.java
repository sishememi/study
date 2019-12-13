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
		a="사람";
		age=n;
	}
	
	void info() {
		System.out.println(a+":"+age+"살");
	}
}

public class ex190904 {
	public static void main(String[] args) {
		  Animal3 a1 = new Animal3("원숭이",26);
		  Animal3 a2 = new Animal3("사자");
		  Animal3 a3 = new Animal3(100);
		  a1.info(); 
		  a2.info(); 
		  a3.info();  
		 }
}
*/
	

/*
 1.  Student 클래스 구현
       멤버변수 : 학번,이름,국어점수,영어점수, 수학점수
        멤버메서드 : 
                1. int getTotal() : 국어,영어,수학 점수의 합을 리턴
                2. float getAverage() : 국어,영어,수학 점수의 평균을 리턴
                3. void info() : 이름,반,학번, 국어,영어,수학, 총점,평균을 출력하기
        생성자 : 
                1. 매개변수 (이름, 학번) :  이름,학번을 초기화 하고, 점수는 0으로 초기화
                2. 매개변수 (이름, 학번, 국어, 영어, 수학) :  이름,학번, 점수들  초기화

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
		 System.out.println("학번:"+no+"\n 이름:"+name+"\n 국어:"+kor+"\n 영어:"+eng+"\n 수학:"+math
				 +"\n 영어:"+no+"\n 총점:"+getTotal()+"\n 평균:"+getAverage()+"\n======================");
	 }
}
public class ex190904 {
	public static void main(String[] args) {
		Student s = new Student("홍길동",1);
		  s.info();
		  Student s2 = new Student("김삿갓",2,80,90,70);
		  s2.info();
	}
}
*/