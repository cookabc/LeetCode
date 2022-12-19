import java.util.List;

/**
 * Solution
 *
 * @author chuangcius
 * @date 2022.06.17
 */
public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        printList(middleNode(convert(List.of(1, 2, 3, 4, 5))));
        System.out.println("------");
        printList(middleNode(convert(List.of(1, 2, 3, 4, 5, 6))));
    }

    private static ListNode convert(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<Integer> subList = list.subList(1, list.size());
        if (subList.isEmpty()) {
            return new ListNode(list.get(0));
        }
        return new ListNode(list.get(0), convert(subList));
    }

    private static void printList(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        System.out.println(listNode.val);
        if (listNode.next != null) {
            printList(listNode.next);
        }
    }
}
