/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        inorder(root, order);
        return order;
    }

    private void inorder(TreeNode root, List<Integer> order) {
        if (root == null) {
            return;
        }

        inorder(root.left, order);
        order.add(root.val);
        inorder(root.right, order);
    }
}