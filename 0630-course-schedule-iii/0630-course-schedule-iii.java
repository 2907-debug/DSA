class Solution {
    public int scheduleCourse(int[][] courses) {

        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>((a, b) -> b - a);

        int totalTime = 0;

        for(int i = 0; i < courses.length; i++) {

            int duration = courses[i][0];
            int deadline = courses[i][1];

            totalTime += duration;
            maxHeap.add(duration);

            if(totalTime > deadline) {
                totalTime -= maxHeap.poll();
            }
        }

        return maxHeap.size();
    }
}
