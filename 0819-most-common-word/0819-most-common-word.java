
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();

        String[] words = paragraph.toLowerCase().split("[!?',;. ]+");

        for (String word : words) {
            if (!set.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        String ans = "";
        int max = 0;

        for (String word : map.keySet()) {
            if (map.get(word) > max) {
                max = map.get(word);
                ans = word;
            }
        }

        return ans;
    }
}
