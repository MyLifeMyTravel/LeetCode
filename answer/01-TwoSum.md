# 01-TwoSum

题目：给定一个数组和一个目标数值，求数组内两数相加之和等于目标数值的下标。假定必有一组解。

示例如下：

```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

解题思路如下：遍历数组，判断是否有 `nums[j] = target - nums[i]`

[TwoSum.java](../src/Q1TwoSum.java)

```
public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == target - nums[i]) {
                return new int[]{i, j};
            }
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}
```

另有通过 `HashMap` 来解决该问题的[方法](https://leetcode.com/articles/two-sum/)，时间复杂度为为`O(n)`。