package chap12;
/*
 * ������ ���� ���ǵ� �޼��带 �ۼ��ϰ� �׽�Ʈ�Ͻÿ�.
 * �޼����: String format(String str,int len,int align)
 * ���: �־��� ���ڿ��� ������ ũ���� ���ڿ��� ��ȯ.
 * 		������ ������ �������� ä���.
 * 		(0: ���� ����, 1: ��� ����, 2: ������ ����)
 */
public class Exam5 {
	public static void main(String[] args) {
		String str = "������";
		System.out.println(format(str,7,0));
		System.out.println(format(str,7,1));
		System.out.println(format(str,7,2));
		System.out.println(format(str,2,0));
	}
	static String format(String str,int len,int align) {
		
		if(str.length() >= len) { //���̸�ŭ ����..	
			return str.substring(0,len);
		} 
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<len;i++) {
			sb.append(" ");
		}
		int l = len - str.length(); //len > str.length() 
		switch(align) {
		case 0 : sb.replace(0, str.length(),str);	break;		//����  ����
		case 1 : sb.replace(l/2, str.length()+l/2, str);break;	//��� ����
		case 2 : sb.replace(l, str.length()+l, str);	break;	//������ ����
		}
		return sb.toString();
	}
}
