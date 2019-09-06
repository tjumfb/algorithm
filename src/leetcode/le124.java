package leetcode;

import util.TreeNode;

public class le124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSumR(TreeNode root) {
        if(root == null) return 0;
        int left = maxPathSumR(root.left);
        int right = maxPathSumR(root.right);

        // 当前节点为路径最高点
        int case1 = root.val;
        if(left > 0) case1 += left;
        if(right > 0) case1 += right;
        max = Math.max(max,case1);
        System.out.println("case1:"+case1+ " "+root.val+" "+ left + " " + right + " " + max);

        //  路径最高点在节点之上，返回当前能提供的最大值
        int case2 = root.val;
        int a = Math.max(left,right);
        if(a > 0) case2 += a;
        System.out.println("case2:"+case2);
        return case2 > 0? case2:0;
    }

    public int maxPathSum(TreeNode root) {
        maxPathSumR(root);
        return max;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
        int max = new le124().maxPathSum(root);
        System.out.print(max);
    }
}
