package chap9;
class LazerZet implements Printerable{
	@Override
	public void print() {
		System.out.println("레이저 Printer에서 출력함");
	}
}

class InkZet implements Printerable{
	@Override
	public void print() {
		System.out.println("잉크젯 Printer에서 출력함");
	}
}

class PrinterManager{
	//Printerable: Printerable 인터페이스의 구현객체를 리턴
	public static Printerable getPrinter(String type) {
		if(type.equals("INK"))
			return new InkZet();
		else
			return new LazerZet();
	}
}
public class PrinterEx1 {
	public static void main(String[] args) {
		Printerable able = PrinterManager.getPrinter("INK");
		able.print();
		able = PrinterManager.getPrinter("LAZER");
		able.print();
	}

}
