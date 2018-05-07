import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PairNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> input = new ArrayList<Integer> ();
		String line = scan.nextLine();
		String[] a = line.split(" ");
		for(int i=0;i<a.length;i++) {
			int temp = Integer.valueOf(a[i]);
			input.add(temp);
		}
		int sum = Integer.valueOf(scan.nextLine().trim());
		scan.close();
		
		ArrayList<Integer> tempList = new ArrayList<>(input);
		
		ArrayList<Integer> result = new ArrayList<Integer> ();
		for(int i=0;i<input.size();i++) {
			tempList.remove((Integer)(input.get(i)));
			if(tempList.contains(sum-input.get(i))) {
				if(input.get(i) < sum-input.get(i)) {
					result.add(input.get(i));
				}else {
					result.add(sum-input.get(i));
				}
				tempList.remove((Integer)(sum-input.get(i)));
			}
		}
		
		Collections.sort(result);
		
		for(int i=0;i<result.size();i++) {
			System.out.print(result.get(i));
			System.out.print(" ");
			System.out.print(sum - result.get(i));
			System.out.print("\n");
		}
	}

}
