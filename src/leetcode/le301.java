package leetcode;

import java.util.*;

public class le301 {
    LinkedList<String> list = new LinkedList<>();
    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='(') left++;
            if(s.charAt(i)==')'){
                if(left > 0) left--;
                else right++;
            }
        }
        dfs(s,0,left,right);
        HashSet<String> hashSet = new HashSet<>(list);
        list = new LinkedList<>(hashSet);

        return list;
    }
    public void dfs(String s,int st,int left, int right){
//        System.out.println(st + " " +left+" "+right+" "+s);
        if(left==0 && right==0 && check(s)){
            list.add(s);
            return;
        }
        for(int i = st; i < s.length(); i++){
            if(left > 0 && s.charAt(i)=='('){
                dfs(s.substring(0,i)+s.substring(i+1),i,left-1,right);
            }
            if(right > 0 && s.charAt(i) == ')'){
                dfs(s.substring(0,i)+s.substring(i+1),i,left,right-1);
            }
        }
    }
    public boolean check(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='(') count++;
            else if(s.charAt(i)==')') {
                count--;
                if(count < 0) return false;
            }
        }
        if(count != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        List<String> list = new le301().removeInvalidParentheses(")d))");
        for(String s:list) System.out.println(s);
    }

}
