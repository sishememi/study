package chap8;
/*
 * final ���� �Ұ�.
 * final method: ������ �Ұ�. �������̵� �Ұ� �޼���.
 * */
public class FinalMethod {
	final void finalMethod() { //�������̵� �Ұ� �޼���
		System.out.println("finalMethod �������̵� �Ұ�");
	}
}

class SubMethod extends FinalMethod{
	void finalMethod() {
		System.out.println("finalMethod �������̵� �Ұ�");
	}
}

