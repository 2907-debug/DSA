class Solution {
    public boolean rotateString(String s, String goal) {

        // Length same honi chahiye
        if (s.length() != goal.length()) {
            return false;
        }

        int n = s.length();

        // Maximum n rotations possible hain
        for (int i = 0; i < n; i++) {

            // First character ko end me bhej do
            s = s.substring(1) + s.charAt(0);

            // Goal se compare karo
            if (s.equals(goal)) {
                return true;
            }
        }

        // Kahin bhi match nahi hua
        return false;
    }
}