package leetcode;

import util.ListNode;
import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class le226 {
//    public TreeNode invertTree(TreeNode root) {
//        inverse(root);
//        return root;
//    }
//    public void inverse(TreeNode root){
//        if(root == null) return;
//        TreeNode left = root.left;
//        root.left = root.right;
//        root.right = left;
//        invertTree(root.left);
//        invertTree(root.right);
//    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if(cur.left != null) queue.add(cur.left);
            if(cur.right != null) queue.add(cur.right);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(9);
        new le226().invertTree(treeNode);
    }
}
