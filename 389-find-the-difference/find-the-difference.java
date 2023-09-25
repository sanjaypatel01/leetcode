class Solution {
    /*public char findTheDifference(String s, String t) {
        int arr[] = new int [26];
        for(int i=0; i < t.length(); i++) {
            if(i < s.length()) arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for(int i=0; i < 26; i++) {
            if(arr[i] != 0) return (char)('a' + i);
        }
        return '!';
    }*/

    public char findTheDifference(String s, String t) {
       char ans = 0; 
        for(int i=0; i < t.length(); i++) {
            if(i < s.length()) ans ^=s.charAt(i);
            ans ^=t.charAt(i);
        }
        return ans;
    }
}