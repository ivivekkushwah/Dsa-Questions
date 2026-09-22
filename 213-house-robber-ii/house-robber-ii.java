class Solution {

    public int rob(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        int[] dp1 = new int[nums.length + 1];
        int[] dp2 = new int[nums.length + 1];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        // Exclude first house: 1 -> n-1
        int l = fun(dp1, 1, nums, nums.length - 1);

        // Exclude last house: 0 -> n-2
        int r = fun(dp2, 0, nums, nums.length - 2);

        return Math.max(l, r);
    }

    public int fun(int[] dp, int idx, int[] nums, int end) {

        if (idx > end)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int loot = nums[idx] + fun(dp, idx + 2, nums, end);

        int noLoot = fun(dp, idx + 1, nums, end);

        return dp[idx] = Math.max(loot, noLoot);
    }
}