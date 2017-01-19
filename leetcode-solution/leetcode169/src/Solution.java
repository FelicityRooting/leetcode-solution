/**
 * Created by Felicity on 2017/1/17.
 */
//“投票算法”，设定两个变量candidate和count。candidate保存当前可能的候选众数，count保存该候选众数的出现次数。
// 遍历数组num。 如果当前的数字e与候选众数candidate相同，则将计数count + 1
// 否则，如果当前的候选众数candidate为空，或者count为0，则将候选众数candidate的值置为e，并将计数count置为1
// 否则，将计数count - 1
// 最终留下的候选众数candidate即为最终答案。
// 以上算法时间复杂度为O(n)，空间复杂度为O(1)
//可比喻为，因为比别人多还有另外一种解释，就是你的票抵消了我的一部分票后，我还有剩。
public class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int a=nums[0];
        for (int i =0; i<nums.length; i++) {
            if (count == 0) {
                a=nums[i];
                count=1;
            } else if (a==nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return a;
    }
}
