package LeetCode;

public class HouseRobber {

	public int rob(int[] nums) {
		if(nums==null||nums.length==0)
			return 0;
		int re[] = new int[nums.length + 1];
		re[0] = 0;
		re[1] = nums[0];
		for (int i = 2; i <= nums.length; i++) {
			re[i] = Math.max(re[i - 2] + nums[i-1], re[i - 1]);
		}
		return re[nums.length];
	}

}
