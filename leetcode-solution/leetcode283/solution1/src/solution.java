/**
 * Created by Felicity on 2016/12/14.
 */
public class solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j<nums.length; j++) {
            if(nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }
        for (int m=i; m<nums.length; m++) {
            nums[m]=0;
        }
    }
}
