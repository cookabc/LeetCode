import java.util.ArrayList;
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
        int sz = 1;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            sz++;
        }

        int targetPos = sz - n;
        int currentPos = 0;
        curr = head;
        List<ListNode> nodeList = new ArrayList<>();
        while (currentPos < targetPos && curr != null) {
            currentPos++;
            nodeList.add(new ListNode(curr.val));
            curr = curr.next;
        }
        if (curr != null) {
            curr = curr.next;
        }
        while (curr != null) {
            nodeList.add(new ListNode(curr.val));
            curr = curr.next;
        }
        if (nodeList.size() == 0) {
            return null;
        }
        for (int i = 0; i < nodeList.size() - 1; i++) {
            nodeList.get(i).next = nodeList.get(i + 1);
        }
        return nodeList.get(0);
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
