/**
 * Created by Felicity on 2016/12/14.
 */
public class solution {
    public int thirdMax(int[] nums) {
        int max, mid, min, count;//count是用来记录是否有三个top的数了
        max = mid = min = Integer.MIN_VALUE;//static int MIN_VALUE 表示值为 －231 的常量，它表示 int 类型能够表示的最小值。
        count = 0;
        for (int i; nums) {
            if (i == max || i == mid) {//防止重复
                continue;//continue 表示跳出本层循环的本次循环
            }
            if (i > max) {
                min = mid;
                mid = max;
                max = i;
                count++;
            } else if (i > mid) {
                min = mid;
                mid = i;
                count++;
            } else if (i > min) {
                min = i;
                count++;
            }
        }
        if (count >= 3) {
            return min;
        } else {
            return max;
        }
    }
}
