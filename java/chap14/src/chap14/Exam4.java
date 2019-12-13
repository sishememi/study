package chap14;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * 1.대한민국(서울),캐나다(오타와),영국(런던),스위스(베른)를 HashMap에 저장하고
 * 화면에서 나라이름을 입력받아, 해당나라의 수도를 출력하는 프로그램 작성하기.
 * 2.등록된 나라가 아닌 경우 "등록된 수도가 없습니다. 등록하시겠습니까?(등록:Y)"
 * =>y,Y인 경우 수도를 등록하기.
 * 3.프로그램 종료 전에 현재 등록된 나라와 수도 목록을 출력하기
 * 
 */
public class Exam4 {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String, String>();
		String [] national = {"대한민국","캐나다","영국","스위스"};
		String [] city = {"서울","오타와","런던","베른"};
		
		for(int i=0; i<national.length;i++) {
			map.put(national[i], city[i]);
		}//System.out.println(map);
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("나라를 입력하세요[서울,캐나다,영국,스위스]/(종료:끝) : ");
			String nt = scan.next();
		
			if(nt.equals("끝")) 
			{
				Set<Map.Entry<String, String>> entry = map.entrySet();
				for(Map.Entry<String,String > m : entry)
				{
					System.out.println(m.getKey()+"의 수도: "+m.getValue());
				}
				System.out.println("종료");
				break;
			}
	
			else if(map.get(nt)==null)
			{
				System.out.println("등록된 수도가 없습니다. 등록하시겠습니까?(등록:Y or y):");
				String y = scan.next();
				if(y.equalsIgnoreCase("y")|| y.equalsIgnoreCase("Y")) {
						System.out.println("수도를 등록하세요");
						String c = scan.next();
						map.put(nt, c);
						System.out.println("등록되었습니다.");	
				}	
			}
			else System.out.println(nt+"의 수도는 "+map.get(nt));	
		}
		//entrySet()메서드
		for(Map.Entry<String, String> k : map.entrySet()) {
			System.out.println(k);
		}
		//keySet()메서드
		for(String k : map.keySet()) {
			System.out.println(k+"="+map.get(k));
		}
	}
}
