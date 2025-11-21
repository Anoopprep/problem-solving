package Queue;

class CircularQueue {
    int array[];
    int front = -1, rear = -1, size;
    CircularQueue(int size){
        this.size = size;
        this.array = new int[size];
    }

    boolean isFull(){
        return (rear+1) % size == front;
    }

    boolean isEmpty(){
        return (front == -1 && rear == -1);
    }

    void enqueue(int ele) {
        if(isFull()){
            System.out.println("QUEUE IS FULL");
            return;
        }

        rear = (rear + 1) % size;
        this.array[rear] = ele;
        if(front == -1) front = 0;
    }

    int dequeue(){
        if(isEmpty()){
            System.out.println("QUEUE IS EMPTY");
            return Integer.MIN_VALUE;
        }
        int ele = this.array[front];
        if(front == rear) {
            front = rear = -1;
        }
        else {
            front = (front + 1) % size;
        }
        return ele;
    }

    int peek() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return array[front];
    }
}
