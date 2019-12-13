package chap8;
/*
 * SutdaCard 20������ �̷���� SutdaCard Ŭ���� �����ϱ�
 * SutdaDeck Ŭ����
 * 1.�������
 * SutdaCard 20���� ������ �迭.
 * 2.������
 * SutdaCard 20���� �����Ͽ� �迭�� �����ϱ�
 * 3.�޼���
 * 	(1)void shuffle():ī�带 ����.
 *  (2)SutdaCard pick(int index): index�� �ش��ϴ� ī�� ������ ��ȯ
 *  (3)SutdaCard pic(): ������ ī�� ������ ��ȯ
 *  
 * SutdaCard Ŭ����
 * 1.�������: int number,boolean isKwang
 * 2.������: this ������ �̿��ϱ�
 * 		-():number=1, isKwang=ture �� ��ü ����
 * 		-(int , boolean): ��������� ���� �����ϱ�
 * 3.�޼���
 * 		info: number+isKwang?"K":" "���� ����ϱ�.
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


	//SutdaDeck has a SutdaCard ����
class SutdaDeck{
		SutdaCard cards [] = new SutdaCard[20]; //����ī�带 ������ �������� 20��
		private int number;
		
		SutdaDeck(){		
			for(int i=0; i<cards.length;i++) {   
				//SutdaDeck deck = new SutdaDeck();
				cards[i] = new SutdaCard((i%10)+1,(i==0 || i==2 || i==7)?true:false);	 //		cards[i] = new  �� ��ü�� ���� ���� �־���>SutdaCard
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
				result += c.toString()+","; //result += c+","  c�� ����ī�忡�ִ� toString �޼��尡 ȣ��.
			}
			return result;
		}
	}
	

public class Exam1 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck(); 
		//1K,2,3K,4,5,6,7,8K,9,10,1,2,3,4,5,6,7,8,9,10
		System.out.println(deck); //deck �� toString ����
		deck.shuffle();
		System.out.println(deck);
		System.out.println(deck.pick(0)); //pick�� ȣ��ǰ� index�� ���� 0�̵�
		System.out.println(deck.pick());
	}
}




