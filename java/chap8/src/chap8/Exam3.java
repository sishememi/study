package chap8;

import java.util.Scanner;

/*
 * 모든 식품(food)은 가격(price)과 포인트(point)를 멤버로 가진다.
 * 식품의 객체 생성시 가격을 입력받아야하고, 가격의 10%를 포인트로 저장한다.
 * 식료품의 종류는 과일(Fruit),음료(Drink),과자(Snack) 로 나뉜다.
 * 과일 클래스는 당도(brix)를,  음료는 용량(ml), 과자는 무게(kg)를 멤버로가진다.
 * 음료의 종류로는 콜라(Cock)와 사이다(Sider)
 * 과자의 종류로는 비스킷(Biscuit)과 쿠키(Cookie) 가 있다.
 * 사과,복숭아,콜라,사이다,비스킷,쿠키 클래스에 toString() 메서드를 구현하고
 * 각각의 이름을 리턴한다.
 * 
 * 사과와 복숭아 생성시 가격과 당도를,
 * 콜라,사이다 생성시 가격과 용량을,
 * 비스킷과 쿠기 생성시 가격과 무게를 입력받아 객체를 생성한다.
 * */
class Food{
	int price,point;	

	Food(int price){
		this.price=price;
		this.point= price/10;
	}
}
class Fruit extends Food{
	double brix;
	
	Fruit(int price,double brix){
		super(price);
		this.brix=brix;
	}
}
class Drink extends Food{
	int ml;
	
	Drink(int price,int ml){
		super(price);	
		this.ml=ml;
	}
}
class Snack extends Food{
	double kg;
	
	Snack(int price,double kg){
		super(price);
		this.kg=kg;
	}
}
class Apple extends Fruit{

	Apple(int price,double brix){
		super(price,brix);
	}
	public String toString() {
		return "사과";
	}
}
class Peach extends Fruit{
	
	Peach(int price,double brix){
		super(price,brix);
	}
	public String toString() {
		return "복숭아";
	}
	
}
class Cock extends Drink{
	
	Cock(int price,int ml){
		super(price,ml);
	}
	public String toString() {
		return "콜라";
	}
}
class Sider extends Drink{
	
	Sider(int price,int ml){
		super(price,ml);
	}
	public String toString() {
		return "사이다";
	}
}
class Biscuit extends Snack{
	
	Biscuit(int price,int kg){
		super(price,kg);
	}
	public String toString() {
		return "비스킷";
	}
}

class Cookie extends Snack{
	
	Cookie(int price,int kg){
		super(price,kg);
	}
	public String toString() {
		return "쿠키";
	}
}
/*
 * Buyer2 클래스 구현하기
 * 고객은 돈과 포인트 장바구니를 멤버로 가진다.
 * 총 식료품 구매 건수를 가진다.
 * 메서드:
 * 		buy(Food):
 * 			물건 구매시 보유금액에서 물품가격만큼 차감
 * 			물품의 포인트 만큼 포인트 증가.
 * 			소유 금액보다 물품값이 큰 경우 "잔액부족" 메세지 출력하고 메서드 종료
 * 			물품의 물품명과 가격을 화면에 출력.
 * 			해당 물품은 장바구니에 추가.
 * 		summary() :
 * 			장바구니를 조회하여 구매한 물품의 목록과 총 가격과 현재 포인트를 출력하기.
 * 			과일의 갯수, 과일 구매 금액,과일 구매 목록
 * 			음료의 갯수, 음료 구매 금액,음료 구매 목록
 * 			과일의 갯수, 과자 구매 금액,과자 구매 목록 출력하기.
 * */

class Buyer2 {
	int money=10000;
	int point;
	Food cart[] = new Food[20];
	int cnt;
	
	void buy(Food f) {
		if(money<f.price) {
			System.out.println(f+"구매시 잔액부족");
			return;
		}
		money -= f.price;
		point += f.point;
		System.out.println(f+": 가격= "+f.price+"구입");
		cart[cnt++]=f;
	}
	
	void summary(){
		int total=0,ftotal=0,dtotal=0,stotal=0;
		int fcnt=0,dcnt=0,scnt=0;
		String flist="",dlist="",slist="";
		
		for(Food f: cart) {
			if(f==null) break;
			total += f.price;
			//과일 건수, 과일 금액(핵심)
			if(f instanceof Fruit) {
				fcnt++;
				ftotal += f.price;
				flist += f+",";
			}
			if(f instanceof Drink) {
				dcnt++;
				dtotal += f.price;
				dlist += f+",";
			}
			if(f instanceof Snack) {
				scnt++;
				stotal += f.price;
				slist += f+",";
			}
		}
		System.out.println("총구매 금액:"+total+", 총구매건수:"+cnt);
		System.out.println("과일구매 금액:"+ftotal+", 과일구매건수:"+fcnt);
		System.out.println("과일 구매 목록:"+ flist);
		
		System.out.println("음료구매 금액:"+dtotal+", 음료구매건수:"+dcnt);
		System.out.println("음료 구매 목록:"+ dlist);
		
		System.out.println("과자구매 금액:"+stotal+", 과자구매건수:"+scnt);
		System.out.println("과자 구매 목록:"+ slist);
	}
}
public class Exam3 {
	public static void main(String[] args) {
		Apple apple = new Apple(1000,10.5); //가격,당도(birx)
		System.out.println("사과 가격:"+apple.price);
		System.out.println("사과 당도:"+apple.brix);
		Peach peach = new Peach(1000,13.5);//가격,당도(birx)
		Cock cock = new Cock(500,500);//가격 ,용량(ml)
		Sider sider = new Sider(1500,1500);//가격,용량(ml)
		Biscuit bis = new Biscuit(1000,500);//가격,무게(kg)
		Cookie cookie = new Cookie(500,5000);//가격,무게(kg)
		Buyer2 b = new Buyer2();
		b.buy(apple);
		b.buy(peach);
		b.buy(cock);
		b.buy(sider);
		b.buy(bis);
		b.buy(cookie);
		System.out.println("고객 잔액:"+b.money);
		System.out.println("고객 포인트: "+b.point);
		b.summary();
	
//		System.out.println(peach);
//		System.out.println(cock);
//		System.out.println(sider);
//		System.out.println(bis);
//		System.out.println(cookie);
			
	}
}
