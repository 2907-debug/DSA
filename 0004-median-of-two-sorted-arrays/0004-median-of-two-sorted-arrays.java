class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        // Binary search hamesha smaller array par karenge
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = n1;

        while (low <= high) {

            int mid1 = (low + high) / 2;

            // Total required left elements - nums1 se liye hue elements
            int mid2 = (n1 + n2 + 1) / 2 - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if (mid1 < n1) {
                r1 = nums1[mid1];
            }

            if (mid2 < n2) {
                r2 = nums2[mid2];
            }

            if (mid1 - 1 >= 0) {
                l1 = nums1[mid1 - 1];
            }

            if (mid2 - 1 >= 0) {
                l2 = nums2[mid2 - 1];
            }

            // Correct partition
            if (l1 <= r2 && l2 <= r1) {

                // Odd total elements
                if ((n1 + n2) % 2 == 1) {
                    return Math.max(l1, l2);
                }

                // Even total elements
                return (
                    Math.max(l1, l2)
                    +
                    Math.min(r1, r2)
                ) / 2.0;
            }

            // nums1 se zyada elements left me le liye
            else if (l1 > r2) {
                high = mid1 - 1;
            }

            // nums1 se kam elements left me liye
            else {
                low = mid1 + 1;
            }
        }

        return 0.0;
    }
}