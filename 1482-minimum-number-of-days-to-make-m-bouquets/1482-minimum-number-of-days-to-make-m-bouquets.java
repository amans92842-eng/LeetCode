class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
      
        long requiredFlowers = (long) m * k;

        // Impossible to make m bouquets
        if (requiredFlowers > bloomDay.length) {
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Find minimum and maximum bloom day
        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                high = mid - 1;   // Try earlier day
            } else {
                low = mid + 1;    // Need more days
            }
        }

        return low;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int flowers = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                flowers++;

                if (flowers == k) {
                    bouquets++;
                    flowers = 0;

                    if (bouquets >= m) {
                        return true;
                    }
                }
            } else {
                flowers = 0;
            }
        }

        return false;
    }
}
     