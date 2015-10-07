package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer> ();
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                int curK = i - map.get(nums[i]);
                if(curK<=k) {
                    return true;
                }
            }
            map.put(nums[i],i);
        }
        return false;
    }

	public static void main(String[] args) {

	}

}
