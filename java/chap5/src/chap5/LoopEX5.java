package chap5;
/*
 * �׿� ���
 * break: �ݺ����̳� switch ������ ����
 * continue: �ݺ����� ó������ ��� �̵�
 */
public class LoopEX5 {
	public static void main(String[] args) {
	for(int i=2;i<=9;i++) {
			System.out.println("\n"+i+"��");
			for(int j=1;j<=9;j++) {
				//if(j==5)break;
				if(j==5)continue;
				System.out.println(i+"*"+j+"="+(i*j));
			}
		}
	
	}
}
