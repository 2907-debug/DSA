class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();

        for (int row = 1; row <= numRows; row++) {

            List<Integer> temp = new ArrayList<>();

            int element = 1;
            temp.add(element);

            for (int col = 1; col < row; col++) {

                element = element * (row - col);
                element = element / col;

                temp.add(element);
            }

            ans.add(temp);
        }

        return ans;
    }
}