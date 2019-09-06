package leetcode;

import util.TreeNode;

public class le543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        System.out.println(l+" "+r+" "+root.val);
        max = Math.max(l+r+1,max);
        return Math.max(l,r)+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        new le543().diameterOfBinaryTree(root);
    }
}
