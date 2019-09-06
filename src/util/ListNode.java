package util;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x){
        val = x;
    }
    public void pr(){
        ListNode l = this;
        while (l != null){
            System.out.print(l.val+" ");
            l = l.next;
        }
        System.out.println();
    }
}
