package leetcode;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

public class le101 {
//    public boolean isSymmetric(TreeNode root) {
//        return isMirror(root, root);
//    }
//
//    public boolean isMirror(TreeNode t1, TreeNode t2) {
//        if (t1 == null && t2 == null) return true;
//        if (t1 == null || t2 == null) return false;
//        return (t1.val == t2.val)
//                && isMirror(t1.right, t2.left)
//                && isMirror(t1.left, t2.right);
//    }
//
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/symmetric-tree/solution/dui-cheng-er-cha-shu-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    LinkedList<Integer> left = new LinkedList<>();
    LinkedList<Integer> right = new LinkedList<>();

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        TreeNode lNode = root.left;
        TreeNode rNode = root.right;

        Stack<TreeNode> stack = new Stack<>();

        while (lNode != null || !stack.empty()){
            while (lNode != null){
                left.add(lNode.val);
                if(lNode.right != null) stack.push(lNode.right);
                lNode = lNode.left;
            }
            if(!stack.empty()){
                lNode = stack.pop();
            }
        }

        while (rNode != null || !stack.empty()){
            while (rNode != null){
                right.add(rNode.val);
                if(rNode.left != null) stack.push(rNode.left);
                rNode = rNode.right;
            }
            if(!stack.empty()){
                rNode = stack.pop();
            }
        }

        while (!left.isEmpty() && !right.isEmpty()){
            if(!left.poll().equals(right.poll())) return false;
        }

        return left.isEmpty() && right.isEmpty();
    }

}
