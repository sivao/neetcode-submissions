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

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // dfs(root);
        // return diameter;
        return iterativePostOrder(root);
    }

    // TC: O(N), SC: O(H)
    private int dfs(TreeNode root) {
        if(root == null) return 0;
        // if(root.left == null && root.right == null) return 1;
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        int length = leftHeight + rightHeight;
        diameter = Math.max(diameter, length);
        return Math.max(leftHeight, rightHeight)+1;
    }

    // TC: O(N), SC: O(N)
    private int iterativePostOrder(TreeNode root) {
        if(root == null) return 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, Integer> heights = new HashMap<>();
        int diameter = 0;
        TreeNode cur = root;
        TreeNode lastSeen = null;
        while(cur != null || !stack.isEmpty()) {
            while(cur!= null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode peek = stack.peek();
            if(peek.right != null && lastSeen != peek.right) {
                cur = peek.right;
            } else {
                TreeNode temp = stack.pop();
                int leftHeight = heights.getOrDefault(temp.left, 0);
                int rightHeight = heights.getOrDefault(temp.right, 0);
                diameter = Math.max(diameter, leftHeight+rightHeight);
                heights.put(temp, Math.max(leftHeight, rightHeight)+1);
                lastSeen = temp;
            }
        }
        return diameter;
    }
}
