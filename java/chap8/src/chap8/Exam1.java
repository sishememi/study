package chap8;
/*
 * SutdaCard 20장으로 이루어진 SutdaCard 클래스 구현하기
 * SutdaDeck 클래스
 * 1.멤버변수
 * SutdaCard 20장을 저장할 배열.
 * 2.생성자
 * SutdaCard 20장을 생성하여 배열에 저장하기
 * 3.메서드
 * 	(1)void shuffle():카드를 섞기.
 *  (2)SutdaCard pick(int index): index에 해당하는 카드 한장을 반환
 *  (3)SutdaCard pic(): 임의의 카드 한장을 반환
 *  
 * SutdaCard 클래스
 * 1.멤버변수: int number,boolean isKwang
 * 2.생성자: this 생성자 이용하기
 * 		-():number=1, isKwang=ture 인 객체 생성
 * 		-(int , boolean): 멤버변수에 값을 저장하기
 * 3.메서드
 * 		info: number+isKwang?"K":" "정보 출력하기.
 **/

class SutdaCard{
	int number;
	boolean isKwang;
			
	SutdaCard(int number,boolean isKwang){
		this.number = number;
		this.isKwang = isKwang;
	}
	

	SutdaCard(){
		this(1,true);
	}
	
	void info() {
		System.out.println(this);
	}
	
	public String toString() {
		return number+((isKwang)?"K":" ");
	}
}


	//SutdaDeck has a SutdaCard 관계
class SutdaDeck{
		SutdaCard cards [] = new SutdaCard[20]; //섯다카드를 저장한 참조변수 20개
		private int number;
		
		SutdaDeck(){		
			for(int i=0; i<cards.length;i++) {   
				//SutdaDeck deck = new SutdaDeck();
				cards[i] = new SutdaCard((i%10)+1,(i==0 || i==2 || i==7)?true:false);	 //		cards[i] = new  이 객체를 통해 값을 넣어줌>SutdaCard
			}		
		}
		
		void shuffle() {
			for(int i=0;i<1000;i++) {
				int f=(int)(Math.random()*20);
				int s=(int)(Math.random()*20);
				SutdaCard tmp = cards[f];
				cards[f] = cards[s];
				cards[s] = tmp;			
			}
		}
		
		SutdaCard pick(int index) {
			return cards[index];
		}
		
		SutdaCard pick() {
			
				return cards[(int)(Math.random()*20)];
		}

		public String toString() {
			String result="";
			for(SutdaCard c : cards) {
				result += c.toString()+","; //result += c+","  c는 섯다카드에있는 toString 메서드가 호출.
			}
			return result;
		}
	}
	

public class Exam1 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck(); 
		//1K,2,3K,4,5,6,7,8K,9,10,1,2,3,4,5,6,7,8,9,10
		System.out.println(deck); //deck 뒤 toString 생략
		deck.shuffle();
		System.out.println(deck);
		System.out.println(deck.pick(0)); //pick이 호출되고 index의 값에 0이들어감
		System.out.println(deck.pick());
	}
}




