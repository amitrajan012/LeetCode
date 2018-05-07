import java.util.HashSet;
import java.util.Set;

public class Test {
public static void main(String[] args)  {
	Set<Character> row1 = new HashSet<Character>() {{
		add('q');add('w');add('e');add('r');add('t');add('y');add('u');add('i');add('o');add('p');
	}};
	System.out.print(row1.contains('q'));
	}
}
