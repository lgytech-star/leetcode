class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
       for(int i=0;i<tokens.length;i++){
            String token = tokens[i];
            if(token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                 switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num2 - num1);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num2 / num1);
                        break;
                    default:
                }
            }else{
                stack.push(Integer.parseInt(token));
            }
       }
       return stack.pop();
    }
}