class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums, goal) - atmost(nums, goal - 1);
    }

    public int atmost(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }

        int sum = 0;
        int left = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > goal) {
                sum -= nums[left];
                left++;
            }

            ans += right - left + 1;
        }

        return ans;
    }
}