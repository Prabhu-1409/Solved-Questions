
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null) return null;
        Stack<Node> st = new Stack<>();
        Node curr = head;
        Node ans = new Node(0);
        Node temp1 = ans;
        while(curr!=null || !st.isEmpty()){
            if(!st.isEmpty() && curr==null){
                curr = st.pop();
            }
            if(curr.child!=null){
                if(curr.next!=null){
                    st.push(curr.next);
                }
                temp1.next = curr;
                if(temp1.child!=null) temp1.child = null;
                Node temp_curr = temp1;
                temp1 = temp1.next;
                temp1.prev = temp_curr;
                curr = curr.child;
            }else{
                temp1.next = curr;
                if(temp1.child!=null) temp1.child = null;
                Node temp_curr = temp1;
                temp1 = temp1.next;
                temp1.prev = temp_curr;
                curr = curr.next;
            }
        }
        // Node curr1 = ans;
        // while(curr1!=null){
        //     if(curr1.child!=null) curr1.child = null;
        //     curr1 = curr1.next;
        // }
        Node ans1 = ans.next;
        ans1.prev = null;
        return ans1;
    }
}


// Example 1:


// Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
// Output: [1,2,3,7,8,11,12,9,10,4,5,6]
// Explanation: The multilevel linked list in the input is shown.
// After flattening the multilevel linked list it becomes:

// Example 2:


// Input: head = [1,2,null,3]
// Output: [1,3,2]
// Explanation: The multilevel linked list in the input is shown.
// After flattening the multilevel linked list it becomes:

// Example 3:

// Input: head = []
// Output: []
// Explanation: There could be empty list in the input.
 

// Constraints:

// The number of Nodes will not exceed 1000.
// 1 <= Node.val <= 105
 