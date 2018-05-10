
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] store = new int[r][c];
        
        int max = 0;
        
        for(int j = 0; j < c; j++){
            for(int i = 0; i< r; i++){
                calVertical(matrix, store, i, j);
            }
        }
        
        for(int i = 0; i < r; i++){
            max = Math.max(max, calHorizontal(store[i]));
        }
        
        return max;
    }
    
    public void calVertical(char[][] matrix, int[][] store, int i, int j){
        if(i == 0){
            store[i][j] = matrix[i][j] == '1'?1:0;
        }
        else{
            if(matrix[i][j] == '1'){
                store[i][j]  = store[i - 1][j] + 1;
            }
        }
    }
    
    public int calHorizontal(int[] array){
        int val = array[0];
        for(int i = 0; i < array.length; i++){
            int min = array[i];
            for(int j = i; j < array.length; j++){
                min = Math.min(min, array[j]);
                val = Math.max(val, (j - i + 1) * min);
            }
        }
        return val;
    }
}

//Using Stack
//Space Complexity O(mn)
//Time complexity O(mn)

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[][] store = convertLine(matrix);
        int ans = 0;
        
        for (int i = 0; i < store.length; i++){
            ans = Math.max(ans, maxLineArea(store[i]));
        }
        
        return ans;
    }
    
    public int[][] convertLine (char[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[m][n];
        
        for (int j = 0; j < n; j++){
            for (int i = 0; i < m; i++){
                if(i == 0){
                    ans[i][j] = matrix[i][j] - '0';
                }
                else{
                    ans[i][j] = (matrix[i][j] == '0') ? 0 : ans[i - 1][j] + 1;
                }
            }
        }
        return ans;
    }
    
    public int maxLineArea(int[] line){
        Stack<Integer> st = new Stack<Integer>();
        int ans = 0;
        
        for (int i = 0; i <= line.length; i++){
            int mark = (i == line.length) ? -1 : line[i];
            while (!st.isEmpty() && mark < line[st.peek()]){
                int h = line[st.pop()];
                int w = (st.isEmpty()) ? i : i - st.peek() - 1;
                ans = Math.max(ans, h * w);
            }
            st.push(i);
        }
        
        return ans;
    }
    
}
