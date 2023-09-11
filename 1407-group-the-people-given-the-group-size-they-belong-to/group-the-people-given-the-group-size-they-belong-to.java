class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i < groupSizes.length; i++){
            List<Integer> list = map.get(groupSizes[i]);
            if(list == null){
                list = new ArrayList<>();
                map.put(groupSizes[i], list);
            } 
            list.add(i);
        }

        List<List<Integer>> ansList = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            int size = entry.getKey();
            List<Integer> currentList = entry.getValue();

            if(size == currentList.size()){
                ansList.add(currentList);
            } else {
                int from = 0;
                int to = size;
                while(to <= currentList.size()) {
                    //System.out.println("from: "+from +" ,to: "+to + " Size: "+ currentList.size());
                    ansList.add(currentList.subList(from, to));
                    from = to;
                    to = to + size;
                }
            }
        }

        return ansList;
    }
}