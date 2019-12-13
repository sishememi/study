package chap14;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * 1.���ѹα�(����),ĳ����(��Ÿ��),����(����),������(����)�� HashMap�� �����ϰ�
 * ȭ�鿡�� �����̸��� �Է¹޾�, �ش糪���� ������ ����ϴ� ���α׷� �ۼ��ϱ�.
 * 2.��ϵ� ���� �ƴ� ��� "��ϵ� ������ �����ϴ�. ����Ͻðڽ��ϱ�?(���:Y)"
 * =>y,Y�� ��� ������ ����ϱ�.
 * 3.���α׷� ���� ���� ���� ��ϵ� ����� ���� ����� ����ϱ�
 * 
 */
public class Exam4 {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String, String>();
		String [] national = {"���ѹα�","ĳ����","����","������"};
		String [] city = {"����","��Ÿ��","����","����"};
		
		for(int i=0; i<national.length;i++) {
			map.put(national[i], city[i]);
		}//System.out.println(map);
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("���� �Է��ϼ���[����,ĳ����,����,������]/(����:��) : ");
			String nt = scan.next();
		
			if(nt.equals("��")) 
			{
				Set<Map.Entry<String, String>> entry = map.entrySet();
				for(Map.Entry<String,String > m : entry)
				{
					System.out.println(m.getKey()+"�� ����: "+m.getValue());
				}
				System.out.println("����");
				break;
			}
	
			else if(map.get(nt)==null)
			{
				System.out.println("��ϵ� ������ �����ϴ�. ����Ͻðڽ��ϱ�?(���:Y or y):");
				String y = scan.next();
				if(y.equalsIgnoreCase("y")|| y.equalsIgnoreCase("Y")) {
						System.out.println("������ ����ϼ���");
						String c = scan.next();
						map.put(nt, c);
						System.out.println("��ϵǾ����ϴ�.");	
				}	
			}
			else System.out.println(nt+"�� ������ "+map.get(nt));	
		}
		//entrySet()�޼���
		for(Map.Entry<String, String> k : map.entrySet()) {
			System.out.println(k);
		}
		//keySet()�޼���
		for(String k : map.keySet()) {
			System.out.println(k+"="+map.get(k));
		}
	}
}
