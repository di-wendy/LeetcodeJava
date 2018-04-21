class model{
    public static String minWindow(String s, String t) {
        int[] sNum = new int[256];
        int[] tNum = new int[256];
        
        //init tNum
        for (char c : t.toCharArray()){
            tNum[c] += 1;
        }
        
        String ans = s;
        
        //To find the minimum window
        int i = 0;
        int j = 0;
        for (i = 0; i < s.length(); i++){
            while(j < s.length() && !isCovered(sNum, tNum)){
                sNum[s.charAt(j)] ++;
                j++;
            }
            if (j - i <= ans.length() && isCovered(sNum, tNum)){
                ans = s.substring(i, j);
            }
            sNum[s.charAt(i)] --;
        }
        return ans;
    }

    //Test
    public static boolean isCovered(int[] sNum, int[] tNum){
        for (int i = 0; i < tNum.length; i++){
            if (tNum[i] > sNum[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String s2 = "A";
        String t2 = "";
        System.out.println(minWindow(s2, t2));
    }
}