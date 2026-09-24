class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);

        int i = 0, j = sb.length() - 1;

        while (i < j) {

            if (isVowel(sb.charAt(i)) && isVowel(sb.charAt(j))) {
                char temp = sb.charAt(i);

                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, temp);

                i++;
                j--;

            } else if (isVowel(sb.charAt(i))) {
                j--;

            } else if (isVowel(sb.charAt(j))) {
                i++;

            } else {
                i++;
                j--;
            }
        }

        return sb.toString();
    }

    public boolean isVowel(char c) {
        c = Character.toLowerCase(c);

        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;

        return false;
    }
}