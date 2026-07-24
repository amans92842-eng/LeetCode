class Solution {
    public int uniqueXorTriplets(int[] nums) {
        HashSet<Integer> ans = new HashSet<>();
        HashSet<Integer> pairXor = new HashSet<>();

        int n = nums.length;

        // XOR of all pairs (i <= j)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pairXor.add(nums[i] ^ nums[j]);
            }
        }

        // Pair XOR with every element
        for (int x : pairXor) {
            for (int num : nums) {
                ans.add(x ^ num);
            }
        }

        return ans.size();
    }
}
   