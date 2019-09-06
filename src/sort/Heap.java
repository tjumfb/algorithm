package sort;

import java.util.ArrayList;

public class Heap {
    int[] nums ;
    private int size = 0;
    private int N;
    Heap(int maxsize){
        nums = new int[maxsize+1];
        N = maxsize;
    }
    public void pr(){
        System.out.println("capcity: "+N);
        for(int i = 1; i <= size; i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
    private void exc(int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    private boolean less(int i, int j){
        return nums[i] < nums[j];
    }

    public void insert(int a){
        if(size < N){
            nums[++size] = a;
            swim(size);
        }
        else {
            N *= 2;
            int[] t = new int[N+1];
            for(int i = 0; i < nums.length; i++){
                t[i] = nums[i];
            }
            nums = t;
            nums[++size] = a;
            swim(size);
        }

    }

    public void swim(int index){
        while (index > 1 && nums[index/2] < nums[index]){

                exc(index/2,index);
                index /= 2;

        }
    }

    public void sink(int index, int bound){
        while (2 * index <= bound){
            int j = 2 * index;
            if(j < bound && nums[j] < nums[j+1]) j++;
            if(nums[index] >= nums[j]) break;
            exc(index,j);
            index = j;
        }
    }

    public void sort(){
        int i = size;
       while (i > 1){
            exc(1,i);
            sink(1,--i);
        }
    }

    public int getkMax(int k){
        sort();
        return nums[size-k+1];

    }
}

class TestHeap{
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        Heap heap = new Heap(nums.length);
        for(int i: nums){
            heap.insert(i);
        }
        System.out.println(heap.getkMax(2));
    }
}