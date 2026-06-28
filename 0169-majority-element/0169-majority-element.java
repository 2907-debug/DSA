class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap <>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int oldfrequency=map.getOrDefault(nums[i],0);
            int newfrequency =oldfrequency+1;
            map.put(nums[i],newfrequency);

        }
        for(int keyy:map.keySet()){
            int frequency=map.get(keyy);
          
            if(frequency > n/2){
            return keyy;

            }
            
        }
        return -1;
        
         
        
    }
}