class Solution {

    class Pair {
        int capital;
        int profit;

        Pair(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        PriorityQueue<Pair> minHeap =
            new PriorityQueue<>((a, b) -> a.capital - b.capital);

        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>((a, b) -> b - a);

        for(int i = 0; i < profits.length; i++) {
            minHeap.add(new Pair(capital[i], profits[i]));
        }

        for(int i = 0; i < k; i++) {

            while(!minHeap.isEmpty() &&
                  minHeap.peek().capital <= w) {

                Pair p = minHeap.poll();

                maxHeap.add(p.profit);
            }

            if(maxHeap.isEmpty()) {
                break;
            }

            int profit = maxHeap.poll();

            w += profit;
        }

        return w;
    }
}