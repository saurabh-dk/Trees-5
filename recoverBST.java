// TC : O(n)
// SC : O(h)
// Ran on LC : Yes
// Problems faced : None.


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
    TreeNode first;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void helper(TreeNode root) {
        if(root == null) return;
        
//         helper(root.left);
        
//         if(prev != null && prev.val >= root.val) {
//             if(first == null) {
//                 first = prev;
//                 second = root;
//             } else {
//                 second = root;
//             }
//         }
        
//         prev = root;
        
//         helper(root.right);
        
        TreeNode prev = null;
        
        Stack<TreeNode> st = new Stack<>();
        
        while(root != null || !st.isEmpty()) {
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            
            if(prev != null && prev.val >= root.val) {
                if(first == null) {
                    first = prev;
                    second = root;
                } else {
                    second = root;
                }
            }
            
            prev = root;
            root = root.right;
        }
        
        
    }
}