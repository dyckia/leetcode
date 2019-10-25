# Binary Search

## Suitable for
- Sorted Elements
- Find smallest integer that satifies a contidtion (in this case the target must be valid)
- O(1) space requirement
- O(log(n)) time requirement

## Code
### Find the index of exact number

```java
binary search 

while left <= right
mid = floor( (l + r) /2 )
left = mid+1
right = mid-1

while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
return -1;
```



### Find the index of smallest number

## Check correctness of code

Here is a helpful tip to quickly prove the correctness of your binary search algorithm during an interview. We just need to test an input of size 2. Check if it reduces the search space to a single element (which must be the answer) for both of the scenarios above. If not, your algorithm will never terminate.

## Tips

Use `L + (R-L) / 2` instead of  `(R+L) / 2` to avoid overflow.

If you are setting mid = (left + right)/2, you have to be very careful. Unless you are using a language that does not overflow such as Python, left+right could overflow. One way to fix this is to use mid = left + (right - left)/2 instead.



