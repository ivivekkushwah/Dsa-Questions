class Solution {
    public int climbStairs(int n) {
        return stairs(n, 0);
    }
    HashMap<Integer, Integer> hm = new HashMap<>();
    public int stairs(int n, int curr) {
        if (curr == n) return 1;
        if (curr > n) return 0;
        if(hm.containsKey(curr))return hm.get(curr);
        int startWith1 = stairs(n, curr + 1);
        int startWith2 = stairs(n, curr + 2);
        hm.put(curr, startWith1 + startWith2);
        return startWith1 + startWith2;
    }
}