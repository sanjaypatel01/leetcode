class StockSpanner {
    Stack<int []> stack;
    int index = -1;
   
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        if(stack.size() == 0) {
            stack.push(new int[]{price, ++index});
            return 1;
        }

        while(!stack.isEmpty() && stack.peek()[0] <= price) {
            stack.pop();
        }
        if(!stack.isEmpty()) {
            int ans = index - stack.peek()[1] + 1;
            stack.push(new int[]{price, ++index});
            return ans;
        } else {
            stack.push(new int[]{price, ++index});
            return index + 1;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */