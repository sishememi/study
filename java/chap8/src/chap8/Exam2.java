package chap8;
/*
 * 다형성 예제
 * Buyer가 전자제품 구매하기
 * 
 * Product 클래스
 *	멤버변수: 가격, 포인트
 *	생성자: 가격을 입력받고, 가격의 10%를 포인트로 저장.
 *
 * Tv 클래스
 *	 가격이 100 설정하기
 *	toString () 메서드에서 Tv를 리턴.
 *
 *  Computer 클래스
 *	 가격이 200 설정하기
 *	toString () 메서드에서 Computer를 리턴.
 *
 *  SmartPhone 클래스
 *	 가격이 150 설정하기
 *	toString () 메서드에서 SmartPhone를 리턴.
 * */
class Product{
	int price;
	int point;

	Product(int price){
		this.price=price;
		this.point=price/10;
	}	
}

class Tv extends Product{
	
	Tv(){ //생성자 상속
		super(100);
	}
	
	public String toString() {
		return "Tv";
	}
}

class Computer extends Product{

	Computer(){
		super(200);
	}
	
	public String toString() {
		return "Computer";
	}
}

class SmartPhone2 extends Product{
	
	SmartPhone2(){
		super(150);
	}
	
	public String toString() {
		return "SmartPhone";
	} 
}
/*
 * Buyer 클래스
 * 	멤버변수: money = 500, point
 * 		   cart = new Product[3];
 * 		   cnt;
 *  멤버메서드: buy(Product p)
 *  		 p 상품의 가격만큼 고객의 money에서 차감.
 *  		 p 상품의 포인트만큼 나의 point 증가.
 *  		  화면에 구입한 제품을 출력
 *    		 cart에 제품 추가.
 *  		 
 *  		 summary()
 *  			1.각 구매한 물품의 가격과 포인트 출력.
 *  			2.전체 구매 물품 가격.
 *  			3.전체 구매 물품 목록 출력.
 * */
class Buyer {
	int money= 500;
	int point;
	Product cart[] = new Product[3]; //물건을살수있는 카트
	int cnt; //물건 구입갯수;
	
	void buy(Product p) {  //티비,컴퓨터,스마트폰을 한번에 묶어줌.
			money -= p.price;
			point += p.point;
			System.out.println(p+" 구입함");
			cart[cnt++]=p;		  //실제 저장한 객체는 티비,컴퓨터,스마트폰
	}
	
	void summary() {
		int sum=0;
		String productlist="";
		//강사님버전
//		for(Product p : cart) {
//			if(p==null) break;
//			System.out.println(p+"상품 : 가격="+p.price+", 포인트="+p.point);
//			 sum += p.price;
//			 productlist += p+", ";
//		}
		for(int i=0;i<cart.length;i++) {
		System.out.println(cart[i]+"상품 : 가격="+cart[i].price+", 포인트="+cart[i].point);
		 sum += cart[i].price;
		 productlist += cart[i]+", ";
		}
	System.out.println("총 물품구매액:"+sum);
	System.out.println("총 물품구매 목록:"+productlist);
	}		
}
public class Exam2 {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		Tv t =new Tv();
		Computer c = new Computer();
		SmartPhone2 s = new SmartPhone2();
		b.buy(t);
		b.buy(c);
		b.buy(s);
		System.out.println("구매후 잔액:"+b.money);
		System.out.println("구매후 적립포인트:"+b.point);
		System.out.println("========구매 제품 정보========");
		b.summary();
	}
}