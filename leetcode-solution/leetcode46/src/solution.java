import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by fl222 on 2017/7/12.
 */
public class solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        Arrays.sort(nums);
        helper(results, new ArrayList<Integer>(), nums);
        return results;
    }
    private void helper(List<List<Integer>> results,
                        List<Integer> permutes,
                        int[] nums) {
        //当permutes的长度与nums的长度一致时才加紧results里
        if (nums.length == permutes.size()) {
            results.add(new ArrayList<Integer>(permutes));
            return;
        }
        //从i=0到i=2，一个一个与permutes里已有的元素对比，如果有了就跳过到下一个，没有就添加
        for (int i = 0; i < nums.length; i++) {
            if (permutes.contains(nums[i])) {
                continue;
            }
            permutes.add(nums[i]);
            helper(results, permutes, nums);
            permutes.remove(permutes.size() - 1);
        }
    }
}
