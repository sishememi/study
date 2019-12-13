package chap14;


import java.util.Comparator;
import java.util.TreeSet;

/*
 * ClassCastException: ��ü�� ������������ ����
 * Comparable:�̸����θ� ����
 * Comparator: �ٸ��ɷ� ���İ���
 * 
 * ����
 * ���� ���� �������̽�
 * Comparable �������̽�: �߻�޼��� compareTo(Object)
 * 					      Ŭ������ �⺻ ���� ��� ����
 * Comparator �������̽�: �߻�޼��� compare(Object o1, Object o2)
 * 					      �⺻���� ��� ��� �������� �ʰ� ����ڰ� ���Ƿ� ���� ����� ����
 */
class Phone implements Comparable<Phone>
{
   String name;
   int number;
   public Phone(String name, int number) {
      super();
      this.name = name;
      this.number = number;
   }
   public String toString()
   {
      return "(" + name + "," + number + ")";
   }
@Override
	public int compareTo(Phone p) {//compareTo��  Comparable�� �����ϴ� �޼���
	return name.compareTo(p.name);
	}
}
public class SetEx4 {

   public static void main(String[] args) {
	   	System.out.println("�̸������� ���");
	   	TreeSet<Phone> set = new TreeSet<>();
	   	  set.add(new Phone("ȫ�浿",1234));
	      set.add(new Phone("���",3456));
	      set.add(new Phone("�̸���",5678));
	      System.out.println(set);
	      
	      System.out.println("��ȭ��ȣ ������ ���");
	   set = new TreeSet<>(new Comparator<Phone>() 
      {//TreeSet ��ü�� ���������� Comparable �������̽��� �����ؾ��Ѵ�..
         @Override
         public int compare(Phone p1, Phone p2) 
         //Comparator ������ ������  compareTo ����.
         {
            return p1.number-p2.number;
         }
      }); // �̸����� �ܺ� Ŭ���� ���
//      TreeSet<Phone> set = new TreeSet<>(); 
      set.add(new Phone("ȫ�浿",1234));
      set.add(new Phone("���",3456));
      set.add(new Phone("�̸���",5678));
      System.out.println(set);
      
      System.out.println("�̸��� �������� ���");
      set = new TreeSet<>(Comparator.reverseOrder()); //Comparator.reverseOrder()������ ����� ���   
      set.add(new Phone("ȫ�浿",1234));
      set.add(new Phone("���",3456));
      set.add(new Phone("�̸���",5678));
      System.out.println(set);
      
      System.out.println("��ȭ��ȣ�� �������� ���");
      set = new TreeSet<>(new Comparator<Phone>(){
    	  @Override
    	  public int compare(Phone p1,Phone p2) {
    		  return p2.number-p1.number; //(p1.number-p2.number) * -1
    	  }
      }); //Comparator.reverseOrder()������ ����� ���   
      set.add(new Phone("ȫ�浿",1234));
      set.add(new Phone("���",3456));
      set.add(new Phone("�̸���",5678));
      System.out.println(set);
   }

}