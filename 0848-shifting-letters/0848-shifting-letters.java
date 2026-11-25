class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int len = shifts.length, i, next, prefSum = 0;
        char[] sc = s.toCharArray();
        for(i = len-1; i >= 0; i--) {
            prefSum = (prefSum+shifts[i])%26;
            next = sc[i]+prefSum;
            sc[i] = (char) (next > 122 ? next-26 : next);
        }
        return new String(sc);
    }
}