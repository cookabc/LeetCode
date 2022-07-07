import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Solution
 *
 * @author xugang.song
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

    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public static boolean validate(TreeNode root, Integer low, Integer high) {
        // Empty trees are valid BSTs.
        if (root == null) {
            return true;
        }
        // The current node's value must be between low and high.
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        // The left and right subtree must also be valid.
        return validate(root.right, root.val, high) && validate(root.left, low, root.val);
    }

    public static void main(String[] args) {
        System.out.println(isValidBST(convert(List.of(2, 1, 3))));
        System.out.println(isValidBST(convert(Arrays.asList(5, 1, 4, null, null, 3, 6))));
        System.out.println(isValidBST(convert(Arrays.asList(5, 4, 6, null, null, 3, 7))));
    }

    private static TreeNode convert(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (list.size() == 1) {
            return getNullableTreeNode(list.get(0));
        }
        if (list.size() == 2) {
            return getNullableTreeNode(list.get(0), getNullableTreeNode(list.get(1)), null);
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
