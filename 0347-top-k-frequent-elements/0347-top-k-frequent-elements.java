class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Frequency count
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Step 2: Min Heap
        // [element, frequency]
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // Step 3: HashMap ke elements ko heap mein daalo
        for(int num : map.keySet()) {

            int frequency = map.get(num);

            if(pq.size() < k) {
                pq.add(new int[]{num, frequency});
            }

            else if(frequency > pq.peek()[1]) {
                pq.poll();
                pq.add(new int[]{num, frequency});
            }
        }

        // Step 4: Answer
        int[] ans = new int[k];

        for(int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }

        return ans;
    }
}