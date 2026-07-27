class Solution {
    public int maxProduct(int[] nums) {

        int largest = 0;
        int secondLargest = 0;

        for (int num : nums) {

            // agar current number sabse bada hai
            if (num > largest) {

                // purana largest ab second largest banega
                secondLargest = largest;

                // current number largest banega
                largest = num;
            }

            // largest nahi hai but second largest se bada hai
            else if (num > secondLargest) {

                secondLargest = num;
            }
        }

        return (largest - 1) * (secondLargest - 1);
    }
}