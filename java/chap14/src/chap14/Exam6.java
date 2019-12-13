package chap14;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/*
 * TreeMap : key순으로 정렬 (tree),key와 값의 쌍(Map)
 * 정렬 : comparable, comparator
 */
public class Exam6 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		deck.shuffle();
		List<Player> list = Arrays.asList(
				new Player("타짜",deck.pick(),deck.pick()),
				new Player("고수",deck.pick(),deck.pick()),
				new Player("중수",deck.pick(),deck.pick()),
				new Player("하수",deck.pick(),deck.pick()),
				new Player("물주",deck.pick(),deck.pick())
				);
		
		TreeMap<Player,Integer> rank = new TreeMap<Player,Integer>
											(new Comparator<Player>() {
			@Override
			public int compare(Player p1, Player p2) {	
				int result = p1.getPoint()-p2.getPoint(); //Player의 점수를기준으로 낮은순에서 높은순으로 정렬.(오름차순)
				if(result == 0) {
					result = p1.name.compareTo(p2.name);
				}
				return result;//return result* -1 내림차순정렬;
			}
			
		});
		for(Player p : list) {
			rank.put(p ,p .getPoint());
		}
		System.out.println(rank);
	}
}
