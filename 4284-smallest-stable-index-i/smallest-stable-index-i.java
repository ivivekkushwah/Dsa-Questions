class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int suffix[] = new int[n];
        int min = Integer.MAX_VALUE;
        for(int i=n-1; i>=0; i--){
            min = Math.min(min, nums[i]);
            suffix[i] = Math.min(min, nums[i]);
        }
        int index = -1;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            max = Math.max(nums[i], max);
            int stability = max-suffix[i];
            if(stability<=k){
                index = i;
                break;
            }
        }
        return index;
    }
}