class Solution {

    public int fib(int n) {
        if(n<2)return n;
        
        int prevP = 0;
        int prev = 1;
        for(int i=2; i<=n; i++){
            int curr = prev + prevP;
            prevP = prev;
            prev = curr;
        }
        
        return prev;
    }
}