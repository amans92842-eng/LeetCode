class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
         HashMap<Integer, Integer> map = new HashMap<>();

        
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

      
        ArrayList<Integer> freq = new ArrayList<>(map.values());

     
        Collections.sort(freq);

        int unique = freq.size();

       
        for (int f : freq) {
            if (k >= f) {
                k -= f;
                unique--;
            } else {
                break;
            }
        }

        return unique;
    }
}