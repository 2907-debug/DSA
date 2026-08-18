class StockSpanner {

    Stack<int[]> st = new Stack<>();
    int index = 0;

    public int next(int price) {

        while (!st.isEmpty() && st.peek()[0] <= price) {
            st.pop();
        }

        int prevGreaterIndex = -1;

        if (!st.isEmpty()) {
            prevGreaterIndex = st.peek()[1];
        }

        int span = index - prevGreaterIndex;

        st.push(new int[]{price, index});

        index++;

        return span;
    }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */