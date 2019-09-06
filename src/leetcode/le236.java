package leetcode;

import util.TreeNode;

public class le236 {
    //    TreeNode res;
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        judge(root,p,q);
//       return res;
//    }
//    public boolean judge(TreeNode root, TreeNode p, TreeNode q){
//        if(res != null) return false;
//        if(root == null) return false;
//        boolean b1 = (root == p || root == q);
//        boolean b2 = judge(root.left,p,q);
//        boolean b3 = judge(root.right,p,q);
//
//        if( (b1&&b2) || (b1&&b3) || (b2&&b3) ){
//            res = root;
//            return false;
//        }
//        return b1||b2||b3;
//    }
// LCA 问题
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }
}
