class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int res[] = new int[temperatures.length];
        DequeInteger deque = new ArrayDeque();
        for(int i=0;itemperatures.length;i++){
            while(!deque.isEmpty()&&temperatures[i]>temperatures[deque.peek()]){
                res[deque.peek()] = i-deque.peek();
                deque.pop();
            }
            deque.push(i);
        }
        return res;
    }
}