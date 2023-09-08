class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ansList = new ArrayList<>();
        for(int i=0; i < numRows; i++) {
            List<Integer> rowList = new ArrayList<>();
            rowList.add(1);
            for(int j=1; j < i; j++) {
                rowList.add(ansList.get(i-1).get(j-1) + ansList.get(i-1).get(j));
            }
            if(i > 0) rowList.add(1);
            ansList.add(rowList);
        }
        return ansList;
    }
}