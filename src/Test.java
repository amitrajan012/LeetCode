
public class Test {
	public static void main(String[] args)  {
		StringBuilder sb = new StringBuilder();
		int num = -7;
		sb.append(num%7);
		num /= 7;
		sb.append(num);
		System.out.print(sb.toString());
	}
}
