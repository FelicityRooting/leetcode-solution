import java.util.ArrayList;
import java.util.List;

/**
 * Created by Felicity on 2016/12/25.
 */

//正负号标记法，这里nums的数有3种情况：出现1次，出现2次，出现0次。我们找第二种。出现2次，比如element 8出现2次，
// 那么我们按照element的值来走到下一个的时候，会有2次走到nums[8]。 标记一下，这样下次来的时候就知道了。。
// 比如把正的换成负的，下次来的时候发现是个负数，就知道我们来过一次。当然，想赢的根据element的值来走的时候，
// 如果是负数，要换成正数。。
public class solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> b = new ArrayList<>();
        if (nums.length <= 1) return b;
        for (int i = 0; i < nums.length; i++) {
            int d = Math.abs(nums[i]) - 1;
            if (nums[d] < 0) {
                b.add(d+1);
            }else {
                nums[d] = -nums[d];
            }
        }
        return b;
    }
}
