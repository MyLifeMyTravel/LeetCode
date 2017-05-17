/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * Created by littlejie on 2017/5/17.
 */
public class Q2AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1_0 = new ListNode(2);
        ListNode l1_1 = new ListNode(4);
        ListNode l1_2 = new ListNode(3);
        l1_0.next = l1_1;
        l1_1.next = l1_2;

        ListNode l2_0 = new ListNode(5);
        ListNode l2_1 = new ListNode(6);
        ListNode l2_2 = new ListNode(4);
        l2_0.next = l2_1;
        l2_1.next = l2_2;

        ListNode result = addTwoNumbers(l1_0, l2_0);
        System.out.println(result);
    }

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

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
