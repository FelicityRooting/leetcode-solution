import java.util.Arrays;

/**
 * Created by Felicity on 2016/12/14.
 */
public class solution {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        if (nums.length<=1) {
            return false;
        } else {
            for (int i=1;i<nums.length;i++) {
                if (nums[i]==nums[i-1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
