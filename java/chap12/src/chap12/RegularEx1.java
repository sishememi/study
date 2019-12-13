package chap12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * ���� ǥ���� ����
 */
public class RegularEx1 {
	public static void main(String[] args) {
		String [] patterns = {".","[a-z]?","[0-9]+","^[0-9]","[a-z]*","[a-z]+",
				"02|010","\\s","\\S","\\d","\\w","\\W"};
		String [] datas = {"","a","1","12","012","abc","02"," ","A","5","*"};
			for(String d : datas) {
				if(d.equals("")) {
					System.out.print("���� \"\"�� ���� =>");
				}else if(d.equals(" ")) {
					System.out.print("���� ���� \" \" �� ���� =>");
				}else {
					System.out.print(d+"������ ���� =>");
				}
				
			for(String p : patterns) {
				Pattern pattern = Pattern.compile(p);
				Matcher m = pattern.matcher(d);
				if(m.matches()) {
					System.out.print(p+" ,");
				}
			}
			System.out.println();
				
		}
	}

}
