package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class 全排列 {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 使用哈希表检测一个数字是否使用过
        boolean[] used = new boolean[len];
        for(boolean b:used) b = false;
        Stack<Integer> stack = new Stack<>();

        backtrack(nums, 0, len, used, stack, res);
        return res;
    }
    private void backtrack(int[] nums, int depth, int len, boolean[] used, Stack<Integer> stack, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                used[i] = true;
                stack.push(nums[i]);
                backtrack(nums, depth + 1, len, used, stack, res);
                stack.pop();
                used[i] = false;
            }
        }
    }
}