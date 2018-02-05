import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Felicity on 2017/3/22.
 */
public class solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }

        Arrays.sort(nums);
        helper(results, new ArrayList<Integer>(), nums, 0);
        return results;
    }
    private void helper(ArrayList<ArrayList<Integer>> results,
                        ArrayList<Integer> subset,
                        int[] nums,
                        int startIndex) {
        results.add(new ArrayList<Integer>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            /*
            startIndex指的是nums的元素下标，以nums为[1,1',1'']为例，如果
            startIndex是0，那么subset是[1]，如果startIndex是1，那么subset是[1,1']。
             */
            if (i != 0 && nums[i] == nums[i - 1] && i > startIndex) {
                continue;
            }
            subset.add(nums[i]);
            helper(results, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
