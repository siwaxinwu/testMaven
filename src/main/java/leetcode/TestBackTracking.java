package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *candidates 中的数字可以无限制重复被选取。
 */
public class TestBackTracking {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();//新建堆栈用来判断
        List<List<Integer>> res = new ArrayList<>();//结果集
        if (candidates == null || candidates.length == 0) return res;
        combin(candidates, 0, target, list, res);
        return res;
    }
    //对数组元素（已排序）进行逐个判断以及加入结果集
    private void combin(int[] candidates, int start, int target, List<Integer> list, List<List<Integer>> res) {
        //刚好满足则将结果存入结果集
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i ++) {
            if (candidates[i] <= target) { //判断是否已经大于target
                list.add(candidates[i]);//将第一个元素存入
                combin(candidates, i, target -candidates[i] , list, res);//继续判断进栈元素
                list.remove(list.size() - 1);//不满足则将最后一个元素移除，进栈新元素判断
            }
        }
    }
}


