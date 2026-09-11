class Solution {
    public int totalNumbers(int[] digits) {
        int n=digits.length;
        Set<Integer> s = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j)continue;
                for(int k=0; k<n; k++){
                    if(j==k|| i==k || digits[k]%2==1)continue;
                    int f=digits[i]*100 + digits[j]*10 + digits[k];
                    if(f>99 && f<999){
                        s.add(f);
                    }
                }
            }
        }
        return s.size();
    }
}