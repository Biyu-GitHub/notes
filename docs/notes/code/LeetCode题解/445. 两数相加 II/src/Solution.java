import java.util.Stack;

/**
 * 输入: (7 -> 2 -> 4 -> 3)
 * +     (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 */
class Solution {

    private int flag = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode dummyHead = new ListNode(-1);

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int flag = 0;
        while (!(s1.isEmpty() && s2.isEmpty())) {
            int v1 = (s1.isEmpty() ? 0 : s1.pop());
            int v2 = (s2.isEmpty() ? 0 : s2.pop());

            int v = v1 + v2 + flag;
            if (v >= 10) {
                flag = v / 10;
                v = v % 10;
            } else {
                flag = 0;
            }

            ListNode newNode = new ListNode(v);
            newNode.next = dummyHead.next;
            dummyHead.next = newNode;
        }
        if (flag != 0) {
            ListNode newNode = new ListNode(flag);
            newNode.next = dummyHead.next;
            dummyHead.next = newNode;
        }
        return dummyHead.next;
    }
}