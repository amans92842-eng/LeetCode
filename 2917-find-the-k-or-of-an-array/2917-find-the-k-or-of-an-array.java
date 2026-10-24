
class Solution {
    public int findKOr(int[] nums, int k) {
        int ans = 0;

        for (int bit = 0; bit < 31; bit++) {
            int count = 0;

            for (int num : nums) {
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }

            if (count >= k) {
                ans |= (1 << bit);
            }
        }

        return ans;
    }
}
