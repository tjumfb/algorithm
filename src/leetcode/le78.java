package leetcode;

import java.util.ArrayList;
import java.util.List;

public class le78 {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        subsets(new ArrayList<>(),0);
        return res;
    }
    public void subsets(ArrayList<Integer> cut, int index){
        if(index == nums.length){
            res.add(cut);
            return;
        }
        ArrayList<Integer> take = new ArrayList<>(cut);
        take.add(nums[index]);
        subsets(take,index+1);
        ArrayList<Integer> ntake = new ArrayList<>(cut);
        subsets(ntake,index+1);

    }
}
