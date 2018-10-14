import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StreamDemo {

	public static void main(String[] args) {
		// find start with r names
		List<String> ll=new ArrayList<String>();
		
		ll.add("x");
		ll.add("h");
		ll.add("a");
		ll.add("k");
		ll.add("r");
		ll.add("c");
		ll.add("r");
		
		List<String> filteredList =new ArrayList<String>();
		
		for(String s:ll) {
			
			if(s.startsWith("r")) {
				filteredList.add(s);
			}
		}
		System.out.println(filteredList.size());
		for(String name:filteredList) {
			
			System.out.println(name);
		}
		
		//using above example with java8streams
		//1 approach
		ll.stream().filter(a-> a.startsWith("r")).forEach(System.out::println);
		
		//using above example with java8streams
		//2nd approach
		Predicate<String> p1= s -> s.startsWith("r");
		
		Consumer<String> c1= c->System.out.println(c);
		
		ll.stream().filter(p1).forEach(c1);
		
		//System.out.println(ll.stream().filter(p1).count());
		
	}

}
