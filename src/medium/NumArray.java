package medium;
/*
 * https://leetcode.com/problems/range-sum-query-mutable/description/
 */
class NumArray1 {
	int[] sumArray;
	int[] numArray;
    public NumArray1(int[] nums) {
    		if(nums == null || nums.length == 0) return;
        sumArray = new int[nums.length];
        numArray = new int[nums.length];
        sumArray[0] = nums[0];
        numArray[0] = nums[0];
        for(int i=1;i<nums.length;i++) {
        		sumArray[i] = sumArray[i-1] + nums[i];
        		numArray[i] = nums[i];
        }
    }
    
    public void update(int i, int val) {
        int temp = numArray[i];
        for(int j=i;j<sumArray.length;j++) {
        		sumArray[j] = sumArray[j] - temp + val;
        }
        numArray[i] = val;
    }
    
    public int sumRange(int i, int j) {
        return (i>0) ? (sumArray[j] - sumArray[i-1]) : (sumArray[j]);
    }
}

//Solution based on segment tree
class NumArray {
	int[] tree;
	int n;
    public NumArray(int[] nums) {
    		if(nums.length > 0) {
    			n = nums.length;
    			tree = new int[2*n];
    			buildTree(nums);
    		}
    }
    
    private void buildTree(int[] nums) {
    		for(int i=n; i<2*n; i++) {
    			tree[i] = nums[i-n];
    		}
		for(int i=n-1;i>0;i--) {
			tree[i] = tree[2*i] + tree[2*i+1];
		}
	}

	public void update(int i, int val) {
    		i += n;
    		tree[i] = val;
    		while(i>0) {
    			int left = i, right = i;
    			if(i%2 == 0) right = i+1;
    			else left = i-1;
    			tree[i/2] = tree[left] + tree[right];
    			i /= 2;
    		}
    }
    
    public int sumRange(int l, int r) {
    		l += n;
    		r += n;
    		int sum = 0;
    		while(l <= r) {
    			if(l%2 == 1) {
    				sum += tree[l];
    				l++;
    			}
    			if(r%2 == 0) {
    				sum += tree[r];
    				r--;
    			}
    			l /= 2;
    			r /= 2;
    		}
    		return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
