class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[n - k + 1];

        Deque<Integer> dq = new LinkedList<>();
        int j = 0;

        for (int i = 0; i < n; i++) {

            // 1. Window ke bahar wale index ko remove karo
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 2. Chhote elements ko remove karo
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            // 3. Current index add karo
            dq.offerLast(i);

            // 4. Jab window size k ho jaye
            if (i >= k - 1) {
                ans[j] = nums[dq.peekFirst()];
                j++;
            }
        }

        return ans;
    }
}