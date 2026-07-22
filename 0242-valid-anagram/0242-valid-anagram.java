class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            // s ka count increase
            map.put(ch1, map.getOrDefault(ch1, 0) + 1);

            // t ka count decrease
            map.put(ch2, map.getOrDefault(ch2, 0) - 1);
        }

        // Sab counts 0 hone chahiye
        for (int value : map.values()) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }
}