import java.util.HashMap;

/**
 * Created by Felicity on 2017/2/2.
 * 首先，不能对该数组作任何预处理。因为要求返回是原始数组的下标，如果对数组进行了排序，那么下标就会乱。

 （如果是有序数组，可以用双指针来做，参见Two Sum II - Input array is sorted）

 很容易想到用<value, index>的映射表。

 遍历numbers，在映射表中寻找target-numbers[i].

 若找到则结束，返回存储的下标+1和当前下标+1. （注意题目中规定，以1作为起始下标）

 若找不到则将<numbers[i], i>加入映射表。
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
             if (hashmap.get(target - nums[i]) != null) {
                int[] result = {hashmap.get(target-nums[i]) + 1, i + 1};
                return result;
            } else {
                 hashmap.put(nums[i], i);
             }

        }
        return result;
    }
}
