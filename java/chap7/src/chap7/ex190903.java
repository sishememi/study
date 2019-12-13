package chap7;

//public class ex190903 {
//	public static void main(String[] args) {
////1. 모름!!!		
//		int arr[] = {50,7,5,8,1,33,16,2,28,25,29,17,44,15,13,9,31}; 
//		int[][] arr2 = new int [5][5];
//		int index=0;
//		//arr배열 내림차순 정렬
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
//			 	if(!check) break; //check 가 아니면..
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
//	void flip() {  //함수는 실행하지만 전달하는ㄱ ㅏㅄ은 없다..
//		side=(int)(Math.random()*2); //0<= random<1  => 0<= random <2
//		if(side==0) {
//			
//			t="앞면";
//			
//			}else
//			{
//				t="뒷면";
//			}
//		
//	}
//	
//	public String toString() {
//		return serialNo+"번 동전:"+ t;
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
//		System.out.println("전체 앞면 동전의 갯수:"+totalf);
//		System.out.println("전체 뒷면 동전의 갯수:"+totalb);
//	}
//}
 //3번 강사님버전
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
//		return serialNo+"번동전:"+((side==0)?"앞면":"뒷면");
//		}
//}
//
//public class ex190903 {
//	public static void main(String[] args) {
//		Coin coinarr[] = new Coin[10];
//		int [] cntarr = new int[2];//앞면 뒷면
//		for(int i=0; i<coinarr.length;i++) {
//			coinarr[i] = new Coin();
//			coinarr[i].serialNo= ++Coin.sno;
//			coinarr[i].flip();
//			System.out.println(coinarr[i]);
//			cntarr[coinarr[i].side]++;
//		}
//		System.out.println("전체 앞면동전의 갯수:"+cntarr[0]);
//		System.out.println("전체 뒷면동전의 갯수:"+cntarr[1]);
//	}
//}



//  class Animal{ 
//	  String name; 
//	  int age;
//  
//  void eat() { 
//	  System.out.println("맛있게 얌얌"); 
//	  } 
//  } 
//  public class ex190903 {
//	  public static void main(String[] args) {
//		  Animal m = new Animal();
//		  m.name="원숭이";
//		  m.age=20;
//  
//  System.out.println("이름(name):"+m.name); 
//  System.out.println("나이(age)"+m.age);
//  m.eat(); 
//  
//	  } 
//}
 