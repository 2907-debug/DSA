class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        // First k cards ka sum
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }

        int maxSum = sum;

        // Left se remove, right se add
        int left = k - 1;
        int right = n - 1;

        for (int i = 0; i < k; i++) {

            sum -= cardPoints[left];
            left--;

            sum += cardPoints[right];
            right--;

            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}