package chap11;

import java.util.Scanner;

/*
 * ������ ���ܸ� �����
 */
public class ExeptionEx8 {
	public static void main(String[] args) {
		try {
			String id="hong";
			String pw="1234";
			Scanner scan = new Scanner(System.in);
			System.out.println("���̵� �Է��ϼ���");
			String inputId = scan.nextLine();
			System.out.println("��й�ȣ�� �Է��ϼ���");
			String inputPw = scan.nextLine();
			if(id.equals(inputId) && pw.equals(inputPw)) {
				System.out.println("�α��� ����");
			}else if(!id.equals(inputId)) {
				throw new LoginFailException
				("���̵� Ʋ���ϴ�. �ٽ÷α��� �ϼ���");
			}else
				throw new LoginFailException
				("��й�ȣ�� Ʋ���ϴ�. �ٽ� �α��� �ϼ���");
		}catch(LoginFailException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
class LoginFailException extends Exception{
	LoginFailException(String msg){
		super(msg);
	}

}
