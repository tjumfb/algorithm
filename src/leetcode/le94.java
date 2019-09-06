package leetcode;


import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class le94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.empty()){
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }

        }
        return res;
    }
}
