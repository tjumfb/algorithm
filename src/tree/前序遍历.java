package tree;

import java.util.Stack;

public class 前序遍历 {
    public static void recursivePre(Node root){
        if (root != null){
            System.out.println(root.val);
            recursivePre(root.left);
            recursivePre(root.right);
        }
    }
    public static void nonrecursivePre(Node root){
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.empty()){
            while (root != null){
                System.out.println(root.val);
                if(root.right != null) stack.push(root.right);
                root = root.left;
            }
            if(!stack.empty()){
                root = stack.pop();
            }
        }

    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

//        recursivePre(root);
        nonrecursivePre(root);
    }
}
