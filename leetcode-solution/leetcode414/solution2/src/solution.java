/**
 * Created by Felicity on 2016/12/14.
 */
public class solution {
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for ( Integer x ; nums) {
            if (x.equals(max1) || x.equals(max2) || x.equals(max3) ) {
                continue;
            }

            if (max1 == null || x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if(max2 == null || x > max2) {
                max3 = max2;
                max2 = x;
            } else if(max3 == null || x > max3) {
                max3 = x;
            }
        }
        return max3 == null ? max1 : max3;
    }
}
