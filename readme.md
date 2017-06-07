# [LeetCode](https://leetcode.com/) 解题
争取每天做一题 LeetCode 上的题，坚持就是胜利！

## [01-TwoSum](answer/01-TwoSum.md)

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

## [02-AddTwoNumbers](answer/02-AddTwoNumbers.md)

题目：输入两个非空链表，代表两个正数，每个节点代表一位，数据反转存储，求两链表数据相加的结果

```
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
相当于：342 + 465 = 807
```

解题思路如下：链表的每个节点相加，如果节点相加之和大于 10，则需要进位。同时，需要考虑到链表不等长的情况，如：32 + 465 。最后，还需要注意，最高位相加导致进位的情况。

[AddTwoNumbers](../src/Q2AddTwoNumbers.java)

```
public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode next1 = l1;
    ListNode next2 = l2;
    ListNode result = new ListNode(0);
    ListNode temp = result;
    int sum = 0;
    while (next1 != null || next2 != null) {
        if (next1 != null) {
            sum += next1.val;
            next1 = next1.next;
        }
        if (next2 != null) {
            sum += next2.val;
            next2 = next2.next;
        }
        temp.next = new ListNode(sum % 10);
        sum /= 10;
        temp = temp.next;
    }
    //考虑最后两位数相加进位的情况
    if (sum > 0) {
        temp.next = new ListNode(1);
    }
    //因为 ListNode 的第一个节点为 0
    return result.next;
}
```

[点此查看 LeetCode 上的解题思路](https://leetcode.com/articles/add-two-numbers/)

## [03-LongestSubstringWithoutRepeatingCharacters](answer/03-LongestSubstringWithoutRepeatingCharacters.md)

题目：本题是求最长无重复子串的长度

```
Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
```

[Q3LongestSubstringWithoutRepeatingCharacters](../src/Q3LongestSubstringWithoutRepeatingCharacters.java)

abcabcbb:[a)->[ab)->[abc)->[abca)->[bca)->[bcab)->[cab)-[cabc)->[abc)->[abcb)->[bcb)-[cbb)->[bb)->[b)

[点此查看 LeetCode 上的解题思路](https://leetcode.com/articles/longest-substring-without-repeating-characters/)

## [04-MedianofTwoSortedArrays](answer/04-MedianofTwoSortedArrays.md)

## [07-ReserveInteger](answer/07-ReserveInteger.md)

该题是让我们求一个数字的反转，比如：-123 的反转为 -321，100 的反转为 1，同时，需要考虑到反转后的数字出现溢出的情况。
 
```
public static int reverse(int x) {
    //此处 result 得使用 long 类型
    long result = 0;
    int abs = Math.abs(x);
    while (abs > 0) {
        result *= 10;
        result += abs % 10;
        if (result > Integer.MAX_VALUE) {
            return 0;
        }
        abs /= 10;
    }
    return (int) (x < 0 ? -result : result);
}
```

## [09-PalindromeNumber](answer/09-PalindromeNumber.md)

这题是让我们求一个数字是否为回文数，这里要注意以下几点

1. 负数不是回文数
2. 不能使用额外的空间，如创建数组
3. 如果考虑反转后的值是否与原值相等，得考虑到反转后的值是否会导致溢出

根据回文数的定义，即：数字成对称，只要我们可以比较对称位是否相等即可判断

如：1234321

1234321 % 1000000 = 1;
1234321 / 100000  = 1;

## 14-Longest Common Prefix

这题是让我们求解字符串数组的从第一位开始的公共字符串。这里使用暴力求解的方法，具体讨论可以参考[Longest Common Prefix Solution](https://leetcode.com/articles/longest-common-prefix)

```
public static String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
        return "";
    }
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
        int j = 0;
        while (j < prefix.length() && j < strs[i].length()
                && prefix.charAt(j) == strs[i].charAt(j)) {
            j++;
        }
        prefix = prefix.substring(0, j);
    }
    return prefix;
}
```