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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        TreeNode curr1 = p;
        TreeNode curr2 = q;
        // while(curr1!=null || !st1.isEmpty()){
        //     if(curr1!=null) st1.push(curr1);

        //     if(curr1==null && st1.size()>0){
        //         curr1 = st1.pop();
        //         curr1 = curr1.right;
        //         continue;
        //     }
        //     System.out.println(curr1.val);
        //     curr1 = curr1.left;
        // }

         while(curr1!=null || !st1.isEmpty() || curr2!=null || !st2.isEmpty()){
            if(curr1!=null) st1.push(curr1);
            if(curr2!=null) st2.push(curr2);

            if(curr1==null && st1.size()>0 && curr2==null && st2.size()>0){
                curr1 = st1.pop();
                curr1 = curr1.right;
                curr2 = st2.pop();
                curr2 = curr2.right;
                continue;
            }
            if(curr1==null || curr2==null) return false;
            // if(curr2==null && curr1!=null) return false;
            if(curr1.val!=curr2.val) return false;
            curr1 = curr1.left;
            curr2 = curr2.left;
        }
        return true;
    }
}
// Example 1:


// Input: p = [1,2,3], q = [1,2,3]
// Output: true
// Example 2:


// Input: p = [1,2], q = [1,null,2]
// Output: false
// Example 3:


// Input: p = [1,2,1], q = [1,1,2]
// Output: false
 

// Constraints:

// The number of nodes in both trees is in the range [0, 100].
// -104 <= Node.val <= 104