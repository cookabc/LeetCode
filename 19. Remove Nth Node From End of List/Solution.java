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
        if (head.next == null) {
            return null;
        }
        ListNode curr = head;
        if (n == 1) {
            while (curr.next.next != null) {
                curr = curr.next;
            }
            curr.next = null;
            return head;
        }

        int sz = 1;
        while (curr.next != null) {
            curr = curr.next;
            sz++;
        }
        if (sz == n) {
            return head.next;
        }

        curr = head;
        for (int i = 1; i < (sz - n); i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;

        return head;
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
