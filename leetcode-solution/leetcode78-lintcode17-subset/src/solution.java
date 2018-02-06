import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Felicity on 2017/3/21.
 */
class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        // result是最后的结果
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length == 0) {
            return results;//这时候result里面只有[]
        }
        Arrays.sort(nums);//给数组排个序，因为要输出的是按升序排列的
        //找到所有[]开头的子集，放到result里面
        helper(results, new ArrayList<Integer>(), nums, 0);
        return results;
    }
    //递归三要素
    //1.递归的定义：接受什么样的参数，返回什么样的值，做了什么样的事
    //找到所有以subset开头的子集，然后都丢到result里面去
    //result是结果，subset是记录已经有的子集，nums是要输入的整个数组，
    //startIndex是目前已经有的子集的最后一个元素的下标
    //result和subset的前缀不一样是因为一个是list of list of integer, 一个
    //是list of integer啊，第一个 arraylist的类型 是第二个arraylist
    private void helper(ArrayList<ArrayList<Integer>> results,
                        ArrayList<Integer> subset,
                        int[] nums,
                        int startIndex) {
        //2.递归的拆解
        //deep copy
        results.add(new ArrayList<Integer>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);//[]->[1] or [1]->[1,2]
            //比如这时候我要找到所有以[1,2]开头的子集加进去
            helper(results, subset, nums, i + 1);
            //现在[1,2]的找完了，要找[1,3]的，那么就要把[1,2]
            //里最后的一个数去掉
            subset.remove(subset.size() - 1);
        }
        //这里的递归自然而然地退出了
        //3.递归的出口（什么时候不往下递归了，可以直接找到答案退出）
    }
}

