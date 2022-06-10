import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author xugang.song
 * @date 2022.06.10
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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> valueList1 = getValues(list1);
        List<Integer> valueList2 = getValues(list2);
        valueList1.addAll(valueList2);
        List<Integer> allValueList = valueList1.stream().sorted().toList();

        return convert(allValueList);
    }

    private static List<Integer> getValues(ListNode listNode) {
        List<Integer> result = new ArrayList<>();
        if (listNode == null) {
            return result;
        }
        result.add(listNode.val);
        if (listNode.next != null) {
            result.addAll(getValues(listNode.next));
        }
        return result;
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

    public static void main(String[] args) {
        printList(mergeTwoLists(convert(List.of(1, 2, 4)), convert(List.of(1, 3, 4))));
        System.out.println("------");
        printList(mergeTwoLists(convert(List.of()), convert(List.of())));
        System.out.println("------");
        printList(mergeTwoLists(convert(List.of()), new ListNode(0)));
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
