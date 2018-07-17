/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        
        if(nestedList == null){
        return 0;}
        
        Queue<NestedInteger> q = new LinkedList<NestedInteger>(nestedList);
        
        int ans = 0;
        int level = 1;
        
        while(q.size() != 0){
            
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                NestedInteger temp = q.poll();
                if(temp.isInteger()){
                    ans += (temp.getInteger() * level);
                }
                else{
                    q.addAll(temp.getList());
                }
            }
            level += 1;
        }
        
        return ans;
    }
}
//
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return getSum(nestedList, 1);
    }
    
    public int getSum(List<NestedInteger> nestedList, int base){
        int sum = 0;
        for (int i = 0; i < nestedList.size(); i++){
            if (nestedList.get(i).isInteger()){
                sum += nestedList.get(i).getInteger() * base;
            } else {
                sum += getSum(nestedList.get(i).getList(), base + 1);
            }
        }
        return sum;
    }
}
