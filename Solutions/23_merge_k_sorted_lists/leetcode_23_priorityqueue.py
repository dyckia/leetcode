# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

from queue import PriorityQueue

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:

        head = cur = ListNode(-1)
        q = PriorityQueue()

        for l in lists:
            if l:
                q.put((l.val, l))

        while not q.empty():
            val, node = q.get()
            if node.next:
                q.put((node.next.val, node.next))
            cur.next = node
            cur = cur.next

        return head.next
