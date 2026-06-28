class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        List<Integer>ans=new ArrayList<>();
        int n =nums.length;
        for(int i=0;i<n;i++){
            int oldfrequency=map.getOrDefault(nums[i],0);
            int newfrequency=oldfrequency +1;
            map.put(nums[i],newfrequency);
        }
        for(int key:map.keySet()){
            int frequency=map.get(key);
            if(frequency>n/3){
                ans.add(key);
            }
        }
        return ans;
        }
        
    }
