package easy;

public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		//Solution approach: Single character column name count = 26 [Max integer value = 26]
		//Double character column name count = 26^2 [Max integer value = 26 + 26^2]
		//Triple character column name count = 26^3 [Max integer value = 26 + 26^2 +26^3] and so on .......
		//Hence this is a base 26 problem, i.e. We have to convert the number to base 26
		//Need to subtract 1 as 1 is mapped to A rather than 0
		String title = "";
		while(n != 0) {
			int temp = (n-1) % 26;
			title = (char) ('A' + temp) + title;
			n = (n-1)/26;
		}
		return title;
	}
}
