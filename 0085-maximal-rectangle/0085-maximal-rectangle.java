import java.util.Stack;

class Solution {

    public int maximalRectangle(char[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];

        int maxArea = 0;

        for (int i = 0; i < rows; i++) {

            // Current row se histogram heights update karo
            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            int area = largestRectangleArea(heights);

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }


    
    public int largestRectangleArea(int[] heights) {

        int[] pse = PSE(heights);
        int[] nse = NSE(heights);

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {

           
            int width = nse[i] - pse[i] - 1;

         
            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }


    
    public int[] PSE(int[] heights) {

        int n = heights.length;
        int[] pse = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            
            while (!st.isEmpty() &&
                   heights[st.peek()] >= heights[i]) {

                st.pop();
            }

            if (st.isEmpty()) {
                pse[i] = -1;
            } 
            else {
                pse[i] = st.peek();
            }

            st.push(i);
        }

        return pse;
    }


    // Next Smaller Element
    public int[] NSE(int[] heights) {

        int n = heights.length;
        int[] nse = new int[n];

        Stack<Integer> st = new Stack<>();

        // Right se left traverse
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() &&
                   heights[st.peek()] >= heights[i]) {

                st.pop();
            }

            if (st.isEmpty()) {
                nse[i] = n;
            } 
            else {
                nse[i] = st.peek();
            }

            st.push(i);
        }

        return nse;
    }
}