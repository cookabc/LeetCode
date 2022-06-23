import java.util.List;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.23
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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;

        while (n > 0) {
            right = right.next;
            n--;
        }
        while (right != null) {
            right = right.next;
            left = left.next;
        }
        if (left != null && left.next != null) {
            left.next = left.next.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        printList(removeNthFromEnd(convert(List.of(1, 2, 3, 4, 5)), 5));
        System.out.println("------");
        printList(removeNthFromEnd(convert(List.of(1, 2, 3, 4, 5)), 4));
        System.out.println("------");
        printList(removeNthFromEnd(convert(List.of(1, 2, 3, 4, 5)), 2));
        System.out.println("------");
        printList(removeNthFromEnd(convert(List.of(1)), 1));
        System.out.println("------");
        printList(removeNthFromEnd(convert(List.of(1, 2)), 1));
        System.out.println("------");
        printList(removeNthFromEnd(convert(List.of(1, 2, 3)), 1));
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
