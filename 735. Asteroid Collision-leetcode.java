class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int asteroid : asteroids){
            boolean asteroidsurvives = true;
            //collision happend when left moving asteroid is bigger than right moving
            while(!stack.isEmpty() && asteroid<0 && stack.peek()>0){
                int top = stack.peek();
                if(Math.abs(asteroid)>top){
                    stack.pop(); // Top asteroid explodes; check further collisions
                }else if(Math.abs(asteroid)==top){
                    stack.pop(); // Both explode
                    asteroidsurvives = false;
                    break;
                }else{
                    asteroidsurvives = false; //current explodes (3 > Math.abs(-2))
                    break;
                }
            }
            if(asteroidsurvives){ //no collision
                stack.push(asteroid);
            }
        }
        int[] result = new int[stack.size()];
        for(int i=result.length-1;i>=0;i--){
            result[i] = stack.pop();
        }
        return result;
    }
}
