class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>((a, b) -> b - a);

        int reach = startFuel;
        int i = 0;
        int stops = 0;

        while (reach < target) {

            while (i < stations.length && stations[i][0] <= reach) {
                maxHeap.add(stations[i][1]);
                i++;
            }

            if (maxHeap.isEmpty()) {
                return -1;
            }

            reach += maxHeap.poll();
            stops++;
        }

        return stops;
    }
}