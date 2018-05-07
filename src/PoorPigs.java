
public class PoorPigs {
	public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // Number of tests that can be conducted = (int) (minutesToTest/minutesToDie+1)
		// Number of scenarios that has to be covered = buckets
		// Let total number of pigs = X
		// Then, tests ^ X = buckets
		return (int)Math.ceil(Math.log(buckets) / Math.log((int) (minutesToTest/minutesToDie+1)));
    }
}
