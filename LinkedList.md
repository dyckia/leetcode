# LinkedList

1. Use data structure to track visited nodes (mostly **O(n)** or more space complexity)
   - hash set
   - stack
2. Use multiple pointers
   - faster pointer moves twice fast than slow pointer (*find middle node*, *find cyclic list*)
   - faster pointer moves n steps ahead of slow pointer
   - when faster pointer reaches the end, reset (*find intersection node*)
3. Manipultate node.next pointer
   - reverse list/node pairs
   - remove node (skip next node to next next node)
   - unweave two interweaved node lists L138
4. Use recursion
5. Get the length of the LinkedList (take len%k to avoid traverse mutiple time) **L61**
6. Attach tail to head, and break at certain node **L61**
7. To save memory space used by hash map(tracking relationship between node in old list and node in new list), interweave the old list and the new list so new list can mimic the action from the old list. **L138**
8. Create a dummy head