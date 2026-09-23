class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1)
            return 1;
        int dp[][] = new int[nums.length + 1][nums.length + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        // for(int i=nums.length; i>=0; i--){
        //     if(nums[i]<lv){
        //     int count1 = 1 + lis(idx+1, nums, nums[idx]);
        //     int count2 = lis(idx+1, nums, lv);
        //     dp Math.max(count1, count2);
        // }else{
        //     return lis(idx+1, nums, lv);
        // }
        // }
        return lis(dp, 0, nums, -1);
    }

    public int lis(int dp[][], int idx, int[] nums, int li) {

        if (idx == nums.length)
            return 0;
        if (li != -1 && dp[idx][li+1] != -1)
            return dp[idx][li + 1];
        if (li == -1 || nums[idx] > nums[li]) {
            int count1 = 1 + lis(dp, idx + 1, nums, idx);
            int count2 = lis(dp, idx + 1, nums, li);
            return dp[idx][li + 1] = Math.max(count1, count2);
        }
        return dp[idx][li + 1] = lis(dp, idx + 1, nums, li);

    }
}