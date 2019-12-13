package chap14;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/*
 * TreeMap : key������ ���� (tree),key�� ���� ��(Map)
 * ���� : comparable, comparator
 */
public class Exam6 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		deck.shuffle();
		List<Player> list = Arrays.asList(
				new Player("Ÿ¥",deck.pick(),deck.pick()),
				new Player("���",deck.pick(),deck.pick()),
				new Player("�߼�",deck.pick(),deck.pick()),
				new Player("�ϼ�",deck.pick(),deck.pick()),
				new Player("����",deck.pick(),deck.pick())
				);
		
		TreeMap<Player,Integer> rank = new TreeMap<Player,Integer>
											(new Comparator<Player>() {
			@Override
			public int compare(Player p1, Player p2) {	
				int result = p1.getPoint()-p2.getPoint(); //Player�� �������������� ���������� ���������� ����.(��������)
				if(result == 0) {
					result = p1.name.compareTo(p2.name);
				}
				return result;//return result* -1 ������������;
			}
			
		});
		for(Player p : list) {
			rank.put(p ,p .getPoint());
		}
		System.out.println(rank);
	}
}
