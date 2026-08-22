class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int maxlength=0;
        HashMap<Character,Integer>map=new HashMap<>();
        int maxFrequency=0;

        for(int right=0;right<s.length();right++ ){
            if(map.containsKey(s.charAt(right))){

                map.put(s.charAt(right),map.get(s.charAt(right))+1);
                maxFrequency = Math.max(maxFrequency,map.get(s.charAt(right)));

            }
            else{
               map.put(s.charAt(right),1);
                maxFrequency = Math.max(maxFrequency,map.get(s.charAt(right)));

            }
           
            while(right-left+1-maxFrequency>k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
            }
            maxlength=Math.max(maxlength,right-left+1);


        }
        return maxlength;
        
    }
}