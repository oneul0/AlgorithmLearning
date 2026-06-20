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
    int postIdx;
    Map<Integer,Integer> inorderIdxMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length-1;

        for(int i = 0; i<inorder.length; i++){
            inorderIdxMap.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, inorder.length-1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int left, int right){
        if(left > right) return null;

        int rootVal = postorder[postIdx];
        postIdx--;

        TreeNode root = new TreeNode(rootVal);

        int rootIdx = inorderIdxMap.get(rootVal);

        root.right = build(inorder, postorder, rootIdx+1, right);
        root.left = build(inorder, postorder, left, rootIdx-1);

        return root;
    }
}

//postorder의 마지막 값은 항상 현재 서브트리의 루트
//