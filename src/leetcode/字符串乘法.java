package leetcode;

public class 字符串乘法 {
    static public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        int[] res = new int[num1.length()+num2.length()];
        for(int i = 0; i < res.length; i++){
            res[i] = 0;
        }
        for(int i = 0; i < num1.length(); i++){
            for(int j = 0; j < num2.length(); j++){
                res[i+j+1] += (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        int c = 0;
        for(int i = res.length-1; i>=0; i--){
            res[i] += c;
            c = res[i] / 10;
            res[i] = res[i] % 10;
        }
        StringBuffer sb = new StringBuffer();
        for(int i:res){
            sb.append(i);
        }
        if(sb.charAt(0) == '0'){
            return sb.substring(1);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
       System.out.println( multiply("9","9"));
    }
}
