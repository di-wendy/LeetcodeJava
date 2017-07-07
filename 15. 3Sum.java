//With Duplicate
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        //Creat Bucket to store nums in HashTable<integer,index> bucket<index> = array[index]
        List<Integer>[] Bucket = new List[nums.length];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],count);
                Bucket[count] =  new ArrayList<Integer>();
                Bucket[count].add(i);
                count += 1;
            }
            else{
                int index = map.get(nums[i]);
                Bucket[index].add(i);
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                int target = -(nums[i] + nums[j]);
                if(!map.containsKey(target)){
                    continue;
                }
                else{
                    List<Integer> array = Bucket[map.get(target)];
                    if(!array.contains(i) && !array.contains(j)){
                        List<Integer> subans = new ArrayList<>();
                        subans.add(nums[i]);
                        subans.add(nums[j]);
                        subans.add(target);
                        ans.add(subans);
                    }
                }
            }
        }
        
        return ans;
    }
}

//Without Duplicate
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans = new LinkedList<>();
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] > 0) break;
            if(i == 0 || nums[i] != nums[i-1]){
                int low = i + 1;
                int high = nums.length - 1;
                int target = -(nums[i]);
                while(low < high){
                    if(nums[low] + nums[high] == target){
                        ans.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        while(low < high && nums[low] == nums[low + 1]) low++;
                        while(low < high && nums[high - 1] == nums[high]) high--;
                        low ++;
                        high --;
                    }
                    else if(nums[low] + nums[high] < target){
                        low++;
                    }
                    else{
                        high--;
                    }
                }
            }  
        }
        
        return ans;
    }
}
