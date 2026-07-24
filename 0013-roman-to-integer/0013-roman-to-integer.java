class Solution {
    public int romanToInt(String s) {

        int answer = 0;

        for (int i = 0; i < s.length(); i++) {

            int currentValue = getValue(s.charAt(i));

            if (i < s.length() - 1) {

                int nextValue = getValue(s.charAt(i + 1));

                if (currentValue < nextValue) {
                    answer = answer - currentValue;
                } else {
                    answer = answer + currentValue;
                }

            } else {
                // Last character ko directly add karenge
                answer = answer + currentValue;
            }
        }

        return answer;
    }

    public int getValue(char ch) {

        if (ch == 'I') return 1;
        if (ch == 'V') return 5;
        if (ch == 'X') return 10;
        if (ch == 'L') return 50;
        if (ch == 'C') return 100;
        if (ch == 'D') return 500;

        return 1000; // M
    }
}