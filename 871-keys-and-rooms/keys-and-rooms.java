class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean visited[] = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while(!queue.isEmpty()) {
            int index = queue.poll();
            visited[index] = true;
            for(int key : rooms.get(index)){
                if(!visited[key]) {
                    queue.offer(key);
                }
            }
        }
        for(boolean isVisited : visited){
            if(!isVisited) return false;
        }
        
        return true;
    }
}