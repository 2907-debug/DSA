import java.util.HashMap;

class Solution {

    public int subarraysWithKDistinct(int[] nums, int k) {

        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {

            if (map.containsKey(nums[right])) {
                map.put(nums[right], map.get(nums[right]) + 1);
            } else {
                map.put(nums[right], 1);
            }

            while (map.size() > k) {

                map.put(nums[left], map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }

                left++;
            }

            ans += right - left + 1;
        }

        return ans;
    }
}