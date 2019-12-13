package chap8;
/*
 * ������ ����
 * Buyer�� ������ǰ �����ϱ�
 * 
 * Product Ŭ����
 *	�������: ����, ����Ʈ
 *	������: ������ �Է¹ް�, ������ 10%�� ����Ʈ�� ����.
 *
 * Tv Ŭ����
 *	 ������ 100 �����ϱ�
 *	toString () �޼��忡�� Tv�� ����.
 *
 *  Computer Ŭ����
 *	 ������ 200 �����ϱ�
 *	toString () �޼��忡�� Computer�� ����.
 *
 *  SmartPhone Ŭ����
 *	 ������ 150 �����ϱ�
 *	toString () �޼��忡�� SmartPhone�� ����.
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
	
	Tv(){ //������ ���
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
 * Buyer Ŭ����
 * 	�������: money = 500, point
 * 		   cart = new Product[3];
 * 		   cnt;
 *  ����޼���: buy(Product p)
 *  		 p ��ǰ�� ���ݸ�ŭ ���� money���� ����.
 *  		 p ��ǰ�� ����Ʈ��ŭ ���� point ����.
 *  		  ȭ�鿡 ������ ��ǰ�� ���
 *    		 cart�� ��ǰ �߰�.
 *  		 
 *  		 summary()
 *  			1.�� ������ ��ǰ�� ���ݰ� ����Ʈ ���.
 *  			2.��ü ���� ��ǰ ����.
 *  			3.��ü ���� ��ǰ ��� ���.
 * */
class Buyer {
	int money= 500;
	int point;
	Product cart[] = new Product[3]; //����������ִ� īƮ
	int cnt; //���� ���԰���;
	
	void buy(Product p) {  //Ƽ��,��ǻ��,����Ʈ���� �ѹ��� ������.
			money -= p.price;
			point += p.point;
			System.out.println(p+" ������");
			cart[cnt++]=p;		  //���� ������ ��ü�� Ƽ��,��ǻ��,����Ʈ��
	}
	
	void summary() {
		int sum=0;
		String productlist="";
		//����Թ���
//		for(Product p : cart) {
//			if(p==null) break;
//			System.out.println(p+"��ǰ : ����="+p.price+", ����Ʈ="+p.point);
//			 sum += p.price;
//			 productlist += p+", ";
//		}
		for(int i=0;i<cart.length;i++) {
		System.out.println(cart[i]+"��ǰ : ����="+cart[i].price+", ����Ʈ="+cart[i].point);
		 sum += cart[i].price;
		 productlist += cart[i]+", ";
		}
	System.out.println("�� ��ǰ���ž�:"+sum);
	System.out.println("�� ��ǰ���� ���:"+productlist);
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
		System.out.println("������ �ܾ�:"+b.money);
		System.out.println("������ ��������Ʈ:"+b.point);
		System.out.println("========���� ��ǰ ����========");
		b.summary();
	}
}