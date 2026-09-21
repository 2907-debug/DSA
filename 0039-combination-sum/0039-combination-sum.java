class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        fun(candidates, 0, new ArrayList<>(), 0, target, ans);

        return ans;
    }

    void fun(int[] a, int idx, List<Integer> diary, int sum,
             int target, List<List<Integer>> ans) {

        int n = a.length;

        if (sum == target) {
            ans.add(new ArrayList<>(diary));
            return;
        }

        if (sum > target) {
            return;
        }

        if (idx == n) {
            return;
        }

        
        fun(a, idx + 1, diary, sum, target, ans);

        
        diary.add(a[idx]);
        sum += a[idx];

        fun(a, idx, diary, sum, target, ans);

        diary.remove(diary.size() - 1);
        sum -= a[idx];
    }
}
