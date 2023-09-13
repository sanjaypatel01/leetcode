class Solution {
    public int minDeletions(String s) {
        int []arr = new int[26];
        Set<Integer> usedFreg = new HashSet<>();
        for(char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        int res = 0;
        for(int i=0; i < 26; i++) {
            while(arr[i] > 0 && !usedFreg.add(arr[i])) {
                arr[i]--;
                res++;
            }
        }
        return res;
    }
}