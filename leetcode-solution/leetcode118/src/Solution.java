import java.util.ArrayList;
import java.util.List;

/**
 * Created by Felicity on 2017/1/18.
 */
// ArrayList的get方法
// 每一层的第i个位置，等于上一层第i-1与第i个位置之和。
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();//建立最终结果的数组
        if (numRows <=0){//如果给出的数为0，则输出数组，这一步其实不需要
            return triangle;
        }
        for (int i=0; i<numRows; i++){ //遍历每一行
            List<Integer> row =  new ArrayList<Integer>();//建立每一行的数组
            for (int j=0; j<i+1; j++){//遍历每一行的每一列
                if (j==0 || j==i){//头尾分别为1
                    row.add(1);
                } else {
                    row.add(triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j));//每一层的第i个位置等于上一层第i-1与第i个位置之和
                }
            }
            triangle.add(row);//结果数组加上新一行数组
        }
        return triangle;//返回结果
    }
}
