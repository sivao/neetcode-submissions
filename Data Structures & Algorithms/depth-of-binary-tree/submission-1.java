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
    public int maxDepth(TreeNode root) {
        // clarifying questions?
        // what is size of the tree?
        // is the structure of the treenode below one?
        // treeNode {
        //   int val;
        //   treenode left;
        //   treenode right;
        // }
        // edge cases;
        // null -> 0
        // skewed tree height is N
        // Balanced tree height is O(logN)
        return depth(root);
    }

    private int depth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
