class Solution {
    HashMap<Integer, Integer> hm = new HashMap<>();
    public int fib(int n) {
        if(n<2)return n;
        if(hm.containsKey(n))return hm.get(n);
        int last = fib(n-1);
        int lastSecond = fib(n-2);
        int ans = last + lastSecond;
        hm.put(n, ans);
        return ans;
    }
}