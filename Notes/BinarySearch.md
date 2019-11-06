# Binary Search

## Suitable for
- Sorted Elements
- Find smallest integer that satifies a contidtion (in this case the target must be valid)
- O(1) space requirement
- O(log(n)) time requirement

## Code
### Find the index of exact number

```java
while (left <= right) {
    int mid = left +  (right - left) / 2;
    if (nums[mid] < target) {
        left = mid + 1;
    } else if (nums[mid] > target) {
        right = mid - 1;
    } else {
        return mid;
    }
}
return -1;
```

### Find the index of smallest number
Search in [Left, right)
```java
// returns the index of smallest number in range [l, right)
// such that g(m) is true. Returns right if not found
int binarySearch(int left, int right) {

    while (left < right) {
        int mid = left + (right - left) / 2;
        if (g(mid) == true) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }

    return left;
}
```

![](assets/binary-search-1.png)

## Check correctness of code

Here is a helpful tip to quickly prove the correctness of your binary search algorithm during an interview. We just need to test an input of size 2. Check if it reduces the search space to a single element (which must be the answer) for both of the scenarios above. If not, your algorithm will never terminate.

## Tips

Use `L + (R-L) / 2` instead of  `(R+L) / 2` to avoid overflow.

If you are setting mid = (left + right)/2, you have to be very careful. Unless you are using a language that does not overflow such as Python, left+right could overflow. One way to fix this is to use mid = left + (right - left)/2 instead.

