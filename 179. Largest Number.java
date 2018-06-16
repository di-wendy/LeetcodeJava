//[824,938,1399,5607,6973,5703,9609,4398,8247]
class Solution {
    public String largestNumber(int[] nums) {
        String[] convert = new String[nums.length];
        for (int i = 0; i < nums.length; i++) convert[i] = Integer.toString(nums[i]);
        
        Arrays.sort(convert, new Comparator<String>(){
            @Override
            public int compare(String A, String B){
                String temp1 = A + B;
                String temp2 = B + A;
                return temp2.compareTo(temp1); 
            }
        });
        
        String ans = "";
        for (String s : convert){
            ans += s;
            if (ans.equals("0")) return ans;
        }
        return ans;
    }
}
