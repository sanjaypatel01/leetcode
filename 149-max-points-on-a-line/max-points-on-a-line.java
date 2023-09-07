class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n <= 1) return n;
        int max = 1;
        Map<Double, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            int p1[]= points[i];
            map.clear();
            for(int j=0; j < n; j++) {
                int []p2 = points[j];
                if(p1 == p2) continue;
                double slope = 0.0;
                if(p1[0] == p2[0]) {
                    slope = Integer.MAX_VALUE;
                } else {
                    slope = (p1[1] - p2[1]) * 1.0 /(p1[0] - p2[0]);
                }
                map.put(slope, map.getOrDefault(slope, 0) + 1);                
            }
            int cMax = Collections.max(map.values());
            max = Math.max(max, cMax + 1);
        }
        return max;
    }
}