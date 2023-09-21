class Solution{
public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
        
    /**
    If the asteroid is with + sign, simply push onto stack since it can't collide, irrespective of whether the stack top is + (both same direction & hence can't collide) or stack top is - (since both in opposite direction & the stack top is present to left of the asteroid & also moving left, they can't collide)
    
    If the asteroid is with - sign, there can be couple of cases :
        1. if stack top is +ve & absolute value is lesser than the asteroid, then it has to be blown off, so pop it off.
        2. if the stack top is also -ve, simply push the asteroid, no question of collision since both move in left direction.
        3. if the absolute value of asteroid & stack top are same, both would be blown off, so effectively pop off from stack & do nothing with the current asteroid.
    */
    for(int asteroid: asteroids){
            if(asteroid > 0){
                stack.push(asteroid);
            }else{// asteroid is negative
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)){//see pt1
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek() < 0){//see pt 2
                    stack.push(asteroid);
                }else if(asteroid + stack.peek() == 0){//see pt 3
                    stack.pop(); //equal
                }
            }
        }
        int[] res = new int[stack.size()];  
        for(int i = res.length - 1; i >= 0; i--){
            res[i] = stack.pop();
        }
        return res;
    }
}