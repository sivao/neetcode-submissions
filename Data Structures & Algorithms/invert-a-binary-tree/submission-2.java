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
    public TreeNode invertTree1(TreeNode root) {
        // clarifying questions:
        // treenode {
        //   int val;
        //   treenode left;
        //   treenode right;
        // }
        // what is the size of the array? 
        // sample test cases:
        // null return null;
        if(root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        // clarifying questions:
        // treenode {
        //   int val;
        //   treenode left;
        //   treenode right;
        // }
        // what is the size of the array? 
        // sample test cases:
        // null return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode lastSeen = null;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode peek = stack.peek();
            if(peek.right != null && lastSeen != peek.right) {
                cur = peek.right;
            } else {
                TreeNode ele = stack.pop();
                TreeNode right = ele.right;
                ele.right = ele.left;
                ele.left = right;
                lastSeen = ele;
            }
        }
        return root;
    }
}
