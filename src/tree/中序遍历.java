package tree;

import java.util.Stack;

public class 中序遍历 {
    public static void recursiveIn(Node root){
        if (root != null){
            recursiveIn(root.left);
            System.out.println(root.val);
            recursiveIn(root.right);
        }
    }
    public static void nonrecursiveIn(Node root){
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.empty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.empty()){
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
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

//        recursiveIn(root);
        nonrecursiveIn(root);
    }


    }

