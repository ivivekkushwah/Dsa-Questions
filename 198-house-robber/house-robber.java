class Solution {

    record Pair(int index, int flag) {}

    HashMap<Pair, Integer> hm = new HashMap<>();

    public int rob(int[] nums) {
        return dp(nums, 1, 0);
    }

    public int dp(int nums[], int free, int idx) {

        if (idx >= nums.length)
            return 0;

        Pair p = new Pair(idx, free);

        if (hm.containsKey(p))
            return hm.get(p);

        if (free == 1) {

            int notLoot = dp(nums, 1, idx + 1);
            int loot = nums[idx] + dp(nums, 0, idx + 1);

            hm.put(p, Math.max(notLoot, loot));

            return Math.max(notLoot, loot);

        } else {

            return dp(nums, 1, idx + 1);
        }
    }
}