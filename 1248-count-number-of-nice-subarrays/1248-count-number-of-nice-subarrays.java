class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atmost(nums, k) - atmost(nums, k - 1);
    }

    public int atmost(int[] nums, int k) {
        int left = 0;
        int oddcount = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] % 2 != 0) {
                oddcount++;
            }

            while (oddcount > k) {
                if (nums[left] % 2 != 0) {
                    oddcount--;
                }
                left++;
            }

            ans += right - left + 1;
        }

        return ans;
    }
}