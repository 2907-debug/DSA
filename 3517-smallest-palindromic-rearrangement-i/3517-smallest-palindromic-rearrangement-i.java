class Solution {

    public String smallestPalindrome(String s) {

        // frequency count
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        StringBuilder middle = new StringBuilder();

        // a se z tak jao
        for (int i = 0; i < 26; i++) {

            // half letters left me daalo
            for (int j = 0; j < freq[i] / 2; j++) {
                left.append((char) (i + 'a'));
            }

            // odd frequency wala middle me
            if (freq[i] % 2 == 1) {
                middle.append((char) (i + 'a'));
            }
        }

        // right = reverse(left)
        StringBuilder right = new StringBuilder(left).reverse();

        // final palindrome
        return left.toString() + middle.toString() + right.toString();
    }
}