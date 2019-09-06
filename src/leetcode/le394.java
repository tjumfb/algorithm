package leetcode;

import java.util.Stack;

public class le394 {
//    非递归
//    static public String decodeString(String s) {
//        Stack<Integer> nums = new Stack<>();
//        Stack<StringBuffer> cs = new Stack<>();
//        StringBuffer num = new StringBuffer();
//
//        for(int i = 0; i < s.length(); i++){
//            while (Character.isDigit(s.charAt(i))) {
//                num.append(s.charAt(i));
//                i++;
//            }
//            if(num.length()!=0){
//            nums.push(Integer.parseInt(num.toString()));
//            num = new StringBuffer();
//            }
//            if (s.charAt(i)!=']'){
//                StringBuffer sb = new StringBuffer();
//                sb.append(s.charAt(i));
//                cs.push(sb);
//            }
//            else {
//                StringBuffer stringBuffer = new StringBuffer();
//                StringBuffer temp;
//                while (!"[".equals((temp = cs.pop()).toString())){
//                    stringBuffer = temp.append(stringBuffer);
//                }
//                StringBuffer res = new StringBuffer();
//                int times = nums.pop();
//                for (int j = 0; j < times; j++){
//                    res.append(stringBuffer);
//                }
//                cs.push(res);
//            }
//
//        }
//        StringBuffer res = new StringBuffer();
//        while (!cs.isEmpty()){
//            res = cs.pop().append(res);
//        }
//        return res.toString();
//    }
     public String decodeString(String s) {
        return recursiveDecode(1, new StringBuffer(s));
    }
     public String recursiveDecode(int times, StringBuffer s){
         StringBuffer it = new StringBuffer();
         StringBuffer res = new StringBuffer();
         for(int i = 0; i < s.length();){
             if(!Character.isDigit(s.charAt(i))) {
                 {
                     it.append(s.charAt(i));
                     i++;
                 }
             }else {
                 StringBuffer num = new StringBuffer();
                 while (Character.isDigit(s.charAt(i))){
                     num.append(s.charAt(i));
                     i++;
                 }
                 StringBuffer temp = new StringBuffer();
                 int count = 1;
                 i++;
                 while (true){
                     if(s.charAt(i)=='['){
                         temp.append('[');
                         count++;
                         i++;
                     }
                     else if(s.charAt(i)==']'){
                         count--;
                         i++;
                         if(count == 0) break;
                         temp.append(']');
                     }
                     else {
                         temp.append(s.charAt(i));
                         i++;
                     }
                 }
                 it.append(recursiveDecode(Integer.parseInt(num.toString()),temp));
             }
         }
         for(int i = 0; i < times; i++){
             res.append(it);
         }
         return res.toString();

     }
    public static void main(String[] args) {
        System.out.println(new le394().decodeString("3[a2[c]]"));
    }
}
