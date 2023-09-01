class Solution {
    int max = 0;
    int mStart = -1;
    int mEnd = -1;
    public String longestPalindrome(String s) {
        if(s.length() <= 1) return s;
        int  n = s.length();
        for(int i=0; i < n; i++) {
            palindromeCheck(i, i, n, s);
            palindromeCheck(i, i+1, n, s);
        }
        StringBuilder sb = new StringBuilder();
        while(mStart <= mEnd ) {
            sb.append(s.charAt(mStart++));
        }
        return sb.toString();
    }

    private void palindromeCheck(int start1, int start2, int n, String s) {
        while(start1 >= 0 && start2 < n) {
            if(s.charAt(start1) == s.charAt(start2)) {
                if(start2 - start1 + 1 > max) {
                    max = start2 - start1 + 1;
                    mStart = start1;
                    mEnd = start2;
                }
            } else {
                break;
            }
            start1--;
            start2++;
        }
    }
}