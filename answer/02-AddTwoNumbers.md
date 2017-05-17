# 02-AddTwoNumbers

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