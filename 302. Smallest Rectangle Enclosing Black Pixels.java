class Solution {
    public int minArea(char[][] image, int x, int y) {
        int upper = search(image, 0, x, true, true);
        int lower = search(image, x, image.length - 1, true, false);
        int left = search(image, 0, y, false, true);
        int right = search(image, y, image[0].length - 1, false, false);
        return (lower - upper + 1) * (right - left + 1);
    }
    
    public int search(char[][] image, int i, int j, boolean row, boolean start){
        while (i + 1 < j){
            int mid = i + (j - i) / 2;
            if (check(image, mid, row)){
                if (start) j = mid;
                else i = mid;
            } else {
                if (start) i = mid + 1;
                else j = mid - 1;
            }
        }
        if (start) return check(image, i, row) ? i : j;
        return check(image, j, row) ? j : i;
    }
    
    public boolean check(char[][] image, int mid, boolean row){
        if (row){
            for (char c : image[mid]){
                if (c == '1') return true;
            }
        } else {
            for (int i = 0; i < image.length; i++){
                if (image[i][mid] == '1') return true;
            }
        }
        return false;
    }
    
}
