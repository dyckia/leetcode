/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // store all nodes in an array list;
        List<Integer> array = new ArrayList<>();
        for (ListNode i : lists) {
            while(i != null) {
                array.add(i.val);
                i = i.next;
            }
        }
        
        // sort the array
        Collections.sort(array);
        
        // create a new linked list
        ListNode dummy = new ListNode(-1);
        ListNode cur=dummy;
        
        for (int i = 0; i<array.size(); i++) {
            cur.next = new ListNode(array.get(i));
            cur=cur.next;
        }
        cur.next = null;
        
        return dummy.next;
    }
}