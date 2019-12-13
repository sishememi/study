package chap5;
/*
 *
 * Switch 구문에 사용되는 자료형
 * 		=> byte,short,int,char,String (O)
 * Switch 구문에 사용되지 않는 자료형
 * 	 	=> boolean,long,float,double (X)
 * 
 * 조건문: if, switch
 * 	 모든  switch구문은  if문으로 변경 가능함.
 * 	 모든  if구문을 switch문으로 변경할 수 없다. 변경 가능한것도 있고 변경 불가능한 것도 있다.
 */
 
public class SwitchEx2 {

	public static void main(String[] args) {
		int value =1; //String value=1+"";
		switch(value) {
		//범위 지정 안됨.
		case 1:System.out.println(value);break;
		case 2:System.out.println(value);break;
		default:System.out.println(value);break;
		}

	}

}
