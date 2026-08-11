class Solution {

    // Previous Smaller Element
    public int[] previousSmaller(int[] arr) {

        int n = arr.length;
        int[] left = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = st.peek();
            }

            st.push(i);
        }

        return left;
    }


    // Next Smaller Element
    public int[] nextSmaller(int[] arr) {

        int n = arr.length;
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = st.peek();
            }

            st.push(i);
        }

        return right;
    }


    
    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        long mod = 1000000007;

        int[] left = previousSmaller(arr);
        int[] right = nextSmaller(arr);

        long ans = 0;

        for (int i = 0; i < n; i++) {

            long leftChoices = i - left[i];
            long rightChoices = right[i] - i;

            long contribution =
                    (arr[i] * leftChoices % mod) * rightChoices % mod;

            ans = (ans + contribution) % mod;
        }

        return (int) ans;
    }
}