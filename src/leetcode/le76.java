package leetcode;

import java.util.HashMap;

public class le76 {
    HashMap<Character,Integer> windows = new HashMap<>();
    HashMap<Character,Integer> needs = new HashMap<>();
    public String minWindow(String s, String t) {
        for(int i = 0; i < t.length(); i++){
            int count = needs.getOrDefault(t.charAt(i),0);
            needs.put(t.charAt(i),count+1);
        }
        int match = 0, left = 0, right = 0, len = Integer.MAX_VALUE, start = 0;

        while (right < s.length()){
            char c = s.charAt(right);
            if(needs.containsKey(c)){
                int count = windows.getOrDefault(c,0);
                windows.put(c,count+1);
                if(count+1 == needs.get(c))
                    match++;
            }
            right++;

            while (match == needs.size()){
                if(right-left < len){
                    len = right-left;
                    start = left;
                }
                char c1 = s.charAt(left);
                if(windows.containsKey(c1)){
                    int count = windows.get(c1);
                    windows.put(c1,count-1);
                    if(count-1 < needs.get(c1))
                        match--;
                }
                left++;
            }
        }


    return len == Integer.MAX_VALUE? "":s.substring(start,start+len);
    }
}
