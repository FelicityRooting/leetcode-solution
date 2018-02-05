/**
 * Created by Felicity on 2017/3/15.
 * 这是比较笨的一种方法
 * 用source的长度减去target的长度，然后再用target去和source挨个比对，如果target的第一个字母对上了就比对第二个，第二个对上了就比对第三个，以此类推，
 * 如果不对，把target往后移一位继续重复刚才的比对
 */
class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        // write your code here 0;
        if (source == null || target == null) {
            return -1;
        }
        for (int i = 0; i < source.length() - target.length() + 1; i++) { //这里是用source的长度减去target的长度
            int j = 0;
            for (j = 0; j < target.length(); j++) { //用target里面的每一个字母去对比
                if (source.charAt(i + j) != target.charAt(j)) { //一旦有不一样的字母，立刻停止
                    break;//break 是结束程序不往下走了，一般用在循环中，终止循环的，continue在循环中表示跳出本次循环，直接进行下一次循环
                }
            }
            if (j == target.length()) { //如果从source的i处，数了j个字母与target的长度相同（也就是和target完全一样），那么就返回那个i值
                return i;
            }
        }
        return -1;
    }
}
