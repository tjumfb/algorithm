package tree;

import java.util.Stack;

class BNode{
    boolean visited = false;
    Node n;
    BNode(Node root){
        n = root;
    }
}

public class 后序遍历 {
    public static void recursivePost(Node root){
        if (root != null){
            recursivePost(root.left);
            recursivePost(root.right);
            System.out.println(root.val);
        }
    }
    public static void nonrecursivePost(Node root){
        Stack<BNode> stack = new Stack<>();
        while (root != null || !stack.empty()){
            while (root != null){
                BNode temp = new BNode(root);
                stack.push(temp);
                root = root.left;
            }
            if(!stack.empty()){
                if(!stack.peek().visited){
                    stack.peek().visited = true;
                    root = stack.peek().n.right;
                    }
                else {
                    System.out.println(stack.pop().n.val);
                }
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

//        recursivePost(root);
        nonrecursivePost(root);

    }


}
