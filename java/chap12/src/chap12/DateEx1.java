package chap12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Date 클래스 예제
 * SimpleDateFormat : 형식화 클래스.
 *		Strig format(Date) : Date 타입의 객체를 형식화된 문자열로 변경하여 리턴.
 *		Date parse(String) : 형식화된 문자열을 Date 객체로 리턴.
 */
public class DateEx1 {
	public static void main(String[] args) {
		Date now = new Date(); //현재시간 객체 리턴, 현재시간의 객체를 만들어 now에 생성.
		System.out.println(now);
		//SimpleDateFormat : 날짜를 문자열 변경.
//							  문자열 날짜로 변경 가능.
		/*
		 * yyyy : 년도는 4자리 출력
		 * MM : 월
		 * dd : 일자
		 * HH : 0 ~ 23시
		 * hh : 1 ~ 12시
		 * mm : 분
		 * ss : 초
		 * E  : 요일
		 * a  : 오전,오후
		 */
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
		String dispDate = sf.format(now);
		System.out.println(dispDate);
//		System.out.println(sf.format(now));//format 내가 지정한형식으로바꾸는거
		String  strDate = "2019-09-21";
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd");//yyyy-MM-dd형식으로 들어온 걸 format 시킬수 있다.
		Date day = null;
		try {
			day = sf2.parse(strDate);//parse 문자형 => 날짜형
		}catch(ParseException e) {
			e.printStackTrace();
		}
		System.out.println(day);
		System.out.println(sf.format(day));
		
		//문제: 2019년 12월 31일의 요일 출력하기.
		//		단 입력값은 "2019년 12월 31일"형태로
		//   	    출력값은 "2019-12-31 날짜의 요일은 ??요일 입니다."
		
		strDate = "2019년 12월 31일";
		SimpleDateFormat sf3 = new SimpleDateFormat("yyyy년MM월dd일");//yyyy년MM월dd일형식으로 받을수 있게 sf3객체에 format 시킬수 있다.
		try {
		day = sf3.parse(strDate); //년,월,일 을 알고 parse시킴
		}catch(ParseException e){
			e.printStackTrace();
		}
		SimpleDateFormat sf4 = new SimpleDateFormat("yyyy-MM-dd날짜의 요일은  E요일 입니다.");
		System.out.println(sf4.format(day)+"날짜의 요일은");
	}
}
