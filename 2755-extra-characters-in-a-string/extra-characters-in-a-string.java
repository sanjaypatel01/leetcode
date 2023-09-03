class Solution {

    public int minExtraChar(String s, String[] dictionary) {

        Set<String> dicSet = new HashSet<>();
        for(String word: dictionary) {
            dicSet.add(word);
        }
        int []dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return minExtra(0, s, dicSet, dp);
    }

    private int minExtra(int index, String s, Set<String> dicSet, int []dp){
        if(index >= s.length()) return 0;
        if(dp[index] != -1) return dp[index];
        String current ="";
        int min = s.length();
        for(int i=index; i < s.length(); i++) {
            current = current + s.charAt(i);
            int extraCount = current.length();
            if(dicSet.contains(current)) extraCount = 0;
            extraCount = extraCount + minExtra(i+1, s, dicSet, dp);
            min = Math.min(min, extraCount);
        }
        return dp[index] = min;
    }
}