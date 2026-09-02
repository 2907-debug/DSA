class Solution {
    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> b - a
        );

        for(int freq : map.values()) {
            pq.add(freq);
        }

        Queue<int[]> q = new LinkedList<>();

        int time = 0;

        while(!pq.isEmpty() || !q.isEmpty()) {

            time++;

            if(!pq.isEmpty()) {

                int freq = pq.poll();
                freq--;

                if(freq > 0) {
                    q.add(new int[]{freq, time + n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time) {
                pq.add(q.poll()[0]);
            }
        }

        return time;
    }
}