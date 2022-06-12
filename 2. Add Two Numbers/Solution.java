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
        int carry = 0;
        ListNode result = new ListNode();
        ListNode curr = null;
        while (l1 != null || l2 != null || carry != 0) {
            int num1 = 0;
            int num2 = 0;
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            if (curr == null) {
                result.val = sum % 10;
                result.next = null;
                curr = result;
            } else {
                ListNode temp = new ListNode();
                temp.val = sum % 10;
                temp.next = null;
                curr.next = temp;
                curr = curr.next;
            }
        }
        return result;
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
