import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author xugang.song
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
        List<Integer> nodeArray = new ArrayList<>();
        while (head.next != null) {
            nodeArray.add(head.val);
            head = head.next;
        }
        nodeArray.add(head.val);
        int loopLength = nodeArray.size() / 2;
        for (int j = 0; j < loopLength; j++) {
            if (!nodeArray.get(j).equals(nodeArray.get(nodeArray.size() - 1 - j))) {
                return false;
            }
        }
        return true;
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
