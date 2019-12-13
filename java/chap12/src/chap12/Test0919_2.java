package chap12;

/*
* ���� ����� �������� ���ǵ� �޼��带 �����ϱ�
* �޼���� : fillZero
* ��� : �־��� ���ڿ�(����)�� �־��� ������ ���ڿ���  �����, ���� �� ������ 0���� ä���.
*        ���� �־��� ���ڿ��� null�̰ų� ���ڿ��� ���̰� length�� ���� ������ �״�� ��ȯ�Ѵ�.
*        ���� �־��� length�� ���� 0�� ���ų� ���� ���̸� �� ���ڿ�("")�� ��ȯ�Ѵ�.
* ��ȯŸ�� : String
* �Ű����� : String src, int length
* 

[���]
0000012345

123
null
*/
public class Test0919_2 {
	public static void main(String[] args) {
		String src = "12345";
		System.out.println(fillZero(src, 10));
		System.out.println(fillZero(src, -1));
		System.out.println(fillZero(src, 3));
		System.out.println(fillZero(null, 3));
	}

	static String fillZero(String src, int length) {
		if (src == null || src.length() == length) {
			return src;
		} else if (length <= 0) {
			return "";
		} else if (src.length() >= length)
			return src.substring(0, length);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append("0");
		}
		int b = length - src.length();
		sb.replace(b, src.length() + b, src);

		return sb.toString();
	}
}
