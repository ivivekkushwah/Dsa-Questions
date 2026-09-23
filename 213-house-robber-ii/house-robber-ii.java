class Solution {

    public int rob(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        // Exclude first house: 1 -> n-1
        int l = fun( 1, nums, nums.length - 1);

        // Exclude last house: 0 -> n-2
        int r = fun( 0, nums, nums.length - 2);

        return Math.max(l, r);
    }
    public int fun(int start, int nums[], int end){
        int[] dp = new int[end + 3];
        
        for(int i=end; i>=start; i--){
            int include = nums[i] + dp[i+2];
            int exclude = dp[i+1];
            dp[i] = Math.max(include, exclude);
        }
        return dp[start];
    }
}