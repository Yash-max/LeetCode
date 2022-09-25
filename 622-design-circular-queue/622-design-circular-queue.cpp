class MyCircularQueue {
public:
    vector<int> v;
    int n;
    int start;
    int rear;
    MyCircularQueue(int k) {
        vector<int> x(k);
        v = x;
        n = k;
        start = -1;
        rear   = -1;
    }
    
    bool enQueue(int value) {
        if(isFull()) {
            return false;
        }
        if(rear == -1) {
            start = 0;   
        }
        rear = (rear+1) % n;
        v[rear] = value;
        return true;
    }
    bool deQueue() {
        if(isEmpty()) {
            return false;
        }
        if(start == rear) {
            start = rear = -1;
        } else {
            start = (start+1) % n;
        }
        return true;
    }
    
    int Front() {
        if(start == -1) {
            return -1;
        }
        return v[start];
    }
    
    int Rear() {
        if(rear == -1) {
            return -1;
        }
        return v[rear];
    }
    
    bool isEmpty() {
        if(start == -1) {
            return true;
        }
        return false;
    }
    
    bool isFull() {
        if(start != -1 && (rear+1) % n == start) {
            return true;
        }
        return false;
    }
};

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue* obj = new MyCircularQueue(k);
 * bool param_1 = obj->enQueue(value);
 * bool param_2 = obj->deQueue();
 * int param_3 = obj->Front();
 * int param_4 = obj->Rear();
 * bool param_5 = obj->isEmpty();
 * bool param_6 = obj->isFull();
 */