class Solution {
    public int totalFruit(int[] fruits) {

        int left = 0;
        int maxlength = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {

            // Add fruit
            map.put(fruits[right],
                    map.getOrDefault(fruits[right], 0) + 1);

            // More than 2 fruit types
            while (map.size() > 2) {

                // Remove one fruit from left
                map.put(fruits[left],
                        map.get(fruits[left]) - 1);

                // If frequency becomes 0, remove the fruit type
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }

                left++;
            }

            // Current valid window
            maxlength = Math.max(maxlength, right - left + 1);
        }

        return maxlength;
    }
}