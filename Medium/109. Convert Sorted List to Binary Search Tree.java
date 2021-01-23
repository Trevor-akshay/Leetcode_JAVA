/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
       List<Integer>nums=new ArrayList<>();
		while(head!=null)
		{
			nums.add(head.val);
			head=head.next;
		}
		return BST(nums,0,nums.size()-1);
	}
	 public TreeNode BST(List<Integer>nums,int low,int high)
	{
		if(low>high)return null;
		int mid=(low+high)/2;
		TreeNode root=new TreeNode(nums.get(mid));
		root.left=BST(nums,low,mid-1);
		root.right=BST(nums,mid+1,high);
		return root;
    }
}
