/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        
        while(root != null){
            TreeLinkNode start = new TreeLinkNode(0);
            TreeLinkNode p = start;
            while(root!=null){
                if(root.left != null){p.next = root.left; p = p.next;}
                if(root.right != null){p.next = root.right; p = p.next;}
                root = root.next;
            }
            root = start.next;
        }
      
    }
}
