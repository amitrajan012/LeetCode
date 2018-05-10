package easy;

public class FirstBadVersion {
	public int firstBadVersion(int n) {
		int start = 1, end = n;
		while(start<end) {
			int mid = start+(end-start)/2;
			if(isBadVersion(mid)) {
				end = mid;
			}else {
				start = mid+1;
			}
		}
		return start;
    }

	//API that returns whether the version is BAD or not
	private boolean isBadVersion(int n) {
		return false;
	}
}
