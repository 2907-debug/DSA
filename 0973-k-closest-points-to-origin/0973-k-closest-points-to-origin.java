class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) ->
                (b[0] * b[0] + b[1] * b[1])
              - (a[0] * a[0] + a[1] * a[1])
        );

        for (int[] point : points) {

            if (pq.size() < k) {
                pq.add(point);
            }
            else {
                int currentDistance =
                    point[0] * point[0] + point[1] * point[1];

                int farthestDistance =
                    pq.peek()[0] * pq.peek()[0]
                    + pq.peek()[1] * pq.peek()[1];

                if (currentDistance < farthestDistance) {
                    pq.poll();
                    pq.add(point);
                }
            }
        }

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }
}