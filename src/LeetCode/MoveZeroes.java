package LeetCode;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int countZero = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==0) {
                countZero++;
            }
            else {
                exchange(i,i-countZero,nums);
            }
        }
    }
    
    public void exchange(int index1,int index2,int[] nums) {
        if (index1 == index2) {
			return;
		}
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp; 
    }

	public static void main(String[] args) {

	}

}
