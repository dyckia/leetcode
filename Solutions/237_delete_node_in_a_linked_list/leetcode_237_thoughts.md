# [LeetCode 237](https://leetcode.com/problems/delete-node-in-a-linked-list/) - Delete Node in a Linked List

Since we only have access to the node to be deleted, and it is a singly linked list. 

We can't get trace to its previous node. However, we can change the value of this node to its next node's valuecand delete the next node instead.

