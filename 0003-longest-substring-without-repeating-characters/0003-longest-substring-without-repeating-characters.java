class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int maxLen = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {

            // Add current character
            map.put(s.charAt(right),
                    map.getOrDefault(s.charAt(right), 0) + 1);

            // Duplicate hai toh left se shrink karo
            while (map.get(s.charAt(right)) > 1) {

                map.put(s.charAt(left),
                        map.get(s.charAt(left)) - 1);

                left++;
            }

            // Current window valid hai
            int len = right - left + 1;

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}