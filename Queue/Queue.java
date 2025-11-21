package Queue;

public class Queue {
    int front = -1, rear = -1;
    int[] array;

    Queue(int size){
        this.array = new int[size];
    }

    public boolean isFull(){
        return rear == array.length-1;
    }

    public boolean isEmpty(){
        return front == -1 && rear == -1;
    }

    public void enqueue(int ele) {
        if(isFull()){
            System.out.println("QUEUE IS FULL");
            return;
        }
        this.array[++rear] = ele;
        if(front==-1) front = 0;
        printArray();
    }

    public int dequeue() {
        if(isEmpty()){
            System.out.println("QUEUE IS EMPTY");
            return Integer.MIN_VALUE;
        }

        int ele = this.array[front++];
        if(front > rear) front = rear = -1;
        printArray();
        return ele;
    }

    // Gives the front element
    public int peek(){
        if(isEmpty()){
            System.out.println("QUEUE IS EMPTY");
            return Integer.MIN_VALUE;
        }
        return this.array[front];
    }

    private void printArray(){
        if(front == -1 && rear == -1) {
            System.out.println("QUEUE IS EMPTY");
            return;
        }
        for (int i=front; i<=rear; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
