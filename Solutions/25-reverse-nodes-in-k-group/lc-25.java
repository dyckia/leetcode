/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
b              e
   p  c  n
0->1->2->3->4->5->6

   p  c  n
0->1  2->3->4->5->6  
   |______________|

   p  c  n
0->1<-2  3->4->5->6  
   |______________|
    
            p  c  n
0->1<-2<-3<-4  5->6  
   |______________|
   
   
            p  c  n
0  1<-2<-3<-4->5->6
|  |________|__|
|___________|__|
*/ 


class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        
        ListNode begin = dummyHead;
        ListNode tail = begin.next;
        
        int tailIndex = 1;
        
        while (tail != null) {
            if (tailIndex % k == 0) {
                begin = reverseSection(begin, tail.next);
                tail = begin.next;
            } else {
                tail = tail.next;
            }
            tailIndex++;
        }
            
        return dummyHead.next;
    }
    
    
    // reverse the nodes between begin and end exclusivly
    private ListNode reverseSection(ListNode begin, ListNode end) {
        ListNode newBegin = begin.next;
        ListNode prev = begin.next;
        ListNode cur = prev.next;
        ListNode next;
        
        prev.next = end;
        
        while (cur != end){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        begin.next = prev;
        
        return newBegin;
    }

}