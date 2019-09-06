package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Josephus {
    public static void main(String[] args) {
        int N = 7,M = 2;
        List<Integer> people = new ArrayList<>();
        for(int i = 0; i < N; i++) people.add(i);
        int index = 0;
        while (!people.isEmpty()){
            index = (index+M-1)%people.size();
            System.out.print(people.get(index)+" ");
            people.remove(index);
        }
    }
}
