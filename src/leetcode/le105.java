package leetcode;

import util.TreeNode;

public class le105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0, preorder.length-1,0,inorder.length-1);
    }
    private TreeNode buildTree(int[] preorder, int[] inorder, int pre_lo,int pre_hi, int in_lo, int in_hi){
        if(in_lo == in_hi) return new TreeNode(inorder[in_hi]);
        if(pre_lo >= pre_hi || pre_hi >= preorder.length) return null;

        int val = preorder[pre_lo];
        TreeNode root = new TreeNode(val);
        int i;
        for(i = in_lo; i <= in_hi; i++){
            if(inorder[i] == val) break;
        }

        root.left = buildTree(preorder,inorder,pre_lo+1,pre_lo+i-in_lo,in_lo,i-1);
        root.right = buildTree(preorder,inorder,pre_lo+i+1-in_lo,pre_hi,i+1,in_hi);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,3,4};
        int[] in = {1,2,3,4};

        TreeNode root = new le105().buildTree(pre,in);
        TreeNode.preorder(root);
        System.out.println();
        TreeNode.inorder(root);
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
//        TreeNode.inorder(root);
    }
}
