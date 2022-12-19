import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Solution
 *
 * @author chuangcius
 * @date 2022.07.07
 */
public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private static void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            inorderTraversal(root.left, result);
            result.add(root.val);
            inorderTraversal(root.right, result);
        }
    }

    public static void main(String[] args) {
        System.out.println(inorderTraversal(convert(Arrays.asList(null, 1, 2, 3))));
        System.out.println(inorderTraversal(convert(Arrays.asList(1, null, 2, 3))));
        System.out.println(inorderTraversal(convert(Arrays.asList(1, 2, null, 3))));
        System.out.println(inorderTraversal(convert(List.of(1))));
        System.out.println(inorderTraversal(convert(List.of())));
    }

    private static TreeNode convert(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return getNullableTreeNode(list.get(0));
        }
        if (list.size() == 2) {
            return getNullableTreeNode(list.get(0), new TreeNode(list.get(1)), null);
        }
        return getNullableTreeNode(list.get(0), getNullableTreeNode(list.get(1)), convert(list.subList(2, list.size())));
    }

    private static TreeNode getNullableTreeNode(Integer val) {
        return Objects.nonNull(val) ? new TreeNode(val) : null;
    }

    private static TreeNode getNullableTreeNode(Integer val, TreeNode left, TreeNode right) {
        return Objects.nonNull(val) ? new TreeNode(val, left, right) : null;
    }
}
