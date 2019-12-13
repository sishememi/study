package chap19;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Collection {

	public static void main(String[] args) {
		List<Figure2> list = Arrays.asList(new Ractangle2(10,3)
				,new Circle2(10),new Rectangle2(2,3));
		Lisn<Figure2> recList = list.stream().filter(s->
			s.type.equals("사각형")).collect(Collectors.toList());
		recList.stream().forEach(f->System.out.println(f));
		System.out.println();
		Set<Figure2> recSet=list.stream().filter(s->
		s.type.equals("사각형")).collect(Collectors.toSet());
		recSet.strem().forEach(f->System.out.println(f));

	}

}
