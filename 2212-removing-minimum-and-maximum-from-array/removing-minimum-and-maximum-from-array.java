class Solution {
    public int minimumDeletions(int[] nums) {
        // HashMap<Integer, Integer> hm = new HashMap<>();
        int maxI =0, minI=0, maxV = Integer.MIN_VALUE, minV = Integer.MAX_VALUE;
        int n= nums.length;
        for(int i=0; i<n; i++){
            if(nums[i]>maxV){
                maxV = nums[i];
                maxI = i;
            }
            if(nums[i]<minV){
                minV = nums[i];
                minI = i;
            }
        }
        int ahead = Math.max(maxI, minI);
        int before = Math.min(maxI, minI);
        int total = 0;
            if(before+1<=n-ahead){
                total += before+1;
                if(ahead-before<=n-ahead){
                    total += ahead-before;
                }else{
                    total += n-ahead;
                }
            }else{
                total += n-ahead;
                if(ahead-before<=before+1){
                    total += ahead-before;
                }else{
                    total += before+1;
                }
            }
        return total;
         
    }
}