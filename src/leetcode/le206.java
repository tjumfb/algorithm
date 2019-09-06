package leetcode;


import util.ListNode;

//  反转链表
public class le206 {
//    递归
//    class 全排列 {
//        public ListNode reverseList(ListNode head) {
//            if(head == null || head.next == null) return head;
//            ListNode temp = head.next;
//            ListNode res = reverseList(head.next);
//            temp.next = head;
//            head.next = null;
//            return res;
//        }
//    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode pre = head;
            ListNode cur = head.next;

            while (cur != null){
                pre.next = cur.next;
                cur.next = head;
                head = cur;
                cur = pre.next;
            }

            return head;
        }
    }

}
