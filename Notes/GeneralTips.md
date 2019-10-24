## Index boundary in loops

Boundary check should come before conditional check in `for loop` or `while loop`.

```java
while (i < nums.length - 1 && nums[i] < nums[i+1]) //correct

while (nums[i] < nums[i+1] && i < nums.length - 1) //wrong
```

## while lopp vs for loop

Use `while loop` instead of `for loop` if we want to keep the value of `i` after the loop.

