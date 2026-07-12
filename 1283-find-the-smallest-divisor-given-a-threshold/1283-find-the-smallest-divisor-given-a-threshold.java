class Solution {

    public int smallestDivisor(int[] nums, int threshold) {

        int low = 1;
        int high = findMax(nums);

        while(low <= high){

            int mid = low + (high - low) / 2;

            int sum = calculateSum(nums, mid);

            if(sum <= threshold){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return low;
    }

    public int findMax(int[] nums){

        int maxi = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            maxi = Math.max(maxi, nums[i]);
        }

        return maxi;
    }

    public int calculateSum(int[] nums, int divisor){

        int sum = 0;

        for(int i = 0; i < nums.length; i++){

            sum += (nums[i] + divisor - 1) / divisor;
        }

        return sum;
    }
}