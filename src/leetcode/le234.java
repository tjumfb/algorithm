package leetcode;

import util.ListNode;

public class le234 {

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
//        fast 指向null,有偶数个节点
//        fast 不为null,有奇数个节点
        if(fast != null){
            slow = slow.next;
        }
        slow = reverseList(slow);
        while (slow != null){
            if(slow.val == head.val) {
                slow = slow.next;
                head = head.next;
            }
            else return false;
        }
        return true;
    }
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode temp = head.next;
        ListNode res = reverseList(head.next);
        temp.next = head;
        head.next = null;
        return res;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l = new le234().reverseList(l);
        l.pr();
    }

}
