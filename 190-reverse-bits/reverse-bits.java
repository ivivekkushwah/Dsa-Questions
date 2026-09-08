class Solution {
    public int reverseBits(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>0){
            int digit = n%2;
            char ch = (char) (digit + '0');
            sb.append(ch);
            n /= 2;
        }
        while(sb.length()<32){
            sb.append('0');
        }
        sb.reverse();
        int num = 0;
        int i=0;
        while(sb.length()>0){
            int digit = sb.charAt(0) - '0';
            num += Math.pow(2, i)*digit;
            sb.deleteCharAt(0);
            i++;
        }
        return num;
    }
}