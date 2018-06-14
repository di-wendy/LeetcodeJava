class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(nums, 0, nums.length - 1);
    }
    
    public TreeNode convert(int[] nums, int start, int end){
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode temp = new TreeNode(nums[mid]);
        temp.left = convert(nums, start, mid - 1);
        temp.right = convert(nums, mid + 1, end);
        return temp;
    }
}
