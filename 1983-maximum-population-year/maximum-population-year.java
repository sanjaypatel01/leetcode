class Solution {
    public int maximumPopulation(int[][] logs) {

        Map<Integer, Integer> map = new TreeMap<>();
        for(int []log : logs) {
            map.put(log[0], map.getOrDefault(log[0], 0) + 1);
            map.put(log[1], map.getOrDefault(log[1], 0) - 1);
        }
        int sum = 0;
        int max = 0;
        int year = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            sum = sum + entry.getValue();
            if(sum > max) {
                year = entry.getKey();
                max= sum;
            }
        }
        return year;
    }
}