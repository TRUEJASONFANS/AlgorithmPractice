package LeetCode;


public class RotateArray  {
	
	/**
	 * 该方法有点类似于希尔排序的，间隔为k的的元素之间的位移,
	 * @param nums
	 * @param k
	 */
    public void rotate(int[] nums, int k) {
    	int n = nums.length;
    	k = k % n ;
    	if(n==0||n==1)
    		return;
    	int idx = 0;
    	int distance = 0,cur = nums[idx];
    	 for (int i = 0; i < n; ++i) {
    	        int next = (idx+k)%n;
    	        int temp = nums[next];
    	        nums[next] = cur;
    	        idx = next;
    	        cur = temp;

    	        // If distance is back. Move it one step forward.
    	        distance = (distance+k)%n;
    	        if (distance == 0) {
    	            idx = (idx+1)%n;
    	            cur = nums[idx];
    	        }
    	    }
    }

	public static void main(String args[]) {
		int []nums = new int[]{1,2,3,4};
		new RotateArray().rotate(nums,2);
		for(int a : nums) {
			System.out.print(a+"\t");
		}
	}

}

