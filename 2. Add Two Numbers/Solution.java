import java.util.List;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.12
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            if (l2.val == 10) {
                return new ListNode(0, addTwoNumbers(new ListNode(1), l2.next));
            }
            return l2;
        }
        if (l2 == null) {
            if (l1.val == 10) {
                return new ListNode(0, addTwoNumbers(new ListNode(1), l1.next));
            }
            return l1;
        }
        int sum = l1.val + l2.val;
        if (sum / 10 == 1) {
            if (l1.next != null) {
                l1.next.val += 1;
            } else {
                l1.next = new ListNode(1);
            }
        }
        return new ListNode(sum % 10, addTwoNumbers(l1.next, l2.next));
    }

    public static void main(String[] args) {
        printList(addTwoNumbers(convert(List.of(2, 4, 3)), convert(List.of(5, 6, 4))));
        System.out.println("------");
        printList(addTwoNumbers(convert(List.of(0)), convert(List.of(0))));
        System.out.println("------");
        printList(addTwoNumbers(convert(List.of(5)), convert(List.of(5))));
        System.out.println("------");
        printList(addTwoNumbers(convert(List.of(9, 9, 9, 9, 9, 9, 9)), convert(List.of(9, 9, 9, 9))));
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
