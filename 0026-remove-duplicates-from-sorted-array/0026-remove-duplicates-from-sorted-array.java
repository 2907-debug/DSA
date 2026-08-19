class Solution {
    public int removeDuplicates(int[] nums) {
        int i =0;
        int j =i+1;
        for (j =1;j<nums.length;j++){
            if (nums[i]==nums[j]){
                

            }else{
                i++;
                nums[i]=nums[j];
                //#unique element ko previous dupilic ated //element ke place me rakhdo 
                //i sirf tab badhta hai jab j ko naya unique element milta hai.
            }
            

        }
        return i+1;
        
       
    }    
}
