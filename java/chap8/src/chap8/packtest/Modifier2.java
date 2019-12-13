package chap8.packtest;
/*
 * class 의 접근제어자는  protected, private 쓸 수 없다.
 * */
public class Modifier2 {
	private int v1 = 10;
			int v2 = 20;
	protected int v3 = 30;
	public int v4 = 40;
	
	public String toString() {
		return  v1+","+v2+","+v3+","+v4+",";
	}
}

