class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        // Har row ka first aur last element check karenge
        for (int row = 0; row < n; row++) {

            // Target is row ki range me hai
            if (matrix[row][0] <= target &&
                target <= matrix[row][m - 1]) {

                // Is row ke andar binary search
                int low = 0;
                int high = m - 1;

                while (low <= high) {

                    int mid = low + (high - low) / 2;

                    if (matrix[row][mid] == target) {
                        return true;
                    }

                    else if (matrix[row][mid] < target) {
                        low = mid + 1;
                    }

                    else {
                        high = mid - 1;
                    }
                }

                // Target range wali row me bhi nahi mila
                return false;
            }
        }

        return false;
    }
}