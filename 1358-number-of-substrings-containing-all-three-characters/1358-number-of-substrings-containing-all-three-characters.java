class Solution {
    public int numberOfSubstrings(String s) {

        int left = 0;
        int ans = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {

            map.put(s.charAt(right),
                    map.getOrDefault(s.charAt(right), 0) + 1);

            while (map.size() == 3) {

                ans += s.length() - right;

                char ch = s.charAt(left);

                map.put(ch, map.get(ch) - 1);

                if (map.get(ch) == 0) {
                    map.remove(ch);
                }

                left++;
            }
        }

        return ans;
    }
}