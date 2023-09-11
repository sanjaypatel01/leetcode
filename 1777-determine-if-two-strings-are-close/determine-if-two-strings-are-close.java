class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        int []count1 = new int [26];
        int []count2 = new int [26];
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for(int i=0; i < word1.length(); i++){
            count1[word1.charAt(i) - 'a']++;
            count2[word2.charAt(i) - 'a']++;
            set1.add(word1.charAt(i));
            set2.add(word2.charAt(i));
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        for(int i=0; i < count1.length; i++){
            if(count1[i] != count2[i]) return false;
        }
        for(Character c : set1){
            if(!set2.contains(c)) return false;
        }
        return true;
    }
}