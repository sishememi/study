package chap12;

public class e190918 {
	 public static void main(String[] args) {
	  
	  String fullPath = "c:/jdk12/work/Test.java";
	  String path="";
	  String fileName = "";
	  
//	  String f = new String(fullPath);
//	  path=f.substring(0,13);
//	  fileName=f.substring(14);
	  //����� ����
	  int idx = fullPath.lastIndexOf("/");
	  path=fullPath.substring(0, idx);
	  fileName=fullPath.substring(idx+1);
	  
	  System.out.println("fullPath:" + fullPath);
	  System.out.println("path:" + path);
	  System.out.println("fileName:" + fileName);
	 }
	}
	 

//class Card {
//	 String kind;
//	 int num;
//	 
//	 Card(String kind,int num){
//		 this.kind=kind;
//		 this.num=num;
//	 }
//	 Card(){
////		 kind="Spade";
////		 num=1;
//		 this("Spade",1);//����Թ���
//	 }
//	 //toString() : Object Ŭ������ ���
//	 // 			��ü�� ���ڿ� ǥ�ø� ���� �޼���.
//	 //				 ���������̸��� ���ڿ��� ǥ���Ҷ� �ڵ� ȣ��Ǵ� �޼���
//	 // Object Ŭ����:
//	 //		       Ŭ������@16���� �ؽ��ڵ尪
//	 public String toString() {
//		 return "("+kind+","+num+")";
//	 }
//	 //equals �޼��� : Object Ŭ���� ���. ��� Ŭ������ ��ü���� ���� ����.
//	 //				 ������ ���Ҷ� ���. ������ Ŭ�������� �������̵� �ʿ�.
//	 @Override
//	 public boolean equals(Object o) {
//		 if(o instanceof Card) {
//			 Card c = (Card) o;
////			 if(kind==c.kind && num==c.num) {
////				 return true;
////			 }else return false;
////		 }
////		return false;
//			 return kind.equals(c.kind) && num==c.num;
//		 }else return false;//����� ����
//	 }
//}
//
//	public class e190918 {
//	 public static void main(String[] args) {
//	  Card c1 = new Card("Spade",1);
//	  Card c2 = new Card();
//	  if(c1==c2) {
//	   System.out.println("c1�� c2�� ���� ��ü�Դϴ�.");
//	  } else {
//	   System.out.println("c1�� c2�� �ٸ� ��ü�Դϴ�.");
//	  }
//	  if(c1.equals(c2)) {
//	   System.out.println("c1�� c2�� ���� ������ ī�� �Դϴ�.");
//	  } else {
//	   System.out.println("c1�� c2�� �ٸ� ������ ī�� �Դϴ�.");
//	  }
//	  System.out.println("c1 ī�� :" + c1);
//	  System.out.println("c2 ī�� :" + c2);
//	 }
//	}