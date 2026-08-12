import java.util.*;

class Solution {

    // Previous Smaller Element
    public int[] PSE(int[] arr) {

        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = st.peek();
            }

            st.push(i);
        }

        return pse;
    }


    // Next Smaller Element
    public int[] NSE(int[] arr) {

        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nse[i] = n;
            } else {
                nse[i] = st.peek();
            }

            st.push(i);
        }

        return nse;
    }


    // Previous Greater Element
    public int[] PLE(int[] arr) {

        int n = arr.length;
        int[] ple = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ple[i] = -1;
            } else {
                ple[i] = st.peek();
            }

            st.push(i);
        }

        return ple;
    }


    // Next Greater Element
    public int[] NLE(int[] arr) {

        int n = arr.length;
        int[] nle = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nle[i] = n;
            } else {
                nle[i] = st.peek();
            }

            st.push(i);
        }

        return nle;
    }


    // Sum of Subarray Minimums
    public long sumSubarrayMins(int[] arr) {

        int n = arr.length;

        int[] pse = PSE(arr);
        int[] nse = NSE(arr);

        long sum = 0;

        for (int i = 0; i < n; i++) {

            int left = i - pse[i];
            int right = nse[i] - i;

            long contribution =
                    (long) left * right * arr[i];

            sum += contribution;
        }

        return sum;
    }


    // Sum of Subarray Maximums
    public long sumSubarrayMaxs(int[] arr) {

        int n = arr.length;

        int[] ple = PLE(arr);
        int[] nle = NLE(arr);

        long sum = 0;

        for (int i = 0; i < n; i++) {

            int left = i - ple[i];
            int right = nle[i] - i;

            long contribution =
                    (long) left * right * arr[i];

            sum += contribution;
        }

        return sum;
    }


    // Sum of Subarray Ranges
    public long subArrayRanges(int[] arr) {

        long maximumSum = sumSubarrayMaxs(arr);
        long minimumSum = sumSubarrayMins(arr);

        return maximumSum - minimumSum;
    }
}