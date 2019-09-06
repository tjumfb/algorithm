package leetcode;

import util.TreeNode;

import java.util.Stack;

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        return root.val + "[" + serialize(root.left) + "," + serialize(root.right) + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }
}
public class le297 {
}
