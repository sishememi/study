package chap7;

//public class ex190903 {
//	public static void main(String[] args) {
////1. ��!!!		
//		int arr[] = {50,7,5,8,1,33,16,2,28,25,29,17,44,15,13,9,31}; 
//		int[][] arr2 = new int [5][5];
//		int index=0;
//		//arr�迭 �������� ����
//		for(int i=0;i<arr.length;i++){
//			boolean check = false;
//			for(int j=0;j<arr.length-i-1;j++){
//				if(arr[j]>arr[j]+1){
//					int temp=arr[j];
//					arr[j]=arr[j+1];
//					arr[j+1]=temp;
//					check = true;
//					}
//				}
//			 	if(!check) break; //check �� �ƴϸ�..
//			}		  
//		 for(int i=0;i<=arr2.length/2;i++) {
//			 for(int j=1;j<arr2.length-i;j++) {
//				 arr2[i][j]=arr[index++];
//			 }
//		 }
//		    
//		  for (int i=arr2.length/2+1;i<arr2.length;i++) {
//		   for(int j=arr2.length-i-1;j<=i;j++) {
//			   arr2[i][j] = arr[index++];
//
//		   	 }
//		 }
//		  
//		  
//		  for(int i=0; i<=arr2.length; i++) {
//			   for(int j=i;j<arr2[i].length-i;j++) {
//			   		if(arr2[i][j]==0)
//			   			System.out.printf("5%c",j++);
//			   	 }
//			  }		
//
//	}
//}
//		

//
//class Coin{
//	int side;
//	static int sno;
//	int serialNo;
//	String t;
//	void flip() {  //�Լ��� ���������� �����ϴ¤� ������ ����..
//		side=(int)(Math.random()*2); //0<= random<1  => 0<= random <2
//		if(side==0) {
//			
//			t="�ո�";
//			
//			}else
//			{
//				t="�޸�";
//			}
//		
//	}
//	
//	public String toString() {
//		return serialNo+"�� ����:"+ t;
//	}
//
//}
//public class ex190903 {
//	public static void main(String[] args) {
//		Coin c [] = new Coin[10];
//		int totalf=0;
//		int totalb=0;
//	
//		for(int i=0;i<c.length;i++) {
//			c[i] = new Coin();
//			c[i].serialNo= ++Coin.sno;
//			c[i].flip();	
//			if(c[i].side==0) totalf++;
//			else totalb++;
//				
//			System.out.println(c[i]);
//		}
//		System.out.println("��ü �ո� ������ ����:"+totalf);
//		System.out.println("��ü �޸� ������ ����:"+totalb);
//	}
//}
 //3�� ����Թ���
//
//class Coin{
//	int side,serialNo;
//	static int sno;
//	
//	void flip() {
//		side = (int)(Math.random()*2);
//	}
//	
//	public String toString() {
//		return serialNo+"������:"+((side==0)?"�ո�":"�޸�");
//		}
//}
//
//public class ex190903 {
//	public static void main(String[] args) {
//		Coin coinarr[] = new Coin[10];
//		int [] cntarr = new int[2];//�ո� �޸�
//		for(int i=0; i<coinarr.length;i++) {
//			coinarr[i] = new Coin();
//			coinarr[i].serialNo= ++Coin.sno;
//			coinarr[i].flip();
//			System.out.println(coinarr[i]);
//			cntarr[coinarr[i].side]++;
//		}
//		System.out.println("��ü �ո鵿���� ����:"+cntarr[0]);
//		System.out.println("��ü �޸鵿���� ����:"+cntarr[1]);
//	}
//}



//  class Animal{ 
//	  String name; 
//	  int age;
//  
//  void eat() { 
//	  System.out.println("���ְ� ���"); 
//	  } 
//  } 
//  public class ex190903 {
//	  public static void main(String[] args) {
//		  Animal m = new Animal();
//		  m.name="������";
//		  m.age=20;
//  
//  System.out.println("�̸�(name):"+m.name); 
//  System.out.println("����(age)"+m.age);
//  m.eat(); 
//  
//	  } 
//}
 