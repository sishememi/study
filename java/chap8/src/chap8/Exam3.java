package chap8;

import java.util.Scanner;

/*
 * ��� ��ǰ(food)�� ����(price)�� ����Ʈ(point)�� ����� ������.
 * ��ǰ�� ��ü ������ ������ �Է¹޾ƾ��ϰ�, ������ 10%�� ����Ʈ�� �����Ѵ�.
 * �ķ�ǰ�� ������ ����(Fruit),����(Drink),����(Snack) �� ������.
 * ���� Ŭ������ �絵(brix)��,  ����� �뷮(ml), ���ڴ� ����(kg)�� ����ΰ�����.
 * ������ �����δ� �ݶ�(Cock)�� ���̴�(Sider)
 * ������ �����δ� ��Ŷ(Biscuit)�� ��Ű(Cookie) �� �ִ�.
 * ���,������,�ݶ�,���̴�,��Ŷ,��Ű Ŭ������ toString() �޼��带 �����ϰ�
 * ������ �̸��� �����Ѵ�.
 * 
 * ����� ������ ������ ���ݰ� �絵��,
 * �ݶ�,���̴� ������ ���ݰ� �뷮��,
 * ��Ŷ�� ��� ������ ���ݰ� ���Ը� �Է¹޾� ��ü�� �����Ѵ�.
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
		return "���";
	}
}
class Peach extends Fruit{
	
	Peach(int price,double brix){
		super(price,brix);
	}
	public String toString() {
		return "������";
	}
	
}
class Cock extends Drink{
	
	Cock(int price,int ml){
		super(price,ml);
	}
	public String toString() {
		return "�ݶ�";
	}
}
class Sider extends Drink{
	
	Sider(int price,int ml){
		super(price,ml);
	}
	public String toString() {
		return "���̴�";
	}
}
class Biscuit extends Snack{
	
	Biscuit(int price,int kg){
		super(price,kg);
	}
	public String toString() {
		return "��Ŷ";
	}
}

class Cookie extends Snack{
	
	Cookie(int price,int kg){
		super(price,kg);
	}
	public String toString() {
		return "��Ű";
	}
}
/*
 * Buyer2 Ŭ���� �����ϱ�
 * ���� ���� ����Ʈ ��ٱ��ϸ� ����� ������.
 * �� �ķ�ǰ ���� �Ǽ��� ������.
 * �޼���:
 * 		buy(Food):
 * 			���� ���Ž� �����ݾ׿��� ��ǰ���ݸ�ŭ ����
 * 			��ǰ�� ����Ʈ ��ŭ ����Ʈ ����.
 * 			���� �ݾ׺��� ��ǰ���� ū ��� "�ܾ׺���" �޼��� ����ϰ� �޼��� ����
 * 			��ǰ�� ��ǰ��� ������ ȭ�鿡 ���.
 * 			�ش� ��ǰ�� ��ٱ��Ͽ� �߰�.
 * 		summary() :
 * 			��ٱ��ϸ� ��ȸ�Ͽ� ������ ��ǰ�� ��ϰ� �� ���ݰ� ���� ����Ʈ�� ����ϱ�.
 * 			������ ����, ���� ���� �ݾ�,���� ���� ���
 * 			������ ����, ���� ���� �ݾ�,���� ���� ���
 * 			������ ����, ���� ���� �ݾ�,���� ���� ��� ����ϱ�.
 * */

class Buyer2 {
	int money=10000;
	int point;
	Food cart[] = new Food[20];
	int cnt;
	
	void buy(Food f) {
		if(money<f.price) {
			System.out.println(f+"���Ž� �ܾ׺���");
			return;
		}
		money -= f.price;
		point += f.point;
		System.out.println(f+": ����= "+f.price+"����");
		cart[cnt++]=f;
	}
	
	void summary(){
		int total=0,ftotal=0,dtotal=0,stotal=0;
		int fcnt=0,dcnt=0,scnt=0;
		String flist="",dlist="",slist="";
		
		for(Food f: cart) {
			if(f==null) break;
			total += f.price;
			//���� �Ǽ�, ���� �ݾ�(�ٽ�)
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
		System.out.println("�ѱ��� �ݾ�:"+total+", �ѱ��ŰǼ�:"+cnt);
		System.out.println("���ϱ��� �ݾ�:"+ftotal+", ���ϱ��ŰǼ�:"+fcnt);
		System.out.println("���� ���� ���:"+ flist);
		
		System.out.println("���ᱸ�� �ݾ�:"+dtotal+", ���ᱸ�ŰǼ�:"+dcnt);
		System.out.println("���� ���� ���:"+ dlist);
		
		System.out.println("���ڱ��� �ݾ�:"+stotal+", ���ڱ��ŰǼ�:"+scnt);
		System.out.println("���� ���� ���:"+ slist);
	}
}
public class Exam3 {
	public static void main(String[] args) {
		Apple apple = new Apple(1000,10.5); //����,�絵(birx)
		System.out.println("��� ����:"+apple.price);
		System.out.println("��� �絵:"+apple.brix);
		Peach peach = new Peach(1000,13.5);//����,�絵(birx)
		Cock cock = new Cock(500,500);//���� ,�뷮(ml)
		Sider sider = new Sider(1500,1500);//����,�뷮(ml)
		Biscuit bis = new Biscuit(1000,500);//����,����(kg)
		Cookie cookie = new Cookie(500,5000);//����,����(kg)
		Buyer2 b = new Buyer2();
		b.buy(apple);
		b.buy(peach);
		b.buy(cock);
		b.buy(sider);
		b.buy(bis);
		b.buy(cookie);
		System.out.println("�� �ܾ�:"+b.money);
		System.out.println("�� ����Ʈ: "+b.point);
		b.summary();
	
//		System.out.println(peach);
//		System.out.println(cock);
//		System.out.println(sider);
//		System.out.println(bis);
//		System.out.println(cookie);
			
	}
}
