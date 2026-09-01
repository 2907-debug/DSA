class Solution {

    class Pair {
        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String reorganizeString(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.freq - a.freq
        );

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }

        String result = "";
        Pair prev = null;

        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            if (prev == null || current.ch != prev.ch) {

                result += current.ch;
                current.freq--;

                if (prev != null && prev.freq > 0) {
                    pq.add(prev);
                }

                prev = current;

            } else {

                if (pq.isEmpty()) {
                    return "";
                }

                Pair next = pq.poll();

                result += next.ch;
                next.freq--;

                if (current.freq > 0) {
                    pq.add(current);
                }

                prev = next;
            }
        }

        if (result.length() != s.length()) {
            return "";
        }

        return result;
    }
}