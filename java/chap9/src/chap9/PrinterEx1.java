package chap9;
class LazerZet implements Printerable{
	@Override
	public void print() {
		System.out.println("������ Printer���� �����");
	}
}

class InkZet implements Printerable{
	@Override
	public void print() {
		System.out.println("��ũ�� Printer���� �����");
	}
}

class PrinterManager{
	//Printerable: Printerable �������̽��� ������ü�� ����
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
