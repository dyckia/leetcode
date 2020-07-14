/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // since we only have access to the node to be deleted
        // and it is a singly linked list
        // we can't get access to its previous node
        // however, we can change the value of this node to its next node's value
        // and delete the next node instead
        node.val = node.next.val;
        node.next = node.next.next;

    }
}