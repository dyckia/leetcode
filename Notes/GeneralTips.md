## Index boundary in loops

Boundary check should come before conditional check in `for loop` or `while loop`.

```java
while (i < nums.length - 1 && nums[i] < nums[i+1]) //correct

while (nums[i] < nums[i+1] && i < nums.length - 1) //wrong
```

## while lopp vs for loop

Use `while loop` instead of `for loop` if we want to keep the value of `i` after the loop.

## HashMap
If the key range is finite and simple, we can use array instead


## Ceil Integer Division
What you would need to do to achieve the results you want is Math.ceil(3/2.0)
(p + m - 1) / m equal to ceil(p / m) (just personal behavior)
(p-1) / m + 1

## 
Integer[] cache //default value is null
int[] cache //default value is 0