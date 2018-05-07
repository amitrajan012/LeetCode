import java.util.ArrayList;
import java.util.Scanner;

public class ClosestNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> input = new ArrayList<Integer> ();
		int sum = 0;
		int count = 0;
		String line = scan.nextLine();
		String[] a = line.split(" ");
		for(int i=0;i<a.length;i++) {
			int temp = Integer.valueOf(a[i]);
			sum = sum + temp;
			count++;
			input.add(temp);
		}
		scan.close();
		float avg = (float)sum/ (float) count;
		
		int indexClosest = 0;
		float differenceClosest = Integer.MAX_VALUE;
		for(int i=0;i<input.size();i++) {
			if(Math.abs(avg - input.get(i)) < differenceClosest) {
				indexClosest = i;
				differenceClosest = Math.abs(avg - input.get(i));
			}
			if(differenceClosest == 0) {
				break;
			}
		}
		System.out.println(input.get(indexClosest));
	}

}
