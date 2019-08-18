import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();

        if (listNode == null)
            return list;

        printListFromTailToHead(listNode, list);

        return list;
    }

    private void printListFromTailToHead(ListNode listNode, ArrayList<Integer> list) {
        if (listNode == null)
            return;

        printListFromTailToHead(listNode.next, list);
        list.add(listNode.val);
        return;
    }
}