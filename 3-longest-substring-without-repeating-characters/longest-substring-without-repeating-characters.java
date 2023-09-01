class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int end = 0; end < s.length(); end++) {
            if(map.containsKey(s.charAt(end))) {
                int lastIndex = map.get(s.charAt(end));
                start = lastIndex < start ? start : lastIndex + 1;
                map.put(s.charAt(end), end);
            } else {
                map.put(s.charAt(end), end);
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}