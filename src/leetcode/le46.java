package leetcode;

import java.util.ArrayList;
import java.util.List;

public class le46 {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i:nums){
            list.add(i);
        }
        permute(list, new ArrayList<>());
        return lists;
    }
    public void permute(ArrayList<Integer> list, ArrayList<Integer> res){
        if(list.isEmpty()){
            lists.add(res);
            return;
        }
        for(int i = 0; i < list.size(); i++){
            ArrayList<Integer> temp = new ArrayList<>(list);
            ArrayList<Integer> res_t = new ArrayList<>(res);
            res_t.add(temp.get(i));
            temp.remove(i);
            permute(temp,res_t);
        }
    }

    public static void main(String[] args) {

    }

}
