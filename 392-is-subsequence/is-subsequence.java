class Solution {
    public boolean isSubsequence(String s, String t) {
        
        if(s== null || s.length() == 0) return true;
        if(t == null || t.length() == 0) return false;
        if(s.length() > t.length()) return false;
        int j = 0;
        int matched = 0;
        for(int i=0;i < s.length(); i++) {
            while(j < t.length()) {
                if(s.charAt(i) == t.charAt(j)){
                    matched++;
                    j++;
                    break;
                } 
                j++;
            }
        }
        return matched == s.length(); 
    }
}