/**
 * Created by Felicity on 2017/2/2.
 * 循环，只要x不等于0，先对x除以10取余数，设置result为0，把得到的余数与result*10以后的值相加，得到新的值newresult，然后
 * 再反向运算，如果溢出，即x超过int的取值范围，那么得到的值也就不是原来那个result了。这时候直接输出return 0，如果没
 * 有溢出，那么把newresult的值赋给result，x赋值为x/10，举个例子，x=12345，x除以10取余数为5，
 * newresult为5+0*10=5，反向运算得到（5-5）/10=0=result，说明没有溢出；接着result被赋值为5，x/10=1234,。再对x取
 * 余数，得到4，newresult=4+5*10=54，然后把newresult赋值给result，即54，如此循环下去最终得到reverse integer
 *
 */
public class Solution {
    public int reverse(int x) {
        int result = 0;
        int mod = x % 10;
        while (x != 0) {
            int newresult = result * 10 + mod;
            if ((newresult - mod) / 10 != result) {
                return 0;
            }
            result = newresult;
            x = x / 10;
        }
        return result;
    }
}
