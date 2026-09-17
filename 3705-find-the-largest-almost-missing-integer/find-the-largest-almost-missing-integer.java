class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        
        // Case 1: k = 1
        // Every element is its own subarray of size 1. An integer is almost missing
        // if it appears in exactly 1 subarray, which means it appears exactly once in nums.
        if (k == 1) {
            int maxVal = -1;
            int[] count = new int[51]; // Constraints: 0 <= nums[i] <= 50
            for (int x : nums) {
                count[x]++;
            }
            for (int i = 0; i <= 50; i++) {
                if (count[i] == 1) {
                    maxVal = i;
                }
            }
            return maxVal;
        }
        
        // Case 2: k = n
        // There is only 1 subarray of size n, which is the entire array.
        // Therefore, every element in nums appears in exactly one subarray.
        // The answer is simply the maximum element in nums.
        if (k == n) {
            int maxVal = -1;
            for (int x : nums) {
                maxVal = Math.max(maxVal, x);
            }
            return maxVal;
        }
        
        // Case 3: 1 < k < n
        // Any element that is NOT at the ends (nums[0] and nums[n-1]) will be part 
        // of multiple subarrays of size k. Thus, only nums[0] and nums[n-1] have a 
        // chance of appearing in exactly one subarray (specifically, the first and last subarrays).
        int candidate1 = nums[0];
        int candidate2 = nums[n - 1];
        
        boolean c1Unique = true;
        boolean c2Unique = true;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == candidate1 && i != 0) {
                c1Unique = false;
            }
            if (nums[i] == candidate2 && i != n - 1) {
                c2Unique = false;
            }
        }
        
        if (candidate1 == candidate2) {
            return c1Unique ? candidate1 : -1;
        }
        
        int ans = -1;
        if (c1Unique) ans = Math.max(ans, candidate1);
        if (c2Unique) ans = Math.max(ans, candidate2);
        
        return ans;
    }
}