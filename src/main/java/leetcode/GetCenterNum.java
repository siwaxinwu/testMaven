package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到所有长度为n的中心对称数g
 * 就是翻转180度还是相等的
 * n = 1 :0,1,8
 * n = 2: 11,88,69,96
 * n = 3: 以n = 1的情况，在两边加对称
 * 如果两端添加00合法，则输入n < m
 * 如果两端添加00不合法，则输入n == m √
 */
public class GetCenterNum {
    public static List<String> helper(int n, int m){
        if (n < 0 || m < 0 || n > m){
            throw new IllegalArgumentException("参数非法");
        }
        if (n == 0){
            return new ArrayList<String>(Arrays.asList(""));
        }
        if (n == 1){
            return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        }
        List<String> list = helper(n - 2, m);
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (n != m){
                result.add("0" + s + "0");
            }
            result.add("1" + s + "1");
            result.add("6" + s + "9");
            result.add("8" + s + "8");
            result.add("9" + s + "6");
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> helper = GetCenterNum.helper(3, 3);
        System.out.println(helper);
    }
}
