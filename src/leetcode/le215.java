package leetcode;

import java.util.Arrays;

class Heap{
    public int[] heap;
    int size;
    int capcity;
    Heap(int k){
        heap = new int[k+1];
        capcity = k;
        size = 0;
    }
    public void exc(int i, int j){
        int t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }
    public void pr(){
        for(int i:heap) System.out.print(i+" ");
        System.out.println();
    }
    public void insert(int a){
        if(size < capcity){
            heap[++size] = a;
            swim(size);
        }else {
            if(heap[size]<a){
                heap[size] = a;
                swim(size);
            }
        }
    }
    public void swim(int index){
        while (index > 1 && heap[index/2] < heap[index]){
            exc(index,index/2);
            index /= 2;
        }
    }
    public void delMax(){
        if(size != 0){
            heap[1] = heap[size--];
            sink(1);
        }
    }
    public void sink(int index){
        while (index*2 <= size){
            int j = index * 2;
            if(j < size && heap[j]<heap[j+1]) j++;
            if(heap[index] >= heap[j]) break;
            exc(index,j);
            index = j;
        }
    }
}
public class le215 {
    public int findKthLargest(int[] nums, int k) {
        Heap heap = new Heap(nums.length);
        for(int i:nums) heap.insert(i);
        for(int i = 0; i < k-1; i++){
            heap.delMax();
        }

        return heap.heap[1];
    }
    public static void main(String[] args) {
        int[] tar = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(new le215().findKthLargest(tar,3));

    }
}
