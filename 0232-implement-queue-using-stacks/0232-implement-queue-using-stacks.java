class MyQueue {
    Deque<Integer> front;
    Deque<Integer> back;
    public MyQueue() {
        this.front = new ArrayDeque<>();
        this.back = new ArrayDeque<>();
    }
    
    public void push(int x) {
        front.push(x);
    }
    
    public int pop() {
        if(back.isEmpty()){
            while(!front.isEmpty()){
                back.push(front.pop());
            }
        }
        
        return back.pop();
    }
    
    public int peek() {
        if(back.isEmpty()){
            while(!front.isEmpty()){
               back.push(front.pop());
            }
        }
        return back.peekFirst();
    }
    
    public boolean empty() {
        return front.isEmpty() && back.isEmpty();
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