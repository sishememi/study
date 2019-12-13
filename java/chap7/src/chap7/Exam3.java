package chap7;

class Card{
	String kind;
	int number;
	static int width = 100;
	static int height = 250;
	public String toString() {
		return kind+":"+number+"("+width+","+height+")";
	}
}
public class Exam3 {
	public static void main(String[] args) {
//1.card1 객체생성하기
		Card card1 = new Card();
//2.card1.kind="Heart", number=1로 초기화하기
		card1.kind="Heart";
		card1.number=1;
//3.card1 출력하기
		System.out.println("card1:"+card1);
//4.card2 객체 생성하기
		Card card2 = new Card();
//5.card2.kind="Spade", number=1로 초기화하기
		card2.kind="Spade";
		card2.number=1;
//6.card2 출력하기
		System.out.println("card2:"+card2);
//7.card의 크기를 (50,50)으로 변경하기
		Card.width=50;
		Card.height=50;
		System.out.println("card1:"+card1);
		System.out.println("card2:"+card2);

	}
}
