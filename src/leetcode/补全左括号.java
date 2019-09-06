package leetcode;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class 补全左括号 {
    private static String complete(String source){
        Stack<String> vals = new Stack<>();
        Stack<String> ops  = new Stack<>();
        for(int i = 0; i < source.length(); i++){
            Character temp = source.charAt(i);
            if(Character.isDigit(temp)) vals.push(""+temp);
            else if(temp.equals('+')||temp.equals('+')||temp.equals('*')||temp.equals("/")){
                ops.push(""+temp);
            }else if(temp.equals(')')){
                String v1 = vals.pop();
                StringBuffer s = new StringBuffer();
                s.append("(").append(vals.pop()).append(ops.pop()).append(v1).append(")");
                vals.push(s.toString());
            }
        }
        return vals.pop();
    }
    public static void main(String[] args) {
        String aim = "2+3)*4+5))";
        StdOut.println(complete(aim));
    }
}
