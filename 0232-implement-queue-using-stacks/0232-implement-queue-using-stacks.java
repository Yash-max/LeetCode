class MyQueue {
    Stack<Integer> stackFirst;
    Stack<Integer> stackSecond;
    
    public MyQueue() {
        stackFirst = new Stack<>();
        stackSecond = new Stack<>();
    }
    
    public void push(int x) {
        stackFirst.push(x);
    }
    
    public int pop() {
        while(stackFirst.size() != 1) {
            stackSecond.push(stackFirst.pop());
        }
        int ans = stackFirst.pop();
        while(stackSecond.size() != 0) {
            stackFirst.push(stackSecond.pop());
        }
        return ans;
    }
    
    public int peek() {
        while(stackFirst.size() != 1) {
            stackSecond.push(stackFirst.pop());
        }
        int ans = stackFirst.peek();
        while(stackSecond.size() != 0) {
            stackFirst.push(stackSecond.pop());
        }
        return ans;
    }
    
    public boolean empty() {
        if(stackFirst.size() == 0) return true;
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */