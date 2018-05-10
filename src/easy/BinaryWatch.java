package easy;
import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
	public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        //Need to left shift hour to leave the minutes bit intact as a total of 5 bits are needed to represent minutes
        for(int h=0;h<12;h++) {
        		for(int m=0;m<60;m++) {
        			if (Integer.bitCount((h << 6) | m) == num) {
        				result.add(h + ":" + ((m < 10) ? ("0" + m) : m));
                 }
        		}
        }
        return result;
    }
}
