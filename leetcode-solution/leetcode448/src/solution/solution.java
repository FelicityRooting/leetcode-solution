package solution;

import java.util.ArrayList;
import java.util.List;
// 给定的n个元素，每个元素都介于1到n，给出这个条件，首先想到的就是可否将数组中的元素与数组的下标对应起来？
// (这基本可以成为一个套路，当看到这种题目时，首先想到的就是讲数组的元素与数组的下标对应起来）。
// 我们用正负号标记法来解决这道题。首先我们遍历整个数组，当前元素为i，令nums[abs(i)-1]=-abs(nums[abs(i)-1])，
// 即让每个元素所对应的下标的元素值变成一个负值。用一个1-n的数组来代替标志位，开始的时候都赋负值，然后把原数
// 组的数放在应该的位置，然后再重新遍历标志数组，如果为负数则表示缺失。还以上面的例子来说，
// [4, 3, 2, 7, 8, 2, 3, 1]，第一个是4，所以把下标是4的元素变为负数（标志位没有0）, 然后第二个是3，就把下标是3的数
// 变为负数，第三个是2， 把下标是2的数变为负数，现在我们得到了[4, -3, -2, -7, 8, 2, 3, 1], 然后接着变负数，对于已
// 经变成负数的数，不用再变一次，经过这个操作后数组变为：[-4, -3, -2, -7, 8, 2, -3, -1]。然后再次对数组进行遍历，
// 将值为正数对应的下标加1即为求得结果（这时候下标有0）。处理的后的数组有两个正值，分别为8,2，它们对应的下标为4和5，
// 加1后变为5和6，则未出现的数值为[5, 6]。
public class solution {//正负标记法

    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> b = new ArrayList();//新建一个数组b
        if (nums==null || nums.length==0) {
            return b;
        }
        for (int i=0; i<nums.length; i++) {//遍历数组
            int d = Math.abs(nums[i])-1;//将下标取绝对值再减1
            if (nums[d]>0) {
                nums[d] = -nums[d];//赋值负数
            }
        }
        for (int i=0; i<nums.length; i++) {//再次遍历数组
            if (nums[i]>0) {
                b.add(i+1);//将值为正数对应的下标加1即为求得结果赋值到数组b里
            }
        }
        return b;
    }
}
