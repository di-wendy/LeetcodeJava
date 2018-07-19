class segTree{
    segTree left, right;
    int l, r, val;
    public segTree(int l, int r, int val){
        this.l = l;
        this.r = r;
        this.val = val;
    }
}

public class NumArray {
    segTree root;
    int[] nums;
    public NumArray(int[] nums) {
        if (nums.length != 0){
            this.root = buildTree(nums, 0, nums.length - 1);
            this.nums = nums;
        }
    }
    
    public void update(int i, int val) {
        int diff = this.nums[i] - val; //2 -> 3, give -1
        this.nums[i] = val;
        segTree cur = this.root;
        search(cur, i, diff);
    }
    
    public int sumRange(int i, int j) {
        segTree cur = this.root;
        return searchValue(cur, i, j);
    }
    
    public int searchValue(segTree root, int i, int j){
        if (root == null) return 0;
        if (root.l == i && root.r == j) return root.val;
        else{
            int mid = (root.l + root.r) / 2;
            if (j <= mid) return searchValue(root.left, i, j);
            else if (i >= mid + 1) return searchValue(root.right, i, j);
            else return searchValue(root.left, i, mid) + searchValue(root.right, mid + 1, j);
        }
    }
    
    public void search(segTree root, int i, int diff){
        if (root == null) return;
        if (i >= root.l && i <= root.r){
            root.val = root.val - diff;
            if (root.left != null && root.left.r >= i){
                search(root.left, i, diff);
            }
            if (root.right != null && root.right.l <= i){
                search(root.right, i, diff);
            }
        }
    }
    
    public segTree buildTree(int[] nums, int i, int j){
        if (i > j) return null;
        if (i == j) return new segTree(i, j, nums[i]);
        segTree root = new segTree(i, j, 0);
        int mid = (i + j) / 2;
        root.left = buildTree(nums, i, mid);
        root.right = buildTree(nums, mid + 1, j);
        root.val = root.left.val + root.right.val;
        return root;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
