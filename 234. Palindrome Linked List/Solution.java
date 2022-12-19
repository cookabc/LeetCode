import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author chuangcius
 * @date 2022.06.16
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

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow);
        while (head != null && slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode static reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode tmpNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmpNext;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(convert(List.of(1, 2, 2, 1))));
        System.out.println(isPalindrome(convert(List.of(1, 2))));
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
}
